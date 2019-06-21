package com.example.myapplication;




import android.animation.ObjectAnimator;
import android.content.DialogInterface;

import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Build;

import android.support.v7.app.AlertDialog;

import android.support.v7.app.AppCompatActivity;

import android.os.Bundle;

import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SoundEffectConstants;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity{


    private int count=0;
    private int k=0,k1=0;
    ImageView p1,p2;
    Toolbar toolbar;



    ImageButton block1, block2, block3, block4, block5, block6, block7, block8, block9;
    Button restart,newGame;
    TextView result;
    int t1=0,t2=0,t3=0,t4=0,t5=0,t6=0,t7=0,t8=0,t9=0;

    MediaPlayer mediaPlayer;
    MediaPlayer mplayer;
    String player;
    int m=0,s=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
          Intent i=getIntent();
          player=i.getStringExtra("value");
         // i.getIntExtra("music",m);
          //i.getIntExtra("sound",s);
          mediaPlayer=MediaPlayer.create(getApplicationContext(),R.raw.two_dots);
          mediaPlayer.start();
          mplayer=MediaPlayer.create(getApplicationContext(),R.raw.bubble_pop);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitleTextColor(Color.BLACK);
        toolbar.setTitle("T.I.C.-T.A.C.-T.O.E");
        //toolbar.setTextAlignment(View.TEXT_ALIGNMENT_GRAVITY);

        p1=(ImageView)findViewById(R.id.p1);
          p2=(ImageView)findViewById(R.id.p2);
          if(player.equals("O"))
          {
              k=0;
              k1=0;
              p1.setImageResource(R.drawable.bbbb);
              p2.setImageResource(R.drawable.baseball);

          }
              
          else
          {
              k=1;
              k1=1;
              p1.setImageResource(R.drawable.baseball);
              p2.setImageResource(R.drawable.bbbb);

          }
              




        block1 = (ImageButton)findViewById(R.id.bt_block1);
        block2 = (ImageButton) findViewById(R.id.bt_block2);
        block3 = (ImageButton) findViewById(R.id.bt_block3);
        block4 = (ImageButton) findViewById(R.id.bt_block4);
        block5 = (ImageButton) findViewById(R.id.bt_block5);
        block6 = (ImageButton) findViewById(R.id.bt_block6);
        block7 = (ImageButton) findViewById(R.id.bt_block7);
        block8 = (ImageButton) findViewById(R.id.bt_block8);
        block9 = (ImageButton) findViewById(R.id.bt_block9);
        result = (TextView) findViewById(R.id.tv_show_result);
        restart = (Button) findViewById(R.id.bt_restart_game);
        newGame=(Button)findViewById(R.id.bt_new_game);






        block1.setEnabled(true);
        block2.setEnabled(true);
        block3.setEnabled(true);
        block4.setEnabled(true);
        block5.setEnabled(true);
        block6.setEnabled(true);
        block7.setEnabled(true);
        block8.setEnabled(true);
        block9.setEnabled(true);

        block1.setActivated(false);
        block2.setActivated(false);
        block3.setActivated(false);
        block4.setActivated(false);
        block5.setActivated(false);
        block6.setActivated(false);
        block7.setActivated(false);
        block8.setActivated(false);
        block9.setActivated(false);

        block1.setAlpha(1.0f);
        block2.setAlpha(1.0f);
        block3.setAlpha(1.0f);
        block4.setAlpha(1.0f);
        block5.setAlpha(1.0f);
        block6.setAlpha(1.0f);
        block7.setAlpha(1.0f);
        block8.setAlpha(1.0f);
        block9.setAlpha(1.0f);


        newGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder;
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    builder = new AlertDialog.Builder(MainActivity.this, android.R.style.Theme_Material_Dialog_Alert);
                } else {
                    builder = new AlertDialog.Builder(MainActivity.this);
                }
                builder.setTitle("Tic-Tac-Toe")
                        .setMessage("Do you want to start a new game?")
                        .setPositiveButton("YES", new DialogInterface.OnClickListener() {

                            public void onClick(DialogInterface dialog, int which) {
                                // continue with delete

                                block1.setBackgroundResource(R.color.White);
                                block2.setBackgroundResource(R.color.White);
                                block3.setBackgroundResource(R.color.White);
                                block4.setBackgroundResource(R.color.White);
                                block5.setBackgroundResource(R.color.White);
                                block6.setBackgroundResource(R.color.White);
                                block7.setBackgroundResource(R.color.White);
                                block8.setBackgroundResource(R.color.White);
                                block9.setBackgroundResource(R.color.White);



                                count=0;
                                mediaPlayer.stop();
                                Intent i=new Intent(MainActivity.this,homepage.class);
                                MainActivity.this.startActivity(i);



                            }
                        })
                        .setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                // do nothing
                                dialog.dismiss();
                            }
                        })
                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .show();


            }
        });





        /**
         * Restarts the game
         */
        restart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                    AlertDialog.Builder builder;
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        builder = new AlertDialog.Builder(MainActivity.this, android.R.style.Theme_Material_Dialog_Alert);
                    } else {
                        builder = new AlertDialog.Builder(MainActivity.this);
                    }
                    builder.setTitle("Tic-Tac-Toe")
                            .setMessage("Do you want to restart the game?")
                            .setPositiveButton("YES", new DialogInterface.OnClickListener() {

                                public void onClick(DialogInterface dialog, int which) {
                                    // continue with delete
                                    block1.setEnabled(true);
                                    block2.setEnabled(true);
                                    block3.setEnabled(true);
                                    block4.setEnabled(true);
                                    block5.setEnabled(true);
                                    block6.setEnabled(true);
                                    block7.setEnabled(true);
                                    block8.setEnabled(true);
                                    block9.setEnabled(true);

                                    block1.setActivated(false);
                                    block2.setActivated(false);
                                    block3.setActivated(false);
                                    block4.setActivated(false);
                                    block5.setActivated(false);
                                    block6.setActivated(false);
                                    block7.setActivated(false);
                                    block8.setActivated(false);
                                    block9.setActivated(false);

                                    block1.setImageResource(R.color.White);
                                    block2.setImageResource(R.color.White);
                                    block3.setImageResource(R.color.White);
                                    block4.setImageResource(R.color.White);
                                    block5.setImageResource(R.color.White);
                                    block6.setImageResource(R.color.White);
                                    block7.setImageResource(R.color.White);
                                    block8.setImageResource(R.color.White);
                                    block9.setImageResource(R.color.White);


                                    count=0;
                                    k=k1;
                                    t1=0;t2=0;t3=0;t4=0;t5=0;t6=0;t7=0;t8=0;t9=0;

                                    block1.setBackgroundResource(R.color.White);
                                    block2.setBackgroundResource(R.color.White);
                                    block3.setBackgroundResource(R.color.White);
                                    block4.setBackgroundResource(R.color.White);
                                    block5.setBackgroundResource(R.color.White);
                                    block6.setBackgroundResource(R.color.White);
                                    block7.setBackgroundResource(R.color.White);
                                    block8.setBackgroundResource(R.color.White);
                                    block9.setBackgroundResource(R.color.White);

                                    result.setText("It's a Tie");

                                    block1.setAlpha(1.0f);
                                    block2.setAlpha(1.0f);
                                    block3.setAlpha(1.0f);
                                    block4.setAlpha(1.0f);
                                    block5.setAlpha(1.0f);
                                    block6.setAlpha(1.0f);
                                    block7.setAlpha(1.0f);
                                    block8.setAlpha(1.0f);
                                    block9.setAlpha(1.0f);

                                    result.setText("");








                                }
                            })
                            .setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    // do nothing
                                    dialog.dismiss();
                                }
                            })
                            .setIcon(android.R.drawable.ic_dialog_alert)
                            .show();


            }
        });


        // BLOCK 1
        block1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                block1.setActivated(true);
                // CHECK AGAR ALREADY KUCH STRING EXIST KAR RAHA HAI..

                if(t1!=0)
                {

                }
                else
                {
                    if(k%2==0)
                    {
                        block1.setImageResource(R.drawable.bbbb);
                        
                    }
                    else
                    {
                        block1.setImageResource(R.drawable.baseball);
                        
                    }

                    if(count%2==0)
                        t1=1;
                    else
                        t1=2;
                    count++;k++;
                    block1.setBackgroundResource(R.drawable.shadow_game_buttons);
                    if(s==0)
                        mplayer.start();




                    
                    check();
                }

            }
        });


        // BLOCK 2
        block2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // CHECK AGAR ALREADY KUCH STRING EXIST KAR RAHA HAI..
                block2.setActivated(true);

                if(t2!=0)
                {

                }
                else
                {
                    if(k%2==0)
                    {
                        block2.setImageResource(R.drawable.bbbb);
                       
                    }
                    else
                    {
                        block2.setImageResource(R.drawable.baseball);
                        
                    }
                    if(count%2==0)
                        t2=1;
                    else
                        t2=2;
                    count++;k++;

                    block2.setBackgroundResource(R.drawable.shadow_game_buttons);
                    if(s==0)
                        mplayer.start();

                    check();

                }



            }
        });


        // BLOCK 3
        block3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // CHECK AGAR ALREADY KUCH STRING EXIST KAR RAHA HAI..
                block3.setActivated(true);

                if(t3!=0)
                {

                }
                else
                {
                    if(k%2==0)
                    {
                        block3.setImageResource(R.drawable.bbbb);
                        
                    }
                    else
                    {
                        block3.setImageResource(R.drawable.baseball);
                        

                    }
                    if(count%2==0)
                        t3=1;
                    else
                        t3=2;
                    count++;k++;

                    block3.setBackgroundResource(R.drawable.shadow_game_buttons);
                    if(s==0)
                        mplayer.start();


                    check();
                }


            }
        });

        // BLOCK 4
        block4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                block4.setActivated(true);
                // CHECK AGAR ALREADY KUCH STRING EXIST KAR RAHA HAI..

                if(t4!=0)
                {

                }
                else
                {
                    if(k%2==0)
                    {
                        block4.setImageResource(R.drawable.bbbb);
                       
                    }
                    else
                    {
                        block4.setImageResource(R.drawable.baseball);

                        
                    }
                    if(count%2==0)
                        t4=1;
                    else
                        t4=2;
                    count++;k++;
                    block4.setBackgroundResource(R.drawable.shadow_game_buttons);
                    if(s==0)
                        mplayer.start();



                    check();
                }


            }
        });

        //BLOCK 5
        block5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                block5.setActivated(true);
                // CHECK AGAR ALREADY KUCH STRING EXIST KAR RAHA HAI..

                if(t5!=0)
                {

                }
                else
                {
                    if(k%2==0)
                    {
                        block5.setImageResource(R.drawable.bbbb);
                       
                    }
                    else
                    {
                        block5.setImageResource(R.drawable.baseball);
                        
                    }
                    if(count%2==0)
                        t5=1;
                    else
                        t5=2;
                    count++;k++;
                    block5.setBackgroundResource(R.drawable.shadow_game_buttons);

                    if(s==0)
                        mplayer.start();



                    check();
                }


            }
        });

        //BLOCK 6
        block6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                block6.setActivated(true);
                // CHECK AGAR ALREADY KUCH STRING EXIST KAR RAHA HAI..

                if(t6!=0)
                {

                }
                else
                {
                    if(k%2==0)
                    {
                        block6.setImageResource(R.drawable.bbbb);
                       
                    }
                    else
                    {
                        block6.setImageResource(R.drawable.baseball);
                        
                    }
                    if(count%2==0)
                        t6=1;
                    else
                        t6=2;
                    count++;k++;
                    block6.setBackgroundResource(R.drawable.shadow_game_buttons);
                    if(s==0)
                        mplayer.start();



                    check();
                }


            }
        });

        //BLOCK 7
        block7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                block7.setActivated(true);
                // CHECK AGAR ALREADY KUCH STRING EXIST KAR RAHA HAI..

                if(t7!=0)
                {

                }
                else
                {
                    if(k%2==0)
                    {
                        block7.setImageResource(R.drawable.bbbb);
                       
                    }
                    else
                    {
                        block7.setImageResource(R.drawable.baseball);
                        
                    }
                    if(count%2==0)
                        t7=1;
                    else
                        t7=2;
                    count++;k++;
                    block7.setBackgroundResource(R.drawable.shadow_game_buttons);
                    if(s==0)
                        mplayer.start();



                    check();
                }


            }
        });

        // BLOCK 8
        block8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                block8.setActivated(true);
                // CHECK AGAR ALREADY KUCH STRING EXIST KAR RAHA HAI..

                if(t8!=0)
                {

                }
                else
                {
                    if(k%2==0)
                    {
                        block8.setImageResource(R.drawable.bbbb);
                       
                    }
                    else
                    {
                        block8.setImageResource(R.drawable.baseball);
                      
                    }
                    if(count%2==0)
                        t8=1;
                    else
                        t8=2;
                    count++;k++;
                    block8.setBackgroundResource(R.drawable.shadow_game_buttons);
                    if(s==0)
                        mplayer.start();



                    check();
                }


            }
        });

        // BLOCK 9
        block9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                block9.setActivated(true);
                // CHECK AGAR ALREADY KUCH STRING EXIST KAR RAHA HAI..

                if(t9!=0)
                {

                }
                else
                {
                    if(k%2==0)
                    {
                        block9.setImageResource(R.drawable.bbbb);
                       
                    }
                    else
                    {
                        block9.setImageResource(R.drawable.baseball);
                       
                    }
                    if(count%2==0)
                        t9=1;
                    else
                        t9=2;
                    count++;k++;
                    block9.setBackgroundResource(R.drawable.shadow_game_buttons);
                    if(s==0)
                        mplayer.start();



                    check();
                }


            }
        });



        // ONCREATE ENDS HERE
    }

    public void check()
    {


        if ((t1 == t2 && t1 == t3 && t3 == t2 && t1!=0)) {
            if (t1 == 1) {
                result.setText("Player 1 Wins");


            } else if (t1 == 2) {
                result.setText("Player 2 Wins");


            }
            block4.setAlpha(0.5f);
            block5.setAlpha(0.5f);
            block6.setAlpha(0.5f);
            block7.setAlpha(0.5f);
            block8.setAlpha(0.5f);
            block9.setAlpha(0.5f);
            condition();
            return;
        } else if ((t4 == t5 && t5 == t6 && t4 == t6 && t4!=0)) {
            if (t4 == 1) {
                result.setText("Player 1 Wins");


            } else if (t4 == 2) {
                result.setText("Player 2 Wins");


            }
            block1.setAlpha(0.5f);
            block2.setAlpha(0.5f);
            block3.setAlpha(0.5f);
            block7.setAlpha(0.5f);
            block8.setAlpha(0.5f);
            block9.setAlpha(0.5f);
            condition();
            return;
        } else if ((t7 == t8 && t8 == t9 && t7 == t9 && t7!=0)) {
            if (t7 == 1) {
                result.setText("Player 1 Wins");


            } else if (t7 == 2) {
                result.setText("Player 2 Wins");


            }
            block1.setAlpha(0.5f);
            block2.setAlpha(0.5f);
            block3.setAlpha(0.5f);
            block4.setAlpha(0.5f);
            block5.setAlpha(0.5f);
            block6.setAlpha(0.5f);
            condition();
            return;
        } else if ((t1 == t4 && t4 == t7 && t7 == t1 && t1!=0)) {
            if (t7 == 1) {
                result.setText("Player 1 Wins");


            } else if (t7 == 2) {
                result.setText("Player 2 Wins");


            }
            block5.setAlpha(0.5f);
            block2.setAlpha(0.5f);
            block3.setAlpha(0.5f);
            block6.setAlpha(0.5f);
            block8.setAlpha(0.5f);
            block9.setAlpha(0.5f);
            condition();
            return;
        } else if ((t2 == t5 && t2 == t8 && t5 == t8 && t2!=0)) {
            if (t2 == 1) {
                result.setText("Player 1 Wins");


            } else if (t2 == 2) {
                result.setText("Player 2 Wins");


            }
            block1.setAlpha(0.5f);
            block4.setAlpha(0.5f);
            block3.setAlpha(0.5f);
            block7.setAlpha(0.5f);
            block6.setAlpha(0.5f);
            block9.setAlpha(0.5f);
            condition();
            return;
        } else if ((t3 == t6 && t6 == t9 && t3 == t9 && t3!=0)) {
            if (t3 == 1) {
                result.setText("Player 1 Wins");


            } else if (t3 == 2) {
                result.setText("Player 2 Wins");


            }
            block1.setAlpha(0.5f);
            block2.setAlpha(0.5f);
            block4.setAlpha(0.5f);
            block7.setAlpha(0.5f);
            block8.setAlpha(0.5f);
            block5.setAlpha(0.5f);
            condition();
            return;
        } else if ((t1 == t5 && t1 == t9 && t5 == t9 && t1!=0)) {
            if (t5 == 1) {
                result.setText("Player 1 Wins");


            } else if (t5 == 2) {
                result.setText("Player 2 Wins");


            }
            block4.setAlpha(0.5f);
            block2.setAlpha(0.5f);
            block3.setAlpha(0.5f);
            block7.setAlpha(0.5f);
            block8.setAlpha(0.5f);
            block6.setAlpha(0.5f);
            condition();
            return;
        } else if ((t7 == t3 && t7 == t5 && t3 == t5 && t7!=0)) {
            if (t7 == 1) {
                result.setText("Player 1 Wins");


            } else if (t7 == 2) {
                result.setText("Player 2 Wins");


            }
            block1.setAlpha(0.5f);
            block2.setAlpha(0.5f);
            block4.setAlpha(0.5f);
            block6.setAlpha(0.5f);
            block8.setAlpha(0.5f);
            block9.setAlpha(0.5f);
            condition();
            return;
        } else if (count == 9) {
            result.setText("It's a Tie");
            block1.setAlpha(0.5f);
            block2.setAlpha(0.5f);
            block3.setAlpha(0.5f);
            block4.setAlpha(0.5f);
            block5.setAlpha(0.5f);
            block6.setAlpha(0.5f);
            block7.setAlpha(0.5f);
            block8.setAlpha(0.5f);
            block9.setAlpha(0.5f);

            return;
        } else {

        }
    }

    public void condition()
    {
        block1.setEnabled(false);
        block2.setEnabled(false);
        block3.setEnabled(false);
        block4.setEnabled(false);
        block5.setEnabled(false);
        block6.setEnabled(false);
        block7.setEnabled(false);
        block8.setEnabled(false);
        block9.setEnabled(false);
    }

    @Override
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


    }

}
