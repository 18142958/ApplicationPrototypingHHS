public abstract class Shape extends PixelGrid {
    protected int xPos;
    protected int yPos;

    public Shape(int SIZEX, int SIZEY) {
        super(SIZEX, SIZEY);
        this.xPos = 0;
        this.yPos = 0;
        //comment test

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


    public void makeHollow(){
        //eerste en laatste regel wordt altijd geprint en kunnen we dus overslaan
        for(int i =1; i < SIZEY-1; i++) {
            //zoek de eerste pixel daarna elke pixel leegmaken behalve de laatst gevulde pixel
            boolean firstPixelFound = false;
            for (int j = 0; j < SIZEX - 1; j++) {
                if (!firstPixelFound && isFilledPixel(j, i)) {
                    firstPixelFound = true;
                } else if (firstPixelFound && isFilledPixel(j + 1, i)) { //als volgende pixel gevuld is dan deze leegmaken
                    this.clearPixel(j, i);
                }
            }
        }


    }

    public int getArea(){
        int area=0;
        for(int i=0; i <SIZEY;i++){
            for(int j=0; j < SIZEX; j++){
                if(isFilledPixel(j,i)){
                    area++;
                }
            }
        }
        return area;

    }


}
