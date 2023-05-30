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
public class GVDangKy {
    private String maGV;
    private String maLH;

    public GVDangKy() {
    }

    public GVDangKy(String maGV, String maLH) {
        this.maGV = maGV;
        this.maLH = maLH;
    }

    public String getMaGV() {
        return maGV;
    }

    public void setMaGV(String maGV) {
        this.maGV = maGV;
    }

    public String getMaLH() {
        return maLH;
    }

    public void setMaLH(String maLH) {
        this.maLH = maLH;
    }

    @Override
    public String toString() {
        return "GVDangKy{" + "maGV=" + maGV + ", maLH=" + maLH + '}';
    }
}
