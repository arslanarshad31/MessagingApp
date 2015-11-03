package com.example.arslan.messagingapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class MyArrayAdapter extends ArrayAdapter<Message> {
    private final Context context;
    private final ArrayList<Message> messages;

    public MyArrayAdapter(Context context, ArrayList<Message> messages) {
        super(context, R.layout.message, messages);
        this.context = context;
        this.messages = messages;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View messageView;

        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        // Change the layout based on who the message is from
        if (messages.get(position).fromMe()) {

            messageView = inflater.inflate(R.layout.mymessage, parent, false);
            TextView sendingMessageTime = (TextView) messageView.findViewById(R.id.mytimeTextView);
            sendingMessageTime.setText(messages.get(position).getTime());
            TextView sendingMessageText = (TextView) messageView.findViewById(R.id.mymessageTextView);
            sendingMessageText.setText(messages.get(position).getMessage());

        } else {

            messageView = inflater.inflate(R.layout.message, parent, false);
            TextView receivingMessageTime = (TextView) messageView.findViewById(R.id.timeTextView);
            receivingMessageTime.setText(messages.get(position).getTime());
            TextView receivingMessageText = (TextView) messageView.findViewById(R.id.messageTextView);
            receivingMessageText.setText(messages.get(position).getMessage());
        }

        return messageView;
    }
}
