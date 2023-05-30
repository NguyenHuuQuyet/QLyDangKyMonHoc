/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

/**
 *
 * @author Minh Hai
 */
public class InsertDefaultData {

    ConnectDatabase conDb = new ConnectDatabase();

    public void themTK() {
        String sql1 = "INSERT INTO dbo.TaiKhoan VALUES ('sv001', '123', N'Sinh viên')";
        String sql2 = "INSERT INTO dbo.TaiKhoan VALUES ('sv002', '123', N'Sinh viên')";
        String sql3 = "INSERT INTO dbo.TaiKhoan VALUES ('sv003', '123', N'Sinh viên')";
        String sql4 = "INSERT INTO dbo.TaiKhoan VALUES ('sv004', '123', N'Sinh viên')";
        String sql5 = "INSERT INTO dbo.TaiKhoan VALUES ('gv001', '123', N'Giảng viên')";
        String sql6 = "INSERT INTO dbo.TaiKhoan VALUES ('gv002', '123', N'Giảng viên')";
        String sql7 = "INSERT INTO dbo.TaiKhoan VALUES ('gv003', '123', N'Giảng viên')";
        String sql8 = "INSERT INTO dbo.TaiKhoan VALUES ('qtv01', '123', N'Quản trị viên')";
        String sql9 = "INSERT INTO dbo.TaiKhoan VALUES ('qtv02', '123', N'Quản trị viên')";
        conDb.excuteSQL(sql1);
        conDb.excuteSQL(sql2);
        conDb.excuteSQL(sql3);
        conDb.excuteSQL(sql4);
        conDb.excuteSQL(sql5);
        conDb.excuteSQL(sql6);
        conDb.excuteSQL(sql7);
        conDb.excuteSQL(sql8);
        conDb.excuteSQL(sql9);
    }

    public void themSV() {
        String sql1 = "INSERT INTO dbo.SinhVien VALUES ('SV001', N'Quyền Minh Hải', 'CNTT06-K13', '0123111001', N'Nam Định', 'quyenminhhai1608@gmail.com', 'sv001')";
        String sql2 = "INSERT INTO dbo.SinhVien VALUES ('SV002', N'Vũ Ngọc Khiêm', 'CNTT06-K13', '0123111002', N'Bắc Ninh', 'khiemvn@gmail.com', 'sv002')";
        String sql3 = "INSERT INTO dbo.SinhVien VALUES ('SV003', N'Ninh Văn Tuấn', 'CNTT06-K13', '0123111003', N'Nam Định', 'tuannv@gmail.com', 'sv003')";
        String sql4 = "INSERT INTO dbo.SinhVien VALUES ('SV004', N'Nguyễn Đăng Nam', 'CNTT06-K13', '0123111004', N'Vĩnh Phúc', 'namnd@gmail.com', 'sv004')";
        conDb.excuteSQL(sql1);
        conDb.excuteSQL(sql2);
        conDb.excuteSQL(sql3);
        conDb.excuteSQL(sql4);
    }

    public void themGV() {
        String sql1 = "INSERT INTO dbo.GiangVien VALUES ('GV001', N'Vũ Thị Dương', 'CNTT', '0123222001', 'duongvt@gmail.com', 'gv001')";
        String sql2 = "INSERT INTO dbo.GiangVien VALUES ('GV002', N'Trần Phương Nhung', 'CNTT', '0123222002', 'nhungtp@gmail.com', 'gv002')";
        String sql3 = "INSERT INTO dbo.GiangVien VALUES ('GV003', N'Hà Mạnh Đào', 'CNTT', '0123222003', 'daohm@gmail.com', 'gv003')";
        conDb.excuteSQL(sql1);
        conDb.excuteSQL(sql2);
        conDb.excuteSQL(sql3);
    }

    public void themQTV() {
        String sql1 = "INSERT INTO dbo.QuanTriVien VALUES ('QTV01', N'Nguyễn Văn A', 'qtv01')";
        String sql2 = "INSERT INTO dbo.QuanTriVien VALUES ('QTV02', N'Nguyễn Văn B', 'qtv02')";
        conDb.excuteSQL(sql1);
        conDb.excuteSQL(sql2);
    }

    public void themMH() {
        String sql1 = "INSERT INTO dbo.MonHoc VALUES ('MH001', N'Lập trình Java', 4)";
        String sql2 = "INSERT INTO dbo.MonHoc VALUES ('MH002', N'Lập trình C++', 3)";
        String sql3 = "INSERT INTO dbo.MonHoc VALUES ('MH003', N'Lập trình C#', 4)";
        String sql4 = "INSERT INTO dbo.MonHoc VALUES ('MH004', N'Hệ quản trị cơ sở dữ liệu', 3)";
        String sql5 = "INSERT INTO dbo.MonHoc VALUES ('MH005', N'Phân tích thiết kế hệ thống', 3)";
        String sql6 = "INSERT INTO dbo.MonHoc VALUES ('MH006', N'Thiết kế CSDL', 3)";
        conDb.excuteSQL(sql1);
        conDb.excuteSQL(sql2);
        conDb.excuteSQL(sql3);
        conDb.excuteSQL(sql4);
        conDb.excuteSQL(sql5);
        conDb.excuteSQL(sql6);
    }

