import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class radiology extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					radiology frame = new radiology();
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
	public radiology() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 960, 663);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(153, 204, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(51, 102, 153));
		panel.setBounds(0, 0, 946, 80);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("      RADIOLOGY");
		lblNewLabel.setFont(new Font("MV Boli", Font.BOLD, 31));
		lblNewLabel.setBounds(269, 0, 391, 80);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\91964\\eclipse-workspace\\Swing\\src\\image\\female (1).jpg"));
		lblNewLabel_1.setBounds(75, 174, 140, 128);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\91964\\eclipse-workspace\\Swing\\src\\image\\female (1).jpg"));
		lblNewLabel_2.setBounds(75, 388, 140, 128);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Dr Suhasini Menon");
		lblNewLabel_3.setFont(new Font("Cambria", Font.PLAIN, 21));
		lblNewLabel_3.setBounds(287, 174, 248, 34);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("email- suhasini@gmail.com");
		lblNewLabel_4.setFont(new Font("Cambria", Font.PLAIN, 18));
		lblNewLabel_4.setBounds(287, 206, 248, 34);
		contentPane.add(lblNewLabel_4);
		
		JButton btnNewButton = new JButton("Book Appoinment");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				details dt= new details();
				dt.setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("Cambria", Font.PLAIN, 14));
		btnNewButton.setBounds(654, 200, 149, 52);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_5 = new JLabel("Dr Suleha Beegam");
		lblNewLabel_5.setFont(new Font("Cambria", Font.PLAIN, 21));
		lblNewLabel_5.setBounds(287, 388, 248, 34);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("email- suleha@gmail.com");
		lblNewLabel_6.setFont(new Font("Cambria", Font.PLAIN, 18));
		lblNewLabel_6.setBounds(287, 415, 248, 41);
		contentPane.add(lblNewLabel_6);
		
		JButton btnNewButton_1 = new JButton("Book Appointment");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				details dt= new details();
				dt.setVisible(true);
			}
		});
		btnNewButton_1.setFont(new Font("Cambria", Font.PLAIN, 14));
		btnNewButton_1.setBounds(654, 431, 149, 46);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_7 = new JLabel("ID-suha@123");
		lblNewLabel_7.setFont(new Font("Cambria", Font.PLAIN, 18));
		lblNewLabel_7.setBounds(287, 233, 227, 28);
		contentPane.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("ID-suleha@123");
		lblNewLabel_8.setFont(new Font("Cambria", Font.PLAIN, 18));
		lblNewLabel_8.setBounds(287, 443, 201, 28);
		contentPane.add(lblNewLabel_8);
	}

}
