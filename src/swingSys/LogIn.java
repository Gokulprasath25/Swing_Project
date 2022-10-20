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

public class LogIn {

	private JFrame frmLogin;
	private JTextField UN;
	private JPasswordField PW;
	static  String un;
	static  String pw;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new LogIn();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public LogIn() {
		initialize();
	}

	
	private void initialize() {
		frmLogin = new JFrame();
		frmLogin.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Administrator\\Downloads\\log-in-icon.png"));
		frmLogin.setTitle("LogIn");
		frmLogin.setBounds(100, 100, 550, 400);
		frmLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLogin.getContentPane().setLayout(null);
		frmLogin.setVisible(true);
		
		JLabel Hlbl = new JLabel("User LogIn");
		Hlbl.setFont(new Font("Tahoma", Font.BOLD, 18));
		Hlbl.setBounds(206, 37, 110, 22);
		frmLogin.getContentPane().add(Hlbl);
		
		JLabel UNlbl = new JLabel("User Name");
		UNlbl.setFont(new Font("Tahoma", Font.PLAIN, 14));
		UNlbl.setBounds(109, 110, 81, 14);
		frmLogin.getContentPane().add(UNlbl);
		
		JLabel PWlbl = new JLabel("Password");
		PWlbl.setFont(new Font("Tahoma", Font.PLAIN, 14));
		PWlbl.setBounds(109, 164, 81, 14);
		frmLogin.getContentPane().add(PWlbl);
		
		UN = new JTextField();
		UN.setBounds(217, 109, 150, 20);
		frmLogin.getContentPane().add(UN);
		UN.setColumns(10);
		
		PW = new JPasswordField();
		PW.setBounds(217, 163, 150, 20);
		frmLogin.getContentPane().add(PW);
		
		JButton Loginbtn = new JButton("LOGIN");
		Loginbtn.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				 un = UN.getText();
				 pw = PW.getText();
				 try {
					//Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Gokul","root","Root@25");
					PreparedStatement ps = con.prepareStatement("SELECT * FROM Users WHERE UserName = (?) AND Password=(?)");
					ps.setString(1, un);
					ps.setString(2, pw);
					ResultSet rs = ps.executeQuery();
					if(rs.next())
					{
				       new Welcome();
					}else {
						JOptionPane.showMessageDialog(Loginbtn,"Invalid User Credentials!","Error!",JOptionPane.ERROR_MESSAGE);
					}
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		Loginbtn.setFont(new Font("Tahoma", Font.BOLD, 12));
		Loginbtn.setBounds(114, 257, 90, 30);
		frmLogin.getContentPane().add(Loginbtn);
		
		JButton Resetbtn = new JButton("Forgot password?");
		Resetbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ResetPass();
			}
		});
		Resetbtn.setFont(new Font("Tahoma", Font.BOLD, 12));
		Resetbtn.setBounds(281, 258, 150, 30);
		frmLogin.getContentPane().add(Resetbtn);
	}

}
