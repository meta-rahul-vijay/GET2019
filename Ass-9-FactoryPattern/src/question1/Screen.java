package question1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import question1.Shape.ShapeType;


/**
* The screen class is where all objects are added.
* @author Rahul Vijay
* 
*/
public class Screen {
	
	private List<Shape> shapesOnScreen = new ArrayList<Shape>();
	
	/**
	 * adds shape on screen
	 * @param shapeObject
	 * @return true if shape is added else false
	 */
	public boolean addShape(Shape shapeObject) {
	    
	    try
        {
            if(shapeObject == null) {
                throw new AssertionError("Object is null! Cannot add!");
            }
            
            if(shapeObject.getOrigin().x < 0 || shapeObject.getOrigin().y < 0 || shapeObject.getOrigin().x > Point.XMAX || shapeObject.getOrigin().y > Point.YMAX) {
                throw new AssertionError("Origin Point not in screen.");
            }
        
            shapesOnScreen.add(shapeObject);
           
            return true;
        }
        catch(AssertionError error)
        {
            return false;
        }

	}
	
	/**
	 * remove all occurrences of given shape type
	 * @param type is the Shape Type
	 * @return true if all shapes are deleted else false
	 */
	public boolean removeAllShapeOfType(ShapeType type) {
	    if(type == null ) {
	        return false;
	    }
	    
	    boolean flag = false;
		for(int i = 0; i < shapesOnScreen.size(); i++) {
			if(shapesOnScreen.get(i).getShapeType() == type.toString()) {
				shapesOnScreen.remove(i);
				i--;
				flag = true;
			}
		}
		
		try
        {
            if(!flag)
                throw new AssertionError("No object of the given type!");
        }
        catch(AssertionError error)
        {
            return false;
        }
        
        return flag;
	}
	
	/**
	 * removes shape object of given type
	 * @param shapeObjectName
	 * @return true if shape is deleted else false
	 */
	public boolean deleteShape(Shape shapeObjectName) {
	    
	    try
        {
            if(shapesOnScreen.contains(shapeObjectName)) {
                shapesOnScreen.remove(shapeObjectName);
            }
            else {
                throw new AssertionError("The given shape object is not present on screen!");
            }
            
            return true;
        }
        catch(AssertionError error)
        {
            return false;
        }

	}
	
	/**
     * sorts the list of objects in ascending order according to area
     * @return sortedList
     */
    public List<Shape> sortByArea()
    {
        
        if(shapesOnScreen.size() == 0) {
            throw new AssertionError("List is empty! Cannot sort");
        }
        
        List<Shape> sortedListByArea = new ArrayList<Shape>(shapesOnScreen);
        
        Collections.sort(sortedListByArea, ShapeSort.sortByArea);
        
        return sortedListByArea;
    }
    
    /**
     * sorts the list of objects in ascending order according to perimeter
     * @return sortedList
     */
    public List<Shape> sortByPerimeter()
    {
        if(shapesOnScreen.size() == 0) {
            throw new AssertionError("List is empty! Cannot sort");
        }
        
        List<Shape> sortedListByPerimeter = new ArrayList<Shape>(shapesOnScreen);
        
        Collections.sort(sortedListByPerimeter, ShapeSort.sortByPerimeter);
        
        return sortedListByPerimeter;
    }
    
    /**
     * sorts the list of objects in ascending order according to Origin Distance
     * @return sortedList
     */
    public List<Shape> sortByOriginDistance()
    {
        if(shapesOnScreen.size() == 0) {
            throw new AssertionError("List is empty! Cannot sort");
        }
        
        List<Shape> sortedListByOriginDistance = new ArrayList<Shape>(shapesOnScreen);
        
        Collections.sort(sortedListByOriginDistance, ShapeSort.sortByOriginDistance);
        
        return sortedListByOriginDistance;
    }
    
    /**
     * sorts the list of objects in ascending order according to Origin Distance
     * @return sortedList
     */
    public List<Shape> sortByTimestamp()
    {
        if(shapesOnScreen.size() == 0) {
            throw new AssertionError("List is empty! Cannot sort");
        }
        
        return shapesOnScreen;
    }
	
}
