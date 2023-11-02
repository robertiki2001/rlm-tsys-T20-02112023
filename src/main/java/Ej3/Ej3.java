package Ej3;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Ej3 extends JFrame {
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JLabel label1;
    private JLabel label2;
    private int contadorBoton1 = 0; 
    private int contadorBoton2 = 0; 

    public Ej3() {
        setTitle("Ejercicio 3");
        setBounds(600, 450, 400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initComponents();
    }

    private void initComponents() {
        contentPane = new JPanel();
        contentPane.setLayout(new BorderLayout());

        label1 = new JLabel("Botón 1 ha sido clicado 0 veces");
        label2 = new JLabel("Botón 2 ha sido clicado 0 veces");

        JPanel labelsPanel = new JPanel(new GridLayout(2, 1));
        labelsPanel.add(label1);
        labelsPanel.add(label2);

        contentPane.add(labelsPanel, BorderLayout.CENTER);

        JButton boton1 = new JButton("Botón 1");
        JButton boton2 = new JButton("Botón 2");

        boton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                contadorBoton1++;
                actualizarEtiqueta();
            }
        });

        boton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                contadorBoton2++;
                actualizarEtiqueta();
            }
        });

        JPanel buttonPanel = new JPanel(new GridLayout(2, 1));
        buttonPanel.add(boton1);
        buttonPanel.add(boton2);

        contentPane.add(buttonPanel, BorderLayout.WEST);
        setContentPane(contentPane);
    }

    private void actualizarEtiqueta() {
        label1.setText("Botón 1 ha sido clicado " + contadorBoton1 + " veces");
        label2.setText("Botón 2 ha sido clicado " + contadorBoton2 + " veces");
    }
}