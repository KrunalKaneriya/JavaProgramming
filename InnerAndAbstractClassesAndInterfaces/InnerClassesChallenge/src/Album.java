import java.util.ArrayList;
import java.util.LinkedList;

public class Album {
    private String albumName;
    private Songlist songs;
    private LinkedList<Song> playlist = new LinkedList<Song>();
    private String playlistName;

    public Album(String albumName) {
        this.albumName = albumName;
        this.songs = new Songlist();
    }

    public Album() {

    }

    public boolean addSong(String title,double duration) {
        return this.songs.add(new Song(title,duration));
    }



    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

//    public ArrayList<Song> getAlbumOfSongs() {
//        return albumOfSongs;
//    }

//    public void setAlbumOfSongs(ArrayList<Song> albumOfSongs) {
//        this.albumOfSongs = albumOfSongs;
//    }

    public boolean addSongToPlaylist (String title, LinkedList<Song>playlist) {
        Song checkedSong = songs.findsong(title);
        if(checkedSong!=null) {
            playlist.add(checkedSong);
            return true;
        }
        System.out.println("The song " + title + " not found in the Album.");
        return false;
    }

    public class Songlist {
        private ArrayList<Song>songs;

        public Songlist() {
            ArrayList<Song> songs = new ArrayList<Song>();
        }

        public boolean add(Song song) {
            if(songs.contains(song)) {
                System.out.println("Song Already Added...");
                return false;

            }
            this.songs.add(song);
            System.out.println("Song "+ song.getSongName() + " Added..");
            return true;
        }

        public Song findsong(String title) {
            for(Song checkedsong : songs) {
                if(checkedsong.getSongName().equals(title))
                    return checkedsong;
            }
            return null;
        }



    }
}

