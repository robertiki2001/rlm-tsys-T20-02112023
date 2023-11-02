package Ej4;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Ej4 extends JFrame {
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JLabel label;
    private JTextArea textArea;

    public Ej4() {
        setTitle("Ejercicio 4");
        setBounds(600, 450, 400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initComponents();
        agregarEventosDeVentana();
    }

    private void initComponents() {
        contentPane = new JPanel();
        contentPane.setLayout(new BorderLayout());

        label = new JLabel("Eventos");
        textArea = new JTextArea();

        contentPane.add(label, BorderLayout.NORTH);
        contentPane.add(new JScrollPane(textArea), BorderLayout.CENTER); // Utilizamos un JScrollPane para permitir desplazamiento

        setContentPane(contentPane);
    }

    private void agregarEventosDeVentana() {
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowOpened(WindowEvent e) {
                agregarEvento("Ventana abierta");
            }

            @Override
            public void windowClosing(WindowEvent e) {
                agregarEvento("Ventana cerrándose");
            }

            @Override
            public void windowClosed(WindowEvent e) {
                agregarEvento("Ventana cerrada");
            }

            @Override
            public void windowIconified(WindowEvent e) {
                agregarEvento("Ventana minimizada");
            }

            @Override
            public void windowDeiconified(WindowEvent e) {
                agregarEvento("Ventana restaurada");
            }

            @Override
            public void windowActivated(WindowEvent e) {
                agregarEvento("Ventana activada");
            }

            @Override
            public void windowDeactivated(WindowEvent e) {
                agregarEvento("Ventana desactivada");
            }
        });
    }

    private void agregarEvento(String evento) {
        textArea.append(evento + "\n");
    }
}