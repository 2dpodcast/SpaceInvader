package com.efnez.SpaceInvader;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.view.WindowManager;

/**
 * Created with IntelliJ IDEA.
 * User: Dany
 */
public class SpaceActivity extends Activity {
    private MySpaceView mySpaceView;
    Handler handler = new Handler();
    long fps = 60;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        // Create a instance and set it
        // as the ContentView for this Activity.
        mySpaceView = new MySpaceView(this);
        setContentView(mySpaceView);
        gameLoop();
    }

    private void gameLoop(){

        Runnable loop = new Runnable() {
            @Override
            public void run() {
                mySpaceView.invalidate();
                handler.postDelayed(this, 1000 / fps);
            }
        };

        handler.postDelayed(loop, 1000 / fps);
    }


//    @Override
//    protected void onPause() {
//        // The following call pauses the rendering thread.
//        // If your OpenGL application is memory intensive,
//        // you should consider de-allocating objects that
//        // consume significant memory here.
//        super.onPause();
//        mySpaceView.onPause();
//    }
//
//    @Override
//    protected void onResume() {
//        // The following call resumes a paused rendering thread.
//        // If you de-allocated graphic objects for onPause()
//        // this is a good place to re-allocate them.
//        super.onResume();
//        mySpaceView.onResume();
//    }
}