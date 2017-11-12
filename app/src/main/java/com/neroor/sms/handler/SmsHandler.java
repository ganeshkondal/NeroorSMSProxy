package com.neroor.sms.handler;

import android.content.Context;
import android.content.Intent;
import android.support.v4.content.WakefulBroadcastReceiver;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.widget.Toast;

import com.neroor.sms.data.Message;
import com.neroor.sms.service.SmsManager;
import com.neroor.sms.util.Logger;

/**
 * SMS handler. Used to receive the message
 */
public class SmsHandler extends WakefulBroadcastReceiver {

    public static final String SMS_BUNDLE = "pdus";

    public void onReceive(Context context, Intent intent) {
        Bundle intentExtras = intent.getExtras();
        if (intentExtras != null) {
            Object[] sms = (Object[]) intentExtras.get(SMS_BUNDLE);
            String smsMessageStr = "";
            Message messageReceived = null;
            for (int i = 0; i < sms.length; ++i) {
                SmsMessage smsMessage = SmsMessage.createFromPdu((byte[]) sms[i]);

                messageReceived = new Message(smsMessage.getOriginatingAddress(), smsMessage.getMessageBody().toString() );
                Logger.print("N_TAG", "onReceive: " + messageReceived.toString() );
                smsMessageStr += "SMS From: " + messageReceived.getSenderMDN() + "\n";
                smsMessageStr += messageReceived.getMessage() + "\n";
            }
            Toast.makeText(context, smsMessageStr, Toast.LENGTH_SHORT).show();

            // this will update the UI with message
            // SmsActivity inst = SmsActivity.instance();
            // inst.updateList(messageReceived);


            SmsManager.updateList( messageReceived );
        }
    }
}