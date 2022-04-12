package frontend;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
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
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import backend.Dificultad;
import backend.Idioma;
import backend.Modo;
import controller.ControllerAhorcado;

public class Frontend {

	private JFrame frameInicial;
	private JFrame frameModo;
	private JFrame frameIdioma;
	private JFrame frameDificultad;
	private JFrame frameJuego;

	private JPanel panelJuego;

	private JLabel labelTurnos;
	private JLabel palabra;

	ControllerAhorcado controlador = new ControllerAhorcado();

	Modo modoAJugar;
	Idioma idiomaAUtilizar;
	Dificultad dificultadAUtilizar;
	public String palabraContraIA;

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
		frameInicial();
	}

	private JFrame frameInicial() {
		frameInicial = new JFrame();
		fondoDePantalla(frameInicial);
		frameInicial.setTitle("Ahorcado 2.0");
		frameInicial.setBounds(100, 100, 450, 300);
		frameInicial.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameInicial.getContentPane().setLayout(null);
		frameInicial.setLocationRelativeTo(null);

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

	private JFrame frameModo() {
		frameModo = new JFrame();
		fondoDePantalla(frameModo);
		frameModo.setTitle("Ahorcado 2.0");
		frameModo.setBounds(100, 100, 450, 300);
		frameModo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameModo.getContentPane().setLayout(null);
		frameModo.setLocationRelativeTo(null);

		JButton botonInicial = new JButton("Modo normal");
		botonInicial.setBounds(169, 56, 100, 23);
		frameModo.getContentPane().add(botonInicial);
		botonInicial.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				accionBoton("Modo normal");
			}
		});

		JButton botonMedio = new JButton("Modo torneo");
		botonMedio.setBounds(169, 90, 100, 23);
		frameModo.getContentPane().add(botonMedio);
		botonMedio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				accionBoton("Modo torneo");
			}
		});

		JButton botonVuelta = new JButton("Volver al menu");
		botonVuelta.setBounds(10, 227, 114, 23);
		frameModo.getContentPane().add(botonVuelta);
		botonVuelta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				accionBoton("Volver al menu");
			}
		});

		return frameModo;
	}

	private JFrame frameIdioma() {
		frameIdioma = new JFrame();
		fondoDePantalla(frameIdioma);
		frameIdioma.setTitle("Ahorcado 2.0");
		frameIdioma.getContentPane().setLayout(null);
		frameIdioma.setBounds(100, 100, 450, 300);
		frameIdioma.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameIdioma.setLocationRelativeTo(null);

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

		JButton botonPortugues = new JButton("Frances");
		botonPortugues.setBounds(169, 124, 89, 23);
		frameIdioma.getContentPane().add(botonPortugues);
		botonPortugues.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				accionBoton("Frances");
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

	private JFrame frameDificultad() {
		frameDificultad = new JFrame();
		fondoDePantalla(frameDificultad);
		frameDificultad.setTitle("Ahorcado 2.0");
		frameDificultad.getContentPane().setLayout(null);
		frameDificultad.setBounds(100, 100, 450, 300);
		frameDificultad.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameDificultad.setLocationRelativeTo(null);

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

	private JFrame frameJuego() {

		controlador.crearJuego(idiomaAUtilizar, dificultadAUtilizar, modoAJugar, palabraContraIA);
		frameJuego = new JFrame();
		frameJuego.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameJuego.setBounds(100, 100, 800, 600);
		frameJuego.setLayout(new FlowLayout());
		frameJuego.setLocationRelativeTo(null);

		panelJuego = new JPanel();
		panelJuego.setBorder(new EmptyBorder(5, 5, 5, 5));

		frameJuego.setContentPane(panelJuego);
		panelJuego.setLayout(new BorderLayout(0, 0));
		panelJuego.setForeground(Color.WHITE);

		this.palabra = new JLabel(controlador.getPalabra());
		this.palabra.setHorizontalAlignment(JLabel.CENTER);
		this.palabra.setForeground(Color.BLACK);
		this.palabra.setFont(new Font("Serif", Font.PLAIN, 35));

		JPanel panel = new JPanel();
		frameJuego.add(panel, BorderLayout.SOUTH);
		panel.setLayout(new GridLayout(0, 8, 0, 0));

		crearBotones(panel);

		JPanel panelCronometro = new JPanel();
		panel.add(panelCronometro);

		panelJuego.add(palabra);

		JMenuBar menuBar = new JMenuBar();
		frameJuego.setJMenuBar(menuBar);

		JMenuItem itemMusicaIniciar = new JMenuItem("\u25B6");
		itemMusicaIniciar.setBounds(393, 0, 43, 23);
		menuBar.add(itemMusicaIniciar);
		itemMusicaIniciar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				accionBoton("Iniciar Musica");
			}
		});

		JMenuItem itemMusicaDetener = new JMenuItem("\u23F8");
		itemMusicaDetener.setBounds(351, 0, 43, 23);
		menuBar.add(itemMusicaDetener);
		itemMusicaDetener.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				accionBoton("Detener Musica");
			}
		});

		JMenuItem itemRendirse = new JMenuItem("Rendirse");
		menuBar.add(itemRendirse);
		itemRendirse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelesFinales("Derrota");
			}
		});

		JMenuItem itemRegresoMenu = new JMenuItem("Volver al menu");
		menuBar.add(itemRegresoMenu);
		itemRegresoMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				accionBoton("Volver al menu");
			}
		});

		JButton itemIncorrectas = new JButton("Ver intentos");
		panel.add(itemIncorrectas);
		itemIncorrectas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				accionBoton("Ver incorrectas");
			}
		});

		this.labelTurnos = new JLabel("Turnos: " + String.valueOf(controlador.getTurnos()));
		menuBar.add(this.labelTurnos);

		return frameJuego;
	}

	private void crearBotones(JPanel panel) {

		JButton[] botones = new JButton[26];
		String[] letras = { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R",
				"S", "T", "U", "V", "W", "X", "Y", "Z" };

		for (int i = 0; i < botones.length; i++) {
			botones[i] = new JButton(letras[i]);
			botones[i].setSize(40, 40);
			botones[i].setActionCommand(letras[i]);
			ActionListener listener = new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					if (e.getSource() instanceof JButton) {
						String boton = e.getActionCommand();
						frameJuego.repaint();
						accionBotonTeclado(boton);
					}
				}
			};

			botones[i].addActionListener(listener);
			panel.add(botones[i]);
		}

	}

	private void actualizarPantalla() {

		this.labelTurnos.setText("Turnos: " + String.valueOf(controlador.getTurnos()));
		this.palabra.setText(controlador.getPalabra());

		this.panelJuego.validate();
		this.panelJuego.repaint();

		if (controlador.verificarVictoria()) {
			panelesFinales("Victoria");
		} else if (!controlador.getEstado()) {
			panelesFinales("Derrota");
		}
	}

	private void accionBotonTeclado(String tecla) {
		if (controlador.getEstado()) {

			switch (tecla) {
			case "A": {
				controlador.intentar(tecla);
				break;
			}
			case "B": {
				controlador.intentar(tecla);
				break;
			}
			case "C": {
				controlador.intentar(tecla);
				break;
			}
			case "D": {
				controlador.intentar(tecla);
				break;
			}
			case "E": {
				controlador.intentar(tecla);
				break;
			}
			case "F": {
				controlador.intentar(tecla);
				break;
			}
			case "G": {
				controlador.intentar(tecla);
				break;
			}
			case "H": {
				controlador.intentar(tecla);
				break;
			}
			case "I": {
				controlador.intentar(tecla);
				break;
			}
			case "J": {
				controlador.intentar(tecla);
				break;
			}
			case "K": {
				controlador.intentar(tecla);
				break;
			}
			case "L": {
				controlador.intentar(tecla);
				break;
			}
			case "M": {
				controlador.intentar(tecla);
				break;
			}
			case "N": {
				controlador.intentar(tecla);
				break;
			}
			case "Ñ": {
				controlador.intentar(tecla);
				break;
			}
			case "O": {
				controlador.intentar(tecla);
				break;
			}
			case "P": {
				controlador.intentar(tecla);
				break;
			}
			case "Q": {
				controlador.intentar(tecla);
				break;
			}
			case "R": {
				controlador.intentar(tecla);
				break;
			}
			case "S": {
				controlador.intentar(tecla);
				break;
			}
			case "T": {
				controlador.intentar(tecla);
				break;
			}
			case "U": {
				controlador.intentar(tecla);
				break;
			}
			case "V": {
				controlador.intentar(tecla);
				break;
			}
			case "W": {
				controlador.intentar(tecla);
				break;
			}
			case "X": {
				controlador.intentar(tecla);
				break;
			}
			case "Y": {
				controlador.intentar(tecla);
				break;
			}
			case "Z": {
				controlador.intentar(tecla);
				break;
			}
			}
			actualizarPantalla();
		} else {
			panelesFinales("Derrota");
		}

	}

	private void volverAlMenu() {
		frameInicial.setVisible(true);

		if (frameModo.isActive()) {
			frameModo.setVisible(false);
		} else if (frameIdioma.isActive()) {
			frameIdioma.setVisible(false);
		} else if (frameDificultad.isActive()) {
			frameDificultad.setVisible(false);
		} else {
			frameJuego.setVisible(false);
		}
	}

	private void reiniciarJuego() {
		controlador.reiniciarValorTurnos(this.dificultadAUtilizar);
		this.labelTurnos.setText("Turnos: " + String.valueOf(controlador.getTurnos()));
		this.palabra.setText(controlador.getPalabra());
		frameJuego();
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
			mostrarInstrucciones();
			break;
		}
		case "Comenzar juego": {
			frameModo();
			frameModo.setVisible(true);
			frameInicial.setVisible(false);
			break;
		}
		case "Modo normal": {
			modoAJugar = Modo.NORMAL;
			frameIdioma();
			frameIdioma.setVisible(true);
			frameModo.setVisible(false);
			break;
		}
		case "Modo torneo": {
			JOptionPane.showMessageDialog(frameModo, "Por favor escribí tu palabra elegida en el campo superior.");
			JTextArea inputUsuario = new JTextArea(5, 5);
			JOptionPane.showInputDialog(inputUsuario);
			if (controlador.verificarInput(inputUsuario)) {
				this.palabraContraIA = inputUsuario.getText().toUpperCase();
			} else {
				JOptionPane.showMessageDialog(frameModo, "Por favor introducir un input correcto.");
				volverAlMenu();
			}

			modoAJugar = Modo.TORNEO;
			frameIdioma();
			frameIdioma.setVisible(true);
			frameModo.setVisible(false);
			break;
		}
		case "Español": {
			idiomaAUtilizar = Idioma.ESPANIOL;
			frameDificultad();
			frameDificultad.setVisible(true);
			frameIdioma.setVisible(false);

			break;
		}
		case "Ingles": {
			idiomaAUtilizar = Idioma.INGLES;
			frameDificultad();
			frameDificultad.setVisible(true);
			frameIdioma.setVisible(false);

			break;
		}
		case "Frances": {
			idiomaAUtilizar = Idioma.FRANCES;
			frameDificultad();
			frameDificultad.setVisible(true);
			frameIdioma.setVisible(false);
			break;
		}
		case "Inicial": {
			dificultadAUtilizar = Dificultad.FACIL;
			frameJuego();
			frameJuego.setVisible(true);
			frameDificultad.setVisible(false);
			break;
		}
		case "Medio": {
			dificultadAUtilizar = Dificultad.MEDIO;
			frameJuego();
			frameJuego.setVisible(true);
			frameDificultad.setVisible(false);
			break;
		}
		case "Dificil": {
			dificultadAUtilizar = Dificultad.DIFICIL;
			frameJuego();
			frameJuego.setVisible(true);
			frameDificultad.setVisible(false);
			break;
		}
		case "Ver incorrectas": {
			JOptionPane.showMessageDialog(frameJuego, controlador.getLetrasIncorrectas());
			break;
		}
		case "Volver al menu": {
			volverAlMenu();
			break;
		}
		}
	}

	private void panelesFinales(String condicion) {
		int resultadoFinal;
		String[] buttons = { "Reiniciar", "Volver al menu", "Salir" };
		switch (condicion) {
		case "Victoria":
			resultadoFinal = JOptionPane.showOptionDialog(null, "!Felidades, ganaste!", "!Victoria!",
					JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, buttons, null);
			if (resultadoFinal == JOptionPane.YES_OPTION) {
				reiniciarJuego();
			} else if (resultadoFinal == JOptionPane.NO_OPTION) {
				volverAlMenu();
			} else {
				System.exit(0);
			}
			break;
		case "Derrota":
			resultadoFinal = JOptionPane.showOptionDialog(null, "!Mejor suerte la proxima!", "Derrota...",
					JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, buttons, null);
			if (resultadoFinal == JOptionPane.YES_OPTION) {
				reiniciarJuego();
			} else if (resultadoFinal == JOptionPane.NO_OPTION) {
				volverAlMenu();
			} else {
				System.exit(0);
			}
			break;
		}
	}

	private void mostrarInstrucciones() {
		JOptionPane.showMessageDialog(frameInicial,
				"A continuacion vas a poder seleccionar entre distintas opciones:\nModo de juego\nIdioma\nDificultad");
		JOptionPane.showMessageDialog(frameInicial,
				"Hay dos modos de juego para elegir:\nModo normal: tratas de adivinar la palabra.\nModo torneo: jugas vos y si ganas juega la maquina y asi sucesivamente.");
		JOptionPane.showMessageDialog(frameInicial,
				"Vas a ver tres idiomas para elegir en qué jugar:\nEspañol.\nIngles.\nFrances.");
		JOptionPane.showMessageDialog(frameInicial,
				"Recordá que en la dificultad:\nInicial: 5 intentos\nMedio: 3 intentos\nDificil: 1 intento\nSuerte");
	}

	private void estadoMusica(boolean estado) {
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
