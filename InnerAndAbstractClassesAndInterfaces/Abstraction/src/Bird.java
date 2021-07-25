public abstract  class Bird extends Animal implements CanFly{
    public Bird(String name) {
        super(name);
    }

    @Override
    public void eat() {
        System.out.println(getName() + " is Pecking");
    }

    @Override
    public void breathe() {
        System.out.println(getName() + " Breathing Bird.");
    }

    @Override
    public void fly() {
        System.out.println(getName() + " is Flapping it's Wings.");
    }
}
