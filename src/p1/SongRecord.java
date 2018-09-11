package p1;

/**
 * CSE 214 SUMMER SESSION Professor: Esmali
 * 
 * @author Hernan Zavala Yanes Stony Brook id: The <code>SongRecord</code> class
 *         is a template for a song as it requires a title, artist, and length
 *         of the song that can be instantiated.
 */

public class SongRecord {
	private String title;
	private String artist;
	private int minutes;
	private int seconds;

	/**
	 * This constructor creates an instance of <code>SongRecord</code> in
	 * concordance with the parameters entered.
	 * 
	 * @param title
	 *            String variable that holds the title of a song
	 * @param artist
	 *            String variable that holds the name of the artist.
	 * @param minutes
	 *            Integer value that holds the minutes of the song.
	 * @param seconds
	 *            Integer value that holds the seconds of the song.
	 * @exception WrongMinuteException
	 *                Indicates the minutes entered do not meet the requirements.
	 * @exception WrongSecondsException
	 *                Indicates that the seconds entered do not meet the
	 *                requirements Post-Condition An instance of this class is
	 *                created with all of the valid parameters passed.
	 */
	public SongRecord(String title, String artist, int minutes, int seconds) {
		super();
		this.title = title;
		this.artist = artist;
		try {
			if (checkMins(minutes)) {
				this.minutes = minutes;
			} else {
				throw new WrongMinuteException();

			}
		} catch (WrongMinuteException e) {
			e.toString();
		}

		try {
			if (checkSeconds(seconds)) {
				throw new WrongSecondsException();
			} else {
				this.seconds = seconds;
			}
		} catch (WrongSecondsException e) {
			e.toString();
		}
	}

	/**
	 * This method compares 2 <code>SongRecord</code> to validate if they are equal.
	 * 
	 * @param s1
	 *            This the first <code>SongRecord</code>
	 * @param s2
	 *            The second <code>SongRecord</code> that is to be compared to the
	 *            first one.
	 * @return returns a boolean value true if the content of the 2
	 *         <code>SongRecord</code> is the same, false otherwise.
	 */
	public boolean equal(SongRecord s1, SongRecord s2) {
		if (s1.getTitle().equalsIgnoreCase(s2.getTitle()) && s1.getArtist().equalsIgnoreCase(s2.getArtist())
				&& s1.getMinutes() == s2.getMinutes() && s1.getSeconds() == s2.getSeconds()) {
			return true;
		}
		return false;
	}

	/**
	 * This method checks the requirements for minutes entered.
	 * 
	 * @param minutes
	 *            Integer value that is checked
	 * @return returns true if the minutes checked are valid, false otherwise.
	 */
	private boolean checkMins(int minutes) {
		if (minutes < 0) {
			return false;
		}
		return true;
	}

	/**
	 * This method checks if seconds is a valid amount for seconds of a song.
	 * 
	 * @param seconds
	 *            Integer that holds the seconds of a song.
	 * @return returns true if the seconds are valid, false otherwise.
	 */
	private boolean checkSeconds(int seconds) {
		return seconds < 0 || seconds > 59;
	}

	/**
	 * 
	 * @return This method returns the title of the <code>SongRecord</code>
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * 
	 * @param title
	 *            This takes in a String that holds the title of the song.
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * 
	 * @return returns the artist of a <code>SongRecord</code>.
	 */
	public String getArtist() {
		return artist;
	}

	/**
	 * 
	 * @param artist
	 *            this method sets the artist for the song.
	 */
	public void setArtist(String artist) {
		this.artist = artist;
	}

	/**
	 * 
	 * @return returns the minutes of a specific song.
	 */
	public int getMinutes() {
		return minutes;
	}

	/**
	 * This method checks and sets the entered value for minutes.
	 * 
	 * @param minutes
	 *            It takes in the integer value of minutes.
	 */
	public void setMinutes(int minutes) {
		try {
			if (checkMins(minutes)) {
				this.minutes = minutes;
			} else {
				throw new WrongMinuteException();

			}
		} catch (WrongMinuteException e) {
			e.toString();
		}
	}

	/**
	 * 
	 * @return returns the integer value for seconds.
	 */
	public int getSeconds() {
		return seconds;
	}

	/**
	 * This method checks the requirements and sets the integer value of seconds.
	 * 
	 * @param takes
	 *            in integer value for seconds.
	 * 
	 */

	public void setSeconds(int seconds) {
		try {
			if (checkSeconds(seconds)) {
				throw new WrongSecondsException();
			} else {
				this.seconds = seconds;
			}
		} catch (WrongSecondsException e) {
			e.toString();
		}
	}

	/**
	 * @return returns a string representation of <code>SongRecord</code> objects.
	 */
	public String toString() {
		return artist + " " + title + "  ";
	}

}
