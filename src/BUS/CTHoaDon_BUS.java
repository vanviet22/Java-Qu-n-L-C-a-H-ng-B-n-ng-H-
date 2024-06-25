package BUS;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import BUS.KhachHang_BUS;
import BUS.NhanVien_BUS;
import BUS.KMTheoSP_BUS;
import BUS.KMTheoTT_BUS;
import DAO.CTHoaDon_DAO;
import DAO.HoaDon_DAO;
import DTO.ChiTietHoaDon_DTO;
import DTO.HoaDon_DTO;
import DTO.KhachHang_DTO;
import DTO.loaiSP_DTO;
import DTO.NhanVien_DTO;
import DTO.SanPham_DTO;
import DTO.KMtheoTTien_DTO;
import java.time.LocalDateTime;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class CTHoaDon_BUS {
    private ArrayList<ChiTietHoaDon_DTO> listCTHD;
    private CTHoaDon_DAO cthd_DAO = new CTHoaDon_DAO();

    public ArrayList<ChiTietHoaDon_DTO> getListCTHD() {
        listCTHD = cthd_DAO.getListCTHD();
        return listCTHD;
    }

    public boolean themCTHD(ChiTietHoaDon_DTO cthd) {
        boolean flag = cthd_DAO.addCTHD(cthd);
        if (flag) {
            JOptionPane.showMessageDialog(null, "Thêm thành công", "Chi Tiết Hóa Đơn", JOptionPane.INFORMATION_MESSAGE);

        } else {
            JOptionPane.showMessageDialog(null, "Thêm thất bại", "Chi Tiết Hóa Đơn", JOptionPane.ERROR_MESSAGE);
        }
        return flag;
    }
    public boolean suaCTHD(ChiTietHoaDon_DTO cthd) {
        boolean flag = cthd_DAO.updateCTHD(cthd);
        if (flag) {
            JOptionPane.showMessageDialog(null, "Sửa thành công", "Chi Tiết Hóa Đơn", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Sửa thất bại", "Chi Tiết Hóa Đơn", JOptionPane.ERROR_MESSAGE);
        }
        return flag;
    }

    public boolean capNhapChiTietHoaDon(ChiTietHoaDon_DTO cthd) {
        boolean flag = cthd_DAO.updateChiTietHoaDonSuaNgay(cthd);
        return flag;
    }

    public boolean suaSoLuongSP(SanPham_DTO sp) {
        boolean flag = cthd_DAO.updateSLSP(sp);
        return flag;
    }

    public boolean suaSoLuongLoai(loaiSP_DTO loai) {
        boolean flag = cthd_DAO.updateSLLoai(loai);
        return flag;
    }

    public boolean deleteChiTietKhiXoaHoaDon(String maHD, String maSP) {
        boolean flag = cthd_DAO.deleteChiTietKhiXoaHoaDon(maHD, maSP);
        return flag;
    }

    public ArrayList<ChiTietHoaDon_DTO> timKiemCacCTHD(String maHD) {
        ArrayList<ChiTietHoaDon_DTO> listCTHDLoad = new ArrayList<ChiTietHoaDon_DTO>();
        for (ChiTietHoaDon_DTO cthd : listCTHD) {
            if (maHD.equals(cthd.getMaHD())) {
                listCTHDLoad.add(cthd);
            }
        }
        return listCTHDLoad;
    }

    public ArrayList<ChiTietHoaDon_DTO> timKiemCTHD(String thuMuc, String tuKhoa) {
        ArrayList<ChiTietHoaDon_DTO> listCTHD = cthd_DAO.searchCTHD(thuMuc, tuKhoa);
        return listCTHD;
    }

}
