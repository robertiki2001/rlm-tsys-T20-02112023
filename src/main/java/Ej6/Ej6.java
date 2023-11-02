package Ej6;

import java.awt.event.*;
import javax.swing.*;

public class Ej6 extends JFrame {
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;
    private JLabel labelAltura;
    private JLabel labelPeso;
    private JLabel labelCalculo;
    private JButton buttonCalculo;

    public Ej6() {
        setTitle("Ejercicio 6");
        setBounds(500, 500, 700, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initComponents();
    }

    private void initComponents() {
        contentPane = new JPanel();
        contentPane.setLayout(null);
        setContentPane(contentPane);

        labelAltura = new JLabel("Altura (metros)");
        labelAltura.setBounds(72, 69, 125, 22);
        contentPane.add(labelAltura);

        textField = new JTextField();
        textField.setBounds(160, 70, 115, 20);
        contentPane.add(textField);
        textField.setColumns(10);

        labelPeso = new JLabel("Peso (kg)");
        labelPeso.setBounds(326, 69, 125, 22);
        contentPane.add(labelPeso);

        textField_1 = new JTextField();
        textField_1.setColumns(10);
        textField_1.setBounds(391, 70, 115, 20);
        contentPane.add(textField_1);

        buttonCalculo = new JButton("Calcular IMC");
        buttonCalculo.setBounds(137, 131, 145, 23);
        contentPane.add(buttonCalculo);

        labelCalculo = new JLabel("IMC :");
        labelCalculo.setBounds(301, 131, 136, 22);
        contentPane.add(labelCalculo);

        textField_2 = new JTextField();
        textField_2.setColumns(10);
        textField_2.setBounds(371, 132, 115, 20);
        contentPane.add(textField_2);

        buttonCalculo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    double altura = Double.parseDouble(textField.getText());
                    double peso = Double.parseDouble(textField_1.getText());

                    double imc = calcularIMC(altura, peso);

                    textField_2.setText(String.format("%.2f", imc));
                } catch (NumberFormatException ex) {
                    textField_2.setText("Error: Ingresa números válidos");
                }
            }
        });
    }

    private double calcularIMC(double altura, double peso) {
        return peso / (altura * altura);
    }

}