package sk.stuba.fiit.model;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import sk.stuba.fiit.analyze.Action;
import sk.stuba.fiit.analyze.Action.ArrayReadAction;
import sk.stuba.fiit.analyze.Action.ArrayVariableDeclarationAction;
import sk.stuba.fiit.analyze.Action.ArrayWriteAction;

public class MemoryModel<T> {

	private static final Logger log = LoggerFactory.getLogger(MemoryModel.class);

	protected Map<String, List<MemoryNode<T>>> memory = new HashMap<>();

	public MemoryModel<T> processAction(Action<T> action) {
		log.debug("Handling {} action.", Action.class.getSimpleName());

		if (ArrayVariableDeclarationAction.class.equals(action.getClass())) {
			processAction((ArrayVariableDeclarationAction<T>) action);
		} else if (ArrayReadAction.class.equals(action.getClass())) {
			processAction((ArrayReadAction<T>) action);
		} else if (ArrayWriteAction.class.equals(action.getClass())) {
			processAction((ArrayWriteAction<T>) action);
		}

		return this;
	}

	public MemoryModel<T> processAction(ArrayVariableDeclarationAction<T> action) {
		log.debug("Handling {} action.", ArrayVariableDeclarationAction.class.getSimpleName());

		memory.put(action.varName, new LinkedList<MemoryNode<T>>());

		for (int i = 0; i < action.values.size(); i++) {
			String nodeName = action.varName + "[" + i + "]";
			MemoryNode<T> memoryNode = new MemoryValueNode<>(nodeName, action.values.get(i));

			memory.get(action.varName).add(memoryNode);
		}

		log.debug("Initialized array {}: {}", action.varName, memory.get(action.varName));

		return this;
	}

	public MemoryModel<T> processAction(ArrayReadAction<T> action) {
		log.debug("Handling {} action.", ArrayReadAction.class.getSimpleName());

		return this;
	}

	public MemoryModel<T> processAction(ArrayWriteAction<T> action) {
		log.debug("Handling {} action.", ArrayWriteAction.class.getSimpleName());

		return this;
	}

	// public MemoryModel<T> processAction(Action<T> action) {
	// log.debug("Handling {} action.", action.getClass().getSimpleName());
	// System.out.println("Handling " + action.getClass().getSimpleName() + "
	// action.");
	// System.out.println("Handling " + action.getClass().getSimpleName() + "
	// action.");

	// return this;
	// }

	// public List<T> getVarValues(String varName) {
	// return memory.get(varName)//
	// .stream()//
	// .map(memoryNode -> memoryNode.evaluate())//
	// .collect(Collectors.toList());
	// }

	// public T getVarValueAtIndex(String varName, int index) {
	// return memory.get(varName).get(index).evaluate();
	// }
}
