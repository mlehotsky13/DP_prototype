package sk.stuba.fiit.model;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public class MemoryConditionalNode<T> extends MemoryNode<T> {

	Deque<ConditionalExpression<T>> conditionalExpressions = new ArrayDeque<>();

	// TODO
	MemoryConditionalNode(String name) {
		super(name);
	}

	void addConditionalExpression(T value, MemoryNode<T> conditionNode, List<Predicate<MemoryNode<T>>> predicates) {
		conditionalExpressions.push(new ConditionalExpression<>(value, conditionNode, predicates));
	}

	@Override
	public T evaluate() {
		Iterator<ConditionalExpression<T>> it = conditionalExpressions.iterator();

		while (it.hasNext()) {
			ConditionalExpression<T> conditionalExpression = it.next();
			Optional<T> result = conditionalExpression.evaluate();

			if (result.isPresent()) {
				return result.get();
			}
		}

		return null;
	}
}