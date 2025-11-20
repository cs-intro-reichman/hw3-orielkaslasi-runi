public class test {
        
        
}
public static int lengthOfLastWord(String str) {
        int end = (str.length() - 1);
        while (end >= 0) {
            if (sentence.charAt(end) != ' ') {
                break;
            }
            end--;
        }
        
        int start = end;
        while (end >= 0) {
            if (sentence.charAt(start) == ' ') {
                break;
            }
        start--;
        }
    return end - start;
}

public static String[] lengthOfLastWord(String str) {
        int end = (str.length() - 1);
        while (end >= 0) {
            if (sentence.charAt(end) != ' ') {
                break;
            }
            end--;
        }
        
        int start = end;
        while (end >= 0) {
            if (sentence.charAt(start) == ' ') {
                break;
            }
        start--;
        }
    return end - start;
}
