package lab3;

import java.util.List;

public abstract class SpecialNumber 
{
	public abstract SpecialNumber add(SpecialNumber n) throws Lab3Exception;
	public abstract SpecialNumber divideByInt(int x) throws Lab3Exception;
	
	/**
	 * Computes the average of the elements in the given list of SpecialNumber objects.
	 *
	 * @param numbers the list of SpecialNumber objects
	 * @return the average of the elements in the list
	 * @throws Lab3Exception if the list is null or empty
	 */
	public static SpecialNumber computeAverage(List<SpecialNumber> numbers) throws Lab3Exception
	{
		if ( numbers == null || numbers.size() == 0)
			throw new Lab3Exception("List cannot be empty");
		
		SpecialNumber total = numbers.get(0);
		for (int i = 1; i < numbers.size(); i++)
		{
			total = total.add(numbers.get(i));
		}
		return total.divideByInt(numbers.size());
	}
	
}
