public class Triangle extends Shape {
    public Triangle(int SIZEX, int SIZEY) {
        super(SIZEX, SIZEY);
        fill();
    }

    @Override
    public void fill() {
        boolean isEven = SIZEX % 2 == 0 ; //als breedte even is dan 2 sterretjes in het midden anders 1
       int midPoint;
       if(isEven){
           midPoint = 2;
       }else{
           midPoint=1;
       }
        double starIncrease = (double) (SIZEX-midPoint) / (SIZEY-1);

        for (int row = 1; row<= SIZEY; row++){
            double rowStarIncrease = (row-1) * starIncrease; //toename aantal sterren voor deze rij
            int rowStarIncreaseInt =  2*(int)(rowStarIncrease/2);
            int rowStartPoint = ((SIZEX - (rowStarIncreaseInt+midPoint))/2); //positie eerste ster
            int rowEndPoint= rowStartPoint +rowStarIncreaseInt; //positie laatste ster
            int y = SIZEY-row; //vertaal row naar y anders wordt de driehoek ondersteboven afgedrukt
            for(int x =0; x < SIZEX; x++){
               if (x < rowStartPoint || x > rowEndPoint){
                   clearPixel(x,y);
               }else{
                   fillPixel(x,y);
               }

            }
        }


    }
}
