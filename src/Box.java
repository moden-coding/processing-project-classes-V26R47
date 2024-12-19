import processing.core.PApplet;

public class Box {
    public int x;
    public int y;
    private int size;
    private PApplet canvas;
    public int startValue;
    public int boxValue;


    public Box(int xPos, int yPos, PApplet b) {
        x = xPos;
        y = yPos;
        size = 100;
        canvas = b;
        startValue = 2;
        boxValue = startValue;
    }
    public void display(){
        canvas.fill(255);
        canvas.square(x, y, size);
        canvas.fill(0);
        canvas.textSize(50);
        canvas.text(boxValue, x + 25, y + 75);
    }
    public void setValue(int value){
        boxValue = value;
    }   

    public int getValue(){
        return boxValue;
    }

    public void doubleValue(){
        boxValue *= 2;
    }
    public void resetValue(){
        boxValue = 0;
    }
}
