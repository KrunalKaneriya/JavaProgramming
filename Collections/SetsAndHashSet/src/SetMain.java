import com.sun.security.jgss.GSSUtil;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SetMain {
    public static void main(String[] args) {
        Set<Integer>squares = new HashSet<>();
        Set<Integer>cubes = new HashSet<>();

        for(int i=1;i<=100;i++){
            squares.add(i*i);
            cubes.add(i*i*i);
        }

        System.out.println("There are " + squares.size() + " Squares and " + cubes.size() + " Cubes");
        Set<Integer>union = new HashSet<>(squares);

        union.addAll(cubes);
        System.out.println("Union Contains " + union.size());

        Set<Integer>intersection = new HashSet<>(squares);
        intersection.retainAll(cubes);
        System.out.println("Intersection Contains " + intersection.size());

        for(int i:intersection){
            System.out.println(i + " is the square of " + Math.sqrt(i) + " And a Cube of " + Math.cbrt(i));
        }

        Set<String>words= new HashSet<>();
        String sentence = "one day in the year of the fox";
        String []arrayWords = sentence.split(" ");
        words.addAll(Arrays.asList(arrayWords));
        System.out.println(Arrays.asList(arrayWords));
//        for(String s:words){
//            System.out.println(s);
//        }

        Set<String>nature = new HashSet<>();
        Set<String>divine = new HashSet<>();
        String[] natureWords = {"all","nature","is","but","unknown","to","thee"};
        String[] divineWords = {"to","err","is","human","to","forgive","divine"};
        nature.addAll(Arrays.asList(natureWords));
        divine.addAll(Arrays.asList(divineWords));

        System.out.println("nature - divine");
        Set<String>diff1 = new HashSet<>(nature);
        diff1.removeAll(divine);
        printSet(diff1);

        System.out.println("divine - nature");
        Set<String>diff2 = new HashSet<>(divine);
        diff2.removeAll(nature);
        printSet(diff2);

        Set<String>unionTest = new HashSet<>(nature);
        unionTest.addAll(divine);
        Set<String>intersectionTest = new HashSet<>(nature);
        intersectionTest.retainAll(divine);

        //Symmetric Difference
        System.out.println("Symmetric Difference");
        unionTest.removeAll(intersectionTest);
        printSet(unionTest);

        printSet(intersectionTest);
        if(nature.containsAll(divine)){
            System.out.println("Divine is a subset of nature");
        }

        if(nature.containsAll(intersectionTest)) {
            System.out.println("Intersection is a subset of nature");
        }
        if(divine.containsAll(intersectionTest)){
            System.out.println("Intersection is a subset of divine");
        }
    }
    private static void printSet(Set<String>object){
        System.out.print("\t");
        for(String s:object){
            System.out.print(s + " ");
        }
        System.out.println();
    }
}
