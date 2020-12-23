package com.vladimir.myapplication;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface JSONPlaceHolderApi {
    @GET("/dom/search")
    public Call<ID> findId(@Query("api_key") String api_key, @Query("category") Integer category,
                           @Query("realty_type") Integer realty_type, @Query("operation_type") Integer operation_type,
                           @Query("state_id") Integer state_id, @Query("city_id") Integer city_id,
                           @Query("characteristic[246]") Integer uan,
                           @Query("characteristic[235][from]") Integer price_from, @Query("characteristic[235][to]") Integer price_to,
                           @Query("characteristic[209][from]") Integer rooms_from, @Query("characteristic[209][to]") Integer rooms_to,
                           @Query("characteristic[214][from]") Integer area_from, @Query("characteristic[214][to]") Integer area_to,
                           @Query("characteristic[218][from]") Integer kitchen_from, @Query("characteristic[218][to]") Integer kitchen_to,
                           @Query("characteristic[227][from]") Integer floor_from, @Query("characteristic[227][to]") Integer floor_to);

    @GET("/dom/cities/{stateID}")
    public Call<List<City>> getCity(@Path("stateID") int id, @Query("api_key") String api_key);

    @GET("/dom/info/{id}")
    public Call<FindApartmentById> getApartmentById(@Path("id") int id, @Query("api_key") String api_key);
}
