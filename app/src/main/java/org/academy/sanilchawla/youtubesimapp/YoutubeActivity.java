package org.academy.sanilchawla.youtubesimapp;

import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

public class YoutubeActivity extends YouTubeBaseActivity
                        implements YouTubePlayer.OnInitializedListener{
    static final String GOOGLE_API_KEY="AIzaSyA9MhdyJ1rScBFMNX4FWYvzW0cdmEdT2xU";
    static final String YOUTUBE_VIDEO_ID="NGYW4kNAOpQ";
    static final String YOUTUBE_PLAYLIST="PL5vNCmhoNMAkRXn185KU0nSS0e84hC93B";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_youtube);
        ConstraintLayout layout= (ConstraintLayout)getLayoutInflater().inflate(R.layout.activity_youtube);
        setContentView(layout);

        YouTubePlayerView playerView=new YouTubePlayerView(this);
        playerView.setLayoutParams(new ConstraintLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.MATCH_PARENT));
        layout.addView(playerView);
        playerView.initialize(GOOGLE_API_KEY,);
    }

    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {

    }

    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
        final int REQUEST_CODE=1;
                if(youTubeInitializationResult.isUserRecoverableError())
                {
                    youTubeInitializationResult.getErrorDialog(this,REQUEST_CODE).show();
                }
                else
                {
                    String errTM=String.format("THERE WAS AN ERROR INITIALIZING YOUTUBE (%1$s) ",youTubeInitializationResult.toString());
                    Toast.makeText(this, errTM, Toast.LENGTH_LONG).show();
                }
    }
}
