package com.oguzavanoglu.landmarkjava;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.oguzavanoglu.landmarkjava.databinding.RecyclerRowBinding;

import java.util.ArrayList;


public class LandMarkAdapter extends RecyclerView.Adapter<LandMarkAdapter.LandMarkHolder> {

    ArrayList<Landmark> landmarkArrayList;

    public LandMarkAdapter(ArrayList<Landmark> landmarkArrayList){

        this.landmarkArrayList=landmarkArrayList;
    }
    //binding i yani XML i bağlama işlemini burada yapacağız.
    //inflate() i her gördüğünde xml ile kodu birbirine bağladığımızı düşünün.
    public LandMarkHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        RecyclerRowBinding recyclerRowBinding = RecyclerRowBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);

        return new LandMarkHolder(recyclerRowBinding);
    }

    //ViewHolder sınıfı ile bağlandığında neler olacak kısaca Loyoutumuz içinde hangi verileri görmek istiyorsak onu burada göstereceğiz.
    public void onBindViewHolder(@NonNull LandMarkHolder holder, int position) {

        holder.binding.recyclerViewTextView.setText(landmarkArrayList.get(position).name);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(holder.itemView.getContext(), DetailsActivity.class);
                intent.putExtra("landmark",landmarkArrayList.get(position));
                holder.itemView.getContext().startActivity(intent);
            }
        });

    }


    public int getItemCount() {

        return landmarkArrayList.size();
    }


    //Görünümlerimizi tutan yardımcı bir sınıf

    public class LandMarkHolder extends RecyclerView.ViewHolder{

        private RecyclerRowBinding binding;
        public LandMarkHolder(RecyclerRowBinding binding) {
            super(binding.getRoot());

            this.binding = binding;

        }
    }
}
