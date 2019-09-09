package question1;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import question1.Shape.ShapeType;

/**
* This class tests functions of screen.
* @author Rahul Vijay
* 
*/
public class ScreenTest {

	Screen screenObject = new Screen();
	
	/**
     * test case for testing the various methods in Rectangle class
     */
    @SuppressWarnings("serial")
    @Test
    public void rectangleTest()
    {
        Shape rectangle = ShapeFactory.createShape(Shape.ShapeType.RECTANGLE, new Point(1, 1), new ArrayList<Double>(){{add(4.0); add(2.0);}});
        
        assertEquals(8.0, rectangle.getArea(), 0.01);
        assertEquals(12.0, rectangle.getPerimeter(), 0.01);
        assertTrue(rectangle.isPointEnclosed(new Point(2, 2)));
        assertFalse(rectangle.isPointEnclosed(new Point(5, 5)));
    }
    
    /**
     * test case for testing the various methods in Square class
     */
    @SuppressWarnings("serial")
    @Test
    public void squareTest()
    {
        Shape square = ShapeFactory.createShape(Shape.ShapeType.SQUARE, new Point(1, 1), new ArrayList<Double>(){{add(4.0);}});
        
        assertEquals(16.0, square.getArea(), 0.01);
        assertEquals(16.0, square.getPerimeter(), 0.01);
        assertTrue(square.isPointEnclosed(new Point(2, 3)));
        assertFalse(square.isPointEnclosed(new Point(5, 5)));
    }
    
    /**
     * test case for testing the various methods in Triangle class
     */
    @SuppressWarnings("serial")
    @Test
    public void triangleTest()
    {
        Shape triangle = ShapeFactory.createShape(ShapeType.TRIANGLE, new Point(1, 1), new ArrayList<Double>(){{add(4.0); add(3.0); add(2.0); add(1.452);}});
        assertEquals(2.904, triangle.getArea(), 0.001);
        assertEquals(9.0, triangle.getPerimeter(), 0.001);
        assertTrue(triangle.isPointEnclosed(new Point(2, 1)));
        assertFalse(triangle.isPointEnclosed(new Point(5, 5)));
    }
    
    /**
     * test case for testing the various methods in Circle class
     */
    @SuppressWarnings("serial")
    @Test
    public void circleTest()
    {
        Shape circle = ShapeFactory.createShape(ShapeType.CIRCLE, new Point(1, 1), new ArrayList<Double>(){{add(4.0);}});
        assertEquals(50.265, circle.getArea(), 0.001);
        assertEquals(25.133, circle.getPerimeter(), 0.001);
        assertTrue(circle.isPointEnclosed(new Point(2, 1)));
        assertFalse(circle.isPointEnclosed(new Point(10, 5)));
    }
    
    /**
     * test case to add an object to screen
     */
    @SuppressWarnings("serial")
    @Test
    public void addShapeTest() {
        
        Shape shape1 = ShapeFactory.createShape(ShapeType.RECTANGLE, new Point(1, 1), new ArrayList<Double>(){{add(4.0); add(2.0);}});
        assertTrue(screenObject.addShape(shape1));
    }
    
    
    /**
     * test case to add an object to screen when object is null
     */
    @Test
    public void addNullShapeTest() {

        assertFalse(screenObject.addShape(null));
    }
    
    /**
     * test case to add an object to screen when shape lies outside the screen
     */
    @SuppressWarnings("serial")
    @Test
    public void addOutOfScreenShapeTest() {
        
        Shape shape1 = ShapeFactory.createShape(ShapeType.RECTANGLE, new Point(120, 1), new ArrayList<Double>(){{add(4.0); add(2.0);}});
        assertFalse(screenObject.addShape(shape1));
    }
    
    
    /**
     * test case to remove a shape from screen when shape is present
     */
    @SuppressWarnings("serial")
    @Test
    public void deleteShapePresentTest() {

        Shape shape1 = ShapeFactory.createShape(ShapeType.RECTANGLE, new Point(1, 1), new ArrayList<Double>(){{add(4.0); add(2.0);}});
        screenObject.addShape(shape1);
        
        assertTrue(screenObject.deleteShape(shape1));
    }
    
    /**
     * test case to remove a shape from screen when shape is not present or shape is passed null
     */
    @SuppressWarnings("serial")
    @Test
    public void deleteShapeNotPresentTest() {
        
        Shape shape1 = ShapeFactory.createShape(ShapeType.RECTANGLE, new Point(1, 1), new ArrayList<Double>(){{add(4.0); add(2.0);}});
        screenObject.addShape(shape1);
        
        Shape shape2 = ShapeFactory.createShape(ShapeType.RECTANGLE, new Point(1, 3), new ArrayList<Double>(){{add(5.0); add(2.0);}});        
        
        assertFalse(screenObject.deleteShape(shape2));
        assertFalse(screenObject.deleteShape(null));
    }
    
    /**
     * test case to remove all shapes of a particular type from the screen when objects of that type are present
     */
    @SuppressWarnings("serial")
    @Test
    public void deleteShapeTypePresentTest() {

        Shape shape1 = ShapeFactory.createShape(ShapeType.RECTANGLE, new Point(1, 1), new ArrayList<Double>(){{add(4.0); add(2.0);}});
        screenObject.addShape(shape1);
        
        Shape shape2 = ShapeFactory.createShape(ShapeType.RECTANGLE, new Point(1, 3), new ArrayList<Double>(){{add(5.0); add(2.0);}});        
        screenObject.addShape(shape2);
        
        Shape shape3 = ShapeFactory.createShape(ShapeType.CIRCLE, new Point(1, 1), new ArrayList<Double>(){{add(4.0);}});
        screenObject.addShape(shape3);
        
        assertTrue(screenObject.removeAllShapeOfType(ShapeType.RECTANGLE));
    }
    
