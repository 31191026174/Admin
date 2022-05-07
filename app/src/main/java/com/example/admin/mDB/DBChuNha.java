package com.example.admin.mDB;

public class DBChuNha {
    private String keyid;
    private String name;
    private String addess;
    private String phone;
    private String username;
    private String password;
    private String tenphongtro;
    private String avatar;
    private int color;

    public DBChuNha() {
    }

    public DBChuNha(String keyid, String name, String addess, String phone, String username, String password, String tenphongtro, String avatar, int color) {
        this.keyid = keyid;
        this.name = name;
        this.addess = addess;
        this.phone = phone;
        this.username = username;
        this.password = password;
        this.tenphongtro = tenphongtro;
        this.avatar = avatar;
        this.color = color;
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

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }
}
