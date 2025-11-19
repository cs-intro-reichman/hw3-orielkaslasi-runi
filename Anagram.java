/** Functions for checking if a given string is an anagram. */
public class Anagram {
	public static void main(String args[]) {
		// Tests the isAnagram function.
		System.out.println(isAnagram("silent","listen"));  // true
		System.out.println(isAnagram("William Shakespeare","I am a weakish speller")); // true
		System.out.println(isAnagram("Madam Curie","Radium came")); // true
		System.out.println(isAnagram("Tom Marvolo Riddle","I am Lord Voldemort")); // true

		// Tests the preProcess function.
		System.out.println(preProcess("What? No way!!!"));
		
		// Tests the randomAnagram function.
		System.out.println("silent and " + randomAnagram("silent") + " are anagrams.");
		
		// Performs a stress test of randomAnagram 
		String str = "1234567";
		Boolean pass = true;
		//// 10 can be changed to much larger values, like 1000
		for (int i = 0; i < 10; i++) {
			String randomAnagram = randomAnagram(str);
			System.out.println(randomAnagram);
			pass = pass && isAnagram(str, randomAnagram);
			if (!pass) break;
		}
		System.out.println(pass ? "test passed" : "test Failed");
	}  

	// Returns true if the two given strings are anagrams, false otherwise.
	public static boolean isAnagram(String str1, String str2) {
		String pro1 = preProcess(str1);
		String pro2 = preProcess(str2);
		if (pro1.length() != pro2.length()) {
			return false;
		}
		for (int i = 0; i < pro1.length(); i++) {
			char ch1 = pro1.charAt(i);
			boolean found = false;

			for (int k = 0; k < pro2.length(); k++) {
			if (ch1 == pro2.charAt(k)) {
				pro2 = pro2.substring(0, k) + pro2.substring(k + 1);
                found = true;
                break;
			}
		}
			if (!found) {
				return false;
			}
		}
		return true;
}	
	   
	// Returns a preprocessed version of the given string: all the letter characters are converted
	// to lower-case, and all the other characters are deleted, except for spaces, which are left
	// as is. For example, the string "What? No way!" becomes "whatnoway"
	public static String preProcess(String str) {
		int i = 0;
		String newStr = "";
		while (i<str.length()) {
			char ch = str.charAt(i);
			
			if (ch >= 'A' && ch <= 'Z') {
				newStr = newStr + (char)(ch + 32);
			}
			else if (ch >= 'a' && ch <= 'z') {
				newStr += ch;
			}
			else if (ch == ' ') {
				newStr += ch;
			}
			i++;
		}
		return newStr;
	} 
	   
	// Returns a random anagram of the given string. The random anagram consists of the same
	// characters as the given string, re-arranged in a random order. 
	public static String randomAnagram(String str) {
		String anagram = "";

    while (str.length() > 0) {
        int index = (int)(Math.random() * str.length());
        char chosen = str.charAt(index);

        anagram += chosen;

        str = str.substring(0, index) + str.substring(index + 1);
    }

    return anagram;
}
}