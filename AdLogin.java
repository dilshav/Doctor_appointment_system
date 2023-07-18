import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class AdLogin extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdLogin frame = new AdLogin();
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
	public AdLogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 865, 591);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(102, 102, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(153, 204, 255));
		panel.setBounds(0, 58, 851, 496);
		contentPane.add(panel);
		panel.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(427, 121, 209, 36);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(427, 218, 209, 36);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("UserName:");
		lblNewLabel_1.setFont(new Font("Cambria", Font.BOLD, 18));
		lblNewLabel_1.setBounds(281, 121, 122, 36);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Password:");
		lblNewLabel_2.setFont(new Font("Cambria", Font.BOLD, 18));
		lblNewLabel_2.setBounds(281, 218, 122, 36);
		panel.add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("LOGIN");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL","hr","mca");
					PreparedStatement pst= con.prepareStatement("select * from admins where username=? and password=?");
					pst.setString(1,textField.getText());
					
					pst.setString(2,textField_1.getText());
					ResultSet rs = pst.executeQuery();
					//while(rs.next()) {
					if(rs.next()) {
						
						JOptionPane.showMessageDialog(null,"User successfully logged In");
						System.out.println("success");
						setVisible(false);
						adminUse lg= new adminUse();
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
		btnNewButton.setFont(new Font("Cambria", Font.BOLD, 19));
		btnNewButton.setBounds(345, 313, 111, 36);
		panel.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("      WELCOME...........");
		lblNewLabel.setFont(new Font("Script MT Bold", Font.ITALIC, 30));
		lblNewLabel.setBounds(270, 10, 287, 38);
		contentPane.add(lblNewLabel);
		
		
	}
}
