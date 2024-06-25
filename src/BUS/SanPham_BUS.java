/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;
import DAO.SanPham_DAO;
import DTO.SanPham_DTO;
import DTO.loaiSP_DTO;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import BUS.LoaiSP_BUS;
import java.util.ArrayList;
import java.util.Vector;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author ADMIN
 */
public class SanPham_BUS {
    private ArrayList<SanPham_DTO> dsSP = null;
    private SanPham_DAO SPDAO = new SanPham_DAO();
    public ArrayList<SanPham_DTO> getList()
    {
        dsSP=SPDAO.getAllSP();
        return dsSP;
    }
    public ArrayList<SanPham_DTO> themSP(SanPham_DTO sp)
    {
        dsSP.add(sp);
        SPDAO.ThemNhanVien(sp);
        return dsSP;
    }
    public loaiSP_DTO getLoai(ArrayList<loaiSP_DTO>dsLoai,String ma)
    {
        for(loaiSP_DTO i:dsLoai)
        {
            if(i.getMaLoai().equals(ma))
                return i;
        }
        return null;
    }
    public int getViTri(ArrayList<loaiSP_DTO>dsLoai,String ma)
    {
        for(int i=0;i<dsLoai.size();i++)
            if(dsLoai.get(i).getMaLoai().equals(ma))
                return i;
        return -1;
    }
    public ArrayList<SanPham_DTO> xoaSP(int i,String ma,LoaiSP_BUS loaisp_BUS,String maLoai,int sl)
    {
        loaiSP_DTO loai=new loaiSP_DTO();
        loai=getLoai(loaisp_BUS.getListLoai(),maLoai);
        ArrayList<loaiSP_DTO> dsloai=loaisp_BUS.getListLoai();
        int j=getViTri(dsloai,maLoai);
        loai.setSoluong(loai.getSoluong()-sl);
        dsloai=loaisp_BUS.Sua(j, loai );
        SPDAO.XoaSanPham(ma);
        dsSP.remove(i);
        
        return dsSP;
    }
    
