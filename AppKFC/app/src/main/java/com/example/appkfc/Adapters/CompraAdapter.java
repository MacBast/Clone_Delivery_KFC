package com.example.appkfc.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;

import com.bumptech.glide.Glide;
import com.example.appkfc.Compra;
import com.example.appkfc.databinding.CompraItemBinding;
import com.example.appkfc.databinding.ProductItemBinding;
import com.example.appkfc.models.ListProductsModel;

import java.util.ArrayList;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CompraAdapter extends RecyclerView.Adapter<CompraAdapter.CompraViewHolder> {

private Context context;
private CompraItemBinding productItemBinding;
private ArrayList<ListProductsModel> productArrayList;
private String url,enpoint;
private Retrofit retrofit;
private ViewBinding jb;


public CompraAdapter(Context context, ArrayList<ListProductsModel> productArrayList){
        this.context = context;
        this.productArrayList = productArrayList;
        retrofit = new Retrofit.Builder()
        .baseUrl("http://192.168.1.6/Api_res/features/").addConverterFactory(GsonConverterFactory.create())
        .build();
        }

@NonNull
@Override
//cada vez que se va a crear un elemento . oncreat del mainactivity
public CompraViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        productItemBinding = CompraItemBinding.inflate(LayoutInflater.from(context));
        return new CompraViewHolder(productItemBinding);
        }


//onbindviewholder recorre el ciclo del arraylist
@Override
public void onBindViewHolder(@NonNull CompraViewHolder holder, int position) {

        ListProductsModel product = productArrayList.get(position);

        Toast.makeText(context, product.getId_product(), Toast.LENGTH_SHORT).show();
        holder.itemBinding.NombreFroducto.setText(product.getName());
        holder.itemBinding.Descripcion.setText(product.getDescripcion());
        holder.itemBinding.Precio.setText(product.getPrice());
        url = product.getImage();
        Glide.with(context).load(url).into(holder.itemBinding.Imagen);

        }
@Override
public int getItemCount() {
        return productArrayList.size();
        }
    public class CompraViewHolder extends RecyclerView.ViewHolder {

        CompraItemBinding itemBinding;
        public CompraViewHolder(@NonNull CompraItemBinding itemBinding) {
            super(itemBinding.getRoot());
            this.itemBinding = itemBinding;
        }
    }

}
