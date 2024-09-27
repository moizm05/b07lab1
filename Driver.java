import java.io.File;
import java.io.IOException;
//Driver File
public class Driver {
    public static void main(String[] args) {
        try {
            Polynomial p = new Polynomial();
            System.out.println("p(3) = " + p.evaluate(3));

            double[] c1 = {6, 5};
            int[] e1 = {0, 3};
            Polynomial p1 = new Polynomial(c1, e1);

            double[] c2 = {-2, -9};
            int[] e2 = {1, 4};
            Polynomial p2 = new Polynomial(c2, e2);
            
            Polynomial s = p1.add(p2);
            System.out.println("s(0.1) = " + s.evaluate(0.1));

            if (s.hasRoot(1)) {
                System.out.println("1 is a root of s");
            } else {
                System.out.println("1 is not a root of s");
            }

            Polynomial product = p1.multiply(p2);
            System.out.println("p1 * p2 evaluated at 2 = " + product.evaluate(2));

            File polyFile = new File("labs/b07lab1/polynomial.txt");

            Polynomial pFromFile = new Polynomial(polyFile);
            System.out.println("pFromFile(2) = " + pFromFile.evaluate(2));

            s.saveToFile("output_polynomial.txt");
            System.out.println("Polynomial 's' saved to output_polynomial.txt");

        } catch (IOException e) {
            System.out.println("An error occurred while working with files: " + e.getMessage());
        }
    }
}
