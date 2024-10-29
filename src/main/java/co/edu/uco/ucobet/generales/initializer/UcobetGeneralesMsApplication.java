package co.edu.uco.ucobet.generales.initializer;

import com.azure.security.keyvault.secrets.SecretClient;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {"co.edu.uco.ucobet"})
@EntityScan(basePackages = {"co.edu.uco.ucobet.generales.application.secondaryports.entity" })
@EnableJpaRepositories(basePackages = {"co.edu.uco.ucobet"})

public class UcobetGeneralesMsApplication {
/*
	private final SecretClient secretClient;

	public UcobetGeneralesMsApplication(SecretClient secretClient) {
		this.secretClient = secretClient;
	}
*/
	public static void main(String[] args) {
		SpringApplication.run(UcobetGeneralesMsApplication.class, args);
	}

	@Bean
	public ServletWebServerFactory servletContainer() {

		return new TomcatServletWebServerFactory();

	}

}