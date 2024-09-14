package com.enduser.enduser.service;

import com.enduser.enduser.config.Appconstant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class kafka_service {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    private static final Logger logger = LoggerFactory.getLogger(kafka_service.class);

    public boolean updatelocations(String location) {
        kafkaTemplate.send(Appconstant.LOCATION_TOPIC_NAME, location);
        logger.info("Location message produced: {}", location);
        return true;
    }
}
