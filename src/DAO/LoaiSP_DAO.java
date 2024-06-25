/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author HP
 */
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import ConnectDB.XuLyDatabase;
import DTO.loaiSP_DTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
/**
 *
 * @author ADMIN
 */
public class LoaiSP_DAO {
    private XuLyDatabase xuLyDB = null;
    private Connection conn = null;
    private PreparedStatement ps = null;
    private java.sql.Statement st;
    private ResultSet rs = null;
    public ArrayList<loaiSP_DTO> getAllLoaiSP()
    {
        ArrayList<loaiSP_DTO> dsLoai = new ArrayList<loaiSP_DTO>();
        try
        {
            xuLyDB = new XuLyDatabase();
            conn = xuLyDB.openConnection();
            String qry = "Select * from loai ";
            ps = conn.prepareStatement(qry);
            rs = ps.executeQuery(qry);
            while(rs.next())
            {
                loaiSP_DTO loai = new loaiSP_DTO();
                loai.setMaLoai(rs.getString(1));
                loai.setTenLoai(rs.getString(2));
                loai.setSoluong(Integer.parseInt(rs.getString(3)));
                dsLoai.add(loai);
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
    return dsLoai;
    }
    public void ThemLoai(loaiSP_DTO loai)
    {
        try
        {
            xuLyDB = new XuLyDatabase();
            conn = xuLyDB.openConnection();
            String qry="Insert into loai Values (";
            qry = qry + "'" + loai.getMaLoai() + "'"+"," + "'" + loai.getTenLoai() + "'"+"," + "'" + loai.getSoluong() + "')";
            st = conn.createStatement();
            st.executeUpdate(qry);
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
    public void XoaLoai(String ma)
    {
        try
            {
                xuLyDB = new XuLyDatabase();
                conn = xuLyDB.openConnection();
                st = conn.createStatement();
                String qry="Delete from loai where MALOAI='"+ma+"'";
                st.executeUpdate(qry);
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, "Lỗi: " + e.getMessage());
            }finally {
                try {
                    xuLyDB.closeConnection(conn);
                    ps.close();
                    rs.close();
                } catch (SQLException e) {
                     e.printStackTrace();
                }
            }
    }
    public void SuaLoai(loaiSP_DTO loai)
    {
        try{
            xuLyDB = new XuLyDatabase();
            conn =  xuLyDB.openConnection();
            st = conn.createStatement();
            String qry = "Update loai Set ";
            qry = qry +"TENLOAI='"+ loai.getTenLoai() + "'"+",SOLUONG='" + loai.getSoluong() + "'WHERE MALOAI='" + loai.getMaLoai() + "'";
            
            st.executeUpdate(qry);
        }catch(SQLException e)
                    {
                        JOptionPane.showMessageDialog(null, "Lỗi khi cập nhật dữ liệu: " + e.getMessage());
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
