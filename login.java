import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Window;

import javax.swing.JButton;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class login extends JFrame {
	private JTextField txtuser;
	private JTextField txtname;
	private JTextField textname;
	private JTextField textpass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login frame = new login();
					frame.setVisible(true);
					frame.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public login() {
		getContentPane().setBackground(new Color(0, 153, 153));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 919, 612);
		getContentPane().setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 45, 1030, 576);
		getContentPane().add(tabbedPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(102, 204, 204));
		tabbedPane.addTab("Patient", null, panel, null);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Username:");
		lblNewLabel.setFont(new Font("Cambria", Font.BOLD, 18));
		lblNewLabel.setBounds(302, 150, 124, 26);
		panel.add(lblNewLabel);
		
		txtuser = new JTextField();
		txtuser.setBounds(436, 150, 211, 34);
		panel.add(txtuser);
		txtuser.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Password:");
		lblNewLabel_1.setFont(new Font("Cambria", Font.BOLD, 18));
		lblNewLabel_1.setBounds(302, 245, 124, 26);
		panel.add(lblNewLabel_1);
		
		txtname = new JTextField();
		txtname.setBounds(436, 245, 211, 34);
		panel.add(txtname);
		txtname.setColumns(10);
		
		JButton btnNewButton = new JButton("LOGIN");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL","hr","mca");
					PreparedStatement pst= con.prepareStatement("select patient_id,pt_name from patient where patient_id=? and pt_name=?");
					pst.setString(1,txtname.getText());
					
					pst.setString(2,txtuser.getText());
					ResultSet rs = pst.executeQuery();
					//while(rs.next()) {
					if(rs.next()) {
						
						JOptionPane.showMessageDialog(null,"User successfully logged In");
						System.out.println("success");
						setVisible(false);
						Appointment lg= new Appointment();
						lg.setVisible(true);
						
					}
					else {
						JOptionPane.showMessageDialog(null,"Invalid");
					}
				//	}
					rs.close();
					pst.close();
					}catch(Exception e1) {System.out.println(e1);}
			}
		});
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setBackground(new Color(70, 130, 180));
		btnNewButton.setFont(new Font("Cambria", Font.BOLD, 19));
		btnNewButton.setBounds(382, 346, 106, 34);
		panel.add(btnNewButton);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(51, 204, 204));
		tabbedPane.addTab("Doctor", null, panel_1, null);
		panel_1.setLayout(null);
		
		textname = new JTextField();
		textname.setBounds(425, 154, 215, 34);
		panel_1.add(textname);
		textname.setColumns(10);
		
		textpass = new JTextField();
		textpass.setBounds(425, 236, 215, 34);
		panel_1.add(textpass);
		textpass.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Username:");
		lblNewLabel_2.setFont(new Font("Cambria", Font.BOLD, 18));
		lblNewLabel_2.setBounds(305, 150, 110, 34);
		panel_1.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Password:");
		lblNewLabel_3.setFont(new Font("Cambria", Font.BOLD, 18));
		lblNewLabel_3.setBounds(299, 232, 116, 34);
		panel_1.add(lblNewLabel_3);
		
		JButton btnNewButton_1 = new JButton("LOGIN");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL","hr","mca");
					PreparedStatement pst= con.prepareStatement("select doctor_id,d_name from doctor where doctor_id=? and d_name=?");
					pst.setString(1,textpass.getText());
					
					pst.setString(2,textname.getText());
					ResultSet rs = pst.executeQuery();
					//while(rs.next()) {
					if(rs.next()) {
						
						JOptionPane.showMessageDialog(null,"User successfully logged In");
						System.out.println("success");
						setVisible(false);
						prescribe lg= new prescribe();
						lg.setVisible(true);
						
					}
					else {
						JOptionPane.showMessageDialog(null,"Invalid");
					}
				//	}
					rs.close();
					pst.close();
					}catch(Exception e1) {System.out.println(e1);}
			}
		});
		btnNewButton_1.setBackground(new Color(102, 153, 204));
		btnNewButton_1.setFont(new Font("Cambria", Font.BOLD, 19));
		btnNewButton_1.setBounds(376, 347, 104, 34);
		panel_1.add(btnNewButton_1);
		
		JLabel lblNewLabel_4 = new JLabel("       WELCOME.........");
		lblNewLabel_4.setFont(new Font("Rage Italic", Font.BOLD | Font.ITALIC, 29));
		lblNewLabel_4.setBounds(281, 10, 227, 47);
		getContentPane().add(lblNewLabel_4);
	}
}
