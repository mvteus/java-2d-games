import javax.swing.*;
import java.awt.*;

/* JFrame é a Moldura */
public class Janela extends JFrame {

    /* JPanel é o tela */
    private JPanel tela;
    private int fps = 1000 / 50; /* 50 */
    private int contador;
    private boolean anima = true;

    public Janela() {

        tela = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) { /* Graphics é o pincel */
                //g.setColor(Color.WHITE);
                //g.fillRect(0, 0, tela.getWidth(), tela.getHeight());

                g.setColor(Color.BLUE);
                g.drawLine(0, 240 + contador, 640, 240 + contador);
                g.drawRect(10, 25 + contador, 20, 20);
                g.drawOval(30 + contador, 20, 40, 30);

                g.setColor(Color.YELLOW);
                g.drawLine(320 - contador, 0, 320 - contador, 480);
                g.fillRect(110, 125, 120 - contador, 120 - contador);
                g.fillOval(230, 220, 240 + contador, 230);

                g.setColor(Color.RED);
                g.drawString("Eu seria um ótimo Score! " + contador, 5, 10);
            }
        };

        super.getContentPane().add(tela);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(640, 480);
        setVisible(true);
    }

    public void iniciaAnimacao() {
        long prxAtualizacao = 0;

        while (anima) {

            if (System.currentTimeMillis() >= prxAtualizacao) {
                contador++;
                tela.repaint();

                prxAtualizacao = System.currentTimeMillis() + fps;

                if (contador == 100) {
                    anima = false;
                }
            }

        }
    }

    public static void main(String[] args) {
        // new Janela();
        Janela anima = new Janela();
        anima.iniciaAnimacao();
    }

}
