package frontend;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.Box;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Component;
import java.awt.GridLayout;

public class ahorcado extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ahorcado frame = new ahorcado();
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
	public ahorcado() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.SOUTH);
		panel.setLayout(new GridLayout(0, 8, 0, 0));
		
		Component horizontalGlue = Box.createHorizontalGlue();
		horizontalGlue.setEnabled(false);
		horizontalGlue.setFont(new Font("Dialog", Font.PLAIN, 16));
		panel.add(horizontalGlue);
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1);
		
		JLabel lblNewLabel_1 = new JLabel("Tiempo restante:");
		panel_1.add(lblNewLabel_1);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_1.setFont(new Font("Dialog", Font.PLAIN, 10));
		
		JLabel lblNewLabel = new JLabel("15:00");
		panel_1.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 14));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		Box verticalBox = Box.createVerticalBox();
		panel_1.add(verticalBox);
		
		Component horizontalGlue_1 = Box.createHorizontalGlue();
		panel.add(horizontalGlue_1);
		
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setFont(new Font("Dialog", Font.PLAIN, 36));
		panel.add(textField);
		textField.setColumns(10);
		
		Component horizontalGlue_2 = Box.createHorizontalGlue();
		panel.add(horizontalGlue_2);
		
		JButton btnNewButton = new JButton("Rendirse");
		panel.add(btnNewButton);
		
		Component horizontalGlue_3 = Box.createHorizontalGlue();
		panel.add(horizontalGlue_3);
	}

}
