
import java.util.*;




class Ideone
{
	
public static void main (String[] args) throws java.lang.Exception
{

		Scanner sc = new Scanner(System.in);

		int n= sc.nextInt();

		int sum = sc.nextInt();

		int elements[] = new int[n];

		for(int i=0;i<n;i++){

            		elements[i]=sc.nextInt();

		}

		boolean dynamicResult[][] = new boolean[n+1][sum+1];

		for(int i=0;i<=sum;i++){

            		dynamicResult[0][i]=false;

		}

		for(int i=0;i<=n;i++){

            		dynamicResult[i][0]=true;

		}

		for(int i=1;i<=n;i++){

            		for(int j=1;j<=sum;j++){

            			if(j<elements[i-1]){ //if sum is lessthat set value then assign value by not including
 
            					//that value

            				dynamicResult[i][j]=dynamicResult[i-1][j];

            				}

            			else{ //in this we have two possiblites

            				dynamicResult[i][j]=dynamicResult[i-1][j]||dynamicResult[i-1][j-elements[i-1]];

            			}

            		}

		}

		System.out.println(dynamicResult[n][sum]); //dynamicResult[i][j] says whether their is subset in array[0toi] to form sum j

	}

}