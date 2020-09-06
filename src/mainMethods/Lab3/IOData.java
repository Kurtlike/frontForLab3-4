package mainMethods.Lab3;

import mainMethods.Answer;

public class IOData {
    private SplineMethod splineMethod;
    public IOData(double desiredValue,String functionName){
        splineMethod=new SplineMethod( desiredValue,functionName);
        splineMethod.interpolate();

    }
    public Answer getAnswer(){
        Answer answer=new Answer();
        answer.setSourceFunction(splineMethod.getSourceFunction());
        answer.setNewPoints(splineMethod.getNewPoints());
        answer.setDots(splineMethod.getStartingPoints());
        return answer;
    }
}
