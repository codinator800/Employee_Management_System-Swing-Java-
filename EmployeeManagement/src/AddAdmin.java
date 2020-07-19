import java.awt.BorderLayout;
import java.sql.*;
import javax.swing.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;

public class AddAdmin extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddAdmin frame = new AddAdmin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	Connection con = null;
	public AddAdmin() {
		con = sqliteconnection.dbConnector();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAddNewAdmin = new JLabel("Add New Admin");
		lblAddNewAdmin.setFont(new Font("Dialog", Font.BOLD, 16));
		lblAddNewAdmin.setBounds(35, 12, 201, 34);
		contentPane.add(lblAddNewAdmin);
		
		JLabel lblNewAdminid = new JLabel("New AdminID");
		lblNewAdminid.setBounds(35, 67, 115, 34);
		contentPane.add(lblNewAdminid);
		
		textField = new JTextField();
		textField.setBounds(184, 75, 168, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(35, 131, 115, 34);
		contentPane.add(lblPassword);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(184, 139, 168, 26);
		contentPane.add(passwordField);
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					
					String query = "insert into admintable (AdminID, Password) values(?,?)";
					//JOptionPane.showMessageDialog(null, "check");
					PreparedStatement pat = con.prepareStatement(query);
					
					pat.setString(1, textField.getText());
					pat.setString(2, passwordField.getText());
					if (textField.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "field empty");
					}
					else if (passwordField.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "field empty");
					}
					else {
						
					
					pat.execute();
					JOptionPane.showMessageDialog(null, "Data Saved");
					textField.setText("");
					passwordField.setText("");
					}
					pat.close();
					
				}
				catch (Exception e) {
					JOptionPane.showMessageDialog(null, "ID already exists or empty Field");
					textField.setText("");
					e.printStackTrace();
				}
			}
		});
		btnSave.setBounds(122, 194, 114, 25);
		contentPane.add(btnSave);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				StudentInfo si = new StudentInfo();
				si.setVisible(true);
			}
		});
		btnBack.setBounds(282, 194, 114, 25);
		contentPane.add(btnBack);
	}
}
