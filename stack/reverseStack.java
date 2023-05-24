package stack;
import java.util.*;
public class reverseStack {
	public static void reverse(Stack<Integer> s)
	{
		if(s.isEmpty())
		{
			// If stack is empty no operation is performed on it;
			return;
		}
		int top = s.pop();
		reverse(s);
		pushAtBottom(s,top);
	}

	public static void pushAtBottom(Stack<Integer> s, int data) {
		// TODO Auto-generated method stub
		// Base condition
		if(s.isEmpty())
		{
			s.push(data);
			return;
		}
		int top = s.pop();
		// Making recursive call
		pushAtBottom(s, data);
		s.push(top);
	}
	public static void Print(Stack<Integer> s)
	{
		while(!s.isEmpty())
		{
			System.out.println(s.pop());
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stack<Integer> s = new Stack<>();
		s.push(8);
		s.push(7);
		s.push(6);
		s.push(5);
		s.push(4);
		
		reverse(s);
		System.out.println("---");
		Print(s);
		System.out.println("**");

	}

}
