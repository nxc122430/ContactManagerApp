package com.nxc122430.contactmanagerapp;

import android.provider.ContactsContract;

import java.io.Serializable;

/**
 * Stores person info
 *
 * Created by Nikesh Chapagain on 2/15/17.
 */

public class Person implements Serializable {
    // create variables
    String firstName;
    String lastName;
    String middleName;
    String birthday;
    String dateContact;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    String number;

    // create setters and getter for each variable
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getDateContact() {
        return dateContact;
    }

    public void setDateContact(String dateContact) {
        this.dateContact = dateContact;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    // constructor to create one person's info
    public Person (String f, String l, String m, String n, String b, String d) {
        firstName = f;
        lastName = l;
        middleName = m;
        number = n;
        birthday = b;
        dateContact = d;
    }

    public String toString () {
        return lastName + "," + firstName;
    }

    public String printString() {
        return firstName + "\t" + lastName + "\t" + middleName + "\t" + number
                + "\t" + birthday + "\t" + dateContact + "\n";
    }

}
