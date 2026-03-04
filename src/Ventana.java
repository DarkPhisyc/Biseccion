import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;

public class Ventana extends JFrame {
    private JTextField funcion;
    private JTextField error;
    private JButton calcular;
    private JLabel etiqueta1;
    private JLabel etiqueta2;
    private JLabel etiqueta3;
    private JLabel etiqueta5;
    private JTextField a;
    private JTextField b;

    public Ventana(int x, int y, int alto, int ancho, String titulo) {
        // Generación de la ventana
        super(titulo);
        setBounds(x, y, alto, ancho);
        setLayout(null);
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        // Campo de texto para la función
        funcion = new JTextField();
        funcion.setBounds(190, 50, 180, 30);
        add(funcion);
        // Botón para calcular
        calcular = new JButton("Calcular");
        calcular.setBounds(229, 275, 100, 30);
        add(calcular);
        // Agregar acción al botón
        Gestion gestion = new Gestion(funcion);
        calcular.addActionListener(gestion);
        // Etiqueta para indicar la entrada de la función
        etiqueta1 = new JLabel("Ingresa la función f(x):");
        etiqueta1.setBounds(60, 50, 150, 30);
        add(etiqueta1);
        // Etiqueta para indicar la entrada del intervalo
        etiqueta2 = new JLabel("Ingresa el intervalo [a, b]:");
        etiqueta2.setBounds(41, 100, 150, 30);
        add(etiqueta2);
        // Campos de texto para el intervalo
        a = new JTextField();
        a.setBounds(190, 100, 80, 30);
        add(a);
        b = new JTextField();
        b.setBounds(290, 100, 80, 30);
        add(b);
        // Una coma
        etiqueta3 = new JLabel(",");
        etiqueta3.setBounds(275, 100, 20, 30);
        add(etiqueta3);
        // Etiqueta para indicar el error o tolerancia
        etiqueta5 = new JLabel("Ingresa el error:");
        etiqueta5.setBounds(94, 200, 150, 30);
        add(etiqueta5);
        // Campo de texto para el error o tolerancia
        error = new JTextField();
        error.setBounds(190, 200, 180, 30);
        add(error);
        // Hacer visible la ventana
        setVisible(true);
    }
}