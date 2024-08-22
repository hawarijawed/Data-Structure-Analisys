/******************************************************************************

Bit Manipulation

*******************************************************************************/

public class Main
{
    //Get method of Bit
    public static int getBit(int n, int pos){
        int bitMask = 1<<pos;
        if((bitMask & n) ==0){
            return 0;
        }
        
        return 1;
    }
    
    //Set Bit method 
    public static int setBit(int n, int pos){
        int bitMask = 1<<pos; //performing left shift
        int val = n | bitMask;
        return val;
    }
    
    //Remove bit method
    public static int removeBit(int n, int pos){
        int bitMask = 1<<pos;
        int notBitMask = ~(bitMask);
        int compliment = notBitMask & n;
        return compliment;
    }
    //Odd even 
    public static void oddEven(int n){
        if((n & 1) == 1){
            System.out.println("Number is odd");
        }
        else{
            System.out.println("Number is even");
        }
    }
    public static void PrintBits(int n){
        // Printing 8 bits number 
        
        for(int i=7; i>=0; i--){
            
            System.out.print((n>>i)&1);
        }
    }
    //Toggling ith Bit
    public static int toggleBit(int n, int i){
        int bitMask = 1<<i;
        System.out.print("\nBefor toggle: ");
        PrintBits(n);
        int num = n^bitMask;
        System.out.print("\nAfter toggle: ");
        PrintBits(num);
        
        return num;
    }
    public static int unsetIthBit(int n, int i){
        int bitMask = 1<<i;
        System.out.print("Before unsetting the "+i+" bit: ");
        PrintBits(n);
        int num = n & ~(bitMask);
        System.out.print("\nAfter unsetting the "+i+" bit:");
        PrintBits(num);
        return num;
    }
    
    public static int unsetMSB(int n){
        return ((n&n-1));
    }
    //find number of set bits in number 
    public static void SetBits(int n){
        int count = 0;
        while(n != 0){
            n = unsetMSB(n);
            count++;
        }
        System.out.println("\nNumber of 1 bits : "+count);
    }
	public static void main(String[] args) {
		System.out.println("Hello World");
// 		System.out.println("Bit is "+ getBit(5,2));
// 		System.out.println("Bit is "+ getBit(10,3));
// 		System.out.println("Bit:1010, pos = 2:  "+ setBit(10,2));
// 		System.out.println("Bit:100, pos = 1 : "+ setBit(4,1));
        // System.out.println("compliment of 5: "+removeBit(5,2));
        // int n1 = 5;
        // System.out.println("Compliment of 5: "+ ~(n1));
        // oddEven(8);
        PrintBits(89);
        // System.out.println("\nToggling 2nd bit in 1010: "+toggleBit(10, 2));
        
        // System.out.println("\nUnsetting the bit of 10: "+unsetIthBit(89,3));
        SetBits(89);
	}
}