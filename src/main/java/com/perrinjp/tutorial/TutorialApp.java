package com.perrinjp.tutorial;

import javax.annotation.security.RolesAllowed;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class TutorialApp {
    @RolesAllowed("*")
    public static void main(String[] args) {
        SpringApplication.run(TutorialApp.class, args);
    }

}
