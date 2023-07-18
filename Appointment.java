

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Appointment extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Appointment frame = new Appointment();
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
	public Appointment() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setBounds(100, 100, 834, 447);
		setSize(1920,1080);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 153, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Get Your Appointment");
		lblNewLabel.setFont(new Font("Script MT Bold", Font.BOLD | Font.ITALIC, 39));
		lblNewLabel.setBounds(530, 207, 413, 85);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				generalmed lg= new generalmed();
				lg.setVisible(true);
			}
		});
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\91964\\eclipse-workspace\\Swing\\src\\image\\generalmedicine (1).jpg"));
		btnNewButton.setBounds(106, 333, 115, 105);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				cardiology lg= new cardiology();
				lg.setVisible(true);
			}
		});
		btnNewButton_1.setIcon(new ImageIcon("C:\\Users\\91964\\eclipse-workspace\\Swing\\src\\image\\cardiologie (1).jpg"));
		btnNewButton_1.setBounds(617, 333, 115, 105);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				orthopedics lg= new orthopedics();
				lg.setVisible(true);
			}
		});
		btnNewButton_2.setIcon(new ImageIcon("C:\\Users\\91964\\eclipse-workspace\\Swing\\src\\image\\orthopedic (1).jpg"));
		btnNewButton_2.setBounds(1090, 333, 115, 105);
		contentPane.add(btnNewButton_2);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(Appointment.class.getResource("/image/Hospital (3).jpg")));
		lblNewLabel_1.setBounds(0, 0, 1540, 214);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton_3 = new JButton("");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				neurology lg= new neurology();
				lg.setVisible(true);
			}
		});
		btnNewButton_3.setIcon(new ImageIcon("C:\\Users\\91964\\eclipse-workspace\\Swing\\src\\image\\neurology (1).jpg"));
		btnNewButton_3.setBounds(106, 573, 115, 105);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				radiology lg= new radiology();
				lg.setVisible(true);
			}
		});
		btnNewButton_4.setIcon(new ImageIcon("C:\\Users\\91964\\eclipse-workspace\\Swing\\src\\image\\radiology (1).jpg"));
		btnNewButton_4.setBounds(617, 573, 115, 105);
		contentPane.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				virology lg= new virology();
				lg.setVisible(true);
			}
		});
		btnNewButton_5.setIcon(new ImageIcon("C:\\Users\\91964\\eclipse-workspace\\Swing\\src\\image\\virology (1).jpg"));
		btnNewButton_5.setBounds(1090, 573, 115, 105);
		contentPane.add(btnNewButton_5);
		
		JLabel lblNewLabel_2 = new JLabel("GENERAL");
		lblNewLabel_2.setFont(new Font("Cambria", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(231, 333, 146, 28);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("CARDIOLOGY");
		lblNewLabel_3.setFont(new Font("Cambria", Font.PLAIN, 20));
		lblNewLabel_3.setBounds(752, 333, 163, 28);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("ORTHOPEDICS");
		lblNewLabel_4.setFont(new Font("Cambria", Font.PLAIN, 20));
		lblNewLabel_4.setBounds(1215, 333, 197, 28);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("NEUROLOGY");
		lblNewLabel_5.setFont(new Font("Cambria", Font.PLAIN, 20));
		lblNewLabel_5.setBounds(231, 574, 146, 28);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("RADIOLOGY");
		lblNewLabel_6.setFont(new Font("Cambria", Font.PLAIN, 20));
		lblNewLabel_6.setBounds(742, 574, 173, 28);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("VIROLOGY");
		lblNewLabel_7.setFont(new Font("Cambria", Font.PLAIN, 20));
		lblNewLabel_7.setBounds(1215, 573, 197, 29);
		contentPane.add(lblNewLabel_7);
	}
}
