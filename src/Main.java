public class Main {
    public static void main(String[] args) {
        // Test cases for parenthesesCheck
        System.out.println("Parentheses Check:");
        System.out.println(parenthesesCheck("(())")); // true
        System.out.println(parenthesesCheck(")("));   // false
        System.out.println(parenthesesCheck("()()"));  // true
        System.out.println(parenthesesCheck("(()"));   // false

        // Test cases for reverseInteger
        System.out.println("\nReverse Integer:");
        System.out.println(reverseInteger(1234)); // 4321
        System.out.println(reverseInteger(-5678)); // -8765

        // Test cases for encryptThis
        System.out.println("\nEncrypt This:");
        System.out.println(encryptThis("Hello good day")); // "72olle 103doo 100ya"
        System.out.println(encryptThis("A B C"));            // "65 66 67"

        // Test cases for decipherThis
        System.out.println("\nDecipher This:");
        System.out.println(decipherThis("72olle 103doo 100ya")); // "Hello good day"
        System.out.println(decipherThis("82yade 115te 103o"));   // "Ready set go"
    }

    // 1. parenthesesCheck

    public static boolean parenthesesCheck(String str) {
        int count = 0;
        if (str.length() == 0) {
            return true;
        }
        if (str.charAt(0) == ')' || str.charAt(str.length()-1) == '(') {
                return false;
            }
            else {
                for (int i = 0; i < str.length(); i++) {
                    if (str.charAt(i) == '(') {
                        count++;
                    }
                    else if (str.charAt(i) == ')') {
                        count--;
                    }
                }
                if (count < 0) {
                    return false;
                }
                return count == 0;
            }
        }
    }

    // 2. reverseInteger

    public static String reverseInteger(int n) {
        String reversedStr = "";
        String numStr = Integer.toString(n);
        int length = numStr.length();
        for (int i = length - 1; i >= 0; i--) {
            reversedStr += numStr.charAt(i);
        }
        return reversedStr;
    }

    // 3. encryptThis

public static String encryptThis(String str) {
    String encrypted = "";
    String word = "";
    for (int i = 0; i <= str.length(); i++) {
        if (i == str.length() || str.charAt(i) == ' ') {
            if (!word.isEmpty()) {
                int code = (int) word.charAt(0);
                String encryptedWord = code + "";

                if (word.length() > 1) {
                    char second = word.charAt(1);
                    char last = word.charAt(word.length() - 1);

                    encryptedWord += last;
                    encryptedWord += word.substring(2, word.length() - 1);
                    encryptedWord += second;
                }

                encrypted += encryptedWord + " ";
            }
            word = "";
        } else {
            word += str.charAt(i);
        }
    }
    return encrypted.trim();
}

    // 4. decipherThis

public static String decipherThis(String str) {
    String decryptedMessage = "";
    String word = "";
    for (int i = 0; i <= str.length(); i++) {
        if (i == str.length() || str.charAt(i) == ' ') {
            if (!word.isEmpty()) {
                String decryptedWord = "";
                int codeEndIndex = 0;
                while (codeEndIndex < word.length() && word.charAt(codeEndIndex) >= '0' && word.charAt(codeEndIndex) <= '9') {
                    codeEndIndex++;
                }
                int ascii = Integer.parseInt(word.substring(0, codeEndIndex));
                decryptedWord += (char) ascii;
                if (codeEndIndex < word.length()) {
                    String remaining = word.substring(codeEndIndex);
                    if (remaining.length() > 1) {
                        char second = remaining.charAt(1);
                        char last = remaining.charAt(remaining.length() - 1);
                        decryptedWord += remaining.substring(2, remaining.length() - 1);
                        decryptedWord += last;
                        decryptedWord += second;
                    } else {
                        decryptedWord += remaining;
                    }
                }
                decryptedMessage += decryptedWord + " ";
            }
            word = "";
        } else {
            word += str.charAt(i);
        }
    }
    return decryptedMessage.trim();
}
