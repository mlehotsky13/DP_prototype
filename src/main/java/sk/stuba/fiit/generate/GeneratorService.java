package sk.stuba.fiit.generate;

import java.util.Map;

import sk.stuba.fiit.constants.Function;

public interface GeneratorService {
	public Map<String, ?> generateInputs(Function function);
}
