package com.wwdevelopers.dateme.adapters;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;
import com.wwdevelopers.dateme.R;

import java.util.List;

public class GalleyPictureAdapter extends RecyclerView.Adapter<GalleyPictureAdapter.MyViewHolder> {

    private Context mContext;
    private LayoutInflater inflater;
    private List<String> galleryPictures;
    private int previousSelectedPosition = 0;



    public GalleyPictureAdapter(Context ctx, List<String> galleryPictures){

        inflater = LayoutInflater.from(ctx);
        this.mContext = ctx;
        this.galleryPictures = galleryPictures;

    }

    @Override
    public GalleyPictureAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.picture_gallery_item_recycler_item, parent, false);
        GalleyPictureAdapter.MyViewHolder holder = new GalleyPictureAdapter.MyViewHolder(view);
        return holder;

    }

    @Override
    public void onBindViewHolder(final GalleyPictureAdapter.MyViewHolder holder, int position) {


        //holder.item_picture.getDrawable().
        Picasso.get()
                .load(galleryPictures.get(position))
                .placeholder(mContext.getResources().getDrawable(R.drawable.logo))
                .into(holder.item_picture);

    }

    @Override
    public int getItemCount() {
        return galleryPictures.size();
    }

    public Object getItem(int position) {
        return this.galleryPictures.get(position);
    }


    class MyViewHolder extends RecyclerView.ViewHolder{

        ImageView item_picture;

        public MyViewHolder(View itemView) {
            super(itemView);

            item_picture = itemView.findViewById(R.id.item_picture);

        }

    }







}
