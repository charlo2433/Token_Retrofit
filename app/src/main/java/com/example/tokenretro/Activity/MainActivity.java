package com.example.tokenretro.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.tokenretro.Api.ApiClient;
import com.example.tokenretro.Api.ApiInterface;
import com.example.tokenretro.App;
import com.example.tokenretro.Model.CoffeeResponse;
import com.example.tokenretro.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private TextView txtCoffee;
    private ApiInterface apiInterface;
    private App app;
    //private CoffeeResponse response;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtCoffee = findViewById(R.id.coffee);
        apiInterface = ApiClient.getRetrofitInstance().create(ApiInterface.class);
        app = (App) getApplicationContext();

        init();
        showCoffee();
    }

    private void init(){

    }

    private void showCoffee(){
        Call<List<CoffeeResponse>> call = apiInterface.getCoffee();//please access the token for me please
        call.enqueue(new Callback<List<CoffeeResponse>>() {
            @Override
            public void onResponse(Call<List<CoffeeResponse>> call, Response<List<CoffeeResponse>> response) {

                if(response.isSuccessful()){
                    CoffeeResponse coffeeResponse = (CoffeeResponse) response.body();
                    txtCoffee.setText(coffeeResponse.getName());
                }
            }

            @Override
            public void onFailure(Call<List<CoffeeResponse>> call, Throwable t) {

            }
        });
    }
}
