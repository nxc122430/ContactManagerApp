/* * * * * * * * * * * * * * *
* Contact Manager App
*
*
* Created by Nikesh Chapagain
* * * * * * * * * * * * * * *  */

package com.nxc122430.contactmanagerapp;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

// This is the first activity. It will be a scrolling list with the names, last name first, of your contacts.
// Your Action Bar should have buttons for adding a new contact or modifying an existing one.

public class MainActivity extends AppCompatActivity {

    // create variables
    ListView list;
    ArrayList<Person> contact = new ArrayList<Person>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Context context = getApplicationContext();

        list = (ListView)findViewById(R.id.listView);

        // getting motified or new person info
        Intent intent = getIntent();
        if (intent.getSerializableExtra("NewPerson") != null) {
            Person newPerson = (Person)intent.getSerializableExtra("NewPerson");
            contact.add(newPerson);
        }

        // read the file
        try {
            readFile(context);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // if list is not empty then write to the file (datbase)
        if (contact != null) {
            writeFile(context);
        }

        // add arraylist into listview
        ArrayAdapter<Person> arrayAdapter = new ArrayAdapter<Person>(this, android.R.layout.simple_list_item_1, contact );
        list.setAdapter(arrayAdapter);
    }

    // read the file and store it into the array list
    public void readFile (Context context) throws IOException {
        Person p = new Person ("", "", "", "", "", "");
        try {
            InputStream in = context.openFileInput("contact.txt");

            if (in != null) {
                InputStreamReader inputStreamReader = new InputStreamReader(in);
                BufferedReader reader = new BufferedReader(inputStreamReader);
                String line = "";
                while ((line = reader.readLine()) != null) {
                    String[] info = line.split("\\s+");
                    p.setFirstName(info[0]);
                    p.setLastName(info[1]);
                    p.setMiddleName(info[2]);
                    p.setNumber(info[3]);
                    p.setBirthday(info[4]);
                    p.setDateContact(info[5]);
                    contact.add(p);
                }

                in.close();
            }

        }
        catch (FileNotFoundException e) {
            Log.e("login activity", "File not found: " + e.toString());
        } catch (IOException e) {
            Log.e("login activity", "Can not read file: " + e.toString());
        }
    }

    // write to the file (database)
    public void writeFile (Context context) {
        try {
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(context.openFileOutput("contact.txt", Context.MODE_PRIVATE));
            for (int i = 0; i < contact.size(); i++) {
                outputStreamWriter.append(contact.get(i).printString());
            }
            outputStreamWriter.close();
        }
        catch (IOException e) {
            Log.e("Exception", "File write failed: " + e.toString());
        }
    }

    // go to the second activity
    public void gotToSecond (View view) {
        Intent i = new Intent(this, AddNew.class);
        startActivity(i);
    }
}
