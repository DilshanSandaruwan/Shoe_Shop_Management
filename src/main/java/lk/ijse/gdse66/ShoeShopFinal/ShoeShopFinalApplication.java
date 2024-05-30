package lk.ijse.gdse66.ShoeShopFinal;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ShoeShopFinalApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShoeShopFinalApplication.class, args);
	}

	@Bean
	public ModelMapper modelMapper(){
		return new ModelMapper();
	}
}
