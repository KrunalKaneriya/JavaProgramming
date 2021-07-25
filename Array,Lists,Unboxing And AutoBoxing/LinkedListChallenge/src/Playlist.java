import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;

public class Playlist {

    public boolean addToPlaylist (Album album,String songName) {
        if(album.findSong(checkedSong.getSongName()) != null) {
            playlist.add(checkedSong);
            return true;
        }
        return false;
    }

    public void printPlaylist(LinkedList<Song>songs) {
        ListIterator<Song> listiterator = songs.listIterator();
        while(listiterator.hasNext()) {
            System.out.println("The Song Name is: "+listiterator.next().getSongName());
        }
    }

    public void printSongs(ArrayList<Album> albums) {
        ArrayList<Song>songs = new ArrayList<Song>();
        for (int i=0;i<songs.size();i++) {
            System.out.println(songs.get(i).getSongName());
        }
    }
}
