package hostel;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.regex.*;
import javax.swing.*;

//public class Login {
	public class Login extends JFrame{
		JPanel p1, p2;
	        JButton bback, bback1;
	      
	        ResultSet rs;
	        JLabel l;
	        ImageIcon i;
	        

	        Login(Connection con, Statement st){
	            setSize(500,310);
	            setDefaultCloseOperation(2);
	            setLayout(null);
	            setLocationRelativeTo(null);

	            i = new ImageIcon(this.getClass().getResource("adminLogin.jpg"));
	            l = new JLabel(i);
	            l.setSize(500,310);
	            add(l);

	            Font font = new Font("Arial",Font.BOLD,30);

	            p1 = new JPanel();
	            p1.setBackground(Color.decode("#87CEEB"));
	            p1.setBounds(5,5,472,60);
	            l.add(p1);

	            JLabel l1 = new JLabel("Student Log In Form");
	            //l1.setForeground(Color.white);
	            l1.setFont(font);
	            l1.setBounds(50,10,50,80);
	            p1.add(l1);

	            p2 = new JPanel();
	            p2.setBounds(5,70,472,187);
	            p2.setBackground(Color.decode("#87CEEB"));
	            p2.setLayout(null);
	            l.add(p2);
	            
	            Font font1 = new Font("Arial",Font.BOLD,16);

	            JLabel u = new JLabel("User name :");
	            u.setBounds(100,5,100,25);
	            u.setFont(font1);
	            p2.add(u);
	            JTextField utxt = new JTextField();
	            utxt.setBounds(200, 5, 200, 25);
	            p2.add(utxt);

	            JLabel pass = new JLabel("Password :");
	            pass.setBounds(110,42,200,25);
	            pass.setFont(font1);
	            p2.add(pass);
	            JPasswordField ptxt = new JPasswordField();
	            ptxt.setBounds(200,46,200,25);
	            p2.add(ptxt);

	    //       JButton rbtn = new JButton("Register");
	    //       rbtn.setBounds(300,100,100,30);
	    //       rbtn.setBackground(Color.green);
	    //       rbtn.setFont(font1);
	    //       p2.add(rbtn);


	           JButton lbtn = new JButton("Login");
	           lbtn.setBounds(310,110,90,30);
	           lbtn.setBackground( Color.decode("#87CEEB"));
	           lbtn.setFont(font1);

	           p2.add(lbtn);
	    //       rbtn.addActionListener(new ActionListener () {
	    //       	@Override
	    //       	public void actionPerformed(ActionEvent e) {
	    //       		//dispose();
	    //       		//new Register().registration(con, st);
	    //       	}
	    //       
	    //        });
	            lbtn.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                    String username = utxt.getText();
	                    String password = new String(ptxt.getPassword());


	                    if(username.isEmpty() || password.isEmpty()){
	                        JOptionPane.showMessageDialog(null,"User Name and Password can not be Blank.");

	                    }else{
	                        String query2 = "Select * from register where username = '"+username+"' and password = '"+password+"'";
	                    try {

	                        rs = st.executeQuery(query2);
	                        if(rs.next()){
	                            dispose();
	                            JOptionPane.showMessageDialog(null,"Log in Successfuly");
	                            new Admin().searchMenu(con, st);

	                        }else{
	                            JOptionPane.showMessageDialog(null, "UserName or Password do not Matched.");

	                        }
	                    } catch (SQLException ex) {
	                                        }
	                    }

	                } 
	           });

	            bback = new JButton("Back");
	            bback.setBounds(80, 110, 90, 30);
	            bback.setBackground(Color.decode("#87CEEB"));
	            bback.setFont(bback.getFont().deriveFont(15f));
	            p2.add(bback);
	            bback.addActionListener(new ActionListener(){
	                public void actionPerformed(ActionEvent e){
	                    new Hostel().bLogAndRegister(con, st);
	                    dispose();
	                }

	            });

	    //       		String userRegex = "^[a-zA-Z]+$";
	    //       	    String passRegex = " (?=.\\d)(?=.[A-Z])(?=.[a-z])(?=.[@#$%&*()]).{6,20}";
	    //       	    
	    //       	 if(!Pattern.matches(userRegex, username))
	    //         {
	    //             JOptionPane.showConfirmDialog(null,"only char in allowed");
	    //         }
	    //         
	    //         if(!Pattern.matches(passRegex, password))
	    //         {
	    //        	 JOptionPane.showConfirmDialog(null,"1 digit,1 lower,1 upper,1 special char and length 6-20");
	    //         }

	      //      }); 
	            setVisible(true);    
	       
	        }
	        
	        
	        
	}
}
