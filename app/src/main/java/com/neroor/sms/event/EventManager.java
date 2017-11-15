package com.neroor.sms.event;

public class EventManager{

    private Map<EventType, List<EventListener>> listenerMap = new HashMap<EventType, List<EventListener>>();

    /**
     * Register the listener
     */
    public static void bindListener(EventType eventType, EventListener eventListener ){
        if( null != eventType && null != event ) {
            (listenerMap.get(type) == null) ? listenerMap.put(type, eventListener) : (listenerMap.get(type)).add(eventListener);
        }
    }

    public static boolean fireEvent(EventType type, Object data){
        if( type != null ) {
            List<EventListener> listeners = listenerMap.get( type );
            listeners.forEach( listener -> listener.handleEvent(type, data) );
        }
    }
}