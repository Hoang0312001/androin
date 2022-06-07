package com.example.qlsvp2;

public class sinhvien {
    private  int id;
    private  String hoten,email,phone,img;

    public sinhvien() {
    }

    public sinhvien(int id, String hoten, String email, String phone, String img) {
        this.id = id;
        this.hoten = hoten;
        this.email = email;
        this.phone = phone;
        this.img = img;
    }

    public sinhvien(String hoten, String email, String phone, String img) {
        this.hoten = hoten;
        this.email = email;
        this.phone = phone;
        this.img = img;
    }

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
