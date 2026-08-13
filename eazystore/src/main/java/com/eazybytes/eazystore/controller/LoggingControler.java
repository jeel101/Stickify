package com.eazybytes.eazystore.controller;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("api/v1/logging")
@Slf4j
public class LoggingControler {
//    private static final Logger log = LoggerFactory.getLogger(LoggingControler.class);
    @GetMapping
    public ResponseEntity<String> testLogging() {
        log.trace("TRACE!");
        log.debug("DEBUG");
        log.info("info");
        log.warn("warn");
        log.error("error");
        return ResponseEntity.ok().body("Logging tested successfully");
    }
}
