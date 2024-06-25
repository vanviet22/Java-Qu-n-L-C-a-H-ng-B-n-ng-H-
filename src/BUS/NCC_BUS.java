/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;
import DTO.NCC_DTO;
import DAO.NCC_DAO;

import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class NCC_BUS {
    private ArrayList<NCC_DTO> dsNCC = null;
    private NCC_DAO NCCDAO = new NCC_DAO();

    public ArrayList<NCC_DTO> getListNCC() {
        dsNCC = NCCDAO.getAllNCC();
        return dsNCC;
    }

    public ArrayList<NCC_DTO> Them(NCC_DTO ncc) {
        dsNCC.add(ncc);
        NCCDAO.ThemNCC(ncc);
        return dsNCC;
    }

    public ArrayList<NCC_DTO> Xoa(int i, String ma) {
        NCCDAO.XoaNCC(ma);
        dsNCC.remove(i);
        return dsNCC;
    }

    public ArrayList<NCC_DTO> Sua(int i, NCC_DTO ncc) {
        NCCDAO.SuaNCC(ncc);
        NCC_DTO old = dsNCC.set(i, ncc);
        return dsNCC;
    }

    private Vector headerNCC() {
        Vector header = new Vector();
        header.add("Mã NCC");
        header.add("Tên NCC");
        header.add("Địa chỉ");
        header.add("SĐT");
        header.add("Gmail");
        header.add("Trạng thái");
        return header;
    }

    private Vector rowNCC(NCC_DTO ncc) {
        Vector row = new Vector();
        try {
            row.add(ncc.getMaNCC());
            row.add(ncc.getTenNCC());
            row.add(ncc.getDcNCC());
            row.add(ncc.getSdtNCC());
            row.add(ncc.getGmail());
            row.add(ncc.getTrangThai());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return row;
    }

    public DefaultTableModel TimKiem(String YcTim, String values) {
        DefaultTableModel modelTam = new DefaultTableModel();
        Vector header = new Vector();
        header = headerNCC();
        if (modelTam.getRowCount() > 0) {
            modelTam = new DefaultTableModel(header, 0);
        }
        for (NCC_DTO ncc : dsNCC) {
            if (YcTim.equals("Mã NCC") && ncc.getMaNCC().equals(values)
                    || YcTim.equals("Tên NCC") && ncc.getTenNCC().equals(values)
                    || YcTim.equals("Địa chỉ") && ncc.getDcNCC().equals(values)
                    || YcTim.equals("SĐT") && ncc.getSdtNCC().equals(values)
                    || YcTim.equals("Gmail") && ncc.getGmail().equals(values)) {

                Vector row = new Vector();
                row = rowNCC(ncc);
                modelTam.addRow(row);
            }
        }
        return modelTam;
    }
}
