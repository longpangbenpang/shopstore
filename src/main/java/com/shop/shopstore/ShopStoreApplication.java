package com.shop.shopstore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class ShopStoreApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShopStoreApplication.class, args);
    }

}
