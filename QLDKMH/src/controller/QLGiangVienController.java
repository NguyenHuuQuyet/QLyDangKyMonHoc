/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import database.ConnectDatabase;
import model.GiangVien;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Minh Hai
 */
public class QLGiangVienController {
    ConnectDatabase conDb = new ConnectDatabase();

    public List<GiangVien> getListGV() {
        List<GiangVien> listGV = new ArrayList<>();
        String sql = "SELECT * FROM dbo.GiangVien";
        try {
            PreparedStatement ps = conDb.conn.prepareStatement(sql);
            ResultSet re = ps.executeQuery();
            while (re.next()) {
                GiangVien gv = new GiangVien();
                gv.setMaGV(re.getString("MaGV"));
                gv.setTenGV(re.getString("TenGV"));
                gv.setKhoa(re.getString("Khoa"));
                gv.setSoDT(re.getString("SoDT"));
                gv.setEmail(re.getString("Email"));
                gv.setId(re.getString("ID"));
                listGV.add(gv);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Không lấy được danh sách sinh viên");
        }
        return listGV;
    }

    public GiangVien getGVById(String id){
        String sql = "SELECT * FROM dbo.GiangVien WHERE ID = '" + id + "'";
        try {
            PreparedStatement ps = conDb.conn.prepareStatement(sql);
            ResultSet re = ps.executeQuery();
            if(re.next()){
                GiangVien gv = new GiangVien();
                gv.setMaGV(re.getString("MaGV"));
                gv.setTenGV(re.getString("TenGV"));
                gv.setKhoa(re.getString("Khoa"));
                gv.setSoDT(re.getString("SoDT"));
                gv.setEmail(re.getString("Email"));
                gv.setId(re.getString("ID"));
                return gv;
            } else  JOptionPane.showMessageDialog(null, "Giảng viên không tồn tại\nHãy nhập đúng ID");
        } catch (Exception e) {
            e.printStackTrace();
        }  
        return null;
    }
    
    public GiangVien getGVByMaGV(String maGV){
        String sql = "SELECT * FROM dbo.GiangVien WHERE MaGV = '" + maGV + "'";
        try {
            PreparedStatement ps = conDb.conn.prepareStatement(sql);
            ResultSet re = ps.executeQuery();
            if(re.next()){
                GiangVien gv = new GiangVien();
                gv.setMaGV(re.getString("MaGV"));
                gv.setTenGV(re.getString("TenGV"));
                gv.setKhoa(re.getString("Khoa"));
                gv.setSoDT(re.getString("SoDT"));
                gv.setEmail(re.getString("Email"));
                gv.setId(re.getString("ID"));
                return gv;
            } else  JOptionPane.showMessageDialog(null, "Giảng viên không tồn tại\nHãy nhập đúng mã giảng viên");
        } catch (Exception e) {
            e.printStackTrace();
        }  
        return null;
    }
    
    public boolean themGV(GiangVien gv) {
        String sql = "INSERT INTO dbo.GiangVien VALUES(?,?,?,?,?,?)";
        try {
            PreparedStatement ps = conDb.conn.prepareStatement(sql);
            ps.setString(1, gv.getMaGV());
            ps.setString(2, gv.getTenGV());
            ps.setString(3, gv.getKhoa());
            ps.setString(4, gv.getSoDT());
            ps.setString(5, gv.getEmail());
            ps.setString(6,gv.getId());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Thêm thành công");
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Lỗi. Thêm thất bại\nMã giảng viên không hợp lệ");
            System.out.println(e);
            return false;
        }
    }

    public void xoaGV(String id) {
        String sql = "DELETE FROM dbo.TaiKhoan WHERE ID = '" + id +  "'";
        try {
            PreparedStatement ps = conDb.conn.prepareStatement(sql);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Xóa thành công");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Lỗi. Xóa thất bại");
            System.out.println(e);
        }
    }

    public boolean suaGV(GiangVien gv) {
        String sql = "UPDATE dbo.GiangVien SET TenGV = ?, Khoa = ?, SoDT = ?, Email = ? WHERE MaGV = ? ";
        try {
            PreparedStatement ps = conDb.conn.prepareStatement(sql);
            ps.setString(1, gv.getTenGV());
            ps.setString(2, gv.getKhoa());
            ps.setString(3, gv.getSoDT());
            ps.setString(4, gv.getEmail());
            ps.setString(5,gv.getMaGV());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Sửa thành công");
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Lỗi. Sửa thất bại");
            System.out.println(e);
            return false;
        }
    }

    public GiangVien timKiemByMaGV(String maGV) {
        String sql = "SELECT * FROM dbo.GiangVien WHERE MaGV = '" + maGV +  "'";
        try {
            PreparedStatement pre = conDb.conn.prepareStatement(sql);
            ResultSet re = pre.executeQuery();
            if (re.next()) {
                String tenGV = re.getString("TenGV");
                String khoa = re.getString("Khoa");
                String soDT = re.getString("SoDT");
                String email = re.getString("Email");
                String id = re.getString("ID");
                GiangVien gv = new GiangVien(maGV, tenGV, khoa, soDT, email, id);
                return gv;
            } else {
                JOptionPane.showMessageDialog(null, "Không có giảng viên này trong hệ thống");
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
