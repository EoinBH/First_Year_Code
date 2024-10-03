import java.text.DecimalFormat;
public class TestCircle {
	
	public static void main(String[] args) {
		
		DecimalFormat rounding = new DecimalFormat("0.00");
		Circle circle = new Circle(100.0);
		System.out.println("Perimeter of circle is: " + rounding.format(circle.getPerimeter()));
		System.out.println("Area of circle is: " + rounding.format(circle.getArea()));
	}

}
