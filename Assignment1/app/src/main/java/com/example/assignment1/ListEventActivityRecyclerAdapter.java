package com.example.assignment1;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.assignment1.provider.Event;

import java.util.ArrayList;

public class ListEventActivityRecyclerAdapter extends RecyclerView.Adapter<ListEventActivityRecyclerAdapter.CustomViewHolder> {

    ArrayList<Event> dataListEvent = new ArrayList<Event>();

    public void setDataListEvent(ArrayList<Event> dataListEvent) {
        this.dataListEvent = dataListEvent;
    }

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View eventView = LayoutInflater.from(parent.getContext()).inflate(R.layout.event_card,parent,false);
        CustomViewHolder viewHolderEvent = new CustomViewHolder(eventView);
        return viewHolderEvent;

    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holderEvent, int position) {
        holderEvent.tvEventId.setText(dataListEvent.get(position).getEventId());
        holderEvent.tvEventTic.setText( String.valueOf( dataListEvent.get(position).getEventTicNumber()));
        holderEvent.tvEventName.setText(String.valueOf(dataListEvent.get(position).getEventName()));
        holderEvent.tvCatId.setText(dataListEvent.get(position).getCatID());
        holderEvent.isEventActive.setText(dataListEvent.get(position).isEventActive() ? "Active" : "InActive");



        holderEvent.cardView.setOnClickListener(v -> {
        String eventNameString = dataListEvent.get(position).getEventName();
        Context context = holderEvent.cardView.getContext();
        // launch new Activity with supplied country name
        Intent intent = new Intent(context, EventGoogleSearchActivity.class);
        intent.putExtra("eventName", eventNameString);
        context.startActivity(intent);
        });
    }


    @Override
    public int getItemCount() {
        return dataListEvent.size();

    }

    public class CustomViewHolder extends RecyclerView.ViewHolder{
        public TextView tvEventId;
        public TextView tvEventName;
        public TextView tvCatId;
        public TextView tvEventTic;
        public TextView isEventActive;
        public View cardView;
        public CustomViewHolder(@NonNull View eventView){
            super (eventView); //intialise the view inside the RecycleView
            cardView = itemView;
            tvEventId =  itemView.findViewById(R.id.item_eventId);
            tvEventName = itemView.findViewById(R.id.item_eventName);
            tvCatId = itemView.findViewById(R.id.item_catId);
            tvEventTic = itemView.findViewById(R.id.item_eventTick);
            isEventActive = itemView.findViewById(R.id.item_isEventActive);
        }
    }
}

