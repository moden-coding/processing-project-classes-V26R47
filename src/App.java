import processing.core.*;
import java.util.ArrayList;

public class App extends PApplet{
    Box box1;
    Box box2;
    Box box3;
    ArrayList<Box> boxes;
    public static void main(String[] args)  {
        PApplet.main("App");
    }

    public void setup(){
        box1 = new Box(50, 100, this);
        box2 = new Box(150, 100, this);
        box3 = new Box(250, 100, this);
        boxes = new ArrayList<>();
        box1 = new Box(50, 100, this);
        int count = 0;
        if(count > 0){
            boxes.add(box1 + 100, 0, this);
            
        }

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
        if(keyCode == ' '){
            boxes.add(box);
        }
        if(keyCode == RIGHT) {
            if(box1.getValue() == box2.getValue()) {
                box2.doubleValue();
                box1.resetValue();
            } else if(box2.getValue() == box3.getValue()) {
                box3.doubleValue();
                box2.resetValue();
            }
        }
        if(keyCode == LEFT) {
            if(box3.getValue() == box2.getValue()) {
                box2.doubleValue();
                box3.resetValue();
            } else if(box2.getValue() == box3.getValue()) {
                box1.doubleValue();
                box2.resetValue();
            }
        }
    }
}
