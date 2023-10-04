import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/* JFrame é a Moldura */
public class Janela extends JFrame {

    /* JPanel é o tela */
    private JPanel tela;
    private int fps = 1000 / 50; /* 20 */
    private int contador;
    private boolean anima = true;
    private int posicaoX;
    private int posicaoY;

    public Janela() {

        /* Interação com teclado e mouse */
        super.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                int tecla = e.getKeyCode();
                switch(tecla){
                    case KeyEvent.VK_ESCAPE:
                        anima=false;
                        dispose(); /* Para fechar a janela */
                        break;
                    case KeyEvent.VK_UP: /* Seta para CIMA */
                        posicaoY--;
                        break;
                    case KeyEvent.VK_DOWN: /* Seta para BAIXO */
                        posicaoY++;
                        break;
                    case KeyEvent.VK_LEFT: /* Seta para ESQUERDA */
                        posicaoX--;
                        break;
                    case KeyEvent.VK_RIGHT: /* Seta para DIREITA */
                        posicaoX++;
                        break;
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });

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

    /* Loop do jogo */
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
