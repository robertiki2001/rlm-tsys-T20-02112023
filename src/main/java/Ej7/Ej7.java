package Ej7;

import java.awt.event.*;
import javax.swing.*;

public class Ej7 extends JFrame {
	private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField textField;
    private JTextField textField_1;
    private JLabel labelCantidad;
    private JLabel labelResultado;
    private JButton buttonEurosAPesetas;
    private JButton buttonPesetasAEuros;
    private boolean conversionAEuros = true;

    public Ej7() {
        setTitle("Ejercicio 7");
        setBounds(500, 500, 700, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initComponents();
    }

    private void initComponents() {
        contentPane = new JPanel();
        contentPane.setLayout(null);
        setContentPane(contentPane);

        labelCantidad = new JLabel("Cantidad a convertir");
        labelCantidad.setBounds(57, 69, 125, 22);
        contentPane.add(labelCantidad);

        textField = new JTextField();
        textField.setBounds(181, 70, 115, 20);
        contentPane.add(textField);
        textField.setColumns(10);

        labelResultado = new JLabel("Resultado");
        labelResultado.setBounds(326, 69, 147, 22);
        contentPane.add(labelResultado);

        textField_1 = new JTextField();
        textField_1.setColumns(10);
        textField_1.setBounds(456, 70, 115, 20);
        contentPane.add(textField_1);

        buttonEurosAPesetas = new JButton("Euros a pesetas");
        buttonEurosAPesetas.setBounds(159, 108, 157, 36);
        contentPane.add(buttonEurosAPesetas);

        buttonPesetasAEuros = new JButton("Pesetas a euros");
        buttonPesetasAEuros.setBounds(336, 108, 150, 36);
        contentPane.add(buttonPesetasAEuros);

        buttonEurosAPesetas.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                conversionAEuros = true;
                realizarConversion();
            }
        });

        buttonPesetasAEuros.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                conversionAEuros = false;
                realizarConversion();
            }
        });
    }

    private void realizarConversion() {
        try {
            double cantidad = Double.parseDouble(textField.getText());
            double resultado = conversionAEuros ? cantidad * 166.386 : cantidad / 166.386;
            textField_1.setText(String.format("%.2f", resultado));
            labelResultado.setText(conversionAEuros ? "Resultado en pesetas:" : "Resultado en euros:");
        } catch (NumberFormatException ex) {
            textField_1.setText("Error: Ingresa una cantidad válida");
        }
    }
}
