package eu.hem.euler.project.matrix;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.stream.IntStream;

public class MatrixShortestPath {

	private int dim;
	private Entry[][] matrix;
	private PriorityQueue<Entry> unvisited;
	private Entry source;
	private Entry target;

	public MatrixShortestPath(int[][] matrix) {
		this.dim = matrix.length;
		this.unvisited = new PriorityQueue<>();
		this.matrix = new Entry[dim][dim];
		IntStream.range(0, dim)
			.forEach(i -> IntStream.range(0, dim)
					.forEach(j -> this.matrix[i][j] = new Entry(i, j, matrix[i][j])));
		this.source = this.matrix[0][0];
		this.target = this.matrix[dim - 1][dim - 1];
	}

	public int getShortestPathSum() {
		source.distance = matrix[0][0].value;
		unvisited.add(source);
		unvisited.add(target);
		
		while (unvisited.contains(target)) {
			Entry e = unvisited.poll();
			for (Entry f : e.getNeighbours()) {
				int alt = e.distance + f.value;
				if (alt < f.distance) {
					unvisited.remove(f);
					f.distance = alt;
					f.previous = e;
					unvisited.add(f);
				}
			}
		}
		return target.distance;
	}
	
	@Override
	public String toString() {
		int[][] path = new int[dim][dim];
		for (Entry e = target; e != null; e = e.previous) {
			path[e.i][e.j] = 1;
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < dim; i++) {
			for (int j = 0; j < dim; j++) {
				sb.append(path[i][j] > 0 ? "o " : ". ");
			}
			sb.append("\n");
		}
		return sb.toString();
	}

	public class Entry implements Comparable<Entry> {
		private int i;
		private int j;
		private int value;
		private int distance;
		private Entry previous;
		private Set<Entry> neighbours;

		public Entry(int i, int j, int value) {
			this.i = i;
			this.j = j;
			this.value = value;
			this.distance = Integer.MAX_VALUE;
			this.previous = null;
			this.neighbours = null;
		}
		
		private Set<Entry> getNeighbours() {
			if (neighbours == null) {
				neighbours = new HashSet<>();
				if (i > 0) {
					neighbours.add(matrix[i - 1][j]);
				}
				if (i + 1 < dim) {
					neighbours.add(matrix[i + 1][j]);
				}
				if (j > 0) {
					neighbours.add(matrix[i][j - 1]);
				}
				if (j + 1 < dim) {
					neighbours.add(matrix[i][j + 1]);
				}
			}
			return neighbours;
		}

		@Override
		public int compareTo(Entry o) {
			return Integer.valueOf(distance).compareTo(Integer.valueOf(o.distance));
		}

	}
}
