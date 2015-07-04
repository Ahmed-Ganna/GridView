package com.ganna.gridview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import java.util.List;

/**
 * Created by Ahmed on 03/07/2015.
 */
public class ImageAdapter extends ArrayAdapter {

    public ImageAdapter(Context context, List<String> objects) {
        super(context, 0, objects);

    }

    // to avoid outOfMemory exception
    final BitmapFactory.Options options = new BitmapFactory.Options();

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
         class ViewHolder{
            public ImageView imageView ;
        }
        ViewHolder v = new ViewHolder();
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.item_image, null);
            v.imageView = (ImageView) convertView.findViewById(R.id.image_view);
            convertView.setTag(v);
        }

       v = (ViewHolder) convertView.getTag();

        String path = (String) getItem(position);

        // requests the decoder to subsample the original image, returning a smaller image to save memory
        // For example, inSampleSize == 2 returns an image that is 1/2 the width/height of the original
        options.inSampleSize = 2;
        // convert path into Bitmap image
        Bitmap bm = BitmapFactory.decodeFile(path,options);
        v.imageView.setImageBitmap(bm);

        return convertView;
    }
}
