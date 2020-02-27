package org.snowcorp.app.model;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;


public class Register extends RealmObject{
    @PrimaryKey
    private  int ID;
    private String Name;
    private  String Email;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    String Password;
}
