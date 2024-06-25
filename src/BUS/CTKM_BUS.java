/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;
import DAO.CTKM_DAO;
import DTO.CTKM_DTO;
import DTO.KMtheoSP_DTO;
import DTO.KMtheoTTien_DTO;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author ADMIN
 */
public class CTKM_BUS {
     private ArrayList<CTKM_DTO> ds= null;
    private CTKM_DAO DAO = new CTKM_DAO();
    public ArrayList<CTKM_DTO> getList()
    {
        ds=DAO.getAllCTKM();
        return ds;
    }
     public ArrayList<CTKM_DTO> themCTKM(CTKM_DTO ct) {
         
            ds.add(ct);
            DAO.ThemCTKM(ct);
            return ds;
     }
     public ArrayList<CTKM_DTO> xoaCTKM(int i,String ma)
     {
         DAO.XoaCTKM(ma);
         ds.remove(i);
         return ds;
     }
     public ArrayList<CTKM_DTO> suaCTKM(int i,CTKM_DTO ct)
     {
            DAO.SuaCTKM(ct);
            CTKM_DTO old=ds.set(i,ct);
            return ds;
     }
     private Vector headerCT()
    {
        Vector he=new Vector();
        he.add("Mã CT");
        he.add("Tên CT");
        he.add("Ngày BD");
        he.add("Ngày KT");
        return he;
    }
    private Vector headerKMSP()
    {
        Vector he=new Vector();
        he.add("Mã CT");
        he.add("Mã SP");
        he.add("Phần %");
        return he;
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
    private Vector rowCT(CTKM_DTO i)
    {
        Vector row=new Vector();
        row.add(i.getMaCT());
        row.add(i.getTenCT());
        row.add(String.valueOf(i.getNgayBD().toLocalDate()));
        row.add(i.getNgayKT());
        return row;
    }
    private Vector rowKMSP(KMtheoSP_DTO i)
    {
        Vector rowSP=new Vector();
        rowSP.add(i.getMaCT());
        rowSP.add(i.getMaSP());
        rowSP.add(i.getPhanTram_KM());
        return rowSP;
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
    public DefaultTableModel TKKMSP_CTKM(ArrayList<KMtheoSP_DTO> ds,String ma,DefaultTableModel modelTamKMSP )
    {
        Vector header=headerKMSP();
        if(modelTamKMSP.getRowCount()==0)
        {
            modelTamKMSP=new DefaultTableModel(header,0);
        }
        for(KMtheoSP_DTO km:ds)
        {
            if(km.getMaCT().equals(ma))
            {
                Vector row=rowKMSP(km);
                modelTamKMSP.addRow(row);
            }
        }
        return modelTamKMSP;
    }
    public DefaultTableModel TKKMTT_CTKM(ArrayList<KMtheoTTien_DTO> ds,String ma,DefaultTableModel modelTam)
    {
        Vector header=headerKMTT();
        if(modelTam.getRowCount()==0)
        {
            modelTam=new DefaultTableModel(header,0);
        }
        for(KMtheoTTien_DTO km:ds)
        {
            if(km.getMaCT().equals(ma))
            {
                Vector row=rowKMTT(km);
                    modelTam.addRow(row);
            }
        }
        return modelTam;
    }
     public DefaultTableModel[] TK(ArrayList<KMtheoSP_DTO> dsKMSP,ArrayList<KMtheoTTien_DTO> dsKMTT,String yctim,String values)
     {
        DefaultTableModel modelTamCT=new DefaultTableModel();
        DefaultTableModel modelTamKMSP=new DefaultTableModel();
        DefaultTableModel modelTamKMTT=new DefaultTableModel();
        
        Vector heCT = headerCT();
        if(modelTamCT.getRowCount()==0)
        {
            modelTamCT=new DefaultTableModel(heCT, 0);
        }
        for(CTKM_DTO ct:ds)
        {
            if (yctim.equals("Mã CT") && ct.getMaCT().equals(values)
                || yctim.equals("Tên CT") && ct.getTenCT().equals(values)
                || yctim.equals("Ngày BD") && ct.getNgayBD().toLocalDate().equals(LocalDate.parse(values))
                || yctim.equals("Ngày KT") && ct.getNgayKT().toLocalDate().equals(LocalDate.parse(values))) 
            {
                Vector row=rowCT(ct);
                modelTamCT.addRow(row);
                modelTamKMSP=TKKMSP_CTKM(dsKMSP,ct.getMaCT(),modelTamKMSP);
                modelTamKMTT=TKKMTT_CTKM(dsKMTT,ct.getMaCT(),modelTamKMTT);
            }
        }
        return new DefaultTableModel[]{modelTamCT, modelTamKMSP, modelTamKMTT};
            
     }
    
}
