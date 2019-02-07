package sk.stuba.fiit.model;

public abstract class MemoryNode<T> {

	protected String name;

	public MemoryNode(String name) {
		this.name = name;
	}

	public abstract T evaluate();

	@Override
	public String toString() {
		return name + ": " + evaluate();
	}
}
