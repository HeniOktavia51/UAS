package com.example.yanafriyoko.buku.rest;

/**
 * Created by root on 2/3/17.
 */
import com.example.yanafriyoko.buku.model.GetBuku;
import com.example.yanafriyoko.buku.model.PostPutDelBuku;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.HTTP;
import retrofit2.http.POST;
import retrofit2.http.PUT;

public interface ApiInterface {

    @GET("buku")
    Call<GetBuku> getBuku();

    @FormUrlEncoded
    @POST("buku")
    Call<PostPutDelBuku> postBuku(@Field("id_buku") String id_buku,
                                    @Field("nama_buku") String nama_buku,
                                    @Field("harga_buku") String harga_buku,
                                    @Field("total") String total);
    @FormUrlEncoded
    @POST("buku")
    Call<PostPutDelBuku> postBuku2 (@Field("id_buku") String id_buku,
                                    @Field("nama_buku") String nama_buku,
                                    @Field("harga_buku") String harga_buku,
                                    @Field("total") String total);
    @FormUrlEncoded
    @PUT("buku")
    Call<PostPutDelBuku> putBuku(@Field("id_buku") String id_buku,
                                 @Field("nama_buku") String nama_buku,
                                 @Field("harga_buku") String harga_buku,
                                 @Field("total") String total);
    @FormUrlEncoded
    @HTTP(method = "DELETE", path = "buku", hasBody = true)
    Call<PostPutDelBuku> deleteBuku(@Field("id_buku") String id_buku);

}
