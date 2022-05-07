package com.example.admin.mDB;

public class DBTamTru {
    private String keyid;
    private String name;
    private String addess;
    private String phone;
    private String username;
    private String password;
    private String tenphongtro;
    private String thongbao;
    private String masv;
    private String avatar;

    public DBTamTru() {
    }



    public DBTamTru(String keyid, String name, String addess, String phone, String username, String password, String tenphongtro, String thongbao, String masv, String avatar) {
        this.keyid = keyid;
        this.name = name;
        this.addess = addess;
        this.phone = phone;
        this.username = username;
        this.password = password;
        this.tenphongtro = tenphongtro;
        this.thongbao = thongbao;
        this.masv = masv;
        this.avatar = avatar;
    }

    public String getKeyid() {
        return keyid;
    }

    public void setKeyid(String keyid) {
        this.keyid = keyid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddess() {
        return addess;
    }

    public void setAddess(String addess) {
        this.addess = addess;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTenphongtro() {
        return tenphongtro;
    }

    public void setTenphongtro(String tenphongtro) {
        this.tenphongtro = tenphongtro;
    }

    public String getThongbao() {
        return thongbao;
    }

    public void setThongbao(String thongbao) {
        this.thongbao = thongbao;
    }

    public String getMasv() {
        return masv;
    }

    public void setMasv(String masv) {
        this.masv = masv;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
}
