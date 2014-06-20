package br.com.cadore.wcvalidator.main;

import br.com.cadore.wcvalidator.main.utils.ValidationsBR;
import java.awt.Color;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.border.Border;
import javax.swing.text.JTextComponent;

public class WCCustomValidation {
    
    public WCCustomValidation(){
    }
    static Border defaulBorder = null;
    List<Rules> rules = new ArrayList<>();
    
    public void addRule(JTextComponent tf, int condition, String value, 
            String valueTwo, String message, Color color){
        addNewRule(tf, null, condition, value, valueTwo, message, color);
    }
    
    public void addRule(JComboBox cb, int condition, String value, 
            String valueTwo, String message, Color color){
        addNewRule(null, cb, condition, value, valueTwo, message, color);
    }
    
    private void addNewRule(JTextComponent tf, JComboBox cb, int condition, String value, 
            String valueTwo, String message, Color color){
        Rules rule = new Rules();
        rule.tf = tf;
        rule.cb = cb;
        rule.condition = condition;
        rule.value = value;
        rule.valueTwo = valueTwo;
        rule.message = message;
        rule.color = color;
        rules.add(rule);
    }
    
    
    
    
    ArrayList<Boolean> flagArray = new ArrayList<>();
    Boolean flag = false;
    
    
    public Boolean Validate() throws ParseException, Exception{
        if(rules == null){
            throw new Exception("Not have a 'Rule' added for validation.");
        }
        for (Rules rule : rules) { 
            if(defaulBorder == null && rule.tf != null){
                defaulBorder = rule.tf.getBorder();
            }
            if(rule.color == null){
                rule.color = Color.red;
            }
            
            if(rule.tf != null){
                String valueTF = rule.tf.getText();
                setValidations(rule, valueTF);
            }            
        }
        int i = 0;
        for(Boolean flagBoolean : flagArray){
            if(flagBoolean == false)
                i++;
        }
        flag = i == 0;
        return flag;
    }
    
