/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import database.ConnectDatabase;
import model.LopHoc;
import model.SVDangKy;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.SinhVien;

/**
 *
 * @author Minh Hai
 */
public class QLSVDangKyController {

    ConnectDatabase conDb = new ConnectDatabase();

    public List<SVDangKy> getListLopHocTatCaSVDangKy() {
        List<SVDangKy> listSVDK = new ArrayList<>();
        String sql = "SELECT * FROM dbo.SVDangKy";
        try {
            PreparedStatement ps = conDb.conn.prepareStatement(sql);
            ResultSet re = ps.executeQuery();
            while (re.next()) {
                SVDangKy svdk = new SVDangKy();
                svdk.setMaSV(re.getString("MaSV"));
                svdk.setMaLH(re.getString("MaLH"));
                listSVDK.add(svdk);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Không lấy được danh sách lớp học đã đăng ký");
        }
        return listSVDK;
    }

    public List<LopHoc> getListLopHoc1SVDangKy(String maSV) {
        List<LopHoc> listLH = new ArrayList<>();
        String sql = "SELECT LopHoc.* FROM dbo.LopHoc INNER JOIN dbo.SVDangKy ON SVDangKy.MaLH = LopHoc.MaLH WHERE MaSV = '" + maSV + "'";
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
            JOptionPane.showMessageDialog(null, "Không lấy được danh sách lớp học đã đăng ký");
        }
        return listLH;
    }

    public List<SinhVien> getListSVDangKy1LopHoc(String maLH) {
        List<SinhVien> listSV = new ArrayList<>();
        String sql = "SELECT SinhVien.* FROM dbo.SinhVien INNER JOIN dbo.SVDangKy ON SVDangKy.MaSV = SinhVien.MaSV WHERE MaLH = '" + maLH + "'";
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
            JOptionPane.showMessageDialog(null, "Lớp học không tồn tại hoặc không có sinh viên nào đã đăng ký ");
        }
        return listSV;
    }

    public boolean dangKyLopHocSV(String maSV, String maLH) {
        String sql = "INSERT INTO dbo.SVDangKy VALUES(?,?)";
        try {
            PreparedStatement ps = conDb.conn.prepareStatement(sql);
            ps.setString(1, maSV);
            ps.setString(2, maLH);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Đăng ký thành công");
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Lỗi. Đăng ký thất bại\nCó thể lớp học này đã được đăng ký");
            System.out.println(e);
            return false;
        }
    }

    public boolean xoaLopHocSV(String maSV, String maLH) {
        String sql = "DELETE FROM dbo.SVDangKy WHERE MaSV = '" + maSV + "' AND MaLH = '" + maLH + "'";
        try {
            PreparedStatement ps = conDb.conn.prepareStatement(sql);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Xóa thành công");
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Lỗi. Xóa thất bại");
            System.out.println(e);
            return false;
        }
    }

    public LopHoc timKiemLopHocSV(String maSV, String maLH) {
        LopHoc lh = new LopHoc();
        String sql = "SELECT LopHoc.* FROM dbo.LopHoc INNER JOIN dbo.SVDangKy ON SVDangKy.MaLH = LopHoc.MaLH WHERE SVDangKy.MaSV = '" + maSV + "' AND LopHoc.MaLH = '" + maLH + "'";
        try {
            PreparedStatement pre = conDb.conn.prepareStatement(sql);
            ResultSet re = pre.executeQuery();
            if (re.next()) {
                lh.setMaLH(re.getString("MaLH"));
                lh.setTenLH(re.getString("TenLH"));
                lh.setThu(re.getString("Thu"));
                lh.setTiet(re.getString("Tiet"));
                lh.setNgayBatDau(re.getString("NgayBatDau"));
                lh.setSiSo(re.getInt("SiSo"));
                lh.setMaMH(re.getString("MaMH"));
                lh.setMaPH(re.getString("MaPH"));
                return lh;
            } else {
                JOptionPane.showMessageDialog(null, "Lớp học này chưa được đăng ký");
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
