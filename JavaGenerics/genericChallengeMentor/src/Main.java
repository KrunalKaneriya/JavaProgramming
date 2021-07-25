public class Main {

    public static void main(String[] args) {
//	Football joe = new Football("Joe");
//	Baseball pat = new Baseball("Pat");
//	Soccer beckham = new Soccer("Beckham");
//

//
//	hawthorn.matchResult(fremantle,1,0);
//	hawthorn.matchResult(adelaideCrows,3,8);
//
//	adelaideCrows.matchResult(fremantle,2,1);
////	adelaideCrows.matchResult(baseballTeam,1,1);
////		adelaideCrows.teamStats();
////		baseballTeam.teamStats();
////		melbourne.teamStats();
////		hawthorn.teamStats();
////		fremantle.teamStats();
//		System.out.println(adelaideCrows.compareTo(melbourne));
//		System.out.println(adelaideCrows.compareTo(hawthorn));
//		System.out.println(melbourne.compareTo(adelaideCrows));
//    }
//
////    ArrayList<Team>teams;
////    Collections.sort(teams);
		League<Team<Football>>footBallLeague = new League<>("AFL");
		Team<Football> adelaideCrows = new Team<>("Adelaide Crows");
		Team<Football>melbourne = new Team<>("Melbourne");
		Team<Football>hawthorn = new Team<>("Hawthorn");
		Team<Football>fremantle = new Team<>("Fremantle");
		Team<Baseball>baseballTeam = new Team<>("Chicago Cubs");

		footBallLeague.add(adelaideCrows);
		footBallLeague.add(melbourne);
		footBallLeague.add(hawthorn);
		footBallLeague.add(fremantle);
//		footBallLeague.add(baseballTeam);


		hawthorn.matchResult(fremantle,1,0);
		hawthorn.matchResult(adelaideCrows,3,8);

		adelaideCrows.matchResult(fremantle,2,1);
		footBallLeague.showLeagueTable();
//		adelaideCrows.matchResult(baseballTeam,1,1);
	}

}

