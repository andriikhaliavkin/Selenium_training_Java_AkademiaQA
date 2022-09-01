package model;

import enums.MessageSubject;
import lombok.Data;

@Data
public class Message {
    private String email;
    private String orderReference;
    private MessageSubject subject;
    private String message;
}

