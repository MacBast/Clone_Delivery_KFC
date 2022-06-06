package com.example.appkfc.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.appkfc.ProductosActivity;

import com.example.appkfc.Services.ListProducts1;
import com.example.appkfc.databinding.ProductItemBinding;

import com.example.appkfc.models.ListProductsModel1;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder>{

    private Context context;
    private ProductItemBinding productItemBinding;
    private ArrayList<ListProductsModel1> productArrayList;
    private ArrayList producto;
    private String Url;
    private Retrofit retrofit;

    public ProductAdapter(ProductosActivity context, ArrayList<ListProductsModel1> productArrayList){
        this.context=context;
        this.productArrayList= productArrayList;
        retrofit = new Retrofit.Builder()
                .baseUrl("http://54.197.21.179/features/").addConverterFactory(GsonConverterFactory.create())
                .build();
    }
    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        productItemBinding= ProductItemBinding.inflate(LayoutInflater.from(context));
        return new ProductViewHolder(productItemBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
     ListProductsModel1 product= productArrayList.get(position);

     holder.itemBinding.NombreFroducto.setText(product.getName());
     holder.itemBinding.Descripcion.setText(product.getDescripcion());
     holder.itemBinding.Precio.setText(product.getPrice());
     Url = product.getImage();
     Glide.with(context).load(Url).into(holder.itemBinding.Imagen);

    holder.itemBinding.BtnAAdir.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            comprar(product);
        }
    });
    }

    @Override
    public int getItemCount() {
        return productArrayList.size();
    }

    public class ProductViewHolder extends RecyclerView.ViewHolder {
        ProductItemBinding itemBinding;

        public ProductViewHolder(@NonNull ProductItemBinding itemBinding) {
            super(itemBinding.getRoot());
            this.itemBinding= itemBinding;
        }
    }

    public void comprar(ListProductsModel1 product){

        ListProducts1 listProducts = retrofit.create(ListProducts1.class);
        Call<String> listar = listProducts.compra(product);
       // Toast.makeText(context, ""+product.getId_product(), Toast.LENGTH_SHORT).show();
        listar.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                Toast.makeText(context, ""+response.body(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {

            }
        });

    }
}
