
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class McCabe
{
	private String _sourceCode;

	public McCabe(String sourceCode)
	{
		this._sourceCode = sourceCode;
	}

	public final int CalculateCyclomaticComplexity()
	{
		final int numberOfConnectedComponentsCoefficient = 2;

		int numberOfGraphVertices = 0;
		int numberOfGraphArcs = 0;
		int count = 0;
		String loopsPattern = "(\\bswitch\\b)";
	
		Pattern r = Pattern.compile(loopsPattern);
		Matcher m = r.matcher(this._sourceCode);
		  while(m.find()) {
		         count++; }
		  // System.out.print(count);
		numberOfGraphVertices += count;

		loopsPattern = "(\\bcase\\b)|(\\bdefault\\b)|(\\bfor\\b)|(\\bforeach\\b)|(\\bwhile\\b)";
		Pattern r1 = Pattern.compile(loopsPattern);
		Matcher m1= r1.matcher(this._sourceCode);
		count=0;
		  while(m1.find()) {
		         count++; }
		  //System.out.print(count);
		numberOfGraphArcs += count;

		loopsPattern = "(\\bif\\b)";
		
		Pattern r2 = Pattern.compile(loopsPattern);
		Matcher m2= r2.matcher(this._sourceCode);
		count=0;
		  while(m2.find()) {
		         count++; }// System.out.print(count);
		numberOfGraphVertices += count;
		numberOfGraphArcs += 2 * count;

		numberOfGraphVertices++;
		return numberOfGraphArcs - numberOfGraphVertices + numberOfConnectedComponentsCoefficient;
	}
}
