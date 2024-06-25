/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;
import DAO.KMTheoTT_DAO;
import DTO.KMtheoTTien_DTO;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
public class KMTheoTT_BUS {
     private ArrayList<KMtheoTTien_DTO> ds= null;
    private KMTheoTT_DAO DAO = new KMTheoTT_DAO();
    public ArrayList<KMtheoTTien_DTO> getList()
    {
        ds=DAO.getAllKMTT();
        return ds;
    }
    public ArrayList<KMtheoTTien_DTO> ThemKMTT(KMtheoTTien_DTO km)
    {
        
        ds.add(km);
        DAO.ThemKMTT(km);
        return ds;
    }
    public ArrayList<KMtheoTTien_DTO> xoaTheoMaCT(int i,String ma)
    {
        DAO.XoaKMTTTheoMACT(ma);
        ds.remove(i);
        return ds;
    }
    public ArrayList<KMtheoTTien_DTO> xoaKMTT(int i,String mact,String makm)
    {
        DAO.XoaKMTT(makm, mact);
        ds.remove(i);
        return ds;
    }
    private Vector headerKMTT()
    {
        Vector he=new Vector();
        he.add("Mã KM");
        he.add("Mã CT");
        he.add("Tiền Min");
        he.add("Phần %");
        return he;
    }
    private Vector rowKMTT(KMtheoTTien_DTO i)
    {
        Vector rowTT=new Vector();
        rowTT.add(i.getMaKM());
        rowTT.add(i.getMaCT());
                
        rowTT.add(i.getTienMin());
        rowTT.add(i.getPhanTram_KM());
        return rowTT;
    }
    public DefaultTableModel TimKiem(String yctim,String values)
    {
        DefaultTableModel model_tam = new DefaultTableModel();
        Vector header=headerKMTT();
        if(model_tam.getRowCount()==0)
        {
            model_tam=new DefaultTableModel(header, 0);
        }
        for(KMtheoTTien_DTO km:ds)
        {
            if (yctim.equals("Mã KM") && km.getMaKM().equals(values)
                || yctim.equals("Mã CT") && km.getMaCT().equals(values)
                || yctim.equals("Tiền Min") && km.getTienMin()==Float.parseFloat(values)   
                || yctim.equals("Phần %") && km.getPhanTram_KM()==Float.parseFloat(values))
            {
               Vector row=rowKMTT(km);
                model_tam.addRow(row);
            }
        }
        return model_tam;
    }
    public ArrayList<KMtheoTTien_DTO> suaKMTT(int i,KMtheoTTien_DTO km)
    {
        DAO.SuaKMtt(km);
        KMtheoTTien_DTO old =ds.set(i, km);
        return ds;
    }
}
