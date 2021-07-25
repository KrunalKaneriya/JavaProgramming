import java.util.HashSet;
import java.util.Set;

public abstract class HeavenlyBody {
    private final Key key;
    private final double orbitalPeriod;
    public final Set<HeavenlyBody>satelites;

    public enum BodyTypes{
        Planet,
        Star,
        Comet,
        Asteroid,
        Dward_Planet,
        Moon
    }
    public HeavenlyBody(String name, double orbitalPeriod,BodyTypes bodyType) {
        this.key =new Key(name,bodyType);
        this.orbitalPeriod = orbitalPeriod;
        this.satelites = new HashSet<>();
    }

    public double getOrbitalPeriod() {
        return orbitalPeriod;
    }

    public Set<HeavenlyBody> getSatelites() {
        return new HashSet<>(this.satelites);
    }

    public boolean addMoon(HeavenlyBody moon){
        return this.satelites.add(moon);
    }

    public Key getKey() {
        return key;
    }

    @Override
    public int hashCode() {
        return this.key.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj){
            return true;
        }

        if(obj instanceof HeavenlyBody){
            HeavenlyBody objectPassed = (HeavenlyBody)obj;
            return this.key.equals(objectPassed.getKey());
        }
        return false;
    }

    public static Key makeKey(String name,BodyTypes bodyType){
        return new Key(name,bodyType);
    }

    @Override
    public String toString() {
        return this.key.name + ": " + this.key.bodyType + ", " + this.orbitalPeriod;
    }

    public static final class Key{
        private String name;
        private BodyTypes bodyType;

        private Key(String name,BodyTypes bodyType){
            this.name= name;
            this.bodyType = bodyType;
        }

        public String getName() {
            return name;
        }

        public BodyTypes getBodyType() {
            return bodyType;
        }

        @Override
        public int hashCode() {
            return this.name.hashCode() + 57 + this.bodyType.hashCode();
        }

        @Override
        public boolean equals(Object obj) {
            Key key = (Key)obj;
            if(this.name.equals(key.getName())) {
                return this.bodyType == key.getBodyType();
            }
            return false;
        }

        @Override
        public String toString(){
            return this.name + ": " + this.bodyType;
        }
    }
}
