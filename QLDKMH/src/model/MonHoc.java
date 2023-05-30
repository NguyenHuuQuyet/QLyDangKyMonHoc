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
public class MonHoc {
    private String maMH;
    private String tenMH;
    private int soTinChi;

    public MonHoc() {
    }

    public MonHoc(String maMH, String tenMH, int soTinChi) {
        this.maMH = maMH;
        this.tenMH = tenMH;
        this.soTinChi = soTinChi;
    }

    public String getMaMH() {
        return maMH;
    }

    public void setMaMH(String maMH) {
        this.maMH = maMH;
    }

    public String getTenMH() {
        return tenMH;
    }

    public void setTenMH(String tenMH) {
        this.tenMH = tenMH;
    }

    public int getSoTinChi() {
        return soTinChi;
    }

    public void setSoTinChi(int soTinChi) {
        this.soTinChi = soTinChi;
    }

    @Override
    public String toString() {
        return "MonHoc{" + "maMH=" + maMH + ", tenMH=" + tenMH + ", soTinChi=" + soTinChi + '}';
    }
}