package swingSys;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;

public class Welcome {

	private JFrame frmWelcome;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	/**
	 * @wbp.parser.entryPoint
	 */
	public Welcome() throws SQLException {
		initialize();
	}

	private void initialize() throws SQLException {
		frmWelcome = new JFrame();
		frmWelcome.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Administrator\\Downloads\\user-data-icon.png"));
		frmWelcome.setTitle("Welcome!");
		frmWelcome.setBounds(100, 100, 504, 350);
		frmWelcome.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmWelcome.setVisible(true);
		
		  frmWelcome.getContentPane().setLayout(null);
	        
	        JLabel Hlbl = new JLabel("");
	        Hlbl.setFont(new Font("Tahoma", Font.PLAIN, 14));
	        Hlbl.setBounds(10, 26, 400, 22);
	        frmWelcome.getContentPane().add(Hlbl);
	        
	        JLabel lbl3 = new JLabel("Thank You :)");
	        lbl3.setFont(new Font("Tahoma", Font.PLAIN, 12));
	        lbl3.setBounds(159, 274, 81, 14);
	        frmWelcome.getContentPane().add(lbl3);
	        
	        JLabel lbl2 = new JLabel("PROFILE DETAILS :");
	        lbl2.setFont(new Font("Tahoma", Font.PLAIN, 12));
	        lbl2.setBounds(29, 72, 140, 14);
	        frmWelcome.getContentPane().add(lbl2);
	        
	        JLabel NAME = new JLabel("Name");
	        NAME.setFont(new Font("Tahoma", Font.BOLD, 12));
	        NAME.setBounds(104, 111, 46, 14);
	        frmWelcome.getContentPane().add(NAME);
	        
	        JLabel UN = new JLabel("User Name");
	        UN.setFont(new Font("Tahoma", Font.BOLD, 12));
	        UN.setBounds(104, 136, 65, 14);
	        frmWelcome.getContentPane().add(UN);
	        
	        JLabel MAIL = new JLabel("E-Mail");
	        MAIL.setFont(new Font("Tahoma", Font.BOLD, 12));
	        MAIL.setBackground(new Color(240, 240, 240));
	        MAIL.setBounds(104, 161, 46, 14);
	        frmWelcome.getContentPane().add(MAIL);
	        
	        JLabel NUM = new JLabel("Mobile Number");
	        NUM.setFont(new Font("Tahoma", Font.BOLD, 12));
	        NUM.setBounds(104, 186, 106, 14);
	        frmWelcome.getContentPane().add(NUM);
	        
	        JLabel GENDER = new JLabel("Gender");
	        GENDER.setFont(new Font("Tahoma", Font.BOLD, 12));
	        GENDER.setBounds(104, 211, 46, 14);
	        frmWelcome.getContentPane().add(GENDER);
	        
	        JLabel namef = new JLabel("");
	        namef.setBounds(225, 112, 225, 14);
	        frmWelcome.getContentPane().add(namef);
	        
	        JLabel unf = new JLabel("");
	        unf.setBounds(225, 137, 225, 14);
	        frmWelcome.getContentPane().add(unf);
	        
	        JLabel mailf = new JLabel("");
	        mailf.setBounds(225, 162, 253, 14);
	        frmWelcome.getContentPane().add(mailf);
	        
	        JLabel numf = new JLabel("");
	        numf.setBounds(225, 187, 230, 14);
	        frmWelcome.getContentPane().add(numf);
	        
	        JLabel genderf = new JLabel("");
	        genderf.setBounds(225, 212, 225, 14);
	        frmWelcome.getContentPane().add(genderf);
		
		String un = LogIn.un;
		String pw = LogIn.pw;
		String Name = null ;
		String UserName = null;
		String Email = null;
		String Num = null;
		String Gender = null;
		
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Gokul","root","Root@25");
		PreparedStatement ps = con.prepareStatement("SELECT * FROM Users WHERE UserName = (?) AND Password=(?)");
		ps.setString(1, un);
		ps.setString(2, pw);
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			Name = rs.getString(1);
			UserName = rs.getString(2);
			Email = rs.getString(4);
			Num = rs.getString(5);
			Gender =  rs.getString(6);	
		} 
		
		Hlbl.setText("Hello "+Name+" !");
		namef.setText(Name);
		unf.setText(UserName);
		mailf.setText(Email);
		numf.setText(Num);
		genderf.setText(Gender);
		
      
	}

}
