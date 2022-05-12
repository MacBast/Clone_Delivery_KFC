package com.example.appkfc.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.appkfc.Entities.Product;
import com.example.appkfc.MainActivity;
import com.example.appkfc.ProductosActivity;
import com.example.appkfc.Services.ListProducts;
import com.example.appkfc.Services.LoginService;
import com.example.appkfc.databinding.ProductItemBinding;
import com.example.appkfc.models.ListProductsModel;
import com.example.appkfc.models.LoginRequest;
import com.example.appkfc.register2;
import com.example.appkfc.sesion;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder>{

    private Context context;
    private ProductItemBinding productItemBinding;
    private ArrayList<ListProductsModel> productArrayList;
    private ArrayList producto;
    private String Url;
    private Retrofit retrofit;

    public ProductAdapter(ProductosActivity context, ArrayList<ListProductsModel> productArrayList){
        this.context=context;
        this.productArrayList= productArrayList;
        retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.1.6/Api_res/features/").addConverterFactory(GsonConverterFactory.create())
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
     ListProductsModel product= productArrayList.get(position);

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

    public void comprar(ListProductsModel product){

        ListProducts listProducts = retrofit.create(ListProducts.class);
        Call<String> listar = listProducts.compra(product);
        listar.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {

            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {

            }
        });

    }
}
