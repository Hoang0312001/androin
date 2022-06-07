package com.example.nguyensyhoang_08d4800079;

public class VanTai {
    private int trongtai;
    private String bienks,tenchuxe,hangxe,hdkd;

    public VanTai() {
    }

    public VanTai(String bienks, String tenchuxe, String hangxe, int trongtai, String hdkd) {
        this.bienks = bienks;
        this.tenchuxe = tenchuxe;
        this.hangxe = hangxe;
        this.trongtai = trongtai;
        this.hdkd = hdkd;
    }

    public VanTai(String tenchuxe, String hangxe, int trongtai, String hdkd) {

        this.tenchuxe = tenchuxe;
        this.hangxe = hangxe;
        this.trongtai = trongtai;
        this.hdkd = hdkd;
    }




    public String getBienks() {
        return bienks;
    }

    public void setBienks(String bienks) {
        this.bienks = bienks;
    }

    public String getTenchuxe() {
        return tenchuxe;
    }

    public void setTenchuxe(String tenchuxe) {
        this.tenchuxe = tenchuxe;
    }

    public String getHangxe() {
        return hangxe;
    }

    public void setHangxe(String hangxe) {
        this.hangxe = hangxe;
    }

    public int getTrongtai() {
        return trongtai;
    }

    public void setTrongtai(int trongtai) {
        this.trongtai = trongtai;
    }

    public String getHdkd() {
        return hdkd;
    }

    public void setHdkd(String hdkd) {
        this.hdkd = hdkd;
    }

    @Override
    public String toString() {
        return "VanTai{" +
                "trongtai=" + trongtai +
                ", bienks='" + bienks + '\'' +
                ", tenchuxe='" + tenchuxe + '\'' +
                ", hangxe='" + hangxe + '\'' +
                ", hdkd='" + hdkd + '\'' +
                '}';
    }
}
