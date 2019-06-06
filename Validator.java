
/**
 * Write a description of class Validator here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.scene.layout.*;

public class Validator
{
    private boolean isInt(TextField input)
    {
        boolean isNum = true;
        String text = null;
        
        if(!input.getText().matches("[0-9]+") || input.getText().equals(null))
        {
            isNum = false;
            
        }
        else 
        {
            try
            {
                double num = Double.parseDouble(input.getText());
                if(num < 0)
                    isNum = false;
                
            }
            catch (NumberFormatException e) {isNum = false;}
        }
        return isNum;
    }
    
    public boolean diskrodCheck(TextField theta, TextField mass, TextField radius, TextField tc, TextField height)
    {
        boolean check = true; 
        VBox error = new VBox(8);
        
        if(!isInt(theta))
        {
            check = false;
            error.getChildren().add(new Label("Invalid Theta: Theta must be positive and a numerical value"));
        }
        
        if(!isInt(mass))
        {
            check = false;
            error.getChildren().add(new Label("Invalid Mass: Mass must be positive and a numerical value"));
        }
        
        if(!isInt(radius))
        {
            check = false;
            error.getChildren().add(new Label("Invalid Radius: Radius must be positive and a numerical value"));
        }
        if(!isInt(tc))
        {
            check = false;
            error.getChildren().add(new Label("Invalid Torsional Constant: Constant must be positive and a numerical value"));
        }
        if(!isInt(height))
        {
            check = false;
            error.getChildren().add(new Label("Invalid Height: Height must be positive and a numerical value"));
        }
        
        if(check == false)
        {
            AlertBox a = new AlertBox();
            a.display(error);
        }
            
        return check;
    }
    
    public boolean sphereCheck(TextField theta, TextField mass, TextField radius, TextField tc)
    {
        boolean check = true; 
        VBox error = new VBox(8);
        
        if(!isInt(theta))
        {
            check = false;
            error.getChildren().add(new Label("Invalid Theta: Theta must be positive and a numerical value"));
        }
        
        if(!isInt(mass))
        {
            check = false;
            error.getChildren().add(new Label("Invalid Mass: Mass must be positive and a numerical value"));
        }
        
        if(!isInt(radius))
        {
            check = false;
            error.getChildren().add(new Label("Invalid Radius: Radius must be positive and a numerical value"));
        }
        if(!isInt(tc))
        {
            check = false;
            error.getChildren().add(new Label("Invalid Torsional Constant: Constant must be positive and a numerical value"));
        }
        
        if(check == false)
        {
            AlertBox a = new AlertBox();
            a.display(error);
        }
            
        return check;
    }
    
    public boolean barCheck(TextField theta, TextField mass, TextField radius, TextField tc, TextField height, TextField width)
    {
       boolean check = true; 
        VBox error = new VBox(8);
        
        if(!isInt(theta))
        {
            check = false;
            error.getChildren().add(new Label("Invalid Theta: Theta must be positive and a numerical value"));
        }
        
        if(!isInt(mass))
        {
            check = false;
            error.getChildren().add(new Label("Invalid Mass: Mass must be positive and a numerical value"));
        }
        
        if(!isInt(radius))
        {
            check = false;
            error.getChildren().add(new Label("Invalid Radius: Radius must be positive and a numerical value"));
        }
        
        if(!isInt(tc))
        {
            check = false;
            error.getChildren().add(new Label("Invalid Torsional Constant: Constant must be positive and a numerical value"));
        }
        
        if(!isInt(tc))
        {
            check = false;
            error.getChildren().add(new Label("Invalid Torsional Constant: Constant must be positive and a numerical value"));
        }
        if(check == false)
        {
            AlertBox a = new AlertBox();
            a.display(error);
        }
            
        return check;
    }
    
    
}