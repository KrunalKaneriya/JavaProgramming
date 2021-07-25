class Movie {
    private String name;

    public Movie(String name) {
        this.name = name;
    }

    public String plot() {
        return "No Plot Here";
    }

    public String getName() {
        return name;
    }
}

class Jaws extends Movie {
    public Jaws() {
        super("Jaws");
    }
    @Override
    public String plot() {
        return "A Shark eats lots of people..";
    }
}

class independenceDay extends Movie {
    public independenceDay() {
        super("Independence Day");
    }
    
    @Override
    public String plot() {
        return "Aliens attempt to take over Planet Earth";
    }
}

class MazeRunner extends Movie {
    public MazeRunner() {
        super("Maze Runner");
    }

    @Override
    public String plot() {
        return "Kids try and escape a maze";
    }
}

class StarWars extends Movie {
    public StarWars() {
        super("Star Wars");
    }

    @Override
    public String plot() {
        return "Imperial Forces try to take over the Universe";
    }
}

class forgettable extends Movie {
    public forgettable() {
        super("Forgettable");
    }
    //No plot Method Override Here
}

public class Main {
    public static void main(String[] args) {
        for(int i=1; i<11;i++) {
            Movie movie = randomMovie();
            System.out.println("Movie #"  + i +
                                            "   :   " + movie.getName() + "\n" +
                                            "Plot: "+ movie.plot() + "\n");
        }
    }
    public static Movie randomMovie() {
        int randomNumber = (int)(Math.random()*5)+1;
        System.out.println("Random Number Generated was "+ randomNumber);
        switch (randomNumber) {
            case 1:
                return new Jaws();
            case 2:
                return new independenceDay();
            case 3:
                return new MazeRunner();
            case 4:
                return new StarWars();
            case 5:
                return new forgettable();
        }
        return null;
    }
}

