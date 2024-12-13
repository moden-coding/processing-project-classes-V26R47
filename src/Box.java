import processing.core.PApplet;

public class Box {
    private int x;
    private int y;
    private int size;
    private PApplet canvas;
    public int startValue;


    public Box(int xPos, int yPos, PApplet b) {
        x = xPos;
        y = yPos;
        size = 100;
        canvas = b;
        startValue = 10;
    }
    public void display(){
        canvas.fill(255);
        canvas.square(x, y, size);
        canvas.fill(0);
        canvas.textSize(50);
        canvas.text(startValue, x + 25, y + 75);
    }
    public void boxValue(){
        
    }   

    public int getValue(){
        return startValue;
    }
}
