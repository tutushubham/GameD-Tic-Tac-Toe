package com.example.myapplication;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;
import android.support.v7.widget.Toolbar;

public class homepage extends AppCompatActivity {
    ImageButton b1, b2;
    Toolbar toolbar;
    int s=0;
    int m=0;
    //MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.homepage);
        b1 = (ImageButton) findViewById(R.id.basketball);
        b2 = (ImageButton) findViewById(R.id.baseball);
        b1.setEnabled(true);
        b2.setEnabled(true);
        /**toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitleTextColor(Color.WHITE);
        toolbar.setTitle("ListViewDemo");
           mediaPlayer=MediaPlayer.create(getApplicationContext(),R.raw.two_dots);
           mediaPlayer.start();*/


        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(homepage.this, MainActivity.class);
                i.putExtra("value", "O");
                //i.putExtra("music",m);
               // i.putExtra("sound",s);
                homepage.this.startActivity(i);
                b1.setEnabled(true);
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(homepage.this, MainActivity.class);
                i.putExtra("value", "X");
               // i.putExtra("sound",s);
               // i.putExtra("music",m);
                homepage.this.startActivity(i);
                b2.setEnabled(true);

            }
        });

    }

    /*@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_file, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.

        int id = item.getItemId();



        //noinspection SimplifiableIfStatement
        if (id == R.id.sound_btn) {
            if(s==0)
            {
                item.setIcon(R.drawable.volume_off);
                s=1;
            }
            else
            {
                item.setIcon(R.drawable.volume_on);
                s=0;
            }


            Toast.makeText(getApplicationContext(), "Action clicked", Toast.LENGTH_LONG).show();
            return true;
        }
        if(id==R.id.music_btn)
        { if(m==0)
        {
            item.setIcon(R.drawable.no_music_note);
            mediaPlayer.pause();
            m=1;

        }
        else
        {
            item.setIcon(R.drawable.music);
            mediaPlayer.start();
            m=0;
        }

                Toast.makeText(getApplicationContext(), "music clicked", Toast.LENGTH_LONG).show();
                return true;

        }

        return super.onOptionsItemSelected(item);


    }*/

}
