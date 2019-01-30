package sk.stuba.fiit.model;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.function.Predicate;

public class ConditionalExpression<T> {

	Map<MemoryNode<?>, List<Predicate<?>>> conditions;
	T value;

	public Optional<T> evaluate() {
		for (Entry<MemoryNode<?>, List<Predicate<?>>> condition : conditions.entrySet()) {
			MemoryNode<?> memoryNode = condition.getKey();

			for (Predicate predicate : condition.getValue()) {
				if (!predicate.test(memoryNode)) {
					return Optional.empty();
				}
			}
		}

		return Optional.of(value);
	}
}
