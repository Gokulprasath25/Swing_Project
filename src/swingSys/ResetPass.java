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

public class ResetPass {

	private JFrame frmForgotPassword;
	private JTextField UN;
	private JPasswordField PW;
	private JPasswordField PW1;

	/**
	 * Launch the application.
	 */
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
	 * Create the application.
	 * @wbp.parser.entryPoint
	 */
	public ResetPass() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmForgotPassword = new JFrame();
		frmForgotPassword.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Administrator\\Downloads\\password-reset-icon.png"));
		frmForgotPassword.setTitle("Forgot Password");
		frmForgotPassword.setBounds(100, 100, 550, 400);
		frmForgotPassword.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmForgotPassword.getContentPane().setLayout(null);
		frmForgotPassword.setVisible(true);
		
		JLabel Hlbl = new JLabel("Reset Password");
		Hlbl.setFont(new Font("Tahoma", Font.BOLD, 18));
		Hlbl.setBounds(171, 42, 151, 14);
		frmForgotPassword.getContentPane().add(Hlbl);
		
		JLabel UNlbl = new JLabel("User Name");
		UNlbl.setFont(new Font("Tahoma", Font.PLAIN, 14));
		UNlbl.setBounds(93, 111, 82, 14);
		frmForgotPassword.getContentPane().add(UNlbl);
		
		JLabel PWlbl = new JLabel("New Password");
		PWlbl.setFont(new Font("Tahoma", Font.PLAIN, 14));
		PWlbl.setBounds(93, 160, 103, 14);
		frmForgotPassword.getContentPane().add(PWlbl);
		
		JLabel PW1lbl = new JLabel("Confirm Password");
		PW1lbl.setFont(new Font("Tahoma", Font.PLAIN, 14));
		PW1lbl.setBounds(93, 205, 120, 14);
		frmForgotPassword.getContentPane().add(PW1lbl);
		
		UN = new JTextField();
		UN.setBounds(236, 110, 151, 20);
		frmForgotPassword.getContentPane().add(UN);
		UN.setColumns(10);
		
		PW = new JPasswordField();
		PW.setBounds(236, 159, 151, 20);
		frmForgotPassword.getContentPane().add(PW);
		
		PW1 = new JPasswordField();
		PW1.setBounds(236, 204, 151, 20);
		frmForgotPassword.getContentPane().add(PW1);
		
		JButton Submitbtn = new JButton("SUBMIT");
		Submitbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String un = UN.getText();
				@SuppressWarnings("deprecation")
				String pw = PW.getText();
				@SuppressWarnings("deprecation")
				String pw1 = PW1.getText();
				 
				try {
					//Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Gokul","root","Root@25");
					 PreparedStatement ps = con.prepareStatement("SELECT * FROM Users WHERE Username=(?)");
					 ps.setString(1, un);
					 ResultSet rs = ps.executeQuery();
					 if(rs.next())
					 {
					   if(pw.equals(pw1)) {
						   PreparedStatement ps1 = con.prepareStatement("UPDATE Users SET Password=(?) WHERE UserName=(?)");
							ps1.setString(1, pw);
							ps1.setString(2, un);
							int i = ps1.executeUpdate();
							if(i>0)
							{
							 JOptionPane.showMessageDialog(Submitbtn,"Password Changed Successfully!","Success!",JOptionPane.INFORMATION_MESSAGE);
							}
						   
					   }else {
					     JOptionPane.showMessageDialog(Submitbtn,"Passwords Don't Match!","Error!",JOptionPane.ERROR_MESSAGE);   
					   }
					 }else {
						 JOptionPane.showMessageDialog(Submitbtn,"User name doesn't Exist!","Error!",JOptionPane.ERROR_MESSAGE);
					 }
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		Submitbtn.setFont(new Font("Tahoma", Font.BOLD, 12));
		Submitbtn.setBounds(203, 278, 90, 29);
		frmForgotPassword.getContentPane().add(Submitbtn);
	}

}
