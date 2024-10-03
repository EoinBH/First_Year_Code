
public class ResizableCircle extends Circle implements Resizable {
	
	public double resize(int percent) {
		double percentage = percent;
		double reduction = (1 - (percentage / 100));
		radius = radius * reduction;
		return(radius);
	}
	
	public ResizableCircle(double radius) {
		super(radius);
		this.radius = radius;
	}

}
