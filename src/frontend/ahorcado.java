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
	private JTextField inputAdivinarLetra;

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
		
		Component margenInferiorIzquierdo = Box.createHorizontalGlue();
		margenInferiorIzquierdo.setEnabled(false);
		margenInferiorIzquierdo.setFont(new Font("Dialog", Font.PLAIN, 16));
		panel.add(margenInferiorIzquierdo);
		
		JPanel panelCronometro = new JPanel();
		panel.add(panelCronometro);
		
		JLabel etiquetaTextoTiempoRestante = new JLabel("Tiempo restante:");
		panelCronometro.add(etiquetaTextoTiempoRestante);
		etiquetaTextoTiempoRestante.setHorizontalAlignment(SwingConstants.TRAILING);
		etiquetaTextoTiempoRestante.setFont(new Font("Dialog", Font.PLAIN, 10));
		
		JLabel etiquetaCronometroTiempoRestante = new JLabel("15:00");
		panelCronometro.add(etiquetaCronometroTiempoRestante);
		etiquetaCronometroTiempoRestante.setFont(new Font("Dialog", Font.BOLD, 14));
		etiquetaCronometroTiempoRestante.setHorizontalAlignment(SwingConstants.CENTER);
		
		Box verticalBox = Box.createVerticalBox();
		panelCronometro.add(verticalBox);
		
		Component margenInferiorCentralIzquierdo = Box.createHorizontalGlue();
		panel.add(margenInferiorCentralIzquierdo);
		
		inputAdivinarLetra = new JTextField();
		inputAdivinarLetra.setHorizontalAlignment(SwingConstants.CENTER);
		inputAdivinarLetra.setFont(new Font("Dialog", Font.PLAIN, 36));
		panel.add(inputAdivinarLetra);
		inputAdivinarLetra.setColumns(10);
		
		Component margenInferiorCentralDerecho = Box.createHorizontalGlue();
		panel.add(margenInferiorCentralDerecho);
		
		JButton botonRendirse = new JButton("Rendirse");
		panel.add(botonRendirse);
		
		Component margenInferiorDerecho = Box.createHorizontalGlue();
		panel.add(margenInferiorDerecho);
	}

}