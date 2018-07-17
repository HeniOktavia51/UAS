package com.example.yanafriyoko.buku.activity;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.yanafriyoko.buku.R;
import com.example.yanafriyoko.buku.model.PostPutDelBuku;
import com.example.yanafriyoko.buku.rest.ApiClient;
import com.example.yanafriyoko.buku.rest.ApiInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TambahActivity extends AppCompatActivity {
    EditText idBukuTambah,namaBukuTambah,hargaBukuTambah,totalBukuTambah;
    Button btnSimpan;
    ApiInterface mApiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah);
        idBukuTambah = (EditText) findViewById(R.id.idBukuTambah);
        namaBukuTambah = (EditText) findViewById(R.id.edNamaTambah);
        hargaBukuTambah = (EditText) findViewById(R.id.etHargaTambah);
        totalBukuTambah = (EditText) findViewById(R.id.etTotalTambah);
        mApiInterface = ApiClient.getClient().create(ApiInterface.class);
        btnSimpan=(Button)findViewById(R.id.btnTambah);
        btnSimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Call<PostPutDelBuku> putDelBukuCall = mApiInterface.postBuku2(idBukuTambah.getText().toString(), namaBukuTambah.getText().toString(), hargaBukuTambah.getText().toString(), totalBukuTambah.getText().toString());
                putDelBukuCall.enqueue(new Callback<PostPutDelBuku>() {
                    @Override
                    public void onResponse(Call<PostPutDelBuku> call, Response<PostPutDelBuku> response) {
                        Toast.makeText(getApplicationContext(), "Sukses", Toast.LENGTH_SHORT).show();
                        MainActivity.ma.refresh();
                        finish();

                    }

                    @Override
                    public void onFailure(Call<PostPutDelBuku> call, Throwable t) {
                        Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_LONG).show();

                    }
                });
            }
        });
//        btnSimpan.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Call<PostPutDelBuku> postBukuCall = mApiInterface.postBuku(
//                        idBukuTambah.getText().toString(),
//                        namaBukuTambah.getText().toString(),
//                        hargaBukuTambah.getText().toString(),
//                        totalBukuTambah.getText().toString());
//                postBukuCall.enqueue(new Callback<PostPutDelBuku>() {
//                    @Override
//                    public void onResponse(Call<PostPutDelBuku> call, Response<PostPutDelBuku> response) {
//                        Toast.makeText(getApplicationContext(), "Sukses", Toast.LENGTH_SHORT).show();
//                        MainActivity.ma.refresh();
//                        finish();
//                    }
//
//                    @Override
//                    public void onFailure(Call<PostPutDelBuku> call, Throwable t) {
//                        Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_LONG).show();
//                    }
//                });
//            }
//        });

    }
}
