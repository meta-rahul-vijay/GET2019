import java.util.Scanner;


// TODO: Auto-generated Javadoc
/**
 * The Class Area.
 */
public class Area {
	
	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		CalculateArea area = new CalculateArea();
		while(true){
			System.out.println("Enter Choice");
			switch(sc.nextInt()){
			   case 1 : 
			       Triangle triangle = new Triangle();
			       triangle.setWidth(sc.nextInt());
			       triangle.setHeight(sc.nextInt());
			       area.triangleArea(triangle);
			       System.out.println("Area Of Triangle = "+triangle.getArea());
			       break;
			   
			   case 2 : 
			       Rectangle rectangle = new Rectangle();
			       rectangle.setLength(sc.nextInt());
			       rectangle.setBreadth(sc.nextInt());
			       area.rectangleArea(rectangle);
			       System.out.println("Area Of Rectangle = "+rectangle.getArea());
			       break;
			   
			   case 3 :
			       Square square = new Square();
			       square.setSide(sc.nextInt());
			       area.squareArea(square);
			       System.out.println("Area Of Square = "+square.getArea());
			       break;
			   
			   case 4 :
			       Circle circle = new Circle();
			       circle.setRadius(sc.nextInt());
			       area.circleArea(circle);
			       System.out.println("Area Of Circle = "+circle.getArea());
			       break;
			   
			   default :
				   System.out.println("\n" + "Good Bye");
		           System.exit(0);
			}	
		}
	}
}
