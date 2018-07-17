package com.example.yanafriyoko.buku.model;

import com.google.gson.annotations.SerializedName;

public class PostPutDelBuku {
    @SerializedName("status")
    String status;
    @SerializedName("result")
    Buku mBuku;
    @SerializedName("message")
    String message;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Buku getmBuku() {
        return mBuku;
    }

    public void setmBuku(Buku buku) {
        mBuku = buku;
    }
}
