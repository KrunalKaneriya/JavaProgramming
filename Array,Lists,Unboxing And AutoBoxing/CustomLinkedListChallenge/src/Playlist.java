import java.util.LinkedList;

public class Playlist {
    private String playlistName;
    private LinkedList<Song>playlist = new LinkedList<Song>();
    private Album album = new Album();

    public void addSongToPlaylist (Album album,String songName) {
        if(album.findSong(songName)!=null) {
            this.playlist.add(album.findSong(songName));
        }
    }

    public boolean addSongToPlaylist (String title,LinkedList<Song>playlist) {
        Song checkedSong = album.findSong(title);
        if(checkedSong!=null) {
            playlist.add(checkedSong);
            return true;
        }
        System.out.println("The song " + title + " not found in the Album.");
        return false;
    }

    public Playlist(String playlistName) {
        this.playlistName = playlistName;
        this.playlist = new LinkedList<Song>();
    }

    public String getPlaylistName() {
        return playlistName;
    }

    public void setPlaylistName(String playlistName) {
        this.playlistName = playlistName;
    }

    public LinkedList<Song> getPlaylist() {
        return playlist;
    }

    public void setPlaylist(LinkedList<Song> playlist) {
        this.playlist = playlist;
    }
}
