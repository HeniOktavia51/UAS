package com.example.yanafriyoko.buku.activity;


import android.content.Intent;
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

public class EditActivity extends AppCompatActivity {
    private Button btnEdit,btnHapus;
    private EditText etIdBuku,etNamaBuku,etHargaBuku,etTotal;
    ApiInterface mApiInterface;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
        etIdBuku = (EditText) findViewById(R.id.idBukuEdit);
        etNamaBuku = (EditText) findViewById(R.id.edNamaEdit);
        etHargaBuku = (EditText) findViewById(R.id.etHargaEdit);
        etTotal = (EditText) findViewById(R.id.etTotalEdit);
        btnEdit=(Button)findViewById(R.id.btnEdit);
        btnHapus=(Button)findViewById(R.id.btnHapus);
        Intent mIntent = getIntent();
        etIdBuku.setText(mIntent.getStringExtra("id_buku"));
        etIdBuku.setTag(etIdBuku.getKeyListener());
        etIdBuku.setKeyListener(null);
        etNamaBuku.setText(mIntent.getStringExtra("nama_buku"));
        etHargaBuku.setText(mIntent.getStringExtra("harga_buku"));
        etTotal.setText(mIntent.getStringExtra("total"));
        mApiInterface = ApiClient.getClient().create(ApiInterface.class);
        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Call<PostPutDelBuku> updateKontakCall = mApiInterface.putBuku(
                        etIdBuku.getText().toString(),
                        etNamaBuku.getText().toString(),
                        etHargaBuku.getText().toString(),
                        etTotal.getText().toString());
                updateKontakCall.enqueue(new Callback<PostPutDelBuku>() {
                    @Override
                    public void onResponse(Call<PostPutDelBuku> call, Response<PostPutDelBuku> response) {
                        Toast.makeText(getApplicationContext(), "Edit Berhasil", Toast.LENGTH_LONG).show();
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

        btnHapus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (etIdBuku.getText().toString().trim().isEmpty()==false){
                    Call<PostPutDelBuku> deleteJenis = mApiInterface.deleteBuku(etIdBuku.getText().toString());
                    deleteJenis.enqueue(new Callback<PostPutDelBuku>() {
                        @Override
                        public void onResponse(Call<PostPutDelBuku> call, Response<PostPutDelBuku> response) {
                            Toast.makeText(getApplicationContext(), "Delete Berhasil", Toast.LENGTH_SHORT).show();
                            MainActivity.ma.refresh();
                            finish();
                        }

                        @Override
                        public void onFailure(Call<PostPutDelBuku> call, Throwable t) {
                            Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_SHORT).show();
                        }
                    });
                }else{
                    Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_LONG).show();
                }
            }
        });

    }
}
