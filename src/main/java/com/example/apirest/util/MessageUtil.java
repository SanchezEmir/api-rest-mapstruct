package com.example.apirest.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
public class MessageUtil {

    private MessageSource messageSource;

    @Autowired
    public MessageUtil(MessageSource messageSources) {
        this.messageSource = messageSources;
    }

    public MessageSource getMessageSource() {
        return messageSource;
    }

    public String getMessage(String message, Object[] obj, Locale locale) {
        return getMessageSource().getMessage(message, obj, locale);
    }

}
