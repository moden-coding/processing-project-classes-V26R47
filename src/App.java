import processing.core.*;

public class App extends PApplet{
    Box box1;
    Box box2;
    Box box3;
    public static void main(String[] args)  {
        PApplet.main("App");
    }

    public void setup(){
        box1 = new Box(50, 100, this);
        box2 = new Box(150, 100, this);
        box3 = new Box(250, 100, this);
    }

    public void settings() {
        size(400,600);
        
    }

    public void draw(){
       background(100, 0, 0);
       box1.display();
       box2.display();
       box3.display();
    }

    public void keyPressed(){
        if(keyCode == RIGHT) {
            if(box1.getValue() == box2.getValue()) {
                box2 =  startValue * 2;
            }
        }
    }
}
