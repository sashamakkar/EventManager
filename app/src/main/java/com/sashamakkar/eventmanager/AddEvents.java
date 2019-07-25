package com.sashamakkar.eventmanager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.List;

public class AddEvents extends AppCompatActivity {

    EditText entername,entertype,entervenue,enterabout, enterspecial, enterdate, enterduration;
    TextView name, type, venue, about, specialities, attendees, date, duration;
    RadioButton rb;
    Button add;

    HashMap<String,Object> event;
    String s;
    DatabaseReference rootref;//points to the first key

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_events);

        entername = (EditText)findViewById(R.id.entername);
        entertype = (EditText) findViewById(R.id.entertype);
        entervenue = (EditText) findViewById(R.id.entervenue);
        enterabout = (EditText) findViewById(R.id.enterabout);
        enterspecial = (EditText) findViewById(R.id.enterspecial);
        enterdate = (EditText) findViewById(R.id.enterdate);
        enterduration = (EditText) findViewById(R.id.enterduration);

        name = (TextView)findViewById(R.id.name);
        type = (TextView) findViewById(R.id.type);
        venue = (TextView)findViewById(R.id.venue);
        about = (TextView)findViewById(R.id.about);
        specialities = (TextView)findViewById(R.id.specialities);
        attendees = (TextView)findViewById(R.id.attendees);
        date = (TextView) findViewById(R.id.date);
        duration = (TextView) findViewById(R.id.duration);



        rootref= FirebaseDatabase.getInstance().getReference();



        add = (Button) findViewById(R.id.add);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//

                Event event = new Event();

                event.setName(entername.getText().toString());
                event.setType(entertype.getText().toString());
                event.setVenue(entervenue.getText().toString());
                event.setAbout(enterabout.getText().toString());
                event.setAttendees(rb.getText().toString());
                event.setDate(enterdate.getText().toString());
                event.setDuration(enterduration.getText().toString());
                event.setSpeciality(enterspecial.getText().toString());

                new EventDetails().addEvent(event, new EventDetails.DataStatus() {
                    @Override
                    public void DataIsLoaded(List<Event> events, List<String> keys) {

                    }

                    @Override
                    public void DataIsInserted() {
                        Toast.makeText(AddEvents.this, "Event Added", Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void DataIsUpdated() {

                    }

                    @Override
                    public void DataIsDeleted() {

                    }
                });

                HashMap<String, String> ev = new HashMap<String, String>();


                DatabaseReference newRef = rootref.push();

                String Name = entername.getText().toString();

                String Type = entertype.getText().toString();

                String Venue = entervenue.getText().toString();

                String About = enterabout.getText().toString();

                String Speciality = enterspecial.getText().toString();

                String Attendees = rb.getText().toString();

                String Date = enterdate.getText().toString();

                String Duration = enterduration.getText().toString();


                ev.put("about",About);
                ev.put("attendees",Attendees);
                ev.put("date",Date);
                ev.put("duration",Duration);
                ev.put("name",Name);
                ev.put("speciality",Speciality);
                ev.put("type",Type);
                ev.put("venue", Venue);

                newRef.setValue(ev);


                Intent i = new Intent(AddEvents.this,MainActivity.class);

                startActivity(i);
            }
        });

    }

    public void onRadioClick(View view)
    {
        boolean chk = ((RadioButton) view).isChecked();

        switch (view.getId())
        {
            case R.id.ticket :
                if (chk)
                {
                    rb = (RadioButton) findViewById(R.id.ticket);
                }
                break;


            case R.id.noticket :
                if (chk)
                {
                    rb = (RadioButton) findViewById(R.id.noticket);
                }
                break;


            case R.id.vip :
                if (chk)
                {
                    rb = (RadioButton) findViewById(R.id.vip);
                }

                break;


            case R.id.army:if (chk)
            {
                rb = (RadioButton) findViewById(R.id.army);
            }

                break;


            case R.id.other :
                if (chk)
                {
                    rb = (RadioButton) findViewById(R.id.other);
                }

                break;

            case R.id.default_activity_button:
                rb = (RadioButton) findViewById(R.id.other);

                break;

        }
    }
}
