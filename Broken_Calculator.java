package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Broken_Calculator {

	private int maxDepth;
	private int minCount;
	private boolean[] used;
	private ArrayList<Integer> pmt;
	ArrayList<Integer> ret;

	public ArrayList<Integer> permute(int[] num, int range) {
		ret = new ArrayList<Integer>();
		if (num == null || num.length == 0)
			return ret;
		maxDepth = num.length;
		used = new boolean[num.length];
		pmt = new ArrayList<Integer>();
		Arrays.fill(used, false);
		Arrays.sort(num);
		maxDepth = 2;
		dfs(0, num, range);
		maxDepth = 3;
		dfs(0, num, range);
		return ret;
	}

	private void dfs(int depth, int[] num, int range) {
		if (depth == maxDepth) {
			ArrayList<Integer> one = new ArrayList<Integer>(pmt);
			int n = 0;
			for(int i : one){
				n = n * 10 + i;
			}
			if(n <= range)
			ret.add(n);
			return;
		}
		for (int i = 0; i < num.length; i++) {
			if (!used[i]) {
				if (i != 0 && num[i] == num[i - 1] && used[i - 1])
					continue;
				used[i] = true;
				pmt.add(num[i]);
				dfs(depth + 1, num, range);
				pmt.remove((Integer) num[i]);
				used[i] = false;
			}
		}
	}
	
	private void dfs2(int num, ArrayList<Integer> but,
			ArrayList<Integer> path) {
		if(num == 1){
			if(compute(path)< minCount){
				minCount =compute(path);
			}
			return;
		}
		for(int i = 0; i< but.size(); i++){
			int j = but.get(i);
			if(j!=1&&num%j==0){
				path.add(j);
				dfs2(num/j, but, path);
				path.remove(path.size()-1);
			}
		}
	}
	
	private int compute2(int n){
		if(n==0) return 1;
		int count =0;
		while(n != 0){
			count++;
			n/=10;
		}
		return count;
	}
	private int compute(ArrayList<Integer> path) {
		int count = 0; 
		for(int i: path){
			count+=compute2(i);
			count++;
		}
		return count;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		int T = scanner.nextInt();
		for(int i = 1; i <= T; i++){
			ArrayList<Integer> butArr = new ArrayList<Integer>();
			for(int j = 0; j < 10; j++){
				int n = scanner.nextInt();
				if(n != 0) butArr.add(j);
			}
			int X = scanner.nextInt();
			int[] num = new int[butArr.size()];
			for(int k = 0; k < butArr.size(); k++)
				num[k]=butArr.get(k);
			Broken_Calculator instance = new Broken_Calculator();
			ArrayList<Integer> add = instance.permute(num, X);
			butArr.addAll(add);
			if(butArr.contains(0))
				butArr.remove(new Integer(0));
			if(butArr.contains(1))
				butArr.remove(new Integer(1));
			instance.minCount = Integer.MAX_VALUE;
			ArrayList<Integer> path = new ArrayList<Integer>();
			instance.dfs2(X, butArr, path);
			if(i==1)
			  System.out.println();
			if(instance.minCount!=Integer.MAX_VALUE)
		    System.out.println("Case #"+ i +": "+ instance.minCount);
			else {
				System.out.println("Case #"+ i +": "+ "Impossible");
			}
		}
	}

}
