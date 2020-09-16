package mainMethods.Lab3;

import mainMethods.Answer;

public class IOData {
    private String functionName;
    private double size;
    private SplineMethod splineMethod;
    private double desiredValue;
    private String data;
    private double[][] dataDots;
    public IOData(double desiredValue,String functionName,String data){
        this.functionName=functionName;
        this.desiredValue=desiredValue;
        this.data=data;
        switch (data){
            case "default":{
                dataDots=createdefaultStartingPoints();
                break;
            }
            default:dataDots=createStartingPoints();
        }
        splineMethod=new SplineMethod(dataDots,desiredValue);
        splineMethod.interpolate();

    }
    public Answer getAnswer(){
        Answer answer=new Answer();
        answer.setNewPoints(splineMethod.getNewPoints());
        answer.setSourceFunction(createSourseFunction());
        answer.setDots(splineMethod.getStartingPoints());
        answer.setAnswer(splineMethod.getY());
        return answer;
    }
    private double[][] createSourseFunction(){
        double[][] sourceFunction=new double[(int)((dataDots[dataDots.length-1][0]-dataDots[0][0])/0.01)][2];
        double dot=dataDots[0][0];
        for(int i=0;i<(int)((dataDots[dataDots.length-1][0]-dataDots[0][0])/0.01);i++){
            sourceFunction[i][0]=dot;
            sourceFunction[i][1]=getFunctionValue(dot);
            dot+=0.01;
        }
        return sourceFunction;
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
    private double[][] createdefaultStartingPoints(){
        double [][] startingPoints;
        size=20;
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
        return startingPoints;
    }
    private double[][] createStartingPoints(){
        double [][] startingPoints = new double[0][];
        double[] firstData={-11,-10,-8,-7,-6,-4,-3,-1,1,2,4,7,11};
        double[] secondData={6,8,10,15,16,17,20,21,26};
        double[] thirdData={-20,-16,-15,-14,-12,-11,-10};
        switch (data){
            case "firstData":{
                size=firstData.length;
                startingPoints=new double[firstData.length][2];
                for(int i=0;i<firstData.length;i++){
                    startingPoints[i][0]=firstData[i];
                    startingPoints[i][1]=getFunctionValue(firstData[i]);
                }
            }
            break;
            case "secondData":{
                size=secondData.length;
                startingPoints=new double[secondData.length][2];
                for(int i=0;i<secondData.length;i++){
                    startingPoints[i][0]=secondData[i];
                    startingPoints[i][1]=getFunctionValue(secondData[i]);
                }
            }
            break;
            case "thirdData":{
                size=thirdData.length;
                startingPoints=new double[thirdData.length][2];
                for(int i=0;i<thirdData.length;i++){
                    startingPoints[i][0]=thirdData[i];
                    startingPoints[i][1]=getFunctionValue(thirdData[i]);
                }
            }
            break;
        }
        return startingPoints;
    }
}
