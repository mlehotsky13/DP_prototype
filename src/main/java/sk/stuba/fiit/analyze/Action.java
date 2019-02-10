package sk.stuba.fiit.analyze;

import java.util.List;

import sk.stuba.fiit.model.MemoryNode;

public abstract class Action<T> {

	public String varName;
	public int minApplicableIndex;
	public int maxApplicableIndex;

	public Action(String name) {
		this.varName = name;
		this.minApplicableIndex = 0;
		this.maxApplicableIndex = Integer.MAX_VALUE;
	}

	public Action(String name, int minApplicableIndex, int maxApplicableIndex) {
		this.varName = name;
		this.minApplicableIndex = minApplicableIndex;
		this.maxApplicableIndex = maxApplicableIndex;
	}

	public static class ArrayVariableDeclarationAction<T> extends Action<T> {
		public List<T> values;

		public ArrayVariableDeclarationAction(String name, List<T> values) {
			super(name);
			this.values = values;
		}
	}

	public static class ArraySimpleWriteAction<T> extends Action<T> {
		public Integer index;
		public T value;

		public ArraySimpleWriteAction(String name, int index, T value) {
			super(name);
			this.index = index;
			this.value = value;
		}
	}

	public static class ArraySimpleSubtractAction<T> extends Action<T> {
		public Integer index;
		public T value;

		public ArraySimpleSubtractAction(String name, int index, T value) {
			super(name);
			this.index = index;
			this.value = value;
		}
	}

	public static class ArrayConditionalWriteAction<T> extends Action<T> {
		public MemoryNode<T> conditionNode;
		public T value;

		public ArrayConditionalWriteAction(String name, MemoryNode<T> conditionNode, T value) {
			super(name);
			this.conditionNode = conditionNode;
			this.value = value;
		}
	}

	public static class ArrayConditionalAddAction<T> extends Action<T> {
		public MemoryNode<T> conditionNode;
		public T value;

		public ArrayConditionalAddAction(String name, MemoryNode<T> conditionNode, T value) {
			super(name);
			this.conditionNode = conditionNode;
			this.value = value;
		}
	}

	public static class ArrayConditionalAddByMinusIndexAction<T> extends Action<T> {
		public Integer minusIndex;
		public MemoryNode<T> conditionNode;
		public T value;

		public ArrayConditionalAddByMinusIndexAction(String name, MemoryNode<T> conditionNode, int minusIndex,
				int minApplicableIndex, int maxApplicableIndex) {
			super(name, minApplicableIndex, maxApplicableIndex);
			this.conditionNode = conditionNode;
			this.minusIndex = minusIndex;
		}
	}
}
