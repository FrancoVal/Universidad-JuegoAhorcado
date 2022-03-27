package frontend;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

import backend.Backend;

public class Frontend {

	private JFrame frameInicial;
	private JFrame frameIdioma;
	private JFrame frameDificultad;
	private JFrame juego;

	Backend backend;

	/**
	 * Launch the application.
	 */

	public Frontend() {
		initialize();
	}

	public void crearVistaInterfaz() {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frontend window = new Frontend();
					window.frameInicial.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private void initialize() {
		panelInicial();

	}

	private JFrame panelInicial() {
		frameInicial = new JFrame();
		frameInicial.setTitle("Ahorcado 2.0");
		frameInicial.setBounds(100, 100, 450, 300);
		frameInicial.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameInicial.getContentPane().setLayout(null);

		JButton botonMusica = new JButton("Musica");
		botonMusica.setBounds(308, 215, 110, 23);
		frameInicial.getContentPane().add(botonMusica);
		botonMusica.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				accionBoton("Musica");
			}
		});

		JButton botonInstrucciones = new JButton("Instrucciones");
		botonInstrucciones.setBounds(28, 215, 110, 23);
		frameInicial.getContentPane().add(botonInstrucciones);
		botonInstrucciones.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				accionBoton("Instrucciones");
			}
		});

		JButton botonInicio = new JButton("Comenzar juego");
		botonInicio.setBounds(161, 215, 110, 23);
		botonInicio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				accionBoton("Comenzar juego");
			}
		});
		frameInicial.getContentPane().add(botonInicio);

		return frameInicial;
	}

	private JFrame panelIdioma() {
		frameIdioma = new JFrame();
		frameIdioma.getContentPane().setLayout(null);
		frameIdioma.setBounds(100, 100, 450, 300);
		frameIdioma.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JButton botonEspañol = new JButton("Español");
		botonEspañol.setBounds(169, 56, 89, 23);
		frameIdioma.getContentPane().add(botonEspañol);
		botonEspañol.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				accionBoton("Español");
			}
		});

		JButton botonIngles = new JButton("Ingles");
		botonIngles.setBounds(169, 90, 89, 23);
		frameIdioma.getContentPane().add(botonIngles);
		botonIngles.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				accionBoton("Ingles");
			}
		});

		JButton botonPortugues = new JButton("Portugues");
		botonPortugues.setBounds(169, 124, 89, 23);
		frameIdioma.getContentPane().add(botonPortugues);
		botonPortugues.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				accionBoton("Portugues");
			}
		});

		JButton botonVuelta = new JButton("Volver al menu");
		botonVuelta.setBounds(10, 227, 114, 23);
		frameIdioma.getContentPane().add(botonVuelta);
		botonVuelta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				accionBoton("Volver al menu");
			}
		});

		return frameIdioma;
	}

	private void volverAlMenu() {
		frameInicial.setVisible(true);
		frameIdioma.setVisible(false);
//		frameDificultad.setVisible(false);
//		juego.setVisible(false);
	}

	private void accionBoton(String boton) {
		switch (boton) {
		case "Musica": {

		}
		case "Instrucciones": {
			JOptionPane.showMessageDialog(frameInicial, "bla bla bla");
			break;
		}
		case "Comenzar juego": {
			panelIdioma();
			frameIdioma.setVisible(true);
			frameInicial.setVisible(false);
			JOptionPane.showMessageDialog(frameIdioma, "¡Seleccioná el idioma con el que querés jugar!");
			break;
		}
		case "Español": {
			Backend.generarListado("Español");
			break;
		}
		case "Ingles": {
			Backend.generarListado("Ingles");
			break;
		}
		case "Portugues": {
			Backend.generarListado("Portugues");
			break;
		}
		case "Volver al menu": {
			volverAlMenu();
			break;
		}

		}
	}
}
