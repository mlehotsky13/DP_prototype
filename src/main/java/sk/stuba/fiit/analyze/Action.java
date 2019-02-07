package sk.stuba.fiit.analyze;

import java.util.List;

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

	public static class ArrayReadAction<T> extends Action<T> {
		public int index;

		public ArrayReadAction(String name, int index) {
			super(name);
			this.index = index;
		}
	}

	public static class ArrayWriteAction<T> extends Action<T> {
		public int index;
		public T value;

		public ArrayWriteAction(String name, int index, T value) {
			super(name);
			this.index = index;
			this.value = value;
		}
	}

	public static class ArrayComparisonAction<T> extends Action<T> {
		public int index;
		public T value;

		public ArrayComparisonAction(String name, int index, T value) {
			super(name);
			this.index = index;
			this.value = value;
		}
	}
}
