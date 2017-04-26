package jp.genealgorithm.field.main.stages;

import java.util.List;

import jp.genealgorithm.field.main.GameStatus;
import jp.genealgorithm.field.main.control.GameAction;

/**
 * ステージを定義する
 * 一つのステージについて、アクションを入力すると結果が計算される。
 * 結果は、アクションを行ったあと任意のタイミングで取得できる。
 *
 * @author Imano
 *
 */
public interface GameStage {

	//初期化
	public void reset();

	//アクション
	public void actionOneStep(GameAction act);

	//連続アクション
	public void actionSequentialStep(List<GameAction> act);

	//ステータス取得
	public GameStatus getResult();

}
