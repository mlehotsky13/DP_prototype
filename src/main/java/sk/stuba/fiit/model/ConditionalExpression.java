package sk.stuba.fiit.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.function.Predicate;

public class ConditionalExpression<T> {

	Map<MemoryNode<T>, List<Predicate<MemoryNode<T>>>> conditions = new HashMap<>();
	T value;

	ConditionalExpression(T value) {
		this.value = value;
	}

	ConditionalExpression(T value, MemoryNode<T> conditionNode, List<Predicate<MemoryNode<T>>> predicates) {
		this.value = value;
		conditions.put(conditionNode, predicates);
	}

	public Optional<T> evaluate() {
		for (Entry<MemoryNode<T>, List<Predicate<MemoryNode<T>>>> condition : conditions.entrySet()) {
			MemoryNode<T> memoryNode = condition.getKey();

			for (Predicate<MemoryNode<T>> predicate : condition.getValue()) {
				if (!predicate.test(memoryNode)) {
					return Optional.empty();
				}
			}
		}

		return Optional.of(value);
	}
}
