package mainMethods.Lab3;


import mainMethods.GaussianElimination;

public class SplineMethod {
    private double[][] startingPoints;
    private double[][] newPoints;
    private double[] h;
    private double[] cCoef;
    private double[] dCoef;
    private double[] aCoef;
    private double[] bCoef;
    private int size;
    private double xValue;
    private double yValue=0;
    public SplineMethod(double[][] startingPoints,double xValue){
        this.xValue=xValue;
        this.startingPoints=startingPoints;
        size=startingPoints.length;
    }
    public void interpolate(){
        h=getH();
        GaussianElimination gaussianElimination=new GaussianElimination(size-1,createCMatrix());
        aCoef=getaCoef();
        cCoef=gaussianElimination.getAnswer();
        dCoef=getdCoef();
        bCoef=getbCoef();
        createNewPoints();
    }
    private double[] getdCoef(){
        double[] matrix=new double[size-1];
        for(int i=0;i<size-2;i++){
            matrix[i]=(cCoef[i+1]-cCoef[i])/h[i];
        }
        matrix[size-2]=-cCoef[size-2]/h[size-2];
        return matrix;
    }
    private double[] getbCoef(){
        double[] matrix=new double[size-1];
        for(int i=0;i<size-1;i++){
            matrix[i]=(startingPoints[i+1][1]-startingPoints[i][1])/h[i]-cCoef[i]*h[i]/2-dCoef[i]*h[i]*h[i]/6;
        }
        return matrix;
    }
    private double[] getaCoef(){
        double[] matrix=new double[size-1];
        for(int i=0;i<size-1;i++){
            matrix[i]=startingPoints[i][1];
        }
        return matrix;
    }
    private double[] getH(){
        double[] matrix=new double[size-1];
        for(int i=0;i<size-1;i++) matrix[i]=startingPoints[i+1][0]-startingPoints[i][0];
        return matrix;
    }
    private double[][] createCMatrix(){
        double[][] matrix=new double[size-1][size];
        for(int i=0;i<size-1;i++) {
            for (int j = 0; j < size; j++) {
                if (j == i) matrix[i][j] = 2 * (startingPoints[i][0] + startingPoints[i + 1][0]);
                else if (j == i + 1&&j!=size-1) matrix[i][j] = startingPoints[i + 1][0];
                else if (j == i - 1) matrix[i][j] = startingPoints[i][0];
                else if ( j == size-1) {
                    if (i == size-2) {
                        matrix[i][j] = 3 * ((startingPoints[0][1] - startingPoints[size-1][1]) / (0 - startingPoints[size-1][0]) - (startingPoints[size-1][1] - startingPoints[size-2][1]) / h[size-2]);
                    } else
                        matrix[i][j] = 3 * ((startingPoints[i + 2][1] - startingPoints[i + 1][1]) / h[i + 1] - (startingPoints[i + 1][1] - startingPoints[i][1]) / h[i]);
                }
                else matrix[i][j] = 0;
            }

        }
        return matrix;
    }

    private void createNewPoints(){
        newPoints=new double[(int)((startingPoints[startingPoints.length-1][0]-startingPoints[0][0])/0.01)][2];
        double dot=startingPoints[0][0];
        for(int i=0;i<(int)((startingPoints[startingPoints.length-1][0]-startingPoints[0][0])/0.01);i++){
            dot += 0.01;
            newPoints[i][0]=dot;
            for(int k=0;k<size-1;k++) {
                if (dot > startingPoints[k][0] && dot <= startingPoints[k + 1][0]) {
                    newPoints[i][1] =aCoef[k]+bCoef[k]*(dot-startingPoints[k][0])+cCoef[k]*Math.pow((dot-startingPoints[k][0]),2)+dCoef[k]*Math.pow((dot-startingPoints[k][0]),3);
                }
            }

        }
        for(int i=0;i<(int)((startingPoints[startingPoints.length-1][0]-startingPoints[0][0])/0.01)-1;i++){
            if (xValue > newPoints[i][0] && xValue <= newPoints[i + 1][0]) {
                yValue=newPoints[i][1];
                break;
            }
        }
    }
    public double[][] getStartingPoints() {
        return startingPoints;
    }
    public double[][] getNewPoints() {
        return newPoints;
    }
    public double getY(){
        return yValue;
    }
}
