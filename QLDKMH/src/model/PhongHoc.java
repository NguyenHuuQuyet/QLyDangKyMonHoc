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
public class PhongHoc {
    private String maPH;
    private String tenPH;
    private String dienTich;

    public PhongHoc() {
    }

    public PhongHoc(String maPH, String tenPH, String dienTich) {
        this.maPH = maPH;
        this.tenPH = tenPH;
        this.dienTich = dienTich;
    }

    public String getMaPH() {
        return maPH;
    }

    public void setMaPH(String maPH) {
        this.maPH = maPH;
    }

    public String getTenPH() {
        return tenPH;
    }

    public void setTenPH(String tenPH) {
        this.tenPH = tenPH;
    }

    public String getDienTich() {
        return dienTich;
    }

    public void setDienTich(String dienTich) {
        this.dienTich = dienTich;
    }

    @Override
    public String toString() {
        return "PhongHoc{" + "maPH=" + maPH + ", tenPH=" + tenPH + ", dienTich=" + dienTich + '}';
    }
}