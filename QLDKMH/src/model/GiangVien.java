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
public class GiangVien {
    private String maGV;
    private String tenGV;
    private String khoa;
    private String soDT;
    private String email;
    private String id;

    public GiangVien() {
    }

    public GiangVien(String maGV, String tenGV, String khoa, String soDT, String email, String id) {
        this.maGV = maGV;
        this.tenGV = tenGV;
        this.khoa = khoa;
        this.soDT = soDT;
        this.email = email;
        this.id = id;
    }

    public String getMaGV() {
        return maGV;
    }

    public void setMaGV(String maGV) {
        this.maGV = maGV;
    }

    public String getTenGV() {
        return tenGV;
    }

    public void setTenGV(String tenGV) {
        this.tenGV = tenGV;
    }

    public String getKhoa() {
        return khoa;
    }

    public void setKhoa(String khoa) {
        this.khoa = khoa;
    }

    public String getSoDT() {
        return soDT;
    }

    public void setSoDT(String soDT) {
        this.soDT = soDT;
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
        return "GiangVien{" + "maGV=" + maGV + ", tenGV=" + tenGV + ", khoa=" + khoa + ", soDT=" + soDT + ", email=" + email + ", id=" + id + '}';
    }
}
