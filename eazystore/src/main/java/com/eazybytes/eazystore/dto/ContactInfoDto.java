package com.eazybytes.eazystore.dto;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@ConfigurationProperties("contact")  //it looks in application.properties and checks for fields with prefix as contact
public record ContactInfoDto(String phone, String email, String address) {

}
