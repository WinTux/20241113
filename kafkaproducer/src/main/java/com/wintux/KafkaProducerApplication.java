package com.wintux;

import com.wintux.kfk.CambiosWikimediaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class KafkaProducerApplication implements CommandLineRunner {
    @Autowired
    private CambiosWikimediaProducer cambios;
    public static void main(String[] args){
        SpringApplication.run(KafkaProducerApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        cambios.enviarMensaje();
    }
}
