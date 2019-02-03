package sk.stuba.fiit.constants;

import java.lang.reflect.Method;
import java.util.Optional;

import sk.stuba.fiit.Functions;
import sk.stuba.fiit.util.Utils;

public enum Function {

	FUNC_0("func0"), //
	FUNC_1("func1"), //
	FUNC_2("func2"), //
	FUNC_2A("func2a"), //
	FUNC_2B("func2b"), //
	FUNC_3("func3"), //
	FUNC_7("func7");//

	private String name;

	private Function(String name) {
		this.name = name;
	}

	public Optional<Method> getMethod() {
		return Utils.findMethod(Functions.class, this.name);
	}
}
