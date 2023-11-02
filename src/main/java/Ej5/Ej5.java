package Ej5;
import java.awt.event.*;
import javax.swing.*;

public class Ej5 extends JFrame {
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextArea textArea;

    public Ej5() {
        setTitle("Ejercicio 5");
        setBounds(500,500,700,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initComponents();
    }

    private void initComponents() {
        contentPane = new JPanel();
        contentPane.setLayout(null);
        setContentPane(contentPane);

        JButton buttonLimpiar = new JButton("Limpiar");
        buttonLimpiar.setBounds(455, 167, 133, 81);
        contentPane.add(buttonLimpiar);

        textArea = new JTextArea(); // Usa la variable de instancia textArea
        textArea.setBounds(21, 34, 341, 398); // Aumenta la altura del área de texto
        contentPane.add(textArea);

        // Agrega un ActionListener al botón
        buttonLimpiar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Refleja el evento en el área de texto
                textArea.append("Clic en el botón 'Limpiar'\n");
                // Limpia el contenido del área de texto
                textArea.setText("");
            }
        });

        // Agrega un MouseListener al JFrame
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                textArea.append("Mouse entró en la ventana\n");
            }

            @Override
            public void mouseExited(MouseEvent e) {
                textArea.append("Mouse salió de la ventana\n");
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                textArea.append("Clic dentro de la ventana\n");
            }
        });

        // Agrega un WindowListener para el evento de cierre de ventana
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                textArea.append("Ventana cerrada\n");
            }
        });
    }
}