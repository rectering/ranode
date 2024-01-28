package com.rectering.ranode.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.rectering.ranode.Activity.DetailActivity;
import com.rectering.ranode.Domain.PropertyDomain;
import com.rectering.ranode.databinding.RecommendedViewholderBinding;

import java.util.ArrayList;

public class RecommendedAdapter extends RecyclerView.Adapter<RecommendedAdapter.Viewholdel> {
    ArrayList<PropertyDomain> items;
    Context context;
    RecommendedViewholderBinding binding;

    public RecommendedAdapter(ArrayList<PropertyDomain> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public RecommendedAdapter.Viewholdel onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        binding = RecommendedViewholderBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        context = parent.getContext();
        return new Viewholdel(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull RecommendedAdapter.Viewholdel holder, int position) {
        binding.titleTxt.setText(items.get(position).getTitle());
        binding.priceTxt.setText("$" + items.get(position).getPrice());
        binding.typeTxt.setText(items.get(position).getType());
        binding.addressTxt.setText(items.get(position).getAddress());
        binding.scoreTxt.setText("" + items.get(position).getScore());

        int drawableResourceId = holder.itemView.getResources()
                .getIdentifier(items.get(position).getPicPath(), "drawable", holder.itemView.getContext().getPackageName());

        Glide.with(context)
                .load(drawableResourceId)
                .into(binding.pic);

        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(context, DetailActivity.class);
            intent.putExtra("object", items.get(position));
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class Viewholdel extends RecyclerView.ViewHolder {
        public Viewholdel(RecommendedViewholderBinding binding) {
            super(binding.getRoot());
        }
    }
}
