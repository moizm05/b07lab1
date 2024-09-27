import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
public class Polynomial{
    //Polynomial File
    private double [] coefficients;
    private int [] exponents;

    public Polynomial(){
        this.coefficients = new double[] {0};
        this.exponents = new int[] {0};
    }
    public Polynomial(double[] coefficients, int[] exponents){
        this.coefficients = coefficients;
        this.exponents = exponents;
    }

    public Polynomial add(Polynomial poly){
        int length = Math.max(this.coefficients.length, poly.coefficients.length);
        double[] resultCoeff = new double[length];
        int [] resultExp = new int[length];
        int i = 0, j = 0, k = 0;
        while(i < this.coefficients.length && j < poly.coefficients.length){
            if(this.exponents[i] == poly.exponents[j]){
                resultCoeff[k] = this.coefficients[i] + poly.coefficients[j];
                resultExp[k] = this.exponents[i];
                i++;
                j++;
            }
            else if(this.exponents[i] < poly.exponents[j]){
                resultCoeff[k] = this.coefficients[i];
                resultExp[k] = this.exponents[i];
                i++;
            }
            else{
                resultCoeff[k] = poly.coefficients[j];
                resultExp[k] = poly.exponents[j];
                j++;
            }
            k++;
        }

        while(i < this.coefficients.length){
            resultCoeff[k] = this.coefficients[i];
            resultExp[k] = this.exponents[i];
            i++;
            k++;
        }
        while(j < poly.coefficients.length){
            resultCoeff[k] = this.coefficients[j];
            resultExp[k] = this.exponents[j];
            j++;
            k++;
        }
        return new Polynomial(resultCoeff, resultExp);
    }

    public Polynomial multiply(Polynomial poly){
        int length = this.coefficients.length*poly.coefficients.length;
        double [] resultCoeff = new double[length];
        int [] resultExp = new int[length];
        int k = 0;
        for(int i = 0; i < this.coefficients.length; i++){
            for(int j = 0; j < poly.coefficients.length; j++){
                double coeff = this.coefficients[i] * poly.coefficients[j];
                int exp = this.exponents[i] + poly.exponents[j];

                int index = findExponent(resultExp, exp);
                if(index != -1){
                    resultExp[index] += coeff;
                }
                else{
                    resultCoeff[k] = coeff;
                    resultExp[k] = exp;
                    k++;
                }
            }
        }

        double [] finalCoeff = new double[k];
        int [] finalExp = new int[k];
        for(int i = 0; i < k; i++){
            finalCoeff[i] = resultCoeff[i];
            finalExp[i] = resultExp[i];
        }
        return new Polynomial(finalCoeff, finalExp);
    }

    private int findExponent(int [] exponents, int exp){
        for(int i = 0; i < exponents.length; i++){
            if(exponents[i] == exp) return i;
        }
        return -1;
    }

    public double evaluate(double x){
        double result = 0.0;
        for(int i = 0; i < this.coefficients.length; i++){
            result += this.coefficients[i]*Math.pow(x, this.exponents[i]);
        }
        return result;
    }

    public boolean hasRoot(double x){
        return evaluate(x) == 0;
    };
}
