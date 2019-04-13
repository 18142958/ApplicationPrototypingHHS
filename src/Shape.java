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
        for(int i =1; i < SIZEY-1; i++){
            int eerstePixel=0;
            int laatstePixel=0;
            for(int j=0; j < SIZEX; j++){
                if(isFilledPixel(j,i)){
                    eerstePixel = j;
                    break;
                }

            }
            for(int k=SIZEX-1; k >=0; k--){
                if(isFilledPixel(k,i)){
                    laatstePixel=k;
                    break;
                }
            }

            for(int l=0;l <SIZEX;l++){
                if(l != eerstePixel && l != laatstePixel){
                    clearPixel(l,i);
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
