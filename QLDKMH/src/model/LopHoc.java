/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 *
 * @author Minh Hai
 */
public class LopHoc implements Comparable<LopHoc>{

    private String maLH;
    private String tenLH;
    private Date ngayBatDau;
    private String thu;
    private String tiet;
    private int siSo;
    private String maMH;
    private String maPH;

    public LopHoc() {
    }

    public LopHoc(String maLH, String tenLH, String ngayBatDau, String thu,
            String tiet, int siSo, String maMH, String maPH) throws ParseException {
        this.maLH = maLH;
        this.tenLH = tenLH;
        setNgayBatDau(ngayBatDau);
        this.thu = thu;
        this.tiet = tiet;
        this.siSo = siSo;
        this.maMH = maMH;
        this.maPH = maPH;
    }

    public LopHoc(String maLH, String tenLH, String ngayBatDau,
            String tiet, int siSo, String maMH, String maPH) throws ParseException {
        this.maLH = maLH;
        this.tenLH = tenLH;
        setNgayBatDau(ngayBatDau);
        setThuAuto();
        this.tiet = tiet;
        this.siSo = siSo;
        this.maMH = maMH;
        this.maPH = maPH;
    }

    public String getMaLH() {
        return maLH;
    }

    public void setMaLH(String maLH) {
        this.maLH = maLH;
    }

    public String getTenLH() {
        return tenLH;
    }

    public void setTenLH(String tenLH) {
        this.tenLH = tenLH;
    }

    public String getThu() {
        return thu;
    }

    public void setThu(String thu) {
        this.thu = thu;
    }
    
    public void setThuAuto(){
        this.thu = new SimpleDateFormat("E").format(this.ngayBatDau);
    }

    public String getTiet() {
        return tiet;
    }

    public void setTiet(String tiet) {
        this.tiet = tiet;
    }

    public String getNgayBatDau() {
        String ngayBatDauStr = new SimpleDateFormat("dd/MM/yyyy").format(ngayBatDau);
        return ngayBatDauStr;
    }

    public void setNgayBatDau(String ngayBatDauStr) throws ParseException {
        this.ngayBatDau = (Date) new SimpleDateFormat("dd/MM/yyyy").parse(ngayBatDauStr);
    }

    public int getSiSo() {
        return siSo;
    }

    public void setSiSo(int siSo) {
        this.siSo = siSo;
    }

    public String getMaMH() {
        return maMH;
    }

    public void setMaMH(String maMH) {
        this.maMH = maMH;
    }

    public String getMaPH() {
        return maPH;
    }

    public void setMaPH(String maPH) {
        this.maPH = maPH;
    }

    @Override
    public int compareTo(LopHoc lh) {
        return thu.compareToIgnoreCase(lh.thu);
    }
     
    @Override
    public String toString() {
        return "LopHoc{" + "maLH=" + maLH + ", tenLH=" + tenLH + ", thu=" + thu +
                ", tiet=" + tiet + ", ngayBatDau=" + ngayBatDau + ", siSo=" + siSo + ", maMH=" + maMH + ", maPH=" + maPH + '}';
    }
}
