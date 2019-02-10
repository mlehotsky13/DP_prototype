package sk.stuba.fiit;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import sk.stuba.fiit.analyze.Action;
import sk.stuba.fiit.analyze.Action.ArrayConditionalAddAction;
import sk.stuba.fiit.analyze.Action.ArrayConditionalAddByMinusIndexAction;
import sk.stuba.fiit.analyze.Action.ArrayConditionalWriteAction;
import sk.stuba.fiit.analyze.Action.ArraySimpleSubtractAction;
import sk.stuba.fiit.analyze.Action.ArrayVariableDeclarationAction;
import sk.stuba.fiit.model.MemoryModel;
import sk.stuba.fiit.model.MemoryNode;
import sk.stuba.fiit.model.MemoryValueNode;

public class MemoryModelTests {

	@Test
	public void testfunc1_a() {
		MemoryModel<Integer> memorymodel = new MemoryModel<Integer>();
		List<Action<Integer>> actions = mock_func1_a_actions();

		actions.forEach(action -> memorymodel.processAction(action));
	}

	@Test
	public void testfunc1_b() {
		MemoryModel<Integer> memorymodel = new MemoryModel<Integer>();
		List<Action<Integer>> actions = mock_func1_b_actions();

		actions.forEach(action -> memorymodel.processAction(action));
	}

	@Test
	public void testfunc1_c() {
		MemoryModel<Integer> memorymodel = new MemoryModel<Integer>();
		List<Action<Integer>> actions = mock_func1_c_actions();

		actions.forEach(action -> memorymodel.processAction(action));
	}

	@Test
	public void testfunc1_d() {
		MemoryModel<Integer> memorymodel = new MemoryModel<Integer>();
		List<Action<Integer>> actions = mock_func1_d_actions();

		actions.forEach(action -> memorymodel.processAction(action));
	}

	@Test
	public void testfunc1_e() {
		MemoryModel<Integer> memorymodel = new MemoryModel<Integer>();
		List<Action<Integer>> actions = mock_func1_e_actions();

		actions.forEach(action -> memorymodel.processAction(action));
	}

	private List<Action<Integer>> mock_func1_a_actions() {
		return Arrays.asList(//
				new ArrayVariableDeclarationAction<Integer>("arr", Arrays.asList(7, 5, 3, 1))//
		);
	}

	private List<Action<Integer>> mock_func1_b_actions() {
		MemoryNode<Integer> i = new MemoryValueNode<>("i", 0);

		return Arrays.asList(//
				new ArrayVariableDeclarationAction<Integer>("arr", Arrays.asList(7, 5, 3, 1)), //
				new ArrayConditionalWriteAction<>("arr", i, 4));
	}

	private List<Action<Integer>> mock_func1_c_actions() {
		MemoryNode<Integer> i = new MemoryValueNode<>("i", 0);

		return Arrays.asList(//
				new ArrayVariableDeclarationAction<Integer>("arr", Arrays.asList(7, 5, 3, 1)), //
				new ArrayConditionalWriteAction<>("arr", i, 3));
	}

	private List<Action<Integer>> mock_func1_d_actions() {
		MemoryNode<Integer> i = new MemoryValueNode<>("i", 0);

		return Arrays.asList(//
				new ArrayVariableDeclarationAction<Integer>("arr", Arrays.asList(7, 5, 3, 1)), //
				new ArrayConditionalAddAction<>("arr", i, 2));
	}

	private List<Action<Integer>> mock_func1_e_actions() {
		MemoryNode<Integer> i = new MemoryValueNode<>("i", 0);

		return Arrays.asList(//
				new ArrayVariableDeclarationAction<Integer>("arr", Arrays.asList(5, 6, 9, 2, 1, 7, 17, 6, 63)), //
				new ArrayConditionalAddByMinusIndexAction<>("arr", i, 1, 4, 7), //
				new ArrayConditionalAddByMinusIndexAction<>("arr", i, 2, 4, 7), //
				new ArraySimpleSubtractAction<>("arr", 7, 20), //
				new ArrayConditionalAddAction<>("arr", i, 5));
	}
}
