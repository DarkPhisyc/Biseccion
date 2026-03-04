import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Gestion implements ActionListener {
    private JTextField funcion;
    private JTextField a;
    private JTextField b;
    private JTextField error;
    // Constructor para recibir los campos de texto
    public Gestion(JTextField funcion, JTextField a, JTextField b, JTextField error) {
        this.funcion = funcion;
        this.a = a;
        this.b = b;
        this.error = error;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            // Obtener los valores ingresados por el usuario
            String fx = funcion.getText().trim();
            double valorA = Double.parseDouble(a.getText());
            double valorB = Double.parseDouble(b.getText());
            double valorError = Double.parseDouble(error.getText());
            // Validar que la función cambie de signo en el intervalo [a, b]
            double fa = evaluarFuncion(fx, valorA);
            double fb = evaluarFuncion(fx, valorB);
            if(fa * fb >= 0) {
                JOptionPane.showMessageDialog(null, "La función no cambia de signo en el intervalo [a, b]. Por favor, ingresa un intervalo válido.", null, JOptionPane.ERROR_MESSAGE);
                return;
            }
            // Método de bisección
            double m = 0;
            double errorFinal = (valorB - valorA) / 2; // Error inicial
            int iteraciones = 0; // Contador de iteraciones
            while((valorB - valorA) / 2 > valorError) {
                m = (valorA + valorB) / 2; // Punto medio
                double fm = evaluarFuncion(fx, m);
                if(fa * fm < 0) {
                    valorB = m;
                    fb = fm;
                } else {
                    valorA = m;
                    fa = fm;
                }
                errorFinal = (valorB - valorA) / 2; // Actualizar el error a donde se detuvo
                // Incrementar el contador de iteraciones
                iteraciones++;
            }
            // Mostrar resultados
            JOptionPane.showMessageDialog(null, "Raíz aproximada: " + m + "\nIteraciones: " + iteraciones + "\nError final: " + errorFinal);
        // Capturar cualquier error
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error al evaluar la función.", null, JOptionPane.ERROR_MESSAGE);
        }
    }
    // Método para evaluar la función
    public double evaluarFuncion(String funcion, double x) {
        Expression exp = new ExpressionBuilder(funcion)
            .variable("x")
            .build()
            .setVariable("x", x);
        return exp.evaluate();
    }
}
