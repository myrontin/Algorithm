package coursescheduleII;

import java.util.*;

class Solution {

	public static int[] findOrder(int numCourses, int[][] prerequisites) {
		int length = prerequisites.length;
		int[] indegree = new int[numCourses];
		//boolean[] isVisited = new boolean[length];
		// init indegree
		for (int i = 0; i < length; i++) {
			indegree[prerequisites[i][0]]++;
		}

		Queue<Integer> queue = new LinkedList<>();
		for (int i = 0; i < indegree.length; i++) {
			if (indegree[i] == 0)
				queue.offer(i);
		}
		int[] result = new int[numCourses];
		int count =0;
		while (!queue.isEmpty()) {
			int n = queue.poll();
			result[count++] =n;
			for (int i = 0; i < length; i++) {
				if (indegree[prerequisites[i][0]]>0&&prerequisites[i][1] == n) {
					indegree[prerequisites[i][0]]--;
					if (indegree[prerequisites[i][0]] == 0) {
						//isVisited[prerequisites[i][0]]
						queue.offer(prerequisites[i][0]);
					}
				}

			}
		}

		if (count != numCourses)
			return new int[0];

		return result;
	}

	public static void main(String[] args) {
		int[][] prerequisites = { { 1, 0 }, { 2, 0 }, { 3, 1 }, { 3, 2 } };
		int[][] prerequisites1 = { { 0, 1 } };
		int[][] prerequisites2 = {};
		int[][] prerequisites3 = { { 2, 0 }, { 2, 1 } };
		int[][] prerequisites4 = { { 0, 1 }, { 1, 0 } };
		int[] result = findOrder(4, prerequisites);
		for (int n : result) {
			System.out.println(n);
		}
	}

}
