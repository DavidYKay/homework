/**
 * MultiDrawFunction contains many different functions which can be rendered 
 * to a plot by using the functionality in the superclass, AbstractDrawFunction
 */
public class MultiDrawFunction extends AbstractDrawFunction {

	private int funcType;

	MultiDrawFunction(int index) {
		this.funcType = index;
		//System.out.println("Function created with " + funcType);
	}

    /**
     * Changes the currently-active function
     */
	public void setFuncType(int funcType) {
        this.funcType = funcType;
	}

    /**
     * Very basic method which performs an operation, f(x) on a given x.
     *
     * Note that ALL TRIG FUNCTIONS have been scaled to make them more legible on this display
     */
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
				x = myRadians(x);
				value = 10 * ( Math.cos(x) + (5 * Math.sin(x)) );
				break;
			case 6: //5Cos(x) + Sin(x)
				x = myRadians(x);
				value = 10 * ( (5 * Math.cos(x)) + Math.sin(x) );
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
        //String out = String.format(" F(%f) = %f", x, value);
        //out = "Func: " + funcType + out;
        //System.out.println("F(" )"Value is: " + value);
        //System.out.println(out);
		return value;
	}
    private double myRadians(double x) {
        return x / 15.924;
    }
}
