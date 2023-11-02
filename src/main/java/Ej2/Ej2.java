package Ej2;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Ej2 extends JFrame {
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JLabel label;

    private JButton ultimoBotonClicado; 

    public Ej2() {
        setTitle("Ejercicio 2");
        setBounds(600, 450, 400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initComponents();
    }

    private void initComponents() {
        contentPane = new JPanel();
        contentPane.setLayout(new BorderLayout());

        label = new JLabel("Ningún botón ha sido clicado aún");
        contentPane.add(label, BorderLayout.CENTER);

        JButton boton1 = new JButton ("Boton 1");
        JButton boton2 = new JButton("Boton 2");

        boton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ultimoBotonClicado = boton1;
                actualizarEtiqueta();
            }
        });

        boton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ultimoBotonClicado = boton2;
                actualizarEtiqueta();
            }
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(boton1);
        buttonPanel.add(boton2);

        contentPane.add(buttonPanel, BorderLayout.WEST);
        setContentPane(contentPane);
    }

    private void actualizarEtiqueta() {
        if (ultimoBotonClicado != null) {
            label.setText("Último botón clicado: " + ultimoBotonClicado.getText());
        } else {
            label.setText("Ningún botón ha sido clicado aún");
        }
    }
}