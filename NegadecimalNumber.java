/*** Lu Lu and Ryan Smith - CIT591 - HW9 - Negadecimal Numbers***/

package negadecimalCalculator;

public class NegadecimalNumber{
	int value;
	public NegadecimalNumber(String s){
		int base = 1;
		for (int i = s.length() - 1 ; i >= 0 ; i--){
			if (!Character.isDigit(s.charAt(i))) {
				throw new IllegalArgumentException();
			}
			value += base * (s.charAt(i) - '0');
			base *= -10;
		}
	}
	
	public NegadecimalNumber(int n){
		value = n;
	}
	
	public NegadecimalNumber add(NegadecimalNumber ndn){
		return new NegadecimalNumber(this.value + ndn.value);
	}
	
	public NegadecimalNumber subtract(NegadecimalNumber ndn){
		return new NegadecimalNumber(this.value - ndn.value);
	}
	
	public NegadecimalNumber multiply(NegadecimalNumber ndn){
		return new NegadecimalNumber(this.value * ndn.value);
	}
	
	public NegadecimalNumber divide(NegadecimalNumber ndn){
		if (ndn.value == 0) {
			throw new ArithmeticException();
		}
		return new NegadecimalNumber(this.value / ndn.value);
	}
	
	public NegadecimalNumber remainder(NegadecimalNumber ndn){
		if (ndn.value == 0) {
			throw new ArithmeticException();
		}
		return new NegadecimalNumber(this.value % ndn.value);
	}
	
	public NegadecimalNumber negate(){
		return new NegadecimalNumber(-value);
	}
	
	public int decimalValue(){
		return value;
	}
	
	public boolean equals(NegadecimalNumber ndn){
		return this.value == ndn.value;
	}
	
	public String toString(){
		int copyValue = value;
		String result = "";
		while (copyValue != 0){
			int remainder = copyValue % -10;
			copyValue /= -10;
			
			if (remainder < 0){
				remainder += 10;
				copyValue++;
			}
			
			result = remainder + result;
		}
		if (result.equals("")) return "0";
		return result;	
	}
	
	public static void main(String args[]){
		NegadecimalNumber i = new NegadecimalNumber("");
		System.out.println(i.decimalValue());
		System.out.println(i);
	}

}
