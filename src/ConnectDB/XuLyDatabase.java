/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ConnectDB;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
/**
 *
 * @author ADMIN
 */
public class XuLyDatabase {
    private static final String dbURL = "jdbc:mysql://localhost:3306/doan_java";
    private static String userName = "root";
    private static String password = "123456789";
    public XuLyDatabase(){};
    public Connection openConnection(){
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection conn = DriverManager.getConnection(dbURL, userName, password);
                if(conn != null){
                    System.out.println("Kết nối DB thành công!");
                    return conn;
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Kết nối DB thất bại!");
                System.out.println("Kết nối DB thất bại!");
                ex.printStackTrace();
            } catch (ClassNotFoundException ex) {      
            Logger.getLogger(XuLyDatabase.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public void closeConnection(Connection conn){
            try {
                if(conn!=null)
                    conn.close();
                    System.out.println("Đóng kết nối DB thành công!");
            } catch (SQLException ex) {
                System.out.println("Đóng kết nối DB thất bại!");
                ex.printStackTrace();
            }
        }
}
