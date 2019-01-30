package sk.stuba.fiit;

public abstract class Functions {

	public static String func0(int x) {
		String result = "";

		if (x > 3) {
			result += "1";
		} else {
			result += "2";
		}

		return result;
	}

	public static String func1(int[] arr) {
		String result = "";

		if (arr[1] > 3) {
			result += "1";
		} else {
			result += "2";
		}

		return result;
	}

	public static String func2(int[] arr, int i) {
		String result = "";

		if (arr[i] > 3) {
			result += "1";
		} else {
			result += "2";
		}

		return result;
	}

	public static String func2a(int[] arr, int i) {
		String result = "";

		if (i > 6) {
			result += "1";
			if (arr[i] > 3) {
				result += "2";
			} else {
				result += "3";
			}
		} else {
			result += "4";
		}

		return result;
	}

	// TODO: ensure unique resulting value for cycle
	public static String func2b(int[] arr, int i) {
		String result = "";

		for (int j = 0; j < 6; j++) {
			result += "1";
			if (i < j) {
				result += "2";
				if (arr[j] > 3) {
					result += "3";
				} else {
					result += "4";
				}
			} else {
				result += "5";
			}
		}

		return result;
	}

	public static String func3(int i) {
		String result = "";

		int[] arr = { 7, 5, 3, 1 };

		if (arr[i] > 3) {
			result += "1";
		} else {
			result += "2";
		}

		return result;
	}

	public static String func7(int[] arr, int i, int j) {
		String result = "";

		if (j > 3) {
			result += "1";
			arr[j] += 5;
		} else {
			result += "2";
			arr[i] += arr[j];
		}

		if (arr[i] > 10) {
			result += "3";
		} else {
			result += "4";
		}

		return result;
	}
}
