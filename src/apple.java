import java.awt.*;
import java.util.Random;

public class apple {
        private Point ap = new Point();
        private final Random rand = new Random();
        private int step_size=10;
        private int shift=0;
        apple()

        {

            ap.x = step_size*rand.nextInt(((900)/step_size)-2) + step_size + shift;
            ap.y = step_size*rand.nextInt(((700)/step_size)-2) + step_size + shift ;
            if (ap.x<20||ap.x>890||ap.y<30||ap.y>700)
            {apple ap1=new apple();
                ap=ap1.apple1();}
        }
    public Point apple1(){return ap;}
    public void set(){
        ap.x = step_size*rand.nextInt(((900)/step_size)-2) + step_size + shift;
        ap.y = step_size*rand.nextInt(((700)/step_size)-2) + step_size + shift ;
        if (ap.x<20||ap.x>890||ap.y<30||ap.y>700)
        {apple ap1=new apple();
        ap=ap1.apple1();}
    }
    public  void set(boolean a){
        ap.x=-100;
        ap.y=-100;}

    public void set(apple ap2){
        ap.x = step_size*rand.nextInt(((900)/step_size)-2) + step_size + shift;
        ap.y = step_size*rand.nextInt(((700)/step_size)-2) + step_size + shift ;
        if (ap.x<20||ap.x>890||ap.y<30||ap.y>700||(ap==ap2.apple1()))
        {apple ap1=new apple();
            ap1.set();
            ap=ap1.apple1();}}
    public void paint(Graphics2D g2){

        Point p = ap;
        g2.setColor(Color.red);
        g2.fillArc(p.x, p.y, 10, 10, 0, 360);
        g2.setColor(Color.red);
        g2.drawArc(p.x, p.y, 10,10, 0, 360);
    }
}