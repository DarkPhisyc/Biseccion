import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;

public class Ventana extends JFrame {
    private JTextField funcion;
    private JButton calcular;

    public Ventana(int x, int y, int alto, int ancho, String titulo) {
        // Generación de la ventana
        super(titulo);
        setBounds(x, y, alto, ancho);
        setLayout(null);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        // Campo de texto para la función
        funcion = new JTextField();
        funcion.setBounds(190, 100, 180, 30);
        add(funcion);
        // Botón para calcular
        calcular = new JButton("Calcular");
        calcular.setBounds(229, 140, 100, 30);
        add(calcular);
    }
}