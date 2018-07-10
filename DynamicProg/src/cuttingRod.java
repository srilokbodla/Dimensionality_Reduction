/*Given a rod of length n inches and an array of prices that contains prices of all pieces of size smaller than n.
 Determine the maximum value obtainable by cutting up the rod and selling the pieces.
 */


//maximum price of rod length n can be get from maximum price of rod length n-1

import java.util.Scanner;

public class cuttingRod {
	public static void main(String []args) {
		System.out.println("Enter length of rod");
		Scanner in = new Scanner(System.in);
		int length= in.nextInt();
		int cost[] = new int[length];
		int result[] = new int[length+1];
		for(int i=0;i<length;i++) {
			cost[i]=in.nextInt();
		}
		result[0]=0;
		for(int i=1;i<=length;i++) {
			int maxValue=0;
			for(int j=0;j<i;j++) {		// finding maximum cost of rod length of i
			maxValue=Math.max(result[i-j-1]+cost[j], maxValue);
			result[i]=maxValue;
			System.out.println(maxValue);
	}
	}
		System.out.println(result[length]); //result array will contain maximum cost of rod of all length from 1 to n..
											//result[n] will have maximum cost of rod length n
}
}


