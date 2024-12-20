import processing.core.*;

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class App extends PApplet {
    ArrayList<Box> boxes;
    int scene;
    int highScore;
    public static void main(String[] args)  {
        PApplet.main("App");
    }

    public void setup(){
        highScore = 0;
        readHighScore();
        boxes = new ArrayList<>();
        int x = 50;
        for(int i = 0; i < 4; i++){
            Box box = new Box(x, 200, this);
            boxes.add(box);
            x += 100;
        }
        scene = 0;
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
        int index = 0;
        for(boxes.get(index); index < boxes.size(); index++){
        if(scene == 0){
        fill(255);
        textSize(50);
        int number = 0;
        if(number < boxes.size() - 2){
            if(boxes.get(number).getValue() > highScore){
                highScore = boxes.get(number).getValue();
                number++;
            }
            text("High score:" + highScore, 50, 100);
        }
        // } else if(keyCode == LEFT || keyCode == RIGHT){
        //     fill(255);
        //     textSize(50);
        //     int index = 0;
        //     if(index > boxes.size() - 2){
        //         index = boxes.get(0).getValue();
        //         if(boxes.get(index).getValue() > highScore){
        //             highScore = boxes.get(index).getValue();
        //             index++;
        //         }
        // }
        }
    }
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
    public void readHighScore(){
        try (Scanner scanner = new Scanner(Paths.get("highScore.txt"))) {

    // we read the file until all lines have been read
        while (scanner.hasNextLine()) {
        // we read one line
            String row = scanner.nextLine();
        // we print the line that we read
            highScore = Integer.valueOf(row);
        }
    } catch (Exception e) {
        System.out.println("Error: " + e.getMessage());
    }

    }
}
