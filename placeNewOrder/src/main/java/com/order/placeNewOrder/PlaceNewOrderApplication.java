package com.order.placeNewOrder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class PlaceNewOrderApplication {

	public static void main(String[] args) {
		SpringApplication.run(PlaceNewOrderApplication.class, args);
	}

}
