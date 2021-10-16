package stringCalculatorKata;
import org.junit.*;
import static org.junit.Assert.*;
public class CalculatorTest {
	
	StringCalculator stringcalculator = new StringCalculator();

	@Test
	public void returnZeroOnEmptyString()
	{
		assertEquals(0, stringcalculator.Add(""));
	}
	
	@Test
	public void returnNumOnSingleArg()
	{
		assertEquals(1, stringcalculator.Add("1"));
	}
	
	@Test
	public void returnSumOnTwoArgsDelimitedByComma()
	{
		assertEquals(3, stringcalculator.Add("1,2"));
	}
	
	@Test
	public void returnSumOnMultipleArgsDelimitedByComma()
	{
		assertEquals(6, stringcalculator.Add("1,2,3"));
	}

	@Test
	public void acceptNewlineAsValidDelimiter()
	{
		assertEquals(6, stringcalculator.Add("1\n2,3"));
	}
	
	@Test
	public void customDelimeter()
	{
		assertEquals(3, stringcalculator.Add("//;\n1;2"));
	}
	
	@Test
	public void raiseExceptionOnNegativeNumbers()
	{
		try {
			stringcalculator.Add("-1,-2,3");
			fail("Exception expected.");
		}
		
		catch(RuntimeException e)
		{
			assertEquals("Negatives not allowed: [-1, -2]", e.getMessage());
		}
	}
	
	@Test
	public void ignoreNumsGrtThn1000()
	{
		assertEquals(2, stringcalculator.Add("2,1001"));
	}
	
	@Test
	public void validateAnyLengthDelimeter()
	{
		assertEquals(6, stringcalculator.Add("//[***]\n1***2***3"));
	}
	
	@Test
	public void multipleDelimeter()
	{
		assertEquals(6, stringcalculator.Add("//[*][%]\n1*2%3"));
	}
	
	@Test
	public void mulCustomDelWithAnyLength()
	{
		assertEquals(6, stringcalculator.Add("//[**][%%]\n1**2%%3"));
	}
	
	@Test
	public void validateCallCount()
	{
		assertEquals(StringCalculator.getCallCount(), StringCalculator.count);
	}

}
