package sk.stuba.fiit.model;

public class MemoryValueNode<T> extends MemoryNode<T> {

	T value;

	@Override
	public T evaluate() {
		return value;
	}
}
