public class Planet extends HeavenlyBody{
    public Planet(String name,double orbitalPeriod){
        super(name,orbitalPeriod,BodyTypes.Planet);
    }

    @Override
    public boolean addMoon(HeavenlyBody moon) {
        if(moon.getKey().getBodyType() == BodyTypes.Moon){
            return super.addMoon(moon);
        }
        return false;
    }
}
