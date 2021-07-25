public class Main {
    public static void main(String []args) {
        Animal dog = new Dog("Yorkie");
        dog.breathe();
        dog.eat();

        Bird parrot = new Parrot("Australian Ring neck");
        parrot.eat();
        parrot.breathe();
        parrot.fly();

        Bird penguin = new Penguin("Emperor Penguin");
        penguin.eat();
        penguin.breathe();
        penguin.fly();
    }
}