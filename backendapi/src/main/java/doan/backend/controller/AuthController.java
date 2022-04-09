package doan.backend.controller;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import doan.backend.dto.AccountInformationDTO;
import doan.backend.dto.LoginDTO;
import doan.backend.dto.SignupDTO;
import doan.backend.entity.Account;
import doan.backend.entity.Role;
import doan.backend.exception.ResourceNotFoundException;
import doan.backend.repository.AccountRepository;
import doan.backend.repository.RoleRepository;
import doan.backend.service.CustomUserDetailsService;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
	/*
	@Autowired
	private UserDetails userDetails;
	*/
	@Autowired
	private CustomUserDetailsService customUserDetails;

	@Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@RequestBody LoginDTO loginDto)
    		throws ResourceNotFoundException {
    	Account acc = accountRepository.findByEmail(loginDto.getEmail())
  	          .orElseThrow(() -> new ResourceNotFoundException("Wrong email or password"));
    	
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                loginDto.getEmail(), loginDto.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        
        AccountInformationDTO info = new AccountInformationDTO();
        info.setAccountId(acc.getAccountId());
        info.setEmail(customUserDetails.loadUserByUsername(loginDto.getEmail()).getUsername());
        info.setAddress(acc.getAddress());
        info.setName(acc.getName());
        info.setPassword(customUserDetails.loadUserByUsername(loginDto.getEmail()).getPassword());
        info.setPhone(acc.getPhone());
        info.setRoles(customUserDetails.loadUserByUsername(loginDto.getEmail()).getAuthorities());
        
        //String phone = userDetails.get
        //return new ResponseEntity<>("User signed-in successfully!.",  HttpStatus.OK);
        return ResponseEntity.ok().body(info);
        /*
        String jwt = jwtUtils.generateJwtToken(authentication);

		AccountDetailsImpl userDetails = (AccountDetailsImpl) authentication.getPrincipal();
		List<String> roles = userDetails.getAuthorities().stream().map(item -> item.getAuthority())
				.collect(Collectors.toList());

		return ResponseEntity.ok(new JwtResponse(jwt, userDetails.getId(), userDetails.getNameAcc(),
				userDetails.getUsername(), userDetails.getEmail(), userDetails.getPhone(), roles));*/
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerCustomer(@RequestBody SignupDTO signUpDto){

        // add check for email exists in DB
        if(accountRepository.existsByEmail(signUpDto.getEmail())){
            return new ResponseEntity<>("Email is already taken!", HttpStatus.BAD_REQUEST);
        }

        // create user object
        Account acc = new Account();
        acc.setName(signUpDto.getName());
        acc.setEmail(signUpDto.getEmail());
        acc.setPassword(passwordEncoder.encode(signUpDto.getPassword()));
        acc.setAddress(signUpDto.getAddress());
        acc.setPhone(signUpDto.getPhone());

        Role roles = roleRepository.findByRoleName("ROLE_CUSTOMER").get();
        acc.setRoles(Collections.singleton(roles));

        accountRepository.save(acc);

        return new ResponseEntity<>("Customer registered successfully", HttpStatus.OK);
    }
    
    @PostMapping("/signupstaff")
    public ResponseEntity<?> registerStaff(@RequestBody SignupDTO signUpDto){

        // add check for email exists in DB
        if(accountRepository.existsByEmail(signUpDto.getEmail())){
            return new ResponseEntity<>("Email is already taken!", HttpStatus.BAD_REQUEST);
        }

        // create user object
        Account acc = new Account();
        acc.setName(signUpDto.getName());
        acc.setEmail(signUpDto.getEmail());
        acc.setPassword(passwordEncoder.encode(signUpDto.getPassword()));
        acc.setAddress(signUpDto.getAddress());
        acc.setPhone(signUpDto.getPhone());

        Role roles = roleRepository.findByRoleName("ROLE_STAFF").get();
        acc.setRoles(Collections.singleton(roles));

        accountRepository.save(acc);

        return new ResponseEntity<>("Staff registered successfully", HttpStatus.OK);
    }
}
