package com.example.qlsvdb;

public class sinhvien {
    private  int id;
    private  String hoten,lop,diachi,sdt;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public String getLop() {
        return lop;
    }

    public void setLop(String lop) {
        this.lop = lop;
    }

    public String getDiachi( ) {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public sinhvien() {
    }

    public sinhvien(int id, String hoten, String lop, String diachi, String sdt) {
        this.id = id;
        this.hoten = hoten;
        this.lop = lop;
        this.diachi = diachi;
        this.sdt = sdt;
    }

    public sinhvien(String hoten, String lop, String diachi, String sdt) {
        this.hoten = hoten;
        this.lop = lop;
        this.diachi = diachi;
        this.sdt = sdt;
    }

    @Override
    public String toString() {
        return "sinhvien{" +
                "id=" + id +
                ", hoten='" + hoten + '\'' +
                ", lop='" + lop + '\'' +
                ", diachi='" + diachi + '\'' +
                ", sdt='" + sdt + '\'' +
                '}';
    }
}
