package com.example.ws.jsondemo;

/**
 * Created by ws on 7/4/2017.
 */


public class Comment {
    public String id;
    public String first_name;
    public String last_name;
    public String email;
    public String comment;
    public String dtime;


    public Comment() {
    }

    public String toString() {
        return "id=" + id + "\nfirst_name=" + first_name + "\nlast_name=" + last_name
                + "\nemail=" + email + "\ncomment=" + comment
                + "\ndtime=" + dtime;
    }
}
