package mainMethods.Lab4;

import mainMethods.Answer;

public class IOData {
    RungeKuttaMethod rungeKuttaMethod;
    SplineMethod splineMethod;
    public IOData(double xCoord,double yCoord,double accuracy,double xEnd,String functionName){
        rungeKuttaMethod=new RungeKuttaMethod(xCoord,yCoord,accuracy,xEnd,functionName);
    }
    public Answer getRungeAnswer(){
        splineMethod=new SplineMethod(rungeKuttaMethod.getDotsForInterpolate());
        splineMethod.interpolate();
        Answer answer=new Answer();
        answer.setDotsForInterpolate(rungeKuttaMethod.getDotsForInterpolate());
        answer.setSourceFunction(rungeKuttaMethod.getSourceFunction());
        answer.setNewPoints(splineMethod.getNewPoints());
        return answer;
    }
}
