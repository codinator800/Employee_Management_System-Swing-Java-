import java.awt.EventQueue;
import java.awt.Font;
import java.sql.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class login {

	public JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login window = new login();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	Connection conn = null;
	private JTextField textFieldUN;
	private JPasswordField passwordField;
	public login() {
		initialize();
		conn = sqliteconnection.dbConnector();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 800, 475);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblRegistrationPortal = new JLabel("ADMIN LOGIN");
		lblRegistrationPortal.setFont(new Font("Dialog", Font.BOLD, 26));
		lblRegistrationPortal.setBounds(275, 12, 412, 65);
		frame.getContentPane().add(lblRegistrationPortal);
		
		JLabel lblAdminId = new JLabel("Admin ID");
		lblAdminId.setFont(new Font("Dialog", Font.BOLD, 16));
		lblAdminId.setBounds(107, 106, 119, 31);
		frame.getContentPane().add(lblAdminId);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Dialog", Font.BOLD, 16));
		lblPassword.setBounds(105, 159, 109, 47);
		frame.getContentPane().add(lblPassword);
		
		textField = new JTextField();
		textField.setBounds(267, 106, 318, 31);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnLogin = new JButton("LogIn");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					
					String query = "Select * from admintable where AdminID = ? and Password = ? ";
					
					PreparedStatement pat = conn.prepareStatement(query);
					pat.setString(1, textField.getText());
					pat.setString(2, passwordField.getText());
					ResultSet rs = pat.executeQuery();
					int count=0;
					while(rs.next()) {
						count++;
					}
					if(count==1)
					{
						//JOptionPane.showMessageDialog(null,"Successful");
						frame.setVisible(false);
						StudentInfo studinfo = new StudentInfo();
						studinfo.setVisible(true);
						
					}
					else {
						JOptionPane.showMessageDialog(null,"Incorrect AdminID or Password");
					}
						
					
				rs.close();
				pat.close();
				}
				catch(Exception e) {
					JOptionPane.showMessageDialog(null,e);
			}
			}
			});
		btnLogin.setBounds(357, 245, 114, 25);
		frame.getContentPane().add(btnLogin);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(267, 174, 318, 32);
		frame.getContentPane().add(passwordField);
	}
}
