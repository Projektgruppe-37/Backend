package demo;

import demo.model.ConfigUa;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class DemoApplication extends ConfigUa {


	public static void main(String[] args) {
		configUa();
		SpringApplication.run(DemoApplication.class, args);
	}

}
