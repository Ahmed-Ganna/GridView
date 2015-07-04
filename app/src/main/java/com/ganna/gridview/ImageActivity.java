package com.ganna.gridview;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;


public class ImageActivity extends Activity {

    final BitmapFactory.Options options = new BitmapFactory.Options();
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_image);
        imageView = (ImageView) findViewById(R.id.image_view);
        String path = getIntent().getStringExtra("path");
        // convert path into Bitmap image
        Bitmap bm = BitmapFactory.decodeFile(path,options);
        imageView.setImageBitmap(bm);
    }


}
