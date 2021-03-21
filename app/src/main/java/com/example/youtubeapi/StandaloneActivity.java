package com.example.youtubeapi;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.youtube.player.YouTubeStandalonePlayer;

public class StandaloneActivity extends AppCompatActivity implements View.OnClickListener {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.standalonesubmenu);

        Button btnplay = (Button) findViewById(R.id.btnplayvid);
        Button btnlist = (Button) findViewById(R.id.btnplayplaylst);

        btnplay.setOnClickListener(this);
        btnlist.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Intent intent=null;
        switch(v.getId()) {
            case R.id.btnplayplaylst: {
                intent = YouTubeStandalonePlayer.createPlaylistIntent(this, YoutubeActivity.GoogleApiKey, YoutubeActivity.Playlist_id);
                break;

            }
            case R.id.btnplayvid: {
                intent = YouTubeStandalonePlayer.createVideoIntent(this, YoutubeActivity.GoogleApiKey, YoutubeActivity.Video_id);
                break;
            }
            default:

        }
            if(intent!=null)
            {
                startActivity(intent);
            }
        }
    }

