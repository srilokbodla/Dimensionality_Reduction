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
			for(int j=0;j<i;j++) {
			maxValue=Math.max(result[i-j-1]+cost[j], maxValue);
			result[i]=maxValue;
			System.out.println(maxValue);
	}
	}
		System.out.println(result[length]);
}
}
