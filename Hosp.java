import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTabbedPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Hosp {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Hosp window = new Hosp();
					window.frame.setVisible(true);
					window.frame.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Hosp() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(153, 204, 204));
		frame.getContentPane().setLayout(null);
		
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 61, 921, 585);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\91964\\eclipse-workspace\\Swing\\src\\image\\ncr.jpg"));
		lblNewLabel.setBounds(0, 0, 921, 593);
		//ImageIcon img =new ImageIcon(this.getClass().getResource("/ncr.jpg"));
		//lblNewLabel.setIcon(img);
		panel.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("LOGIN");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				login lg= new login();
				lg.setVisible(true);
			}

			private void setVisible(boolean b) {
				// TODO Auto-generated method stub
				
			}
		});
		btnNewButton.setFont(new Font("Cambria", Font.PLAIN, 14));
		btnNewButton.setBounds(815, 0, 106, 41);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("REGISTER");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				register lg= new register();
				lg.setVisible(true);
			}

			private void setVisible(boolean b) {
				// TODO Auto-generated method stub
				
			}
		});
		btnNewButton_1.setBounds(718, 0, 100, 41);
		frame.getContentPane().add(btnNewButton_1);
		btnNewButton_1.setFont(new Font("Cambria", Font.PLAIN, 14));
		
		JButton btnNewButton_2 = new JButton("ADMIN");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				AdLogin lg= new AdLogin();
				lg.setVisible(true);
			}

			private void setVisible(boolean b) {
				// TODO Auto-generated method stub
				
			}
		});
		btnNewButton_2.setFont(new Font("Cambria", Font.PLAIN, 14));
		btnNewButton_2.setBounds(624, 0, 100, 41);
		frame.getContentPane().add(btnNewButton_2);
		
		JLabel lblNewLabel_1 = new JLabel("JN HOSPITAL    ;)");
		lblNewLabel_1.setFont(new Font("Segoe Script", Font.BOLD | Font.ITALIC, 35));
		lblNewLabel_1.setBounds(0, 0, 385, 65);
		frame.getContentPane().add(lblNewLabel_1);
		frame.setBounds(300, 50, 935, 683);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private void setRezisable(boolean b) {
		// TODO Auto-generated method stub
		
	}
}
