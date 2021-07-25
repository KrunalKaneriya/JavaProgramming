import java.util.ArrayList;

public class Teams<T extends Player> implements Comparable<Teams<T>>{
    private String teamName;
    private int teamScore;
    private int won;
    private int lost;
    private int tied;
    private int played;
    private ArrayList<Player>members = new ArrayList<>();

    public Teams(String teamName) {
        this.teamName = teamName;
    }

    public boolean addPlayer(T player) {
        if(members.contains(player)) {
            System.out.println("Player is already There..");
            return false;
        }
        else {
            members.add(player);
            System.out.println("Player "+player.getPlayerName() + " Added.");
            return true;
        }
    }

    public void numPlayers() {
        System.out.println("Team " + this.teamName + " has " + this.members.size() + " Players...");
        }

    public int ranking() {
        return (won*2)+tied;
    }

    public void teamStats() {
        System.out.println("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*--*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
        System.out.println("The Score of Team " + this.teamName + " is " + ranking());
        System.out.println("The " + this.teamName + " has Played " + this.played + " matches");
        System.out.println("Won " + this.won + " matches.");
        System.out.println("Lost " + this.lost + " matches");
        System.out.println("Tied " + this.tied + " matches");
    }

    public void matchResult(Teams<T> opponent,int ourScore,int theirScore) {
        String message;
        if(ourScore>theirScore) {
            message = " beats ";
            this.won++;
        }
        else if(ourScore<theirScore) {
            message = " loses to ";
            this.lost++;
        }
        else {
            message = " Tied With ";
            this.tied++;
        }
        this.played++;
        if(opponent!=null) {
            System.out.println(this.teamName+ " message " + opponent.teamName);
            opponent.matchResult(null,theirScore,ourScore);
        }
    }

    @Override
    public int compareTo(Teams<T> team) {
        if(this.ranking() > team.ranking()) {
            System.out.println("Team " + this.teamName + " Is Better Compared to " + team.teamName);
            return -1;
        }
        else if(this.ranking()<team.ranking()) {
            System.out.println("Team " + team.teamName + " Is Better Compared to " + this.teamName);
            return 1;
        }
        else {
            return 0;
        }
    }
}
