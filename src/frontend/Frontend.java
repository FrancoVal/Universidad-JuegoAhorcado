package frontend;

import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

import backend.Backend;
import backend.Idioma;

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
		fondoDePantalla(frameInicial);
		frameInicial.setTitle("Ahorcado 2.0");
		frameInicial.setBounds(100, 100, 450, 300);
		frameInicial.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameInicial.getContentPane().setLayout(null);

		fondoDePantalla(frameInicial);

		JButton botonMusicaIniciar = new JButton("\u25B6");
		botonMusicaIniciar.setBounds(393, 0, 43, 23);
		frameInicial.getContentPane().add(botonMusicaIniciar);
		botonMusicaIniciar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				accionBoton("Iniciar Musica");
			}
		});

		JButton botonMusicaDetener = new JButton("\u23F8");
		botonMusicaDetener.setBounds(351, 0, 43, 23);
		frameInicial.getContentPane().add(botonMusicaDetener);
		botonMusicaDetener.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				accionBoton("Detener Musica");
			}
		});

		JButton botonInstrucciones = new JButton("Instrucciones");
		botonInstrucciones.setBounds(71, 215, 110, 23);
		frameInicial.getContentPane().add(botonInstrucciones);
		botonInstrucciones.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				accionBoton("Instrucciones");
			}
		});

		JButton botonInicio = new JButton("Comenzar juego");
		botonInicio.setBounds(244, 215, 110, 23);
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
		fondoDePantalla(frameIdioma);
		frameIdioma.setTitle("Ahorcado 2.0");
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
	
	private JFrame panelDificultad() {
		frameDificultad = new JFrame();
		fondoDePantalla(frameDificultad);
		frameDificultad.setTitle("Ahorcado 2.0");
		frameDificultad.getContentPane().setLayout(null);
		frameDificultad.setBounds(100, 100, 450, 300);
		frameDificultad.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton botonInicial = new JButton("Inicial");
		botonInicial.setBounds(169, 56, 89, 23);
		frameDificultad.getContentPane().add(botonInicial);
		botonInicial.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				accionBoton("Inicial");
			}
		});

		JButton botonMedio = new JButton("Medio");
		botonMedio.setBounds(169, 90, 89, 23);
		frameDificultad.getContentPane().add(botonMedio);
		botonMedio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				accionBoton("Medio");
			}
		});

		JButton botonDificil = new JButton("Dificil");
		botonDificil.setBounds(169, 124, 89, 23);
		frameDificultad.getContentPane().add(botonDificil);
		botonDificil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				accionBoton("Dificil");
			}
		});

		JButton botonVuelta = new JButton("Volver al menu");
		botonVuelta.setBounds(10, 227, 114, 23);
		frameDificultad.getContentPane().add(botonVuelta);
		botonVuelta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				accionBoton("Volver al menu");
			}
		});
		
		return frameDificultad;
	}
	
//	private JFrame panelJuego() {
//	}

	private void volverAlMenu() {
		frameInicial.setVisible(true);
		frameIdioma.setVisible(false);
		frameDificultad.setVisible(false);
//		juego.setVisible(false);
	}

	private void accionBoton(String boton) {
		switch (boton) {
		case "Iniciar Musica": {
			estadoMusica(true);
			break;
		}
		case "Detener Musica": {
			estadoMusica(false);
			break;
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
			panelDificultad();
			frameDificultad.setVisible(true);
			frameIdioma.setVisible(false);
			Backend.generarListado(Idioma.ESPAÑOL);
			break;
		}
		case "Ingles": {
			panelDificultad();
			frameDificultad.setVisible(true);
			frameIdioma.setVisible(false);
			Backend.generarListado(Idioma.INGLES);
			break;
		}
		case "Portugues": {
			panelDificultad();
			frameDificultad.setVisible(true);
			frameIdioma.setVisible(false);
			Backend.generarListado(Idioma.FRANCES);
			break;
		}
		case "Volver al menu": {
			volverAlMenu();
			break;
		}

		}
	}

	public void estadoMusica(boolean estado) {
		try {
			AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("src/data/columbia.wav"));
			Clip clip = AudioSystem.getClip();
			clip.open(audioInputStream);
			if (estado) {
				clip.start();
			} else {
				clip.stop();
			}
		} catch (Exception ex) {
			System.out.println("Error with playing sound.");
			ex.printStackTrace();
		}
	}
	
	private void fondoDePantalla(JFrame frame) {
		try {
			BackgroundPane background = new BackgroundPane();
            background.setBackground(ImageIO.read(new File("src/data/Background.png")));
            frame.setContentPane(background);
            frame.getContentPane().setLayout(null);
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridwidth = GridBagConstraints.REMAINDER;
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
}