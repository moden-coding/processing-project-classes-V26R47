import processing.core.*;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class App extends PApplet {
    ArrayList<Box> boxes;
    int scene; // started writing a file
    int highScore; // but didn't finish

    public static void main(String[] args) {
        PApplet.main("App");
    }

    public void setup() {
        highScore = 0;
        readHighScore();
        boxes = new ArrayList<>();

        // creates 4 boxes
        int x = 50;
        for (int i = 0; i < 4; i++) {
            Box box = new Box(x, 200, this);
            boxes.add(box);
            x += 100;
        }
        scene = 0;

    }

    public void settings() {
        size(500, 600);

    }

    public void draw() {
        // prints the boxes
        background(100, 0, 0);
        for (Box b : boxes) {
            b.display();
        }
        int index = 0;

        //checking boxes
        for (boxes.get(index); index < boxes.size(); index++) {
            // tried to get it to write a highscore
            if (scene == 0) {
                fill(255);
                textSize(50);
                int number = 0;
                if (number < boxes.size() - 2) {
                    if (boxes.get(number).getValue() > highScore) {
                        highScore = boxes.get(number).getValue();
                        number++;
                    }
                    text("High score:" + highScore, 50, 100);
                }
            // tried to make it check all the boxes to find the high score
            } else if (keyCode == LEFT || keyCode == RIGHT) {
                fill(255);
                textSize(50);
                if (index > boxes.size() - 2) {
                    index = boxes.get(0).getValue();
                    if (boxes.get(index).getValue() > highScore) {
                        highScore = boxes.get(index).getValue();
                        index++;
                    }
                }
            }
        }
    }

    public void keyPressed() {
        // when left key is pressed, it combines equal ajacent values on the far left and shifts the values all one to the left accept the farthest right value which becomes 0.
        if (keyCode == LEFT) {
            System.out.println("left");
            for (int i = 0; i < boxes.size() - 1; i++) {
                Box left = boxes.get(i);
                Box mid = boxes.get(i + 1);

                if (mid.getValue() == left.getValue()) {
                    left.doubleValue();
                    shiftValues(i);
                    boxes.get(boxes.size() - 1).resetValue();
                    break;
                }
            }

        }
// when right key is pressed, it combines equal ajacent values on the far right and shifts the values all one to the right accept the farthest left value which becomes 0.
        if (keyCode == RIGHT) {
            System.out.println("right");
            for (int j = boxes.size() - 2; j >= 0; j--) {
                // if(j = /*the value 0 */){
                // /*than shift values to the right and double */
                // }
                Box left = boxes.get(j);
                Box right = boxes.get(j + 1);
                if (left.getValue() == right.getValue()) {
                    right.doubleValue();
                    shiftRight(j);
                    boxes.get(0).resetValue();
                    break;
                }
            }
        }

    }

    public void shiftValues(int index) {
        // shifts values left
        for (int start = index + 1; start < boxes.size() - 1; start++) {
            Box currentBox = boxes.get(start);
            Box nextBox = boxes.get(start + 1);
            currentBox.setValue(nextBox.getValue());
            
        }
      
    }

    public void shiftRight(int rightIndex) {
                // shifts values right
        for (int start = rightIndex; start > 0; start--) {
            Box right = boxes.get(start);
            Box left = boxes.get(start - 1);
            right.setValue(left.getValue());
        }
    }

    public void readHighScore() {
        // started writing a file and didn't finnish
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
