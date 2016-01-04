package course.examples.newboston;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;

/**
 * Created by Molham on 12/31/2015.
 */
public class Splash extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.splash);

        MediaPlayer sound = MediaPlayer.create(Splash.this,R.raw.beep);
        sound.start();

        Thread timer = new Thread() {
            public void run() {
                try {
                    this.sleep(1500);
                }catch (InterruptedException e){
                    e.printStackTrace();

                }finally {
                    Intent intent = new Intent("application.MENU");
                    startActivity(intent);
                }
            }
        };
        timer.start();
    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }
}