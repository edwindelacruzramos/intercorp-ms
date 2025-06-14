package pe.intecorp.ms05;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class Ms05XmlProducerApplication {

	public static void main(String[] args) {
		SpringApplication.run(Ms05XmlProducerApplication.class, args);
	}

}
