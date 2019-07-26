package com.sashamakkar.eventmanager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ShowEvents extends AppCompatActivity {

    TextView nametv;
    Button b;
    Spinner spinner;
    public static String event;
    public ShowEvents(String Item) {
        event = Item;

    }
    public void setEvent(String item)
    {
        event = item;
    }

    public String getEvent()
    {
        return event;
    }

    public ShowEvents() {

    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_events);

        nametv = (TextView) findViewById(R.id.name);
        spinner = (Spinner) findViewById(R.id.spinner);

        spinner.setOnItemSelectedListener(new custom());


        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference ref = database.getInstance().getReference();

        final HashMap<String,String> ev = new HashMap<>();


        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                List<String> categories = new ArrayList<String>();
                for (DataSnapshot t : dataSnapshot.getChildren()) {
                    String x = String.valueOf(t.getChildrenCount());
                    for(DataSnapshot tt : t.getChildren())
                    {
                        String y = String.valueOf(t.getChildrenCount());
                        for(DataSnapshot ttt : tt.getChildren()){
                            String q = "";
                            if (ttt.getKey().toString().equals("name")) {
                                q = ttt.getValue().toString();
                                Toast.makeText(getApplicationContext(), "name " + q, Toast.LENGTH_SHORT);
                                String s = q;
                                categories.add(s);
                            }
                        }

                    }
                }
                set(categories);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }

        });

        b = (Button) findViewById(R.id.details);


        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = getEvent();
                Toast.makeText(getApplicationContext(), "Redirecting : " + s, Toast.LENGTH_LONG).show();
                System.out.print("Redirecting   " + s);
                Intent i = new Intent(ShowEvents.this, EventActivity.class);
                i.putExtra("Event",s);
                startActivity(i);


            }
        });

    }

    public void set(List<String> categories) {

        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories);

        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        spinner.setAdapter(dataAdapter);
    }
}

class custom  implements AdapterView.OnItemSelectedListener
{


    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        // On selecting a spinner item
        String item = parent.getItemAtPosition(position).toString();

        // Showing selected spinner item
        //Toast.makeText(parent.getContext(), "Selected: " + item, Toast.LENGTH_LONG).show();
        ShowEvents ob = new ShowEvents(item);
        ob.setEvent(item);
        ShowEvents.event = item;
    }
    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub
    }



}
