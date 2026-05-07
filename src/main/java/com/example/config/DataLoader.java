package com.example.config;

import com.example.entity.Mobile;
import com.example.repository.MobileRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

//@Component
@Configuration
public class DataLoader {
    @Bean
    public CommandLineRunner callMe(MobileRepository mobileRepository){
        return args ->{
            mobileRepository.save(Mobile.builder().brand("samsaung").model("a26").price(90000.0).stock(10).build());
            mobileRepository.save(Mobile.builder().brand("nokia").model("111").price(70000.0).stock(20).build());
            mobileRepository.save(Mobile.builder().brand("oppo").model("777").price(80000.0).stock(5).build());
            mobileRepository.save(Mobile.builder().brand("lenovo").model("888").price(50000.0).stock(4).build());
        } ;
    }
}
