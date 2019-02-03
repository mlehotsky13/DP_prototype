package sk.stuba.fiit.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import sk.stuba.fiit.analyze.Action;

public class MemoryModel {
	private Map<String, List<MemoryNode<?>>> memory = new HashMap<>();

	public MemoryModel processAction(Action action) {
		return this;
	}
}