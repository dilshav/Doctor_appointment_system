import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import com.toedter.calendar.JDateChooser;
import javax.swing.JFormattedTextField;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class details extends JFrame {

	private JPanel contentPane;
	private JTextField textdoc;
	private JTextField textpat;
	private JTextField texttime;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					details frame = new details();
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
	public details() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 643, 466);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 51, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 153, 102));
		panel.setBounds(0, 68, 629, 361);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(340, 49, 185, 34);
		panel.add(dateChooser);
		
		JLabel lblNewLabel_1 = new JLabel("Date");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblNewLabel_1.setBounds(123, 49, 138, 34);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Time");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblNewLabel_2.setBounds(123, 111, 138, 34);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Enter Doctor id");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblNewLabel_3.setBounds(123, 165, 138, 34);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Password");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblNewLabel_4.setBounds(123, 219, 138, 34);
		panel.add(lblNewLabel_4);
		
		textdoc = new JTextField();
		textdoc.setBounds(340, 165, 185, 34);
		panel.add(textdoc);
		textdoc.setColumns(10);
		
		textpat = new JTextField();
		textpat.setBounds(340, 219, 185, 34);
		panel.add(textpat);
		textpat.setColumns(10);
		
		JButton btnNewButton = new JButton("SUBMIT");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL","hr","mca");
					Statement st = con.createStatement();
					ResultSet rs= st.executeQuery("select MAX(appointment_id) from appointment");
					rs.next();
					int id= Integer.parseInt(rs.getString("MAX(appointment_id)"));
					id=id+1;
					String dte= dateChooser.getDate().toString().substring(2,10);
					String time=texttime.getText();
					String docs=textdoc.getText();
					String patnt=textpat.getText();
					String stat="done";
					
					String qc= "insert into appointment values('"+id+"','"+dte+"','"+time+"','"+patnt+"','"+docs+"','"+stat+"')";
					st.executeUpdate(qc);
					
					
					/*PreparedStatement pst= con.prepareStatement("select MAX(prescript_id) from prescription");
					ResultSet rrs= pst.executeQuery();
					rrs.next();
					int did= Integer.parseInt(rs.getString("MAX(prescript_id)"));
					did=did+1;
					String m= "null";
					String d= "null";
					String f= "null";
					String tc="insert into prescription values('"+did+"','"+id+"','"+dte+"','"+m+"','"+d+"','"+f+"')";
					st.executeUpdate(tc);*/
					JOptionPane.showMessageDialog(null,"Appointment Booked");
					setVisible(false);
					}catch(Exception e1) {System.out.println(e1);}
			}
			
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setBounds(248, 277, 126, 45);
		panel.add(btnNewButton);
		
		texttime = new JTextField();
		texttime.setBounds(340, 112, 185, 33);
		panel.add(texttime);
		texttime.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Enter Details....");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBackground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Cambria", Font.ITALIC, 31));
		lblNewLabel.setBounds(208, 10, 297, 48);
		contentPane.add(lblNewLabel);
	}
}
