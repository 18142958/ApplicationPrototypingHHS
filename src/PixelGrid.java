public abstract class PixelGrid {
    protected String pixels[][];
    protected final int SIZEX;
    protected final int SIZEY;

    protected static final String FILLED = "*";
    protected static final String EMPTY  = " ";

    public PixelGrid(int SIZEX, int SIZEY){
        if (SIZEX <= 0 || SIZEY <= 0) {
            throw new IllegalArgumentException("Illegal size of shape");
        }
        this.SIZEX = SIZEX;
        this.SIZEY = SIZEY;
        this.pixels = new String[SIZEX][SIZEY];
        this.clearAllPixels();
    }

    protected void clearAllPixels(){

        for (int x = 0; x < this.SIZEX; x++) {
            for (int y = 0; y < this.SIZEY; y++) {
                this.clearPixel(x, y);
            }
        }
    }
    public abstract void fill();

    public int getSIZEX() {
        return this.SIZEX;
    }
    public int getSIZEY(){
        return this.SIZEY;
    }

    public String toString() {
        String output = "";
        for (int y = SIZEY - 1; y >= 0; y--) {
            for (int x = 0; x < SIZEX; x++) {
                output += pixels[x][y];
            }
            output += "\n";
        }
        return output;
    }


    public void fillPixel(int x, int y) {
        pixels[x][y] = FILLED;
    }

    public void clearPixel(int x, int y) {
        pixels[x][y] = EMPTY;
    }


}
