package core;

import java.awt.image.DataBufferInt;
import java.util.Random;

public class Renderer {

    private int pW, pH;
    private int[] p;

    public Renderer(GameContainer gc) {
        pW = gc.getWidth();
        pH = gc.getHeight();
        p = ((DataBufferInt)gc.getWindow().getImage().getRaster().getDataBuffer()).getData();
    }

    public void clear() {
    	Random r = new Random();
        for (int i = 0; i < p.length; i++) {
            p[i] = r.nextInt();
        }
    }

}
