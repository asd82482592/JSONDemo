package com.example.ws.jsondemo;
/*
        {
                "id": "c200",
                "name": "Ravi Tamada",
                "email": "ravi@gmail.com",
                "address": "xx-xx-xxxx,x - street, x - country",
                "gender" : "male",
                "phone": {
                    "mobile": "+91 0000000000",
                    "home": "00 000000",
                    "office": "00 000000"
                }
        }
 */

public class Contact {
    public String id;
    public String name;
    public String email;
    public String address;
    public String gender;
    public String phoneMobile;
    public String phoneHome;
    public String phoneOffice;

    public Contact() {
    }

    public String toString() {
        return "id=" + id + "\nname=" + name + "\nemail=" + email
                + "\naddress=" + address + "\ngender=" + gender
                + "\nphoneMobile=" + phoneMobile + "\nphoneHome=" + phoneHome
                + "\nphoneOffice=" + phoneOffice;
    }
}
