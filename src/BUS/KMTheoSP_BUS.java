/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;
import DAO.KMTheoSP_DAO;
import DTO.KMtheoSP_DTO;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
public class KMTheoSP_BUS {
    private ArrayList<KMtheoSP_DTO> ds= null;
    private KMTheoSP_DAO DAO = new KMTheoSP_DAO();
    public ArrayList<KMtheoSP_DTO> getList()
    {
        ds=DAO.getAllKMSP();
        return ds;
    }
    public ArrayList<KMtheoSP_DTO> ThemKMSP(KMtheoSP_DTO kmSP)
    {
        
        ds.add(kmSP);
        DAO.ThemKMSP(kmSP);
        return ds;
    }
    public ArrayList<KMtheoSP_DTO> xoaTheoMaCT(int i,String ma)
    {
        DAO.XoaKMSPTheoMACT(ma);
        ds.remove(i);
        return ds;
    }
    public ArrayList<KMtheoSP_DTO> xoaKMSP(int i,String mact,String masp)
    {
        DAO.XoaKMSP(mact, masp);
        ds.remove(i);
        return ds;
    }
    public ArrayList<KMtheoSP_DTO> suaKMSP(int i,KMtheoSP_DTO kmSP)
    {
        DAO.SuaKMSP(kmSP);
        KMtheoSP_DTO old=ds.set(i, kmSP);
        return ds;
    }
    private Vector rowKMSP(KMtheoSP_DTO i)
    {
        Vector rowSP=new Vector();
        rowSP.add(i.getMaCT());
        rowSP.add(i.getMaSP());
        rowSP.add(i.getPhanTram_KM());
        return rowSP;
    }
    private Vector headerKMSP()
    {
        Vector he=new Vector();
        he.add("Mã CT");
        he.add("Mã SP");
        he.add("Phần %");
        return he;
    }
    public DefaultTableModel TimKiem(String yctim,String values)
    {
       
        DefaultTableModel model_tam = new DefaultTableModel();
        Vector header=headerKMSP();
        if(model_tam.getRowCount()==0)
        {
            model_tam=new DefaultTableModel(header, 0);
        }
        for(KMtheoSP_DTO km:ds)
        {
            if (yctim.equals("Mã CT") && km.getMaCT().equals(values)
                || yctim.equals("Mã SP") && km.getMaSP().equals(values)
                || yctim.equals("Phần %") && km.getPhanTram_KM()==Float.parseFloat(values))
            {
               Vector row=rowKMSP(km);
                model_tam.addRow(row);
            }
        }
        return model_tam;
    }
}
