package jp.genealgorithm.field.main.control;

/**
 * コントローラーで入力するようなイメージ
 * 同時押しとなる等なものがこのオブジェクト一つとして定義される
 *
 * 一つの動作ごとに定義された量の変化が起きる。
 * 動作は、強度を指定することができる。1が最小となり10が最大となる。強度10は強度1の10倍の結果が発生するわけではない。
 *
 * Arrow right or left: walk
 * Arrow Strength: 1-10
 * Button A: Jump
 * Button A Strength: 1-10
 *
 *
 * @author Imano
 *
 */
public class GameAction {

	private GameMoveControl move;
	private int moveStrength;
	private GameActionControl[] actions = new GameActionControl[4];//同時動作入力は4つまで
	private int[] actionStrength = new int[4];

	private GameAction() {
	}

	public static GameAction Left(int strength) {
		GameAction act = new GameAction();
		act.move = GameMoveControl.Left;
		act.moveStrength = strength;
		return act;
	}

	public static GameAction right(int strength) {
		GameAction act = new GameAction();
		act.move = GameMoveControl.Right;
		act.moveStrength = strength;
		return act;
	}

	public static GameAction buttonA(int strength) {
		GameAction act = new GameAction();
		act.actions[0] = GameActionControl.ButtonA;
		act.actionStrength[0] = strength;
		return act;
	}

	public static GameAction left_ButtonA(int leftStrength, int buttonStrength) {
		GameAction act = new GameAction();
		act.move = GameMoveControl.Left;
		act.moveStrength = leftStrength;
		act.actions[0] = GameActionControl.ButtonA;
		act.actionStrength[0] = buttonStrength;
		return act;
	}

	public static GameAction right_ButtonA(int rightStrength, int buttonStrength) {
		GameAction act = new GameAction();
		act.move = GameMoveControl.Right;
		act.moveStrength = rightStrength;
		act.actions[0] = GameActionControl.ButtonA;
		act.actionStrength[0] = buttonStrength;
		return act;
	}

	protected static GameAction action(GameMoveControl move, int moveStrength, GameActionControl[] actions, int actionStrength[]) {
		GameAction act = new GameAction();
		act.move = move;
		act.moveStrength = moveStrength;
		act.actions = actions;
		act.actionStrength = actionStrength;
		return act;
	}

	public GameMoveControl getMove() {
		return move;
	}

	public int getMoveStrength() {
		return moveStrength;
	}

	public GameActionControl[] getActions() {
		return actions;
	}

	public int[] getActionStrength() {
		return actionStrength;
	}
}