    public void themPH() {
        String sql1 = "INSERT INTO dbo.PhongHoc VALUES ('PH001', 'P302 A9', N'Vừa')";
        String sql2 = "INSERT INTO dbo.PhongHoc VALUES ('PH002', 'P301 A9', N'Vừa')";
        String sql3 = "INSERT INTO dbo.PhongHoc VALUES ('PH003', 'P307 A9', N'Nhỏ')";
        String sql4 = "INSERT INTO dbo.PhongHoc VALUES ('PH004', 'PM1 A1', N'To')";
        String sql5 = "INSERT INTO dbo.PhongHoc VALUES ('PH005', 'PM2 A1', N'To')";
        String sql6 = "INSERT INTO dbo.PhongHoc VALUES ('PH006', 'PM3 A1', N'Vừa')";
        conDb.excuteSQL(sql1);
        conDb.excuteSQL(sql2);
        conDb.excuteSQL(sql3);
        conDb.excuteSQL(sql4);
        conDb.excuteSQL(sql5);
        conDb.excuteSQL(sql6);
    }

    public void themLH() {
        String sql1 = "INSERT INTO dbo.LopHoc VALUES ('LH001', 'Java 1', N'Th 2', '13,14,15,16','14/06/2021', 75, 'MH001', 'PH004')";
        String sql2 = "INSERT INTO dbo.LopHoc VALUES ('LH002', 'Java 2', N'Th 5', '13,14,15,16','17/06/2021', 75, 'MH001', 'PH005')";
        String sql3 = "INSERT INTO dbo.LopHoc VALUES ('LH003', 'C++ 1', N'Th 3', '1,2,3,4','15/06/2021', 75, 'MH002', 'PH006')";
        String sql4 = "INSERT INTO dbo.LopHoc VALUES ('LH004', 'C# 1', N'Th 4', '1,2,3,4,5,6','16/06/2021', 75, 'MH003', 'PH005')";
        String sql5 = "INSERT INTO dbo.LopHoc VALUES ('LH005', 'SQL 1', N'Th 5', '7,8,9,10','17/06/2021', 75, 'MH004', 'PH003')";
        String sql6 = "INSERT INTO dbo.LopHoc VALUES ('LH006', 'PTTKHT 1', N'Th 6', '3,4,5,6','18/06/2021', 75, 'MH005', 'PH001')";
        String sql7 = "INSERT INTO dbo.LopHoc VALUES ('LH007', 'TKCSDL 1', N'Th 7', '9,10,11,12','19/06/2021', 75, 'MH006', 'PH001')";
        conDb.excuteSQL(sql1);
        conDb.excuteSQL(sql2);
        conDb.excuteSQL(sql3);
        conDb.excuteSQL(sql4);
        conDb.excuteSQL(sql5);
        conDb.excuteSQL(sql6);
        conDb.excuteSQL(sql7);
    }

    public void themSVDangKy() {
        String sql1 = "INSERT INTO dbo.SVDangKy VALUES ('SV001', 'LH001')";
        String sql2 = "INSERT INTO dbo.SVDangKy VALUES ('SV001', 'LH002')";
        String sql3 = "INSERT INTO dbo.SVDangKy VALUES ('SV001', 'LH003')";
        String sql4 = "INSERT INTO dbo.SVDangKy VALUES ('SV001', 'LH004')";
        String sql5 = "INSERT INTO dbo.SVDangKy VALUES ('SV001', 'LH005')";
        String sql6 = "INSERT INTO dbo.SVDangKy VALUES ('SV001', 'LH006')";
        String sql7 = "INSERT INTO dbo.SVDangKy VALUES ('SV001', 'LH007')";
        String sql8 = "INSERT INTO dbo.SVDangKy VALUES ('SV002', 'LH002')";
        String sql9 = "INSERT INTO dbo.SVDangKy VALUES ('SV003', 'LH003')";
        String sql10 = "INSERT INTO dbo.SVDangKy VALUES ('SV004', 'LH004')";
        String sql11 = "INSERT INTO dbo.SVDangKy VALUES ('SV002', 'LH006')";
        String sql12 = "INSERT INTO dbo.SVDangKy VALUES ('SV003', 'LH007')";
        conDb.excuteSQL(sql1);
        conDb.excuteSQL(sql2);
        conDb.excuteSQL(sql3);
        conDb.excuteSQL(sql4);
        conDb.excuteSQL(sql5);
        conDb.excuteSQL(sql6);
        conDb.excuteSQL(sql7);
        conDb.excuteSQL(sql8);
        conDb.excuteSQL(sql9);
        conDb.excuteSQL(sql10);
        conDb.excuteSQL(sql11);
        conDb.excuteSQL(sql12);        
    }

    public void themGVDangKy() {
        String sql1 = "INSERT INTO dbo.GVDangKy VALUES ('GV001', 'LH001')";
        String sql2 = "INSERT INTO dbo.GVDangKy VALUES ('GV001', 'LH002')";
        String sql3 = "INSERT INTO dbo.GVDangKy VALUES ('GV002', 'LH003')";
        String sql4 = "INSERT INTO dbo.GVDangKy VALUES ('GV003', 'LH004')";
        String sql5 = "INSERT INTO dbo.GVDangKy VALUES ('GV002', 'LH005')";
        String sql6 = "INSERT INTO dbo.GVDangKy VALUES ('GV003', 'LH006')";
        String sql7 = "INSERT INTO dbo.GVDangKy VALUES ('GV003', 'LH007')";
        conDb.excuteSQL(sql1);
        conDb.excuteSQL(sql2);
        conDb.excuteSQL(sql3);
        conDb.excuteSQL(sql4);
        conDb.excuteSQL(sql5);
        conDb.excuteSQL(sql6);
        conDb.excuteSQL(sql7);
    }
}
