import java.text.DecimalFormat;
public class TestResizableCircle {
	
	public static void main(String[] args) {
		
		int percent = 10;
		DecimalFormat rounding = new DecimalFormat("0.00");
		ResizableCircle resizedCircle = new ResizableCircle(100.0);
		resizedCircle.resize(percent);
		System.out.println("Perimeter of resized circle is: " + rounding.format(resizedCircle.getPerimeter()));
		System.out.println("Area of resized circle is: " + rounding.format(resizedCircle.getArea()));
	}
}
