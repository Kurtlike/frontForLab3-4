package mainMethods.Lab4;

public class AdamMethod {
    private double h;
    private double endX;
    private String functionName;
    private double[][] dotsForInterpolate;
    public AdamMethod(double h,double[][] initialValues,double endX,String functionName){
        this.h=h;
        this.dotsForInterpolate=initialValues;
        this.endX=endX;
        this.functionName=functionName;
        solveDE();
    }
    public void solveDE(){
        passPredictor();
        passCorrector();
    }
    private void passPredictor(){
        for(int i=4;i<dotsForInterpolate.length;i++){
            dotsForInterpolate[i][1]=dotsForInterpolate[i-1][1]+h*(
                    55*getRightSideEquation(dotsForInterpolate[i-1][0],dotsForInterpolate[i-1][1])
                    -59*getRightSideEquation(dotsForInterpolate[i-2][0],dotsForInterpolate[i-2][1])
                    +37*getRightSideEquation(dotsForInterpolate[i-3][0],dotsForInterpolate[i-3][1])
                    -9*getRightSideEquation(dotsForInterpolate[i-4][0],dotsForInterpolate[i-4][1])
            )/24;
        }
    }
    private void passCorrector(){
        for(int i=4;i<dotsForInterpolate.length;i++){

            dotsForInterpolate[i][1]=dotsForInterpolate[i-1][1]+h*(
                    getRightSideEquation(dotsForInterpolate[i-3][0],dotsForInterpolate[i-3][1])
                    -5*getRightSideEquation(dotsForInterpolate[i-2][0],dotsForInterpolate[i-2][1])
                    +19*getRightSideEquation(dotsForInterpolate[i-1][0],dotsForInterpolate[i-1][1])
                    +9*getRightSideEquation(dotsForInterpolate[i][0],dotsForInterpolate[i][1])
            )/24;

        }
    }
    private double getRightSideEquation(double x,double y){
        switch (functionName){
            case "default": return y+(1+x)*Math.pow(y,2);
            case "first":return y/Math.pow(x,2);
            case "second": return 1/(Math.pow(y,2)+2*x);
            default: return 0;
        }
    }

    public double[][] getDotsForInterpolate() {
        return dotsForInterpolate;
    }

}
