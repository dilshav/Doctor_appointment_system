import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import net.proteanit.sql.DbUtils;

import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.*;
import javax.swing.JTextField;

public class prescribe extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					prescribe frame = new prescribe();
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
	public prescribe() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1024, 615);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(51, 153, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(49, 91, 815, 248);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Appointment id", "Date", "Medicine", "Dosage", "Frequency"
			}
		));
		
		JButton btnNewButton = new JButton("Show Details");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL","hr","mca");
					Statement stmt=con.createStatement();
					ResultSet rs = stmt.executeQuery("select * from prescription");
					//ResultSetMetaData rsmd= rs.getMetaData();
					//DefaultTableModel model= (DefaultTableModel)SQLData.getModel();
					
					table.setModel(DbUtils.resultSetToTableModel(rs));
					
					//JOptionPane.showMessageDialog(null," inserted succesfully");
					//new Feedback().setVisible(true);
					//dispose();
				}catch(Exception e1)
				{
					System.out.println(e1);
				}
			}
		});
		btnNewButton.setBounds(74, 349, 138, 42);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("       Prescription For Patients");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 33));
		lblNewLabel.setBounds(169, 23, 596, 42);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton_1 = new JButton("Add Prescription");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL","hr","mca");
				//	Statement st = con.createStatement();
					String med=textField.getText();
					String dos=textField_1.getText();
					String fre=textField_2.getText();
					int app=Integer.parseInt(textField_3.getText());
					//String qc= "update prescription set medicine_name='"+med+"',dosage='"+dos+"',frequency='"+fre+"' where appointment_id='"+app+"'";
					//st.executeUpdate(qc);
					JOptionPane.showMessageDialog(null,"successful");
					PreparedStatement psd= con.prepareStatement("update prescription set medication_name=?,dosage=?,frequency=? where appointment_id=?");
					psd.setString(1,med);
					psd.setString(2,dos);
					psd.setString(3,fre);
					psd.setInt(4,app);
					psd.executeQuery();
					//		psd.setString(ABORT, getName())
				}catch(Exception e4) {}
				
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_1.setBounds(765, 451, 152, 42);
		contentPane.add(btnNewButton_1);
		
		textField = new JTextField();
		textField.setBounds(132, 434, 152, 28);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Medicine");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(49, 424, 73, 42);
		contentPane.add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(132, 507, 152, 28);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Dosage");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(49, 500, 73, 36);
		contentPane.add(lblNewLabel_2);
		
		textField_2 = new JTextField();
		textField_2.setBounds(467, 427, 180, 42);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Frequency");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(368, 425, 79, 41);
		contentPane.add(lblNewLabel_3);
		
		textField_3 = new JTextField();
		textField_3.setBounds(470, 511, 177, 36);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("App Id");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_4.setBounds(353, 514, 94, 33);
		contentPane.add(lblNewLabel_4);
	}
}
