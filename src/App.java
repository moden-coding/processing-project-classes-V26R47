import processing.core.*;
import java.util.ArrayList;

public class App extends PApplet {
    ArrayList<Box> boxes;
    public static void main(String[] args)  {
        PApplet.main("App");
    }

    public void setup(){
        boxes = new ArrayList<>();
        int x = 50;
        for(int i = 0; i < 4; i++){
            Box box = new Box(x, 100, this);
            boxes.add(box);
            x += 100;
        }
        // boxes.add(new Box(350, 100, this));
        // boxes.get(3).setValue(0);

    }

    public void settings() {
        size(500,600);
        
    }

    public void draw(){
       background(100, 0, 0);
       for(Box b: boxes){
        b.display();
       }
    }

    public void keyPressed(){
        if(keyCode == RIGHT) {
            System.out.println("right");
            for (int j = 0; j < boxes.size()-1; j++){
                Box right = boxes.get(j +2);
                Box mid = boxes.get(j + 1);
                for(int d = 3; d < 0; d--){
                if(mid.getValue() == right.getValue()) {
                    right.doubleValue();
                    shiftValues(j);
                    // mid.resetValue();
                    // boxes.get(boxes.size()-1).resetValue();    
            }
            }
        }
        }
    

        if(keyCode == LEFT) {
            System.out.println("left");
            for (int i = 0; i < boxes.size()-1; i++){
                Box left = boxes.get(i);
                Box mid2 = boxes.get(i + 1);
                for(int d2 = 0; d2 < 3; d2++){
                if(mid2.getValue() == left.getValue()) {
                    left.doubleValue();
                    shiftValues(i);
                    // mid.resetValue();
                    boxes.get(boxes.size()-1).resetValue();    
                }
                }
            }   // } else if(box2.getValue() == box3.getValue()) {
            //     box1.doubleValue();
            //     box2.resetValue();
            // }
    
        }
    }
    public void shiftValues(int index){
        for(int start = index + 1; start < boxes.size() - 1; start++){
            Box currentBox = boxes.get(start);
            Box nextBox = boxes.get(start + 1);
            currentBox.setValue(nextBox.getValue());
        }
    }
}
