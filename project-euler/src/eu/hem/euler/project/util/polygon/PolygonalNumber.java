package eu.hem.euler.project.util.polygon;

import static eu.hem.euler.project.util.EulerUtils.polygonal;

public class PolygonalNumber {

	public final int s;
	public final int n;
	public final int value;

	public PolygonalNumber(int s, int n) {
		this.s = s;
		this.n = n;
		this.value = polygonal(s, n);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + value;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PolygonalNumber other = (PolygonalNumber) obj;
		if (value != other.value)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return String.valueOf(value);
	}

}
