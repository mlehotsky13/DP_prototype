package sk.stuba.fiit.model;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import sk.stuba.fiit.analyze.Action;
import sk.stuba.fiit.analyze.Action.ArrayConditionalAddAction;
import sk.stuba.fiit.analyze.Action.ArrayConditionalWriteAction;
import sk.stuba.fiit.analyze.Action.ArraySimpleWriteAction;
import sk.stuba.fiit.analyze.Action.ArrayVariableDeclarationAction;

public class MemoryModel<T> {

	private static final Logger log = LoggerFactory.getLogger(MemoryModel.class);

	private Map<String, List<MemoryNode<T>>> memory = new HashMap<>();

	public MemoryModel<T> processAction(Action<T> action) {
		log.debug("Handling {} action.", Action.class.getSimpleName());

		if (ArrayVariableDeclarationAction.class.equals(action.getClass())) {
			processAction((ArrayVariableDeclarationAction<T>) action);
		} else if (ArraySimpleWriteAction.class.equals(action.getClass())) {
			processAction((ArraySimpleWriteAction<T>) action);
		} else if (ArrayConditionalWriteAction.class.equals(action.getClass())) {
			processAction((ArrayConditionalWriteAction<T>) action);
		} else if (ArrayConditionalAddAction.class.equals(action.getClass())) {
			processAction((ArrayConditionalAddAction<T>) action);
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

	public MemoryModel<T> processAction(ArraySimpleWriteAction<T> action) {
		log.debug("Handling {} action.", ArraySimpleWriteAction.class.getSimpleName());

		MemoryNode<T> memoryNode = memory.get(action.varName).get(action.index);
		memory.get(action.varName).set(action.index, new MemoryValueNode<T>(memoryNode.name, action.value));

		return this;
	}

	public MemoryModel<T> processAction(ArrayConditionalWriteAction<T> action) {
		log.debug("Handling {} action.", ArrayConditionalWriteAction.class.getSimpleName());

		List<MemoryNode<T>> array = memory.get(action.varName);

		for (int i = 0; i < array.size(); i++) {
			MemoryNode<T> memoryNode = array.get(i);

			if (memoryNode instanceof MemoryValueNode) {
				memoryNode = createConditionalNodeFromValueNode((MemoryValueNode<T>) memoryNode);
				array.set(i, memoryNode);
			}

			((MemoryConditionalNode<T>) memoryNode).addConditionalExpression(action.value, action.conditionNode,
					Arrays.asList(getIndexPredicate(action.varName, action.conditionNode)));
		}

		return this;
	}

	public MemoryModel<T> processAction(ArrayConditionalAddAction<T> action) {
		log.debug("Handling {} action.", ArrayConditionalWriteAction.class.getSimpleName());

		List<MemoryNode<T>> array = memory.get(action.varName);

		for (int i = 0; i < array.size(); i++) {
			MemoryNode<T> memoryNode = array.get(i);

			if (memoryNode instanceof MemoryValueNode) {
				memoryNode = createConditionalNodeFromValueNode((MemoryValueNode<T>) memoryNode);
				array.set(i, memoryNode);
			}

			Object addedValue = addValues(memoryNode.evaluate(), action.value);
			// FIX: using ugly hack
			((MemoryConditionalNode<T>) memoryNode).addConditionalExpression((T) addedValue, action.conditionNode,
					Arrays.asList(getIndexPredicate(action.varName, action.conditionNode)));
		}

		return this;
	}

	// FIX: ugly hack
	private Object addValues(T value1, T value2) {
		if (value1 instanceof Integer && value2 instanceof Integer) {
			return (Integer) value1 + (Integer) value2;
		}

		return null;
	}

	private Predicate<MemoryNode<T>> getIndexPredicate(final String varName, final MemoryNode<T> conditionNode) {
		return (memoryNode) -> conditionNode.evaluate().equals(this.memory.get(varName).indexOf(memoryNode));
	}

	private MemoryConditionalNode<T> createConditionalNodeFromValueNode(MemoryValueNode<T> valueNode) {
		MemoryConditionalNode<T> conditionalNode = new MemoryConditionalNode<>(valueNode.name);
		conditionalNode.addConditionalExpression(valueNode.value);

		return conditionalNode;
	}
}
