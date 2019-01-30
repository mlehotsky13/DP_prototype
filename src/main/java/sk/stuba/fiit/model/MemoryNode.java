package sk.stuba.fiit.model;

public abstract class MemoryNode<T> {

	protected String name;
	
	public abstract T evaluate();
}
