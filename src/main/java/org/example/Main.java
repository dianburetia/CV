package org.example;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main {
   // private static final String QUEUE_NAME = "numbers_queue";

    public static void main(String[] args) throws InterruptedException {
        SpringApplication.run(Main.class, args);

    }
}