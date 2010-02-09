public class MultiDrawFunction extends AbstractDrawFunction {

	private int funcType;

	MultiDrawFunction(int index) {
		funcType = index;
	}

	@Override
	double f(double x) {
        double value = 0;
		switch(funcType) {
		case 0:
			value = x * x;
		case 1:
			value = Math.sin(x);
		case 2:
			value = Math.cos(x);
		case 3:
			value = Math.tan(x);
		case 4:
			value = Math.pow(x, 3);
		}
        System.out.println("Value is: " + value);
		return value;
	}
}
