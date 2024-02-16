package pack;
import jakarta.annotation.Resource;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.Map;
import java.util.HashMap;
import redis.clients.jedis.DefaultJedisClientConfig;
import org.springframework.data.redis.core.StringRedisTemplate;

@Service
public class Redis {
////    private static String line;
////
////    DefaultJedisClientConfig defaultJedisClientConfig = DefaultJedisClientConfig.builder().password("23273297047d46c3a1a3ed9d7903cf45").build();
////
////    Jedis jedis = new Jedis("us1-calm-parakeet-39821.upstash.io",39821,defaultJedisClientConfig);
////
////        Jedis jedis = new Jedis("us1-calm-parakeet-39821.upstash.io", 39821);
////        jedis.auth("23273297047d46c3a1a3ed9d7903cf45");
////
////    //private static JedisPool jedisPool = new JedisPool("192.168.56.101",63791,"vboxredis","vboxredis001");
////    //Map<String, String> hash = new HashMap<>();
////
////        public void pullRedis(String line)
////        {
////            //hash.put("value",)
////            jedis.rpush(line);
////        }
////        //jedis.set("foo", "bar");
////        //String value = jedis.get("foo");
//private final RedisTemplate<String, String> redisTemplate;
//    public Redis(RedisTemplate<String, String> kafkaTemplate) {
//        this.redisTemplate = kafkaTemplate;
//    }
//    private StringRedisTemplate redisTemplate1;
//
//    public void publish(String val) {
//        redisTemplate.opsForValue().set("1", val);
//        //redisTemplate.opsForList().leftPush("1", val); //идут ошибки
//        System.out.println("РЕДИС publish "+val);
//    }
//    @Resource(name="redisTemplate")
//    private ListOperations<String, String> listOps;
//    public void add(String val) {
//        listOps.leftPush("1",val); //идут ошибки
//        //redisTemplate1.opsForList().leftPush("1", val);
//        System.out.println("РЕДИС add "+val);
//    }
private RedisTemplate<String, String> redisTemplate;
    //    public Redis1(RedisTemplate<String, String> kafkaTemplate, StringRedisTemplate redisTemplate1) {
//        //this.redisTemplate = kafkaTemplate;
//        this.redisTemplate1 = redisTemplate1;
//    }
    private final StringRedisTemplate redisTemplate1;
    public Redis(StringRedisTemplate redisTemplate1) {
        //this.redisTemplate = kafkaTemplate;
        this.redisTemplate1 = redisTemplate1;
    }


    public void publish(String line) {
        //redisTemplate1.opsForValue().set("1", "12345");
        redisTemplate1.opsForList().leftPush("3", line);
        //redisTemplate.opsForHash().put("user:100", "name", "Alice");
    }
//    private RedisTemplate<String, String> redisTemplate;
//
//    public void save(RedisTemplate<String, String> redisTemplate) {
//        redisTemplate.opsForValue().set("1", "12345");
//    }

}
