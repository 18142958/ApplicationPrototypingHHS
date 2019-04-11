public abstract class Shape extends PixelGrid {
    protected int xPos;
    protected int yPos;

    public Shape(int SIZEX, int SIZEY) {
        super(SIZEX, SIZEY);
        this.xPos = 0;
        this.yPos = 0;

    }


    public int getYPos(){

        return this.yPos;
    }

    public int getXPos(){
        return this.xPos;
    }


    public boolean isFilledPixel(int x, int y) {
        return (pixels[x][y].equals(FILLED));
    }

    public boolean isFilled(int xCanvas, int yCanvas){
        int endX = this.xPos +this.SIZEX-1;
        int endY = this.yPos + this.SIZEY-1;
        if((this.xPos <= xCanvas && xCanvas <=endX) && (this.yPos <= yCanvas && yCanvas <= endY)){
            int x,y;
            if(xCanvas > 0) {
                x = xCanvas - this.xPos;
            }else{
                x = xCanvas;
            }
            if(yCanvas > 0){
                y = yCanvas-this.yPos;
            }else{
                y = yCanvas;
            }
            return isFilledPixel(x,y);
        }
        return false;
    }

    public void setXPos(int xPos){
        this.xPos = xPos;
    }

    public void setYPos(int yPos){
        this.yPos = yPos;
    }

}
