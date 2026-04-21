import java.util.*;
class Point {
    int x, y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
class Line implements Comparable<Line> {
    Point p1, p2;
    Line(Point p1, Point p2) {
        this.p1 = p1;
        this.p2 = p2;
    }
    public double length() {
        return Math.sqrt(Math.pow(p2.x - p1.x, 2) +
                Math.pow(p2.y - p1.y, 2));
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Line)) return false;

        Line l = (Line) obj;
        return Double.compare(this.length(), l.length()) == 0;
    }
    @Override
    public int compareTo(Line l) {
        return Double.compare(this.length(), l.length());
    }
}
public class Day8Assignment2 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter x1 y1 x2 y2 for Line 1:");
        Point p1 = new Point(sc.nextInt(), sc.nextInt());
        Point p2 = new Point(sc.nextInt(), sc.nextInt());
        System.out.println("Enter x1 y1 x2 y2 for Line 2:");
        Point p3 = new Point(sc.nextInt(), sc.nextInt());
        Point p4 = new Point(sc.nextInt(), sc.nextInt());
        Line line1 = new Line(p1, p2);
        Line line2 = new Line(p3, p4);
        System.out.println("Length of Line 1: " + line1.length());
        System.out.println("Length of Line 2: " + line2.length());
        if (line1.equals(line2)) {
            System.out.println("Lines are equal");
        } else {
            System.out.println("Lines are not equal");
        }
        int result = line1.compareTo(line2);

        if (result > 0) {
            System.out.println("Line 1 is longer");
        } else if (result < 0) {
            System.out.println("Line 2 is longer");
        } else {
            System.out.println("Both lines are equal");
        }
    }
}