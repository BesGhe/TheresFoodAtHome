package ghebrat.bes.theresFoodAtHome;

import ghebrat.bes.theresFoodAtHome.item.ItemRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TheresFoodAtHomeApplication {

	private static final Logger logger = LoggerFactory.getLogger(TheresFoodAtHomeApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(TheresFoodAtHomeApplication.class, args);
	}



}