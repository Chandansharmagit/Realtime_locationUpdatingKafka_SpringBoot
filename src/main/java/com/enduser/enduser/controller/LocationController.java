package com.enduser.enduser.controller;

import com.enduser.enduser.service.kafka_service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/location")
public class LocationController {
    @Autowired
    private kafka_service kafka_service;
    @PostMapping("/updates")
    public ResponseEntity<?> updateLocation(){
        this.kafka_service.updatelocations(" ( " + Math.random()*100+" ," + Math.random() * 100 + "+ " + ")");
        return new ResponseEntity<>(Map.of("message", "Location updated"), HttpStatus.OK);
    }
}
