package Ej9;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

public class Ej9 extends JFrame implements ActionListener{
	private Tablero tablero;
	private JLabel puntosJugador_1 = new JLabel();
	private JLabel puntosJugador_2 = new JLabel();
	private JPanel panelEste = new JPanel(new FlowLayout());
	private JPanel panelOeste = new JPanel(new FlowLayout());
	private JButton[][] botones;
	private ImageIcon[] imagenes;
	private static int option;
	private static int a, b, c, d;
	private String puntos1;
	private String puntos2;
	private int puntosJ1;
	private int puntosJ2;
	private int contador;
	private List<Integer> numeroAciertos;

	/**
	 * Constructor de la clase Parejas. 
	 * Se encarga de inicializar las variables y configurar la ventana del juego. 
	 * También genera el tablero aleatorio y llama a otros métodos de configuración.
	 */
	public Ej9() {
		  	option = 0;
		  	tablero = new Tablero(4);
		  	puntos1 = "0";
		  	puntos2 = "0";
	        contador = 0;
	        puntosJ1 = 0;
	        puntosJ2 = 0;
	        numeroAciertos = new ArrayList<Integer>();
	        tablero.generarTableroAleatorio();
	        initComponents();
	        puntuacionJugadores();
	        configVentana();
	    }

	/**
	 * Este método configura la ventana principal del juego. 
	 * Establece el título de la ventana, el tamaño, la ubicación y el comportamiento de cierre.
	 */
	public void configVentana() {

		setTitle("Juego de las parejas");
		setSize(1200, 900);
		// setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setVisible(true);
		// this.getContentPane().setLayout();
	}

	/**
	 * Configura la interfaz de usuario para mostrar los puntajes de los jugadores en la parte superior de la ventana.
	 * Crea etiquetas para los nombres de los jugadores y sus respectivos puntajes.
	 */
	public void puntuacionJugadores() {

		JPanel panelNorte = new JPanel(new FlowLayout());
		JPanel panelEste = new JPanel(new FlowLayout());
		JPanel panelOeste = new JPanel(new FlowLayout());
		JLabel puntuaje = new JLabel();
		JLabel jugador_1 = new JLabel();
		JLabel jugador_2 = new JLabel();

		jugador_1.setText("Jugador 1:");
		jugador_2.setText("Jugador 2:");
		puntosJugador_1.setText(puntos1);
		puntosJugador_2.setText(puntos2);

		jugador_1.setPreferredSize(new Dimension(200, 50));
		jugador_2.setPreferredSize(new Dimension(200, 50));

		panelEste.add(jugador_1);
		panelEste.add(puntosJugador_1);
		panelOeste.add(jugador_2);
		panelOeste.add(puntosJugador_2);

		this.add(panelNorte, "North");
		this.add(panelEste, "East");
		this.add(panelOeste, "West");

	}

	/**
	 * Inicializa los componentes gráficos del juego, en particular los botones que representan las cartas en el tablero. 
	 * Crea una matriz de botones y los agrega a un panel con una disposición en forma de cuadrícula.
	 */
	public void initComponents() {
		int d = tablero.getDimension();
		imagenes = new ImageIcon[d * d / 2 + 1];
		imagenes[0] = null;
		for (int i = 1; i <= d * d / 2; i++)
			imagenes[i] = new ImageIcon(getClass().getResource("/imagen/" + i + ".jpg"));
		JPanel A = new JPanel(new GridLayout(d, d));

		botones = new JButton[d][d];
		for (int i = 0; i < d; i++) {
			for (int j = 0; j < d; j++) {

				botones[i][j] = new JButton();
				botones[i][j].addActionListener(this);
				A.add(botones[i][j]);
			}
		}
		this.add(A, "Center");
	}

	/**
	 * @param x
	 * @param y
	 * Este método controla la lógica del juego cuando un botón se presiona. 
	 * Se encarga de gestionar los clics en el tablero y verificar si dos cartas seleccionadas coinciden o no. 
	 * Si coinciden, actualiza los puntajes de los jugadores y muestra las cartas acertadas. 
	 * Si no coinciden, oculta las cartas seleccionadas y permite a los jugadores seguir jugando.
	 */
	public void accion(int x, int y) {
		switch (option) {
		case 0:
			if (!tablero.esClic(x, y)) {
				tablero.clic(x, y);
				botones[x][y].setIcon(imagenes[tablero.getPos(x, y)]);
				option = 1;
				a = x;
				b = y;
			}
			break;
		case 1:
			if (!tablero.esClic(x, y)) {
				tablero.clic(x, y);
				botones[x][y].setIcon(imagenes[tablero.getPos(x, y)]);
				c = x;
				d = y;
				if (tablero.getPos(a, b) != tablero.getPos(c, d)) {
					option = 2;
					this.contador++;

				} else {
					this.contador++;
					numeroAciertos.add(contador);

					if (contador % 2 != 0) {

						if (numeroAciertos.contains(contador - 2))
							puntosJ1 = puntosJ2 * 2;
						else
							puntosJ1++;
						puntos1 = Integer.toString(puntosJ1);
						puntosJugador_1.setText(puntos1);
						panelEste.add(puntosJugador_1);
					} else {

						if (numeroAciertos.contains(contador - 2))
							puntosJ2 = puntosJ2 * 2;
						else
							puntosJ2++;
						puntos2 = Integer.toString(puntosJ2);
						puntosJugador_2.setText(puntos2);
						panelEste.add(puntosJugador_2);
					}
					puntuacionJugadores();

					option = 0;
				}
			}
			break;
		case 2:
			botones[a][b].setIcon(null);
			botones[c][d].setIcon(null);
			tablero.clic(a, b);
			tablero.clic(c, d);
			option = 0;
			break;
		}
	}

	/**
	 * Maneja los eventos de acción cuando se hace clic en uno de los botones (cartas) en el tablero. 
	 * Llama al método accion para gestionar la acción del juego.
	 */
	public void actionPerformed(ActionEvent ae) {

		int d = tablero.getDimension();
		for (int i = 0; i < d; i++) {
			for (int j = 0; j < d; j++) {
				if (botones[i][j] == ae.getSource()) {
					accion(i, j);
					if (tablero.esCompleto()) {
						if (puntosJ1 > puntosJ2) {
							JOptionPane.showMessageDialog(this, "¡Felicidades!, ha ganado el jugador 1.",
									"Al fin terminaron!", JOptionPane.INFORMATION_MESSAGE, null);
						} else {
							JOptionPane.showMessageDialog(this, "¡Felicidades!, ha ganado el jugador 2.",
									"Al fin terminaron!", JOptionPane.INFORMATION_MESSAGE, null);
						}
						System.exit(0);
					}
					return;
				}
			}
		}
	}
}
