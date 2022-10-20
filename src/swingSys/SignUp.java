package swingSys;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import javax.swing.JRadioButton;

public class SignUp {

	private JFrame SignUpfrm;
	private JTextField FN;
	private JTextField UN;
	private JPasswordField PW;
	private JPasswordField PW1;
	private JTextField MAIL;
	private JTextField NUM;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SignUp window = new SignUp();
					window.SignUpfrm.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public SignUp() {
		initialize();
	}
	private void initialize() {
		SignUpfrm = new JFrame();
		SignUpfrm.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Administrator\\Downloads\\signup-icon.png"));
		SignUpfrm.setTitle("Sign Up");
		SignUpfrm.setBounds(100, 100, 710, 435);
		SignUpfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		SignUpfrm.getContentPane().setLayout(null);
		
		
		JLabel FNlbl = new JLabel("Full Name");
		FNlbl.setFont(new Font("Tahoma", Font.PLAIN, 14));
		FNlbl.setBounds(33, 109, 73, 14);
		SignUpfrm.getContentPane().add(FNlbl);
		
		JLabel UNlbl = new JLabel("User Name");
		UNlbl.setFont(new Font("Tahoma", Font.PLAIN, 14));
		UNlbl.setBounds(33, 151, 73, 14);
		SignUpfrm.getContentPane().add(UNlbl);
		
		JLabel PWlbl = new JLabel("New Password");
		PWlbl.setFont(new Font("Tahoma", Font.PLAIN, 14));
		PWlbl.setBounds(33, 188, 102, 14);
		SignUpfrm.getContentPane().add(PWlbl);
		
		JLabel PW1lbl = new JLabel("Confirm Password");
		PW1lbl.setFont(new Font("Tahoma", Font.PLAIN, 14));
		PW1lbl.setBounds(33, 229, 124, 14);
		SignUpfrm.getContentPane().add(PW1lbl);
		
		JLabel Hlbl = new JLabel("New User Registration");
		Hlbl.setFont(new Font("Tahoma", Font.BOLD, 18));
		Hlbl.setBounds(259, 36, 210, 22);
		SignUpfrm.getContentPane().add(Hlbl);
		
		FN = new JTextField();
		FN.setBounds(165, 108, 160, 20);
		SignUpfrm.getContentPane().add(FN);
		FN.setColumns(10);
		
		UN = new JTextField();
		UN.setBounds(165, 150, 160, 20);
		SignUpfrm.getContentPane().add(UN);
		UN.setColumns(10);
		
		PW = new JPasswordField();
		PW.setBounds(165, 187, 160, 20);
		SignUpfrm.getContentPane().add(PW);
		
		PW1 = new JPasswordField();
		PW1.setBounds(165, 228, 160, 20);
		SignUpfrm.getContentPane().add(PW1);
		
		
		JLabel Maillbl = new JLabel("E-Mail");
		Maillbl.setFont(new Font("Tahoma", Font.PLAIN, 14));
		Maillbl.setBounds(351, 111, 46, 14);
		SignUpfrm.getContentPane().add(Maillbl);
		
		JLabel Nolbl = new JLabel("Mobile No");
		Nolbl.setFont(new Font("Tahoma", Font.PLAIN, 14));
		Nolbl.setBounds(351, 153, 73, 14);
		SignUpfrm.getContentPane().add(Nolbl);
		
		JLabel Genderlbl = new JLabel("Gender");
		Genderlbl.setFont(new Font("Tahoma", Font.PLAIN, 14));
		Genderlbl.setBounds(351, 190, 73, 14);
		SignUpfrm.getContentPane().add(Genderlbl);
		
		MAIL = new JTextField();
		MAIL.setBounds(446, 108, 190, 20);
		SignUpfrm.getContentPane().add(MAIL);
		MAIL.setColumns(10);
		
		NUM = new JTextField();
		NUM.setText("");
		NUM.setBounds(446, 150, 190, 20);
		SignUpfrm.getContentPane().add(NUM);
		NUM.setColumns(10);
		
		JRadioButton FEMALE = new JRadioButton("Female");
		FEMALE.setBounds(446, 186, 109, 23);
		SignUpfrm.getContentPane().add(FEMALE);
		
		JRadioButton MALE = new JRadioButton("Male");
		MALE.setBounds(446, 212, 109, 23);
		SignUpfrm.getContentPane().add(MALE);
		
		JRadioButton OTHERS = new JRadioButton("Others");
		OTHERS.setBounds(446, 240, 109, 23);
		SignUpfrm.getContentPane().add(OTHERS);
		
		JButton Signupbtn = new JButton("SIGN UP");
		Signupbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String Name = FN.getText();
				String un = UN.getText();
				@SuppressWarnings("deprecation")
				String pw = PW.getText();
				@SuppressWarnings("deprecation")
				String pw1 = PW1.getText();
				String Mail = MAIL.getText();
				String Num = NUM.getText();
				String Gender = null;
				if(FEMALE.isSelected()) {
				 Gender = "Female";
				}if(MALE.isSelected()) {
				 Gender = "Male";	
				}if(OTHERS.isSelected()) {
				 Gender = "others";
				}
			if(pw.equals(pw1)) {
				try {
					//Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Gokul","root","Root@25");
					PreparedStatement ps = con.prepareStatement("SELECT * FROM Users WHERE UserName = (?)");
					ps.setString(1, un);
					ResultSet rs = ps.executeQuery();
					  if(rs.next())
					  {
				 JOptionPane.showMessageDialog(Signupbtn,"User Name Already exist!","Error!",JOptionPane.ERROR_MESSAGE);
					  }else {
				    PreparedStatement ps1 = con.prepareStatement("INSERT INTO Users (Name,UserName,Password,Email,Mobile, Gender) VALUES (?,?,?,?,?,?)");
					ps1.setString(1, Name);
					ps1.setString(2, un);
					ps1.setString(3, pw);
					ps1.setString(4, Mail);
					ps1.setString(5, Num);
					ps1.setString(6, Gender);
					int i = ps1.executeUpdate();
					if(i>0)
					{
					 JOptionPane.showMessageDialog(Signupbtn,"Your Account Has been successfully Created! "+Name+".","Success!",JOptionPane.INFORMATION_MESSAGE);
					}
				} }catch (Exception e1) {
					e1.printStackTrace();
				}
			}else {
				JOptionPane.showMessageDialog(Signupbtn,"Passwords Don't Match","Error!",JOptionPane.ERROR_MESSAGE);
			}
		  }
		});
		Signupbtn.setFont(new Font("Tahoma", Font.BOLD, 12));
		Signupbtn.setBounds(186, 315, 90, 30);
		SignUpfrm.getContentPane().add(Signupbtn);
		
		JButton Loginbtn = new JButton("LOG IN ");

		Loginbtn.setFont(new Font("Tahoma", Font.BOLD, 12));
		Loginbtn.setBounds(379, 315, 90, 30);
		SignUpfrm.getContentPane().add(Loginbtn);
		
		Loginbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new LogIn();
			}
		});
		
	}
}
