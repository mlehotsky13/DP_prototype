package sk.stuba.fiit.util;

import java.lang.reflect.Method;
import java.util.Optional;

public class Utils {

	public static Optional<Method> findMethod(Class c, String methodName) {
		for (Method m : c.getDeclaredMethods()) {
			if (methodName.contains(m.getName())) {
				return Optional.of(m);
			}
		}

		return Optional.empty();
	}
}
