public class MultiDrawFunction extends AbstractDrawFunction {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6178082773934931639L;
	private int funcType;

	public void setFuncType(int funcType) {
        this.funcType = funcType;
	}

	MultiDrawFunction(int index) {
		this.funcType = index;
//		drawFunction();
		System.out.println("Function created with " + funcType);
	}

	@Override
	double f(double x) {
        double value = 0;
		switch(funcType) {
		
			case 0: //X^2
				value = x * x;
				break;
			case 1: //Sin(x)
				value = 100 * Math.sin(myRadians(x));
				break;
			case 2: //Cos(x)
				value = 100 * Math.cos(myRadians(x));
				break;
			case 3: //Tan(x)
				value = 100 * Math.tan(myRadians(x));
				break;
			case 4: //X^3
				value = Math.pow(x, 3);
				break;
			case 5: //Cos(x) + 5Sin(x)
				value = Math.cos(x) + (5 * Math.sin(x));
				break;
			case 6: //5Cos(x) + Sin(x)
				value = (5 * Math.cos(x)) + Math.sin(x);
				break;
			case 7: //Log(x) + X^2
				value = Math.log10(x) +  (x * x);
				break;
			case 8: //X
				value = x;
				break;

			default:
				value = x;
			
		}
        String out = String.format(" F(%f) = %f", x, value);
        out = "Func: " + funcType + out;
        //System.out.println("F(" )"Value is: " + value);
        System.out.println(out);
		return value;
	}
    private double myRadians(double x) {
        return x / 15.924;
    }
}
