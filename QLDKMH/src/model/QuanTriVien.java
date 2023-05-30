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
public class QuanTriVien {
    private String maQTV;
    private String tenQTV;
    private String id;

    public QuanTriVien() {
    }

    public QuanTriVien(String maQTV, String tenQTV, String id) {
        this.maQTV = maQTV;
        this.tenQTV = tenQTV;
        this.id = id;
    }

    public String getMaQTV() {
        return maQTV;
    }

    public void setMaQTV(String maQTV) {
        this.maQTV = maQTV;
    }

    public String getTenQTV() {
        return tenQTV;
    }

    public void setTenQTV(String tenQTV) {
        this.tenQTV = tenQTV;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "QuanTriVien{" + "maQTV=" + maQTV + ", tenQTV=" + tenQTV + ", id=" + id + '}';
    }
}
