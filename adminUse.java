

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import net.proteanit.sql.DbUtils;

import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class adminUse extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					adminUse frame = new adminUse();
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
	public adminUse() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 916, 639);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(102, 102, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(102, 204, 255));
		panel.setBounds(0, 50, 902, 552);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(47, 104, 756, 199);
		panel.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"New column", "Appointment Id", "Date", "Medicine", "Dosage", "Frequency"
			}
		));
		
		JButton btnNewButton = new JButton("Show Details");
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
		btnNewButton.setFont(new Font("Cambria", Font.PLAIN, 16));
		btnNewButton.setBounds(655, 352, 130, 56);
		panel.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Patient Details");
		lblNewLabel.setFont(new Font("Cambria", Font.PLAIN, 32));
		lblNewLabel.setBounds(326, 0, 247, 52);
		contentPane.add(lblNewLabel);
	}
}
