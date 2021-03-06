package com.arijit.pro;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.view.MenuItem;
import android.widget.ImageView;

public class ShowImage extends Activity  {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();

        // BitmapFactory.Options options = new BitmapFactory.Options();
        // options.inJustDecodeBounds = true;
        // BitmapFactory.decodeResource(getResources(), R.drawable.sample_0, options);
        // int imageHeight = options.outHeight;
        // int imageWidth = options.outWidth;
        // String imageType = options.outMimeType;
        // int samplesize = calculateInSampleSize(options, 50, 50);
        // options.inJustDecodeBounds = false;
        // options.inSampleSize = samplesize;

        // Get the image to display
        long photo_id = intent.getLongExtra("photo_id", -1);
        Bitmap myimage = BitmapFactory.decodeResource(getResources(), (int)photo_id, null);

        // Cteate the Image view
        ImageView mImageView = new ImageView(this);
        mImageView.setImageBitmap(myimage);

        // Set the text view as the activity layout
        setContentView(mImageView);

        // Insert the back button 
        getActionBar().setDisplayHomeAsUpEnabled(true);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
        // Respond to the action bar's Up/Home button
        case android.R.id.home:
            NavUtils.navigateUpFromSameTask(this);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public static int calculateInSampleSize(BitmapFactory.Options options, int reqWidth, int reqHeight) {
        // Raw height and width of image
        final int height = options.outHeight;
        final int width = options.outWidth;
        int inSampleSize = 1;

        if (height > reqHeight || width > reqWidth) {

            final int halfHeight = height / 2;
            final int halfWidth = width / 2;

            // Calculate the largest inSampleSize value that is a power of 2 and keeps both
            // height and width larger than the requested height and width.
            while ((halfHeight / inSampleSize) > reqHeight
                    && (halfWidth / inSampleSize) > reqWidth) {
                inSampleSize *= 2;
            }
        }
        return inSampleSize;
    }
}