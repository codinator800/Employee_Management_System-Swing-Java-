import java.awt.BorderLayout;

import java.sql.*;
import javax.swing.*;
import java.awt.EventQueue;

import javax.swing.border.EmptyBorder;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class AddEmployee extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldID;
	private JTextField textFieldName;
	private JTextField textFieldDep;
	private JTextField textFieldCon;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddEmployee frame = new AddEmployee();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	/**
	 * Create the frame.
	 */
	Connection conn = null;
	public AddEmployee() {
		conn = sqliteconnection.dbConnector();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 749, 544);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAddEmployee = new JLabel("Add Employee");
		lblAddEmployee.setFont(new Font("Dialog", Font.BOLD, 24));
		lblAddEmployee.setBounds(37, 12, 232, 43);
		contentPane.add(lblAddEmployee);
		
		JLabel lblName = new JLabel("ID");
		lblName.setFont(new Font("Dialog", Font.BOLD, 14));
		lblName.setBounds(37, 65, 106, 25);
		contentPane.add(lblName);
		
		JLabel label = new JLabel("");
		label.setBounds(37, 102, 66, 15);
		contentPane.add(label);
		
		textFieldID = new JTextField();
		textFieldID.setBounds(212, 67, 208, 25);
		contentPane.add(textFieldID);
		textFieldID.setColumns(10);
		
		JLabel lblName_1 = new JLabel("Name");
		lblName_1.setFont(new Font("Dialog", Font.BOLD, 14));
		lblName_1.setBounds(37, 115, 76, 36);
		contentPane.add(lblName_1);
		
		textFieldName = new JTextField();
		textFieldName.setBounds(212, 120, 208, 27);
		contentPane.add(textFieldName);
		textFieldName.setColumns(10);
		
		JLabel lblDepartment = new JLabel("Department");
		lblDepartment.setFont(new Font("Dialog", Font.BOLD, 14));
		lblDepartment.setBounds(37, 175, 106, 25);
		contentPane.add(lblDepartment);
		
		textFieldDep = new JTextField();
		textFieldDep.setBounds(212, 175, 208, 25);
		contentPane.add(textFieldDep);
		textFieldDep.setColumns(10);
		
		JLabel lblContact = new JLabel("Contact");
		lblContact.setFont(new Font("Dialog", Font.BOLD, 14));
		lblContact.setBounds(37, 233, 95, 15);
		contentPane.add(lblContact);
		
		textFieldCon = new JTextField();
		textFieldCon.setBounds(212, 231, 208, 27);
		contentPane.add(textFieldCon);
		textFieldCon.setColumns(10);
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					
					String query = "insert into EmployeeInfo (ID, Name, Department, Contact) values(?,?,?,?)";
					//JOptionPane.showMessageDialog(null, "check");
					PreparedStatement pat = conn.prepareStatement(query);
					
					pat.setString(1, textFieldID.getText());
					pat.setString(2, textFieldName.getText());
					pat.setString(3, textFieldDep.getText());
					pat.setString(4, textFieldCon.getText());
					if (textFieldID.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "field empty");
					}
					else if (textFieldName.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "field empty");
					}
					else if (textFieldDep.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "field empty");
					}
					else if (textFieldCon.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "field empty");
					}
					else {
						
					pat.execute();
					JOptionPane.showMessageDialog(null, "Data Saved");
					textFieldID.setText("");
					textFieldName.setText("");
					textFieldDep.setText("");
					textFieldCon.setText("");
					}
					pat.close();
					
				}
				catch (Exception e) {
					JOptionPane.showMessageDialog(null, "ID already exists or Field empty");
					textFieldID.setText("");
					e.printStackTrace();
				}
				}
		
		});
		btnSave.setBounds(212, 328, 114, 25);
		contentPane.add(btnSave);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				StudentInfo ob=new StudentInfo();
				ob.setVisible(true);
			}
		});
		btnBack.setBounds(425, 328, 114, 25);
		contentPane.add(btnBack);
		
		JButton btnLogOut = new JButton("Log out");
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				login as = new login();
				as.frame.setVisible(true);
			}
		});
		btnLogOut.setBounds(29, 454, 114, 25);
		contentPane.add(btnLogOut);
	}

}
