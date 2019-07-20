package com.example.oderapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MenuAdapter extends RecyclerView.Adapter<MenuAdapter.Viewhoder> {
    List<Food> foodList;

    public MenuAdapter(List<Food> foodList) {
        this.foodList = foodList;
    }


    @NonNull
    @Override
    public Viewhoder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_menu, parent, false);
        Viewhoder viewhoder = new Viewhoder(view);

        return viewhoder;
    }

    @Override
    public void onBindViewHolder(@NonNull final Viewhoder holder, final int position) {
        final Food food = foodList.get(position);

        if (food.getCount() > 0) {
            holder.tvCount.setText(Integer.toString(food.getCount()));
            holder.tvCount.setVisibility(View.VISIBLE);
        } else {
            holder.tvCount.setVisibility(View.INVISIBLE);
        }

        holder.btnPlus.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                int nowCount = food.getCount() + 1;
                holder.tvCount.setText(Integer.toString(nowCount));
                holder.tvCount.setVisibility(View.VISIBLE);
                Food.foodList.get(position).setCount(nowCount);
            }
        });

        holder.btnSubtract.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                int nowCount = food.getCount() - 1;
                if (nowCount > 0) {
                    holder.tvCount.setText(Integer.toString(nowCount));
                    holder.tvCount.setVisibility(View.VISIBLE);
                } else if (nowCount == 0) {
                    holder.tvCount.setVisibility(View.INVISIBLE);
                } else {
                    return;
                }
                Food.foodList.get(position).setCount(nowCount);
            }
        });

        switch (food.getId()) {
            case 0:
                holder.ivItem.setImageResource(R.drawable.food1);
                break;
            case 1:
                holder.ivItem.setImageResource(R.drawable.food2);
                break;
            case 2:
                holder.ivItem.setImageResource(R.drawable.food3);
                break;
            case 3:
                holder.ivItem.setImageResource(R.drawable.food4);
                break;
            case 4:
                holder.ivItem.setImageResource(R.drawable.food5);
                break;
            case 5:
                holder.ivItem.setImageResource(R.drawable.food6);
                break;


        }
        holder.tvName.setText(food.getName());
        holder.tvCost.setText(Integer.toString(food.getCost()) + "$");
    }

    @Override
    public int getItemCount() {
        return foodList.size();
    }

    public class Viewhoder extends RecyclerView.ViewHolder {
        Button btnPlus, btnSubtract;
        ImageView ivItem;
        TextView tvCount, tvCost, tvName, tvInfo;

        public Viewhoder(@NonNull View itemView) {
            super(itemView);

            btnPlus = itemView.findViewById(R.id.btnPlus);
            btnSubtract = itemView.findViewById(R.id.btnSubtract);
            ivItem = itemView.findViewById(R.id.ivItem);
            tvCount = itemView.findViewById(R.id.tvCount);
            tvCost = itemView.findViewById(R.id.tvCost);
            tvName = itemView.findViewById(R.id.tvName);
        }
    }
}
