import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.ScrollPaneConstants;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;
import javax.swing.DefaultComboBoxModel;
import com.toedter.calendar.JDateChooser;

public class register extends JFrame {

	private JPanel contentPane;
	private JTextField txtname;
	private JTextField txtuser;
	private JTextField txtemail;
	private JTextField txtphone;
	private JTextField txtadd;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					register frame = new register();
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
	public register() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1920,1080);
		//setReSize(false);
		//setBounds(100, 100, 1050, 724);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(102, 153, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		

		
		JLabel lblNewLabel = new JLabel("Patient Registration Form");
		lblNewLabel.setBounds(757, 24, 441, 63);
		lblNewLabel.setFont(new Font("Monotype Corsiva", Font.BOLD | Font.ITALIC, 36));
		contentPane.add(lblNewLabel);
		
		txtname = new JTextField();
		txtname.setBounds(757, 161, 161, 32);
		contentPane.add(txtname);
		txtname.setColumns(10);
		
		txtuser = new JTextField();
		txtuser.setBounds(1211, 161, 161, 32);
		contentPane.add(txtuser);
		txtuser.setColumns(10);
		
		txtemail = new JTextField();
		txtemail.setBounds(757, 405, 161, 38);
		contentPane.add(txtemail);
		txtemail.setColumns(10);
		
		txtphone = new JTextField();
		txtphone.setBounds(1211, 409, 161, 38);
		contentPane.add(txtphone);
		txtphone.setColumns(10);
		
		txtadd = new JTextField();
		txtadd.setBounds(757, 501, 161, 38);
		contentPane.add(txtadd);
		txtadd.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("NAME");
		lblNewLabel_1.setFont(new Font("Cambria", Font.PLAIN, 17));
		lblNewLabel_1.setBounds(600, 161, 102, 32);
		contentPane.add(lblNewLabel_1);
		
		JComboBox txtgndr = new JComboBox();
		txtgndr.setFont(new Font("Cambria", Font.PLAIN, 16));
		txtgndr.setModel(new DefaultComboBoxModel(new String[] {"male", "female", "transgender"}));
		txtgndr.setBounds(757, 287, 161, 32);
		contentPane.add(txtgndr);
		
		JDateChooser txtdob = new JDateChooser();
		txtdob.setBounds(1211, 287, 161, 38);
		contentPane.add(txtdob);
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL","hr","mca");
					Statement st = con.createStatement();
					String pid=txtuser.getText();
					String pname=txtname.getText();
					String gender= (String)txtgndr.getItemAt(txtgndr.getSelectedIndex());
					String dob= txtdob.getDate().toString().substring(2,10);
					String email=txtemail.getText();
					String phone=txtphone.getText();
					String address=txtadd.getText();
					String qc= "insert into patient values('"+pid+"','"+pname+"','"+gender+"','"+dob+"','"+email+"','"+phone+"','"+address+"')";
					st.executeUpdate(qc);
				
					System.out.println("value inserted");
					JOptionPane.showMessageDialog(null,"User successfully logged In");
					setVisible(false);
					login lg= new login();
					lg.setVisible(true);
					}catch(Exception e1) {System.out.println(e1);}
			}
		});
		btnNewButton.setFont(new Font("Cambria", Font.PLAIN, 18));
		btnNewButton.setBounds(1003, 666, 111, 47);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_2 = new JLabel("GENDER");
		lblNewLabel_2.setFont(new Font("Cambria", Font.PLAIN, 17));
		lblNewLabel_2.setBounds(600, 283, 102, 32);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("EMAIL");
		lblNewLabel_3.setFont(new Font("Cambria", Font.PLAIN, 17));
		lblNewLabel_3.setBounds(600, 401, 102, 38);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("ADDRESS");
		lblNewLabel_4.setFont(new Font("Cambria", Font.PLAIN, 17));
		lblNewLabel_4.setBounds(600, 497, 102, 38);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("PASSWORD");
		lblNewLabel_5.setFont(new Font("Cambria", Font.PLAIN, 17));
		lblNewLabel_5.setBounds(1068, 159, 85, 29);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("DATE OF BIRTH");
		lblNewLabel_6.setFont(new Font("Cambria", Font.PLAIN, 17));
		lblNewLabel_6.setBounds(1068, 287, 130, 32);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("PHONE NUMBER");
		lblNewLabel_7.setFont(new Font("Cambria", Font.PLAIN, 17));
		lblNewLabel_7.setBounds(1068, 405, 130, 38);
		contentPane.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("");
		lblNewLabel_8.setIcon(new ImageIcon("C:\\Users\\91964\\eclipse-workspace\\Swing\\src\\image\\Reg (1).jpg"));
		lblNewLabel_8.setBounds(0, 0, 555, 845);
		contentPane.add(lblNewLabel_8);
		
		
		
		
	}
		}
