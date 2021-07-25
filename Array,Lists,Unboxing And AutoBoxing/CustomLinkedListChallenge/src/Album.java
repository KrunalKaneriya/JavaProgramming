import java.util.ArrayList;

public class Album {
    private String albumName;
    private ArrayList<Song> albumOfSongs;

    public Album(String albumName) {
        this.albumName = albumName;
        this.albumOfSongs = new ArrayList<Song>();
    }

    public Album() {

    }

    public boolean addSong(String title,double duration) {
        if(findSong(title) == null) {
            this.albumOfSongs.add(new Song(title, duration));
            return true;
        }
        return false;
    }

    public Song findSong(String title) {
//        for (int i=0;i<albumOfSongs.size();i++) {
//            Song checkedSong = albumOfSongs.get(i);
            for(Song checkedSong:albumOfSongs)
            if(checkedSong.getSongName().equals(title)) {
                return checkedSong;
            }
        return null;
        }


    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    public ArrayList<Song> getAlbumOfSongs() {
        return albumOfSongs;
    }

    public void setAlbumOfSongs(ArrayList<Song> albumOfSongs) {
        this.albumOfSongs = albumOfSongs;
    }
}
