import java.awt.List;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class TopologicalSort {
	LinkedList[] adj;
	int count;
	Queue q = new LinkedList();
	int visited[];
	private static Scanner sc;
	TopologicalSort(int n){
		count=0;
		adj = new LinkedList[n];
		for(int i = 0; i < n ; i++){
            adj[i] = new LinkedList<>();
        }
		 visited = new int[n];
	}
	void addEdge(int a, int b) {
		adj[a-1].add(b);
	}
	void init(int n) {
		for(int i=0;i<n;i++) {
			Iterator<Integer> curr = adj[i].iterator();
			while(curr.hasNext()) {
				visited[curr.next()-1]++;
			}
		}
	}
	void print(int n) {
		for(int i=0;i<n;i++) {
			//System.out.println(visited[i]);
			if(visited[i]==0) {
				q.add(i+1);
			}
		}
		while(!q.isEmpty()) {
			System.out.println(q.element());
			count++;
			Iterator<Integer> curr = adj[(int) q.element()-1].iterator();
			//System.out.println(curr.hasNext());
			while(curr.hasNext()) {
				int temp=curr.next();
				visited[temp-1]--;
				//System.out.println(curr.next());
				if(visited[temp-1]==0) {
					q.add(temp);
				}
			}
			q.remove();
		}
		if(q.isEmpty() && count!=n) {
			System.out.println("Cycle is found");
		}
	}

	public static void main(String[] args) {
		sc = new Scanner(System.in);
		int n,e;
		n=sc.nextInt();
		e=sc.nextInt();
		TopologicalSort t= new TopologicalSort(n);
		for(int i=0;i<e;i++) {
			int p,c;
			p=sc.nextInt();
			c=sc.nextInt();
			t.addEdge(p,c);
		}
		t.init(n);
		t.print(n);
	}
}
