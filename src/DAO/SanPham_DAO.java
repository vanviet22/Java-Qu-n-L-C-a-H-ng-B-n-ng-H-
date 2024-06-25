/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import ConnectDB.XuLyDatabase;
import DTO.SanPham_DTO;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Base64;
import javax.swing.JOptionPane;
/**
 *
 * @author ADMIN
 */
public class SanPham_DAO {
    private XuLyDatabase xuLyDB = null;
    private Connection conn = null;
    private PreparedStatement ps = null;
    private java.sql.Statement st;
    private ResultSet rs = null;
    public ArrayList<SanPham_DTO> getAllSP()
    {
        ArrayList<SanPham_DTO> dsSP=new ArrayList<SanPham_DTO>();
        try
        {
            xuLyDB=new XuLyDatabase();
            conn=xuLyDB.openConnection();
            String qry="Select * from sanpham";
            ps = conn.prepareStatement(qry);
            rs=ps.executeQuery(qry);
            while(rs.next())
            {
                SanPham_DTO sp=new SanPham_DTO();
                sp.setMaSp(rs.getString(1));
                sp.setMaNcc(rs.getString(2));
                sp.setMaLoai(rs.getString(3));
                sp.setTenSP(rs.getString(4));
                sp.setMieuta(rs.getString(5));
                sp.setDongia(rs.getFloat(6));
                sp.setSoluong(rs.getInt(7));
                sp.setAnh(rs.getString(8));
                dsSP.add(sp);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        
        //Dong ket noi
        finally{
            try{
                xuLyDB.closeConnection(conn);
                ps.close();
                rs.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
        return dsSP;
    }
    public void ThemNhanVien(SanPham_DTO sp)
    {
        try
        {
            xuLyDB=new XuLyDatabase();
            conn=xuLyDB.openConnection();
            String qry="Insert into sanpham Values (";
            qry=qry+"'"+sp.getMaSp()+"','"+sp.getMaNcc()+"','"+sp.getMaLoai()+"','"+sp.getTenSP()+"','"+sp.getMieuta()+"',"+sp.getDongia()+","+sp.getSoluong()+",'"+sp.getAnh()+"')";;
            st=conn.createStatement();
            st.executeUpdate(qry);        
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Lỗi Thêm" + e.getMessage());
        }
        finally {
            try {
                xuLyDB.closeConnection(conn);
                ps.close();
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public void XoaSanPham(String ma)
    {
        try
            {
                String mamoi='-'+ma;
                xuLyDB= new XuLyDatabase();
                conn=xuLyDB.openConnection();
                st=conn.createStatement();
                String qry = "Update sanpham Set ";
                qry = qry + "MASP='" + mamoi+"' WHERE MASP='"+ma+"'";
                st.executeUpdate(qry);
                String qry2="Update cthd Set ";
                qry2 = qry2 + "MASP='" + mamoi+"' WHERE MASP='"+ma+"'";
                st.executeUpdate(qry2);
                String qry3="Update ctpn Set ";
                qry3 = qry3 + "MASP='" + mamoi+"' WHERE MASP='"+ma+"'";
                st.executeUpdate(qry3);
                
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, "Lỗi: " + e.getMessage());
            }
            finally {
                try {
                    xuLyDB.closeConnection(conn);
                    ps.close();
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
    }
    public void SuaSanPham(SanPham_DTO sp)
    {
        try {
            xuLyDB = new XuLyDatabase();
            conn = xuLyDB.openConnection();
            st = conn.createStatement();
            String qry = "Update sanpham Set ";
            qry = qry + "MANCC='" + sp.getMaNcc() + "',MALOAI='" + sp.getMaLoai() + "',TENSP='" + sp.getTenSP() + "',";
            qry = qry + "MOTA='" + sp.getMieuta() + "',GIA=" +sp.getDongia() + ",SOLUONG=" + sp.getSoluong() + ",ANH='" + sp.getAnh()+"' WHERE MASP='"+sp.getMaSp()+"'";
            st.executeUpdate(qry);
        } catch(Exception e){
                JOptionPane.showMessageDialog(null, "Lỗi: " + e.getMessage());
            }
            finally {
                try {
                    xuLyDB.closeConnection(conn);
                    ps.close();
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
    }
}
