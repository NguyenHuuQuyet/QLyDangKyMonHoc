/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import database.ConnectDatabase;
import model.TaiKhoan;
import java.sql.PreparedStatement;
import java.sql.ResultSet; 
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Minh Hai
 */
public class TaiKhoanController {
    ConnectDatabase conDb = new ConnectDatabase();
    
    public TaiKhoan checkTK(String id, String matKhau){
        try {
            String sql = "Select * From dbo.TaiKhoan Where ID = ? and MatKhau = ?";
            PreparedStatement ps = conDb.conn.prepareStatement(sql);
            ps.setString(1, id);
            ps.setString(2, matKhau);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                TaiKhoan taiKhoan = new TaiKhoan();
                taiKhoan.setId(rs.getString("ID"));
                taiKhoan.setMatKhau(rs.getString("MatKhau"));
                taiKhoan.setLoaiTK(rs.getString("LoaiTaiKhoan"));
                return taiKhoan;
            }
        } catch (Exception ex) {
             JOptionPane.showMessageDialog(null, "Không tồn tại tài khoản");
        } 
        return null;
    }
    
    public List<TaiKhoan> getListTK() {
        List<TaiKhoan> listTK = new ArrayList<>();
        String sql = "SELECT * FROM dbo.TaiKhoan";
        try {
            PreparedStatement ps = conDb.conn.prepareStatement(sql);
            ResultSet re = ps.executeQuery();
            while (re.next()) {
                TaiKhoan tk = new TaiKhoan();
                tk.setId(re.getString("ID"));
                tk.setMatKhau(re.getString("MatKhau"));
                tk.setLoaiTK(re.getString("LoaiTaiKhoan"));
                listTK.add(tk);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Không lấy được danh sách sinh viên");
        }
        return listTK;
    }
    
    public boolean themTK (TaiKhoan tk){
        String sql = "INSERT INTO dbo.TaiKhoan VALUES(?,?,?)";
        try {
            PreparedStatement ps = conDb.conn.prepareStatement(sql);
            ps.setString(1,tk.getId());
            ps.setString(2,tk.getMatKhau());
            ps.setString(3, tk.getLoaiTK());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Tạo thành công");
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Lỗi. Tạo thất bại\nCó thể tài khoản đã tồn tại");
            System.out.println(e);
            return false;
        }
    }
}
