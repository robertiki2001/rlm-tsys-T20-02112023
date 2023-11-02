package Ej8;

import java.awt.event.*;
import javax.swing.*;

public class Ej8 extends JFrame {
	private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField textFieldCantidad;
    private JTextField textFieldResultado;
    private JLabel labelCantidad;
    private JLabel labelResultado;
    private JButton buttonEurosAPesetas;
    private JButton buttonPesetasAEuros;
    private boolean conversionAEuros = true;
    private JLabel labelError;
    private JButton buttonBorrarDatos;

    public Ej8() {
        setTitle("Ejercicio 8");
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

        textFieldCantidad = new JTextField();
        textFieldCantidad.setBounds(181, 70, 115, 20);
        contentPane.add(textFieldCantidad);
        textFieldCantidad.setColumns(10);

        labelResultado = new JLabel("Resultado");
        labelResultado.setBounds(326, 69, 147, 22);
        contentPane.add(labelResultado);

        textFieldResultado = new JTextField();
        textFieldResultado.setColumns(10);
        textFieldResultado.setBounds(456, 70, 136, 20);
        contentPane.add(textFieldResultado);

        buttonEurosAPesetas = new JButton("Euros a pesetas");
        buttonEurosAPesetas.setBounds(95, 118, 157, 36);
        contentPane.add(buttonEurosAPesetas);

        buttonPesetasAEuros = new JButton("Pesetas a euros");
        buttonPesetasAEuros.setBounds(291, 118, 150, 36);
        contentPane.add(buttonPesetasAEuros);
        
        labelError = new JLabel("");
        labelError.setBounds(167, 89, 203, 22);
        contentPane.add(labelError);
        
        buttonBorrarDatos = new JButton("Borrar datos");
        buttonBorrarDatos.setBounds(443, 11, 150, 36);
        contentPane.add(buttonBorrarDatos);

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
        
        buttonBorrarDatos.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	textFieldCantidad.setText("");
            	textFieldResultado.setText("");
            	labelError.setText("");
            }
        });
    }

    private void realizarConversion() {
        try {
            double cantidad = Double.parseDouble(textFieldCantidad.getText());
            double resultado = conversionAEuros ? cantidad * 166.386 : cantidad / 166.386;
            textFieldResultado.setText(String.format("%.2f", resultado));
            labelResultado.setText(conversionAEuros ? "Resultado en pesetas:" : "Resultado en euros:");
            labelError.setText("");
        } catch (NumberFormatException ex) {
        	labelError.setText("Error: Ingresa una cantidad válida");
        }
    }
}
