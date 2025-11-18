// Implements algebraic operations and the square root function without using 
// the Java operations a + b, a - b, a * b, a / b, a % b, and without calling 
// Math.sqrt. All the functions in this class operate on int values and
// return int values.

public class Algebra {
	public static void main(String args[]) {
	    // Tests some of the operations
	    System.out.println(plus(2,3));   // 2 + 3
	    System.out.println(minus(7,2));  // 7 - 2
   		System.out.println(minus(2,7));  // 2 - 7
 		System.out.println(times(3,4));  // 3 * 4
   		System.out.println(plus(2,times(4,2)));  // 2 + 4 * 2
   		System.out.println(pow(5,3));      // 5^3
   		System.out.println(pow(3,5));      // 3^5
   		System.out.println(div(12,3));   // 12 / 3    
   		System.out.println(div(5,5));    // 5 / 5  
   		System.out.println(div(25,7));   // 25 / 7
   		System.out.println(mod(25,7));   // 25 % 7
   		System.out.println(mod(120,6));  // 120 % 6    
   		System.out.println(sqrt(36));
		System.out.println(sqrt(263169));
   		System.out.println(sqrt(76123));
	}  

	// Returns x1 + x2
	public static int plus(int x1, int x2) {
		for (int i = 0; i < x2; i++) {
        x1++;
    }
    return x1;
	}

	// Returns x1 - x2
	public static int minus(int x1, int x2) {
		return plus(x1, -x2);
	}

	// Returns x1 * x2
	public static int times(int x1, int x2) {
	boolean negative = false;
    if (x2 < 0) {
        x2 = -x2;
        negative = true;
    }
    int answer = 0;
    for (int i = 0; i < x2; i++) {
        answer = plus(answer, x1);
    }
    if (negative) answer = -answer;
    return answer;
}

	// Returns x^n (for n >= 0)
	public static int pow(int x, int n) {
		int xstay = x;
		int answer = x;
		for (int i = 0; i<n; i++) {
			answer = times(answer, xstay);
		}		return answer;
	}

	// Returns the integer part of x1 / x2 
	public static int div(int x1, int x2) {
		int xnew = x1;
		int i = 0;
		while (xnew >= x2) {
			xnew = minus(xnew, x2);
			i++;
		}
		return i;
	}

	// Returns x1 % x2 example 25 % 7 = 3 . 
	public static int mod(int x1, int x2) {
		int divans = div(x1, x2);
		int answer = minus(x1, times(divans, x2)); 
		return answer;
	}

	// Returns the integer part of sqrt(x) 
	public static int sqrt(int x) {
		 int i = 0;

    	while (times(i, i) <= x) {
       		i++;
   		 }

   	 // When loop ends, i*i > x, so the answer is i-1
    	return minus(i, 1);
	}

}
