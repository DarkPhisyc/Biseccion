import javax.swing.JFrame;

public class Ventana extends JFrame {

    public Ventana(int x, int y, int alto, int ancho, String titulo) {
        // Generación de la ventana
        super(titulo);
        setBounds(x, y, alto, ancho);
        setLayout(null);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}