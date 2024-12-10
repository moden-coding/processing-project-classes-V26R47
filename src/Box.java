import processing.core.PApplet;

public class Box {
    private int x;
    private int y;
    private int size;
    private PApplet canvas;
    private int startValue;


    public Box(int xPos, int yPos, PApplet b) {
        x = xPos;
        y = yPos;
        size = 100;
        canvas = b;
        startValue = 10;
    }
    public void display(){
        canvas.square(x, y, size);
    }
    public void boxValue(){
        text(startValue);
    }   
}
