package co.edu.uco.ucobet.generales.crosscutting.helpers;

import co.edu.uco.ucobet.generales.application.secondaryports.service.message.MessageService;
import org.springframework.stereotype.Component;

@Component
public class MessageHelper {

    private static MessageService messageService;

    public MessageHelper(MessageService messageService) {
        MessageHelper.messageService = messageService;
    }

    public static String getMessage(String key) {
        return messageService.getMessage(key);
    }

    public static String getMessage(String key, String defaultMessage) {
        return messageService.getMessage(key, defaultMessage);
    }
}
