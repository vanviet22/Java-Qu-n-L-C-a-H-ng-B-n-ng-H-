/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import ConnectDB.XuLyDatabase;
import DTO.PhieuNhap_DTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
/**
 *
 * @author ADMIN
 */
public class PN_DAO {
    private XuLyDatabase xuLyDB = null;
    private Connection conn = null;
    private PreparedStatement ps = null;
    private java.sql.Statement st;
    private ResultSet rs = null;
    public ArrayList<PhieuNhap_DTO> getAllPN()
    {
        ArrayList<PhieuNhap_DTO> dsPN = new ArrayList<PhieuNhap_DTO>();
        try
        {
            xuLyDB = new XuLyDatabase();
            conn = xuLyDB.openConnection();
            String qry = "Select * from phieunhap ";
            ps = conn.prepareStatement(qry);
            rs = ps.executeQuery(qry);
            while(rs.next())
            {
                PhieuNhap_DTO pn = new PhieuNhap_DTO();
                pn.setMaPN(rs.getString(1));
                pn.setMaNV(rs.getString(2));
                pn.setMaNCC(rs.getString(3));
                LocalDate ngayLap = rs.getDate(4).toLocalDate(); // Chuyển đổi từ java.sql.Date sang LocalDate
                LocalTime gioLap = LocalTime.of(0, 0, 0); // Đây là một ví dụ, bạn có thể sử dụng thời gian mong muốn
                LocalDateTime ngayLapTime = LocalDateTime.of(ngayLap, gioLap); // Kết hợp LocalDate và LocalTime thành LocalDateTime
                pn.setNgayLap(ngayLapTime);
                pn.setSoLuong(Integer.parseInt(rs.getString(5)));
                pn.setTongTien(Double.parseDouble(rs.getString(6)));
                dsPN.add(pn);
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
    return dsPN;
    }
    public void ThemPN(PhieuNhap_DTO pn)
    {
        try
        {
            xuLyDB = new XuLyDatabase();
            conn = xuLyDB.openConnection();
            String qry="Insert into phieunhap Values (";
            qry = qry + "'" + pn.getMaPN() + "'"+"," + "'" + pn.getMaNV() + "'"+"," + "'" + pn.getMaNCC() + "'"+"," + "'" + pn.getNgayLap()+ "'"+"," + "'" + pn.getSoLuong()+ "'"+"," + "'" + pn.getTongTien() + "')";
    
            st=conn.createStatement();
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
    public void XoaPN(String ma)
    {
        try
            {
                xuLyDB = new XuLyDatabase();
                conn = xuLyDB.openConnection();
                st = conn.createStatement();
                String qry="Delete from phieunhap where MAPN='"+ma+"'";
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
    public void SuaSLVaTT(int sl,double tt,String ma)
    {
        try{
            xuLyDB = new XuLyDatabase();
            conn =  xuLyDB.openConnection();
            st = conn.createStatement();
            String qry = "Update phieunhap Set ";
            qry = qry + "TONGSL='" + sl + "',TONGTIEN='" + tt + "' WHERE MAPN='" + ma + "'";
            
            st.executeUpdate(qry);
        }catch(SQLException e)
                    {
                        JOptionPane.showMessageDialog(null, "Lỗi khi cập nhật dữ liệu: " + e.getMessage());
                    }
//                   finally {
//                        try {
//                            xuLyDB.closeConnection(conn);
//                            ps.close();
//                            rs.close();
//                        } catch (SQLException e) {
//                            e.printStackTrace();
//                        }
//                    }
    }
    public void SuaPN(PhieuNhap_DTO pn)
    {
        try{
            xuLyDB = new XuLyDatabase();
            conn =  xuLyDB.openConnection();
            st = conn.createStatement();
            String qry = "Update phieunhap Set ";
            qry = qry +"ID='"+ pn.getMaNV() + "'"+",MANCC='" + pn.getMaNCC() + "',NGAYLAP='" + pn.getNgayLap() + "',TONGSL='" + pn.getSoLuong() + "',TONGTIEN='" + pn.getTongTien() + "' WHERE MAPN='" + pn.getMaPN() + "'";
            
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
