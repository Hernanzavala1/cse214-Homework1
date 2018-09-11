package p1;

/**This is an exception class that is thrown whenever
 * the value entered for seconds does not meet the requirements.
 * @author Hernan Zavala Yanes
 * 
 *
 */
public class WrongSecondsException extends Exception{

	public WrongSecondsException() {
		super("Seconds entered are invalid!");
	}
}
