package mainMethods;

public class Answer {
    private double answer;
    private double[][] sourceFunction;
    private double[][] newPoints;
    private double[][] dots;
    private double[][] dotsForInterpolate;

    public double getAnswer() {
        return answer;
    }

    public void setAnswer(double answer) {
        this.answer = answer;
    }

    public double[][] getSourceFunction() {
        return sourceFunction;
    }

    public void setSourceFunction(double[][] sourceFunction) {
        this.sourceFunction = sourceFunction;
    }

    public double[][] getNewPoints() {
        return newPoints;
    }

    public void setNewPoints(double[][] newPoints) {
        this.newPoints = newPoints;
    }

    public double[][] getDots() {
        return dots;
    }

    public void setDots(double[][] dots) {
        this.dots = dots;
    }

    public double[][] getDotsForInterpolate() {
        return dotsForInterpolate;
    }

    public void setDotsForInterpolate(double[][] dotsForInterpolate) {
        this.dotsForInterpolate = dotsForInterpolate;
    }
}
