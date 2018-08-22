public class AnagramStringTest {

	public static void main(String[] args) {
		String s1 = "hemkar";
		String s2 = "karhem";

		System.out.println(checknangram(s1, s2));

	}

	private static boolean checknangram(String s1, String s2) {
		char ch[] = s1.toCharArray();
		for (char c : ch) {
			if (s2.indexOf(c) != -1) {
				s2 = s2.substring(0, s2.indexOf(c))
						+ s2.substring(s2.indexOf(c) + 1);
			} else {
				return false;
			}
		}
		System.out.println(s2.length());
		return s2.isEmpty();
	}
}
