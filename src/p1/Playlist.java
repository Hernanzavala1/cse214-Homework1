package p1;

/**
 * The <code>Playlist</code> class implements a array of
 * <code>SongRecords</code> objects.
 * 
 *
 * @author Hernan Zavala Yanes e-mail: hernanjousezavala@hotmail.com 
 * Stony Brook ID:112408132
 *        
 **/


public class Playlist {
	/**
	 * invariants: maxSongs is the maximun capacity the playlist can hold. songs is
	 * the array that holds the songRecord objects numberOfElems is the number of
	 * songs currently in the playlist
	 * 
	 * 
	 */
	private final int maxSongs = 50;
	public SongRecord[] songs;
	private int numberOfElems;

	/**
	 * Returns an instance of <code>Playlist</code> it creates the array that will
	 * hold all of the songRecords witha maximum value of 50.
	 * 
	 */
	public Playlist() {
		songs = new SongRecord[maxSongs];
		numberOfElems = 0;
	}

	/**
	 * This method removes a SongRecord at a specific position.
	 * 
	 * @param position
	 *            The index of the songRecord within the Playlist.
	 * @return returns a boolean value indicating weather or not the process was
	 *         done.
	 */
	public boolean removeSong(int position) {
		position--;
		if (checkPosition(position)) {

			for (int i = position; i < numberOfElems - 1; i++) {
				songs[i] = songs[i + 1];
			}
			numberOfElems--;
			return true;
		}
		return false;
	}

	/**
	 * This method adds a new SongRecord at a specific position
	 * 
	 * @param song
	 *            It takes in the new SongRecord to be added.
	 * @param position
	 *            it takes in the position within the Playlist where the song is to
	 *            be added.
	 * @return it returns a boolean value indicating statue of the process.
	 */
	public boolean addSong(SongRecord song, int position) {

		if (checkCondition(position)) {
			position--;
			numberOfElems++;
			for (int i = numberOfElems - 1; i > position; i--) {
				songs[i] = songs[i - 1];

			}
			songs[position] = song;
			return true;

		} else { 
			return false;
		}
	}

	/**
	 * This checks if the position entered is valid.
	 * 
	 * @param position
	 *            The position that is to be checked for validation
	 * @return returns boolean value that indicates if position is valid or not.
	 * @exception IllegalArgumentException
	 *                Indicates that the position entered does not meet the 
	 *                requirements.
	 */

	public boolean checkPosition(int position) {
		try {
			if (position < 0 || position > numberOfElems) {
				throw new IllegalArgumentException();
			}
		} catch (IllegalArgumentException e) {
			System.out.println("Not a valid position!");
			return false;
		}
		return true;

	}

	/**
	 * This method prints a SINGLE songRecord from a desired position on playlist.
	 * 
	 * @param song
	 *            The SongRecord that is to be printed.
	 * @param position
	 *            The position of the <code>SongRecord </code>
	 */
	public void printASong(SongRecord song, int position) {

		System.out.println("Song#\t Title \t\t\t Artist \t\t Length");

		String title = song.getTitle();
		String artist = song.getArtist();
		String lenght = String.valueOf(song.getMinutes());

		if (song.getSeconds() < 10) {
			lenght += ":0" + song.getSeconds();
		} else {
			lenght += ":" + song.getSeconds();
		}

		System.out.format("%-9d%-23s%-25s%-10s\n", position, title, artist, lenght);
	}

	/**
	 * This prints out all of the <code>SongRecords</code> in the Playlist.
	 */

	public void printAllSongs() {

		System.out.println("Song#\t Title \t\t\t Artist \t\t Length");
		for (int i = 0; i < numberOfElems; i++) {

			String title = songs[i].getTitle();
			String artist = songs[i].getArtist();
			String lenght = String.valueOf(songs[i].getMinutes());

			if (songs[i].getSeconds() < 10) {
				lenght += ":0" + songs[i].getSeconds();
			} else {
				lenght += ":" + songs[i].getSeconds();
			}

			System.out.format("%-9d%-24s%-25s%-10s\n", i + 1, title, artist, lenght);

		}
	}

