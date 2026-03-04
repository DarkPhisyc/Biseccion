import javax.swing.JFrame;
import javax.swing.JTextField;

public class Ventana extends JFrame {
    private JTextField funcion;

    public Ventana(int x, int y, int alto, int ancho, String titulo) {
        // Generación de la ventana
        super(titulo);
        setBounds(x, y, alto, ancho);
        setLayout(null);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        // Campo de texto para la función
        funcion = new JTextField();
        funcion.setBounds(200, 200, 180, 30);
        add(funcion);
    }
}