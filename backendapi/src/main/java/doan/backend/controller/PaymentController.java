package doan.backend.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.security.Principal;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.TimeZone;

import javax.mail.MessagingException;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import doan.backend.config.PaymentConfig;
import doan.backend.dto.PaymentDTO;
import doan.backend.repository.AccountRepository;
import doan.backend.response.PaymentResponse;
import doan.backend.response.TransactionResponse;
import doan.backend.utils.DataUtils;
@RestController
@CrossOrigin(origins = "*")
public class PaymentController {
    /*@Autowired
    private MapValidationErrorService mapValidationErrorService;

    @Autowired
    private AccountService accountService;
    */
    @Autowired
    private AccountRepository accountRepository;
/*
    @Autowired
    private PaymentService paymentService;

    @Autowired
    private GetCurrentDate currentDate;
*/
    private String username = "";

    private List serviceId = new ArrayList();

    @PostMapping("create-payment")
    public ResponseEntity<?> createPayment(@Valid @RequestBody PaymentDTO requestParams) throws UnsupportedEncodingException, IOException {
        /*if (principal == null)
            throw new LoginRequiredException("you need to login to get access");*/
        /*
        //check role
        int role = accountService.getRole(principal.getName());
        if (role != 3) {
            throw new AccountNotHaveAccessException(NO_PERMISSION);
        }

        ResponseEntity<?> errorMap = mapValidationErrorService.MapValidationService(bindingResult);
        if (errorMap != null) return errorMap;

            Customer customer = accountService.findByUserName(principal.getName()).getCustomer();
            username = principal.getName();
            String suffix_txn ="";
            for (SinglePost sp : requestParams.getSinglePosts()){
                suffix_txn += "&"+sp.getId();
                serviceId.add(sp.getId());
            }
	*/
            //check ammount ben fe
        	float total = requestParams.getTotalPrice() * 23000;
            int amount = (int) total * 100;
            Map<String, String> vnp_Params = new HashMap<>();
            vnp_Params.put("vnp_Version", PaymentConfig.VERSION);
            vnp_Params.put("vnp_Command", PaymentConfig.COMMAND);
            vnp_Params.put("vnp_TmnCode", PaymentConfig.TMNCODE);
            vnp_Params.put("vnp_Amount", String.valueOf(amount));
            vnp_Params.put("vnp_CurrCode", PaymentConfig.CURRCODE);
            String bank_code = requestParams.getBankCode();
            if (bank_code != null && !bank_code.isEmpty()) {
                vnp_Params.put("vnp_BankCode", bank_code);
            }

            int leftLimit = 97; // letter 'a'
            int rightLimit = 122; // letter 'z'
            int targetStringLength = 3;
            Random random = new Random();

            String generatedString = random.ints(leftLimit, rightLimit + 1)
              .limit(targetStringLength)
              .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
              .toString();

            System.out.println(generatedString);
            
            vnp_Params.put("vnp_TxnRef", "VNP" + generatedString); //Ma giao dich
            vnp_Params.put("vnp_OrderInfo", requestParams.getContent()); //Noi dung thanh toan
            vnp_Params.put("vnp_OrderType", PaymentConfig.ORDERTYPE);
            vnp_Params.put("vnp_Locale", PaymentConfig.LOCALEDEFAULT);
            vnp_Params.put("vnp_ReturnUrl", PaymentConfig.RETURNURL);
            vnp_Params.put("vnp_IpAddr", PaymentConfig.IPADDR);
            Calendar cld = Calendar.getInstance(TimeZone.getTimeZone("Etc/GMT+7"));

            SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
            String vnp_CreateDate = formatter.format(cld.getTime());

            vnp_Params.put("vnp_CreateDate", vnp_CreateDate);
            cld.add(Calendar.MINUTE, 15);
            String vnp_ExpireDate = formatter.format(cld.getTime());
            //Add Params of 2.1.0 Version
            vnp_Params.put("vnp_ExpireDate", vnp_ExpireDate);

            //Build data to hash and querystring
            List fieldNames = new ArrayList(vnp_Params.keySet());
            Collections.sort(fieldNames);
            StringBuilder hashData = new StringBuilder();
            StringBuilder query = new StringBuilder();
            Iterator itr = fieldNames.iterator();
            while (itr.hasNext()) {
                String fieldName = (String) itr.next();
                String fieldValue = (String) vnp_Params.get(fieldName);
                if ((fieldValue != null) && (fieldValue.length() > 0)) {
                    //Build hash data
                    hashData.append(fieldName);
                    hashData.append('=');
                    hashData.append(URLEncoder.encode(fieldValue, StandardCharsets.US_ASCII.toString()));
                    //Build query
                    query.append(URLEncoder.encode(fieldName, StandardCharsets.US_ASCII.toString()));
                    query.append('=');
                    query.append(URLEncoder.encode(fieldValue, StandardCharsets.US_ASCII.toString()));
                    if (itr.hasNext()) {
                        query.append('&');
                        hashData.append('&');
                    }
                }
            }
            String queryUrl = query.toString();
            String vnp_SecureHash = DataUtils.hmacSHA512(PaymentConfig.CHECKSUM, hashData.toString());
            queryUrl += "&vnp_SecureHash=" + vnp_SecureHash;
            String paymentUrl = PaymentConfig.VNPURL + "?" + queryUrl;
            PaymentResponse paymentResponse = new PaymentResponse();
            paymentResponse.setStatus("00");
            paymentResponse.setMessage("success");
            paymentResponse.setUrl(paymentUrl);
//            com.google.gson.JsonObject job = new JsonObject();
//            job.addProperty("code", "00");
//            job.addProperty("message", "success");
//            job.addProperty("data", paymentUrl);
//            Gson gson = new Gson();
//            paymentResponse.getWriter().write(gson.toJson(job));
        return ResponseEntity.status(HttpStatus.OK).body(paymentResponse);
    }

