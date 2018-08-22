import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;
/**
 * 
 * @author Hemkar
 * program to print all duplicate in a string 
 *
 */
public class DuplicateCharFromString {

	public static void main(String[] args) {
		String s = "aapplekjsdks";
		System.out.println("using array");
		findDuplicateUsingArray(s);
		System.out.println("using map");
		findDuplicateUsingHashMap(s);
	}

	private static void findDuplicateUsingHashMap(String s) {
		HashMap<Character, Integer> hm = new HashMap<Character, Integer>();

		for (int i = 0; i < s.length(); i++) {
			Character c = s.charAt(i);
			if (hm.get(c) == null) {
				hm.put(c, 1);
			} else {
				hm.put(c, hm.get(c) + 1);
			}
		}

		Set<Entry<Character, Integer>> set = hm.entrySet();
		for (Entry<Character, Integer> entry : set) {
			if (entry.getValue() > 1) {
				System.out.println(entry.getKey() + " " + entry.getValue());
			}
		}
	}

	private static void findDuplicateUsingArray(String s) {
		int str[] = new int[150];

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			str[(int) c] = ++str[(int) c];
		}
		for (int i = 0; i < str.length; i++) {
			if (str[i] > 1) {
				System.out.println((char) i + " " + str[i]);
			}
		}
	}
}
