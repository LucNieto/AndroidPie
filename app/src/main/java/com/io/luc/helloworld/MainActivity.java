package com.io.luc.helloworld;

import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

/**
 * @author Lucio Nieto Bautista
 * CEO at Nieto Industries
 */

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private VideoView myVideoView;
    private Button btnPlayVideo;
    private Button btnPlayMusic;
    private Button btnPauseMusic;
    private MediaPlayer mediaPlayer;

    private MediaController mediaController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myVideoView = findViewById(R.id.myVideoView);
        btnPlayVideo = findViewById(R.id.btnPlayVideo);
        btnPlayVideo.setOnClickListener(MainActivity.this);
        mediaController = new MediaController(MainActivity.this);
        btnPlayMusic.setOnClickListener(MainActivity.this);
        btnPauseMusic.setOnClickListener(MainActivity.this);
        mediaPlayer = MediaPlayer.create(this, R.raw.the_grid);
    }

    @Override
    public void onClick(View v) {
       // text animation
       //TextView txt = findViewById(R.id.testTxt);
       // txt.animate().scaleX(10);

        switch (v.getId()){
            case R.id.btnPlayVideo:
                Uri videoUri = Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.tron);
                myVideoView.setVideoURI(videoUri);
                myVideoView.setMediaController(mediaController);
                myVideoView.start();
            break;
            case R.id.btnPlayMusic:
                mediaPlayer.start();
            break;
            case R.id.btnPauseMusic:
                mediaPlayer.pause();
                break;

        }


    }
}
