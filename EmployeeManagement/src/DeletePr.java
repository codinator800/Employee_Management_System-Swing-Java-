import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.border.EmptyBorder;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;
import javax.swing.*;
public class DeletePr extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DeletePr frame = new DeletePr();
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
	Connection con = null;
	public DeletePr() {
		con = sqliteconnection.dbConnector();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblEnterEmployeeId = new JLabel("Enter Employee ID");
		lblEnterEmployeeId.setFont(new Font("Dialog", Font.BOLD, 18));
		lblEnterEmployeeId.setBounds(12, 51, 216, 33);
		contentPane.add(lblEnterEmployeeId);
		
		textField = new JTextField();
		textField.setBounds(246, 59, 179, 33);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				StudentInfo ss=new StudentInfo();
				ss.setVisible(true);
			}
		});
		btnBack.setBounds(296, 163, 114, 25);
		contentPane.add(btnBack);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String query2 = "Select * from EmployeeInfo where ID = ?";
					PreparedStatement pat = con.prepareStatement(query2);
					pat.setString(1, textField.getText());
					ResultSet rs = pat.executeQuery();
					int count=0;
					while(rs.next()) {
						count++;
					}
					if(count==1)
					{
						//JOptionPane.showMessageDialog(null,"Successful");
						String query = "delete from EmployeeInfo where ID = '"+textField.getText()+"' ";
						PreparedStatement pat2 = con.prepareStatement(query);
						pat2.execute();
						JOptionPane.showMessageDialog(null, "Data Deleted");
						textField.setText("");
						pat2.close();
					}
					else {
						JOptionPane.showMessageDialog(null,"Incorrect Employee ID");
						textField.setText("");
					}
						
				
					pat.close();
				}
				catch(Exception e) {
					e.printStackTrace();
					
				}
			}
		});
		btnDelete.setBounds(141, 163, 114, 25);
		contentPane.add(btnDelete);
	}

}
