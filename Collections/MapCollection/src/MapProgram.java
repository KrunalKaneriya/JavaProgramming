import java.util.HashMap;
import java.util.Map;

public class MapProgram {
    public static void main(String[] args) {
        Map<String,String>languages = new HashMap<>();
        if(languages.containsKey("Java")) {
            System.out.println("Java Already Added");
        } else {
            languages.put("Java","A Compiled High Level ,object oriented, platform independent language");
            System.out.println("Java Successfully Added");
        }

        languages.put("Python","Interpreted, object oriented, high level programming language with dynamic semantics");
        languages.put("Lisp","Therein Lies Madness");
        languages.put("BASIC","Beginners all purpose symbolic Instruction Code");
        languages.put("Algol","An algorithmic language");
//        System.out.println(languages.put("BASIC","Beginners all purpose symbolic Instruction Code"));
//        System.out.println(languages.put("Algol","An algorithmic language"));

//        if(languages.containsKey("Java")) {
//            System.out.println("Java Already Added");
//        } else {
//            languages.put("Java","This course is about Java");
//        }

//        languages.remove("Lisp");

//        if(languages.remove("Algol","An Family of algorihmic languages")) {
//            System.out.println("Algol Removed");
//        } else {
//            System.out.println("Cannot remove Algol. || Key Value And Pair Doesn't Matches");
//        }

        System.out.println(languages.replace("Lisp","A programming language with imperative features"));
        System.out.println(languages.replace("Lisp","A programming language with imperative features","A Program Language "));




        System.out.println("============================================");
        for(String keySet: languages.keySet()) {
            System.out.println(keySet + " " + languages.get(keySet));
        }

    }
}
