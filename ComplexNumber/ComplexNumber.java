
public class ComplexNumber {
	
	public double x;
	public double y;
	
	public ComplexNumber()
	{
		x = y = 0;
	}
	
	public ComplexNumber(double realPart, double imaginaryPart)
	{
		x = realPart;
		y = imaginaryPart;
	}
	
	public static ComplexNumber add(ComplexNumber num1, ComplexNumber num2)
	{
		ComplexNumber temp = new ComplexNumber(num1.x + num2.x, num1.y + num2.y);
		return temp;
	}
	
	public static ComplexNumber multiply(ComplexNumber num1, ComplexNumber num2)
	{
		ComplexNumber temp = new ComplexNumber(((num1.x * num2.x) - (num1.y * num2.y)), ((num1.x * num2.y) + (num1.y * num2.x)) );
		return temp;
	}
	
	public static ComplexNumber divide(ComplexNumber num1, ComplexNumber num2)
	{
		ComplexNumber temp = new ComplexNumber((((num1.x * num2.x) + (num1.y * num2.y)) / (Math.pow(num2.x, 2) + Math.pow(num2.y, 2))),
				(((num1.y * num2.x) - (num1.x * num2.y)) / (Math.pow(num2.x, 2) + Math.pow(num2.y, 2))));
		return temp;
	}
	
	public String toString()
	{
		String output = ("Answer = " + x + ", " + y + "i");
		return output;
	}
	
	public static void main(String[] args)
	{
		ComplexNumber num1 = new ComplexNumber(3.67, 9.1);	//Test Values
		ComplexNumber num2 = new ComplexNumber(2.5, 6.42);	//Test Values
		
		ComplexNumber total = ComplexNumber.add(num1, num2);
		System.out.println(total.toString());
		
		total = ComplexNumber.multiply(num1, num2);
		System.out.println(total.toString());
		
		total = ComplexNumber.divide(num1, num2);
		System.out.println(total.toString());
	}
}
