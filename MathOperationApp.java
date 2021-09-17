package LambdaFunction;

@FunctionalInterface
interface IMathFunction {
	int calculate (int a, int b);
	
	static void printResult(int a, int b, String function, IMathFunction fob) {
		System.out.println( "Result of "+function+" is "+fob.calculate(a, b));
	}
}
public class MathOperationApp {
	public static void main(String[]args) {
		IMathFunction add = (int a, int b) -> a+b;
		IMathFunction subtract = (int p, int q) -> p-q;
		IMathFunction multiply = (int x, int y) -> x*y;
		IMathFunction divide = (int c, int d) -> c/d;
		
		System.out.println("Addition is: " +add.calculate(5, 7));
		System.out.println("Subtraction is: "+subtract.calculate(78, 8));
		System.out.println("Multiplication is: "+multiply.calculate(5, 8));
		System.out.println("Division is: "+divide.calculate(10, 5));
		
		IMathFunction.printResult(6,3,"addition",add);
		IMathFunction.printResult(6,3,"subtraction",subtract);
		IMathFunction.printResult(6,3,"multiplication",multiply);
		IMathFunction.printResult(6,3,"division",divide);
	}
}
