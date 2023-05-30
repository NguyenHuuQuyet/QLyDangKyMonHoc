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
public class TaiKhoan {
    private String id;
    private String matKhau;
    private String loaiTK;

    public TaiKhoan() {
    }

    public TaiKhoan(String id, String matKhau, String loaiTK) {
        this.id = id;
        this.matKhau = matKhau;
        this.loaiTK = loaiTK;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public String getLoaiTK() {
        return loaiTK;
    }

    public void setLoaiTK(String loaiTK) {
        this.loaiTK = loaiTK;
    }

    @Override
    public String toString() {
        return "TaiKhoan{" + "id=" + id + ", matKhau=" + matKhau + ", loaiTK=" + loaiTK + '}';
    }
}