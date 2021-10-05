package com.example.sendmessage.data.pojo;

import java.io.Serializable;

//El implementa para serializar los datos la interfaz Serializable
public class Message implements Serializable {
    private String user;
    private String message;
    //Constructor vacío si no hay constructor

    public Message(){};
    public Message(String user, String message) {
        this.user = user;
        this.message = message;
    }

    public String getUser() {
        return user;
    }

    public String getMessage() {
        return message;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "Message{" +
                "user='" + user + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
