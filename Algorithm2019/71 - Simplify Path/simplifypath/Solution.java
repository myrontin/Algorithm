package simplifypath;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {

	public String simplifyPath(String path) {
		String[] array = path.split("/");
		StringBuilder sb = new StringBuilder("/");
		Queue<String> queue = new LinkedList<>();
		
		for (int i = 0; i < array.length; i++) {
	

		}

		return sb.toString();
	}

	public static void main(String[] args) {

		String path = "/a/../../b/../c//.//";
		String[] array = path.split("/");
		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}

	}

}
