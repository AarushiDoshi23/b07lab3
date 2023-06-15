package lab3;

/**
 * RationalNumber class represents a rational number with an integer numerator and an integer denominator fields.
 */
public class RationalNumber extends SpecialNumber implements Comparable<RationalNumber>
{
	int numerator;
	int denominator;
	
	/**
	 * Constructor for a RationalNumber object with given numerator and denominator.
	 *
	 * @param numerator the integer numerator of the rational number
	 * @param denominator the integer denominator of the rational number
	 * @throws Lab3Exception if denominator is 0
	 */
	public RationalNumber(int numerator, int denominator) throws Lab3Exception
	{
		if (denominator == 0 )
			throw  new Lab3Exception("Denominator cannot be zero");
		this.numerator = numerator;
		this.denominator = denominator;
	}
	
	/**
	 * Checks if calling RationalNumber object is the same as the given object.
	 *
	 * @param obj the reference object with which to compare
	 * @return false if obj argument is not of compatible type or if it is not same as the calling RationalNumber object,
	 * true otherwise
	 */
	@Override
	public boolean equals(Object obj) 
	{
		if(obj == null || !(obj instanceof RationalNumber))
			return false;
		RationalNumber other = (RationalNumber)obj;
		return ((double)this.numerator/(double)this.denominator) == ((double)other.numerator/(double)other.denominator);
	}
	
	/**
	 * Finds the greatest common divisor of given integer arguments
	 *
	 * @param num1 the first number
	 * @param num2 the second number
	 * @return the greatest common divisor of the num1 and num2
	 */
	public int GCD(int num1, int num2)
	{
		int gcd = 1;
		for(int x = 1; x <= Math.min(num1, num2); x++)
		{
			if(num1%x == 0 && num2%x == 0)
				gcd = x;
		}
		return gcd;
	}
	
	/**
	 * Returns the hash code value for the calling RationalNumber object.
	 *
	 * @return the hash code value
	 */
	@Override
	public int hashCode()
	{
		int result = 1;
		long prime = 31;
		
		int gcd = GCD(this.numerator, this.denominator);
		result = (int) (result * prime + this.numerator / gcd);
		result = (int) (result * prime + this.denominator / gcd);

		return result;
	}
	
	/**
	 * Compares magnitude of the calling object with the magnitude of the input argument RationalNumber object.
	 *
	 * @param num the RationalNumber object to be compared
	 * @return -1, 0 or 1 depending on whether calling RationalNumber is less than, equal to, or greater than the given
	 * RationalNumber, respectively
	 */
	@Override
	public int compareTo(RationalNumber num)
	{
		double callingMagnitude = (double)this.numerator/(double)this.denominator;
		double argMagnitude = (double)num.numerator/(double)num.denominator;
		return Double.compare(callingMagnitude, argMagnitude);
	}
	
	/**
	 * Adds the given RationalNumber object to calling object and returns the RationalNumber object result.
	 *
	 * @param specialNum the SpecialNumber to be added to the calling object
	 * @return the result of adding the rn RationalNumber object to calling RationalNumber object
	 * @throws Lab3Exception if specialNum is not an instance of RationalNumber
	 */
	@Override
	public SpecialNumber add(SpecialNumber specialNum) throws Lab3Exception
	{
		if(!(specialNum instanceof RationalNumber))
		{
			throw new Lab3Exception("Cannot add an incompatible type");
		}
		RationalNumber rn = (RationalNumber)specialNum;
		
		return new RationalNumber(this.numerator*rn.denominator + rn.numerator*this.denominator , this.denominator * rn.denominator);
	}
	
	/**
	 * Divides calling RationalNumber by the given integer and returns the RationalNumber object result.
	 *
	 * @param x the integer divisor
	 * @return the result of dividing the calling object RationalNumber by the divisor
	 * @throws Lab3Exception if x is zero
	 */
	@Override
	public SpecialNumber divideByInt(int x) throws Lab3Exception
	{
		if (x == 0)
			throw  new Lab3Exception("Cannot divide by zero");
		return new RationalNumber(this.numerator, this.denominator * x);
	}

}
