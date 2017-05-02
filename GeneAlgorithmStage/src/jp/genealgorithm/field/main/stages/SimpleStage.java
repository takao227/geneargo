package jp.genealgorithm.field.main.stages;

import java.util.List;

import jp.genealgorithm.field.main.GameStatus;
import jp.genealgorithm.field.main.control.GameAction;
import jp.genealgorithm.field.main.fields.GameField2D;
import jp.genealgorithm.field.main.fields.Simple2DField;

public class SimpleStage implements GameStage {

	//フィールドの状態保持
	private GameField2D field;

	private boolean isGoal = false;
	private int elapTime = 0;//TIMEとか言いながら、アクション実行回数になってる。
	private static final int STAGE_LIMIT_TIME = 100;


	@Override
	public void reset() {
		this.field = new Simple2DField();
	}


	public boolean goalJudgement(){
		//フィールドで判定しようかかんがえなう
		return false;
	}


	@Override
	public void actionOneStep(GameAction act) {
		// TODO 自動生成されたメソッド・スタブ

	}


	@Override
	public void actionSequentialStep(List<GameAction> act) {
		// TODO 自動生成されたメソッド・スタブ

	}


	@Override
	public GameStatus getResult() {
		return new GameStatus(elapTime, STAGE_LIMIT_TIME - elapTime, field.length(), isGoal);
	}

	private void countUpTimer() {
		++elapTime;
	}
}
