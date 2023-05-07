package hostel;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.*;


public class Hostel {
    
    JFrame f;
    JButton bAdmin, bst, bback;
    ImageIcon i;
    JLabel l,l1,l2,l3;
    
    Font f22 = new Font("Arial",Font.ITALIC,22);
    Font f15 = new Font("Arial",Font.ITALIC,15);
    
    void startPage(Connection con, Statement st)
    {
        f = new JFrame("Hostel");
        
        i = new ImageIcon(this.getClass().getResource("Start.jpg"));
        l = new JLabel(i);
        l.setSize(500,400);
        f.add(l);
        
        l1 = new JLabel("Welcome to Hostel Mannagemnt System");
        l1.setBounds(45, 30,400,20);
        l1.setForeground(Color.white);
        l1.setFont(f22);
        l.add(l1);
 
        bAdmin = new JButton("Admin");
        bAdmin.setBounds(180, 120, 140, 45);
        bAdmin.setBackground(Color.decode("#87CEEB"));
        bAdmin.setBorder(BorderFactory.createLineBorder(Color.white, 2));
        bAdmin.setForeground(Color.white);
        bAdmin.setFont(f22);
        f.add(bAdmin);
        bAdmin.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                new Admin().adminLogin(con, st);
                f.dispose();
                
            }
        });
        
        
        bst = new JButton("Student");
        bst.setBounds(180, 180, 140, 45);
        bst.setBackground(Color.decode("#87CEEB"));
        bst.setForeground(Color.white);
        bst.setFont(f22);
        bst.setBorder(BorderFactory.createLineBorder(Color.white, 2));
        f.add(bst);
        bst.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                new Hostel().bLogAndRegister(con, st);
                f.dispose();
            }
        });
        
        
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(500,400);
        f.setLayout(null);
        f.setResizable(false);
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }
    
    void bLogAndRegister(Connection con, Statement st)
    {
        f = new JFrame("Hostel");
        
        i = new ImageIcon(this.getClass().getResource("slogin.jpg"));
        l = new JLabel(i);
        l.setSize(500,400);
        f.add(l);
        
        l2 = new JLabel("do you have an account? if not please register");
        l2.setBounds(75,80, 400, 20);
        l2.setForeground(Color.white);
        l2.setFont(f15);
        l.add(l2);
        
        bAdmin = new JButton("Log In");
        bAdmin.setBounds(180, 120, 140, 45);
        bAdmin.setBackground(Color.decode("#87CEEB"));
        bAdmin.setFont(f22);
        f.add(bAdmin);
        bAdmin.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                new Login(con, st);
                f.dispose();                
            }
        });
        
        
        bst = new JButton("Register");
        bst.setBounds(180, 180, 140, 45);
        bst.setBackground(Color.decode("#87CEEB"));
        bst.setFont(f22);
        f.add(bst);
        
        bst.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                new Register().registration(con, st);
                f.dispose();
            }
        });
        
        
        bback = new JButton("Back");
        bback.setBounds(45, 290, 70, 30);
        bback.setBackground(Color.decode("#87CEEB"));
        bback.setFont(f15);
        f.add(bback);
        bback.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                new Hostel().startPage(con, st);
                f.dispose();
            }
            
        });
        
        
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(500,400);
        f.setLayout(null);
        f.setResizable(false);
        f.setLocationRelativeTo(null);
        f.setVisible(true);
        
    }
 
    public static void main(String[] args)  {
        try{
        	Connection con;
        
        Statement st;
        Class.forName("com.mysql.cj.jdbc.Driver");
                
        String url = "jdbc:mysql://localhost:3306/hostel";
        con = DriverManager.getConnection(url, "root", "");
        st = con.createStatement();
        new Hostel().startPage(con, st);

    }catch(Exception e) {
    	System.out.println(e);
    	}
    }
}
