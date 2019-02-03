package sk.stuba.fiit.analyze;

public abstract class Action<T> {

	protected String name;
	protected T value;

	public Action(String name) {
		this.name = name;
	}

	public Action(String name, T value) {
		this.name = name;
		this.value = value;
	}

	public static class VariableDeclarationAction<T> extends Action<T> {
		public VariableDeclarationAction(String name) {
			super(name);
		}

		public VariableDeclarationAction(String name, T value) {
			super(name, value);
		}
	}

	public static class ReadAction<T> extends Action<T> {
		public ReadAction(String name, T value) {
			super(name, value);
		}
	}

	public static class WriteAction<T> extends Action<T> {
		public WriteAction(String name, T value) {
			super(name, value);
		}
	}
}
