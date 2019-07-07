package com.alaa7amdy.travaladvidor.Model;

public class Chat {

    private String sender;
    private String receiver;
    private String message;
    private boolean isseen;

    public long getMassageTime() {
        return massageTime;
    }

    public void setMassageTime(long massageTime) {
        this.massageTime = massageTime;
    }

    private long massageTime;

    public Chat(String sender, String receiver, String message, boolean isseen, long massageTime) {
        this.sender = sender;
        this.receiver = receiver;
        this.message = message;
        this.isseen = isseen;
        this.massageTime = massageTime;
    }

    public Chat() {
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isIsseen() {
        return isseen;
    }

    public void setIsseen(boolean isseen) {
        this.isseen = isseen;
    }
}