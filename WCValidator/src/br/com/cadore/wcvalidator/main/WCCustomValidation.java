package br.com.cadore.wcvalidator.main;

import java.awt.Color;
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
    
    public void addRule(JTextComponent tf, String condition, String value, 
            String valueTwo, String message, Color color){
        Rules rule = new Rules();
        rule.tf = tf;
        rule.cb = null;
        rule.condition = condition;
        rule.value = value;
        rule.valueTwo = valueTwo;
        rule.message = message;
        rule.color = color;
        rules.add(rule);
    }
    
    public void addRule(JComboBox tf, String condition, String value, 
            String valueTwo, String message, Color color){
        Rules rule = new Rules();
        rule.tf = null;
        rule.cb = tf;
        rule.condition = condition;
        rule.value = value;
        rule.valueTwo = valueTwo;
        rule.message = message;
        rule.color = color;
        rules.add(rule);
    }
    
    public Boolean Validate(){
        ArrayList<Boolean> flagArray = new ArrayList<>();
        Boolean flag = false;        
        for (Rules rule : rules) { 
            if(defaulBorder == null && rule.tf != null){
                defaulBorder = rule.tf.getBorder();
            }
            
            if(rule.tf != null){
                String value = rule.tf.getText();
                if(rule.condition.equals(ConditionsValidation.Null)){
                    if(value == null){
                        flag = true;
                        flagArray.add(true);
                    }else{
                        flag = false;
                        flagArray.add(false);
                    }
                }else if(rule.condition.equals(ConditionsValidation.NotNull)){
                    if(value != null){
                        flag = true;
                        flagArray.add(true);
                    }else{
                        flag = false;
                        flagArray.add(false);
                    }
                }else if(rule.condition.equals(ConditionsValidation.Empty)){
                    if(value.isEmpty()){
                        flag = true;
                        flagArray.add(true);
                    }else{
                        flag = false;
                        flagArray.add(false);
                    }
                }else if(rule.condition.equals(ConditionsValidation.NotEmpty)){
                    if(!value.isEmpty()){
                        flag = true;
                        flagArray.add(true);
                    }else{
                        flag = false;
                        flagArray.add(false);
                    }
                }
            }
            
            setBorder(rule, flag);
        }
        int i = 0;
        for(Boolean flagBoolean : flagArray){
            if(flagBoolean == false)
                i++;
        }
        flag = i == 0;
        return flag;
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
