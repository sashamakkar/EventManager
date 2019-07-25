package com.sashamakkar.eventmanager;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerViewConfig {

    private Context mContext;
    private EventAdapter eventAdapter;
    public void setConfig(RecyclerView recyclerView, Context context, List<Event> events, List<String> keys){
        mContext = context;
        eventAdapter = new EventAdapter(events, keys);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setAdapter(eventAdapter);
    }

    class EventItemView extends RecyclerView.ViewHolder {

        private TextView eventName;
        private TextView eventType;
        private TextView eventDate;
        private TextView eventVenue;
        private TextView eventAbout;
        private TextView eventDuration;
        private TextView eventAttendees;
        private TextView eventSpeciality;

        private String key;

        public EventItemView(ViewGroup parent){
            super(LayoutInflater.from(mContext).inflate(R.layout.activity_event, parent, false));

            eventName = (TextView) itemView.findViewById(R.id.eventName);
            eventType = (TextView) itemView.findViewById(R.id.eventType);
            eventDate = (TextView) itemView.findViewById(R.id.eventDate);
            eventVenue = (TextView) itemView.findViewById(R.id.eventVenue);
            eventAbout = (TextView) itemView.findViewById(R.id.eventAbout);
            eventDuration = (TextView) itemView.findViewById(R.id.eventDuration);
            eventAttendees= (TextView) itemView.findViewById(R.id.eventAttendees);
            eventSpeciality = (TextView) itemView.findViewById(R.id.eventSpeciality);

        }

        public void bind(Event event, String key){
            eventName.setText(event.getName());
            eventType.setText(event.getType());
            eventDate.setText(event.getDate());
            eventVenue.setText(event.getVenue());
            eventAbout.setText(event.getAbout());
            eventDuration.setText(event.getDuration());
            eventAttendees.setText(event.getAttendees());
            eventSpeciality.setText(event.getSpeciality());
            this.key = key;
        }

    }

    class EventAdapter extends RecyclerView.Adapter<EventItemView>{

        private List<Event> mEventList;
        private List<String> mKeys;

        public EventAdapter(List<Event> mEventList, List<String> mKeys) {
            this.mEventList = mEventList;
            this.mKeys = mKeys;
        }

        @NonNull
        @Override
        public EventItemView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new EventItemView(parent);
        }

        @Override
        public void onBindViewHolder(@NonNull EventItemView holder, int position) {
            holder.bind(mEventList.get(position), mKeys.get(position));
        }

        @Override
        public int getItemCount() {
            return mEventList.size();
        }
    }
}
