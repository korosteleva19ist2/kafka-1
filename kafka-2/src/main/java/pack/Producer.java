package pack;

//import org.slf4j.impl.StaticLoggerBinder;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.KafkaTemplate;
//import java.util.Hashtable<Object,Object>;


public class Producer {


   // private KafkaTemplate<String, Pet> kafkaTemplate;
    private KafkaTemplate<String, String> kafkaTemplate;
//   public Producer(KafkaTemplate<String, Pet> kafkaTemplate) {
//        this.kafkaTemplate = kafkaTemplate;
//    }
public Producer(KafkaTemplate<String, String> kafkaTemplate) {
    this.kafkaTemplate = kafkaTemplate;
}

//    public void sendOrder(Pet orderSendEvent) {
//            for (int i = 0; i < 3; i++)
//            {
//                kafkaTemplate.send("part1", Integer.toString(i), orderSendEvent.getName());
//            }
//        }
    public void sendOrder(String name) {
        for (int i = 0; i < 3; i++)
        {
            kafkaTemplate.send("part1", Integer.toString(i), name+Integer.toString(i));
        }
    }

//        try (var producer = new KafkaProducer<String, String>(props)) {
//            for (int i = 0; i < 3; i++)
//                producer.send(new ProducerRecord<String, String>("part1", Integer.toString(i), "a"+Integer.toString(i)));
//
//
//        }
    }
