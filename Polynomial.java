public class Polynomial{
    //Polynomial File
    private double [] coefficients;

    public Polynomial(){
        this.coefficients = new double[] {0};
    }
    public Polynomial(double[] coefficients){
        this.coefficients = coefficients;
    }

    public Polynomial add(Polynomial poly){
        int length = Math.max(this.coefficients.length, poly.coefficients.length);
        double[] result = new double[length];
        for(int i = 0; i < length; i++){
            double coeff1 = (this.coefficients.length <= i) ? 0 : this.coefficients[i];
            double coeff2 = (poly.coefficients.length <= i) ? 0 : poly.coefficients[i];
            result[i] = coeff1 + coeff2;
        }
        return new Polynomial(result);
    }

    public double evaluate(double x){
        double result = 0.0;
        for(int i = 0; i < this.coefficients.length; i++){
            result += this.coefficients[i]*Math.pow(x, i);
        }
        return result;
    }

    public boolean hasRoot(double x){
        return evaluate(x) == 0;
    };
}
