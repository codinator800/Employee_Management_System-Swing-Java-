import java.awt.BorderLayout;
import java.sql.*;
import javax.swing.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Profiles extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Profiles frame = new Profiles();
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
	private JButton btnBack;
	private JButton btnLogOut;
	public Profiles() {
		con = sqliteconnection.dbConnector();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 765, 548);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnClickHereTo = new JButton("Click here to Display Profiles");
		btnClickHereTo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String query = "select * from EmployeeInfo";
					PreparedStatement pat = con.prepareStatement(query);
					ResultSet rs = pat.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
					
					
					
				}
				catch(Exception e) {
					e.printStackTrace();
				}
			}
		});
		btnClickHereTo.setBounds(12, 12, 347, 37);
		contentPane.add(btnClickHereTo);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(27, 115, 704, 274);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				StudentInfo si=new StudentInfo();
				si.setVisible(true);
			}
		});
		btnBack.setBounds(549, 429, 114, 25);
		contentPane.add(btnBack);
		
		btnLogOut = new JButton("Log out");
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				login as = new login();
				as.frame.setVisible(true);
			}
		});
		btnLogOut.setBounds(12, 460, 114, 25);
		contentPane.add(btnLogOut);
	}
}
