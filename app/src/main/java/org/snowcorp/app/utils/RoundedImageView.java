package org.snowcorp.app.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;



public class RoundedImageView extends ImageView {
    public RoundedImageView(Context context) {
        super(context);
    }

    public RoundedImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public RoundedImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public void setLayerType(int layerType, Paint paint) {
        super.setLayerType(layerType, paint);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Drawable drawable = getDrawable();

        if (drawable == null) {
            return;
        }

        if (getWidth() == 0 || getHeight() == 0) {
            return;
        }
        Bitmap bitmap = ((BitmapDrawable) drawable).getBitmap();

        int w = getWidth(), h = getHeight();

        Bitmap roundBitmap = getImg(bitmap, w, h);
        canvas.drawBitmap(roundBitmap, 0, 0, null);
    }


    public Bitmap getImg(Bitmap bit, int bit_width, int bit_height) {
        Bitmap dup;
        double ratio = bit.getWidth() / bit.getHeight();
        double height = bit_width / ratio;
        if (ratio == 0 || height == 0)
            dup = Bitmap.createScaledBitmap(bit, bit_width, bit_height, false);
        else
            dup = Bitmap.createScaledBitmap(bit, bit_width, (int) height, false);
        Bitmap bitmap1 = Bitmap.createBitmap(bit_width, bit_height, Bitmap.Config.ARGB_8888);

        Canvas canvas = new Canvas(bitmap1);
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.FILL);
        paint.setAntiAlias(true);
        paint.setColor(Color.RED);

        canvas.drawCircle(bit_width / 2, bit_width / 2, bit_width / 2, paint);

        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(dup, 0, 0, paint);

        return bitmap1;
    }
}
