package co.edu.uco.ucobet.generales.infrastructure.secondaryadapters.messageservice;

import co.edu.uco.ucobet.generales.application.secondaryports.service.message.MessageService;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class RedisService implements MessageService {

    private final RedisTemplate<String, String> redisTemplate;

    public RedisService(RedisTemplate<String, String> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @Override
    public String getMessage(String key) {
        return redisTemplate.opsForValue().get(key);
    }

    @Override
    public String getMessage(String key, String defaultMessage) {
        String message = redisTemplate.opsForValue().get(key);
        return message != null ? message : defaultMessage;
    }

    @Override
    public void setMessage(String key, String message) {
        redisTemplate.opsForValue().set(key, message);
    }
}