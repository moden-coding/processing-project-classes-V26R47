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
            Box box = new Box(x, 200, this);
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
        fill(255);
        textSize(50);
        int index = 0;
        int highScore = 0;
        if(index < boxes.size() - 2){
            if(boxes.get(index).getValue() > highScore){
                highScore = boxes.get(index).getValue();
                index++;
            }
        }
        text("High score:" , 50, 100);
    }

    public void keyPressed(){
        // I might be able to add a new value in first and last position.
        if(keyCode == LEFT) {
            System.out.println("left");
            for (int i = 0; i < boxes.size() - 1; i++){
                Box left = boxes.get(i);
                Box mid = boxes.get(i + 1);
                
                if(mid.getValue() == left.getValue()) {
                    left.doubleValue();
                    shiftValues(i);
                    boxes.get(boxes.size() - 1).resetValue();    
                    break;            
                }
            }
    
        }

        if(keyCode == RIGHT) {
            System.out.println("right");
            for (int j = boxes.size() - 2; j >= 0; j--){
                // if(j = /*the value 0 */){
                //     /*than shift values to the right and double */
                // }
                Box left = boxes.get(j);
                Box right = boxes.get(j + 1);
                if(left.getValue() == right.getValue()) {
                    right.doubleValue();
                    shiftRight(j);
                    boxes.get(0).resetValue();
                    break;
            }
        }
        }
    
    }
    public void shiftValues(int index){
        for(int start = index + 1; start < boxes.size() - 1; start++){
            Box currentBox = boxes.get(start);
            Box nextBox = boxes.get(start + 1);
            currentBox.setValue(nextBox.getValue());
            // boxes.get(boxes.size() - 1).resetValue();                

        }
        // boxes.get(boxes.size() - 1).resetValue();
    }
    public void shiftRight(int rightIndex){
        for(int start = rightIndex; start > 0; start--){
            Box right = boxes.get(start);
            Box left = boxes.get(start - 1);
            right.setValue(left.getValue());
        }
    }
}
