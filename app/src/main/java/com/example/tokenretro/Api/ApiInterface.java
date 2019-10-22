package com.example.tokenretro.Api;

import com.example.tokenretro.Model.CoffeeResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiInterface {
    @GET("coffees/{token}")
    Call<List<CoffeeResponse>> getCoffee(@Path("token") String token);

}
