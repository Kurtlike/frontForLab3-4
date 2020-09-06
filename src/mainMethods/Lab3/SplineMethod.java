package mainMethods.Lab3;

import mainMethods.GaussianElimination;

public class SplineMethod {
    private double[][] startingPoints;
    private double[][] newPoints;
    private double[][] sourceFunction;
    private double[] h;
    private double[] cCoef;
    private double[] dCoef;
    private double[] aCoef;
    private double[] bCoef;
    private double desiredValue;
    private String functionName;
    public SplineMethod(double desiredValue,String functionName){
        this.desiredValue=desiredValue;
        this.functionName=functionName;
    }
    public void interpolate(){
        createStartingPoints();
        createSourceFunction();
        h=getH();
        GaussianElimination gaussianElimination=new GaussianElimination(19,createCMatrix());
        aCoef=getaCoef();
        cCoef=gaussianElimination.getAnswer();
        dCoef=getdCoef();
        bCoef=getbCoef();
        createNewPoints();
    }
    private double[] getdCoef(){
        double[] matrix=new double[19];
        for(int i=0;i<18;i++){
            matrix[i]=(cCoef[i+1]-cCoef[i])/h[i];
        }
        matrix[18]=-cCoef[18]/h[18];
        return matrix;
    }
    private double[] getbCoef(){
        double[] matrix=new double[19];
        for(int i=0;i<19;i++){
            matrix[i]=(startingPoints[i+1][1]-startingPoints[i][1])/h[i]-cCoef[i]*h[i]/2-dCoef[i]*h[i]*h[i]/6;
        }
        return matrix;
    }
    private double[] getaCoef(){
        double[] matrix=new double[19];
        for(int i=0;i<19;i++){
            matrix[i]=startingPoints[i][1];
        }
        return matrix;
    }
    private double[] getH(){
        double[] matrix=new double[19];
        for(int i=0;i<19;i++) matrix[i]=startingPoints[i+1][0]-startingPoints[i][0];
        return matrix;
    }
    private double[][] createCMatrix(){
        double[][] matrix=new double[19][20];
        for(int i=0;i<19;i++) {
            for (int j = 0; j < 20; j++) {
                if (j == i) matrix[i][j] = 2 * (startingPoints[i][0] + startingPoints[i + 1][0]);
                else if (j == i + 1&&j!=19) matrix[i][j] = startingPoints[i + 1][0];
                else if (j == i - 1) matrix[i][j] = startingPoints[i][0];
                else if ( j == 19) {
                    if (i == 18) {
                        matrix[i][j] = 3 * ((getFunctionValue(0) - startingPoints[19][1]) / (0 - startingPoints[19][0]) - (startingPoints[19][1] - startingPoints[18][1]) / h[18]);
                    } else
                        matrix[i][j] = 3 * ((startingPoints[i + 2][1] - startingPoints[i + 1][1]) / h[i + 1] - (startingPoints[i + 1][1] - startingPoints[i][1]) / h[i]);
                }
                else matrix[i][j] = 0;
            }

        }
        return matrix;
    }
    private double getFunctionValue(double x){
        switch (functionName){
            case "linearFunction": return 2*x+3;
            case "quadraticFunction": return -x*x;
            case "quadraticFunctionTwo": return -(x-20)*(x-20);
            case "cubicalFunction":return x*x*x;
            default:return 0;
        }
    }
    private void createStartingPoints(){
        double[] dotX= new double[20];
        startingPoints=new double[20][2];
        double dot=desiredValue-10;
        for(int i=0;i<4;i++){
            dotX[i]=dot;
            dot+=2;
        }
        for(int i=4;i<16;i++){
            dotX[i]=dot;
            dot+=0.5;
        }
        for(int i=16;i<20;i++){
            dotX[i]=dot;
            dot+=2;
        }
        for(int i=0;i<20;i++){
            startingPoints[i][0]=dotX[i];
            startingPoints[i][1]=getFunctionValue(dotX[i]);
        }
    }
    private void createSourceFunction(){
        sourceFunction=new double[(int)((20)/0.01)][2];
        double dot=desiredValue-10;
        for(int i=0;i<(int)((20)/0.01);i++){
            sourceFunction[i][0]=dot;
            sourceFunction[i][1]=getFunctionValue(dot);
            dot+=0.01;
        }
    }
    private void createNewPoints(){
        newPoints=new double[(int)((20)/0.01)][2];
        double dot=desiredValue-10;
        for(int i=0;i<(int)((20)/0.01);i++){
            dot += 0.01;
            newPoints[i][0]=dot;
            for(int k=0;k<19;k++) {
                if (dot > startingPoints[k][0] && dot < startingPoints[k + 1][0]) {
                    newPoints[i][1] =aCoef[k]+bCoef[k]*(dot-startingPoints[k][0])+cCoef[k]*Math.pow((dot-startingPoints[k][0]),2)+dCoef[k]*Math.pow((dot-startingPoints[k][0]),3);
                }
            }

        }
    }
    public double[][] getStartingPoints() {
        return startingPoints;
    }
    public double[][] getNewPoints() {
        return newPoints;
    }
    public double[][] getSourceFunction() {
        return sourceFunction;
    }
}
