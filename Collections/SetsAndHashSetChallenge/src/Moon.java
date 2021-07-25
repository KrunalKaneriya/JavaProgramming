public class Moon extends HeavenlyBody{

    public Moon(String name, double orbitalPeriod) {
        super(name, orbitalPeriod, BodyTypes.Moon);
    }

    @Override
    public String toString() {
       return this.getKey().getBodyType() + " : " + this.getKey().getName() + ", " + this.getOrbitalPeriod();
    }
}