	/**
	 * This method checks the requirements previous to adding a
	 * <code>SongRecord</code> to the Playlist.
	 * 
	 * @param position
	 *            it is the position that is to be checked.
	 * @return returns a boolean value if the requirements are met, false otherwise.
	 * @exception IllegalArgumentException
	 *                This happens when the position entered does not meet the
	 *                requirements.
	 * @exception PlaylistFullException
	 *                This is thrown when the maximum capacity of the Playlist has
	 *                been reached.
	 * 
	 */

	private boolean checkCondition(int position) {
		// TODO Auto-generated method stub
		try {
			if (position < 1 || position > numberOfElems + 1) {
				throw new IllegalArgumentException("position is invalid!");
			} else if (numberOfElems == maxSongs) {
				throw new PlaylistFullException();

			}

		} catch (PlaylistFullException x) {
			System.out.println(x.toString());
			return false;
		} catch (IllegalArgumentException e) {
			System.out.println(e.toString());
			return false;
		}

		return true;
	}

	/**
	 * This method returns a <code>SongRecord</code> at a desired position in the
	 * Playlist.
	 * 
	 * @param position
	 *            The position where the <code>SongRecord</code> should be retrieved
	 *            from.
	 * @return It returns the <code>SongRecord</code>.
	 */
	public SongRecord getSong(int position) {
		position--;
		if (checkPosition(position)) {
			return songs[position];
		}
		return null;
	}

	/**
	 * This method returns a <code>Playlist</code> by a specific artist.
	 * 
	 * @param originalList
	 *            It takes in a <code>Playlist</code> for which it is to search for
	 *            the artist entered.
	 * @param artist
	 *            The artist for which a new <code>Playlist</code> is created.
	 * @return Returns a <code>Playlist</code> with SongRecords for the specific
	 *         artist entered.
	 */
	public static Playlist getSongsByArtist(Playlist originalList, String artist) {
		if (originalList == null) {
			return null;
		} else if (artist == null) {
			return null;
		} else {
			Playlist newPlaylist = new Playlist();
			int newPlaylistPosition = 1;
			for (int i = 1; i <= originalList.numberOfElems; i++) {
				if (artist.equalsIgnoreCase(originalList.getSong(i).getArtist()))
					newPlaylist.addSong(originalList.getSong(i), newPlaylistPosition);
			}
			return newPlaylist;
		}
	}

	/**
	 * This method checks if two objects are equal to eachother. Done by checking
	 * all of the contents in the 2 onjects.
	 * 
	 * @param obj
	 *            This is the object that is entered to be checked with a specific
	 *            <code>Playlist</code>.
	 * @return Returns a true boolean value if the 2 objects are equal, false
	 *         otherwise.
	 */
	public boolean equals(Object obj) {
		if (obj == null || !(obj instanceof Playlist)) {
			return false;
		}
		Playlist temp = (Playlist) obj;
		for (int i = 1; i <= this.numberOfElems; i++) {
			if (!this.getSong(i).equal(this.getSong(i), temp.getSong(i))) {
				return false;
			}
		}
		return true;
	}

	/**
	 * This creates an exact copy of <code>Playlist</code>. 
	 * @return
	 * it returns a <code>Playlist</code> that is equal to this object.
	 */
	public Object clone() {
		Playlist newPlaylist = new Playlist();
		for (int i = 1; i <= this.numberOfElems; i++) {
			newPlaylist.addSong(this.getSong(i), i);
		}
		return newPlaylist;
	}

	/**
	 * This returns the current size of the <code>Playlist</code>.
	 * @return
	 * returns a integer value that stands for the actual playlist size. 
	 */
	public int getSize() {
		return this.numberOfElems;
	}

}
