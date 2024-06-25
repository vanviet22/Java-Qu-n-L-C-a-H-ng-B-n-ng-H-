package BUS;
import DTO.HoaDon_DTO;
import DTO.ChiTietHoaDon_DTO;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
public class ThongKe_BUS {
    private HoaDon_BUS hoaDon_BUS = new HoaDon_BUS();
    private CTHoaDon_BUS cthoaDon_BUS = new CTHoaDon_BUS();
    private ArrayList<HoaDon_DTO> listHD = hoaDon_BUS.getListHD();
    private ArrayList<ChiTietHoaDon_DTO> listCTHD = cthoaDon_BUS.getListCTHD();
    private boolean kiemTraNamTKSP(String ngayHoaDon, int valueNam) {
        // Kiểm tra độ dài chuỗi ngayHoaDon trước khi cắt chuỗi
        if (ngayHoaDon.length() < 4) {
            return false; // Chuỗi ngày không đủ dài để lấy năm
        }

        // Lấy năm từ chuỗi ngày hóa đơn
        String namHoaDon = ngayHoaDon.substring(0, 4);

        try {
            int namInt = Integer.parseInt(namHoaDon);
            // So sánh năm từ chuỗi ngày và giá trị từ jSpinnerNam
            return valueNam == namInt;
        } catch (NumberFormatException e) {
            // Xử lý nếu giá trị từ jSpinnerNam không phải là một số hợp lệ
            e.printStackTrace(); // Hoặc thực hiện xử lý khác tùy vào ngữ cảnh
            return false;
        }
    }

    public Map<String, Integer> thongKeSanPham(int valueNam) {
        Map<String, Integer> listSanPham = new HashMap<>();
        for (HoaDon_DTO hd : listHD) {
            LocalDateTime ngayLap = hd.getNgayLap();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            String str = ngayLap.format(formatter);
            if (kiemTraNamTKSP(str, valueNam)) {
                for (ChiTietHoaDon_DTO cthd : listCTHD) {
                    if (cthd.getMaHD().equals(hd.getMaHD())) {
                        String maSP = cthd.getMaSP();
                        int soLuongSP = cthd.getSoLuong();
            
                        // Nếu sản phẩm đã có trong map, cộng số lượng mới vào số lượng đã có
                        if (listSanPham.containsKey(maSP)) {
                            int tongSoLuong = listSanPham.get(maSP);
                            listSanPham.put(maSP, tongSoLuong + soLuongSP);
                        } else {
                            // Nếu sản phẩm chưa có trong map, thêm sản phẩm vào map với số lượng tương ứng
                            listSanPham.put(maSP, soLuongSP);
                        }
                    }
                }
            }
        }
        return listSanPham;
    }
    private boolean kiemTraNamTKKH(String ngayHoaDon, int valueNam) {
        // Kiểm tra độ dài chuỗi ngayHoaDon trước khi cắt chuỗi
        if (ngayHoaDon.length() < 4) {
            return false; // Chuỗi ngày không đủ dài để lấy năm
        }

        // Lấy năm từ chuỗi ngày hóa đơn
        String namHoaDon = ngayHoaDon.substring(0, 4);

        try {
            int namInt = Integer.parseInt(namHoaDon);

            // So sánh năm từ chuỗi ngày và giá trị từ jSpinnerNam
            return valueNam == namInt;
        } catch (NumberFormatException e) {
            // Xử lý nếu giá trị từ jSpinnerNam không phải là một số hợp lệ
            e.printStackTrace(); // Hoặc thực hiện xử lý khác tùy vào ngữ cảnh
            return false;
        }
    }
    public Map<String, Double> thongKeKhachHang(int valueNam) {
        Map<String, Double> listKhachHang = new HashMap<>();
        for (HoaDon_DTO hd : listHD) {
            LocalDateTime ngayLap = hd.getNgayLap();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            String str = ngayLap.format(formatter);
            if (kiemTraNamTKKH(str, valueNam)) {
                // listMaKH.add(hd.getMaKH());
                // listTongTien.add(hd.getTongTien());
                String maKH = hd.getMaKH();
                Double tongTien = hd.getTongTien();
                // Nếu sản phẩm đã có trong map, cộng số lượng mới vào số lượng đã có
                if (listKhachHang.containsKey(maKH)) {
                    Double Tong = listKhachHang.get(maKH);
                    listKhachHang.put(maKH, Tong + tongTien);
                } else {
                    // Nếu sản phẩm chưa có trong map, thêm sản phẩm vào map với số lượng tương ứng
                    listKhachHang.put(maKH, tongTien);
                }
            }
        }
        return listKhachHang;
    }
}
