import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class StudentInfo extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentInfo frame = new StudentInfo();
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
	public StudentInfo() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 706, 503);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnAddEmployee = new JButton("Add Employee");
		btnAddEmployee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				AddEmployee em= new AddEmployee();
				em.setVisible(true);
				
			}
		});
		btnAddEmployee.setBounds(182, 88, 213, 53);
		contentPane.add(btnAddEmployee);
		
		JButton btnDisplayProfile = new JButton("Display Profile");
		btnDisplayProfile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				Profiles ab=new Profiles();
				ab.setVisible(true);
				
			}
		});
		btnDisplayProfile.setBounds(182, 196, 213, 53);
		contentPane.add(btnDisplayProfile);
		
		JButton btnDeleteProfile = new JButton("Delete Profile");
		btnDeleteProfile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				DeletePr d=new DeletePr();
				d.setVisible(true);
			}
		});
		btnDeleteProfile.setBounds(182, 310, 213, 53);
		contentPane.add(btnDeleteProfile);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				login lo=new login();
				lo.frame.setVisible(true);
			}
		});
		btnBack.setBounds(519, 380, 114, 25);
		contentPane.add(btnBack);
		
		JLabel lblStaffManagement = new JLabel("Staff Management");
		lblStaffManagement.setFont(new Font("Dialog", Font.BOLD, 16));
		lblStaffManagement.setBounds(25, 12, 213, 42);
		contentPane.add(lblStaffManagement);
		
		JButton btnAddAdmin = new JButton("Add Admin");
		btnAddAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				AddAdmin adm = new AddAdmin();
				adm.setVisible(true);
			}
		});
		btnAddAdmin.setBounds(519, 29, 114, 25);
		contentPane.add(btnAddAdmin);
		
		JButton btnLogOut = new JButton("Log out");
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				login as = new login();
				as.frame.setVisible(true);
			}
		});
		btnLogOut.setBounds(27, 416, 114, 25);
		contentPane.add(btnLogOut);
	}
}
