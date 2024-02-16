package pack;

//import org.slf4j.impl.StaticLoggerBinder;
//import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.KafkaTemplate;

import java.util.concurrent.atomic.AtomicInteger;
//import java.util.Hashtable<Object,Object>;


public class Producer {

    private static final AtomicInteger newID= new AtomicInteger(1);

    private KafkaTemplate<String, String> kafkaTemplate;

public Producer(KafkaTemplate<String, String> kafkaTemplate) {
    this.kafkaTemplate = kafkaTemplate;
}

//    public void sendOrder(Pet orderSendEvent) {
//            for (int i = 0; i < 3; i++)
//            {
//                kafkaTemplate.send("part1", Integer.toString(i), orderSendEvent.getName());
//            }
//        }
    public void sendPet(String name) {
//        for (int i = 0; i < 3; i++)
//        {
            kafkaTemplate.send("part1", Integer.toString(newID.get()), name);
        //}
    }

//        try (var producer = new KafkaProducer<String, String>(props)) {
//            for (int i = 0; i < 3; i++)
//                producer.send(new ProducerRecord<String, String>("part1", Integer.toString(i), "a"+Integer.toString(i)));
//
//
//        }
    }
