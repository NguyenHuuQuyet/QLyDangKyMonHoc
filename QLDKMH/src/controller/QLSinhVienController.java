/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import database.ConnectDatabase;
import model.SinhVien;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Minh Hai
 */
public class QLSinhVienController {

    ConnectDatabase conDb = new ConnectDatabase();

    public List<SinhVien> getListSV() {
        List<SinhVien> listSV = new ArrayList<>();
        String sql = "SELECT * FROM dbo.SinhVien";
        try {
            PreparedStatement ps = conDb.conn.prepareStatement(sql);
            ResultSet re = ps.executeQuery();
            while (re.next()) {
                SinhVien sv = new SinhVien();
                sv.setMaSV(re.getString("MaSV"));
                sv.setTenSV(re.getString("TenSV"));
                sv.setLop(re.getString("Lop"));
                sv.setSoDT(re.getString("SoDT"));
                sv.setDiaChi(re.getString("DiaChi"));
                sv.setEmail(re.getString("Email"));
                sv.setId(re.getString("ID"));
                listSV.add(sv);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Không lấy được danh sách sinh viên");
        }
        return listSV;
    }

    public SinhVien getSVById(String id) {
        String sql = "SELECT * FROM dbo.SinhVien WHERE ID = '" + id + "'";
        try {
            PreparedStatement ps = conDb.conn.prepareStatement(sql);
            ResultSet re = ps.executeQuery();
            if (re.next()) {
                SinhVien sv = new SinhVien();
                sv.setMaSV(re.getString("MaSV"));
                sv.setTenSV(re.getString("TenSV"));
                sv.setLop(re.getString("Lop"));
                sv.setSoDT(re.getString("SoDT"));
                sv.setDiaChi(re.getString("DiaChi"));
                sv.setEmail(re.getString("Email"));
                sv.setId(re.getString("ID"));
                return sv;
            } else {
                JOptionPane.showMessageDialog(null, "Sinh viên không tồn tại\nHãy nhập đúng ID");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public SinhVien getSVByMaSV(String maSV) {
        String sql = "SELECT * FROM dbo.SinhVien WHERE MaSV = '" + maSV + "'";
        try {
            PreparedStatement ps = conDb.conn.prepareStatement(sql);
            ResultSet re = ps.executeQuery();
            if (re.next()) {
                SinhVien sv = new SinhVien();
                sv.setMaSV(re.getString("MaSV"));
                sv.setTenSV(re.getString("TenSV"));
                sv.setLop(re.getString("Lop"));
                sv.setSoDT(re.getString("SoDT"));
                sv.setDiaChi(re.getString("DiaChi"));
                sv.setEmail(re.getString("Email"));
                sv.setId(re.getString("ID"));
                return sv;
            } else {
                JOptionPane.showMessageDialog(null, "Sinh viên không tồn tại\nHãy nhập đúng mã sinh viên");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean themSV(SinhVien sv) {
        String sql = "INSERT INTO dbo.SinhVien VALUES(?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = conDb.conn.prepareStatement(sql);
            ps.setString(1, sv.getMaSV());
            ps.setString(2, sv.getTenSV());
            ps.setString(3, sv.getLop());
            ps.setString(4, sv.getSoDT());
            ps.setString(5, sv.getDiaChi());
            ps.setString(6, sv.getEmail());
            ps.setString(7, sv.getId());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Thêm thành công");
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Lỗi. Thêm thất bại\nMã sinh viên không hợp lệ");
            System.out.println(e);
            return false;
        }
    }

    public void xoaSV(String id) {
        String sql = "DELETE FROM dbo.TaiKhoan WHERE ID = '" + id + "'";
        try {
            PreparedStatement ps = conDb.conn.prepareStatement(sql);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Xóa thành công");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Lỗi. Xóa thất bại");
            System.out.println(e);
        }
    }

    public void suaSV(SinhVien sv) {
        String sql = "UPDATE dbo.SinhVien SET TenSV = ?, Lop = ?, SoDT = ?, DiaChi = ?, Email = ? WHERE MaSV = ? ";
        try {
            PreparedStatement ps = conDb.conn.prepareStatement(sql);
            ps.setString(1, sv.getTenSV());
            ps.setString(2, sv.getLop());
            ps.setString(3, sv.getSoDT());
            ps.setString(4, sv.getDiaChi());
            ps.setString(5, sv.getEmail());
            ps.setString(6, sv.getMaSV());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Sửa thành công");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Lỗi. Sửa thất bại\nHãy nhập đúng mã sinh viên");
            System.out.println(e);
        }
    }

    public SinhVien timKiemByMaSV(String maSV) {
        String sql = "SELECT * FROM dbo.SinhVien WHERE MaSV = '" + maSV + "'";
        try {
            PreparedStatement pre = conDb.conn.prepareStatement(sql);
            ResultSet re = pre.executeQuery();
            if (re.next()) {
                String tenSV = re.getString("TenSV");
                String lop = re.getString("Lop");
                String soDT = re.getString("SoDT");
                String diaChi = re.getString("DiaChi");
                String email = re.getString("Email");
                String id = re.getString("ID");
                SinhVien sv = new SinhVien(maSV, tenSV, lop, soDT, diaChi, email, id);
                return sv;
            } else {
                JOptionPane.showMessageDialog(null, "Không có sinh viên này trong hệ thống");
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
