package pack;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.ProducerFactory;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaConsumerConfig {
    @Bean
    public ProducerFactory<String, String> producerFactory() {
        Map<String, Object> configProps = new HashMap<>();
        configProps.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "https://aware-marten-11494-us1-kafka.upstash.io:9092");
        configProps.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,"org.apache.kafka.common.serialization.StringSerializer");
        configProps.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringSerializer");
        configProps.put("auto.offset.reset", "earliest");
        configProps.put("group.id", "consum-2");
        configProps.put("sasl.mechanism", "SCRAM-SHA-256");
        configProps.put("security.protocol", "SASL_SSL");
        configProps.put("sasl.jaas.config", "org.apache.kafka.common.security.scram.ScramLoginModule required " +
                "username=\"YXdhcmUtbWFydGVuLTExNDk0JOIFNrtWhh89hK87DAiqaCUtIiq0ETsx4EIyeyw\" " +
                "password=\"MmI5MDU3ZTMtNDY4NS00Zjg1LWExZGMtNTQ5MmNlNmRjMWRk\";");
        return new DefaultKafkaProducerFactory<>(configProps);
    }

}
