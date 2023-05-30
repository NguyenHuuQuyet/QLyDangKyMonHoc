    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import database.ConnectDatabase;
import model.MonHoc;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Minh Hai
 */
public class QLMonHocController {
    ConnectDatabase conDb = new ConnectDatabase();

    public List<MonHoc> getListMH() {
        List<MonHoc> listMH = new ArrayList<>();
        String sql = "SELECT * FROM dbo.MonHoc";
        try {
            PreparedStatement ps = conDb.conn.prepareStatement(sql);
            ResultSet re = ps.executeQuery();
            while (re.next()) {
                MonHoc mh = new MonHoc();
                mh.setMaMH(re.getString("MaMH"));
                mh.setTenMH(re.getString("TenMH"));
                mh.setSoTinChi(re.getInt("SoTinChi"));
                listMH.add(mh);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Không lấy được danh sách môn học");
        }
        return listMH;
    }

    public MonHoc getMH(String maMH){
        String sql = "SELECT * FROM dbo.MonHoc WHERE MaMH = '" + maMH + "'";
        try {
            PreparedStatement ps = conDb.conn.prepareStatement(sql);
            ResultSet re = ps.executeQuery();
            if(re.next()){
                MonHoc mh = new MonHoc();
                mh.setMaMH(re.getString("MaMH"));
                mh.setTenMH(re.getString("TenMH"));
                mh.setSoTinChi(re.getInt("SoTinChi"));
                return mh;
            } else  JOptionPane.showMessageDialog(null, "Môn học học không tồn tại");
        } catch (Exception e) {
            e.printStackTrace();
        }  
        return null;
    }
    
    public boolean themMH(MonHoc mh) {
        String sql = "INSERT INTO dbo.MonHoc VALUES(?,?,?)";
        try {
            PreparedStatement ps = conDb.conn.prepareStatement(sql);
            ps.setString(1, mh.getMaMH());
            ps.setString(2, mh.getTenMH());
            ps.setInt(3, mh.getSoTinChi());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Thêm thành công");
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Lỗi. Thêm thất bại\nMôn học này đã tồn tại");
            System.out.println(e);
            return false;
        }
    }

    public void xoaMH(String maMH) {
        String sql = "DELETE FROM dbo.MonHoc WHERE MaMH = '" + maMH + "'";
        try {
            PreparedStatement ps = conDb.conn.prepareStatement(sql);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Xóa thành công");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Lỗi. Thêm thất bại");
            System.out.println(e);
        }
    }

    public boolean suaMH(MonHoc mh) {
        String sql = "UPDATE dbo.MonHoc SET TenMH = ?, SoTinChi = ? WHERE MaMH = ? ";
        try {
            PreparedStatement ps = conDb.conn.prepareStatement(sql);
            ps.setString(1,mh.getTenMH());
            ps.setInt(2,mh.getSoTinChi());
            ps.setString(3,mh.getMaMH());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Sửa thành công");
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Lỗi. Sửa thất bại\n Môn học này không tồn tại");
            System.out.println(e);
            return false;
        }
    }

    public MonHoc timKiemByMaMH(String maMH) {
        String sql = "SELECT * FROM dbo.MonHoc WHERE MaMH = '" + maMH + "'";
        try {
            PreparedStatement pre = conDb.conn.prepareStatement(sql);
            ResultSet re = pre.executeQuery();
            if (re.next()) {
                String tenMH = re.getString("TenMH");
                int soTinChi = re.getInt("SoTinChi");
                MonHoc mh = new MonHoc(maMH, tenMH, soTinChi);
                return mh;
            } else {
                JOptionPane.showMessageDialog(null, "Không có môn học này trong hệ thống");
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
