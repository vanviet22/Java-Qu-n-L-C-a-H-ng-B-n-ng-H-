/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import ConnectDB.XuLyDatabase;
import DTO.CTPN_DTO;
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
public class CTPN_DAO {
    private XuLyDatabase xuLyDB = null;
    private Connection conn = null;
    private PreparedStatement ps = null;
    private java.sql.Statement st;
    private ResultSet rs = null;
    public ArrayList<CTPN_DTO> getAllCTPN()
    {
        ArrayList<CTPN_DTO> dsCTPN = new ArrayList<CTPN_DTO>();
        try
        {
            xuLyDB = new XuLyDatabase();
            conn = xuLyDB.openConnection();
            String qry = "Select * from ctpn ";
            ps = conn.prepareStatement(qry);
            rs = ps.executeQuery(qry);
            while(rs.next())
            {
                CTPN_DTO ctpn = new CTPN_DTO();
                ctpn.setMaPN(rs.getString(1));
                ctpn.setMaSP(rs.getString(2));
                ctpn.setSoLuong(Integer.parseInt(rs.getString(3)));
                ctpn.setGiaNhap(Float.parseFloat(rs.getString(4)));
                ctpn.setThanhTien(Double.parseDouble(rs.getString(5)));
                dsCTPN.add(ctpn);
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
    return dsCTPN;
    }
    public void ThemCTPN(CTPN_DTO ctpn)
    {
        try
        {
            xuLyDB = new XuLyDatabase();
            conn = xuLyDB.openConnection();
            String qry="Insert into ctpn Values (";
            qry = qry + "'" + ctpn.getMaPN() + "'"+"," + "'" + ctpn.getMaSP() + "'"+"," + "'" + ctpn.getSoLuong() + "'"+"," + "'" + ctpn.getGiaNhap()+ "'"+"," + "'" + ctpn.getThanhTien()+ "')";
    
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
    public void XoaCTPN(String ma1, String ma2)
    {
        try
            {
                xuLyDB = new XuLyDatabase();
                conn = xuLyDB.openConnection();
                st = conn.createStatement();
                String qry="Delete from ctpn where MAPN='"+ma1+"' and MASP='"+ma2+"'";
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
    
    public void SuaCTPN(CTPN_DTO ctpn)
    {
        try{
            xuLyDB = new XuLyDatabase();
            conn =  xuLyDB.openConnection();
            st = conn.createStatement();
            String qry = "Update ctpn Set ";
            qry = qry +"SOLUONG='"+ ctpn.getSoLuong() + "'"+",DONGIANHAP='" + ctpn.getGiaNhap() + "',THANHTIEN='" + ctpn.getThanhTien() + "' WHERE MAPN='" + ctpn.getMaPN() + "' AND MaSP='" + ctpn.getMaSP() + "'";
            
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
