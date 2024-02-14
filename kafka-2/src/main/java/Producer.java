import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
//import org.slf4j.impl.StaticLoggerBinder;
import org.springframework.kafka.core.KafkaTemplate;
//import java.util.Hashtable<Object,Object>;
import java.util.Properties;

public class Producer {


    private KafkaTemplate<String, Pet> kafkaTemplate;
    public Producer(KafkaTemplate<String, Pet> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendOrder(Pet orderSendEvent) {
            for (int i = 0; i < 3; i++)
                kafkaTemplate.send("part1", Integer.toString(i), orderSendEvent);
        }

//        try (var producer = new KafkaProducer<String, String>(props)) {
//            for (int i = 0; i < 3; i++)
//                producer.send(new ProducerRecord<String, String>("part1", Integer.toString(i), "a"+Integer.toString(i)));
//
//
//        }
    }
