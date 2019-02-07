package sk.stuba.fiit.model;

public class MemoryValueNode<T> extends MemoryNode<T> {

	T value;

	public MemoryValueNode(String name, T value) {
		super(name);
		this.value = value;
	}

	@Override
	public T evaluate() {
		return value;
	}
}
