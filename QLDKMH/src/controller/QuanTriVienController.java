/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import database.ConnectDatabase;
import model.QuanTriVien;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author Minh Hai
 */
public class QuanTriVienController {
    ConnectDatabase conDb = new ConnectDatabase();

    public QuanTriVien getQTV(String id) {
        String sql = "SELECT * FROM dbo.QuanTriVien WHERE QuanTriVien.ID = '" + id + "'";
        try {
            PreparedStatement ps = conDb.conn.prepareStatement(sql);
            ResultSet re = ps.executeQuery();
            if(re.next()){
                QuanTriVien quanTriVien = new QuanTriVien();
                quanTriVien.setMaQTV(re.getString("MaQTV"));
                quanTriVien.setTenQTV(re.getString("TenQTV"));
                quanTriVien.setId(re.getString("ID"));
                return quanTriVien;
            } else JOptionPane.showMessageDialog(null, "Không tồn tại quản trị viên");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public void suaQTV(QuanTriVien qtv){
        String sql ="UPDATE dbo.QuanTriVien SET TenQTV = ? WHERE MaQTV=? ";
        try {
            PreparedStatement ps = conDb.conn.prepareStatement(sql);
            ps.setString(1,qtv.getTenQTV());
            ps.setString(2,qtv.getMaQTV());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Sửa thành công");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Lỗi. Sửa thất bại");
            e.printStackTrace();
        }
    }
}