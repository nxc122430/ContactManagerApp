package com.nxc122430.contactmanagerapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


// second activity to edit and add new
public class AddNew extends AppCompatActivity {

    // create varables
    EditText fname, lname, mname, brithday, date, number;
    Button save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new);

        fname = (EditText)findViewById(R.id.name);
        lname = (EditText)findViewById(R.id.lastName);
        number = (EditText)findViewById(R.id.phone);
        mname = (EditText)findViewById(R.id.middle);
        brithday = (EditText)findViewById(R.id.brithday);
        date = (EditText)findViewById(R.id.date);
        save = (Button)findViewById(R.id.button);

        // save the new user info
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Person p = new Person (fname.getText().toString(), lname.getText().toString(),
                        number.getText().toString(), mname.getText().toString(), brithday.getText().toString(),
                        date.getText().toString());
                Intent intent = new Intent(AddNew.this, MainActivity.class);
                intent.putExtra("NewPerson", p);
                startActivity(intent);
            } });


    }
}
