package pack;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisPassword;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

@Configuration
public class RedisConfig {
//    @Bean
//    JedisConnectionFactory jedisConnectionFactory() {
//        RedisStandaloneConfiguration a=new RedisStandaloneConfiguration();
//        a.setHostName("us1-calm-parakeet-39821.upstash.io");
//        a.setPassword("23273297047d46c3a1a3ed9d7903cf45");
//        a.setPort(39821);
//        //jedisConnectionFactory.setPassword("23273297047d46c3a1a3ed9d7903cf45");
//        //jedisConnectionFactory.setHostName("us1-calm-parakeet-39821.upstash.io");
//        return new JedisConnectionFactory(a);
//    }
//    @Bean
//    public RedisTemplate<String, String> redisTemplate() {
//        final RedisTemplate<String, String> template = new RedisTemplate<String, String>();
//        template.setConnectionFactory(jedisConnectionFactory());
//        //template.setValueSerializer(new GenericToStringSerializer<Object>(Object.class));
//        return template;
//    }
////    @Bean
////    public RedisTemplate<String, String> redisTemplate() {
////        return new RedisTemplate<>(jedisConnectionFactory());
////    }
//
//
//    //    @Bean
////    public RedisTemplate<String, String> redisTemplate(JedisConnectionFactory jedisConnectionFactory) {
////        RedisTemplate<String, String> template = new RedisTemplate<>();
////        template.setConnectionFactory(jedisConnectionFactory);
////        // Add some specific configuration here. Key serializers, etc.
////        return template;
////    }
//    //redisTemplate.setValueSerializer(new StringRedisSerializer());
////@Bean
////public RedisTemplate<Object, Object> redisTemplate(RedisConnectionFactory connectionFactory) {
////    RedisTemplate<Object, Object> template = new RedisTemplate<>();
////    template.setConnectionFactory(connectionFactory);
////    template.setKeySerializer(new StringRedisSerializer());
////    template.setValueSerializer(new JdkSerializationRedisSerializer());
////    return template;
////}
//    @Bean
//    public Redis redis(){return new Redis(redisTemplate());};

    @Bean
    public StringRedisTemplate redisTemplate() {
        return new StringRedisTemplate(jedisConnectionFactory());
    }
    @Bean
    RedisConnectionFactory jedisConnectionFactory() {
        RedisStandaloneConfiguration a=new RedisStandaloneConfiguration("us1-calm-parakeet-39821.upstash.io",39821);
        a.setPassword(RedisPassword.of("23273297047d46c3a1a3ed9d7903cf45"));

        //jedisConnectionFactory.setPassword("23273297047d46c3a1a3ed9d7903cf45");
        //jedisConnectionFactory.setHostName("us1-calm-parakeet-39821.upstash.io");
        return new JedisConnectionFactory(a);
    }
    @Bean
    public Redis redis1(){return new Redis(redisTemplate());};
}
