/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import database.ConnectDatabase;
import model.LopHoc;
import model.GVDangKy;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.GiangVien;

/**
 *
 * @author Minh Hai
 */
public class QLGVDangKyController {

    ConnectDatabase conDb = new ConnectDatabase();

    public List<GVDangKy> getListLopHocTatCaGVDangKy() {
        List<GVDangKy> listGVDK = new ArrayList<>();
        String sql = "SELECT * FROM dbo.GVDangKy";
        try {
            PreparedStatement ps = conDb.conn.prepareStatement(sql);
            ResultSet re = ps.executeQuery();
            while (re.next()) {
                GVDangKy gvdk = new GVDangKy();
                gvdk.setMaGV(re.getString("MaGV"));
                gvdk.setMaLH(re.getString("MaLH"));
                listGVDK.add(gvdk);
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Không lấy được danh sách lớp học đã đăng ký");
        }
        return listGVDK;
    }

    public List<LopHoc> getListLopHoc1GVDangKy(String maGV) {
        List<LopHoc> listLH = new ArrayList<>();
        String sql = "SELECT LopHoc.* FROM dbo.LopHoc INNER JOIN dbo.GVDangKy ON GVDangKy.MaLH = LopHoc.MaLH WHERE MaGV = '" + maGV + "'";
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
            JOptionPane.showMessageDialog(null, "Không lấy được danh sách lớp học đã đăng ký");
        }
        return listLH;
    }

    public List<GiangVien> getListGVDangKy1LopHoc(String maLH) {
        List<GiangVien> listGV = new ArrayList<>();
        String sql = "SELECT GiangVien.* FROM dbo.GiangVien INNER JOIN dbo.GVDangKy ON GVDangKy.MaGV = GiangVien.MaGV WHERE MaLH = '" + maLH + "'";
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
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Lớp học không tồn tại hoặc không có giảng viên nào đã đăng ký ");
        }
        return listGV;
    }

    public boolean dangKyLopHocGV(String maGV, String maLH) {
        String sql = "INSERT INTO dbo.GVDangKy VALUES(?,?)";
        try {
            PreparedStatement ps = conDb.conn.prepareStatement(sql);
            ps.setString(1, maGV);
            ps.setString(2, maLH);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Thêm thành công");
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Lỗi. Thêm thất bại");
            e.printStackTrace();
            return false;
        }
    }

    public boolean xoaLopHocGV(String maGV, String maLH) {
        String sql = "DELETE FROM dbo.GVDangKy WHERE MaGV = '" + maGV + "' AND MaLH = '" + maLH + "'";
        try {
            PreparedStatement ps = conDb.conn.prepareStatement(sql);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Xóa thành công");
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Lỗi. Thêm thất bại");
            e.printStackTrace();
            return false;
        }
    }

    public GVDangKy timKiemLopHocGVDaDangKy(String maLH) {
        String sql = "SELECT * FROM dbo.GVDangKy WHERE MaLH = '" + maLH + "'";
        try {
            PreparedStatement pre = conDb.conn.prepareStatement(sql);
            ResultSet re = pre.executeQuery();
            if (re.next()) {
                GVDangKy gvdk = new GVDangKy();
                gvdk.setMaLH(re.getString("MaLH"));
                gvdk.setMaGV(re.getString("MaGV"));
                return gvdk;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Lớp học này chưa được đăng ký");
            e.printStackTrace();
            return null;
        }
        return null;
    }
}
