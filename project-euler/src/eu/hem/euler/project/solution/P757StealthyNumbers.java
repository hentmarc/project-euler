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
		PriorityQueue<Stealthy> queue = new PriorityQueue<>();
		queue.add(new Stealthy(1, 1));

		while (!queue.isEmpty()) {
			Stealthy s = queue.poll();
			count += s.value > prev ? 1 : 0;
			prev = s.value;

			Stealthy next = new Stealthy(s.i, s.j + 1);
			if (next.value < limit) {
				queue.add(next);
			}
			if (s.i == s.j) {
				Stealthy next2 = new Stealthy(s.i + 1, s.j + 1);
				if (next2.value < limit) {
					queue.add(next2);
				}
			}
		}
		return count;
	}

	public static class Stealthy implements Comparable<Stealthy> {
		private long value;
		private long i;
		private long j;

		public Stealthy(long i, long j) {
			this.i = i;
			this.j = j;
			this.value = stealthy(i, j);
		}

		private long stealthy(long i, long j) {
			return i * (i + 1) * j * (j + 1);
		}

		@Override
		public int compareTo(Stealthy o) {
			return Long.valueOf(this.value).compareTo(o.value);
		}
	}
}