/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import ConnectDB.XuLyDatabase;
import DTO.TaiKhoan_DTO;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
/**
 *
 * @author ADMIN
 */
public class user_DAO {
    private XuLyDatabase xuLyDB = null;
    private Connection conn = null;
    private PreparedStatement ps = null;
    private java.sql.Statement st;
    private ResultSet rs = null;
    public ArrayList<TaiKhoan_DTO> getAllUser()
    {
        ArrayList<TaiKhoan_DTO> listUser=new ArrayList<TaiKhoan_DTO>();
        try{
            xuLyDB = new XuLyDatabase();
            conn = xuLyDB.openConnection();
            String qry = "SELECT * FROM user";
            ps = conn.prepareStatement(qry);
            rs = ps.executeQuery(qry);
            while(rs.next())
            {
                TaiKhoan_DTO tk=new TaiKhoan_DTO();
                tk.setMaNV(rs.getString(1));
                tk.setMk(rs.getString(2));
                listUser.add(tk);
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
        return listUser;
    }
    public void ThemUser(TaiKhoan_DTO tk)
    {
        try
        {
            xuLyDB = new XuLyDatabase();
            conn = xuLyDB.openConnection();
            st = conn.createStatement();            
            String qry="Insert into user Values (";
            qry = qry + "'" + tk.getMaNV() + "'"+"," + "'" + tk.getMk() + "')";
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
    public void XoaUser(String ma)
    {
        try
            {
                xuLyDB = new XuLyDatabase();
                conn = xuLyDB.openConnection();
                st = conn.createStatement();               
                String qry="Delete from user where ID='"+ma+"'";
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
    public void SuaUser(TaiKhoan_DTO tk)
    {
        try{
            xuLyDB = new XuLyDatabase();
            conn =  xuLyDB.openConnection();
            st = conn.createStatement();
            String qry = "Update user Set ";
            qry = qry +"MATKHAU='"+ tk.getMk() + "'WHERE ID='" + tk.getMaNV() + "'";
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

