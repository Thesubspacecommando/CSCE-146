/*
 * James E
 */
import java.awt.*;
import javax.swing.*;
@SuppressWarnings("serial")
public class SerpTriangle extends Canvas {

	public static void main(String[] args) {
		//sets up the window for the drawing
		JFrame frame = new JFrame("S Triangle");
		frame.setSize(800, 800);
		SerpTriangle st = new SerpTriangle();
		frame.add(st);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void paint(Graphics g) {
		//Starting triangle
		Point p1 = new Point(0,this.getHeight());
		Point p2 = new Point(this.getWidth()/2,0);
		Point p3 = new Point(this.getWidth(),this.getHeight());
		Polygon tri = new Polygon();
		tri.addPoint(p1.x, p1.y);
		tri.addPoint(p2.x, p2.y);
		tri.addPoint(p3.x, p3.y);
		g.fillPolygon(tri);
		g.setColor(getBackground());
		drawTriangle(p1, p2, p3, this.getSize().height, g); 
	}
	
	public void drawTriangle(Point p1, Point p2, Point p3, int size, Graphics g) {
		int sub = size/3;
		Point p4 = midP(p1,p2);
		Point p5 = midP(p2,p3);
		Point p6 = midP(p1,p3);
		Polygon mTri = new Polygon();
		mTri.addPoint(p4.x, p4.y);
		mTri.addPoint(p5.x, p5.y);
		mTri.addPoint(p6.x, p6.y);
		g.fillPolygon(mTri);
		if(size >= 3) {
			drawTriangle(p1,p4, p6, sub, g); //bottom left side
			drawTriangle(p6, p5, p3, sub, g); //bottom right side
			drawTriangle(p4, p2, p5, sub, g); //top
			
		}
	}
	//Method that gets the midpoint between a line segment
	private Point midP(Point p1, Point p2) {
		return new Point((p1.x + p2.x)/2, (p1.y + p2.y)/2);
	}

}
