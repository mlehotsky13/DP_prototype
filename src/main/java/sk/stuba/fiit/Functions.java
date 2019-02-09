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

	public static String func1_a(int i) {
		String result = "";

		int[] arr = { 7, 5, 3, 1 };

		if (arr[i] > 3) {
			result += "1";
		} else {
			result += "2";
		}

		return result;
	}

	public static String func1_b(int i) {
		String result = "";

		int[] arr = { 7, 5, 3, 1 };

		arr[i] = 4;

		if (arr[3] > 3) {
			result += "1";
		} else {
			result += "2";
		}

		return result;
	}

	public static String func1_c(int i) {
		String result = "";

		int[] arr = { 7, 5, 3, 1 };

		arr[i] = 3;

		if (arr[1] > 3) {
			result += "1";
		} else {
			result += "2";
		}

		return result;
	}

	public static String func1_d(int i) {
		String result = "";

		int[] arr = { 7, 5, 3, 1 };

		arr[i] += 2;

		if (arr[i] > 5) {
			result += "1";
		} else {
			result += "2";
		}

		return result;
	}

	public static String func1_e(int i) {
		String result = "";

		int[] arr = { 5, 6, 9, 2, 1, 7, 17, 6, 63 };

		if (i > 3 && i < 8) {
			/* i = {4, 5, 6, 7} */
			result += "1";
			arr[i] += arr[i - 1] + arr[i - 2];
			if (i > 5) {
				result += "2";
				/* i = {6, 7} */
				arr[7] -= 20;
			}
		} else {
			/* i = {0, 1, 2, 3, 8, 9, 10} */
			result += "3";
			arr[i] += 5;
		}

		if (arr[i] > 10) {
			/* i = {2, 4, 5, 7, 8, 9} */
			result += "4";
		} else {
			/* i = {0, 1, 3, 6, 10} */
			result += "5";
		}

		return result;
	}

//
//	public static String func1(int[] arr) {
//		String result = "";
//
//		if (arr[1] > 3) {
//			result += "1";
//		} else {
//			result += "2";
//		}
//
//		return result;
//	}
//
//	public static String func2(int[] arr, int i) {
//		String result = "";
//
//		if (arr[i] > 3) {
//			result += "1";
//		} else {
//			result += "2";
//		}
//
//		return result;
//	}
//
//	public static String func2a(int[] arr, int i) {
//		String result = "";
//
//		if (i > 6) {
//			result += "1";
//			if (arr[i] > 3) {
//				result += "2";
//			} else {
//				result += "3";
//			}
//		} else {
//			result += "4";
//		}
//
//		return result;
//	}
//
//	// TODO: ensure unique resulting value for cycle
//	public static String func2b(int[] arr, int i) {
//		String result = "";
//
//		for (int j = 0; j < 6; j++) {
//			result += "1";
//			if (i < j) {
//				result += "2";
//				if (arr[j] > 3) {
//					result += "3";
//				} else {
//					result += "4";
//				}
//			} else {
//				result += "5";
//			}
//		}
//
//		return result;
//	}
//
//	public static String func7(int[] arr, int i, int j) {
//		String result = "";
//
//		if (j > 3) {
//			result += "1";
//			arr[j] += 5;
//		} else {
//			result += "2";
//			arr[i] += arr[j];
//		}
//
//		if (arr[i] > 10) {
//			result += "3";
//		} else {
//			result += "4";
//		}
//
//		return result;
//	}
}
