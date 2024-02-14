package pack;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

public class Consumer {
    private final JpaRepository<Pet, Long> ordersRepository;

    public Consumer(JpaRepository<Pet, Long> ordersRepository) {
        this.ordersRepository = ordersRepository;
    }

    @Transactional
    @KafkaListener(topics = "part1", groupId = "consum-2")
    public void createOrder(OrderEvent orderEvent) {
        //log.info("Message consumed {}", orderEvent);
        orderService.save(modelMapper.map(orderEvent, OrderDto.class));
    }
}
