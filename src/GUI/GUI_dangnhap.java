package GUI;
import GUI.GUI_Sanpham;
import GUI.ThongTinDN;
import GUI.GUI_USER;
import DAO.user_DAO;
import DAO.NhanVien_DAO;
import DTO.NhanVien_DTO;
import DTO.TaiKhoan_DTO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class GUI_dangnhap extends JFrame implements ActionListener {
    
     private JTextField usernameField;
     private JPasswordField passwordField;
     private JButton loginButton;
    private ArrayList<TaiKhoan_DTO> listUser;
    private ArrayList<NhanVien_DTO> listNV;
    public ThongTinDN dn=new ThongTinDN();
    public GUI_dangnhap() {
        setTitle("Đăng nhập");
        setSize(400, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        listUser=new ArrayList<TaiKhoan_DTO>();
        setLocationRelativeTo(null); // Đưa cửa sổ vào trung tâm màn hình
        JPanel panel = new JPanel();
        panel.setLayout(null); // Sử dụng layout không
        panel.setBackground(Color.LIGHT_GRAY);
        JLabel titleLabel = new JLabel("Chào mừng bạn đến với hệ thống quản lí ");
        titleLabel.setBounds(70, 10, 300, 20);
        panel.add(titleLabel);

        JLabel usernameLabel = new JLabel("ID đăng nhập:");
        usernameLabel.setBounds(50, 40, 100, 20);
        panel.add(usernameLabel);

        usernameField = new JTextField();
        usernameField.setBounds(150, 40, 200, 20);
        panel.add(usernameField);

        JLabel passwordLabel = new JLabel("Mật khẩu:");
        passwordLabel.setBounds(50, 70, 100, 20);
        panel.add(passwordLabel);

        passwordField = new JPasswordField();
        passwordField.setBounds(150, 70, 200, 20);
        panel.add(passwordField);

        loginButton = new JButton("Đăng nhập");
        loginButton.setBounds(150, 100, 100, 30);
        loginButton.addActionListener(this);
        panel.add(loginButton);

        add(panel);
        setVisible(true);
        sukienEnter();
    }
    public boolean checkTK(ArrayList<TaiKhoan_DTO> list,String ma,String mk,ArrayList<NhanVien_DTO> listNV)
    {
        for(TaiKhoan_DTO i:list)
        {
            if(i.getMaNV().equals(ma) && i.getMk().equals(mk))
            {
                dn.setHoTen("Xin chào: "+Tim(listNV,ma).getHo()+" "+Tim(listNV,ma).getTen());
                dn.setQuyen(Tim(listNV,ma).getChucvu());
                return true;
            }
        }
        return false;
    }
    public NhanVien_DTO Tim(ArrayList<NhanVien_DTO> list,String ma)
    {
        for(NhanVien_DTO i:list)
        {
            if(i.getMaNV().equals(ma))
                return i;
        }
        return null;
    }
    public void actionPerformed(ActionEvent e) {
        String username = usernameField.getText();
        String password = new String(passwordField.getPassword());
        
        user_DAO user=new user_DAO();
        listUser=user.getAllUser();
        NhanVien_DAO nv=new NhanVien_DAO();
        listNV=nv.getAllNV();
        if (checkTK(listUser,username,password,listNV)) {
            if(dn.getQuyen().equals("ADMIN"))
            {
                new GUI_USER().setVisible(true);
            }
            else
            {
                new GUI_Sanpham().setVisible(true);
                
            }
            JOptionPane.showMessageDialog(this, "Đăng nhập thành công!");
            dispose();
            
        } else {
            JOptionPane.showMessageDialog(this, "Đăng nhập không thành công. Vui lòng thử lại!");
            usernameField.requestFocus();

        }
    }
     public void sukienEnter()
    {
        usernameField.requestFocus();
        usernameField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e){
                if(e.getKeyCode()==KeyEvent.VK_ENTER)
                    passwordField.requestFocus();
            }
        });
        passwordField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e){
                if(e.getKeyCode()==KeyEvent.VK_ENTER)
                    loginButton.doClick();
                }
        });
    }
     

    public static void main(String[] args) {
        new GUI_dangnhap();
    }
}

