package mainMethods.Lab4;

import mainMethods.Answer;

public class IOData {
    private RungeKuttaMethod rungeKuttaMethod;
    private MilneMethod milneMethod;
    private AdamMethod adamMethod;
    private SplineMethod splineMethod;
    private String methodName;
    private  double xEnd;
    private String functionName;
    public IOData(double xCoord,double yCoord,double step,double xEnd,String functionName,String methodName){
        this.methodName=methodName;
        this.xEnd=xEnd;
        this.functionName=functionName;
        rungeKuttaMethod=new RungeKuttaMethod(xCoord,yCoord,step,xEnd,functionName);
    }
    public Answer getAnswer(){
        switch (methodName){
            case "milnesMethod":return getMilneAnswer();
            case "adamsMethod":return getAdamsAnswer();
            case "rungeKuttaMethod":return getRungeAnswer();
            default: return new Answer();
        }
    }
    public Answer getRungeAnswer(){
        return getGeneralAnswer(rungeKuttaMethod.getDotsForInterpolate());
    }
    public Answer getAdamsAnswer(){
        adamMethod=new AdamMethod(rungeKuttaMethod.getH(),rungeKuttaMethod.getDotsForInterpolate(),xEnd,functionName);
        return getGeneralAnswer(adamMethod.getDotsForInterpolate());
    }
    public Answer getMilneAnswer(){
        milneMethod=new MilneMethod(rungeKuttaMethod.getH(),rungeKuttaMethod.getDotsForInterpolate(),xEnd,functionName);
        return getGeneralAnswer(milneMethod.getDotsForInterpolate());
    }

    private Answer getGeneralAnswer(double[][] dotsForInterpolate) {
        splineMethod=new SplineMethod(dotsForInterpolate);
        splineMethod.interpolate();
        Answer answer=new Answer();
        answer.setDotsForInterpolate(dotsForInterpolate);
        answer.setNewPoints(splineMethod.getNewPoints());
        return answer;
    }
}
