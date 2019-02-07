package sk.stuba.fiit.generate;

import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import sk.stuba.fiit.analyze.Action;
import sk.stuba.fiit.analyze.Analyzer;
import sk.stuba.fiit.constants.Function;
import sk.stuba.fiit.model.MemoryModel;

public class GeneratorServiceImpl implements GeneratorService {

	private static final Logger log = LoggerFactory.getLogger(GeneratorServiceImpl.class);

	private Analyzer analyzer;
	private MemoryModel<Integer> memoryModel;

	public GeneratorServiceImpl() {
		memoryModel = new MemoryModel<>();
	}

	public GeneratorServiceImpl(Analyzer analyzer, MemoryModel<Integer> memoryModel) {
		this.analyzer = analyzer;
		this.memoryModel = memoryModel;
	}

	@Override
	public Map<String, ?> generateInputs(Function function) {
		Method method = function.getMethod().orElseThrow(() -> new RuntimeException("No appropriate function found!"));

		log.debug("Starting generation of inputs for function: {}", function.name());
		return generateInputs(method);
	}

	private Map<String, ?> generateInputs(Method method) {
		// Analyze method and get actions
		List<Action<Integer>> actions = analyzer.analyzeMethod(method);

		// Process all actions from method in MemoryModel
		actions.forEach(action -> memoryModel.processAction(action));

		return null;
	}
}
