package com.skillstorm.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "restaurant-service")
public interface RestaurantClient {
	
	@PostMapping("/restaurant/food")
	public String getAssociatedRestaurant(Integer foodId);

}
