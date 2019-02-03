package sk.stuba.fiit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import sk.stuba.fiit.constants.Function;
import sk.stuba.fiit.generate.GeneratorService;
import sk.stuba.fiit.generate.GeneratorServiceImpl;

/**
 * Prototype App for variable storage-referencing problem handling in symbolic
 * execution
 * 
 * @author Miroslav Lehotsky
 *
 */
public class App {

	private static final Logger log = LoggerFactory.getLogger(App.class);

	private static final Function FUNC = Function.FUNC_1;

	public static void main(String[] args) {
		log.info("Starting App...");

		GeneratorService generatorService = new GeneratorServiceImpl();
		generatorService.generateInputs(FUNC);

		log.info("Ending App...");
	}
}