package p1;

/**This is an exception class that is thrown whenever
 * the value for minutes is negative.
 * @author Hernan Zavala Yanes
 * 
 *
 */
public class WrongMinuteException extends Exception{

	public WrongMinuteException() {
		super("Minutes cannot be Negative!");
	}
	
}
