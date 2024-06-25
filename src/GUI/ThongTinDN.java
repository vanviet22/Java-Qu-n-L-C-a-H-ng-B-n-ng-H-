/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import javax.swing.JFrame;

/**
 *
 * @author ADMIN
 */
public class ThongTinDN {
    private static String HoTen="Xin chào: ";
    private static String quyen;
    private JFrame frame;
    public String getHoTen() {
        return HoTen;
    }
    public String getQuyen() {
        return quyen;
    }
    public void setHoTen(String hoten)
    {
        HoTen=hoten;
    }
    public void setQuyen(String hoten)
    {
        quyen=hoten;
    }
    public JFrame getFrame()
    {
        return frame;
    }
    public void setFrame(JFrame f)
    {
        frame=f;
    }
}
