package p1;

import java.util.Scanner;

/**
 * @author Hernan Zavala Yanes
 * Stony Brook id:112408132
 * Professor: Ahmad Esmaili
 * 
 *This class serves the sole purpose of having the user test out 
 *all of the functions that are set out in the <code>Playlist</code>.
 *This runs the program in a loop and displays a menu with all of the functions
 *for the user to choose and communicate with it. 
 *
 */
public class PlaylistOperations {


	public static void main(String[] args) {
		int condition =1;
		Playlist myPlaylist = new Playlist();
		
		Scanner inp = new Scanner(System.in);
		
		while(condition == 1) {
			System.out.println("A) Add Song");
			System.out.println("B) Print Songs By Artist");
			System.out.println("G) Get Song");
			System.out.println("R) Remove Song");
			System.out.println("P) Print All Songs");
			System.out.println("S) Size");
			System.out.println("Q) Quit \n");
			
			System.out.print("Select a menu option: \n");
			String option = inp.nextLine().toUpperCase();
			
			switch(option) {
			case "A":
				System.out.print("Enter the Song title:");
				String title = inp.nextLine();
				System.out.print("Enter the song artist:");
				String artist = inp.nextLine();
				System.out.print("Enter the song lenght (minutes):");
				int minutes = inp.nextInt();
				System.out.print("Enter the song lenght (Seconds): ");
				int seconds = inp.nextInt();
				System.out.print("Enter the position:");
				int position = inp.nextInt();
				SongRecord song = new SongRecord(title, artist, minutes, seconds);
				if(myPlaylist.addSong(song, position)) {
					System.out.println("Song added: "+title+" by "+artist);
				}
				else {
					System.out.println("process could not be done!");
				}
				break;
			case "B": 
				System.out.print("Enter the name of the artist:");
				String artist1 = inp.nextLine();
			   Playlist list =myPlaylist.getSongsByArtist(myPlaylist, artist1);
			   list.printAllSongs();
				break;
			case "G":
				System.out.print("enter the postion:");
				 position = inp.nextInt();
				myPlaylist.printASong(myPlaylist.getSong(position), position);
				break;
			case "R":
				System.out.print("Enter the position:");
				position = inp.nextInt();
				if(myPlaylist.removeSong(position)) {
					System.out.println("Song removed at position "+position);
				}
				break;
			case "P":
				myPlaylist.printAllSongs();
				break;
			case "S":
			 int size =myPlaylist.getSize();
				if(size == 1) {
					System.out.println("There is 1 song in the playlist.");
				}
				else {
					System.out.println("There is "+size+" songs in the playlist.");
				}
				break;
			case "Q":
				System.out.println("Program terminating normally...");
				System.exit(-1);
				condition++;
			default:
				break;
			}
		
		}
	}
}
