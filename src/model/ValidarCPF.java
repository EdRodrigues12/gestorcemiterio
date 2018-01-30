package model;

import java.util.InputMismatchException;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

public class ValidarCPF implements Validator {  
	
	@Override
	public void validate(FacesContext arg0, UIComponent arg1, Object valorTela) throws ValidatorException {
		
		valorTela = String.valueOf(valorTela).replaceAll("[^0123456789]", "");
		System.out.println("cpf"+valorTela);
		if( CPF(String.valueOf(valorTela)) != true){
			FacesMessage message = new FacesMessage();
			message.setSeverity(FacesMessage.SEVERITY_ERROR);
			message.setSummary("CPF INVÁLIDO");
			throw new ValidatorException(message);
		}
		
	}  
    
    public boolean CPF(String strCpf) {  
    	strCpf = String.valueOf(strCpf).replaceAll("[^0123456789]", "");
    	System.out.println("cpf"+strCpf);
    	for (int i = 1; i < strCpf.length(); i++){
   		 if(strCpf.charAt(i) == strCpf.charAt(i-1)){
   			 return false;
   		 }
    	}
    	
        if (strCpf.equals("")) {  
            return false;  
        }
        
        else{
		    char dig10, dig11;
		    int sm, i, r, num, peso;
		
		    try {
		
		      sm = 0;
		      peso = 10;
		      for (i=0; i<9; i++) {             
		       
		        num = (int)(strCpf.charAt(i) - 48);
		        sm = sm + (num * peso);
		        peso = peso - 1;
		      }
		      r = 11 - (sm % 11);
		      if ((r == 10) || (r == 11))
		         dig10 = '0';
		      else dig10 = (char)(r + 48); 
		
		      sm = 0;
		      peso = 11;
		      for(i=0; i<10; i++) {
		        num = (int)(strCpf.charAt(i) - 48);
		        sm = sm + (num * peso);
		        peso = peso - 1;
		      }
		      r = 11 - (sm % 11);
		      if ((r == 10) || (r == 11))
		         dig11 = '0';
		      else dig11 = (char)(r + 48);
		
		      if ((dig10 == strCpf.charAt(9)) && (dig11 == strCpf.charAt(10))){
		    	  System.out.println("cpf");
		         return true;
		         
		      } 
		      else {
		    	  return(false);
		      } 
	    } catch (InputMismatchException erro) {
	        return(false);
	    }
        	}
        		}

	
    
}