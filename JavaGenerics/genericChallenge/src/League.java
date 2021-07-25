import java.util.ArrayList;
import java.util.Collections;

public class League<T extends Teams>{
    String leagueName;

    public League(String leagueName) {
        this.leagueName = leagueName;
    }

    private ArrayList<T> league = new ArrayList<T>();

    public boolean addTeam(T team) {
        if(league.contains(team)) {
            return false;
        }
        else {
            league.add(team);
            return true;
        }
    }

    public void showLeagueTable() {
        Collections.sort(league);

    }
}
