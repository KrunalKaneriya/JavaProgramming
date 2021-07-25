import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Main {

    public static void main(String[] args) {
	Football joe = new Football("Joe");
	Baseball pat = new Baseball("Pat");
	Soccer beckham = new Soccer("Beckham");

	Team<Football> adelaideCrows = new Team<>("Adelaide Crows");
	adelaideCrows.addPlayer(joe);
//	adelaideCrows.addPlayer(pat);
//	adelaideCrows.addPlayer(beckham);
	Team<Baseball> baseballTeam = new Team<>("Chicago Cubs");
	baseballTeam.addPlayer(pat);

	Team<Football>melbourne = new Team<>("Melbourne");
	Football banks = new Football("Gordon");
	melbourne.addPlayer(banks);

	Team<Football>hawthorn = new Team<>("Hawthorn");
	Team<Football>fremantle = new Team<>("Fremantle");

	hawthorn.matchResult(fremantle,1,0);
	hawthorn.matchResult(adelaideCrows,3,8);

	adelaideCrows.matchResult(fremantle,2,1);
//	adelaideCrows.matchResult(baseballTeam,1,1);
//		adelaideCrows.teamStats();
//		baseballTeam.teamStats();
//		melbourne.teamStats();
//		hawthorn.teamStats();
//		fremantle.teamStats();
		System.out.println(adelaideCrows.compareTo(melbourne));
		System.out.println(adelaideCrows.compareTo(hawthorn));
		System.out.println(melbourne.compareTo(adelaideCrows));
    }

//    ArrayList<Team>teams;
//    Collections.sort(teams);
}
