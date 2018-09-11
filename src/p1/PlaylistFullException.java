package p1;

/**	This is an exception class that is thrown 
 * whenever the maximun capacity of a <code>Playlist</code> is reached.
 * 
 * @author Hernan Zavala Yanes
 * 
 *
 */
public class PlaylistFullException extends Exception {

	
	public PlaylistFullException() {
		super("Playlist is already Full!");
	}
}
