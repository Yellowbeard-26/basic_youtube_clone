package com.example.youtubeapi;

import android.os.Bundle;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.constraintlayout.widget.ConstraintLayout;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

public class YoutubeActivity extends YouTubeBaseActivity implements YouTubePlayer.OnInitializedListener {
    private static final String TAG = "YoutubeActivity";
    
    public static final String GoogleApiKey="AIzaSyAPHignDftJRxCbUkzgBPxGQify0YSntos";
    public static final String Video_id="usowioeF5Xg";
    public static final String Playlist_id="RDMMusowioeF5Xg";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_youtube);
        ConstraintLayout layout=(ConstraintLayout) findViewById(R.id.you);

        YouTubePlayerView playerView=new YouTubePlayerView(this);
        playerView.setLayoutParams(new ConstraintLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        layout.addView(playerView);
        playerView.initialize(GoogleApiKey,this);

    }


    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean wasRestored) {
        Log.d(TAG, "onInitializationSuccess: provider is "+provider.getClass().toString());
        Toast.makeText(this,"Initialized Youtube Player Succesfully",Toast.LENGTH_LONG);

        youTubePlayer.setPlaybackEventListener(playbackEventListener);
        youTubePlayer.setPlayerStateChangeListener(playerStateChangeListener);

        if(!wasRestored)
        {
            youTubePlayer.cueVideo(Video_id);
        }


    }

    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {

        final int Request_Code=1;

        if(youTubeInitializationResult.isUserRecoverableError())
        {
            youTubeInitializationResult.getErrorDialog(this,Request_Code).show();
        }
        else
        {
            String error=String.format("There was an error initializing thr Youtube player (%1$s)",youTubeInitializationResult.toString());
            Toast.makeText(this,error,Toast.LENGTH_LONG).show();

        }


    }
    private YouTubePlayer.PlaybackEventListener playbackEventListener=new YouTubePlayer.PlaybackEventListener() {
        @Override
        public void onPlaying() {
            Toast.makeText(YoutubeActivity.this,"playing video",Toast.LENGTH_LONG).show();

        }

        @Override
        public void onPaused() {
            Toast.makeText(YoutubeActivity.this,"Video Paused",Toast.LENGTH_LONG).show();

        }

        @Override
        public void onStopped() {

            Toast.makeText(YoutubeActivity.this,"Video stopped",Toast.LENGTH_LONG).show();
        }

        @Override
        public void onBuffering(boolean b) {

        }

        @Override
        public void onSeekTo(int i) {

        }
    };
    private YouTubePlayer.PlayerStateChangeListener playerStateChangeListener=new YouTubePlayer.PlayerStateChangeListener() {
        @Override
        public void onLoading() {
            Toast.makeText(YoutubeActivity.this,"Loading video",Toast.LENGTH_LONG).show();
        }

        @Override
        public void onLoaded(String s) {


        }

        @Override
        public void onAdStarted() {

            Toast.makeText(YoutubeActivity.this,"Ad has been started",Toast.LENGTH_LONG).show();
        }

        @Override
        public void onVideoStarted() {

            Toast.makeText(YoutubeActivity.this,"playing video",Toast.LENGTH_LONG).show();
        }

        @Override
        public void onVideoEnded() {

        }

        @Override
        public void onError(YouTubePlayer.ErrorReason errorReason) {

        }
    };

}