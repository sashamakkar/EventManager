package com.sashamakkar.eventmanager;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class EventActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerViewEvents);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(EventActivity.this);
        recyclerView.setLayoutManager(layoutManager);



        new EventDetails().readEvent(new EventDetails.DataStatus() {
            @Override
            public void DataIsLoaded(List<Event> events, List<String> keys) {

//                setContentView(findViewById(R.id.recyclerViewEvents));
                new RecyclerViewConfig().setConfig(recyclerView, EventActivity.this, events, keys);
            }

            @Override
            public void DataIsInserted() {

            }

            @Override
            public void DataIsUpdated() {

            }

            @Override
            public void DataIsDeleted() {

            }
        });
    }
}
