import edu.duke.*;
import java.io.File;

public class PerimeterAssignmentRunner {
    public double getPerimeter (Shape s) {
        // Start with totalPerim = 0
        double totalPerim = 0.0;
        // Start wth prevPt = the last point 
        Point prevPt = s.getLastPoint();
        // For each point currPt in the shape,
        for (Point currPt : s.getPoints()) {
            // Find distance from prevPt point to currPt 
            double currDist = prevPt.distance(currPt);
            // Update totalPerim by currDist
            totalPerim = totalPerim + currDist;
            // Update prevPt to be currPt
            prevPt = currPt;
        }
        // totalPerim is the answer
        return totalPerim;
    }

    public int getNumPoints (Shape s) {
        // Put code here - Done
        // Define a counting variable
        int countNumPoints = 0;
        // Iterate over points in Shape s
        for (Point currPt : s.getPoints()){
            // Increment counter countNumPoints by 1 for each point
            countNumPoints = countNumPoints + 1;
        }
        // countNumPoints should contain the value for number of points in file
        return countNumPoints;
    }

    public double getAverageLength(Shape s) {
        // Put code here - Done
        // Since we already have getPerimeter defined, get perimeter from shape
        double totalLength = getPerimeter(s);
        // Since we already have getNumPoints defined, get number of points
        int totalPoints = getNumPoints(s);
        // Divide the two quantities to get average!
        double averageLength = totalLength / totalPoints; 
        return averageLength;
    }

    public double getLargestSide(Shape s) {
        // Put code here - Done
        // Define maxDist
        double maxDist = 0.0;
        // Get last point
        Point prevPt = s.getLastPoint();
        // Iterate over all the points 
        for (Point currPt: s.getPoints()){
            // Get distance by calling distance method
            double currDist = prevPt.distance(currPt);
            // Update maxDist by comparing the active largest value with the active iterated value
            if (currDist >= maxDist){
                maxDist = currDist;
            }
            // Update prevPt to active point
            prevPt = currPt;
        }
        return maxDist;
    }

    public double getLargestX(Shape s) {
        // Put code here - Done
        // Define maxCoordX 
        double maxCoordX = 0.0;
        for (Point currPt: s.getPoints()){
            // Get current coordinates
            double currX = currPt.getX();
            if (currX >= maxCoordX){
                maxCoordX = currX;
            }
        }
        return maxCoordX;
    }

    public double getLargestPerimeterMultipleFiles() {
        // Put code here
        // Define maxPerimeter
        double maxPerimeter = 0.0;
        // Define DirectoryResource type as dr
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            System.out.println(f);
            // Generate file resource
            FileResource fr = new FileResource(f);
            // Test is Shape is generated
            Shape s = new Shape(fr);
            if (getPerimeter(s) >= maxPerimeter){
                maxPerimeter = getPerimeter(s);
            }
            System.out.println("Perimeter = " + getPerimeter(s));
        }
        // Iterate over 
        return maxPerimeter;
    }

    public String getFileWithLargestPerimeter() {
        // Put code here
        File temp = null;    // replace this code
        double maxPerimeter = 0.0;
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()){
            FileResource fr = new FileResource(f);
            Shape s = new Shape(fr);
            if (getPerimeter(s) >= maxPerimeter){
                maxPerimeter = getPerimeter(s);
                temp = f;
            }
        }
        System.out.println("Name " + temp.getName());
        return temp.getName();
    }

    public void testPerimeter () {
        FileResource fr = new FileResource();
        System.out.println(fr);
        Shape s = new Shape(fr);
        double length = getPerimeter(s);
        System.out.println("perimeter = " + length);
        int points = getNumPoints(s);
        System.out.println("number of points = " + points);
        double averageLength = getAverageLength(s);
        System.out.println("average length = " + averageLength);
        double maxDistance = getLargestSide(s);
        System.out.println("largest side = " + maxDistance);
        double maxCoordX = getLargestX(s);
        System.out.println("largest x = " + maxCoordX);
    }
    
    public void testPerimeterMultipleFiles() {
        // Put code here
        double maxPerimeter = getLargestPerimeterMultipleFiles();
        System.out.println("largest perimeter = " + maxPerimeter);
    }

    public void testFileWithLargestPerimeter() {
        // Put code here
        String maxPerimFileName = getFileWithLargestPerimeter();
        System.out.println("file with largest perim = " + maxPerimFileName);        
    }

    // This method creates a triangle that you can use to test your other methods
    public void triangle(){
        Shape triangle = new Shape();
        triangle.addPoint(new Point(0,0));
        triangle.addPoint(new Point(6,0));
        triangle.addPoint(new Point(3,6));
        for (Point p : triangle.getPoints()){
            System.out.println(p);
        }
        double peri = getPerimeter(triangle);
        System.out.println("perimeter = "+peri);
    }

    // This method prints names of all files in a chosen folder that you can use to test your other methods
    public void printFileNames() {
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            System.out.println(f);
        }
    }

    public static void main (String[] args) {
        PerimeterAssignmentRunner pr = new PerimeterAssignmentRunner();
        //pr.testPerimeter();
        pr.testPerimeterMultipleFiles();
        pr.testFileWithLargestPerimeter();
    }
}
