package com.nyeintnyeint.talentup1.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.nyeintnyeint.talentup1.R;
import com.nyeintnyeint.talentup1.model.Phone;

import java.util.List;

/**
 * Created by kaungkhantlynn on 10/30/16.
 */
public class PhoneAdapter extends RecyclerView.Adapter<PhoneAdapter.PhoneViewHolder> {
    Context context;
    List<Phone> phoneList;
    PhoneItemClick phoneItemClick;


    public PhoneAdapter(Context context, List<Phone> phoneList, PhoneItemClick phoneItemClick) {
        this.context = context;
        this.phoneList = phoneList;
        this.phoneItemClick = phoneItemClick;
    }

    @Override
    public PhoneViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.phone_card, parent, false);
        return new PhoneViewHolder(view);
    }

    @Override
    public void onBindViewHolder(PhoneViewHolder holder, int position) {
        holder.txtBrand.setText(phoneList.get(position).getPhone_brand());
        holder.txtOs.setText(phoneList.get(position).getOs_version());
        holder.txtPrice.setText(phoneList.get(position).getEstimate_price());

        Glide.with(context).load(phoneList.get(position).getImage1())
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(holder.imgPhone);
    }

    @Override
    public int getItemCount() {
        return phoneList.size();
    }

    public class PhoneViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        ImageView imgPhone;
        TextView txtBrand,txtOs,txtPrice;
        public PhoneViewHolder(View itemView) {
            super(itemView);

            imgPhone=(ImageView)itemView.findViewById(R.id.phone_img);
            txtBrand=(TextView)itemView.findViewById(R.id.txt_brand_name);
            txtOs=(TextView)itemView.findViewById(R.id.txt_os);
            txtPrice=(TextView)itemView.findViewById(R.id.txt_price);
            itemView.setOnClickListener(this);


        }

        @Override
        public void onClick(View view) {
            phoneItemClick.OnItemClick(phoneList.get(getLayoutPosition()));
        }
    }

    public static interface PhoneItemClick{
        public void OnItemClick(Phone itemClicked);
    }
}
