package GUI;
import ConnectDB.XuLyDatabase;
import BUS.LoaiSP_BUS;
import BUS.SanPham_BUS;
import DTO.SanPham_DTO;
import BUS.NCC_BUS;
import DTO.NCC_DTO;
import DTO.loaiSP_DTO;
import GUI.ThongTinDN;
import java.beans.Statement;
import java.lang.System.Logger.Level;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.PreparedStatement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.Vector;
import javax.imageio.ImageIO;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableCellRenderer;
public class GUI_Sanpham extends JFrame {
    private ThongTinDN dn=new ThongTinDN();
    Panel tieude = new Panel();
    Panel menu = new Panel();
    Panel chitiet = new Panel();
    JLabel lb_bentrai = new JLabel("        Chào mừng đến với hệ thống quản lí");
    JLabel lb_benphai = new JLabel(dn.getHoTen());
    JButton bt_sp = new JButton("Sản Phẩm");
    JButton bt_kh = new JButton("Khách hàng");
    JButton bt_nv = new JButton("Nhân viên");
    JButton bt_bh = new JButton("Bán hàng");
    JButton bt_km = new JButton("Khuyến mãi");
    JButton bt_duyet = new JButton("Duyệt yêu cầu");
    JButton bt_user = new JButton("User");
    JButton bt_ncc = new JButton("Nhà cung cấp");
    JButton bt_kho = new JButton("Kho hàng");
    JButton bt_tk = new JButton("Thống kê");
    JButton bt_dx = new JButton("Đăng xuất");
    ImageIcon icon = new ImageIcon("D:\\vietcpp\\.vscode\\doan_java\\Image\\276-2764901_www-agisac-gov-in-admin-png.png"); 
    JLabel jlb_anh = new JLabel();
    private javax.swing.JButton bt_ChonAnh;
    private javax.swing.JButton bt_Clear;
    private javax.swing.JButton bt_Dong;
    private javax.swing.JButton bt_Sua;
    private javax.swing.JButton bt_Them;
    private javax.swing.JButton bt_TimKiem_NangCao;
    private javax.swing.JButton bt_Timkiem_CoBan;
    private javax.swing.JButton bt_Xoa;
    private javax.swing.JComboBox<String> cb_TimKiemCB;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lb_Anh;
    private javax.swing.JLabel lb_ChuaAnh;
    private javax.swing.JLabel lb_CoBan;
    private javax.swing.JLabel lb_DonGia;
    private javax.swing.JLabel lb_Lc_TimKiem;
    private javax.swing.JLabel lb_LoiChao;
    private javax.swing.JLabel lb_MaLoai;
    private javax.swing.JLabel lb_MaNCC;
    private javax.swing.JLabel lb_MaSP;
    private javax.swing.JLabel lb_MieuTa;
    private javax.swing.JLabel lb_NhapDonGia;
    private javax.swing.JLabel lb_NhapMaNCC;
    private javax.swing.JLabel lb_NhapSL;
    private javax.swing.JLabel lb_SoLuong;
    private javax.swing.JLabel lb_TK_NangCao;
    private javax.swing.JLabel lb_TenSP;
    private javax.swing.JPanel lb_TimKiem;
    private javax.swing.JLabel lb_anh_chinh;
    private javax.swing.JPanel pn_TK_CoBan;
    private javax.swing.JTable tableSP;
    private javax.swing.JTextField tx_DonGia;
    private javax.swing.JTextField tx_MaLoai;
    private javax.swing.JTextField tx_MaNCC;
    private javax.swing.JTextField tx_MaSP;
    private javax.swing.JTextField tx_MieuTa;
    private javax.swing.JTextField tx_NhapDG_Max;
    private javax.swing.JTextField tx_NhapDG_Min;
    private javax.swing.JTextField tx_NhapID;
    private javax.swing.JTextField tx_NhapMaNCC;
    private javax.swing.JTextField tx_NhapSLMin;
    private javax.swing.JTextField tx_NhapSL_Max;
    private javax.swing.JTextField tx_SoLuong;
    private javax.swing.JTextField tx_TenSP;
    private DefaultTableModel model;
    private ArrayList<SanPham_DTO> dsSP;
    private ArrayList<NCC_DTO> dsNCC=new ArrayList<NCC_DTO>();
    private ArrayList<loaiSP_DTO> dsLoai=new ArrayList<loaiSP_DTO>();
    private SanPham_BUS sp_BUS=new SanPham_BUS();
    private NCC_BUS ncc_BUS=new NCC_BUS();
    private LoaiSP_BUS loaisp_BUS=new LoaiSP_BUS();
    private String ImgPath=""; 
    private JTable resultTable;
    private JScrollPane scrollPane;
    private JTable Tb_MaDM;
    private JScrollPane scroll_MaDM;
    private Vector headerSP(Vector header) {
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
    private Vector rowSP(Vector row, SanPham_DTO i) {
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
    private boolean checkMaSPKhiLoad(String ma)
    {
        if(ma.charAt(0)!='-')
            return true;
        return false;
    }
    private void hienThi() {
        if(dsSP.isEmpty()) 
        {
            for(SanPham_DTO i:sp_BUS.getList())
                if(checkMaSPKhiLoad(i.getMaSp()))
                    dsSP.add(i);
        }
        if(dsNCC.isEmpty()) dsNCC = ncc_BUS.getListNCC();
        if(dsLoai.isEmpty())  dsLoai = loaisp_BUS.getListLoai();
        
        if (!dsSP.isEmpty()) {
            Vector header = new Vector();
            header = headerSP(header);
            model = new DefaultTableModel(header, 0);

            for (SanPham_DTO i : dsSP) {
                Vector row = new Vector();
                row = rowSP(row, i);
                model.addRow(row);
            }

            // Gán model cho tableSP
            tableSP.setModel(model);
        }
        else {
            JOptionPane.showMessageDialog(this, "List sp null");
        }
    }
    private void checkNhap()
    {
        if(tx_MaSP.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập mã sản phầm!");
            tx_MaSP.requestFocus();
        }
        else if(tx_MaNCC.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập mã nhà cung cấp!");
            tx_MaNCC.requestFocus();
        }
        else if(tx_MaLoai.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập mã loại của sản phẩm!");
            tx_MaLoai.requestFocus();
        }
        else if(tx_TenSP.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập tên sản phẩm!");
            tx_TenSP.requestFocus();
        }
        else if(tx_MieuTa.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập mô tả của sản phẩm!");
            tx_MieuTa.requestFocus();
        }
        else if(tx_DonGia.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập giá của sản phẩm!");
            tx_DonGia.requestFocus();
        }
        else if(lb_ChuaAnh.getIcon()==null)
        {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn ảnh!");
            bt_ChonAnh.requestFocus();
        }
        
    }
    private boolean checkMa(ArrayList<SanPham_DTO> ds,String ma)
    {
        for(SanPham_DTO i:ds)
        {
            if(i.getMaSp().equals(ma))
                return false;
        }
        return true;
    }
    private boolean checkMaNCC(ArrayList<NCC_DTO> ds,String ma)
    {
        for(NCC_DTO i:ds)
        {
            if(i.getMaNCC().equals(ma))
                return true;
        }
        return false;
    }
    private boolean checkMaLoai(ArrayList<loaiSP_DTO> ds,String ma)
    {
        for(loaiSP_DTO i:ds)
        {
            if(i.getMaLoai().equals(ma))
                return true;
        }
        return false;
    }
    private void bt_ThemActionPerformed(java.awt.event.ActionEvent evt) {
        if(tx_MaSP.getText().isEmpty() || tx_MaNCC.getText().isEmpty() || tx_MaLoai.getText().isEmpty() || tx_TenSP.getText().isEmpty() ||tx_MieuTa.getText().isEmpty()||tx_DonGia.getText().isEmpty()||  lb_ChuaAnh.getIcon()==null )
        {
            checkNhap();
        }
        else if(!checkMa(dsSP,tx_MaSP.getText()))
        {
            JOptionPane.showMessageDialog(this, "Mã SP bạn nhập đã có trong cửa hàng vui lòng nhập lại!");
            tx_MaSP.setText("");
            tx_MaSP.requestFocus();
        }
        else if(!checkMaNCC(dsNCC,tx_MaNCC.getText()))
        {
            JOptionPane.showMessageDialog(this, "Mã NCC bạn nhập không có trong cửa hàng vui lòng nhập lại!");
            tx_MaNCC.setText("");
            tx_MaNCC.requestFocus();
        }
        else if(!checkMaLoai(dsLoai,tx_MaLoai.getText()))
        {
            JOptionPane.showMessageDialog(this, "Mã Loai bạn nhập không có trong cửa hàng vui lòng nhập lại!");
            tx_MaLoai.setText("");
            tx_MaLoai.requestFocus();
        }
        else if(tx_MaSP.getText().length()>10)
        {
            JOptionPane.showMessageDialog(this, "Mã SP bạn nhập đã có độ dài >10 vui lòng nhập lại!");
            tx_MaSP.setText("");
            tx_MaSP.requestFocus();
        }
        else if(!Character.isLetter(tx_MaSP.getText().charAt(0)))
        {
            JOptionPane.showMessageDialog(this, "Bạn đã nhập mã với kí tự đầu tiên là kí tự đặc biệt vui lòng nhập lại!");
            tx_MaSP.setText("");
            tx_MaSP.requestFocus();
        }
        else
        {
            try {
                    Float.parseFloat(tx_DonGia.getText());
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(this, "Đơn giá  bạn nhập không phải số thực vui lòng nhập lại!");
                    tx_DonGia.requestFocus();
                    return;
                }
            SanPham_DTO sptam=new SanPham_DTO();
            sptam.setMaSp(tx_MaSP.getText());
            sptam.setMaNcc(tx_MaNCC.getText());
            sptam.setMaLoai(tx_MaLoai.getText());
            sptam.setTenSP(tx_TenSP.getText());
            sptam.setMieuta(tx_MieuTa.getText());
            sptam.setDongia(Float.parseFloat(tx_DonGia.getText()));
            sptam.setSoluong(Integer.parseInt(tx_SoLuong.getText()));
            File fileAnh = new File(ImgPath);
            String tenAnh = fileAnh.getName(); // Lấy tên tập tin
            sptam.setAnh(tenAnh);
            dsSP=sp_BUS.themSP(sptam);
            ImgPath="";
            Vector header=new Vector();
            header=headerSP(header);
             if(model.getRowCount()==0)
            {
                model=new DefaultTableModel(header, 0);
            }
            Vector row=new Vector();
            row=rowSP(row,sptam);
            model.addRow(row);
            tableSP.setModel(model);
            JOptionPane.showMessageDialog(this, "Thêm Sản phẩm có mã " +tx_MaSP.getText()+" thành công");
            bt_ClearActionPerformed(evt);
        }
    }

    
    private void bt_ChonAnh() {
        JFileChooser file=new JFileChooser();
        file.setCurrentDirectory(new File(System.getProperty("user.dir")));
        FileNameExtensionFilter filter=new FileNameExtensionFilter("*.images", "jpg", "png", "jpeg");
        file.addChoosableFileFilter(filter);//Lọc đuôi file được phép upload
        int result=file.showSaveDialog(null);
        if(result==JFileChooser.APPROVE_OPTION)//nếu người dùng bấm save
        {
            File fileDaChon=file.getSelectedFile();//lấy file đã chọn
            String path=fileDaChon.getAbsolutePath();//Lấy đường dẫn
            //Xử lí ảnh
            File fileAnh = new File(path);
            if(!fileAnh.exists())
                path="";
            ImageIcon myImg=new ImageIcon(path);
            Image img=myImg.getImage();
            Image img2=img.getScaledInstance(lb_ChuaAnh.getWidth()-3, lb_ChuaAnh.getHeight(), Image.SCALE_SMOOTH);
            ImageIcon image=new ImageIcon(img2);
            lb_ChuaAnh.setIcon(image);//hiện thị ảnh
            //lưu đường ảnh lại
            ImgPath=path;//Gán đường dẫn vào ImgPath
        }
    }
    private void bt_XoaActionPerformed(java.awt.event.ActionEvent evt) {
        int i=tableSP.getSelectedRow();
        if(i>=0 && i<dsSP.size())
        {
            String ma=tx_MaSP.getText();
                dsSP=sp_BUS.xoaSP(i, ma,loaisp_BUS,tx_MaLoai.getText(),Integer.parseInt(tx_SoLuong.getText()));
                model.removeRow(i);
                tableSP.setModel(model);
               
              JOptionPane.showMessageDialog(this, "Xóa Sản phẩm có mã " +tx_MaSP.getText()+" thành công");
               bt_ClearActionPerformed(evt);
        }
        else
        {
            JOptionPane.showMessageDialog(this, "Đã vượt qua độ lớn của danh sách sản phẩm mời chọn lại!");
        }
    }
    private void bt_SuaActionPerformed(java.awt.event.ActionEvent evt) {
    int i = tableSP.getSelectedRow();
    if (i >= 0 && i < dsSP.size()) {
        SanPham_DTO cu=new SanPham_DTO();
        cu=dsSP.get(i);
        if (tx_MaNCC.getText().isEmpty() || tx_MaLoai.getText().isEmpty() || tx_TenSP.getText().isEmpty() ||
                tx_MieuTa.getText().isEmpty() || tx_DonGia.getText().isEmpty() || lb_ChuaAnh.getIcon() == null) {
            checkNhap();
        } else if (!checkMaNCC(dsNCC, tx_MaNCC.getText())) {
            JOptionPane.showMessageDialog(this, "Mã NCC bạn nhập không có trong cửa hàng vui lòng nhập lại!");
            tx_MaNCC.setText("");
            tx_MaNCC.requestFocus();
        } else if (!checkMaLoai(dsLoai, tx_MaLoai.getText())) {
            JOptionPane.showMessageDialog(this, "Mã Loai bạn nhập không có trong cửa hàng vui lòng nhập lại!");
            tx_MaLoai.setText("");
            tx_MaLoai.requestFocus();
        } else {
            try {
                    Float.parseFloat(tx_DonGia.getText());
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(this, "Đơn giá  bạn nhập không phải số thực vui lòng nhập lại!");
                    tx_DonGia.requestFocus();
                    return;
                }
            SanPham_DTO sptam=new SanPham_DTO();
            sptam.setMaSp(tx_MaSP.getText());
            sptam.setMaNcc(tx_MaNCC.getText());
            sptam.setMaLoai(tx_MaLoai.getText());
            sptam.setTenSP(tx_TenSP.getText());
            sptam.setMieuta(tx_MieuTa.getText());
            sptam.setDongia(Float.parseFloat(tx_DonGia.getText()));
            sptam.setSoluong(Integer.parseInt(tx_SoLuong.getText()));
            sptam.setAnh(dsSP.get(i).getAnh());
            if(!ImgPath.isEmpty())
            {
                File fileAnh = new File(ImgPath);
                String tenAnh = fileAnh.getName(); // Lấy tên tập tin
                sptam.setAnh(tenAnh);
            }
            
                dsSP=sp_BUS.SuaSP(i,sptam);
                sp_BUS.suaLoai(loaisp_BUS, cu, tx_MaLoai.getText(),tx_SoLuong.getText());
                ImgPath="";
//            ImageIcon img = new ImageIcon(new ImageIcon("C:\\Users\\ADMIN\\OneDrive\\Documents\\NetBeansProjects\\doan_java\\src\\Image\\anhdongho\\" + sp.getAnh()).getImage().getScaledInstance(47, 47, Image.SCALE_SMOOTH));
                try {
                    // Đọc ảnh từ đường dẫn và tạo ImageIcon
                    BufferedImage anh = ImageIO.read(new File("C:\\Users\\ADMIN\\OneDrive\\Documents\\NetBeansProjects\\doan_java\\src\\Image\\anhdongho\\"+sptam.getAnh()));
                    Image scaledImage = anh.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
                    ImageIcon icon = new ImageIcon(scaledImage);
                    model.setValueAt(icon, i, 0);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                model.setValueAt(sptam.getMaNcc(), i, 2);
                model.setValueAt(sptam.getMaLoai(), i, 3);
                model.setValueAt(sptam.getTenSP(), i, 4);
                model.setValueAt(sptam.getMieuta(), i, 5);
                model.setValueAt(String.valueOf(sptam.getDongia()), i, 6);
                model.setValueAt(String.valueOf(sptam.getSoluong()), i, 7);
                tableSP.setModel(model);
                
                JOptionPane.showMessageDialog(this, "Sửa Sản phẩm có mã " +tx_MaSP.getText()+" thành công");
                bt_ClearActionPerformed(evt);
        }
    } else {
        JOptionPane.showMessageDialog(this, "Đã vượt quá độ lớn của danh sách sản phẩm");
    }
}

    private void bt_ClearActionPerformed(java.awt.event.ActionEvent evt) {
        tx_MaSP.setEnabled(true);
        tx_MaSP.setDisabledTextColor(Color.BLACK);
        tx_MaSP.setText("");
        tx_MaNCC.setText("");
        tx_MaLoai.setText("");
        tx_TenSP.setText("");
        tx_MieuTa.setText("");
         tx_SoLuong.setText("0");
        tx_SoLuong.setEnabled(false);
        tx_DonGia.setText("");
        lb_ChuaAnh.setIcon(null);
    }
    private void bt_TimKiemCoBanActionPerformed(java.awt.event.ActionEvent evt) {
        if(tx_NhapID.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(this,"Vui lòng nhập nội dung cần tìm vào tx của tìm kiếm cơ bản");
            tx_NhapID.requestFocus();
        }
        else
        {
            DefaultTableModel model_tam = new DefaultTableModel();
            model_tam=sp_BUS.TKCB(String.valueOf( cb_TimKiemCB.getSelectedItem()), tx_NhapID.getText());
            if(model_tam.getRowCount()>0)
                tableSP.setModel(model_tam);
            else
                JOptionPane.showMessageDialog(null,"Cửa hàng không có sản phẩm theo như yêu cầu của bạn");
            tx_NhapID.setText("");
        }
    }
    
    private void bt_TimKiemNangCaoActionPerformed(java.awt.event.ActionEvent evt) {
       if(tx_NhapMaNCC.getText().isEmpty() && tx_NhapSLMin.getText().isEmpty() && tx_NhapSL_Max.getText().isEmpty() && tx_NhapDG_Min.getText().isEmpty()&&tx_NhapDG_Max.getText().isEmpty())
       {
           JOptionPane.showMessageDialog(this,"Vui lòng nhập tối thiểu 1 thông tin để thực thi tìm kiếm kết hợp");
            tx_NhapMaNCC.requestFocus();
       }
       else
       {
            DefaultTableModel model_tam = new DefaultTableModel();
            model_tam=sp_BUS.TKNC(tx_NhapMaNCC.getText(), tx_NhapSLMin.getText(), tx_NhapSL_Max.getText(), tx_NhapDG_Min.getText(), tx_NhapDG_Max.getText());
            if(model_tam!=null)
            {
                if(model_tam.getRowCount()>0 )
                {
                    tableSP.setModel(model_tam);
                }
               else
               {
                   JOptionPane.showMessageDialog(null,"Cửa hàng không có sản phẩm theo như yêu cầu của bạn");
               }
            }
            
            
            tx_NhapMaNCC.setText("");
            tx_NhapSLMin.setText("");
            tx_NhapSL_Max.setText("");
            tx_NhapDG_Min.setText("");
            tx_NhapDG_Max.setText("");
       }
       
    }
    private void bt_XongActionPerformed(java.awt.event.ActionEvent evt) {
         tableSP.setModel(model);
    }
    private void tableKHMouseClicked(java.awt.event.MouseEvent evt) {
        int i=tableSP.getSelectedRow();
        if(i>=0 && i<dsSP.size())
        {
            tx_MaSP.setEnabled(false);
            tx_MaSP.setDisabledTextColor(Color.GRAY);
            SanPham_DTO sp=new SanPham_DTO();
            sp=dsSP.get(i);
            tx_MaSP.setText(sp.getMaSp());
            tx_MaNCC.setText(sp.getMaNcc());
            tx_MaLoai.setText(sp.getMaLoai());
            tx_TenSP.setText(sp.getTenSP());
            tx_DonGia.setText(String.valueOf(sp.getDongia()));
            tx_MieuTa.setText(sp.getMieuta());
            tx_SoLuong.setText(String.valueOf(sp.getSoluong()));
            ImageIcon anh=new ImageIcon("C:\\Users\\ADMIN\\OneDrive\\Documents\\NetBeansProjects\\doan_java\\src\\Image\\anhdongho\\"+sp.getAnh());
            Image img = anh.getImage().getScaledInstance(lb_ChuaAnh.getWidth()-3, lb_ChuaAnh.getHeight()-3, Image.SCALE_SMOOTH);
            ImageIcon image=new ImageIcon(img);
            lb_ChuaAnh.setIcon(image);
            tx_MaNCC.requestFocus();
        }
        else 
        {
            JOptionPane.showMessageDialog(this,"Đã vượt quá độ lớn của danh sách");
        }
    }
    private void ViTriCuaTableMa()
    {
  
        //MaNCC
        resultTable = new JTable();
        DefaultTableModel modelMaNCC = new DefaultTableModel(new Object[]{""}, 0);
        resultTable.setModel(modelMaNCC);
        scrollPane = new JScrollPane(resultTable);

        // Thêm scrollPane vào JFrame
        chitiet.add(scrollPane);
        scrollPane.setBounds(78, 90, 118, 50);
        scrollPane.setVisible(false); // Đặt visible là false ở đây
        
        //table mã DM
        Tb_MaDM=new JTable();
        DefaultTableModel modelMaDM = new DefaultTableModel(new Object[]{""}, 0);
        Tb_MaDM.setModel(modelMaDM);
        scroll_MaDM=new JScrollPane(Tb_MaDM);
        //scroll_MaDM.setViewportView(Tb_MaDM);
        chitiet.add(scroll_MaDM);
        scroll_MaDM.setBounds(78,115,118,50);
        scroll_MaDM.setVisible(false);
        
    }
    private void searchMaNCC(String ma)
    {
        DefaultTableModel modelMaNCC = (DefaultTableModel) resultTable.getModel();
        modelMaNCC.setRowCount(0);
        for(NCC_DTO i:dsNCC)
            if(i.getMaNCC().toLowerCase().contains(ma.toLowerCase()))
                modelMaNCC.addRow(new Object[]{i.getMaNCC()});
        
    }
    private void txMaNCCMouseListener()
    {

        tx_MaNCC.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                // Khi người dùng nhập, thực hiện tìm kiếm và hiển thị kết quả
                scrollPane.setVisible(true);
                tx_MaLoai.setVisible(false);
                tx_TenSP.setVisible(false);
                String searchText = tx_MaNCC.getText();
                searchMaNCC(searchText);
            }
        });
    }
    private void tableMaNCC_Click(java.awt.event.MouseEvent evt)
    {
        int i=resultTable.getSelectedRow();
        if(i>-1)
        {
            tx_MaNCC.setText(resultTable.getValueAt(i,0).toString());
            scrollPane.setVisible(false);
            tx_MaLoai.setVisible(true);
            tx_TenSP.setVisible(true);
        }
    }
    private void searchMaDM(String ma)
    {
        DefaultTableModel modelMaLoai = (DefaultTableModel) Tb_MaDM.getModel();
        modelMaLoai.setRowCount(0);
        for(loaiSP_DTO i:dsLoai)
            if(i.getMaLoai().toLowerCase().contains(ma.toLowerCase()))
                modelMaLoai.addRow(new Object[]{i.getMaLoai()});
    }
    private void txMaLoaiMouseListener()
    {

        tx_MaLoai.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                // Khi người dùng nhập, thực hiện tìm kiếm và hiển thị kết quả
                scroll_MaDM.setVisible(true);
            tx_MieuTa.setVisible(false);
            tx_TenSP.setVisible(false);
                String searchText = tx_MaLoai.getText();
                searchMaDM(searchText);
            }
        });
    }
    private void tableMaLoai_Click(java.awt.event.MouseEvent evt)
    {
        int i=Tb_MaDM.getSelectedRow();
        if(i>-1)
        {
            tx_MaLoai.setText(Tb_MaDM.getValueAt(i,0).toString());
            scroll_MaDM.setVisible(false);
            tx_MieuTa.setVisible(true);
            tx_TenSP.setVisible(true);
        }
    }
    public GUI_Sanpham() {
        setTitle("Quản lí sản phẩm");
        setSize(910, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null); // Tắt LayoutManager để sử dụng setBounds()
        setResizable(false);
        jlb_anh.setIcon(icon);
        jlb_anh.setHorizontalAlignment(JLabel.CENTER); 
        jlb_anh.setVerticalAlignment(JLabel.CENTER); 
        tieude.setBounds(150, 0, 750, 30);
        tieude.setBackground(new java.awt.Color(102,102,102));

        menu.setBounds(0, 0, 150, 565); // Đặt vị trí và kích thước cho panel menu
        //menu.setLayout(new GridLayout(12, 1));
        menu.setBackground(new java.awt.Color(51,153,255));

        // Panel chi tiết
        chitiet.setBounds(150, 30, 750, 535); // Đặt vị trí và kích thước cho panel chi tiết
        chitiet.setBackground(new java.awt.Color(204,204,204));


        // Đặt kích thước cho các nút trong menu
        jlb_anh.setPreferredSize(new Dimension(150, 180));
        bt_sp.setPreferredSize(new Dimension(150, 30)); // Điều chỉnh kích thước nút
        bt_kh.setPreferredSize(new Dimension(150,30));
        bt_nv.setPreferredSize(new Dimension(150, 30));
        bt_bh.setPreferredSize(new Dimension(150, 30));
        bt_km.setPreferredSize(new Dimension(150, 30));
        bt_duyet.setPreferredSize(new Dimension(150, 30));
        bt_user.setPreferredSize(new Dimension(150, 30));
        bt_ncc.setPreferredSize(new Dimension(150, 30));
        bt_kho.setPreferredSize(new Dimension(150, 30));
        bt_tk.setPreferredSize(new Dimension(150, 30));
        bt_dx.setPreferredSize(new Dimension(100, 22));
        bt_dx.setBackground(Color.PINK);
        lb_bentrai.setForeground(Color.WHITE);
        lb_benphai.setForeground(Color.WHITE);
        lb_bentrai.setFont(new Font("Times New Roman", Font.BOLD, 14));
        lb_benphai.setFont(new Font("Times New Roman", Font.BOLD, 14));
        Box hbox = Box.createHorizontalBox();
        hbox.add(lb_bentrai);
        hbox.add(Box.createHorizontalStrut(200));
        hbox.add(lb_benphai);
        tieude.setLayout(new BorderLayout());
        tieude.add(hbox, BorderLayout.WEST);

        // Panel menu
        
        bt_sp.setBackground(new java.awt.Color(153,255,153));
        menu.add(jlb_anh);
        menu.add(bt_sp);
        menu.add(bt_kh);
        menu.add(bt_nv);
        menu.add(bt_bh);
        menu.add(bt_km);
        menu.add(bt_duyet);
        menu.add(bt_user);
        menu.add(bt_ncc);
        menu.add(bt_kho);
        menu.add(bt_tk);
        menu.add(bt_dx);
        //Sản phẩm
        lb_anh_chinh = new javax.swing.JLabel();
        lb_LoiChao = new javax.swing.JLabel();
        lb_MaSP = new javax.swing.JLabel();
        tx_MaSP = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        //tableSP = new javax.swing.JTable();
        lb_MaNCC = new javax.swing.JLabel();
        tx_MaNCC = new javax.swing.JTextField();
        lb_MaLoai = new javax.swing.JLabel();
        tx_MaLoai = new javax.swing.JTextField();
        lb_TenSP = new javax.swing.JLabel();
        tx_TenSP = new javax.swing.JTextField();
        lb_MieuTa = new javax.swing.JLabel();
        tx_MieuTa = new javax.swing.JTextField();
        lb_DonGia = new javax.swing.JLabel();
        tx_DonGia = new javax.swing.JTextField();
        lb_SoLuong = new javax.swing.JLabel();
        tx_SoLuong = new javax.swing.JTextField();
        lb_Anh = new javax.swing.JLabel();
        bt_Them = new javax.swing.JButton();
        bt_Sua = new javax.swing.JButton();
        bt_Clear = new javax.swing.JButton();
        lb_TimKiem = new javax.swing.JPanel();
        pn_TK_CoBan = new javax.swing.JPanel();
        lb_CoBan = new javax.swing.JLabel();
        tx_NhapID = new javax.swing.JTextField();
        bt_Timkiem_CoBan = new javax.swing.JButton();
        cb_TimKiemCB = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        lb_TK_NangCao = new javax.swing.JLabel();
        lb_NhapMaNCC = new javax.swing.JLabel();
        tx_NhapMaNCC = new javax.swing.JTextField();
        lb_NhapSL = new javax.swing.JLabel();
        tx_NhapSLMin = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        tx_NhapSL_Max = new javax.swing.JTextField();
        lb_NhapDonGia = new javax.swing.JLabel();
        tx_NhapDG_Min = new javax.swing.JTextField();
        tx_NhapDG_Max = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        bt_TimKiem_NangCao = new javax.swing.JButton();
        lb_Lc_TimKiem = new javax.swing.JLabel();
        bt_ChonAnh = new javax.swing.JButton();
        bt_Dong = new javax.swing.JButton();
        bt_Xoa = new javax.swing.JButton();
        lb_ChuaAnh = new javax.swing.JLabel();
        dsSP=new ArrayList<SanPham_DTO>();
       
        lb_anh_chinh.setIcon(new javax.swing.ImageIcon("D:\\vietcpp\\.vscode\\doan_java\\Image\\icons8-product-26.png")); // NOI18N

        lb_LoiChao.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        lb_LoiChao.setText("Quản lí sản phẩm");

        lb_MaSP.setText("Mã SP");
        model = new DefaultTableModel(new Object[]{"Ảnh", "Mã SP", "Mã NCC", "Mã Loại", "Tên SP", "Miêu tả", "Đơn Giá", "Số lượng"}, 0);
        tableSP=new JTable(model){
            Class[] types = new Class [] 
        {
                ImageIcon.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Float.class, java.lang.Integer.class
            };

//            public Class getColumnClass(int columnIndex) {
//                return types [columnIndex];
//            }
            @Override
            public Class<?> getColumnClass(int column) {
                return column == 0 ? ImageIcon.class : Object.class;
            }
        };
        // Thiết lập độ cao của các hàng trong table là 50
        tableSP.setRowHeight(50);
        jScrollPane1.setViewportView(tableSP);
        lb_MaNCC.setText("Mã NCC");

        lb_MaLoai.setText("Mã loại");

        lb_TenSP.setText("Tên SP");

        lb_MieuTa.setText("Miêu tả");

        lb_DonGia.setText("Đơn giá");

        lb_SoLuong.setText("Số lượng");

        lb_Anh.setText("Ảnh");
        lb_ChuaAnh.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        bt_Them.setBackground(new java.awt.Color(255, 153, 153));
        ImageIcon anhThem= new ImageIcon("D:\\vietcpp\\.vscode\\doan_java\\Image\\icons8-add-27.png");
        ImageIcon anhThem_resized = new ImageIcon(anhThem.getImage().getScaledInstance(24, 24, java.awt.Image.SCALE_SMOOTH));
        bt_Them.setIcon(anhThem_resized);
        bt_Them.setPreferredSize(new java.awt.Dimension(24, 24));

        ImageIcon anhSua= new ImageIcon("D:\\vietcpp\\.vscode/doan_java/Image/icons8-update-left-rotation-27.png");
        ImageIcon anhSua_resized = new ImageIcon(anhSua.getImage().getScaledInstance(22, 22, java.awt.Image.SCALE_SMOOTH));
        bt_Sua.setIcon(anhSua_resized); // NOI18N
        bt_Sua.setPreferredSize(new java.awt.Dimension(24, 24));

        ImageIcon anhClear= new ImageIcon("D:\\vietcpp\\.vscode\\\\doan_java/Image/clean-icon2.png");
        ImageIcon anhClear_resized = new ImageIcon(anhClear.getImage().getScaledInstance(22, 22, java.awt.Image.SCALE_SMOOTH));
        bt_Clear.setIcon(anhClear_resized);
        bt_Clear.setPreferredSize(new java.awt.Dimension(24, 24));

        lb_TimKiem.setBackground(new java.awt.Color(255, 204, 204));

        pn_TK_CoBan.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lb_CoBan.setBackground(new java.awt.Color(51, 255, 204));
        lb_CoBan.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lb_CoBan.setText("Tìm kiếm cơ bản");

        cb_TimKiemCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mã SP", "Mã NCC", "Mã Loại", "Tên SP", "Đơn Giá", "Số lượng" }));
        

        ImageIcon anh_Tk_CoBan= new ImageIcon("D:\\vietcpp\\.vscode\\\\doan_java/Image/icons8-search-27.png");
        ImageIcon anh_Tk_CoBan_resized = new ImageIcon(anh_Tk_CoBan.getImage().getScaledInstance(22, 22, java.awt.Image.SCALE_SMOOTH));
        bt_Timkiem_CoBan.setIcon(anh_Tk_CoBan_resized);
        bt_Timkiem_CoBan.setPreferredSize(new java.awt.Dimension(24, 24));
        
        hienThi();
        // hiện thị tìm kiếm mã khi nhập txMaNCC
        ViTriCuaTableMa();
        txMaNCCMouseListener();
        resultTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMaNCC_Click(evt);
            }
        });
        // với mã Loai
        txMaLoaiMouseListener();
        Tb_MaDM.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMaLoai_Click(evt);
            }
        });
        // hủy tìm kiếm
        chitiet.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                scrollPane.setVisible(false);
                tx_MaLoai.setVisible(true);
                tx_TenSP.setVisible(true);
                scroll_MaDM.setVisible(false);
                tx_MieuTa.setVisible(true);
            }
        });
        
        bt_Them.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            bt_ThemActionPerformed(evt);
            }
        });
        bt_Xoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                
                bt_XoaActionPerformed(evt);
            }
        });
        bt_Sua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                
                bt_SuaActionPerformed(evt);
            }
        });
        bt_Clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                
                bt_ClearActionPerformed(evt);
            }
        });
        bt_Dong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                
                bt_XongActionPerformed(evt);
            }
        });
        bt_Timkiem_CoBan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                
                bt_TimKiemCoBanActionPerformed(evt);
            }
        });
        bt_TimKiem_NangCao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                
                bt_TimKiemNangCaoActionPerformed(evt);
            }
        });
        tableSP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableKHMouseClicked(evt);
            }
        });
        javax.swing.GroupLayout pn_TK_CoBanLayout = new javax.swing.GroupLayout(pn_TK_CoBan);
        pn_TK_CoBan.setLayout(pn_TK_CoBanLayout);
        pn_TK_CoBanLayout.setHorizontalGroup(
            pn_TK_CoBanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_TK_CoBanLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(lb_CoBan, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(75, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pn_TK_CoBanLayout.createSequentialGroup()
                .addComponent(cb_TimKiemCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tx_NhapID)
                .addGap(24, 24, 24))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pn_TK_CoBanLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(bt_Timkiem_CoBan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pn_TK_CoBanLayout.setVerticalGroup(
            pn_TK_CoBanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_TK_CoBanLayout.createSequentialGroup()
                .addComponent(lb_CoBan)
                .addGap(18, 18, 18)
                .addGroup(pn_TK_CoBanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tx_NhapID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cb_TimKiemCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(bt_Timkiem_CoBan, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lb_TK_NangCao.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lb_TK_NangCao.setText("Tìm kiếm Kết Hợp");
        ImageIcon anh_Tk_NangCao_resized = new ImageIcon(anh_Tk_CoBan.getImage().getScaledInstance(22, 22, java.awt.Image.SCALE_SMOOTH));
        bt_TimKiem_NangCao.setIcon(anh_Tk_CoBan_resized);
        bt_TimKiem_NangCao.setPreferredSize(new java.awt.Dimension(24, 24));
        lb_NhapMaNCC.setText("Mã NCC");

        lb_NhapSL.setText("Số lượng");

        jLabel1.setText("đến");

        lb_NhapDonGia.setText("Đơn giá");

        jLabel2.setText("đến");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(129, 129, 129)
                        .addComponent(lb_TK_NangCao))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(lb_NhapDonGia, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(1, 1, 1)
                                .addComponent(tx_NhapDG_Min, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(lb_NhapMaNCC, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tx_NhapMaNCC)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(tx_NhapDG_Max, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                                .addComponent(bt_TimKiem_NangCao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(lb_NhapSL, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tx_NhapSLMin, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(tx_NhapSL_Max, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap(43, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(lb_TK_NangCao)
                        .addGap(13, 13, 13)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lb_NhapMaNCC)
                            .addComponent(tx_NhapMaNCC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lb_NhapSL)
                            .addComponent(tx_NhapSLMin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tx_NhapSL_Max, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                        .addComponent(bt_TimKiem_NangCao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(lb_NhapDonGia)
                            .addComponent(tx_NhapDG_Min, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tx_NhapDG_Max, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(16, 16, 16))
        );

        javax.swing.GroupLayout lb_TimKiemLayout = new javax.swing.GroupLayout(lb_TimKiem);
        lb_TimKiem.setLayout(lb_TimKiemLayout);
        lb_TimKiemLayout.setHorizontalGroup(
            lb_TimKiemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lb_TimKiemLayout.createSequentialGroup()
                .addComponent(pn_TK_CoBan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        lb_TimKiemLayout.setVerticalGroup(
            lb_TimKiemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pn_TK_CoBan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        lb_Lc_TimKiem.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lb_Lc_TimKiem.setText("Thông tin tìm kiếm");

        bt_ChonAnh.setText("Chọn ảnh");

        ImageIcon anhXong= new ImageIcon("D:\\vietcpp\\.vscode\\doan_java\\Image\\sign-check-icon.png");
        ImageIcon anhXong_resized = new ImageIcon(anhXong.getImage().getScaledInstance(22, 22, java.awt.Image.SCALE_SMOOTH));
        bt_Dong.setIcon(anhXong_resized); // NOI18N
        bt_Dong.setPreferredSize(new java.awt.Dimension(24, 24));

        ImageIcon anhXoa= new ImageIcon("D:\\vietcpp\\.vscode\\doan_java\\Image\\Button-Delete-icon.png");
        ImageIcon anhXoa_resized = new ImageIcon(anhXoa.getImage().getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH));
        bt_Xoa.setIcon(anhXoa_resized); // NOI18N
        bt_Xoa.setPreferredSize(new java.awt.Dimension(24, 24));

        javax.swing.GroupLayout chitietLayout = new javax.swing.GroupLayout(chitiet);
        chitiet.setLayout(chitietLayout);
        chitietLayout.setHorizontalGroup(
            chitietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, chitietLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lb_Lc_TimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(131, 131, 131)
                .addComponent(bt_Dong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(chitietLayout.createSequentialGroup()
                .addGroup(chitietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, chitietLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(chitietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lb_MaSP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lb_MaNCC, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lb_MaLoai, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lb_TenSP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lb_MieuTa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lb_DonGia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lb_SoLuong, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                            .addComponent(lb_Anh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(chitietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(chitietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(tx_SoLuong, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE)
                                .addComponent(tx_DonGia, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE)
                                .addComponent(tx_MieuTa, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE)
                                .addComponent(tx_TenSP, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE)
                                .addComponent(tx_MaLoai, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE)
                                .addComponent(tx_MaNCC, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE)
                                .addComponent(tx_MaSP, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE))
                            .addGroup(chitietLayout.createSequentialGroup()
                                .addGroup(chitietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(chitietLayout.createSequentialGroup()
                                        .addComponent(bt_Them, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(bt_Xoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(lb_ChuaAnh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(chitietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(chitietLayout.createSequentialGroup()
                                        .addGap(12, 12, 12)
                                        .addComponent(bt_Sua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(bt_Clear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(chitietLayout.createSequentialGroup()
                                        .addGap(1, 1, 1)
                                        .addComponent(bt_ChonAnh)))))
                        .addGroup(chitietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(chitietLayout.createSequentialGroup()
                                .addGap(86, 86, 86)
                                .addComponent(lb_anh_chinh)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lb_LoiChao, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(chitietLayout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(jScrollPane1))))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, chitietLayout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(lb_TimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(35, 35, 35))
        );
        chitietLayout.setVerticalGroup(
            chitietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(chitietLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(chitietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lb_anh_chinh)
                    .addComponent(lb_LoiChao))
                .addGroup(chitietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(chitietLayout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addGroup(chitietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tx_MaSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lb_MaSP))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(chitietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tx_MaNCC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lb_MaNCC))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(chitietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tx_MaLoai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lb_MaLoai))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(chitietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tx_TenSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lb_TenSP))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(chitietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lb_MieuTa)
                            .addComponent(tx_MieuTa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(chitietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lb_DonGia)
                            .addComponent(tx_DonGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(chitietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lb_SoLuong)
                            .addComponent(tx_SoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(chitietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(bt_ChonAnh)
                            .addComponent(lb_ChuaAnh, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lb_Anh))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(chitietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(bt_Sua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bt_Clear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bt_Them, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bt_Xoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(chitietLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(chitietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lb_Lc_TimKiem, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(bt_Dong, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lb_TimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );
        bt_ChonAnh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
               bt_ChonAnh();
            }
        });
        
        
        
        //Sự kiện bàn phím
        tx_SoLuong.setText("0");
        tx_SoLuong.setEnabled(false);
        sukienEnter();
        chuyenForm();
        // Thêm các panel vào JFrame
        add(tieude);
        add(menu);
        add(chitiet);

        setVisible(true);
    }
    public void chuyenForm(){
         if(dn.getQuyen().equals("ADMIN"))
        {
            bt_user.addActionListener(new ActionListener() {
            @Override
                public void actionPerformed(ActionEvent e) {
                    dispose();
                    new GUI_USER().setVisible(true);
                }
            });
            bt_dx.addActionListener(new ActionListener() {
            @Override
                public void actionPerformed(ActionEvent e) {
                    dispose();
                    new GUI_dangnhap().setVisible(true);
                }
            });
            bt_kh.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JOptionPane.showMessageDialog(null, "Bạn là ADMIN bạn không có quyền quản lí thực thể này,bạn chỉ quản lí user!!");
                }
            });
            bt_nv.addActionListener(new ActionListener() {
                @Override 
                public void actionPerformed(ActionEvent e){
                     JOptionPane.showMessageDialog(null, "Bạn là ADMIN bạn không có quyền quản lí thực thể này,bạn chỉ quản lí user!!");
                }
            });
            bt_km.addActionListener(new ActionListener() {
                @Override 
                public void actionPerformed(ActionEvent e){
                     JOptionPane.showMessageDialog(null, "Bạn là ADMIN bạn không có quyền quản lí thực thể này,bạn chỉ quản lí user!!");
                }
            });
            bt_sp.addActionListener(new ActionListener() {
                @Override 
                public void actionPerformed(ActionEvent e){
                     JOptionPane.showMessageDialog(null, "Bạn là ADMIN bạn không có quyền quản lí thực thể này,bạn chỉ quản lí user!!");
                }
            });
            bt_kho.addActionListener(new ActionListener() {
                @Override 
                public void actionPerformed(ActionEvent e){
                     JOptionPane.showMessageDialog(null, "Bạn là ADMIN bạn không có quyền quản lí thực thể này,bạn chỉ quản lí user!!");
                }
            });
            bt_ncc.addActionListener(new ActionListener() {
                @Override 
                public void actionPerformed(ActionEvent e){
                     JOptionPane.showMessageDialog(null, "Bạn là ADMIN bạn không có quyền quản lí thực thể này,bạn chỉ quản lí user!!");
                }
            });
            bt_bh.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                     JOptionPane.showMessageDialog(null, "Bạn là ADMIN bạn không có quyền quản lí thực thể này,bạn chỉ quản lí user!!");
                }
            });
//            bt_duyet.addActionListener(new ActionListener() {
//                @Override 
//                public void actionPerformed(ActionEvent e){
//                 
//                }
//            });
            bt_tk.addActionListener(new ActionListener() {
                @Override 
                public void actionPerformed(ActionEvent e){
                     JOptionPane.showMessageDialog(null, "Bạn là ADMIN bạn không có quyền quản lí thực thể này,bạn chỉ quản lí user!!");
                }
            });
        }
        else if(dn.getQuyen().equals("Quản lí"))
        {
            bt_user.addActionListener(new ActionListener() {
            @Override
                public void actionPerformed(ActionEvent e) {
                    JOptionPane.showMessageDialog(null, "Bạn là nhân viên quản lí bạn không có quyền quản lí thực thể này!!");
                }
            });
            bt_dx.addActionListener(new ActionListener() {
            @Override
                public void actionPerformed(ActionEvent e) {
                    dispose();
                    new GUI_dangnhap().setVisible(true);
                }
            });
            bt_kh.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    dispose();
                    new GUI_Khachhang().setVisible(true);
                }
            });
            bt_nv.addActionListener(new ActionListener() {
                @Override 
                public void actionPerformed(ActionEvent e){
                    dispose();
                    new GUI_NhanVien().setVisible(true);
                }
            });
            bt_km.addActionListener(new ActionListener() {
                @Override 
                public void actionPerformed(ActionEvent e){
                    dispose();
                    new GUI_CTKM().setVisible(true);
                }
            });
            bt_sp.addActionListener(new ActionListener() {
                @Override 
                public void actionPerformed(ActionEvent e){
                    dispose();
                    new GUI_Sanpham().setVisible(true);
                }
            });
            bt_kho.addActionListener(new ActionListener() {
                @Override 
                public void actionPerformed(ActionEvent e){
                    dispose();
                    new GUI_NhapHang().setVisible(true);
                }
            });
            bt_ncc.addActionListener(new ActionListener() {
                @Override 
                public void actionPerformed(ActionEvent e){
                    dispose();
                    new GUI_NCC().setVisible(true);
                }
            });
            bt_bh.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    dispose();
                    new GUI_HoaDon().setVisible(true);
                }
            });
//            bt_duyet.addActionListener(new ActionListener() {
//                @Override 
//                public void actionPerformed(ActionEvent e){
//                 
//                }
//            });
            bt_tk.addActionListener(new ActionListener() {
                @Override 
                public void actionPerformed(ActionEvent e){
                    JOptionPane.showMessageDialog(null, "Bạn là nhân viên quản lí bạn không có quyền quản lí thực thể này!!");
                }
            });
            
        }
        else if(dn.getQuyen().equals("Nhân viên bán hàng"))
        {
            bt_user.addActionListener(new ActionListener() {
            @Override
                public void actionPerformed(ActionEvent e) {
                    JOptionPane.showMessageDialog(null, "Bạn là nhân viên bán hàng bạn không có quyền quản lí thực thể này!!");
                }
            });
            bt_dx.addActionListener(new ActionListener() {
            @Override
                public void actionPerformed(ActionEvent e) {
                    dispose();
                    new GUI_dangnhap().setVisible(true);
                }
            });
            bt_kh.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    dispose();
                    new GUI_Khachhang().setVisible(true);
                }
            });
            bt_nv.addActionListener(new ActionListener() {
                @Override 
                public void actionPerformed(ActionEvent e){
                    JOptionPane.showMessageDialog(null, "Bạn là nhân viên bán hàng bạn không có quyền quản lí thực thể này!!");
                }
            });
            bt_km.addActionListener(new ActionListener() {
                @Override 
                public void actionPerformed(ActionEvent e){
                    dispose();
                    new GUI_CTKM().setVisible(true);
                }
            });
            bt_sp.addActionListener(new ActionListener() {
                @Override 
                public void actionPerformed(ActionEvent e){
                    dispose();
                    new GUI_Sanpham().setVisible(true);
                }
            });
            bt_kho.addActionListener(new ActionListener() {
                @Override 
                public void actionPerformed(ActionEvent e){
                    JOptionPane.showMessageDialog(null, "Bạn là nhân viên bán hàng bạn không có quyền quản lí thực thể này!!");
                }
            });
            bt_ncc.addActionListener(new ActionListener() {
                @Override 
                public void actionPerformed(ActionEvent e){
                    JOptionPane.showMessageDialog(null, "Bạn là nhân viên bán hàng bạn không có quyền quản lí thực thể này!!");
                }
            });
            bt_bh.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    dispose();
                    new GUI_HoaDon().setVisible(true);
                }
            });
//            bt_duyet.addActionListener(new ActionListener() {
//                @Override 
//                public void actionPerformed(ActionEvent e){
//                 
//                }
//            });
            bt_tk.addActionListener(new ActionListener() {
                @Override 
                public void actionPerformed(ActionEvent e){
                    JOptionPane.showMessageDialog(null, "Bạn là nhân viên bán hàng bạn không có quyền quản lí thực thể này!!");
                }
            });
        }
        else
        {
            bt_user.addActionListener(new ActionListener() {
            @Override
                public void actionPerformed(ActionEvent e) {
                    dispose();
                    new GUI_USER().setVisible(true);
                }
            });
            bt_dx.addActionListener(new ActionListener() {
            @Override
                public void actionPerformed(ActionEvent e) {
                    dispose();
                    new GUI_dangnhap().setVisible(true);
                }
            });
            bt_kh.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    dispose();
                    new GUI_Khachhang().setVisible(true);
                }
            });
            bt_nv.addActionListener(new ActionListener() {
                @Override 
                public void actionPerformed(ActionEvent e){
                    dispose();
                    new GUI_NhanVien().setVisible(true);
                }
            });
            bt_km.addActionListener(new ActionListener() {
                @Override 
                public void actionPerformed(ActionEvent e){
                    dispose();
                    new GUI_CTKM().setVisible(true);
                }
            });
            bt_sp.addActionListener(new ActionListener() {
                @Override 
                public void actionPerformed(ActionEvent e){
                    dispose();
                    new GUI_Sanpham().setVisible(true);
                }
            });
            bt_kho.addActionListener(new ActionListener() {
                @Override 
                public void actionPerformed(ActionEvent e){
                    dispose();
                    new GUI_NhapHang().setVisible(true);
                }
            });
            bt_ncc.addActionListener(new ActionListener() {
                @Override 
                public void actionPerformed(ActionEvent e){
                    dispose();
                    new GUI_NCC().setVisible(true);
                }
            });
            bt_bh.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    dispose();
                    new GUI_HoaDon().setVisible(true);
                }
            });
//            bt_duyet.addActionListener(new ActionListener() {
//                @Override 
//                public void actionPerformed(ActionEvent e){
//                 
//                }
//            });
            bt_tk.addActionListener(new ActionListener() {
                @Override 
                public void actionPerformed(ActionEvent e){
                    dispose();
                    new GUI_ThongKe().setVisible(true);
                }
            });
        }
    }
    public void sukienEnter()
    {
        tx_MaSP.requestFocus();
        tx_MaSP.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e){
                if(e.getKeyCode()==KeyEvent.VK_ENTER)
                    tx_MaNCC.requestFocus();
            }
        });
        tx_MaNCC.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e){
                if(e.getKeyCode()==KeyEvent.VK_ENTER)
                    tx_MaLoai.requestFocus();
            }
        });
        tx_MaLoai.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e){
                if(e.getKeyCode()==KeyEvent.VK_ENTER)
                    tx_TenSP.requestFocus();
            }
        });
        tx_TenSP.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e){
                if(e.getKeyCode()==KeyEvent.VK_ENTER)
                    tx_MieuTa.requestFocus();
            }
        });
        tx_MieuTa.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e){
                if(e.getKeyCode()==KeyEvent.VK_ENTER)
                    tx_DonGia.requestFocus();
            }
        });
        tx_DonGia.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e){
                if(e.getKeyCode()==KeyEvent.VK_ENTER)
                    tx_SoLuong.requestFocus();
            }
        });
        tx_SoLuong.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e){
                if(e.getKeyCode()==KeyEvent.VK_ENTER)
                    bt_ChonAnh.requestFocus();
            }
        });
        bt_ChonAnh.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e){
                if(e.getKeyCode()==KeyEvent.VK_ENTER)
                    bt_Them.requestFocus();
            }
        });
        tx_NhapID.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e){
                if(e.getKeyCode()==KeyEvent.VK_ENTER)
                    bt_Timkiem_CoBan.doClick();
            }
        });
        bt_Them.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e){
                if(e.getKeyCode()==KeyEvent.VK_ENTER)
                    bt_Clear.requestFocus();
            }
        });
        tx_NhapID.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e){
                if(e.getKeyCode()==KeyEvent.VK_ENTER)
                    bt_Timkiem_CoBan.requestFocus();
            }
        });
        tx_NhapMaNCC.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e){
                if(e.getKeyCode()==KeyEvent.VK_ENTER)
                    tx_NhapDG_Min.requestFocus();
            }
        });
        tx_NhapDG_Min.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e){
                if(e.getKeyCode()==KeyEvent.VK_ENTER)
                    tx_NhapDG_Max.requestFocus();
            }
        });
        tx_NhapDG_Max.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e){
                if(e.getKeyCode()==KeyEvent.VK_ENTER)
                    tx_NhapSLMin.requestFocus();
            }
        });
        tx_NhapSLMin.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e){
                if(e.getKeyCode()==KeyEvent.VK_ENTER)
                    tx_NhapSL_Max.requestFocus();
            }
        });
        tx_NhapSL_Max.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e){
                if(e.getKeyCode()==KeyEvent.VK_ENTER)
                    bt_TimKiem_NangCao.requestFocus();
            }
        });
        bt_TimKiem_NangCao.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e){
                if(e.getKeyCode()==KeyEvent.VK_ENTER)
                    bt_Xoa.requestFocus();
            }
        });
        bt_Xoa.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e){
                if(e.getKeyCode()==KeyEvent.VK_ENTER)
                    bt_Sua.requestFocus();
            }
        });
        bt_Sua.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e){
                if(e.getKeyCode()==KeyEvent.VK_ENTER)
                    bt_Dong.requestFocus();
            }
        });

    }
//    public static void main(String[] args) {
//        new GUI_Sanpham();
//    }
}

        
