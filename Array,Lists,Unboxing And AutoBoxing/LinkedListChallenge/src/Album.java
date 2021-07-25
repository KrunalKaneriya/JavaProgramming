import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;

public class Album {
    private String albumName;
    ArrayList<Song>album;

    Album(String albumName) {
        this.albumName = albumName;
        this.album = new ArrayList<Song>();
    }



    public boolean addSong(String songName,double songDuration) {
        if(findSong(songName) == null) {
            album.add(new Song(songName,songDuration));
            return true;
        }
            return false;
    }

    public Song findSong(String songName) {
        for(int i=0;i<album.size();i++) {
            Song checkedSong = this.album.get(i);
            if(checkedSong.getSongName().equals(songName)) {
                return checkedSong;
            }

        }
        return null;
    }

    public String getAlbumName() {
        return albumName;
    }



}
