Android Native Application built as a proxy for my personal purpose. 

Handles SMS.

Copyright (c) 2017-2018 Ganesh Kondal 

No rights given to anyone for any reuse or repurpose. If you need it, please reach out to me at ganeshkondal at gmail.com

--

Event Mechanism:
EventManager enables registering and dissipating events to the listeners.

Events:
a) ToggleWifi4G - event used when there is a sending errors
b) ToggleWifi4G_Complete - event when the network (wifi to 4g) switch is done

Listeners:
MQ - MessageQueue listens to network errors. On the request to toggle wifi to 4g (event a) it stops sending it to Volley
   - Again when the ToggleWifi4G_Complete is received, it runs through the yet to be sent ones and sends it out
   
MessageSender - Originates the n/w error event (event a)

Wifi4gSwitch - Originates the switch complete event
