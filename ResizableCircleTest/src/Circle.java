
public class Circle implements GeometricObject {
	
	protected double radius = 0.0;
	
	public double getPerimeter() {
		return (2 * Math.PI * radius);
	}
	
	public double getArea() {
		return (Math.PI * Math.pow(radius, 2));
	}
	
	public Circle(double radius) {
		this.radius = radius;
	}

}
