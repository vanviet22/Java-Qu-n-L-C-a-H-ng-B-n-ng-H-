/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;
import DTO.TaiKhoan_DTO;
import DAO.user_DAO;

import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class USER_BUS {
    private ArrayList<TaiKhoan_DTO> dsTK = null;
    private user_DAO TKDAO = new user_DAO();

    public ArrayList<TaiKhoan_DTO> getListUser() {
        dsTK = TKDAO.getAllUser();
        return dsTK;
    }

    public ArrayList<TaiKhoan_DTO> Them(TaiKhoan_DTO tk) {
        dsTK.add(tk);
        TKDAO.ThemUser(tk);
        return dsTK;
    }

    public ArrayList<TaiKhoan_DTO> Xoa(int i, String ma) {
        TKDAO.XoaUser(ma);
        dsTK.remove(i);
        return dsTK;
    }

    public ArrayList<TaiKhoan_DTO> Sua(int i, TaiKhoan_DTO tk) {

        TKDAO.SuaUser(tk);
        TaiKhoan_DTO old = dsTK.set(i, tk);
        return dsTK;
    }

    private Vector headerUser() {
        Vector header = new Vector();
        header.add("UserName");
        header.add("PassWord");
        return header;
    }

    private Vector rowNCC(TaiKhoan_DTO tk) {
        Vector row = new Vector();
        row.add(tk.getMaNV());
        row.add(tk.getMk());
        return row;
    }

    public DefaultTableModel TimKiem(String YcTim, String values)
    {
        DefaultTableModel modelTam = new DefaultTableModel();
        Vector header = new Vector();
        header=headerUser();
        if(modelTam.getRowCount()==0)
        {
            modelTam=new DefaultTableModel(header, 0);
        }
        for (TaiKhoan_DTO tk : dsTK) {
            if(YcTim.equals("All") && (tk.getMaNV().equals(values) || tk.getMk().equals(values))
            || YcTim.equals("UserName") && tk.getMaNV().equals(values)
            || YcTim.equals("PassWord") && tk.getMk().equals(values)){

                Vector row = new Vector();
                row=rowNCC(tk);
                modelTam.addRow(row);
            }
        }
        return modelTam;
    }
}
