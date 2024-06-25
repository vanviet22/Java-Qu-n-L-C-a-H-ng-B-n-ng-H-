package BUS;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import BUS.KhachHang_BUS;
import BUS.NhanVien_BUS;
import BUS.KMTheoSP_BUS;
import BUS.KMTheoTT_BUS;
import DAO.HoaDon_DAO;
import DTO.ChiTietHoaDon_DTO;
import DTO.HoaDon_DTO;
import DTO.KhachHang_DTO;
import DTO.NhanVien_DTO;
import DTO.KMtheoTTien_DTO;

import java.time.LocalDateTime;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class HoaDon_BUS {
    private ArrayList<HoaDon_DTO> listHoaDon;
    private ArrayList<KhachHang_DTO> listKhachHang;
    private ArrayList<NhanVien_DTO> listNhanVien;
    private ArrayList<KMtheoTTien_DTO> listKMTheoTT;
    private HoaDon_DAO hoaDon_DAO = new HoaDon_DAO();

    public ArrayList<HoaDon_DTO> getListHD() {
        listHoaDon = hoaDon_DAO.getListHoaDon();
        return listHoaDon;
    }

    public boolean themHoaDon(HoaDon_DTO hoaDon) {
        boolean flag = hoaDon_DAO.addHoaDon(hoaDon);
        if (flag) {
            JOptionPane.showMessageDialog(null, "Thêm thành công", "Hóa Đơn", JOptionPane.INFORMATION_MESSAGE);

        } else {
            JOptionPane.showMessageDialog(null, "Thêm thất bại", "Hóa Đơn", JOptionPane.ERROR_MESSAGE);
        }
        return flag;
    }

    public boolean capNhatHoaDon(HoaDon_DTO hoaDon) {
        boolean flag = hoaDon_DAO.updateHoaDon(hoaDon);
        if (flag) {
            JOptionPane.showMessageDialog(null, "Sửa thành công", "Hóa Đơn", JOptionPane.INFORMATION_MESSAGE);

        } else {
            JOptionPane.showMessageDialog(null, "Sửa thất bại", "Hóa Đơn", JOptionPane.ERROR_MESSAGE);
        }
        return flag;
    }

    public boolean capNhatHoaDonKhiSuaChiTiet(HoaDon_DTO hoaDon) {
        boolean flag = hoaDon_DAO.updateHoaDon(hoaDon);
        return flag;
    }

    public boolean xoaHoaDon(String maHD) {
        boolean flag = hoaDon_DAO.deleteHoaDon(maHD);
        if (flag) {
            JOptionPane.showMessageDialog(null, "Xóa thành công", "Hóa Đơn", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Xóa thất bại", "Hóa Đơn", JOptionPane.ERROR_MESSAGE);
        }
        return flag;
    }

    public ArrayList<HoaDon_DTO> TimKiemKhongNgay(String thuMuc, String tuKhoa) {
        ArrayList<HoaDon_DTO> listHD = hoaDon_DAO.searchHDKhongNgay(thuMuc, tuKhoa);
        return listHD;
    }

    public ArrayList<HoaDon_DTO> timKiemHDTheoNgay(String ngayBD, String ngayKT, String thuMuc, String tuKhoa) {
        ArrayList<HoaDon_DTO> listHD = hoaDon_DAO.searchHDTheoNgay(ngayBD, ngayKT, thuMuc, tuKhoa);
        return listHD;
    }

    public ArrayList<HoaDon_DTO> timKiemHDTheoNgayNhoHonHoacBang(String ngayBD, String thuMuc, String tuKhoa) {
        ArrayList<HoaDon_DTO> listHD = hoaDon_DAO.searchHDTheoNgayNhoHonHoacBang(ngayBD, thuMuc, tuKhoa);
        return listHD;
    }

    public ArrayList<HoaDon_DTO> timKiemHDTheoNgayLonHonHoacBang(String ngayKT, String thuMuc, String tuKhoa) {
        ArrayList<HoaDon_DTO> listHD = hoaDon_DAO.searchHDTheoNgayLonHonHoacBang(ngayKT, thuMuc, tuKhoa);
        return listHD;
    }

    public ArrayList<HoaDon_DTO> timKiemHDTheoNgay(String ngayBD, String ngayKT) {
        ArrayList<HoaDon_DTO> listHD = hoaDon_DAO.searchHDTheoNgay(ngayBD, ngayKT);
        return listHD;
    }

    public ArrayList<HoaDon_DTO> timKiemHDTheoNgayNhoHonHoacBang(String ngayBD) {
        ArrayList<HoaDon_DTO> listHD = hoaDon_DAO.searchHDTheoNgayNhoHonHoacBang(ngayBD);
        return listHD;
    }

    public ArrayList<HoaDon_DTO> timKiemHDTheoNgayLonHonHoacBang(String ngayKT) {
        ArrayList<HoaDon_DTO> listHD = hoaDon_DAO.searchHDTheoNgayLonHonHoacBang(ngayKT);
        return listHD;
    }
}
