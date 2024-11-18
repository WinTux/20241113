package com.wintux.consum;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaDDBBconsumer {
    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaDDBBconsumer.class);
    @KafkaListener(topics = "cambios_de_wikimedia",groupId = "miGrupo")
    public void consumir(String eventMessage){
        LOGGER.info(String.format("Mensaje recibido en KafkaDDBBconsumer: %s", eventMessage));
    }
}
