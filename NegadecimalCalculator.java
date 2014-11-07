/*** Lu Lu and Ryan Smith - CIT591 - HW9 - Negadecimal Numbers***/

package negadecimalCalculator;

import java.util.Arrays;
import java.util.Scanner;

public class NegadecimalCalculator {
	String displayValue; //String instance variable that will serve as calculator display
	NegadecimalNumber negaNum;
	boolean errorInDisplay;
	NegadecimalCalculator(){
		negaNum = new NegadecimalNumber(0);
		displayValue = "0";
		errorInDisplay = false;
	}
	
	public void REPL(){
		System.out.println(displayValue);
		System.out.print("Compute: ");
		Scanner input = new Scanner(System.in);
		String userInput = input.nextLine().trim().toLowerCase();
		while (true){
			if (userInput.equals("q") || userInput.equals("quit")) {
				break;
			}
			try{
				displayValue = evaluate(userInput);
			} catch (Exception e){
				displayValue = "Error";	
				errorInDisplay = true;
			}
			System.out.println(displayValue);
			System.out.print("Compute: ");
			userInput = input.nextLine().trim().toLowerCase();	
		}
		System.out.println("Done.");
	}
	
	public String evaluate(String s){
		if (errorInDisplay){
			if (!(s.equals("c") || s.equals("clear"))){
				return "Error";
			}
			errorInDisplay = false;
			negaNum = new NegadecimalNumber(0);
			return negaNum.toString();
		}
		
		if (s.equals("c")|| s.equals("clear")){
			negaNum = new NegadecimalNumber(0);
			return negaNum.toString();
		}
		
		if (isAllDigit(s)){
			negaNum = new NegadecimalNumber(s);
			return negaNum.toString();
		}
		
		if (isBinary(s.charAt(0))){
			return compute(s.charAt(0), s.substring(1));	
		}
		
		if (s.equals("~")) {
			negaNum = negaNum.negate();
			return negaNum.toString();
		}
		
		if (s.equals("?")) {
			return negaNum.toString() + " (decimal " + negaNum.decimalValue() + ")";
		}
		
		if (s.charAt(0) == 'd' || s.indexOf("decimal") == 0){
			setDecimal(s);
			return negaNum.toString();
		}
		
		throw new ArithmeticException();
	}
	
	public boolean isAllDigit(String s){
		if (s.equals("")) return false;
		for (int i = 0; i < s.length(); i++){
			if (!Character.isDigit(s.charAt(i))) return false;
		}
		return true;
	}
	
	public String compute(char operator, String operand){
		operand = operand.trim();
		if (!isAllDigit(operand)) throw new ArithmeticException();
		switch(operator){
			case '+':
				negaNum = negaNum.add(new NegadecimalNumber(operand));
				break;
			case '-':
				negaNum = negaNum.subtract(new NegadecimalNumber(operand));
				break;
			case '*':
				negaNum = negaNum.multiply(new NegadecimalNumber(operand));
				break;
			case '/':
				negaNum = negaNum.divide(new NegadecimalNumber(operand));
				break;
			case '%':
				negaNum = negaNum.remainder(new NegadecimalNumber(operand));
				break;	
		}
		return negaNum.toString();
	}
	
	public void setDecimal(String s){
		String num;
		if (s.indexOf("decimal") == 0){
			num = s.substring(7);
		}else num = s.substring(1);
		num = num.trim();
		if (!isAllDigit(num)) {
			throw new ArithmeticException();
		}
		
		negaNum = new NegadecimalNumber(Integer.parseInt(num));	
	}
	
	public boolean isBinary(char x){
		char[] operators = {'+', '-', '*', '/', '%'};
		for (int i = 0; i < operators.length; i++){
			if (operators[i] == x) return true;
		}
		return false;
	}
	
	
	
	
	public static void main(String[] args) throws Exception {
		//Main method simply makes NegaDecimalCalculator object and calls REPL method
		NegadecimalCalculator operator = new NegadecimalCalculator();
		operator.REPL();
	}

}
