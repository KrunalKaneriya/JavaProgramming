public class Main {

    public static void main(String[] args) {

//        Player player = new Player();
//        player.name = "Krunal";
//        //player.health = 20;
//        player.weapon = "Sword";
//
//        int damage = 10;
//        player.loseHealth(damage);
//        System.out.println("Remaining Health: " + player.healthRemaining());
//
//        damage = 11;
//        player.health = 200;
//        player.loseHealth(damage);
//        System.out.println("Remaining Health: " + player.healthRemaining());

        enchancedPlayer player = new enchancedPlayer("Krunal",200 ,"Sword");
        System.out.println("Initial Health is "+ player.getHealth()); // Here we cannot access the private fields directly so thats why we have to use getters
    }
}
