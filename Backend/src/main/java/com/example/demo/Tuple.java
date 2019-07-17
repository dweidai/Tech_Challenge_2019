package com.example.demo;
public class Tuple<X, Y> {

	private X x;
	private Y y;

	public Tuple(X x, Y y) {
		this.x = x;
		this.y = y;
	}

	public void getx(X x) {
		this.x = x;
	}

	public void gety(Y y) {
		this.y = y;
	}

	public X getx() {
		return x;
	}

	public Y gety() {
		return y;
	}

	@Override
	public String toString() {
		return "(" + x + "," + y + ")";
	}

	@Override
	public boolean equals(Object other) {
		if (other == this) {
			return true;
		}
		if (!(other instanceof Tuple)) {
			return false;
		}
		Tuple<X, Y> other_ = (Tuple<X, Y>) other;
		return other_.x.equals(this.x) && other_.y.equals(this.y);
	}

}