package co.edu.uco.ucobet.generales.infrastructure.secondaryadapters.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MessageHelper {

    private static MessageCatalogService messageCatalogService;

    @Autowired
    public MessageHelper(MessageCatalogService messageCatalogService) {
        MessageHelper.messageCatalogService = messageCatalogService;
    }

    // Método para obtener un mensaje usando solo la clave
    public static String getMessage(String key) {
        return messageCatalogService.getMessage(key);
    }

    // Método para obtener un mensaje; si no existe, devuelve un mensaje por defecto
    public static String getMessage(String key, String defaultMessage) {
        String message = messageCatalogService.getMessage(key);
        return message != null ? message : defaultMessage;
    }
}
