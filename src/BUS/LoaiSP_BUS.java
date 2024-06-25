
package BUS;
    
import DTO.loaiSP_DTO;
import DAO.LoaiSP_DAO;

import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class LoaiSP_BUS {
    private ArrayList<loaiSP_DTO> dsLoai = null;
    private LoaiSP_DAO LoaiDAO = new LoaiSP_DAO();

    public ArrayList<loaiSP_DTO> getListLoai() {
        dsLoai = LoaiDAO.getAllLoaiSP();
        return dsLoai;
    }

    public ArrayList<loaiSP_DTO> Them(loaiSP_DTO loai) {
        dsLoai.add(loai);
        LoaiDAO.ThemLoai(loai);
        return dsLoai;
    }

    public ArrayList<loaiSP_DTO> Xoa(int i, String ma) {
        LoaiDAO.XoaLoai(ma);
        dsLoai.remove(i);
        return dsLoai;
    }

    public ArrayList<loaiSP_DTO> Sua(int i, loaiSP_DTO loai) {
        LoaiDAO.SuaLoai(loai);
        loaiSP_DTO old = dsLoai.set(i, loai);
        return dsLoai;
    }

    // public ArrayList<loaiSP_DTO> Sua(int i,String ma,String Ten,int Soluong) {
    // loaiSP_DTO loai = new loaiSP_DTO();
    // loai.setMaLoai(ma);
    // loai.setTenLoai(Ten);
    // loai.setSoluong(Soluong);
    // LoaiDAO.SuaLoai(loai);
    // loaiSP_DTO old=dsLoai.set(i, loai);
    // return dsLoai;
    // }

    private Vector headerLoai() {
        Vector header = new Vector();
        header.add("Mã loại");
        header.add("Tên loại");
        header.add("Số lượng");
        return header;
    }

    private Vector rowLoai(loaiSP_DTO loai) {
        Vector row = new Vector();
        row.add(loai.getMaLoai());
        row.add(loai.getTenLoai());
        row.add(loai.getSoluong());
        return row;
    }

    public DefaultTableModel TimKiem(String YcTim, String values) {
        DefaultTableModel modelTam = new DefaultTableModel();
        Vector header = new Vector();
        header = headerLoai();
        if (modelTam.getRowCount() == 0) {
            modelTam = new DefaultTableModel(header, 0);
        }
        for (loaiSP_DTO loai : dsLoai) {
            if (YcTim.equals("Mã") && loai.getMaLoai().equals(values)
                    || YcTim.equals("Tên") && loai.getTenLoai().equals(values)) {

                Vector row = new Vector();
                row = rowLoai(loai);
                modelTam.addRow(row);
            }
        }
        return modelTam;
    }
}
