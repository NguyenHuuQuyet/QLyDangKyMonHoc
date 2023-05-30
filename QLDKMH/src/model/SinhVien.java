/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Minh Hai
 */
public class SinhVien {
    private String maSV;
    private String tenSV;
    private String lop;
    private String soDT;
    private String diaChi;
    private String email;
    private String id;

    public SinhVien() {
    }

    public SinhVien(String maSV, String tenSV, String lop, String soDT, String diaChi, String email, String id) {
        this.maSV = maSV;
        this.tenSV = tenSV;
        this.lop = lop;
        this.soDT = soDT;
        this.diaChi = diaChi;
        this.email = email;
        this.id = id;
    }

    public String getMaSV() {
        return maSV;
    }

    public void setMaSV(String maSV) {
        this.maSV = maSV;
    }

    public String getTenSV() {
        return tenSV;
    }

    public void setTenSV(String tenSV) {
        this.tenSV = tenSV;
    }

    public String getLop() {
        return lop;
    }

    public void setLop(String lop) {
        this.lop = lop;
    }

    public String getSoDT() {
        return soDT;
    }

    public void setSoDT(String soDT) {
        this.soDT = soDT;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "SinhVien{" + "maSV=" + maSV + ", tenSV=" + tenSV + ", lop=" + lop + ", soDT=" + soDT + ", diaChi=" + diaChi + ", email=" + email + ", id=" + id + '}';
    }
}
