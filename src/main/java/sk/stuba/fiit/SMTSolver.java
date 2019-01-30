package sk.stuba.fiit;

import java.util.List;
import java.util.function.Predicate;

import sk.stuba.fiit.model.MemoryNode;

public interface SMTSolver {

	public <T> T getSatisfyingValue(MemoryNode<T> memoryNode, List<Predicate<T>> predicates);
}
