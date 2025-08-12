package com.example.assignment1;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.assignment1.provider.Category;

import java.util.ArrayList;

    public class ListCategoryRecyclerAdapter extends RecyclerView.Adapter<ListCategoryRecyclerAdapter.CustomViewHolder> {

        ArrayList<Category> dataListCategory = new ArrayList<Category>();

        public void setDataListCategory(ArrayList<Category> dataListCategory) {
            this.dataListCategory = dataListCategory;
        }

        @NonNull
        @Override
        public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View categoryView = LayoutInflater.from(parent.getContext()).inflate(R.layout.category_card,parent,false); //CardView inflated as RecyclerView list item
            CustomViewHolder viewHolderCategory = new CustomViewHolder(categoryView);
            return viewHolderCategory;
        }

        @Override
        public void onBindViewHolder(@NonNull CustomViewHolder holderCategory, int position) {

            if(position==0){
                holderCategory.tvCatId.setText("Id");
                holderCategory.tvCatName.setText("Name");
                holderCategory.tvEventCount.setText("Event Count");

            }else {
                holderCategory.tvEventCount.setText(String.valueOf(dataListCategory.get(position-1).getEventCount()));
                holderCategory.tvCatName.setText(String.valueOf(dataListCategory.get(position-1).getCategoryName()));
                holderCategory.tvCatId.setText(dataListCategory.get(position-1).getCatId());
                holderCategory.isCatActive.setText(dataListCategory.get(position-1).isCatActive() ? "Active" : "Inactive");
            }

            // passing value into googleMapsActivity
            holderCategory.cardView.setOnClickListener(v -> {
                String categoryLocation = dataListCategory.get(position-1).getCategoryLocation();
                String categoryName = dataListCategory.get(position-1).getCategoryName();

                // TODO: Launch new MapsActivity with Country Name in extras
                Context context = holderCategory.cardView.getContext();
                Intent intent = new Intent(context, GoogleMapsActivity.class);
                intent.putExtra("categoryLocation", categoryLocation);
                intent.putExtra("categoryName", categoryName);
                context.startActivity(intent);
            });
        }


        @Override
        public int getItemCount() {
           return dataListCategory.size()+1;
        }

        public class CustomViewHolder extends RecyclerView.ViewHolder{
            public TextView tvCatId;
            public TextView tvCatName;
            public TextView tvEventCount;
            public TextView isCatActive;
            public View cardView;

            public CustomViewHolder(@NonNull View itemView){
                super (itemView);
                cardView = itemView;
                tvCatId =  this.itemView.findViewById(R.id.tv_catId);
                tvCatName = this.itemView.findViewById(R.id.tv_catName);
                tvEventCount = this.itemView.findViewById(R.id.tv_eventCount);
                isCatActive = this.itemView.findViewById(R.id.tv_isCatActive);

            }
        }
    }




