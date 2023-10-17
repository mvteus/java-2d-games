import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/* JFrame é a Moldura */
public class Janela extends JFrame {

    private JPanel tela; /* JPanel é a tela */
    private final int FPS = 1000 / 50; /* 20 */
    private int contador;
    private boolean anima = true;
    private int posicaoX;
    private int posicaoY;
    private boolean[] controleTecla = new boolean[4];
    private Point mouseClick = new Point();

    public Janela() {

        tela = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) { /* Graphics é o pincel */
                g.setColor(Color.WHITE);
                g.fillRect(0, 0, tela.getWidth(), tela.getHeight());

                int x = tela.getWidth() / 2 - 20 + posicaoX;
                int y = tela.getHeight() / 2 - 20 + posicaoY;

                g.setColor(Color.BLUE);
                g.fillRect(x, y, 40, 40);
                g.drawString("Agora estou em " + x + "x" + y, 10, 20);

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

        super.getContentPane().add(tela); /* Adiciono o JPanel (Tela) no JFrame (Moldura) */

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(640, 480);
        setVisible(true);

        /*
         * Interação com TECLADO e MOUSE
         * */

        /*
         * MOUSE
         * */
        tela.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                mouseClick = e.getPoint();
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                /*
                 * Mouse entrou da tela
                 * */
            }

            @Override
            public void mouseExited(MouseEvent e) {
                /*
                 * Mouse saiu da tela
                 * */
            }
        });

        /*
         * TECLADO
         * */
        super.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                //int tecla = e.getKeyCode();
                setaTecla(e.getKeyCode(), true);
            }

            @Override
            public void keyReleased(KeyEvent e) {
                setaTecla(e.getKeyCode(), false);
            }
        });

    }

    /* Controle do jogo */
    public void setaTecla(int tecla, boolean pressionada) {
        switch (tecla) {
            case KeyEvent.VK_ESCAPE: /* Tecla ESC para fechar a janela */
                anima = false;
                dispose();
                break;
            case KeyEvent.VK_UP: /* Seta para CIMA */
                //posicaoY--;
                controleTecla[0] = pressionada;
                break;
            case KeyEvent.VK_DOWN: /* Seta para BAIXO */
                //posicaoY++;
                controleTecla[1] = pressionada;
                break;
            case KeyEvent.VK_LEFT: /* Seta para ESQUERDA */
                //posicaoX--;
                controleTecla[2] = pressionada;
                break;
            case KeyEvent.VK_RIGHT: /* Seta para DIREITA */
                //posicaoX++;
                controleTecla[3] = pressionada;
                break;
        }
    }

    private void atualizaJogo() {

        /*
         * Controle com o MOUSE
         * */
        posicaoX = mouseClick.x;
        posicaoY = mouseClick.y;

        /*
         * Controle com o TECLADO
         * */
        if (controleTecla[0]) { /* EIXO Y */
            posicaoY--;
        } else if (controleTecla[1]) {
            posicaoY++;
        }

        if (controleTecla[2]) { /* EIXO X */
            posicaoX--;
        } else if (controleTecla[3]) {
            posicaoX++;
        }
    }

    /* Loop do jogo */
    public void iniciaAnimacao() {
        long prxAtualizacao = 0;

        while (anima) {

            if (System.currentTimeMillis() >= prxAtualizacao) {
                contador++;
                atualizaJogo();
                tela.repaint();

                prxAtualizacao = System.currentTimeMillis() + FPS;

                /*if (contador == 100) {
                    anima = false;
                }*/
            }

        }
    }

    public static void main(String[] args) {
        // new Janela();
        Janela anima = new Janela();
        anima.iniciaAnimacao();
    }

}
