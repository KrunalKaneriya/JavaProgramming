import com.example.series.Series;
public class Main {

    public static void main(String[] args) {
	for (int i=1;i<=10;i++) {
        System.out.println(Series.nSum(i));
    }
        System.out.println("**************************************");
	for (int i=1;i<=5;i++) {
        System.out.println(Series.factorial(i));
    }
        System.out.println("**************************************");
            Series.fibonacci(10);

    }
}
