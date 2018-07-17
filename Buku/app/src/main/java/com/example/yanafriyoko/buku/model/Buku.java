package com.example.yanafriyoko.buku.model;

import com.google.gson.annotations.SerializedName;

public class Buku {
    @SerializedName("id_buku")
    private String id_buku;
    @SerializedName("nama_buku")
    private String nama_buku;
    @SerializedName("harga_buku")
    private String harga_buku;
    @SerializedName("total")
    private String total;

    public Buku() {
    }

    public Buku(String id_buku, String nama_buku, String harga_buku, String total) {
        this.id_buku = id_buku;
        this.nama_buku = nama_buku;
        this.harga_buku = harga_buku;
        this.total = total;
    }

    public String getId_buku() {
        return id_buku;
    }

    public void setId_buku(String id_buku) {
        this.id_buku = id_buku;
    }

    public String getNama_buku() {
        return nama_buku;
    }

    public void setNama_buku(String nama_buku) {
        this.nama_buku = nama_buku;
    }
    public String getHarga_buku() {
        return harga_buku;
    }

    public void setHarga_buku(String harga_buku) {
        this.harga_buku = harga_buku;
    }
    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }
}
