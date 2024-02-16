package pack;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import org.springframework.context.ApplicationContext;
import java.util.Arrays;

@Service
public class Consumer {
    private final Redis redis;

    public Consumer(Redis redis) {
        this.redis = redis;
    }

    @KafkaListener(topics = "part1",groupId = "consum-2",containerFactory = "kafkaListenerContainerFactory")
    public String listen(ConsumerRecord<String,String> record) {
        String val=record.value();
        String[]  action= val.split("питомца");
        String[]  name= val.split("имя");
        String line=action[0]+name[1];
        System.out.println(line);
        redis.publish(line);
       // redis.add(line);
        return val;

    }


}