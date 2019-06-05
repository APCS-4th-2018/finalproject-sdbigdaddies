
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

public class Validator
{
    private boolean isInt(TextField input)
    {
        boolean isNum = true;
        String text = null;
        
        if(!input.getText().matches("[0-9]+") || input.getText().equals("") || input.getText().equals(null))
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
        if(!isInt(theta))
        {
            check = false;
        }
        if(!isInt(mass))
        {
            check = false;
        }
        if(!isInt(radius))
        {
            check = false;
        }
        if(!isInt(tc))
        {
            check = false;
        }
        if(!isInt(height))
        {
            check = false;
        }
            
        return check;
    }
    
    
    
    
    
    
}