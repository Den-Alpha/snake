import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class snake {


    public static final int UP = 1;
    public static final int RIGHT = 2;
    public static final int DOWN = 3;
    public static final int LEFT = 4;
    public static final int shift = 0;
    private ArrayList<Point> snake_body = new ArrayList<Point>();
    private int step_size=0;
    private int snake_direction = 0;


    snake(int x0, int y0, int step) {
        step_size = step;
        int x = x0 * step + shift;
        int y = y0 * step + shift;
        for (int i = 0; i < 1; i++) {
            snake_body.add(new Point(x, y));
        }

    }
    public int length() {
        return snake_body.size();
    }

    public void setDirection(int direction) {
        this.snake_direction = direction;
    }

    public Point head (){
        return snake_body.get(0);
    }
    public ArrayList<Point> body(){
        return snake_body;
    }


    public void logic(){
        Point c=this.head();
      /* if (c.x<0||c.x>900||c.y<0||c.y>710)
        {
            JOptionPane.showMessageDialog(null,"Game over.");
            System.exit(10);}*/


        int length = snake_body.size();
        Point head = snake_body.get(0);
        Point last = snake_body.get(length-1);

        for(int i=1; i<snake_body.size();i++){

            snake_body.set(length-i,snake_body.get(length-i-1) );

        }

        switch(snake_direction){
            case UP:
                head = new Point(head.x,head.y-step_size);

                break;
            case DOWN:
                head = new Point(head.x,head.y+step_size);
                break;
            case LEFT:
                head = new Point(head.x-step_size,head.y);
                break;
            case RIGHT:
                head = new Point(head.x+step_size,head.y);
                break;
        }
        snake_body.set(0,head);
        //snake_body.add(0,head);



    }
    public void eat(apple Apple, apple ap){   int length = snake_body.size();
        Point head = snake_body.get(0);
        Point last = snake_body.get(length-1);
    if(head.x==Apple.apple1().x && head.y==Apple.apple1().y ){
        Apple.set(ap);
        snake_body.add(last);
    }}
    public  boolean gameover(snake snakee){ int length = snake_body.size();
        Point head = snake_body.get(0);
        Point last = snake_body.get(length-1);
        ArrayList<Point> q=snakee.body();
        snake_body.set(0,head);
        Point c1=head;

        if (this.length()==20)
            return true;
        /*if( this.head().x==snakee.head().x&&this.head().y==snakee.head().y)
        {
            return true;}
        for(int i=1;i<length;i++)
        { if((head.x==snake_body.get(i).x&&head.y==snake_body.get(i).y))
        {
            return true;}}
        for(int i=1;i<q.size();i++)
        {if (head.x==q.get(i).x&&head.y==q.get(i).y)
        {
            return true;}
        }*/
return  false;
    }

    public void reset(Point head){
        snake_body.clear();
        snake_body.add(0, head);
    };

    public void reset(snake s)
    { Point head1= snake_body.get(0);
    Point head2=s.head();
    if(head1==head2)
    {snake_body.clear();
        snake_body.add(0, head1);
    s.reset(head2);
    }
        for(int i=1; i<snake_body.size();i++) {

            if (head1.x == snake_body.get(i).x && head1.y == snake_body.get(i).y) {
                snake_body.clear();
                snake_body.add(0, head1);
                break;
            }
            if (head2.x == snake_body.get(i).x && head2.y == snake_body.get(i).y) {
                snake_body.clear();
                snake_body.add(0, head1);
                break;

            }

        }
    }



    public void paint(Graphics2D g2){
        for(Point p:snake_body){
            g2.setColor(Color.black);
            g2.fillArc(p.x, p.y, step_size, step_size, 0, 360);
            g2.setColor(Color.black);
            g2.drawArc(p.x, p.y, step_size, step_size, 0, 360);
        }
        /*Point p = snake_body.get(snake_body.size() - 1);
        g2.setColor(Color.black);
        g2.fillArc(p.x + step_size / 2 - 2, p.y + step_size / 2 - 2, 4, 4, 0, 360);
        g2.setColor(Color.white);
        g2.fillArc(p.x + step_size / 2 - 1, p.y + step_size / 2 - 1, 2, 2, 0, 360);*/


    }

}
