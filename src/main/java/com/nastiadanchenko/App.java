package com.nastiadanchenko;

import com.nastiadanchenko.display.DisplayData;
import lombok.AllArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@AllArgsConstructor
@SpringBootApplication
public class App {
    public static void main(String[] args) {

        SpringApplication.run(App.class, args);
        System.setProperty("java.awt.headless", "false");
        new DisplayData();

    }
}
