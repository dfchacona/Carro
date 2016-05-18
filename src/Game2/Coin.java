/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game2;

public class Coin extends Sprite {

    private int numAnimation;
    public Coin(int x, int y) {
        super(x, y);
        numAnimation = 1;
        initAlien();
    }

    private void initAlien() {
        loadImage("coin/BIG_0000_Capa-" + this.numAnimation + ".png");
        System.out.println("coin/BIG_0000_Capa-" + this.numAnimation + ".png");
        getImageDimensions();
    }

    public void move() {
        if(this.numAnimation ==8)
            this.numAnimation = 1;
        
        this.numAnimation++;
        
        loadImage("coin/BIG_000" + (this.numAnimation-1) + "_Capa-" + this.numAnimation + ".png");
    }
}