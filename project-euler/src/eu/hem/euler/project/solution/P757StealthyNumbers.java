package eu.hem.euler.project.solution;

import static eu.hem.euler.project.util.ProcessUtils.printDuration;

import java.util.PriorityQueue;

public class P757StealthyNumbers {

	public static final long LIMIT = (long) Math.pow(10L, 14);

	public static void main(String[] args) {
		System.out.println(stealthyCount(LIMIT));
		printDuration();
	}

	public static long stealthyCount(long limit) {
		long count = 0;
		long prev = 0;
		PriorityQueue<Node> queue = new PriorityQueue<>();
		queue.add(new Node(1, 1));

		while (!queue.isEmpty()) {
			Node n = queue.poll();
			count += n.value > prev ? 1 : 0;
			prev = n.value;

			Node next = new Node(n.i, n.j + 1);
			if (next.value < limit) {
				queue.add(next);
			}
			if (n.i == n.j) {
				Node next2 = new Node(n.i + 1, n.j + 1);
				if (next2.value < limit) {
					queue.add(next2);
				}
			}
		}
		return count;
	}

	public static class Node implements Comparable<Node> {
		private long value;
		private long i;
		private long j;

		public Node(long i, long j) {
			this.i = i;
			this.j = j;
			this.value = stealthy(i, j);
		}

		private long stealthy(long i, long j) {
			return i * (i + 1) * j * (j + 1);
		}

		@Override
		public int compareTo(Node o) {
			return Long.valueOf(this.value).compareTo(o.value);
		}
	}
}