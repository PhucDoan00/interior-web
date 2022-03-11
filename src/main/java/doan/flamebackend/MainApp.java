package doan.flamebackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableJpaRepositories(basePackages = {"mz.server.spring.repository"})
@EnableGlobalMethodSecurity(prePostEnabled = true, proxyTargetClass = true) // <--
@EntityScan(basePackages = "mz.server.hibernate.model")
@EnableTransactionManagement
@EnableScheduling
public class MainApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SpringApplication.run(MainApp.class, args);
	}

}
