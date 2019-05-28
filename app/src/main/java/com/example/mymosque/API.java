package com.example.mymosque;

import com.example.mymosque.Adapter.DuaArrayList;
import com.example.mymosque.Adapter.Links;
import com.example.mymosque.Adapter.LinksArrayList;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface API {


    @GET("Duas?")
    Call<DuaArrayList> getduas(@Query("page=") int page);
    @GET("Duas")
    Call<String> getlinks();
}
