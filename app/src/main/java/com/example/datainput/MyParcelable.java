package com.example.datainput;

import android.app.ActionBar;
import android.os.Parcel;
import android.os.Parcelable;

public class MyParcelable implements Parcelable {
    String nama;
    String nim;
    String tgllahir;
    String jeniskelamin;
    String jurusan;



    protected MyParcelable(Parcel in) {
        this.nama = in.readString();
        this.nim = in.readString();
        this.tgllahir = in.readString();
        this.jeniskelamin = in.readString();
        this.jurusan = in.readString();
    }

    public MyParcelable(String nama, String nim, String tgllahir, String jeniskelamin, String jurusan){
        this.nama = nama;
        this.nim = nim;
        this.tgllahir = tgllahir;
        this.jeniskelamin = jeniskelamin;
        this.jurusan = jurusan;

    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNim() {
        return nim;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    public String getTgllahir() {
        return tgllahir;
    }

    public void setTgllahir(String tgllahir) {
        this.tgllahir = tgllahir;
    }

    public String getJeniskelamin() {
        return jeniskelamin;
    }

    public void setJenisKelamin(String jenisKelamin) {
        this.jeniskelamin = jenisKelamin;
    }

    public String getJurusan() {
        return jurusan;
    }

    public void setJurusan(String jurusan) {
        this.jurusan = jurusan;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.nama);
        dest.writeString(this.nim);
        dest.writeString(this.tgllahir);
        dest.writeString(this.jeniskelamin);
        dest.writeString(this.jurusan);
    }

    public static final Creator<MyParcelable> CREATOR = new Creator<MyParcelable>() {
        @Override
        public MyParcelable createFromParcel(Parcel source) {
            return new MyParcelable(source);
        }

        @Override
        public MyParcelable[] newArray(int size) {
            return new MyParcelable[size];
        }
    };
}
