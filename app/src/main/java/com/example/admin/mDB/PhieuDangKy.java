package com.example.admin.mDB;

public class PhieuDangKy {
    private String hoTen;
    private String ngaySinh;
    private String queQuan;
    private String soCmnd;
    private String noiDangKyTamTru;
    private String getSoCmndChuTro;

    public PhieuDangKy(String hoTen, String ngaySinh, String queQuan, String soCmnd, String noiDangKyTamTru, String getSoCmndChuTro) {
        this.hoTen = hoTen;
        this.ngaySinh = ngaySinh;
        this.queQuan = queQuan;
        this.soCmnd = soCmnd;
        this.noiDangKyTamTru = noiDangKyTamTru;
        this.getSoCmndChuTro = getSoCmndChuTro;
    }

    public PhieuDangKy(){}

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getQueQuan() {
        return queQuan;
    }

    public void setQueQuan(String queQuan) {
        this.queQuan = queQuan;
    }

    public String getSoCmnd() {
        return soCmnd;
    }

    public void setSoCmnd(String soCmnd) {
        this.soCmnd = soCmnd;
    }

    public String getNoiDangKyTamTru() {
        return noiDangKyTamTru;
    }

    public void setNoiDangKyTamTru(String noiDangKyTamTru) {
        this.noiDangKyTamTru = noiDangKyTamTru;
    }

    public String getGetSoCmndChuTro() {
        return getSoCmndChuTro;
    }

    public void setGetSoCmndChuTro(String getSoCmndChuTro) {
        this.getSoCmndChuTro = getSoCmndChuTro;
    }
}
