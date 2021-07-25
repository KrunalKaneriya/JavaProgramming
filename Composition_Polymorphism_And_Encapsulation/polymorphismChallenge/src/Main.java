public class Main {

    public static void main(String[] args) {
        nano tatanano = new nano(2,"Tata Nano");
        System.out.println(tatanano.getName());
        tatanano.acclerate(50);
        tatanano.acclerate(20);
        tatanano.startEngine();
        tatanano.breaking(60);

        System.out.println("*************************************************************\n");
        lamborghini lambo = new lamborghini(6,"Lamborghini Delta");
        System.out.println(lambo.getName());
        lambo.startEngine();
        lambo.acclerate(200);
        lambo.breaking(50);
        lambo.breaking(80);
        lambo.startEngine();

        System.out.println("*************************************************************\n");

        bentley Bentley = new bentley(3,"Bentley");
        Bentley.startEngine();
        Bentley.acclerate(200);
        Bentley.breaking(120);
        Bentley.startEngine();

    }
}

class bentley extends Car {
    public bentley(int cylinders,String name) {
        super(cylinders, name);
    }

    @Override
    public void startEngine() {
        System.out.println("Bentley --> StartEngine()");
        super.startEngine();
    }

    @Override
    public int acclerate (int throttle) {
        System.out.println("Bentley -->Acclerate()");
        return super.acclerate(throttle);
    }

    @Override
    public int breaking (int throttle) {
        System.out.println("Bentley -->Breaking()");
        return super.breaking(throttle);
    }
}

class nano extends Car{
    public nano(int cylinders, String name) {
        super(cylinders, name);
    }
    @Override
    public void startEngine() {
        System.out.println("Tata Nano --> StartEngine()");
        super.startEngine();
    }

    @Override
    public int acclerate(int throttle) {
        System.out.println("Tata Nano --> Acclerate()");
        return super.acclerate(throttle);
    }

    @Override
    public int breaking(int throttle) {
        System.out.println("Tata Nano --> Breaking()");
        return super.breaking(throttle);
    }


}

class lamborghini extends Car {
    public lamborghini (int cylinders,String name) {
        super(cylinders,name);
    }
    @Override
    public int breaking(int throttle) {
        System.out.println("Lamborghini --> Breaking()");
        return super.breaking(throttle);
    }
    @Override
    public int acclerate (int throttle) {
        System.out.println("Lamborghini --> Acclerate()");
        return super.acclerate(throttle);
    }

    @Override
    public void startEngine() {
        System.out.println("Lamborghini --> startEngine()");
        super.startEngine();
    }

}

class Car {
    private boolean engine;
    private int cylinders;
    private int wheels;
    private String name;
    private int acclerate;
    private int breaking = 0;

    public Car(int cylinders,String name) {
        this.engine = true;
        this.cylinders = cylinders;
        this.wheels = 4;
        this.name = name;
    }

    public int getCylinders() {
        return cylinders;
    }

    public int getWheels() {
        return wheels;
    }

    public String getName() {
        return name;
    }

    public boolean isEngine() {
        return engine;
    }

    public void startEngine() {
        System.out.println("The Engine Mode Of Car is: "+this.engine);
        if(isEngine()) {
            this.engine = false;
        }
        else {
            this.engine = true;
        }
        System.out.println("Now The Engine Mode Of Car Is Changed To: "+this.engine);
    }

    public int acclerate(int throttle) {
        System.out.println("The Function is Called For Car "+ getClass().getSimpleName());

        System.out.println("The Initial Speed Was "+ this.acclerate + " And Now It is Increased To "+ throttle);
        this.acclerate+=throttle;
        return throttle;
        }

        public int breaking(int throttle) {
            System.out.println("The Function is Called For Car "+ this.name);
            this.breaking = this.acclerate;
            this.breaking-=throttle;
            System.out.println("The Speed Was " + this.acclerate + " And Now The Speed Is Decreased To " + this.breaking);
            return breaking;
    }
}