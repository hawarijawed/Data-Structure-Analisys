package stack;
import java.util.*;
public class reverseString {
	public static String reverse(String str)
	{
		Stack<Character> s = new Stack<>();
		// For length of the string;
		int index = 0;
		// Insertion of given string into stack
		for(index=0;index<str.length();index++)
		{
			s.push(str.charAt(index));
		}
		StringBuilder result = new StringBuilder("");
		// Popping of the characters of the string from stack and storing them into result variable
		while(!s.isEmpty())
		{
			result.append(s.pop());
		}
		// toString() function has been used to covert data type of result to string and stores it back to str variable
		str = result.toString();
		return str;
	
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String name = "Jawed hawari";
		System.out.println("Reverse of the string: "+reverse(name));
		

	}

}
