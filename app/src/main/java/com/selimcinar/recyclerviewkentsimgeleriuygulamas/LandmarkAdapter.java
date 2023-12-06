package com.selimcinar.recyclerviewkentsimgeleriuygulamas;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.renderscript.ScriptGroup;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.selimcinar.recyclerviewkentsimgeleriuygulamas.databinding.RecyclerRowBinding;

import java.util.ArrayList;

public class LandmarkAdapter extends RecyclerView.Adapter<LandmarkAdapter.LandmarkHolder> {
    ArrayList<Landmark> landmarkArrayList;

    public LandmarkAdapter(ArrayList<Landmark> landmarkArrayList) {
        this.landmarkArrayList = landmarkArrayList;
    }

    @NonNull
    @Override
    public LandmarkHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       //View holder sınıfından obje oluştuğunda çağrılacak metot
      RecyclerRowBinding recyclerRowBinding=RecyclerRowBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        return new LandmarkHolder(recyclerRowBinding) ;
    }

    @Override
    public void onBindViewHolder(@NonNull LandmarkAdapter.LandmarkHolder holder, @SuppressLint("RecyclerView") int position) {
        //Görünümler içinde ne olacağını yazar.
        holder.binding.recyclerViewText.setText(landmarkArrayList.get(position).name);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(holder.itemView.getContext(),DetailsActivity.class);
             //   intent.putExtra("landmark",landmarkArrayList.get(position));
               Singleton singleton =Singleton.getInstance();
               singleton.setSentLandmark(landmarkArrayList.get(position));
                holder.itemView.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        //Kaç tane xml olacağını tutar Veri olacağını tutar
        return landmarkArrayList.size();//ArrayList boyutu kadar dön
    }

    //View holder görünüm tutucu sınıf
public  class  LandmarkHolder extends RecyclerView.ViewHolder{

       private RecyclerRowBinding binding;

    public LandmarkHolder(RecyclerRowBinding binding) {
        super(binding.getRoot());
        this.binding=binding;
    }
}
}
