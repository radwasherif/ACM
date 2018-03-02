package algorithms;

import java.util.Arrays;

import javax.swing.plaf.synth.SynthSpinnerUI;

public class Permute {
	public static void main(String[] args) {
		String s = "abc";
		permute(0, s.length() - 1, s.toCharArray());
		System.out.println(c);
	}

	static int c;

	static void permute(int start, int end, char arr[]) {
		if (start == end) {
			System.out.println(new String(arr));
			c++;
			return;
		}
//		permute(start + 1, end, arr); 
		for (int i = start; i <= end; i++) {
			swap(start, i, arr);
			permute(start + 1, end, arr);
			swap(i, start, arr);
		}

	}

	static void swap(int i, int j, char[] arr) {
		char tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}

}
