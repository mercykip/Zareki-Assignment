package java;

public class CharacterReversing {

	public static String reverseString()
    {
        String s="Lorem at";
        char[] myString = new  char[s.length()];
        int charIndex=0;

        //Get each character of string
        for(int i=s.length()-1; i>=0;i--)
	        {
	            myString[charIndex]=s.charAt(i);
	            charIndex++;
	        }

        String reverseString="";
        for(int i=0; i<s.length(); i++)
	        {
	            reverseString =reverseString + myString[i];
	        }
        reverseString.split(" ");
        System.out.println("reverseString "+reverseString);
            return reverseString;

    }
 public static void main(String[] args) {
        reverseString();

    }
}

