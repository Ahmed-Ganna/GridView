package com.ganna.gridview;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import java.util.ArrayList;


public class MainActivity extends Activity implements AdapterView.OnItemClickListener{
   private ArrayList<String> ImagePath ;
   private GridView gridView ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gridView = (GridView) findViewById(R.id.gridview);
        gridView.setOnItemClickListener(this);
        ImagePath = new ArrayList<>();
        // Get images paths
        ContentResolver contentResolver = getContentResolver();
        Uri uri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
        Cursor cursor = contentResolver.query(uri, null, null, null, null);
        if (cursor != null) {
            cursor.moveToFirst();
            do {
                String path = cursor.getString(cursor.getColumnIndex(MediaStore.Images.Media.DATA));
                ImagePath.add(path);
            }while (cursor.moveToNext());
            // Adapter class extends Array Adapter , review the class
            ImageAdapter adapter = new ImageAdapter(this,ImagePath);
            gridView.setAdapter(adapter);
        }


    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        Intent i = new Intent(this,ImageActivity.class);
        // get path for current image
        String path = ImagePath.get(position);
        i.putExtra("path",path);
        startActivity(i);
    }
}
