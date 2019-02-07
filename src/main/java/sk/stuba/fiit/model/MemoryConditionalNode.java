package sk.stuba.fiit.model;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.Optional;

public class MemoryConditionalNode<T> extends MemoryNode<T> {

	Deque<ConditionalExpression<T>> conditionalExpressions = new ArrayDeque<>();

	// TODO
	public MemoryConditionalNode(String name) {
		super(name);
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