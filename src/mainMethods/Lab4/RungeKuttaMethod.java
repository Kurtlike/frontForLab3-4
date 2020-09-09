package mainMethods.Lab4;

public class RungeKuttaMethod {
    private double[][] dotsForInterpolate;
    private double[] kCoef = new double[4];
    private double h;
    private double error = 100;
    private double startX;
    private double startY;
    private double step;
    private double endX;
    private String functionName;

    public RungeKuttaMethod(double startX, double startY, double step, double endX, String functionName) {
        this.step = step;
        this.endX = endX;
        this.startX = startX;
        this.startY = startY;
        this.functionName = functionName;
        solveDE();
    }

    public void solveDE() {
        h=step;
        createDotsForInterpolate();
    }

    private void createDotsForInterpolate() {
        double x = startX;
        double y = startY;
        dotsForInterpolate = new double[(int) ((endX - startX) / h)][2];
        dotsForInterpolate[0][0] = x;
        dotsForInterpolate[0][1] = y;
        for (int i = 1; i < (int) ((endX - startX) / h); i++) {
            x += h;
            dotsForInterpolate[i][0] = x;
            getKCoef(dotsForInterpolate[i - 1][0], dotsForInterpolate[i - 1][1]);
            dotsForInterpolate[i][1] = dotsForInterpolate[i - 1][1] + (kCoef[0] + 2 * kCoef[1] + 2 * kCoef[2] + kCoef[3]) / 6;

        }
    }
    private void getKCoef(double x, double y) {
        kCoef[0] = h * getRightSideEquation(x, y);
        kCoef[1] = h * getRightSideEquation(x + h / 2, y + kCoef[0] / 2);
        kCoef[2] = h * getRightSideEquation(x + h / 2, y + kCoef[1] / 2);
        kCoef[3] = h * getRightSideEquation(x + h, y + kCoef[2]);
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
    public double getH() {
        return h;
    }

}
