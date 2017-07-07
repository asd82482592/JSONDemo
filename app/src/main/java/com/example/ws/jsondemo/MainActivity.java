package com.example.ws.jsondemo;


        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.widget.TextView;
        import java.io.IOException;
        import java.io.InputStream;
        import java.util.ArrayList;

        import org.json.JSONArray;
        import org.json.JSONException;
        import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {
    private TextView textView1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView1 = (TextView) findViewById(R.id.textView1);
        String jsonStr = readAssetsFile("contacts.json");
        // textView1.setText(jsonStr);
        ArrayList<Contact> list = convertToArrayList(jsonStr);

        jsonStr = readAssetsFile("comments.json");
        ArrayList<Comment> list1 = convertToCommentArrayList(jsonStr);
        //Arrays.toString(list1.toArray())
        textView1.setText(list1.get(0).toString());


    }

    private ArrayList<Contact> convertToArrayList(String jsonStr) {
        JSONObject jsonObj;
        ArrayList<Contact> list = new ArrayList<Contact>();
        try {
            jsonObj = new JSONObject(jsonStr);
            // Getting JSON Array node
            JSONArray contacts = jsonObj.getJSONArray("contacts");

            // looping through All Contacts
            for (int i = 0; i < contacts.length(); i++) {
                JSONObject obj = contacts.getJSONObject(i);
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
                Contact contact = new Contact();
                contact.id = obj.getString("id");
                contact.name = obj.getString("name");
                contact.email = obj.getString("email");
                contact.address = obj.getString("address");
                contact.gender = obj.getString("gender");

                JSONObject phone = obj.getJSONObject("phone");
                contact.phoneMobile = phone.getString("mobile");
                contact.phoneHome = phone.getString("home");
                contact.phoneOffice = phone.getString("office");

                list.add(contact);
            }
        } catch (JSONException e) {
        }

        return list;
    }

    // Examples for pathAndName:
    // data/contacts.json <--- saved in "data" sub-folder
    // contacts <--- saved in assets folder
    // ref: http://android.okhelp.cz/get-assets-folder-path-and-read-txt-file-to-string-android-example-code/
    public String readAssetsFile(String pathAndName) {
        try {
            InputStream  input = getAssets().open(pathAndName);
            int size = input.available();
            byte[] buffer = new byte[size];
            input.read(buffer);
            input.close();
            // Convert byte array to a string
            String text = new String(buffer);
            return text;
        } catch (IOException e) {
            return "";
        }
    }


    private ArrayList<Comment> convertToCommentArrayList(String jsonStr) {
        ArrayList<Comment> list = new ArrayList<Comment>();
        try {
            // Getting JSON Array node
            JSONArray comments = new JSONArray(jsonStr);

            // looping through All Contacts
            for (int i = 0; i < comments.length(); i++) {
                JSONObject obj = comments.getJSONObject(i);

                Comment comment = new Comment();
                comment.id = obj.getString("id");
                comment.first_name = obj.getString("first_name");
                comment.last_name = obj.getString("last_name");
                comment.email = obj.getString("email");
                comment.comment = obj.getString("comment");

                list.add(comment);
            }
        } catch (JSONException e) {
        }

        return list;
    }


}
