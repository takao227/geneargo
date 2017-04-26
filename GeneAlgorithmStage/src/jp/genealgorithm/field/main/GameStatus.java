package jp.genealgorithm.field.main;

/**
 * フィールドに対してアクションした結果を格納するオブジェクト
 *
 * @author Imano
 */
public class GameStatus {

	private int elapTime;
	private int remainTime;
	private int remainDistance;
	private boolean isGoal;


	public GameStatus(int elapTime, int remainTime, int remainDistance, boolean isGoal) {
		this.elapTime = elapTime;
		this.remainTime = remainTime;
		this.remainDistance = remainDistance;
		this.isGoal = isGoal;
	}


	/**
	 * 経過時間
	 * @return
	 */
	public int getElapTime() {
		return elapTime;
	}

	/**
	 * 残り時間
	 * @return
	 */
	public int getRemainTime() {
		return remainTime;
	}

	/**
	 * ゴールまでの距離
	 * @return
	 */
	public int getRemainDistance() {
		return remainDistance;
	}

	/**
	 * ゴールに到達したか
	 * @return
	 */
	public boolean isGoal() {
		return isGoal;
	}

}
