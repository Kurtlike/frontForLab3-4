package elements.lab4;

import elements.Logger;
import javafx.scene.control.TextField;

public class Fields {
    private final TextField xCoord;
    private final TextField yCoord;
    private final TextField accuracy;
    private final TextField xEnd;
    private double valueOfXCoord;
    private double valueOfYCoord;
    private double valueOfAccuracy;
    private double valueOfXEnd;
    private Logger logger;
    public Fields(TextField xCoord, TextField yCoord,TextField accuracy,TextField xEnd, Logger logger){
        this.xCoord=xCoord;
        this.yCoord=yCoord;
        this.accuracy=accuracy;
        this.xEnd=xEnd;
        this.logger=logger;
        readX();
    }
    private void readX(){
        try {
            valueOfXCoord=Double.parseDouble(xCoord.getText());
            valueOfYCoord=Double.parseDouble(yCoord.getText());
            valueOfAccuracy=Double.parseDouble(accuracy.getText());
            valueOfXEnd=Double.parseDouble(xEnd.getText());
        }
        catch (Exception e){
            logger.setLog("Значения введенны не верно");
        }
    }
    public double getvalueOfXCoord(){
        return valueOfXCoord;
    }
    public double getvalueOfYCoord(){
        return valueOfYCoord;
    }
    public double getValueOfAccuracy(){
        return valueOfAccuracy;
    }
    public double getValueOfXEnd(){
        return valueOfXEnd;
    }
}