    private void setValidations(Rules rule, String valueForValidation){
        if(rule.condition == (ConditionsValidation.Null)){
                    if(valueForValidation == null){
                        flag = true;
                        flagArray.add(true);
                    }else{
                        flag = false;
                        flagArray.add(false);
                    }
                }else if(rule.condition == (ConditionsValidation.NotNull)){
                    if(valueForValidation != null){
                        flag = true;
                        flagArray.add(true);
                    }else{
                        flag = false;
                        flagArray.add(false);
                    }
                }else if(rule.condition == (ConditionsValidation.Empty)){
                    if(valueForValidation.isEmpty()){
                        flag = true;
                        flagArray.add(true);
                    }else{
                        flag = false;
                        flagArray.add(false);
                    }
                }else if(rule.condition == (ConditionsValidation.NotEmpty)){
                    if(!valueForValidation.isEmpty()){
                        flag = true;
                        flagArray.add(true);
                    }else{
                        flag = false;
                        flagArray.add(false);
                    }
                }else if(rule.condition == (ConditionsValidation.Equals)){
                    if(valueForValidation == rule.value){
                        flag = true;
                        flagArray.add(true);
                    }else{
                        flag = false;
                        flagArray.add(false);
                    }
                }else if(rule.condition == (ConditionsValidation.NotEquals)){
                    if(valueForValidation != rule.value){
                        flag = true;
                        flagArray.add(true);
                    }else{
                        flag = false;
                        flagArray.add(false);
                    }
                }else if(rule.condition == (ConditionsValidation.Greater)){
                    if(Double.valueOf(valueForValidation) > Double.valueOf((String)rule.value)){
                        flag = true;
                        flagArray.add(true);
                    }else{
                        flag = false;
                        flagArray.add(false);
                    }
                }else if(rule.condition == (ConditionsValidation.GreaterOrEquals)){
                    if(Double.valueOf(valueForValidation) >= Double.valueOf((String)rule.value)){
                        flag = true;
                        flagArray.add(true);
                    }else{
                        flag = false;
                        flagArray.add(false);
                    }
                }else if(rule.condition == (ConditionsValidation.Less)){
                    if(Double.valueOf(valueForValidation) < Double.valueOf((String)rule.value)){
                        flag = true;
                        flagArray.add(true);
                    }else{
                        flag = false;
                        flagArray.add(false);
                    }
                }else if(rule.condition == (ConditionsValidation.LessOrEquals)){
                    if(Double.valueOf(valueForValidation) <= Double.valueOf((String)rule.value)){
                        flag = true;
                        flagArray.add(true);
                    }else{
                        flag = false;
                        flagArray.add(false);
                    }
                }else if(rule.condition == (ConditionsValidation.GreaterLenght)){
                    if(valueForValidation.length() > Integer.valueOf((String)rule.value)){
                        flag = true;
                        flagArray.add(true);
                    }else{
                        flag = false;
                        flagArray.add(false);
                    }
                }else if(rule.condition == (ConditionsValidation.GreaterOrEqualsLenght)){
                    if(valueForValidation.length() >= Integer.valueOf((String)rule.value)){
                        flag = true;
                        flagArray.add(true);
                    }else{
                        flag = false;
                        flagArray.add(false);
                    }
                }else if(rule.condition == (ConditionsValidation.LessLenght)){
                    if(valueForValidation.length() < Integer.valueOf((String)rule.value)){
                        flag = true;
                        flagArray.add(true);
                    }else{
                        flag = false;
                        flagArray.add(false);
                    }
                }else if(rule.condition == (ConditionsValidation.LessOrEqualsLenght)){
                    if(valueForValidation.length() <= Integer.valueOf((String)rule.value)){
                        flag = true;
                        flagArray.add(true);
                    }else{
                        flag = false;
                        flagArray.add(false);
                    }
                }else if(rule.condition == (ConditionsValidation.BetweenNumber)){
                    Double v = Double.valueOf(valueForValidation);
                    if(v >= Double.valueOf((String)rule.value) && v <= Double.valueOf((String)rule.valueTwo)){
                        flag = true;
                        flagArray.add(true);
                    }else{
                        flag = false;
                        flagArray.add(false);
                    }
                }else if(rule.condition == (ConditionsValidation.NotBetweenNumber)){
                    Double v = Double.valueOf(valueForValidation);
                    if(v <= Double.valueOf((String)rule.value) || v >= Double.valueOf((String)rule.valueTwo)){
                        flag = true;
                        flagArray.add(true);
                    }else{
                        flag = false;
                        flagArray.add(false);
                    }
                }else if(rule.condition == ConditionsValidation.BRCFPCNPJ){
                    if(new ValidationsBR().isValidCPFCNPJ(valueForValidation)){
                        flag = true;
                        flagArray.add(true);
                    }else{
                        flag = false;
                        flagArray.add(false);
                    }
                }
        setBorder(rule, flag);
    }
    
    private void setBorder(Rules rule, Boolean flag){
        if(rule.tf != null){
              if(flag == false){
                  rule.tf.setBorder(BorderFactory.createEtchedBorder(rule.color, null));
                  rule.tf.setToolTipText(rule.message);
              }else{
                  rule.tf.setBorder(defaulBorder);
                  rule.tf.setToolTipText(null);                  
              }
            }else if(rule.cb != null){
              if(flag == false){
                  rule.cb.setBorder(BorderFactory.createEtchedBorder(rule.color, null));
                  rule.cb.setToolTipText(rule.message);
              }else{                
                  rule.cb.setBorder(defaulBorder);
                  rule.cb.setToolTipText(null);                  
              }
            }
 
        //UIManager.put("ToolTip.foreground", new ColorUIResource(Color.RED));  
        //UIManager.put("ToolTip.background", new ColorUIResource(Color.YELLOW)); 
    }
}
