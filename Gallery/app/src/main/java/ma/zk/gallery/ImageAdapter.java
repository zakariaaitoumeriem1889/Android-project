package ma.zk.gallery;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;

public class ImageAdapter extends BaseAdapter {

    private int GItemBackground;
    private Context context;
    private int[] Img = {R.drawable.image1, R.drawable.image2, R.drawable.image3, R.drawable.image4};

    public ImageAdapter(Context c) {
        context = c;
    }

    @Override
    public int getCount() {
        return Img.length;
    }

    @Override
    public Object getItem(int position) {
        return Img[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView i = new ImageView(context);
        i.setImageResource(Img[position]);
        i.setLayoutParams(new Gallery.LayoutParams(ViewGroup.LayoutParams.FILL_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        i.setScaleType(ImageView.ScaleType.FIT_XY);
        return i;
    }
}
