import processing.core.*;

public class App extends PApplet{
    public static void main(String[] args)  {
        PApplet.main("App");
    }

    public void setup(){
        background(255, 0, 255);
        rect(25, 225,100,100);
        rect(150,225,100,100);
        rect(275,225,100,100);
        rect(25, 350,100,100);
        rect(150, 350,100,100);
        rect(275, 350,100,100);
        rect(25, 475,100,100);
        rect(150, 475,100,100);
        rect(275, 475,100,100);
        textSize(25);
        text("greater undecimal neutral second", 25,50);
        
    }

    public void settings(){
            size(400,600);
    }

    public void draw(){
       

    }
}
