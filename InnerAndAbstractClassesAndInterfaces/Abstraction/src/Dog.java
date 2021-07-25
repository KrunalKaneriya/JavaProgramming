public class Dog extends Animal{
    public Dog(String name) {
        super(name);
    }

    @Override
    public void eat() {
        System.out.println("Dog Can Eat. -> Dog Class Inherited From Animal Class And An Abstract Method");

    }

    @Override
    public void breathe() {
        System.out.println("Dog Can Breathe. -> Dog Class Inherited From Animal Class And An Abstract Method");

    }
}

