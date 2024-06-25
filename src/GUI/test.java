////DAOOOOO
////thêm
//package GUI;
//import ConnectDB.XuLyDatabase;
//import DTO.SanPham_DTO;
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.InputStream;
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.Base64;
//import javax.swing.JOptionPane;
//import DAO.SanPham_DAO;
//import DTO.SanPham_DTO;
//import DTO.loaiSP_DTO;
//import java.awt.Image;
//import java.awt.image.BufferedImage;
//import java.io.File;
//import BUS.LoaiSP_BUS;
//import DTO.ChiTietHoaDon_DTO;
//import DTO.HoaDon_DTO;
//import java.time.format.DateTimeFormatter;
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.Comparator;
//import java.util.HashMap;
//import java.util.HashSet;
//import java.util.List;
//import java.util.Map;
//import static java.util.Map.entry;
//import java.util.Set;
//import java.util.Vector;
//import javax.imageio.ImageIO;
//import javax.swing.ImageIcon;
//import javax.swing.JComboBox;
//import javax.swing.JOptionPane;
//import javax.swing.JTable;
//import javax.swing.JTextField;
//import javax.swing.table.DefaultTableModel;
//public class test {
//    private XuLyDatabase xuLyDB = null;
//    private Connection conn = null;
//    private PreparedStatement ps = null;
//    private java.sql.Statement st;
//    private ResultSet rs = null;
//    private void Them(SanPham_DTO sp)
//    {
//        try
//        {
//            xuLyDB=new XuLyDatabase();
//            conn=xuLyDB.openConnection();
//            String qry="Insert into sanpham Values (";
//            qry=qry+"'"+sp.getMaSp()+"','"+sp.getMaNcc()+"','"+sp.getMaLoai()+"','"+sp.getTenSP()+"','"+sp.getMieuta()+"','"+sp.getDongia()+"','"+sp.getSoluong()+"','"+sp.getAnh()+"')";
//            st=conn.createStatement();
//            st.executeUpdate(qry);
//        }
//        catch(Exception e){
//            JOptionPane.showMessageDialog(null, "Lỗi Thêm" + e.getMessage());
//        }
//    }
//    private void Sua(SanPham_DTO sp)
//    {
//        try
//        {
//            xuLyDB=new XuLyDatabase();
//            conn=xuLyDB.openConnection();
//            String qry="Update sanpham Set ";
//            qry=qry+"MaNCC='"+sp.getMaNcc()+"' Where MaSP='"+sp.getMaSp()+"'";
//            st=conn.createStatement();
//            st.executeUpdate(qry);
//        }
//        catch(Exception e)
//        {
//            JOptionPane.showMessageDialog(null,"Lỗi Sửa"+ e.getMessage());
//        }
//    }
//    private void Xoa(String ma)
//    {
//        try
//        {
//            xuLyDB=new XuLyDatabase();
//            conn=xuLyDB.openConnection();
//            String qry="Detele from sanpham where masp='"+ma+"'";
//            st=conn.createStatement();
//            st.executeUpdate(qry);
//        }
//        catch(Exception e)
//        {
//            JOptionPane.showMessageDialog(null,"Lỗi Xóa"+e.getMessage());
//        }
//    }
//    private ArrayList<SanPham_DTO> getALL()
//    {
//        ArrayList<SanPham_DTO> listsp=new ArrayList<SanPham_DTO>();
//        try
//        {
//            
//            xuLyDB=new XuLyDatabase();
//            conn=xuLyDB.openConnection();
//            String qry="Select * from sanpham";
//            ps=conn.prepareStatement(qry);
//            rs=ps.executeQuery(qry);
//            while(rs.next())
//            {
//                SanPham_DTO sp=new SanPham_DTO();
//                sp.setMaSp(rs.getString(1));
//                sp.setMaNcc(rs.getString(2));
//                sp.setMaLoai(rs.getString(3));
//                sp.setTenSP(rs.getString(4));
//                sp.setMieuta(rs.getString(5));
//                sp.setDongia(rs.getFloat(6));
//                sp.setSoluong(rs.getInt(7));
//                sp.setAnh(rs.getString(8));
//                listsp.add(sp);
//            }
//        }
//        catch(Exception e)
//        {
//            JOptionPane.showMessageDialog(null,"Lỗi lấy dữ liệu"+ e.getMessage());
//        }
//        return listsp;
//    }
//     private ArrayList<SanPham_DTO> dsSP = null;
//    private SanPham_DAO SPDAO = new SanPham_DAO();
//    ///BUS
//    private ArrayList<SanPham_DTO> getALLsp()
//    {
//        dsSP=SPDAO.getAllSP();
//        return dsSP;
//    }
//    private ArrayList<SanPham_DTO> Them(String maSP,String mancc,String maloai,String ten,String mta,String dongia,String sl,String anh)
//    {
//        SanPham_DTO sp=new SanPham_DTO();
//        sp.setMaSp(maSP);
//        sp.setMaNcc(mancc);
//        sp.setMaLoai(maloai);
//        sp.setTenSP(ten);
//        sp.setMieuta(mta);
//        sp.setDongia(Float.parseFloat(dongia));
//        sp.setSoluong(Integer.parseInt(sl));
//        sp.setAnh(anh);
//        SPDAO.ThemNhanVien(sp);
//        dsSP.add(sp);
//        return dsSP;
//        
//    }
//    private loaiSP_DTO getLoai(ArrayList<loaiSP_DTO> dsLoai,String ma)
//    {
//        for(loaiSP_DTO i:dsLoai)
//            if(i.getMaLoai().equals(ma))
//                return i;
//        return null;
//    }
//    private ArrayList<SanPham_DTO> Sua(int i,LoaiSP_BUS loaisp,String maSP,String mancc,String maloai,String ten,String mta,String dongia,String sl,String anh)
//    {
//        SanPham_DTO sp=new SanPham_DTO();
//        sp.setMaSp(maSP);
//        sp.setMaNcc(mancc);
//        sp.setMaLoai(maloai);
//        sp.setTenSP(ten);
//        sp.setMieuta(mta);
//        sp.setDongia(Float.parseFloat(dongia));
//        sp.setSoluong(Integer.parseInt(sl));
//        sp.setAnh(anh);
//        if(!anh.isEmpty())
//        {
//            File fileanh= new File(anh);
//            String tenanh=fileanh.getName();
//            sp.setAnh(tenanh);
//        }
//        SPDAO.SuaSanPham(sp);
//        loaiSP_DTO loai=getLoai(loaisp.getListLoai(),dsSP.get(i).getMaLoai());
//        loaisp.Sua(loaisp.getListLoai().indexOf(loai), loai.getMaLoai(),loai.getTenLoai() ,loai.getSoluong()-Integer.parseInt(sl));
//        loaiSP_DTO loaimoi=getLoai(loaisp.getListLoai(),maloai);
//        loaisp.Sua(loaisp.getListLoai().indexOf(loaimoi), maloai,loaimoi.getTenLoai(),loai.getSoluong()+Integer.parseInt(sl));
//        dsSP.set(i, sp);
//        return dsSP;
//    }
//    private ArrayList<SanPham_DTO> Xoa(String ma,int i,LoaiSP_BUS loaisp)
//    {
//       SPDAO.XoaSanPham(ma);
//       loaiSP_DTO loai=getLoai(loaisp.getListLoai(),dsSP.get(i).getMaLoai());
//       loaisp.Sua(loaisp.getListLoai().indexOf(loai), loai.getMaLoai(), loai.getTenLoai(),loai.getSoluong()-dsSP.get(i).getSoluong());
//       dsSP.remove(i);
//       return dsSP;
//    }
//    private Vector header(Vector he)
//    {
//        he.add("Ảnh");
//        he.add("Mã sp");
//        he.add("Mã ncc");
//        return he;
//    }
//    private Vector Row(Vector ro,SanPham_DTO sp)
//    {
//        try
//        {
//            BufferedImage img=ImageIO.read(new File("C:\\Users\\ADMIN\\OneDrive\\Documents\\NetBeansProjects\\doan_java\\src\\Image\\anhdongho\\"+sp.getAnh()));
//            Image imgScal=img.getScaledInstance(50,50,Image.SCALE_SMOOTH);
//            ro.add(imgScal);
//            ro.add(sp.getMaSp());
//            ro.add(sp.getMaNcc());
//            
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
//        return ro;
//    }
//    private void TimKiemCoBan(JTable tbSP,JComboBox<String> cbTK,JTextField txTK)
//    {
//        boolean flag = false;
//        DefaultTableModel model_tam = new DefaultTableModel();
//        Vector he = new Vector();
//        he=header(he);
//        if(model_tam.getRowCount()==0)
//        {
//            model_tam=new DefaultTableModel(he,0);
//        }
//        for(SanPham_DTO sp:dsSP)
//        {
//            if((cbTK.getSelectedItem().equals("Mã SP")&& sp.getMaSp().equals(txTK.getText()))
//               || cbTK.getSelectedItem().equals("Mã NCC") &&sp.getMaNcc().equals(txTK.getText())
//                )
//            {
//                Vector ro=new Vector();
//                ro=Row(ro,sp);
//                model_tam.addRow(ro);
//                flag=true;
//            }
//        }
//        if(flag==true)
//        {
//            tbSP.setModel(model_tam);
//        }
//        else
//        {
//            System.out.print("không có kết quả tìm kiếm đc");
//        }
//    }
//    private int slMax()
//    {
//        int sl=0;
//        for(SanPham_DTO sp:dsSP)
//            if(sp.getSoluong()>sl)
//                sl=sp.getSoluong();
//        return sl;
//    }
//    private float dgMax()
//    {
//        float dg=0;
//        for(SanPham_DTO sp:dsSP)
//            if(sp.getDongia()>dg)
//                dg=sp.getDongia();
//        return dg;
//    }
//    private void TimKiemNangCao(JTable tbSP,JTextField txMaNCC,JTextField SLMin,JTextField SLMax,JTextField DGMin,JTextField DGMax)
//    {
//        boolean flag=false;
//        Vector he=new Vector();
//        he=header(he);
//        DefaultTableModel modelTam=new DefaultTableModel();
//        modelTam=new DefaultTableModel(he,0);
//        int slmin=0,slmax=slMax();
//        float dgmin=0,dgmax=dgMax();
//        if(!SLMin.getText().isEmpty())
//        {
//            try
//            {
//                slmin=Integer.parseInt(SLMin.getText());
//            }
//            catch (NumberFormatException e) {
//                JOptionPane.showMessageDialog(null, "Bạn nhập số lượng min không phải là số nguyên");
//                SLMin.setText("");
//                SLMin.requestFocus();
//                return; // Thoát khỏi phương thức
//            }
//        }
//        if(slmin>slmax && slmax!=slMax())
//        {
//            
//        }
//        for(SanPham_DTO sp:dsSP)
//        {
//            if(!txMaNCC.getText().isEmpty()|| txMaNCC.getText().equals(sp.getMaNcc()))
//                if(sp.getSoluong()>=slmin && sp.getSoluong()<=slmax && sp.getDongia()>=dgmin && sp.getDongia()<=dgmax)
//                {
//                    Vector ro=new Vector();
//                    ro=Row(ro,sp);
//                    modelTam.addRow(ro);
//                    flag=true;
//                }
//        }
//        if(flag==true)
//        {
//            tbSP.setModel(modelTam);
//        }
//    }
//    private boolean checkNam(String namNhap,String namHD)
//    {
//        if(namNhap.length()!=4)
//            return false;
//        return namNhap.equals(namHD);
//    }
//    private ArrayList<HoaDon_DTO> dsHD=new ArrayList<HoaDon_DTO>();
//    private ArrayList<ChiTietHoaDon_DTO> dsCTHD=new ArrayList<ChiTietHoaDon_DTO>();
//    private JTextField txNamTK;
//    private void thongkeSP()
//    {
//        Map<String,Integer> listTKSP=new HashMap<>();
//        for(HoaDon_DTO hd:dsHD)
//        {
//            String namHD=String.valueOf(hd.getNgayLap()).substring(0, 4);
//            if(checkNam(txNamTK.getText(),namHD))
//            {
//                for(ChiTietHoaDon_DTO ct:dsCTHD)
//                {
//                    if(ct.getMaHD().equals(hd.getMaHD()))
//                        if(listTKSP.containsKey(ct.getMaSP()))
//                        {
//                            listTKSP.put(ct.getMaSP(),listTKSP.get(ct.getMaSP())+ct.getSoLuong());
//                        }
//                        else 
//                        {
//                            listTKSP.put(ct.getMaSP(), ct.getSoLuong());
//                        }
//                }
//            }
//        }
//        DefaultTableModel modelSP=new DefaultTableModel();
//        modelSP.setRowCount(0);
//        Vector header=new Vector();
//        header.add("Mã SP");
//        header.add("Tên Sản phẩm");
//        header.add("Số lượng");
//        header.add("Đơn giá");
//        modelSP=new DefaultTableModel(header,0);
//        if(!listTKSP.isEmpty())
//        {
//            for (Map.Entry<String, Integer> entry : listTKSP.entrySet()) 
//            {
//                SanPham_DTO sp=new SanPham_DTO();
//                sp=TimSP(entry.getKey());
//                if(sp!=null)
//                {
//                    Vector row=new Vector();
//                    row.add(sp.getMaSp());
//                    row.add(sp.getTenSP());
//                    row.add(entry.getValue());
//                    row.add(sp.getDongia());
//                    modelSP.addRow(row);
//                }
//            }
//            List<Map.Entry<String, Integer>> list = new ArrayList<>(listTKSP.entrySet());
//            Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
//                public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
//                    return (o2.getValue()).compareTo(o1.getValue());
//                }
//            });
//            if(list.size()>=3)
//            {
//                //set 3top
//
//            }
//            if(list.size()==2)
//            {
//                //set 2 top đầu và top cuối là null
//            }
//            if(list.size()==1)
//            {
//                //set 1 top đầu
//            }
//        }
//        else
//        {
//            //set lb tên và số lượng 3 top;
//        }
//        //gọi tb set model
//        Set<String> listMaKH=new HashSet<>();
//        listMaKH.add("HII");
//        
//    }
//    
//}