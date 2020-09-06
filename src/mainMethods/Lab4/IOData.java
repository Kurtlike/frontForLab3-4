package mainMethods.Lab4;

import mainMethods.Answer;

public class IOData {
    RungeKuttaMethod rungeKuttaMethod;
    public IOData(double xCoord,double yCoord,double accuracy,double xEnd,String functionName){
        rungeKuttaMethod=new RungeKuttaMethod(xCoord,yCoord,accuracy,xEnd,functionName);
    }
    public Answer getAnswer(){
        Answer answer=new Answer();
        answer.setDotsForInterpolate(rungeKuttaMethod.getDotsForInterpolate());
        answer.setSourceFunction(rungeKuttaMethod.getSourceFunction());
        return answer;
    }
}
