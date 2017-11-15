package com.neroor.sms.event;

public interface EventListener {

    public static void handleEvent(EventTypes type, Object data);
}