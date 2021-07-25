import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;
public class Main {

    private static ArrayList<Album>albums = new ArrayList<>();

    private static LinkedList<Album.Songlist>playlist = new LinkedList<>();

    public static void main(String[] args) {
        Album starboy = new Album("Starboy");
        starboy.addSong("I feel it Coming",5.59);
        starboy.addSong("Party Monster",4.25);
        starboy.addSong("False Alarm",3.54);
        starboy.addSong("Reminder",4.21);
        starboy.addSong("Rockin",3.44);
        starboy.addSong("Secrets",2.59);
        starboy.addSong("True Colors",4.12);
        starboy.addSong("Starboy",4.10);


        Album revival = new Album("Revival");
        revival.addSong("Revival",4.06);
        revival.addSong("Kill em with Kindness",3.37);
        revival.addSong("Hands To Myself",3.20);
        revival.addSong("Same Old Love",3.49);
        revival.addSong("Sober",3.14);
        revival.addSong("Good For You",3.41);
        revival.addSong("Survivors",7.44);




//        myfavouritePlaylist = new Playlist("My Favourite Playlist");
//        myfavouritePlaylist.addSongToPlaylist(starboy,"I feel it Coming");
//        myfavouritePlaylist.addSongToPlaylist(starboy,"Rockin");
//        myfavouritePlaylist.addSongToPlaylist(revival,"Kill em with Kindness");
//        myfavouritePlaylist.addSongToPlaylist(starboy,"False Alarm");
//        myfavouritePlaylist.addSongToPlaylist(starboy, "Party Monster");



    }

    public static void printPlaylistSongs(LinkedList<Song> playList) {

        for (int i=0;i< playList.size();i++) {
            System.out.println("Song: " + playList.get((i)).getSongName() + " || Duration: " + playList.get(i).getSongDuration());
        }
    }


    private static void playPlaylist(LinkedList<Song>playlist) {
        boolean quit = false;
        Scanner scanner = new Scanner(System.in);
        ListIterator<Song>listIterator = playlist.listIterator();
        boolean moveForward = true;

//        if(playlist.size() == 0) {
//            System.out.println("No Songs Exist in Playlist");
//        } else {
//            System.out.println("Now Playing " + listIterator.next().toString());
//        }
        while(!quit) {
            printMenu();
            System.out.print("Enter The Choice: ");
            int choice = scanner.nextInt();
            switch(choice) {
                case 0:
                    quit = true;
                    System.out.println("Exiting.......");
                    break;
                case 1:
                    if(!moveForward){
                        if(listIterator.hasNext()) {
                            listIterator.next();    //we are checking here that if we not going forward
                            //then we need to change the direction to go forward
                        }
                        moveForward = true;
                    }
                    if(listIterator.hasNext()) {
                        System.out.println("Now Playing " + listIterator.next().toString()); }
                    else {
                        System.out.println("Reached The End of Playlist..");
                        moveForward = false;
                    }
                    break;
                case 2:
                    if(moveForward) {
                        if(listIterator.hasPrevious()) {
                            listIterator.previous();
                        }
                        moveForward = false;
                    }

                    if(listIterator.hasPrevious()) {
                        System.out.println("Now Playing " + listIterator.previous().toString());
                    } else {
                        System.out.println("Reached The Start of Playlist..");
                        moveForward = true;
                    }
                    break;
                case 3:
                    if(moveForward) {
                        if(listIterator.hasPrevious()) {
                            System.out.println("Now Replaying " + listIterator.previous().toString());
                            moveForward = false;
                        }
                        else {
                            System.out.println("We are at the start of the list.") ;
                        }
                    } else {
                        if(listIterator.hasNext()) {
                            System.out.println("Now Replaying " + listIterator.next().toString());
                            moveForward = true;
                        }
                        else {
                            System.out.println("We are at the end of the list.");
                        }
                    }
                case 4:
                    printPlaylistSongs(playlist);
                    break;
                case 5:
                    printMenu();
                    break;
                case 6:
                    if(playlist.size()>0) {
                        listIterator.remove();
                        if(listIterator.hasNext()) {
                            System.out.println("Now Playing " + listIterator.next());
                        } else if(listIterator.hasPrevious()) {
                            System.out.println("Now Playing " + listIterator.previous());
                        }
                    }
                    break;
                default:
                    System.out.println("Invalid Choice Enter Again..");
                    break;
            }
        }
    }

    public static void printMenu() {
        System.out.println("0. Exit.");
        System.out.println("1. Play Next Track.");
        System.out.println("2. Play Previous Track.");
        System.out.println("3. Print PlayList Tracks.");
        System.out.println("4. Replay The Song");
        System.out.println("5. Print the Menu");
        System.out.println("6. Remove The Song");
    }
}