    /**
     * test case to remove all shapes of a particular type from the screen when no object of that type are present
     */
    @SuppressWarnings("serial")
    @Test
    public void deleteShapeTypeNotPresentTest() {

        Shape shape1 = ShapeFactory.createShape(ShapeType.RECTANGLE, new Point(1, 1), new ArrayList<Double>(){{add(4.0); add(2.0);}});
        screenObject.addShape(shape1);
        
        Shape shape2 = ShapeFactory.createShape(ShapeType.RECTANGLE, new Point(1, 3), new ArrayList<Double>(){{add(5.0); add(2.0);}});        
        screenObject.addShape(shape2);
        
        Shape shape3 = ShapeFactory.createShape(ShapeType.CIRCLE, new Point(1, 1), new ArrayList<Double>(){{add(4.0);}});
        screenObject.addShape(shape3);
        
        assertFalse(screenObject.removeAllShapeOfType(ShapeType.SQUARE));
        assertFalse(screenObject.removeAllShapeOfType(null));
    }
    
    /**
     * test case to sort the shapes on screen according to area
     */
    @SuppressWarnings("serial")
    @Test
    public void sortByAreaTest() {
        
        Shape shape1 = ShapeFactory.createShape(ShapeType.RECTANGLE, new Point(1, 1), new ArrayList<Double>(){{add(4.0); add(2.0);}});
        screenObject.addShape(shape1);
        
        Shape shape2 = ShapeFactory.createShape(ShapeType.SQUARE, new Point(1, 1), new ArrayList<Double>(){{add(2.0);}});
        screenObject.addShape(shape2);
        
        List<Shape> sortedShapeByArea = screenObject.sortByArea();
        assertEquals(sortedShapeByArea, new ArrayList<Shape>(){{add(shape2); add(shape1);}}); 
    }
    
    /**
     * test case to sort the shapes on screen according to area when no object is present on screen
     */
    @Test(expected = AssertionError.class)
    public void sortByAreaEmptyListTest() {
        
        screenObject.sortByArea();
    }
    
    /**
     * test case to sort the shapes on screen according to Perimeter
     */
    @SuppressWarnings("serial")
    @Test
    public void sortByPerimeterTest() {

        Shape shape1 = ShapeFactory.createShape(ShapeType.RECTANGLE, new Point(1, 1), new ArrayList<Double>(){{add(4.0); add(2.0);}});
        screenObject.addShape(shape1);
        
        Shape shape2 = ShapeFactory.createShape(ShapeType.SQUARE, new Point(1, 1), new ArrayList<Double>(){{add(2.0);}});
        screenObject.addShape(shape2);
        
        List<Shape> sortedShapeByPerimeter = screenObject.sortByPerimeter();
        assertEquals(sortedShapeByPerimeter, new ArrayList<Shape>(){{add(shape2); add(shape1);}}); 
    }
    
    
    /**
     * test case to sort the shapes on screen according to Perimeter when no object is present on screenObject
     */
    @Test(expected = AssertionError.class)
    public void sortByPerimeterEmptyListTest() {
              
        screenObject.sortByPerimeter();
    }
    
    
    /**
     * test case to sort the shapes on screen according to OriginDistance
     */
    @SuppressWarnings("serial")
    @Test
    public void sortByOriginDistanceTest() {
        
        Shape shape1 = ShapeFactory.createShape(ShapeType.RECTANGLE, new Point(1, 1), new ArrayList<Double>(){{add(4.0); add(2.0);}});
        screenObject.addShape(shape1);
        
        Shape shape2 = ShapeFactory.createShape(ShapeType.SQUARE, new Point(2, 1), new ArrayList<Double>(){{add(2.0);}});
        screenObject.addShape(shape2);
        
        Shape shape3 = ShapeFactory.createShape(ShapeType.CIRCLE, new Point(0, 0), new ArrayList<Double>(){{add(4.0);}});
        screenObject.addShape(shape3);
        
        List<Shape> sortedShapeByOriginDistance = screenObject.sortByOriginDistance();
        assertEquals(sortedShapeByOriginDistance, new ArrayList<Shape>(){{add(shape3); add(shape1); add(shape2);}}); 
    }
    
    
    /**
     * test case to sort the shapes on screen according to OriginDistance when no object is present on screenObject
     */
    @Test(expected = AssertionError.class)
    public void sortByOriginDistanceEmptyListTest() {
        
        screenObject.sortByOriginDistance();
    }
    
    
    /**
     * test case to sort the shapes on screen according to Timestamp
     */
    @SuppressWarnings("serial")
    @Test
    public void sortByTimeStampTest() {

        Shape shape1 = ShapeFactory.createShape(ShapeType.RECTANGLE, new Point(1, 1), new ArrayList<Double>(){{add(4.0); add(2.0);}});
        screenObject.addShape(shape1);
        
        Shape shape2 = ShapeFactory.createShape(ShapeType.SQUARE, new Point(2, 1), new ArrayList<Double>(){{add(2.0);}});
        screenObject.addShape(shape2);
        
        Shape shape3 = ShapeFactory.createShape(ShapeType.CIRCLE, new Point(0, 0), new ArrayList<Double>(){{add(4.0);}});
        screenObject.addShape(shape3);
        
        List<Shape> sortedShapeByTimestamp = screenObject.sortByTimestamp();
        assertEquals(sortedShapeByTimestamp, new ArrayList<Shape>(){{add(shape1); add(shape2); add(shape3);}}); 
    }
    
    
    /**
     * test case to sort the shapes on screen according to Timestamp when no object is present on screenObject
     */
    @Test(expected = AssertionError.class)
    public void sortByTimestampEmptyListTest() {
        
        screenObject.sortByTimestamp();
    }

}