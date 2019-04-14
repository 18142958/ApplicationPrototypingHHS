import java.sql.SQLOutput;

public class ConsoleDrawing {
    public static void main(String[] args) {
        System.out.println("Opdracht 1-3");
        System.out.println();

        Rectangle myRectangle = new Rectangle(15, 7);
        System.out.println(myRectangle);

        Oval myOval = new Oval(15, 7);
        System.out.println(myOval);


        Triangle myTriangle = new Triangle(15, 7);
        System.out.println(myTriangle);

        System.out.println();
        System.out.println("Opdracht 2-3");
        System.out.println();

//        TODO: complete this code
//
        Canvas myCanvas = new Canvas(51,7);
        myRectangle.makeHollow();
        myOval.makeHollow();
        myTriangle.makeHollow();
        myCanvas.add(myRectangle, 0,0);
        myCanvas.add(myOval, 18,0);
        myCanvas.add(myTriangle,36,0);
       //myCanvas.fill(); // is dat nodig, of kan dat slimmer?
        System.out.println(myCanvas);
//
//        todo (end)

//        System.out.println();
//        System.out.println("Opdracht 2-4");
//        System.out.println();
//
//        TODO: complete this code
//
        System.out.println("Opdracht 2-4");
        Shape linkervoet = new Rectangle(10,3);
        Shape rechtervoet = new Rectangle(10,3);
        Shape linkerbeen = new Rectangle(3,10);
        Shape rechterbeen = new Rectangle(3,10);
        Shape linkerarm = new Rectangle(12,2);
        Shape rechterarm = new Rectangle(12,2);
        Shape romp = new Oval(25,15);
        Shape hoofd = new Oval(17,7);
        Shape hat = new Rectangle(29,2);
        Shape hatTop = new Rectangle(9,5);

        Canvas papier = new Canvas(60,47);
        papier.add(linkervoet, 15,0); //voeg al je Shapes toe aan het papier
        papier.add(rechtervoet, 30,0);
        papier.add(linkerbeen, 22,3);
        papier.add(rechterbeen, 30,3);
        papier.add(romp, 15,13);
        papier.add(hoofd, 19,28);
        papier.add(linkerarm, 5,22);
        papier.add(rechterarm, 37,22);
        papier.add(hat, 13,34);
        papier.add(hatTop, 23,36);

//        papier.fill(); // is dat nodig, of kan dat slimmer?
        System.out.println(papier);
//
//        todo (end)

//        System.out.println();
        System.out.println("Opdracht 2-5");
        try {
            papier.move(9, 0, 5);
            papier.move(8, 0, 5);
            papier.move(7, 5, 2);
            papier.move(6, -5, 2);
            papier.move(5, 0, 3);
            papier.move(4, 0, 2);
            papier.move(3, 0, 1);
            papier.move(2, 0, 1);
            papier.move(1, 0, 0);
            papier.move(0, 0, 0);
            System.out.println(papier);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
//        System.out.println();
        System.out.println("Opdracht 3-2 invert hoofd en romp");
        papier.invertShape(4);
        papier.invertShape(5);
        System.out.println(papier);

//
//        TODO: verplaats alle shapes zodat je een 'exploded view' krijgt en teken dan het resultaat
//
    }
}
