package com.wwdevelopers.dateme.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;
import com.wwdevelopers.dateme.R;
import com.wwdevelopers.dateme.interfaces.RecyclerClickListener;
import com.wwdevelopers.dateme.models.UserModel;

import java.util.List;

public class UsersAdapter extends RecyclerView.Adapter<UsersAdapter.MyViewHolder> {

    private Context mContext;
    private LayoutInflater inflater;
    private List<UserModel> userModels;
    private RecyclerClickListener userClickListener;


    public UsersAdapter(Context ctx, List<UserModel> userModels, RecyclerClickListener userClickListener){

        inflater = LayoutInflater.from(ctx);
        this.mContext = ctx;
        this.userModels = userModels;
        this.userClickListener = userClickListener;

    }

    @Override
    public UsersAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView = inflater.inflate(R.layout.user_item_layout, parent, false);
        UsersAdapter.MyViewHolder mViewHolder = new UsersAdapter.MyViewHolder(itemView);

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                userClickListener.onItemClick(v,mViewHolder.getAdapterPosition());

            }
        });

        return mViewHolder;

    }

    @Override
    public void onBindViewHolder(final UsersAdapter.MyViewHolder holder, int position) {

        holder.user_distance.setText(userModels.get(position).getDistance());
        holder.user_name_age.setText(userModels.get(position).getFullname()+", "+userModels.get(position).getAge());

        if(userModels.get(position).isOnline()) {
            holder.user_status_indicator.setBackgroundColor(mContext.getResources().getColor(R.color.colorOnline));
        }else {
            holder.user_status_indicator.setBackgroundColor(mContext.getResources().getColor(R.color.colorOffline));
        }

        //holder.item_picture.getDrawable().
        Picasso.get()
                .load(userModels.get(position).getPicture_url())
                .placeholder(mContext.getResources().getDrawable(R.drawable.logo))
                .into(holder.user_profile_picture);

    }

    @Override
    public int getItemCount() {
        return userModels.size();
    }

    public Object getItem(int position) {
        return this.userModels.get(position);
    }


    class MyViewHolder extends RecyclerView.ViewHolder{

        TextView user_distance;
        TextView user_name_age;
        ImageView user_profile_picture;
        ImageView user_status_indicator;

        public MyViewHolder(View itemView) {
            super(itemView);

            user_distance = itemView.findViewById(R.id.user_distance);
            user_name_age = itemView.findViewById(R.id.user_name_age);
            user_profile_picture = itemView.findViewById(R.id.user_profile_picture);
            user_status_indicator = itemView.findViewById(R.id.user_status_indicator);

        }

    }







}
