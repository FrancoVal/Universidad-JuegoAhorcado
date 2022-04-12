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

public class Frontend {

	private JFrame frameInicial;
	private JFrame frameIdioma;
	private JFrame frameDificultad;
<<<<<<< Updated upstream
	private JFrame juego;

	Backend backend;
=======
	private JFrame frameJuegoNormal;
	private JFrame frameJuegoIA;

	private JPanel panelJuegoNormal;
	private JPanel panelJuegoIA;
>>>>>>> Stashed changes

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
<<<<<<< Updated upstream
		
		return frameDificultad;
=======

		return frameDificultad;
	}

	private JFrame frameJuegoNormal() {

		controlador.crearJuego(idiomaAUtilizar, dificultadAUtilizar, modoAJugar, palabraContraIA);
		frameJuegoNormal = new JFrame();
		frameJuegoNormal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameJuegoNormal.setBounds(100, 100, 800, 600);
		frameJuegoNormal.setLayout(new FlowLayout());
		frameJuegoNormal.setLocationRelativeTo(null);

		panelJuegoNormal = new JPanel();
		panelJuegoNormal.setBorder(new EmptyBorder(5, 5, 5, 5));

		frameJuegoNormal.setContentPane(panelJuegoNormal);
		panelJuegoNormal.setLayout(new BorderLayout(0, 0));
		panelJuegoNormal.setForeground(Color.WHITE);

		this.palabra = new JLabel(controlador.getPalabra());
		this.palabra.setHorizontalAlignment(JLabel.CENTER);
		this.palabra.setForeground(Color.BLACK);
		this.palabra.setFont(new Font("Serif", Font.PLAIN, 35));

		JPanel panel = new JPanel();
		frameJuegoNormal.add(panel, BorderLayout.SOUTH);
		panel.setLayout(new GridLayout(0, 8, 0, 0));

		crearBotones(panel);

		JPanel panelCronometro = new JPanel();
		panel.add(panelCronometro);

		panelJuegoNormal.add(palabra);

		JMenuBar menuBar = new JMenuBar();
		frameJuegoNormal.setJMenuBar(menuBar);

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

		frameJuegoNormal.setVisible(true);

		return frameJuegoNormal;
	}

	private JFrame frameJuegoIA(String palabraContraIA) {

		controlador.crearJuego(idiomaAUtilizar, dificultadAUtilizar, modoAJugar, palabraContraIA);
		frameJuegoIA = new JFrame();
		frameJuegoIA.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameJuegoIA.setBounds(100, 100, 800, 600);
		frameJuegoIA.setLayout(new FlowLayout());
		frameJuegoIA.setLocationRelativeTo(null);

		panelJuegoIA = new JPanel();
		panelJuegoIA.setBorder(new EmptyBorder(5, 5, 5, 5));

		frameJuegoIA.setContentPane(panelJuegoIA);
		panelJuegoIA.setLayout(new BorderLayout(0, 0));
		panelJuegoIA.setForeground(Color.WHITE);

		this.palabra = new JLabel(controlador.getPalabra());
		this.palabra.setHorizontalAlignment(JLabel.CENTER);
		this.palabra.setForeground(Color.BLACK);
		this.palabra.setFont(new Font("Serif", Font.PLAIN, 35));

		JPanel panel = new JPanel();
		frameJuegoIA.add(panel, BorderLayout.SOUTH);
		panel.setLayout(new GridLayout(0, 8, 0, 0));

		crearBotones(panel);

		panelJuegoIA.add(palabra);

		JMenuBar menuBar = new JMenuBar();
		frameJuegoIA.setJMenuBar(menuBar);

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

		frameJuegoIA.setVisible(true);

		return frameJuegoIA;

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
						frameJuegoNormal.repaint();
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

		this.panelJuegoNormal.validate();
		this.panelJuegoNormal.repaint();

		if (controlador.verificarVictoria()) {
			panelesFinales("Victoria");
		} else if (!controlador.getEstado()) {
			panelesFinales("Derrota");
		}
	}

	private void accionBotonTeclado(String tecla) {
		if (controlador.getEstado()) {

			controlador.intentar(tecla);
			actualizarPantalla();
		} else {
			panelesFinales("Derrota");
		}

>>>>>>> Stashed changes
	}
	
//	private JFrame panelJuego() {
//	}

	private void volverAlMenu() {
		frameInicial.setVisible(true);
<<<<<<< Updated upstream
		frameIdioma.setVisible(false);
		frameDificultad.setVisible(false);
//		juego.setVisible(false);
=======

		if (frameModo.isActive()) {
			frameModo.setVisible(false);
		} else if (frameIdioma.isActive()) {
			frameIdioma.setVisible(false);
		} else if (frameDificultad.isActive()) {
			frameDificultad.setVisible(false);
		} else {
			frameJuegoNormal.setVisible(false);
		}
	}

	private void reiniciarJuego() {

		frameJuegoNormal.dispose();
		frameJuegoNormal();
		frameJuegoNormal.revalidate();
		frameJuegoNormal.repaint();
		actualizarPantalla();

>>>>>>> Stashed changes
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
<<<<<<< Updated upstream
			panelIdioma();
=======
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
			this.palabraContraIA = inputUsuario.getText().toUpperCase();
			modoAJugar = Modo.TORNEO;
			frameIdioma();
>>>>>>> Stashed changes
			frameIdioma.setVisible(true);
			frameInicial.setVisible(false);
			JOptionPane.showMessageDialog(frameIdioma, "¡Seleccioná el idioma con el que querés jugar!");
			break;
		}
		case "Español": {
			panelDificultad();
			frameDificultad.setVisible(true);
			frameIdioma.setVisible(false);
			Backend.generarListado("Español");
			break;
		}
		case "Ingles": {
			panelDificultad();
			frameDificultad.setVisible(true);
			frameIdioma.setVisible(false);
			Backend.generarListado("Ingles");
			break;
		}
		case "Portugues": {
			panelDificultad();
			frameDificultad.setVisible(true);
			frameIdioma.setVisible(false);
<<<<<<< Updated upstream
			Backend.generarListado("Portugues");
=======
			break;
		}
		case "Inicial": {
			dificultadAUtilizar = Dificultad.FACIL;
			if(this.palabra!=null) {
				frameJuegoNormal();
			}else {
				frameJuegoIA(this.palabraContraIA);
			}
			frameJuegoNormal.setVisible(true);
			frameDificultad.setVisible(false);
			break;
		}
		case "Medio": {
			dificultadAUtilizar = Dificultad.MEDIO;
			if(this.palabra!=null) {
				frameJuegoNormal();
			}else {
				frameJuegoIA(this.palabraContraIA);
			}
			frameJuegoNormal.setVisible(true);
			frameDificultad.setVisible(false);
			break;
		}
		case "Dificil": {
			dificultadAUtilizar = Dificultad.DIFICIL;
			if(this.palabra!=null) {
				frameJuegoNormal();
			}else {
				frameJuegoIA(this.palabraContraIA);
			}
			frameJuegoNormal.setVisible(true);
			frameDificultad.setVisible(false);
			break;
		}
		case "Ver incorrectas": {
			JOptionPane.showMessageDialog(frameJuegoNormal, controlador.getLetrasIncorrectas());
>>>>>>> Stashed changes
			break;
		}
		case "Volver al menu": {
			volverAlMenu();
			break;
		}
<<<<<<< Updated upstream
=======
		}

	}
>>>>>>> Stashed changes

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
