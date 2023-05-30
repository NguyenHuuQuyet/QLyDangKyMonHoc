/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import database.ConnectDatabase;
import model.PhongHoc;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Minh Hai
 */
public class QLPhongHocController {
    ConnectDatabase conDb = new ConnectDatabase();

    public List<PhongHoc> getListPH() {
        List<PhongHoc> listPH = new ArrayList<>();
        String sql = "SELECT * FROM dbo.PhongHoc";
        try {
            PreparedStatement ps = conDb.conn.prepareStatement(sql);
            ResultSet re = ps.executeQuery();
            while (re.next()) {
                PhongHoc ph = new PhongHoc();
                ph.setMaPH(re.getString("MaPH"));
                ph.setTenPH(re.getString("TenPH"));
                ph.setDienTich(re.getString("DienTich"));
                listPH.add(ph);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Không lấy được danh sách phòng học");
        }
        return listPH;
    }

    public PhongHoc getPH(String maPH){
        String sql = "SELECT * FROM dbo.PhongHoc WHERE MaPH = '" + maPH + "'";
        try {
            PreparedStatement ps = conDb.conn.prepareStatement(sql);
            ResultSet re = ps.executeQuery();
            if(re.next()){
                PhongHoc ph = new PhongHoc();
                ph.setMaPH(re.getString("MaPH"));
                ph.setTenPH(re.getString("TenPH"));
                ph.setDienTich(re.getString("DienTich"));
                return ph;
            } else  JOptionPane.showMessageDialog(null, "Phòng học không tồn tại");
        } catch (Exception e) {
            e.printStackTrace();
        }  
        return null;
    }
    
    public boolean themPH(PhongHoc ph) {
        String sql = "INSERT INTO dbo.PhongHoc VALUES(?,?,?)";
        try {
            PreparedStatement ps = conDb.conn.prepareStatement(sql);
            ps.setString(1, ph.getMaPH());
            ps.setString(2, ph.getTenPH());
            ps.setString(3, ph.getDienTich());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Thêm thành công");
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Lỗi. Thêm thất bại\nPhòng học này đã tồn tại");
            System.out.println(e);
            return false;
        }
    }

    public void xoaPH(String maPH) {
        String sql = "DELETE FROM dbo.PhongHoc WHERE MaPH = '" + maPH + "'";
        try {
            PreparedStatement ps = conDb.conn.prepareStatement(sql);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Xóa thành công");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Lỗi. Thêm thất bại");
            System.out.println(e);
        }
    }

    public void suaPH(PhongHoc ph) {
        String sql = "UPDATE dbo.PhongHoc SET TenPH = ?, DienTich = ? WHERE MaPH = ? ";
        try {
            PreparedStatement ps = conDb.conn.prepareStatement(sql);
            ps.setString(1,ph.getTenPH());
            ps.setString(2,ph.getDienTich());
            ps.setString(3,ph.getMaPH());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Sửa thành công");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Lỗi. Sửa thất bại");
            System.out.println(e);
        }
    }

    public PhongHoc timKiemByMaPH(String maPH) {
        String sql = "SELECT * FROM dbo.PhongHoc WHERE MaPH = '" + maPH + "'";
        try {
            PreparedStatement pre = conDb.conn.prepareStatement(sql);
            ResultSet re = pre.executeQuery();
            if (re.next()) {
                String tenPH = re.getString("TenPH");
                String dienTich = re.getString("DienTich");
                PhongHoc ph = new PhongHoc(maPH, tenPH, dienTich);
                return ph;
            } else {
                JOptionPane.showMessageDialog(null, "Không có phòng học này trong hệ thống");
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
