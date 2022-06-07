package com.example.nguyensyhoang_08dcntt1;

public class MayTinh {
  private String mamt,tenmt,loaimt,namsx,hangsx,dongia,soluong;

    public MayTinh(String mamt, String tenmt, String loaimt, String namsx, String hangsx, String dongia, String soluong) {
        this.mamt = mamt;
        this.tenmt = tenmt;
        this.loaimt = loaimt;
        this.namsx = namsx;
        this.hangsx = hangsx;
        this.dongia = dongia;
        this.soluong = soluong;
    }

    public MayTinh(String tenmt, String loaimt, String namsx, String hangsx, String dongia, String soluong) {
        this.tenmt = tenmt;
        this.loaimt = loaimt;
        this.namsx = namsx;
        this.hangsx = hangsx;
        this.dongia = dongia;
        this.soluong = soluong;
    }

    public MayTinh() {
    }

    public String getMamt() {
        return mamt;
    }

    public void setMamt(String mamt) {
        this.mamt = mamt;
    }

    public String getTenmt() {
        return tenmt;
    }

    public void setTenmt(String tenmt) {
        this.tenmt = tenmt;
    }

    public String getLoaimt() {
        return loaimt;
    }

    public void setLoaimt(String loaimt) {
        this.loaimt = loaimt;
    }

    public String getNamsx() {
        return namsx;
    }

    public void setNamsx(String namsx) {
        this.namsx = namsx;
    }

    public String getHangsx() {
        return hangsx;
    }

    public void setHangsx(String hangsx) {
        this.hangsx = hangsx;
    }

    public String getDongia() {
        return dongia;
    }

    public void setDongia(String dongia) {
        this.dongia = dongia;
    }

    public String getSoluong() {
        return soluong;
    }

    public void setSoluong(String soluong) {
        this.soluong = soluong;
    }
}
