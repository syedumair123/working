package com.example.mymosque;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

public class DuaDetailScreen extends AppCompatActivity {


    TextView DuaTitle, Dua, DuaTranslation;
    String AudioLink, duaTile, duaArabic, duaTranslation;
    SeekBar seekbar;
    ImageView play, Pause, Stop;

    MediaPlayer mp;
    int SeekValue = 0;
    ProgressDialog PG;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dua_detail_screen);

        DuaTitle = findViewById(R.id.Text_Intoduction_);
        Dua = findViewById(R.id.Text_Arabic_);
        DuaTranslation = findViewById(R.id.Text_Arabic_Tranxlation);
        seekbar = findViewById(R.id.Seekbar);
        play = findViewById(R.id.Play);
        Pause = findViewById(R.id.Pause);
        Stop = findViewById(R.id.Stop);


        getSupportActionBar().hide();


        PG = new ProgressDialog(this);
        PG.setMessage("Loading....");
        PG.setCancelable(false);
//pick the values from shared pref and set these values in text fields of dua detail screen

        SharedPreferences DuaDataPrefs = getSharedPreferences("DuaDataPass", Context.MODE_PRIVATE);
        duaTile = DuaDataPrefs.getString("Title", "0");
        duaArabic = DuaDataPrefs.getString("TextDua", "0");
        duaTranslation = DuaDataPrefs.getString("TextDuaTranslation", "0");
        AudioLink = DuaDataPrefs.getString("AudioUrl", "0");


        DuaTitle.setText(duaTile);
        DuaTranslation.setText(duaTranslation);
        Dua.setText(duaArabic);
        //   mp=new MediaPlayer();
        Stop.setVisibility(View.GONE);
        Pause.setVisibility(View.GONE);

        seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar SSeekBar, int i, boolean b) {
                SeekValue = i;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

                try {
                    mp.seekTo(SeekValue);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }


        });


        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                PG.show();
                final Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        //Do something after 100ms

//initialize the media player here
                        if (SeekValue == 0) {

                            try {


                                mp = new MediaPlayer();
                                mp.setDataSource(AudioLink);
                                mp.prepare();
                                mp.seekTo(SeekValue);
                                mp.start();
                                seekbar.setMax(mp.getDuration());


                                if (mp.isPlaying()) {
                                    PG.dismiss();
                                }


                            } catch (Exception ex) {
                                ex.printStackTrace();

                            }


                            mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                                @Override
                                public void onCompletion(MediaPlayer mediaPlayer) {
//set the media player to begining after completion of audio
                                    mp.seekTo(0);
                                    seekbar.setProgress(0);
                                    seekbar.setMax(0);


                                    play.setEnabled(true);
                                    play.setVisibility(View.VISIBLE);
                                    Pause.setEnabled(false);
                                    Pause.setVisibility(View.GONE);


                                }
                            });

                            play.setEnabled(false);
                            play.setVisibility(View.GONE);
                            Pause.setEnabled(true);
                            Pause.setVisibility(View.VISIBLE);

                        } else {


                            try {

                                if (!mp.isPlaying()) {
                                    PG.dismiss();
                                }

                                mp = new MediaPlayer();
                                mp.setDataSource(AudioLink);
                                mp.prepare();
                                mp.seekTo(SeekValue);
                                mp.start();
                                seekbar.setMax(mp.getDuration());


                            } catch (Exception ex) {
                                ex.printStackTrace();

                            }


                            mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                                @Override
                                public void onCompletion(MediaPlayer mediaPlayer) {

                                    mp.seekTo(0);
                                    seekbar.setProgress(0);
                                    seekbar.setMax(0);


                                    play.setEnabled(true);
                                    play.setVisibility(View.VISIBLE);
                                    Pause.setEnabled(false);
                                    Pause.setVisibility(View.GONE);


                                }
                            });


                            play.setEnabled(false);
                            play.setVisibility(View.GONE);
                            Pause.setEnabled(true);
                            Pause.setVisibility(View.VISIBLE);

                        }


                    }
                }, 100);







               /* Stop.setVisibility(View.VISIBLE);
                Stop.setEnabled(true);*/


            }
        });


        Pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Pausemedia();
                Pause.setEnabled(false);
                Pause.setVisibility(View.GONE);
                play.setEnabled(true);
                play.setVisibility(View.VISIBLE);

            }
        });
      /*  Stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Stopmedia();
                Stop.setEnabled(false);
                Stop.setVisibility(View.GONE);
                play.setEnabled(true);
                play.setVisibility(View.VISIBLE);

            }
        });*/

        SeekThread skt = new SeekThread();
        skt.start();


    }//Oncreate Method


    public void Playmedia() {

        try {

            mp = new MediaPlayer();
            mp.setDataSource(AudioLink);
            mp.prepare();
            mp.start();
            seekbar.setMax(mp.getDuration());

            if (mp.isPlaying()) {
                PG.dismiss();
            }


        } catch (Exception ex) {
            ex.printStackTrace();

        }


    }

    public void Pausemedia() {

        if (mp.isPlaying()) {
            mp.pause();
            SeekValue = mp.getCurrentPosition();
        }


    }


    class SeekThread extends  Thread{

        public  void  run(){

            while (true){
                try{
                    Thread.sleep(1000);
                }catch (Exception ex){
                    ex.printStackTrace();
                }
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if(mp!=null){

                            seekbar.setProgress(mp.getCurrentPosition());

                        }


                    }
                });





            }







        }






    }



}//End of class
