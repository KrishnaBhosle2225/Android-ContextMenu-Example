package com.krishna.contextmenuexample;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ImageView image;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        image = findViewById(R.id.img);
        registerForContextMenu(image);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.contextmenu,menu);
        menu.setHeaderTitle("Select Action");
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();

        switch (id)
        {
            case R.id.email:

                Intent email = new Intent(Intent.ACTION_SEND);
                email.putExtra(Intent.EXTRA_EMAIL, "kbhosle2000@gmail.com");
                email.putExtra(Intent.EXTRA_SUBJECT,"Invitation");
                email.putExtra(Intent.EXTRA_TEXT,"Welcome to Android Full Course");
                email.setType("message/rfc822");
                startActivity(Intent.createChooser(email,"Choose and valid Email :"));
                break;

            case R.id.call:
                Intent call = new Intent(Intent.ACTION_DIAL);
                call.setData(Uri.parse("tel:"+"9082875143"));
                startActivity(call);
                break;

            case R.id.web:
                Intent web = new Intent(Intent.ACTION_VIEW);
                web.setData(Uri.parse("https:www.google.com"));
                startActivity(web);
                break;
        }

        return super.onContextItemSelected(item);
    }

}