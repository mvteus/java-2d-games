import javax.swing.*;
import java.awt.*;

/* JFrame é a Moldura */
public class Janela extends JFrame {

    /* JPanel é o tela */
    private JPanel tela;

    public Janela() {

        tela = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) { /* Graphics é o pincel */
                g.setColor(Color.BLUE);
                g.drawLine(0, 240, 640, 240);
                g.drawRect(10, 25, 20, 20);
                g.drawOval(30, 20, 40, 30);
                g.setColor(Color.YELLOW);
                g.drawLine(320, 0, 320, 480);
                g.fillRect(110, 125, 120, 120);
                g.fillOval(230, 220, 240, 230);
                g.setColor(Color.RED);
                g.drawString("Eu seria um ótimo Score!", 5, 10);
            }
        };

        super.getContentPane().add(tela);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(640, 480);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Janela();
    }

}
