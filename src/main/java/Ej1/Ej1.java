package Ej1;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Ej1 extends JFrame {
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JLabel label;

    public Ej1() {
        setTitle("Ejercicio 1");
        setBounds(600, 450, 400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initComponents();
    }

    private void initComponents() {
        contentPane = new JPanel();
        contentPane.setLayout(new BorderLayout());

        label = new JLabel("Cambia el tamaño de la ventana principal");
        contentPane.add(label, BorderLayout.CENTER);

        JButton restaurarButton = new JButton("Restaurar");
        JButton maximizarButton = new JButton("Maximizar");
        JButton cerrarButton = new JButton("Cerrar");

        restaurarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setExtendedState(JFrame.NORMAL);
            }
        });

        maximizarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setExtendedState(JFrame.MAXIMIZED_BOTH);
            }
        });

        cerrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); // Cierra la ventana
                System.exit(0); // Cierra la aplicación
            }
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(restaurarButton);
        buttonPanel.add(maximizarButton);
        buttonPanel.add(cerrarButton);

        contentPane.add(buttonPanel, BorderLayout.SOUTH);

        setContentPane(contentPane);
    }
}