        public ArrayList<SanPham_DTO> SuaSP(int i,SanPham_DTO sp)
        {
            SPDAO.SuaSanPham(sp);
            SanPham_DTO old=dsSP.set(i, sp);
            return dsSP;
        }
        public void suaLoai(LoaiSP_BUS loaisp_BUS,SanPham_DTO spcu,String maLoai,String soLuongmoi)
        {
            loaiSP_DTO loai=new loaiSP_DTO();
            loai=getLoai(loaisp_BUS.getListLoai(),maLoai);
            loai.setSoluong(loai.getSoluong()+Integer.parseInt(soLuongmoi));
            
            loaisp_BUS.Sua(getViTri(loaisp_BUS.getListLoai(),maLoai),loai);
            loaiSP_DTO loaicu=new loaiSP_DTO();
            loaicu=getLoai(loaisp_BUS.getListLoai(),spcu.getMaLoai());
            loaicu.setSoluong(loaicu.getSoluong()-spcu.getSoluong());
            loaisp_BUS.Sua(getViTri(loaisp_BUS.getListLoai(),loaicu.getMaLoai()),loaicu );
        }
        private Vector headerSP() {
        Vector header=new Vector();
        header.add("Ảnh");
        header.add("Mã SP");
        header.add("Mã NCC");
        header.add("Mã Loại");
        header.add("Tên SP");
        header.add("Miêu Tả");
        header.add("Đơn giá");
        header.add("Số lượng");
        return header;
    }
    private Vector rowSP( SanPham_DTO i) {
        Vector row=new Vector();
        try {
            // Đọc ảnh từ đường dẫn và tạo ImageIcon
            BufferedImage img = ImageIO.read(new File("C:\\Users\\ADMIN\\OneDrive\\Documents\\NetBeansProjects\\doan_java\\src\\Image\\anhdongho\\"+i.getAnh()));
            Image scaledImage = img.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
            ImageIcon icon = new ImageIcon(scaledImage);
            // Thêm ảnh vào hàng
            row.add(icon);
            // Thêm các giá trị khác vào hàng
            row.add(i.getMaSp());
            row.add(i.getMaNcc());
            row.add(i.getMaLoai());
            row.add(i.getTenSP());
            row.add(i.getMieuta());
            row.add(i.getDongia());
            row.add(i.getSoluong());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return row;
    }
       public DefaultTableModel  TKCB(String YcTim,String values)
       {
            DefaultTableModel model_tam = new DefaultTableModel();
            Vector header = headerSP();
            if(model_tam.getRowCount()==0)
            {
                model_tam=new DefaultTableModel(header, 0);
            }
            for (SanPham_DTO sp : dsSP) {
                if (YcTim.equals("Mã SP") && sp.getMaSp().equals(values)
                        || YcTim.equals("Mã NCC") && sp.getMaNcc().equals(values)
                        || YcTim.equals("Mã Loại") && sp.getMaLoai().equals(values)
                        || YcTim.equals("Tên SP") && sp.getTenSP().equals(values)
                        || YcTim.equals("Đơn giá") && sp.getDongia()==Float.parseFloat(values)
                        || YcTim.equals("Số lượng") && sp.getSoluong()==Integer.parseInt(values))
                {
                    Vector row =rowSP(sp);
                    model_tam.addRow(row);
                }
            } 
            return model_tam;
       }
    private int SLMax()
    {
        int max=0;
        for(SanPham_DTO i:dsSP)
        {
            if(i.getSoluong()>max)
                max=i.getSoluong();
        }
        return max;
    }
    private float DonGiaMax()
    {
        float max=0;
        for(SanPham_DTO i:dsSP)
        {
            if(i.getDongia()>max)
                max=i.getDongia();
        }
        return max;
    }
       public DefaultTableModel TKNC(String mancc,String slmin,String slmax,String dgmin,String dgmax)
       {
            int slMin=0,slMax=SLMax();
            float dgMin=0,dgMax=DonGiaMax();
            if(!slmin.isEmpty())
               {
                   try {
                        slMin = Integer.parseInt(slmin);
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(null, "Bạn nhập số lượng min không phải là số nguyên");
                        return null; // Thoát khỏi phương thức
                    }
               }
               if(!slmax.isEmpty())
               {
                   try {
                        slMax = Integer.parseInt(slmax);
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(null, "Bạn nhập số lượng Max không phải là số nguyên");
                        return null; // Thoát khỏi phương thức
                    }
               }
               if(slMin>slMax && slMax!=SLMax())
               {
                    JOptionPane.showMessageDialog(null, "Bạn nhập số lượng Min > số lượng max vui lòng kiểm tra lại");
                    return null; // Thoát khỏi phương thức
               }
               if(!dgmin.isEmpty())
               {
                    try {
                        dgMin = Float.parseFloat(dgmin);
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(null, "Bạn nhập đơn giá min không phải là số ");
                        return null; // Thoát khỏi phương thức
                    }
               }
               if(!dgmax.isEmpty())
               {
                   try {
                        dgMax = Float.parseFloat(dgmax);
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(null, "Bạn nhập đơn giá max không phải là số ");
                        return null; // Thoát khỏi phương thức
                    }
               }
               if(dgMin>dgMax && dgMax!=DonGiaMax())
               {
                    JOptionPane.showMessageDialog(null, "Bạn nhập đơn giá Min > đơn giá max vui lòng kiểm tra lại");
                    return null; // Thoát khỏi phương thức
                   
               }
                DefaultTableModel model_tam = new DefaultTableModel();
                Vector header = headerSP();
                if(model_tam.getRowCount()==0)
                {
                    model_tam=new DefaultTableModel(header, 0);
                }
                for (SanPham_DTO sp : dsSP) {
                    if (sp.getMaNcc().equals(mancc) || (sp.getSoluong() >= slMin && sp.getSoluong() <= slMax && sp.getDongia() >= dgMin && sp.getDongia() <= dgMax)) 
                    {
                            Vector row = rowSP(sp);
                            model_tam.addRow(row);

                    }
            }
            
            return model_tam;
       }
}
