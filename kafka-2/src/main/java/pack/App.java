package pack;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.kafka.annotation.KafkaListener;
//import org.springframework.kafka.config.internalKafkaListenerEndpointRegistry;

@SpringBootApplication
public class App {

    public static void main(String[] args)
    {
        SpringApplication.run(App.class,args); //Указали, что исполняющий класс pack.App
    }
}
