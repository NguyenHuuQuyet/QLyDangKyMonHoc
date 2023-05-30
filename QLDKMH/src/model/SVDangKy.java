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
public class SVDangKy {
    private String maSV;
    private String maLH;

    public SVDangKy() {
    }

    public SVDangKy(String maSV, String maLH) {
        this.maSV = maSV;
        this.maLH = maLH;
    }

    public String getMaSV() {
        return maSV;
    }

    public void setMaSV(String maSV) {
        this.maSV = maSV;
    }

    public String getMaLH() {
        return maLH;
    }

    public void setMaLH(String maLH) {
        this.maLH = maLH;
    }
    
    @Override
    public String toString() {
        return "SVDangKy{" + "maSV=" + maSV + ", maLH=" + maLH + '}';
    }
}