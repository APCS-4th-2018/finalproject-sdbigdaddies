/**
 * Write a description of class Validator here.
 * takes textfields from gui and checks to make sure they are valid inputs, otherwise it promtpts an error box
 * @author (David Glozman)
 * @version (a version number or a date)
 */
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.scene.layout.*;
import javafx.geometry.*;
import javafx.stage.*;
import javafx.application.*;

public class Validator
{
    /*
     * checks if the textfield is a valid integer that is postiive, non null.
     * @param textfield of an input to be checked
     */
    private boolean isInt(TextField input)
    {
        //local variables
        boolean isNum = true;
        String text = null;
        
        //check if its a number and its non null 
        if(!input.getText().matches("[0.0-9.0]+") || input.getText().equals(null))
        {
            isNum = false; //false if it matches
            
        }
        else 
        {
            try
            {
                //check if it is a number
                double num = Double.parseDouble(input.getText());
                if(num < 0) //check if it is negative
                    isNum = false;
                
            }
            catch (NumberFormatException e) {isNum = false;} //if a string is entered and you cannot parse int catch exception
        }
        return isNum; //return  boolean
    }
    
    /**
     * checks if there are any errors in the disk or rod's input and returns a boolean based on result. 
     * calls an error box if there are errors
     * @param TextField objects (input) of theta, mass,radius, torsional constant, height
     * @return boolean true if that arent any errors and false if there are
     */
    public boolean diskrodCheck(TextField theta, TextField mass, TextField radius, TextField tc, TextField height)
    {
        //local variables
        boolean check = true; 
        VBox error = new VBox(8);
        
        //if theta isnt valid
        if(!isInt(theta))
        {
            check = false;
            error.getChildren().add(new Label("Invalid Theta: Theta must be positive and a numerical value"));
        }
        
        //if mass isnt valid
        if(!isInt(mass))
        {
            check = false;
            error.getChildren().add(new Label("Invalid Mass: Mass must be positive and a numerical value"));
        }
        
        //if radius isnt valid
        if(!isInt(radius))
        {
            check = false;
            error.getChildren().add(new Label("Invalid Radius: Radius must be positive and a numerical value"));
        }
        
        //if torisional constant isnt valid
        if(!isInt(tc))
        {
            check = false;
            error.getChildren().add(new Label("Invalid Torsional Constant: Constant must be positive and a numerical value"));
        }
        
        //if height isnt valid
        if(!isInt(height))
        {
            check = false;
            error.getChildren().add(new Label("Invalid Height: Height must be positive and a numerical value"));
        }
        
        //if something isnt valid display error alert box
        if(check == false)
        {
            AlertBox a = new AlertBox();
            a.display(error);
        }
            
        return check; //return boolean
    }
    
    /**
     * checks if there are any errors in sphere input and returns a boolean based on result.
     * calls an error box if there are errors
     * @param TextField objects (input) of theta, mass,radius, torsional constant
     * @return boolean true if that arent any errors and false if there are
     */
    public boolean sphereCheck(TextField theta, TextField mass, TextField radius, TextField tc)
    {
        //local variables
        boolean check = true; 
        VBox error = new VBox(8);
        
        //if theta isnt valid
        if(!isInt(theta))
        {
            check = false;
            error.getChildren().add(new Label("Invalid Theta: Theta must be positive and a numerical value"));
        }
        
        //if mass isnt valid
        if(!isInt(mass))
        {
            check = false;
            error.getChildren().add(new Label("Invalid Mass: Mass must be positive and a numerical value"));
        }
        
        //if radius isnt valid
        if(!isInt(radius))
        {
            check = false;
            error.getChildren().add(new Label("Invalid Radius: Radius must be positive and a numerical value"));
        }
        
        //if torsional constant isnt valid
        if(!isInt(tc))
        {
            check = false;
            error.getChildren().add(new Label("Invalid Torsional Constant: Constant must be positive and a numerical value"));
        }
        
        //if anything is invalid display error alert box with invalid input
        if(check == false)
        {
            AlertBox a = new AlertBox();
            a.display(error);
        }
            
        return check; //return boolean
    }
    
    /**
     * checks if there are any errors in the bars input 
     * and returns a boolean based on result. calls an error box if there are errors
     * @param TextField objects (input) of theta, mass, radius, torsional constant, height, width
     * @return boolean true if that arent any errors and false if there are
     */
    public boolean barCheck(TextField theta, TextField mass, TextField radius, TextField tc, TextField height, TextField width)
    {
        //local variables
        boolean check = true; 
        VBox error = new VBox(10);
        error.setPadding(new Insets(10,10,10,10));
        
        //if theta is invalid
        if(!isInt(theta))
        {
            check = false;
            error.getChildren().add(new Label("Invalid Theta: Theta must be positive and a numerical value"));
        }
        
        //if mass is invald
        if(!isInt(mass))
        {
            check = false;
            error.getChildren().add(new Label("Invalid Mass: Mass must be positive and a numerical value"));
        }
        
        //if radius is invalid
        if(!isInt(radius))
        {
            check = false;
            error.getChildren().add(new Label("Invalid Radius: Radius must be positive and a numerical value"));
        }
        
        //if torsional csontatn is invalid
        if(!isInt(tc))
        {
            check = false;
            error.getChildren().add(new Label("Invalid Torsional Constant: Constant must be positive and a numerical value"));
        }
        
        //if height is invalid
        if(!isInt(height))
        {
            check = false;
            error.getChildren().add(new Label("Invalid Height: Height must be positive and a numerical value"));
        }
        
        //if width is invalid
        if(!isInt(width))
        {
            check = false;
            error.getChildren().add(new Label("Invalid Width: Width must be positive and a numerical value"));
        }
        
        //if anything is invalid display error alert box
        if(check == false)
        {
            AlertBox a = new AlertBox();
            a.display(error);
        }
            
        return check; //return boolean
    }
    
    
}
