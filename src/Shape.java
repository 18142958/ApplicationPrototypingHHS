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


    /**
     * Keer de waarden van alle pixels om
     */
    public void invert(){
        for(int y=0;y < SIZEY; y++){
            for(int x=0; x< SIZEX;x++){
                if(this.isFilledPixel(x,y)) {
                    this.clearPixel(x,y);

                }else{
                    this.fillPixel(x,y);
                }
            }
        }
    }

    /**
     * Spiegel de shape horizontaal
     */
    public void mirrorH(){
        String[][] pixelsCopy = this.copyPixelsArray();
        this.clearAllPixels();
       for(int y=SIZEY-1; y >=0; y--){
           int rij = SIZEY-1-y ;// zorg dat de laatste rij de eerste wordt
           for(int x=0; x < SIZEX;x++){
               if(pixelsCopy[x][y].equals(FILLED)){
                   this.fillPixel(x,rij);
               }
           }
       }

    }

    /**
     * Maak een kopie van de pixels array
     * @return
     */
    private String[][] copyPixelsArray(){
       String[][] tempArray = new String[SIZEX][SIZEY];
       for(int y=0; y<SIZEY;y++){
           for(int x=0;x<SIZEX;x++){
               tempArray[x][y] = this.pixels[x][y];
           }

       }
       return tempArray;

    }
}
