package jp.genealgorithm.field.main.fields;

import java.util.ArrayList;
import java.util.List;

import jp.genealgorithm.field.main.fields.object.FieldObstacle;
import jp.genealgorithm.field.main.fields.object.Hole;
import jp.genealgorithm.field.main.fields.object.Tree;

/**
 * 基本的には何もない平坦なフィールド
 *
 * 幾つかのポイントに以下のオブジェクトが存在する。
 * ・落とし穴　高さ0でこの領域に触れている場合死亡
 * ・サボテン　地面から空中の一定の領域に触れている場合死亡
 * 
 * 単位：セル
 * セルの定義：
 *
 * @author works
 *
 */
public class Simple2DField implements GameField2D {

	//フィールド設計図
	private List<FieldObstacle> obstacles = new ArrayList<>();

	@Override
	public void reset() {
		obstacles.add(new Tree(10, 10, 3));
		obstacles.add(new Tree(50, 10, 3));
		obstacles.add(new Hole(60,10));
		obstacles.add(new Hole(100, 10));
	}

	@Override
	public int length() {
		// TODO 自動生成されたメソッド・スタブ
		return 0;
	}

	@Override
	public boolean collision() {
		// TODO 自動生成されたメソッド・スタブ
		return false;
	}
}
