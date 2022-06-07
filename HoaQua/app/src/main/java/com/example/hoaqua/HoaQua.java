package com.example.hoaqua;

public class HoaQua {
    private int id;
    private String ten,loai,dvt,dongia,noisx;

    public HoaQua(int id, String ten, String loai, String dvt, String dongia, String noisx) {
        this.id = id;
        this.ten = ten;
        this.loai = loai;
        this.dvt = dvt;
        this.dongia = dongia;
        this.noisx = noisx;
    }
    public HoaQua(){}
    public HoaQua(String ten, String loai, String dvt, String dongia, String noisx) {
        this.ten = ten;
        this.loai = loai;
        this.dvt = dvt;
        this.dongia = dongia;
        this.noisx = noisx;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getLoai() {
        return loai;
    }

    public void setLoai(String loai) {
        this.loai = loai;
    }

    public String getDvt() {
        return dvt;
    }

    public void setDvt(String dvt) {
        this.dvt = dvt;
    }

    public String getDongia() {
        return dongia;
    }

    public void setDongia(String dongia) {
        this.dongia = dongia;
    }

    public String getNoisx() {
        return noisx;
    }

    public void setNoisx(String noisx) {
        this.noisx = noisx;
    }
}
