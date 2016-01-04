package course.examples.newboston;

import android.app.Activity;
import android.app.WallpaperManager;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.opengl.EGLExt;
import android.os.Bundle;
import android.provider.MediaStore; // capture image
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import java.io.IOException;

/**
 * Created by Molham on 1/2/2016.
 */
public class UsingCamera extends Activity implements View.OnClickListener {

    //linking Widget
    ImageView iv;
    ImageButton ib;
    Button b;

    //local variables
    final static int cameraData=0;
    Bitmap bitmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.using_camera);
        init();
    }

    private void init() {
        iv = (ImageView)findViewById(R.id.ivReturned);
        ib = (ImageButton)findViewById(R.id.ibCamera);
        b = (Button)findViewById(R.id.bSetWallpaper);

        ib.setOnClickListener(this);
        b.setOnClickListener(this);

        //setting default value fot the bitmap
        bitmap = BitmapFactory.decodeStream(getResources().openRawResource(+R.mipmap.ic_launcher));
    }


    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.ibCamera:
                Intent i = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(i,cameraData);
                break;

            case R.id.bSetWallpaper:
                WallpaperManager  manager =  WallpaperManager.getInstance(getApplicationContext());
                try {
                    manager.setBitmap(bitmap);
                } catch (IOException e) {
                    e.printStackTrace();
                }//catch (Exception e){
                   // e.printStackTrace();
                //}


//                getApplicationContext().setWallpaper();
                break;
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == RESULT_OK)
        {
            Bundle bundle= data.getExtras();
            bitmap= (Bitmap)bundle.get("data");
            iv.setImageBitmap(bitmap);
        }
    }


}
