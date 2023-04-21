// Madison Manuel
// 4/20/23
// LeetCode problem "Roman to Integer", Difficulty: Easy

import java.util.*;
import java.io.*;

public class romanToInt {
    public static int romanToInt(String s) {
        int sum = 0;
        char current;
        int value = 0;
		ArrayList<Integer> nums = new ArrayList<>();
        for (int i = 0; i < s.length(); i++)
        {
            current = s.charAt(i);
            switch (current)
            {
                case 'I':
                    nums.add(1);
					break;
                case 'V':
				nums.add(5);
					break;
                case 'X':
					nums.add(10);
					break;
                case 'L':
					nums.add(50);
					break;
                case 'C':
					nums.add(100);
					break;
                case 'D':
					nums.add(500);
					break;
                case 'M':
					nums.add(1000);
					break;
            }
		}
		for(int j = 0; j < s.length(); j++)
		{
			if(j != (s.length() - 1))
				if(nums.get(j) < nums.get(j + 1))
				{
					sum -= nums.get(j);
					continue;
				}
			
			sum += nums.get(j);
		}
        return sum;
    }

	public static void main(String args[])
	{
		int answer = romanToInt("III");
		System.out.printf("%d\n", answer);
		answer = romanToInt("LVIII");
		System.out.printf("%d\n", answer);
		answer = romanToInt("MCMXCIV");
		System.out.printf("%d", answer);

		// Passed this LeetCode problem with a 5ms runtime and great memory usage!
		// Could have done slightly better iterating backwards in the string...
	}
}
