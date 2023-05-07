package hostel;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.regex.*;
import javax.swing.*;

public class Register {
    
    JFrame r;
    JPanel pr,pl; JButton br,bback;
    JLabel l,lr,ln,lp,lm,le,la, lun,lro,ls;
    JTextField tn,tm,te,ta, tun,tc,ts; 
    String name,username,password,mobile,email,address,seatno,roomno;
    JPasswordField tp;ImageIcon i;
    
    ResultSet rs;
    
    Font f20 = new Font("Arial",Font.ITALIC,20);
    Font f30 = new Font("Arial",Font.ITALIC,30);
    
    public void registration(Connection con, Statement st)
    {
        r = new JFrame("Registration");
        
        i = new ImageIcon(this.getClass().getResource("reg01.jpg"));
        l = new JLabel(i);
        l.setSize(700,580);
        r.add(l);
        
        Font font = new Font("Arial",Font.BOLD,17);

        pl = new JPanel();
        pl.setBounds(0, 580, 700, 680);
        pl.setBackground(Color.decode("#87CEEB"));
        r.add(pl);
        
        pr = new JPanel();
        pr.setBounds(45, 40, 599, 80);
        pr.setBackground(Color.decode("#87CEEB"));
        l.add(pr);
        
        lr = new JLabel("Registration Form");
        lr.setForeground(Color.white);
        lr.setFont(f30);
        pr.add(lr);
      
        lun = new JLabel("User name");
        lun.setBounds(45, 150, 150, 50);
        lun.setFont(f20);
        lun.setForeground(Color.white);
        l.add(lun);
        
        tun = new JTextField();
        tun.setBounds(200, 150, 447, 40);
        tun.setFont(font);
        r.add(tun);
        
        ln = new JLabel("Name");
        ln.setBounds(45, 200, 80, 50);
        ln.setFont(f20);
        ln.setForeground(Color.white);
        l.add(ln);
        
        tn = new JTextField();
        tn.setBounds(200, 200, 447, 40);
        tn.setFont(font);
        r.add(tn);

        lp = new JLabel("Password");
        lp.setBounds(45, 250, 120, 50);
        lp.setFont(f20);
        lp.setForeground(Color.white);
        l.add(lp);
        
        tp = new JPasswordField();
        tp.setBounds(200, 250, 446, 40);
        tp.setFont(font);
        r.add(tp);
        
        
        lm = new JLabel("Mobile");
        lm.setBounds(45, 300, 120, 50);
        lm.setFont(f20);
        lm.setForeground(Color.white);
        l.add(lm);
        
        tm = new JTextField();
        tm.setBounds(200, 300, 446, 40);
        tm.setFont(font);
        r.add(tm);
        
        le = new JLabel("E-mail");
        le.setBounds(45, 350, 120, 50);
        le.setFont(f20);
        le.setForeground(Color.white);
        l.add(le);
        
        te = new JTextField();
        te.setBounds(200, 350, 446, 40);
        te.setFont(font);
        r.add(te);
        
        la = new JLabel("Address");
        la.setBounds(45, 400, 120, 50);
        la.setFont(f20);
        la.setForeground(Color.white);
        l.add(la);
        
        ta = new JTextField();
        ta.setBounds(200, 400, 446, 40);
        ta.setFont(font);
        r.add(ta);
        
        lro = new JLabel("Room No");
        lro.setBounds(45, 450, 120, 50);
        lro.setFont(f20);
        lro.setForeground(Color.white);
        l.add(lro);
        
        tc = new JTextField();
        tc.setBounds(200, 450, 446, 40);
        tc.setFont(font);
        r.add(tc);
        
        ls = new JLabel("Seat NO");
        ls.setBounds(45, 500, 120, 50);
        ls.setFont(f20);
        ls.setForeground(Color.white);
        l.add(ls);
        
        ts = new JTextField();
        ts.setBounds(200, 500, 446, 40);
        ts.setFont(font);
        r.add(ts);
               
        br = new JButton("Submit");
        br.setBounds(547, 580, 100, 40);
        br.setBackground(Color.decode("#87CEEB"));
        br.setFont(br.getFont().deriveFont(18f));
        br.setBorder(BorderFactory.createLineBorder(Color.white, 2));
        br.setForeground(Color.white);
        r.add(br);
        br.addActionListener(new ActionListener(){
           public void actionPerformed(ActionEvent e){
               username = tun.getText();
               name = tn.getText(); 
               password = new String(tp.getPassword());
               mobile = tm.getText();
               email = te.getText();
               address = ta.getText();
               roomno = tc.getText();
               seatno = ts.getText();
               
        	    String nameRegex = "^[a-z A-Z]+$";	
                String mobileRegex = "^(\\+88)?01[3-9]\\d{8}";
                String emailRegex = "^[a-z0-9]+@[a-z]+.[a-z]+$";
                 
                String passRegex = "^(?=.*\\d)(?=.*[A-Z])(?=.*[a-z])(?=.*[@#$%&*]).{6,20}";
                
                if(name.isEmpty() || username.isEmpty() || password.isEmpty() || mobile.isEmpty() || email.isEmpty() || address.isEmpty()||roomno.isEmpty()||seatno.isEmpty())
                {
                    JOptionPane.showMessageDialog(null,"Form is blank");
                    
                }else
                {
                    if(!Pattern.matches(nameRegex, name))
                    {
                        JOptionPane.showMessageDialog(null,"Only char is allowed");
                    }
                    else if(!Pattern.matches(emailRegex, email))
                {
                    JOptionPane.showMessageDialog(null,"in valid email");
                }
                else if(!Pattern.matches(mobileRegex, mobile))
                {
                    JOptionPane.showMessageDialog(null,"in valid mobile number");                
                }
                else if(!Pattern.matches(passRegex, password))
                {
               	 JOptionPane.showMessageDialog(null,"1 digit,1 lower,1 upper,1 special char and length 6-20");
                }
                else if(address.equals(""))
                {
                    JOptionPane.showMessageDialog(null,"In-Valid address");                
                }else if(roomno.equals(""))
                {
                    JOptionPane.showMessageDialog(null,"Please give your room No");                
                }else if(seatno.equals(""))
                {
                    JOptionPane.showMessageDialog(null,"Please give your seat No");                
                }
                
                else {

                   String rQuery = "Select username from register where username = '"+username+"'";
                   try {
    
                       rs = st.executeQuery(rQuery);
                       if(rs.next()){
                           JOptionPane.showMessageDialog(null,"Username must be unique");
                       }else{
                           
                           String Query = "Insert into register(username,name,password,mobile,email,address,roomno,seatno) values ('"+username+"','"+name+"','"+password+"','"+mobile+"','"+email+"','"+address+"','"+roomno+"','"+seatno+"')";
                           
                            st.executeUpdate(Query);
                            st.close();
                            con.close();
                            
                            JOptionPane.showMessageDialog(null,"Registration Successfuly");
                            r.dispose();
                       }
                       
                   } catch (SQLException ex) {
                       JOptionPane.showMessageDialog(null,"Registration not Successfuly");
                   }
                 }}	}
        });
        
        bback = new JButton("Back");
        bback.setBounds(45, 580, 100, 40);
        bback.setBackground(Color.decode("#87CEEB"));
        bback.setFont(f20);
        bback.setForeground(Color.white);
        bback.setBorder(BorderFactory.createLineBorder(Color.white, 2));
        r.add(bback);
        bback.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                new Hostel().bLogAndRegister(con, st);
                r.dispose();
            } 
        });
        
        r.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        r.setSize(700,680);
        r.setLayout(null);
        r.setResizable(false);
        r.setLocationRelativeTo(null);
        r.setVisible(true);
    }
    
    
}
