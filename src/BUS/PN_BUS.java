
package BUS;

import DTO.PhieuNhap_DTO;
import DAO.PN_DAO;
import DTO.CTPN_DTO;
import DTO.NCC_DTO;
import DTO.NhanVien_DTO;
import DTO.SanPham_DTO;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class PN_BUS {
    private ArrayList<PhieuNhap_DTO> dsPN = null;
    private PN_DAO PNDAO = new PN_DAO();

    public ArrayList<PhieuNhap_DTO> getListPN() {
        dsPN = PNDAO.getAllPN();
        return dsPN;
    }

    public ArrayList<PhieuNhap_DTO> Them(PhieuNhap_DTO pn) {
        dsPN.add(pn);
        PNDAO.ThemPN(pn);
        return dsPN;
    }

    public ArrayList<PhieuNhap_DTO> Xoa(int i, String ma) {
        PNDAO.XoaPN(ma);
        dsPN.remove(i);
        return dsPN;
    }

    public ArrayList<PhieuNhap_DTO> Sua(int i, PhieuNhap_DTO pn) {
        PNDAO.SuaPN(pn);
        PhieuNhap_DTO old = dsPN.set(i, pn);
        return dsPN;
    }

    // public ArrayList<PhieuNhap_DTO> Sua(int i,String MaPN,String MaNCC,String
    // MaNV,LocalDate localDate,String TongSoLuong,String TongTien) {
    // PhieuNhap_DTO pn = new PhieuNhap_DTO();
    // pn.setMaPN(MaPN);
    // pn.setMaNV(MaNV);
    // pn.setMaNCC(MaNCC);
    // pn.setNgayLap(localDate.atStartOfDay());
    // pn.setSoLuong(Integer.parseInt(TongSoLuong));
    // pn.setTongTien(Double.parseDouble(TongTien));
    // PNDAO.SuaPN(pn);
    // PhieuNhap_DTO old = dsPN.set(i, pn);
    // return dsPN;
    // }
    private Vector headerPN() {
        Vector header = new Vector();
        header.add("Mã PN");
        header.add("Mã NV");
        header.add("Mã NCC");
        header.add("Ngày lập");
        header.add("SL");
        header.add("Tổng tiền");
        return header;
    }

    private Vector rowPN(PhieuNhap_DTO i) {
        Vector row = new Vector();
        row.add(i.getMaPN());
        row.add(i.getMaNV());
        row.add(i.getMaNCC());
        // row.add(pn.getNgayLap());
        row.add(String.valueOf(i.getNgayLap().toLocalDate()));
        row.add(i.getSoLuong());
        row.add(i.getTongTien());
        return row;
    }

    public DefaultTableModel TimKiem(String YcTim, String values) {
        DefaultTableModel modelTam = new DefaultTableModel();
        Vector header = new Vector();
        header = headerPN();
        if (modelTam.getRowCount() == 0) {
            modelTam = new DefaultTableModel(header, 0);
        }
        for (PhieuNhap_DTO i : dsPN) {
            if (YcTim.equals("Mã PN") && i.getMaPN().equals(values)
                    || YcTim.equals("Mã NCC") && i.getMaNCC().equals(values)
                    || YcTim.equals("Mã NV") && i.getMaNV().equals(values)
                    || YcTim.equals("Ngày lập") && i.getNgayLap().equals(values)) {

                Vector row = new Vector();
                row = rowPN(i);
                modelTam.addRow(row);
            }
        }
        return modelTam;
    }
    public SanPham_DTO getSP(ArrayList<SanPham_DTO> dsSP,String ma){
        for(SanPham_DTO i:dsSP)
            if(i.getMaSp().equals(ma))
                return i;
        return null;
    }
    
    public NhanVien_DTO getNV(ArrayList<NhanVien_DTO> dsNV, String ma){
        for(NhanVien_DTO i:dsNV)
            if(i.getMaNV().equals(ma))
                return i;
        return null;
    }
    
    public NCC_DTO getNCC(ArrayList<NCC_DTO> dsNCC, String ma){
        for(NCC_DTO i:dsNCC)
            if(i.getMaNCC().equals(ma))
                return i;
        return null;
    }
    
    public void In(String fileName,PhieuNhap_DTO pn,ArrayList<CTPN_DTO> dsCTPN,ArrayList<SanPham_DTO> dsSP,ArrayList<NhanVien_DTO>dsNV,ArrayList<NCC_DTO> dsNCC){
        try (FileWriter writer = new FileWriter(fileName)) {
            NCC_DTO ncc=new NCC_DTO();
            ncc=getNCC(dsNCC,pn.getMaNCC());
            NhanVien_DTO nv=new NhanVien_DTO();
            nv=getNV(dsNV,pn.getMaNV());
            writer.write(String.format("%-30s %-50s \n", " ","Cửa hàng bán đồng hồ"));
//            writer.write("Mã PN: "+ pn.getMaPN() + "                    " + "Ngày lập: "+ pn.getNgayLap().toLocalDate() + "\n");
            writer.write(String.format("%-80s %-20s \n", "Mã PN: " + pn.getMaPN(), "Ngày lập: " + pn.getNgayLap().toLocalDate()));
//            writer.write("Mã NCC: " + pn.getMaNCC() + "                 " + "Tên NCC: " + ncc.getTenNCC() + "\n");
            writer.write(String.format("%-80s %-20s \n", "Mã NCC: " + pn.getMaNCC(), "Tên NCC: " + ncc.getTenNCC()));
//            writer.write("Mã NV: " + pn.getMaNV() + "              " + "Tên NV: " + nv.getTen() + "\n");
            writer.write(String.format("%-80s %-20s \n", "Mã NV: " + pn.getMaNV(), "Tên NV: " + nv.getTen()));
            writer.write("-------------------------------------------------------------------------------------------------------\n");
            writer.write(String.format("%-10s %-50s %-10s %-15s %-15s\n", "Mã SP", "Tên SP", "Số lượng", "Giá nhập", "Thành tiền"));
            writer.write("--------------------------------------------------------------------------------------------------------\n");

            double TongTien = 0;
            int TongSP = 0;
            for (CTPN_DTO i:dsCTPN) {
                if(i.getMaPN().equals(pn.getMaPN()))
                {
                    SanPham_DTO sp=new SanPham_DTO();
                    sp=getSP(dsSP,i.getMaSP());
                    writer.write(String.format("%-10s %-50s %-10d %-15.2f %-15.2f \n", i.getMaSP(), sp.getTenSP(), i.getSoLuong(),i.getGiaNhap(), i.getThanhTien()));
                    TongSP += i.getSoLuong();
                    TongTien +=i.getThanhTien();
                }
            }

            writer.write("--------------------------------------------------------------------------------------------------------\n");
writer.write(String.format("%-61s %-26s %-15.2f\n", "Tổng: ", TongSP, TongTien));
            JOptionPane.showMessageDialog(null, "In phiếu nhập có mã "+pn.getMaPN()+" thành công");
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }
}