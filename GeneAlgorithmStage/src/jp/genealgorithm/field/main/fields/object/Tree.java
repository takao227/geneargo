package jp.genealgorithm.field.main.fields.object;

public class Tree extends AbstractFieldObstacle {

	public Tree(int left, int bottom,  int height, int width) {
		this.left = left;
		this.top = bottom + height;
		this.height = height;
		this.width = width;
	}

}
