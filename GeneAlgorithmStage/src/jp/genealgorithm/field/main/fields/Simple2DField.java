package jp.genealgorithm.field.main.fields;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import jp.genealgorithm.field.main.fields.object.FieldObstacle;
import jp.genealgorithm.field.main.fields.object.Hole;
import jp.genealgorithm.field.main.fields.object.Tree;

/**
 * 基本的には何もない平坦なフィールド
 *
 * 幾つかのポイントに以下のオブジェクトが存在する。
 * ・落とし穴　高さ0でこの領域に触れている場合死亡(一部でも）
 * ・サボテン　地面から空中の一定の領域に触れている場合死亡
 *
 * 単位：ピクセル
 * セルの定義：サイズ表
 *
 * キャラクタ:           h14px * w2px
 * フィールドサイズ:     h100px * w1000px
 * フィールド基準レベル: 30px(地面）
 *
 * 横移動は強度に対して一致するピクセル数移動する。
 * ジャンプは、縦と横の強度に対して計算される。（基準点はleft/right+bottom)
 *
 * @author imano
 */
public class Simple2DField implements GameField2D {

	private static final int FIELD_WIDTH = 1000;
	private static final int FIELD_HEIGHT = 100;
	private static final int FIELD_BASE_HEIGHT = 30;

	private static final int PERSON_WIDTH = 2;
	private static final int PERSON_HEIGHT = 12;
	private static final int TREE_WIDTH = PERSON_WIDTH * 4;
	private static final int TREE_HEIGHT = PERSON_HEIGHT * 3;
	private static final int HOLE_WIDTH = PERSON_WIDTH * 5;


	//フィールド設計図
	private List<FieldObstacle> obstacles = new ArrayList<>();

	//キャラクタポジション(Left Bottom)
	private int personPositionX = 0;
	private int personPositionY = FIELD_BASE_HEIGHT;
	private boolean personAlive = true;



	@Override
	public void reset() {

		obstacles.add(new Tree(30, FIELD_BASE_HEIGHT, TREE_HEIGHT, TREE_WIDTH));
		obstacles.add(new Tree(70, FIELD_BASE_HEIGHT, TREE_HEIGHT, TREE_WIDTH));
		obstacles.add(new Hole(120, HOLE_WIDTH));
		obstacles.add(new Hole(270, HOLE_WIDTH));
		obstacles.add(new Tree(310, FIELD_BASE_HEIGHT, TREE_HEIGHT, TREE_WIDTH));
		obstacles.add(new Tree(470, FIELD_BASE_HEIGHT, TREE_HEIGHT, TREE_WIDTH));
		obstacles.add(new Tree(560, FIELD_BASE_HEIGHT, TREE_HEIGHT, TREE_WIDTH));
		obstacles.add(new Hole(600, HOLE_WIDTH));
		obstacles.add(new Hole(700, HOLE_WIDTH));
		obstacles.add(new Tree(850, FIELD_BASE_HEIGHT, TREE_HEIGHT, TREE_WIDTH));
		obstacles.add(new Tree(970, FIELD_BASE_HEIGHT, TREE_HEIGHT, TREE_WIDTH));

		//TODO オブジェクト同士の重なりがないかチェックするルーチンを書く
	}

	@Override
	public int length() {
		return FIELD_WIDTH;
	}

	/**
	 * 衝突対象となるオブジェクトをリストで返します。(X軸基準）
	 */
	private List<FieldObstacle> getCrashCandidateObject(int minX, int width) {
		return obstacles.stream()
				.filter(obj ->
						   obj.getLeft() <= minX + width
						&& obj.getLeft() >= minX - obj.getWidth())
				.collect(Collectors.toList());
	}

	/**
	 * 前進
	 */
	private void moveForward(int xStrength) {
		//X強度分移動
		int targetX = personPositionX + xStrength;

		//衝突対象
		List<FieldObstacle> obs = getCrashCandidateObject(personPositionX, xStrength);

		//衝突順にソート
		List<FieldObstacle> sortedObs = obs.stream().sorted(Comparator.comparingInt(FieldObstacle::getLeft)).collect(Collectors.toList());

		//最初のオブジェクトから衝突処理を行う
		int tmpX = personPositionX;
		for (FieldObstacle oj : sortedObs) {
			int dx = oj.getRight();
			if (dx >= targetX) {
				dx = targetX;
			}
			//最初のオブジェクトまでの仮想的な長方形とみなして衝突判定する
			if (collision(oj, tmpX, dx - tmpX, PERSON_HEIGHT)) {
				//衝突
				tmpX = oj.getLeft() - 1;
				personAlive = false;
				break;
			}
			tmpX = dx + 1;
		}

		//キャラ移動
		personPositionX = tmpX;
	}

	/**
	 * バック
	 */
	private void moveBack(int xStrength) {
		//X強度分移動
		//衝突判定
	}

	/**
	 * ジャンプ
	 */
	private void jump(int xStrength, int yStrength) {
		//進行方向X軸について半分まで上昇
		//進行方向X軸について半分以降下降
		//半分の場所で上昇強度MAXまで到達する
		//衝突判定
	}

	/**
	 * 落下
	 */
	private void fall() {

	}

	private boolean collision(FieldObstacle r1, int x, int w, int h) {
		if (r1.getLeft() <= x + w
			&& r1.getLeft() <= x + h
			&& r1.getLeft() >= x - r1.getWidth()
			&& r1.getLeft() >= x - r1.getHeight()) {
			return true;
		}
		return false;
	}
}
