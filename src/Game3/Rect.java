package Game3;


public class Rect extends Sprite{
    private int dx;
    private int dy;
    
    public Rect(int x, int y, int width, int height) throws Exception {
        super(x, y,width,height);
    }
   
    public void move() {
        y =  300;
        if (x < 0) {
            x = 200;
        }
        x -= 1;
    }

}