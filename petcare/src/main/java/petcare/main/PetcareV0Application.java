package petcare.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
@ComponentScan(basePackages = {"petcare.controller", "petcare.dao", "petcare.entities", "petcare.service"})
@EntityScan(basePackages = {"petcare.entities"})
@EnableJpaRepositories(basePackages = {"petcare.dao"})
@SpringBootApplication
public class PetcareV0Application {

	public static void main(String[] args) {
		SpringApplication.run(PetcareV0Application.class, args);
	}

}
