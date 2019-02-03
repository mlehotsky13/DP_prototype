package sk.stuba.fiit.analyze;

import java.lang.reflect.Method;
import java.util.List;

public interface Analyzer {

	public List<Action> analyzeMethod(Method method);
}
