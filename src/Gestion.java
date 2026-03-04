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
            double fa = evaluarFuncion(fx, valorA);
            double fb = evaluarFuncion(fx, valorB);
            if(fa * fb >= 0) {
                JOptionPane.showMessageDialog(null, "La función no cambia de signo en el intervalo [a, b]. Por favor, ingresa un intervalo válido.", null, JOptionPane.ERROR_MESSAGE);
                return;
            }
            double m = 0;
            int iteraciones = 0;
            while((valorB - valorA) / 2 > valorError) {
                m = (valorA + valorB) / 2;
                double fm = evaluarFuncion(fx, m);
                if(fa * fm < 0) {
                    valorB = m;
                    fb = fm;
                } else {
                    valorA = m;
                    fa = fm;
                }
                iteraciones++;
            }
            // Mostrar resultados
            JOptionPane.showMessageDialog(null, "La raíz aproximada es: " + m + "\nNúmero de iteraciones: " + iteraciones);
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
