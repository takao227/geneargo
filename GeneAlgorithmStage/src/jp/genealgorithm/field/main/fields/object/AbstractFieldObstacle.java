package jp.genealgorithm.field.main.fields.object;

public abstract class AbstractFieldObstacle implements FieldObstacle {

	protected int top;
	protected int left;
	protected int height;
	protected int width;

	@Override
	public int getHeight() {
		return height;
	}

	@Override
	public int getWidth() {
		return width;
	}
	
	@Override
	public int getTop() {
		return top;
	}
	
	@Override
	public int getLeft() {
		return left;
	}
}
