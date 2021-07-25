import java.util.HashSet;
import java.util.Set;


public final class HeavenlyBody {


    private final String name;
    private final double orbitalPeriod;
    private final Set<HeavenlyBody>satelites;

    public HeavenlyBody(String name, double orbitalPeriod) {
        this.name = name;
        this.orbitalPeriod = orbitalPeriod;
        this.satelites = new HashSet<>();
    }

    public String getName() {
        return name;
    }

    public double getOrbitalPeriod() {
        return orbitalPeriod;
    }

    public boolean addMoon(HeavenlyBody moon){
        return this.satelites.add(moon);
    }

    public Set<HeavenlyBody> getSatelites() {
        return new HashSet<>(this.satelites);
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj){
            return true;
        }
//        System.out.println("obj.getClass() is " + obj.getClass());
//        System.out.println("this.getClass() is " + this.getClass());
        if((obj == null) || obj.getClass()!=this.getClass()) {
            return false;
        }
        String objectName = ((HeavenlyBody)obj).getName();
        return this.name.equals(objectName);
    }

    @Override
    public int hashCode() {
//        System.out.println("Hashcode Called");
        return this.name.hashCode()+57;
    }
}
