package com.example.playground;

import com.example.playground.service.DiamondService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PlaygroundApplication {

    public static void main(String[] args) {
        DiamondService diamondService = new DiamondService(args[0]);
        diamondService.printDiamond();
    }
}
