package com.example.rep_6_mediaplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    MediaPlayer mediaPlayer = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mediaPlayer = MediaPlayer.create(this, R.raw.wap);

    }
    public void play(View v){
        if(mediaPlayer != null)
            mediaPlayer.start();
    }

    public void stop(View v){
        if(mediaPlayer != null)
            mediaPlayer.stop();
    }
}
