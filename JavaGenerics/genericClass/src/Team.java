import java.util.ArrayList;

public class Team<T extends Player> implements Comparable<Team<T>>{
    private String name;
    int played=0;
    int won=0;
    int lost=0;
    int tied=0;

    private ArrayList<T>members = new ArrayList<>();

    public Team(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean addPlayer(T player) {
        if (members.contains(player)) {
            System.out.println(player.getName() + " is already on this team");
            return false;
        }
        else {
            members.add(player);
            System.out.println(player.getName() + " picked for team " + this.name);
            return true;
        }
    }

    public void numPlayers() {
        System.out.println("Team: " + this.name + " Has " + members.size() + " Players");

    }

    public void matchResult(Team<T> opponent,int ourScore,int theirScore) {
        String message;
        if(ourScore>theirScore) {
            won++;
            message = " beat ";
        } else if(ourScore == theirScore) {
            tied++;
            message = " drew with ";
        } else {
            lost++;
            message = " lost to ";
        }
        played++;
        if(opponent!=null) {
            System.out.println(this.getName() + message + opponent.getName());
            opponent.matchResult(null,theirScore,ourScore);
        }
    }

    public int ranking() {
        return (won*2)+tied;
    }

    public void teamStats() {
        System.out.println("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*--*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
        System.out.println("The Score of Team " + this.name + " is " + ranking());
        System.out.println("The " + this.name + " has Played " + this.played + " matches");
        System.out.println("Won " + this.won + " matches.");
        System.out.println("Lost " + this.lost + " matches");
        System.out.println("Tied " + this.tied + " matches");

    }

    @Override
    public int compareTo(Team<T> team) {
        if(this.ranking() > team.ranking()) {
            System.out.println("Team " + this.name + " Is Better Compared to " + team.name);
            return -1;
        }
        else if(this.ranking()<team.ranking()) {
            System.out.println("Team " + team.name + " Is Better Compared to " + this.name);

            return 1;
        }
        else {
            return 0;
        }

    }
}
