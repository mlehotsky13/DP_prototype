package sk.stuba.fiit;

public abstract class Functions {

	public static int func0(int x) {
		int result = 0;

		if (x > 3) {
			result += 1;
		} else {
			result += 2;
		}

		return result;
	}

	public static int func1(int[] arr) {
		int result = 0;

		if (arr[1] > 3) {
			result += 1;
		} else {
			result += 2;
		}

		return result;
	}

	public static int func2(int[] arr, int i) {
		int result = 0;

		if (arr[i] > 3) {
			result += 1;
		} else {
			result += 2;
		}

		return result;
	}

	public static int func2a(int[] arr, int i) {
		int result = 0;

		if (i > 6) {
			if (arr[i] > 3) {
				result += 1;
			} else {
				result += 2;
			}
		} else {
			result += 4;
		}

		return result;
	}

	// TODO: ensure unique resulting value for cycle
	public static int func2b(int[] arr, int i) {
		int result = 0;

		for (int j = 0; j < 6; j++) {
			if (i < j) {
				if (arr[j] > 3) {
					result += 1;
				} else {
					result += 2;
				}
			} else {
				result += 4;
			}
		}

		return result;
	}

	public static int func3(int i) {
		int result = 0;

		int[] arr = { 7, 5, 3, 1 };

		if (arr[i] > 3) {
			result += 1;
		} else {
			result += 2;
		}

		return result;
	}
}