    @GetMapping("/payment-result")
    public ResponseEntity<?> transactionHandle(
            @RequestParam(value = "vnp_Amount", required = false) String amount,
            @RequestParam(value = "vnp_TxnRef", required = false) String txnRef,
            @RequestParam(value = "vnp_BankCode", required = false) String bankCode,
            @RequestParam(value = "vnp_BankTranNo", required = false) String bankTransNo,
            @RequestParam(value = "vnp_CardType", required = false) String cardType,
            @RequestParam(value = "vnp_OrderInfo", required = false) String orderInfo,
            @RequestParam(value = "vnp_ResponseCode", required = false) String responseCode,
            @RequestParam(value = "vnp_TmnCode", required = false) String tmnCode,
            @RequestParam(value = "vnp_TransactionNo", required = false) String transNo,
            @RequestParam(value = "vnp_TransactionStatus", required = false) String transStatus,
            @RequestParam(value = "vnp_SecureHash", required = false) String secureHash
            )throws MessagingException {

        PaymentResponse paymentResponse = new PaymentResponse();
        if(!responseCode.equalsIgnoreCase("00")){
            paymentResponse.setStatus("99");
            paymentResponse.setMessage("failed");
            return ResponseEntity.status(HttpStatus.OK).body(paymentResponse);
        }
/*
        paymentService.save(amount, txnRef, bankCode, bankTransNo, cardType, orderInfo,
                responseCode, tmnCode, transNo, transStatus, secureHash, username, serviceId);
*/
        paymentResponse.setStatus("00");
        paymentResponse.setMessage("success");

        TransactionResponse transactionResponse = new TransactionResponse();
        transactionResponse.setTransactionTime(LocalDateTime.now());
        transactionResponse.setAmount(Integer.parseInt(amount));
        transactionResponse.setBankCode(bankCode);
        transactionResponse.setMessage("Payment has been completed successfully");
        transactionResponse.setTransactionNumber(transNo);
        transactionResponse.setTransactionInfo(orderInfo);

        return ResponseEntity.status(HttpStatus.OK).body(transactionResponse);
    }

/*
    @GetMapping("/receipt")
    public ResponseEntity<Collection<PaymentHistoryResponse>> getAllReceipt(Principal principal){
        //check login
        if (principal == null)
            throw new LoginRequiredException(LOGIN_REQUIRED);

        //check role
        int role = accountService.getRole(principal.getName());
        if (role != 3) {
            throw new AccountNotHaveAccessException(NO_PERMISSION);
        }
        return new ResponseEntity<>(paymentService.findAllReceipt(principal.getName()), HttpStatus.OK);
    }

    @GetMapping("/receipt/{id}")
    public ResponseEntity<ReceiptDetailResponse> getReceiptDetail(@PathVariable Long id, Principal principal){
        //check login
        if (principal == null)
            throw new LoginRequiredException(LOGIN_REQUIRED);

        //check role
        int role = accountService.getRole(principal.getName());
        if (role != 3) {
            throw new AccountNotHaveAccessException(NO_PERMISSION);
        }
        return new ResponseEntity<>( paymentService.getReceiptDetail(id, principal.getName()), HttpStatus.OK);
    }
    */
}