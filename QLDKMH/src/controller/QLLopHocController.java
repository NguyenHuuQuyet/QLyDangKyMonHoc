/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import database.ConnectDatabase;
import java.sql.Date;
import model.LopHoc;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Minh Hai
 */
public class QLLopHocController {

    ConnectDatabase conDb = new ConnectDatabase();

    public List<LopHoc> getListLH() throws ParseException {
        List<LopHoc> listLH = new ArrayList<>();
        String sql = "SELECT * FROM dbo.LopHoc";
        try {
            PreparedStatement ps = conDb.conn.prepareStatement(sql);
            ResultSet re = ps.executeQuery();
            while (re.next()) {
                LopHoc lh = new LopHoc();
                lh.setMaLH(re.getString("MaLH"));
                lh.setTenLH(re.getString("TenLH"));
                lh.setThu(re.getString("Thu"));
                lh.setTiet(re.getString("Tiet"));
                lh.setNgayBatDau(re.getString("NgayBatDau"));
                lh.setSiSo(re.getInt("SiSo"));
                lh.setMaMH(re.getString("MaMH"));
                lh.setMaPH(re.getString("MaPH"));
                listLH.add(lh);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Không lấy được danh sách lớp học");
        }
        return listLH;
    }

    public LopHoc getLH(String maLH) {
        String sql = "SELECT * FROM dbo.LopHoc WHERE MaLH = '" + maLH + "'";
        try {
            PreparedStatement ps = conDb.conn.prepareStatement(sql);
            ResultSet re = ps.executeQuery();
            if (re.next()) {
                LopHoc lh = new LopHoc();
                lh.setMaLH(re.getString("MaLH"));
                lh.setTenLH(re.getString("TenLH"));
                lh.setThu(re.getString("Thu"));
                lh.setTiet(re.getString("Tiet"));
                lh.setNgayBatDau(re.getString(("NgayBatDau")));
                lh.setSiSo(re.getInt("SiSo"));
                lh.setMaMH(re.getString("MaMH"));
                lh.setMaPH(re.getString("MaPH"));
                return lh;
            } else {
                JOptionPane.showMessageDialog(null, "Lớp học không tồn tại");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean themLH(LopHoc lh) {
        String sql = "INSERT INTO dbo.LopHoc VALUES(?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = conDb.conn.prepareStatement(sql);
            ps.setString(1, lh.getMaLH());
            ps.setString(2, lh.getTenLH());
            ps.setString(3, lh.getThu());
            ps.setString(4, lh.getTiet());
            ps.setString(5, lh.getNgayBatDau());
            ps.setInt(6, lh.getSiSo());
            ps.setString(7, lh.getMaMH());
            ps.setString(8, lh.getMaPH());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Thêm thành công");
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Lỗi. Thêm thất bại\nLớp học này đã tồn tại");
            System.out.println(e);
            return false;
        }
    }

    public void xoaLH(String maLH) {
        String sql = "DELETE FROM dbo.LopHoc WHERE MaLH = '" + maLH + "'";
        try {
            PreparedStatement ps = conDb.conn.prepareStatement(sql);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Xóa thành công");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Lỗi. Xóa thất bại");
            System.out.println(e);
        }
    }

    public boolean suaLH(LopHoc lh) {
        String sql = "UPDATE dbo.LopHoc SET TenLH = ?, Thu = ?, Tiet = ?, NgayBatDau = ?, SiSo = ? WHERE MaLH = ? ";
        try {
            PreparedStatement ps = conDb.conn.prepareStatement(sql);
            ps.setString(1, lh.getTenLH());
            ps.setString(2, lh.getThu());
            ps.setString(3, lh.getTiet());
            ps.setString(4, lh.getNgayBatDau());
            ps.setInt(5, lh.getSiSo());
            ps.setString(6, lh.getMaLH());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Sửa thành công");
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Lỗi. Sửa thất bại");
            System.out.println(e);
            return false;
        }
    }

    public LopHoc timKiemByMaLH(String maLH) {
        String sql = "SELECT * FROM dbo.LopHoc WHERE MaLH = '" + maLH + "'";
        try {
            PreparedStatement pre = conDb.conn.prepareStatement(sql);
            ResultSet re = pre.executeQuery();
            if (re.next()) {
                String tenLH = re.getString("TenLH");
                String thu = re.getString("Thu");
                String tiet = re.getString("Tiet");
                String ngayBatDau = re.getString("NgayBatDau");
                int siSo = re.getInt("SiSo");
                String maMH = re.getString("MaMH");
                String maPH = re.getString("MaPH");
                LopHoc lh = new LopHoc(maLH, tenLH, ngayBatDau, thu, tiet, siSo, maMH, maPH);
                return lh;
            } else {
                JOptionPane.showMessageDialog(null, "Không có lớp học này trong hệ thống");
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<LopHoc> timKiemByMaMH(String maMH) {
        List<LopHoc> listLH = new ArrayList<>();
        String sql = "SELECT * FROM dbo.LopHoc WHERE MaMH = '" + maMH + "'";
        try {
            PreparedStatement ps = conDb.conn.prepareStatement(sql);
            ResultSet re = ps.executeQuery();
            while (re.next()) {
                LopHoc lh = new LopHoc();
                lh.setMaLH(re.getString("MaLH"));
                lh.setTenLH(re.getString("TenLH"));
                lh.setThu(re.getString("Thu"));
                lh.setTiet(re.getString("Tiet"));
                lh.setNgayBatDau(re.getString("NgayBatDau"));
                lh.setSiSo(re.getInt("SiSo"));
                lh.setMaMH(re.getString("MaMH"));
                lh.setMaPH(re.getString("MaPH"));
                listLH.add(lh);
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Không lấy được danh sách lớp học");
        }
        return listLH;
    }
}
