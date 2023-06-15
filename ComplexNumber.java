package lab3;
public class ComplexNumber extends SpecialNumber implements Comparable<ComplexNumber>
{
	double real;
	double imaginary;
	public ComplexNumber(double real, double imaginary)
	{
		this.real = real;
		this.imaginary = imaginary;
	}
	
	@Override
	public boolean equals(Object obj) 
	{
		if(obj == null || !(obj instanceof ComplexNumber))
			return false;
		ComplexNumber other = (ComplexNumber)obj;
		return (this.real == other.real) && (this.imaginary == other.imaginary);
	}
	
	@Override
	public int hashCode()
	{
		int prime1 = 1;
		long prime2 = 31;

		int result = (int) ( this.real* prime1 + this.imaginary*prime2);

		return result;
	}
	
	@Override
	public int compareTo(ComplexNumber num)
	{
		double callingMagnitude = Math.sqrt(Math.pow(this.imaginary,2) + Math.pow(this.real,2));
		double argMagnitude = Math.sqrt(Math.pow(num.imaginary,2) + Math.pow(num.real,2));
		return Double.compare(callingMagnitude, argMagnitude);
	}
	
	@Override
	public SpecialNumber add(SpecialNumber specialNum) throws Lab3Exception
	{
		if(!(specialNum instanceof ComplexNumber))
		{
			throw new Lab3Exception("Cannot add an incompatible type");
		}
		ComplexNumber cn = (ComplexNumber)specialNum;
		return new ComplexNumber(this.real + cn.real, this.imaginary + cn.imaginary);
			
	}
	
	@Override
	public SpecialNumber divideByInt(int x) throws Lab3Exception
	{
		if ( x == 0 )
			throw  new Lab3Exception("Cannot divide by zero");
		return new ComplexNumber((double)this.real / x, (double)this.imaginary / x);
	}

}
