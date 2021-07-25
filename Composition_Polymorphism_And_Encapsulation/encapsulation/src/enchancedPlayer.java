public class enchancedPlayer {
    private String name;
    private int hitpoints = 100;  //Here we have given default value of field
    private String weapon;

    public enchancedPlayer(String name, int health, String weapon) {
        this.name = name;
        if(health >0 && health <=100) {
            this.hitpoints = health;                   //We are doing validation that the
                                                            //values accepted for health is between 1 And 100 Only.
        }
        this.weapon = weapon;
    }

    public void loseHealth(int damage) {
        this.hitpoints = this.hitpoints - damage;
        if(this.hitpoints <= 0) {
            System.out.println("Player Knocked Out..");
            //Reduce Number of Lives Of Remaining Player.
        }
    }

    public int getHealth() {
        return hitpoints;
    }
}
