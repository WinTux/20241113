package com.wintux.kfk;


import com.launchdarkly.eventsource.EventSource;
import com.launchdarkly.eventsource.background.BackgroundEventHandler;
import com.launchdarkly.eventsource.background.BackgroundEventSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.util.concurrent.TimeUnit;

@Service
public class CambiosWikimediaProducer {
    private static final Logger LOGGER = LoggerFactory.getLogger(CambiosWikimediaProducer.class);
    private KafkaTemplate<String,String> kafkaTemplate;

    public CambiosWikimediaProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }
    public void enviarMensaje() throws InterruptedException {
        String topic = "cambios_de_wikimedia";
        // Para leer los datos en tiempo real
        BackgroundEventHandler event = new CambiosWikimediaHandler(kafkaTemplate,topic);
        // Le pasamos la URL del servidor REST
        String url = "https://stream.wikimedia.org/v2/stream/recentchange";
        // Creando un event source al cual pasarle la URL
        BackgroundEventSource.Builder builder = new BackgroundEventSource.Builder(event, new EventSource.Builder(URI.create(url)));
        BackgroundEventSource eventSource = builder.build();
        eventSource.start();
        //Descansará dentro de 5 min
        TimeUnit.MINUTES.sleep(5);
    }
}
