package com.fcodex.ecommerce.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.fcodex.ecommerce.R;
import com.smarteist.autoimageslider.SliderViewAdapter;

public class ImageSliderAdapter extends SliderViewAdapter<ImageSliderAdapter.ImageSlider> {
    Context context;
    int[] images;

    public ImageSliderAdapter(Context context, int[] images) {
        this.context = context;
        this.images = images;
    }

    @Override
    public ImageSlider onCreateViewHolder(ViewGroup parent) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_image_slider, null);
        return new ImageSlider(inflate);
    }

    @Override
    public void onBindViewHolder(ImageSlider viewHolder, final int position) {

        viewHolder.image_slider_view.setImageResource(images[position]);
        viewHolder.image_slider_view.setOnClickListener(v -> Toast.makeText(context, "This is item in position " + position, Toast.LENGTH_SHORT).show());
    }

    @Override
    public int getCount() {
        return 2;
    }

    public class ImageSlider extends SliderViewAdapter.ViewHolder {

        ImageView image_slider_view;

        public ImageSlider(View itemView) {
            super(itemView);

            image_slider_view = itemView.findViewById(R.id.image_slider_view);

        }
    }
}
