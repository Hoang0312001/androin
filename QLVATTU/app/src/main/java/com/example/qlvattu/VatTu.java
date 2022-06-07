package com.example.qlvattu;

public class VatTu {
    private int id,dongia;
    private String tenvt,hangvt,donvi;

    public VatTu() {
    }

    public VatTu(int id, int dongia, String tenvt, String hangvt, String donvi) {
        this.id = id;
        this.dongia = dongia;
        this.tenvt = tenvt;
        this.hangvt = hangvt;
        this.donvi = donvi;
    }

    public VatTu(int dongia, String tenvt, String hangvt, String donvi) {
        this.dongia = dongia;
        this.tenvt = tenvt;
        this.hangvt = hangvt;
        this.donvi = donvi;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDongia() {
        return dongia;
    }

    public void setDongia(int dongia) {
        this.dongia = dongia;
    }

    public String getTenvt() {
        return tenvt;
    }

    public void setTenvt(String tenvt) {
        this.tenvt = tenvt;
    }

    public String getHangvt() {
        return hangvt;
    }

    public void setHangvt(String hangvt) {
        this.hangvt = hangvt;
    }

    public String getDonvi() {
        return donvi;
    }

    public void setDonvi(String donvi) {
        this.donvi = donvi;
    }
}
