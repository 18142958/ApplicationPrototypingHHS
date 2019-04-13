import java.util.ArrayList;

public class Canvas extends PixelGrid {

    private ArrayList<Shape> shapes = new ArrayList<>();
    public Canvas(int SIZEX, int SIZEY){
        super(SIZEX, SIZEY);
    }


    public void fill(){

        //alle pixels legen voordat de alle shapes getekend worden
        this.clearAllPixels();
        for(Shape shape : shapes){
            this.fill(shape);
        }
    }

    public void fill(Shape shape){

        //gebruik shape coordinaten voor efficientie
        for(int y=shape.getYPos();y < (shape.getYPos()+shape.getSIZEY());y++){
            for(int x=shape.getXPos(); x< shape.getXPos()+shape.getSIZEX();x++){
                if(shape.isFilled(x,y)){
                    fillPixel(x,y);
                }
            }
        }
    }
    public void add(Shape shape, int xPos, int yPos){

        if(shapeFitsCanvas(shape, xPos, yPos)){
            shape.setXPos(xPos);
            shape.setYPos(yPos);
            this.shapes.add(shape);
            this.fill(shape);
        }
    }

    public void move(int index, int xPos, int yPos) throws Exception {

            xPos = this.shapes.get(index).xPos + xPos;
            yPos = this.shapes.get(index).yPos + yPos;

            if (shapeFitsCanvas(this.shapes.get(index), xPos, yPos)){
                this.shapes.get(index).yPos = yPos;
                this.shapes.get(index).xPos =xPos;
                this.fill();
            } else{
                throw new Exception("Past niet");
            }
    }

    public void remove(int index){

    }

    public boolean shapeFitsCanvas(Shape shape, int xPos, int yPos){
        int xEnd = xPos + shape.SIZEX;
        int yEnd = yPos + shape.SIZEY;
        return (xEnd <= this.SIZEX && yEnd <= this.SIZEY);
    }

}
