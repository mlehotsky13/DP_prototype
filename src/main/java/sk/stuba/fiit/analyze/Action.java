package sk.stuba.fiit.analyze;

import java.util.List;

import sk.stuba.fiit.model.MemoryNode;

public abstract class Action<T> {

	public String varName;

	public Action(String name) {
		this.varName = name;
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

	public static class ArrayConditionalWriteAction<T> extends Action<T> {
		public Integer index;
		public MemoryNode<T> conditionNode;
		public T value;

		public ArrayConditionalWriteAction(String name, MemoryNode<T> conditionNode, T value) {
			super(name);
			this.conditionNode = conditionNode;
			this.value = value;
		}
	}
}
