package com.example.thucpham;

public class ThucPham {
    private int id;
    private String dvt,dongia,name;

    public ThucPham() {
    }

    public ThucPham(int id, String name,String dvt, String dongia) {
        this.id = id;
        this.dvt = dvt;
        this.dongia = dongia;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ThucPham(String name, String dvt, String dongia) {
        this.dvt = dvt;
        this.dongia = dongia;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
}
