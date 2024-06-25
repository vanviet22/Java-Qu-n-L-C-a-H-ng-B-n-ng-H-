
package BUS;

import DTO.CTPN_DTO;
import DAO.CTPN_DAO;

import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class CTPN_BUS {
    private ArrayList<CTPN_DTO> dsCTPN = null;
    private CTPN_DAO CTPNDAO = new CTPN_DAO();

    public ArrayList<CTPN_DTO> getListCTPN() {
        dsCTPN = CTPNDAO.getAllCTPN();
        return dsCTPN;
    }

    public ArrayList<CTPN_DTO> Them(CTPN_DTO ctpn) {
        dsCTPN.add(ctpn);
        CTPNDAO.ThemCTPN(ctpn);
        return dsCTPN;
    }

    public ArrayList<CTPN_DTO> Xoa(int i, String ma1, String ma2) {
        CTPNDAO.XoaCTPN(ma1, ma2);
        dsCTPN.remove(i);
        return dsCTPN;
    }

    public ArrayList<CTPN_DTO> Sua(int i, CTPN_DTO ctpn) {
        // ctpn.setThanhTien(ThanhTien);
        CTPNDAO.SuaCTPN(ctpn);
        CTPN_DTO old = dsCTPN.set(i, ctpn);
        return dsCTPN;
    }

    private Vector headerCTPN() {
        Vector header = new Vector();
        header.add("Mã PN");
        header.add("Mã SP");
        header.add("Số lượng");
        header.add("Giá nhập");
        header.add("Thành tiền");
        return header;
    }

    private Vector rowCTPN(CTPN_DTO ctpn) {
        Vector row = new Vector();
        row.add(ctpn.getMaPN());
        row.add(ctpn.getMaSP());
        row.add(ctpn.getSoLuong());
        row.add(ctpn.getGiaNhap());
        row.add(ctpn.getThanhTien());
        return row;
    }

    public DefaultTableModel TimKiem(String YcTim, String values) {
        DefaultTableModel modelTam = new DefaultTableModel();
        Vector header = new Vector();
        header = headerCTPN();
        if (modelTam.getRowCount() == 0) {
            modelTam = new DefaultTableModel(header, 0);
        }
        for (CTPN_DTO i : dsCTPN) {
            if (YcTim.equals("Mã PN") && i.getMaPN().equals(values)
                    || YcTim.equals("Mã SP") && i.getMaSP().equals(values)) {

                Vector row = new Vector();
                row = rowCTPN(i);
                modelTam.addRow(row);
            }
        }
        return modelTam;
    }

    public DefaultTableModel TKCTPN(ArrayList<CTPN_DTO> ds, String ma, DefaultTableModel modelTam) {
        Vector header = new Vector();
        header = headerCTPN();
        if (modelTam.getRowCount() == 0) {
            modelTam = new DefaultTableModel(header, 0);
        }
        for (CTPN_DTO ctpn : ds) {
            if (ctpn.getMaPN().equals(ma)) {
                Vector row = new Vector();
                row = rowCTPN(ctpn);
                modelTam.addRow(row);
            }
        }
        return modelTam;
    }
}
