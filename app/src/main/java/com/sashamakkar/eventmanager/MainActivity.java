package com.sashamakkar.eventmanager;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    TextView welcome, info, contact, name;

    Button search, addEvent;
    TextView editTextSearchEvent, editTextAddEvent;
    DatabaseReference rootref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Coming Soon", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

//        welcome = (TextView) findViewById(R.id.welcome);
        info = (TextView) findViewById(R.id.info);
        contact = (TextView) findViewById(R.id.contact);
        addEvent = (Button) findViewById(R.id.addEvent);
        search = (Button) findViewById(R.id.search);
        editTextSearchEvent = (TextView) findViewById(R.id.editTextSearchEvent);
        editTextAddEvent = (TextView) findViewById(R.id.editTextAddEvent);
        rootref= FirebaseDatabase.getInstance().getReference();

        addEvent.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View view)
            {

                Intent myIntent = new Intent(MainActivity.this,AddEvents.class);

                startActivity(myIntent);
            }
        });


        name = (TextView) findViewById(R.id.name);



        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String a = editTextSearchEvent.getText().toString();
//                String b = tv2.getText().toString();
                // Intent intent = new Intent(MainActivity.this, new ShowEvents(a,b).getClass());
                Intent intent = new Intent(MainActivity.this, new ShowEvents(a).getClass());
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
