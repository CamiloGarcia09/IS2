package co.edu.uco.ucobet.generales.infrastructure.secondaryadapters.redis;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class MessageCatalogService {

    private final RedisTemplate<String, String> redisTemplate;

    public MessageCatalogService(RedisTemplate<String, String> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    // Método para obtener un mensaje desde Redis
    public String getMessage(String key) {
        return redisTemplate.opsForValue().get(key);
    }

    // Método para guardar o actualizar un mensaje en Redis
    public void setMessage(String key, String message) {
        redisTemplate.opsForValue().set(key, message);
    }
}