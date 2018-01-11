import sun.plugin2.message.ShowDocumentMessage;
import sun.plugin2.message.ShowStatusMessage;
import javax.swing.JFrame;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.*;
import java.security.Key;
import java.util.ArrayList;


public class MainWindow extends JFrame
{   private int qqq=0;
    private int lastKey = 0;
    private boolean GameOver1 = false;
    private boolean GameOver2 = false;
    private snake snake1 = new snake(5, 5, 10);
    private snake snake2 = new snake(60, 10, 10);
    private ArrayList<apple> apple1 = new ArrayList<apple>();
    private apple apple2 = new  apple();
    private int lastKey1=-1;
    private int lastKey2=-1;
    private int u1=0;
    private int u2=0;
    private int n=100;

    MainWindow (String title)
    {
        super(title);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(900,710);
        setResizable(false);
         setFocusable(true);


        for(int i=0;i<n ;i++)
            apple1.add(new apple());
        apple2.set(false);


        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
                Input(e);
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
        Thread th = new Thread(new Runnable() {

            public void run() {

                while (qqq!=1) {
                    snake1.logic();

                    GameOver1=snake1.gameover(snake2);
                    if(GameOver1)
                    {if(snake1.length()>snake2.length())
                        JOptionPane.showMessageDialog(null,"1 player win");
                       else if(snake1.length()<snake2.length())
                            JOptionPane.showMessageDialog(null,"2 player win");
                        else JOptionPane.showMessageDialog(null,"draw");
                        setVisible(false);
                        dispose();
                        qqq=1;

                    }

                    snake1.eat(apple1.get(0), apple2);
                    for(int i=1;i<n;i++)
                        snake1.eat(apple1.get(i),apple1.get(i-1));
                    Point c=snake1.head();
                    snake2.logic();
                    GameOver2=snake2.gameover(snake1);
                    snake2.eat(apple1.get(0), apple2);
                    for(int i=1;i<n;i++)
                        snake2.eat(apple1.get(i),apple1.get(i-1));
                    Point c1=snake2.head();
                    if (c1.x<0||c1.x>900||c1.y<10||c1.y>710||c.x<0||c.x>900||c.y<10||c.y>710||GameOver2){
                        { if(snake1.length()>snake2.length())
                            JOptionPane.showMessageDialog(null,"1 player win");
                            else if(snake1.length()<snake2.length())
                                JOptionPane.showMessageDialog(null,"2 player win");
                            else JOptionPane.showMessageDialog(null,"draw");
                            setVisible(false);
                            dispose();
                            qqq=1;
                        }
                    }
                    snake1.reset(snake2);
                    snake2.reset(snake1);
                    repaint();
                    try {
                        Thread.sleep(300);
                    } catch (InterruptedException e) {
                    }
                }
            }
        });
        th.start();




     /*  sdddThread th1 = new Thread(new Runnable() {

           public void run() {

                while (true) {
                   // game(snake1, snake2);
                    snake2.logic();
                    snake2.gameover(snake1);
                    for(int i=0;i<n;i++)
                        snake2.eat(apple1.get(i));
                    Point c=snake2.head();
                    if (c.x<0||c.x>900||c.y<0||c.y>710){
                        System.exit(11);
                    }
                    repaint();
                    try {
                        Thread.sleep(300);
                    } catch (InterruptedException e) {
                    }
                }


            }
        });
        th1.start();*/

    }

    public void Input(KeyEvent event) {
        //Snake snake = getSnake();

        if((lastKey == KeyEvent.VK_UP||
                lastKey == KeyEvent.VK_DOWN||
                lastKey == KeyEvent.VK_RIGHT||
                lastKey == KeyEvent.VK_LEFT)&&u1==0
                )
        { lastKey1=lastKey;u1++;}
        if((lastKey == KeyEvent.VK_A||
                lastKey == KeyEvent.VK_W||
                lastKey == KeyEvent.VK_S||
                lastKey == KeyEvent.VK_D)&&u2==0)
        { lastKey2=lastKey;u2++;}

        switch (event.getKeyCode()) {

            case KeyEvent.VK_RIGHT:

                if (lastKey1 != KeyEvent.VK_LEFT && !GameOver1 && !GameOver2)
                    {
                    snake1.setDirection(snake.RIGHT);
                    lastKey1 = KeyEvent.VK_RIGHT;
                }
                break;
            case KeyEvent.VK_LEFT:

                if (lastKey1 != KeyEvent.VK_RIGHT && !GameOver1 && !GameOver2) {
                    snake1.setDirection(snake.LEFT);
                    lastKey1 = KeyEvent.VK_LEFT;
                }
                break;
            case KeyEvent.VK_DOWN:

                if (lastKey1 != KeyEvent.VK_UP && !GameOver1 && !GameOver2) {
                    snake1.setDirection(snake.DOWN);
                    lastKey1 = KeyEvent.VK_DOWN;
                }
                break;
            case KeyEvent.VK_UP:

                if (lastKey1 != KeyEvent.VK_DOWN && !GameOver1 && !GameOver2) {
                    snake1.setDirection(snake.UP);
                    lastKey1 = KeyEvent.VK_UP;
                }
                break;
            case KeyEvent.VK_D:

                if (lastKey2 != KeyEvent.VK_A && !GameOver1 && !GameOver2) {
                    snake2.setDirection(snake.RIGHT);
                    lastKey2 = KeyEvent.VK_D;
                }
                break;
                case KeyEvent.VK_A:

                if (lastKey2 != KeyEvent.VK_D && !GameOver1 && !GameOver2) {
                    snake2.setDirection(snake.LEFT);
                    lastKey2 = KeyEvent.VK_A;
                }
                break;
            case KeyEvent.VK_S:

                if (lastKey2 != KeyEvent.VK_W && !GameOver1 && !GameOver2) {
                    snake2.setDirection(snake.DOWN);
                    lastKey2 = KeyEvent.VK_S;
                }
                break;
            case KeyEvent.VK_W:

                if (lastKey2 != KeyEvent.VK_S && !GameOver1 && !GameOver2) {
                    snake2.setDirection(snake.UP);
                    lastKey2 = KeyEvent.VK_W;
                }

                break;
            case KeyEvent.VK_ESCAPE:
                System.exit(3);
                break;
        }
        snake1.logic();
        snake2.logic();
        snake1.reset(snake2);
        snake2.reset(snake1);
        GameOver1=snake1.gameover(snake2);
        GameOver2=snake2.gameover(snake1);
        snake1.eat(apple1.get(0), apple2);
        snake2.eat(apple1.get(0), apple2);
        for(int i=1;i<n;i++) {
            snake1.eat(apple1.get(i), apple1.get(i - 1));
            snake2.eat(apple1.get(i), apple1.get(i - 1));
        }
        repaint();
    }


    public void paint(Graphics g)
    {
        Graphics2D g2 = (Graphics2D) g.create();
        //g.setsetRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g.setColor(Color.white);
        g.fillRect(0, 0, getWidth(), getHeight());
        snake1.paint(g2);
        snake2.paint(g2);
        for(int i=0;i<n;i++)
        apple1.get(i).paint(g2);


    }

   /* public void game (snake snake1, snake snake2)
    {ArrayList<Point> s1= snake1.body();
        ArrayList<Point> s2= snake2.body();
        for (int i=0;i<sna)
    }*/
}

