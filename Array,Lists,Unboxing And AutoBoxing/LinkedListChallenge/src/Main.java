// Create a program that implements a playlist for songs
// Create a Song class having Title and Duration for a song.
// The program will have an Album class containing a list of songs.
// The albums will be stored in an ArrayList
// Songs from different albums can be added to the playlist and will appear in the list in the order
// they are added.
// Once the songs have been added to the playlist, create a menu of options to:-
// Quit,Skip forward to the next song, skip backwards to a previous song.  Replay the current song.
// List the songs in the playlist
// A song must exist in an album before it can be added to the playlist (so you can only play songs that
// you own).
// Hint:  To replay a song, consider what happened when we went back and forth from a city before we
// started tracking the direction we were going.
// As an optional extra, provide an option to remove the current song from the playlist
// (hint: listIterator.remove()

import java.util.ArrayList;
import java.util.LinkedList;

public class Main {

	public static ArrayList<Album>albums = new ArrayList<>();

    public static void main(String[] args) {
	Album a1 = new Album("Starboy");
	a1.addSong("One Love",5.35);
	a1.addSong("Starboy",4.25);
	a1.addSong("I Feel It Coming",5.19);
	a1.addSong("Party Favour",3.59);
	LinkedList<Album> albumLinkedList = new LinkedList<Album>();
	albums.add(a1);

	LinkedList<Song>playlist = new LinkedList<>();
	albums.get(0).addToPlaylist("One Love",playlist);
	albums.get(0).addToPlaylist("Starboy",playlist);
	albums.get(0).addToPlaylist("I Feel It Coming",playlist);

	albums.get(0).printPlaylist(playlist);
    }

	public void printAlbum(ArrayList<Album>albums) {
		for(int i=0;i<albums.size();i++) {
			System.out.println(albums.get(i).getAlbumName());
			System.out.println(albums.get(i).getArtistName());
		}
	}
}
