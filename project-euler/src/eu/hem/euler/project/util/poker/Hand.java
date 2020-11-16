package eu.hem.euler.project.util.poker;

import static eu.hem.euler.project.util.poker.Hand.Rank.FLUSH;
import static eu.hem.euler.project.util.poker.Hand.Rank.FOUR_OF_A_KIND;
import static eu.hem.euler.project.util.poker.Hand.Rank.FULL_HOUSE;
import static eu.hem.euler.project.util.poker.Hand.Rank.HIGH_CARD;
import static eu.hem.euler.project.util.poker.Hand.Rank.ONE_PAIR;
import static eu.hem.euler.project.util.poker.Hand.Rank.ROLYAL_FLUSH;
import static eu.hem.euler.project.util.poker.Hand.Rank.STRAIGHT;
import static eu.hem.euler.project.util.poker.Hand.Rank.STRAIGHT_FLUSH;
import static eu.hem.euler.project.util.poker.Hand.Rank.THREE_OF_A_KIND;
import static eu.hem.euler.project.util.poker.Hand.Rank.TWO_PAIRS;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Hand implements Comparable<Hand> {

	public final List<Integer> hand;
	public final String[] notation;
	public final long value;
	public final Rank rank;
	private final List<Character> cardRanks = List.of('2', '3', '4', '5', '6', '7', '8', '9', 'T', 'J', 'Q', 'K', 'A');

	public Hand(String[] notation) {
		this.notation = notation;
		this.hand = Arrays.stream(notation).map(s -> s.charAt(0)).map(c -> cardRanks.indexOf(c))
				.sorted(Comparator.reverseOrder()).collect(Collectors.toList());

		long value = hand.stream().reduce(0, (a, b) -> 0x10 * a + b);

		boolean flush = Arrays.stream(notation).map(s -> s.charAt(1)).distinct().count() == 1;
		boolean straight = hand.stream().distinct().count() == 5 && hand.get(0) == hand.get(4) + 4;
		Map<Integer, Integer> ranks = hand.stream().distinct()
				.collect(Collectors.toMap(c -> c, c -> Collections.frequency(hand, c)));

		if (straight && flush && hand.get(0) == 0xE) {
			rank = ROLYAL_FLUSH;
			value += hand.get(0) * ROLYAL_FLUSH.value;
		} else if (straight && flush) {
			rank = STRAIGHT_FLUSH;
			value += hand.get(0) * STRAIGHT_FLUSH.value;
		} else if (flush) {
			rank = FLUSH;
			value += hand.get(0) * FLUSH.value;
		} else if (straight) {
			rank = STRAIGHT;
			value += hand.get(0) * STRAIGHT.value;
		} else if (ranks.size() == 2 && ranks.containsValue(4)) {
			rank = FOUR_OF_A_KIND;
			value += ranks.keySet().stream().filter(r -> ranks.get(r) == 4).findFirst().get() * FOUR_OF_A_KIND.value;
		} else if (ranks.size() == 2) {
			rank = FULL_HOUSE;
			value += ranks.keySet().stream().filter(r -> ranks.get(r) == 3).findFirst().get() * FULL_HOUSE.value;
		} else if (ranks.size() == 3 && ranks.containsValue(3)) {
			rank = THREE_OF_A_KIND;
			value += ranks.keySet().stream().filter(r -> ranks.get(r) == 3).findFirst().get() * THREE_OF_A_KIND.value;
		} else if (ranks.size() == 3) {
			rank = TWO_PAIRS;
			value += ranks.keySet().stream().filter(r -> ranks.get(r) == 2).max(Integer::compareTo).get()
					* TWO_PAIRS.value;
			value += ranks.keySet().stream().filter(r -> ranks.get(r) == 2).min(Integer::compareTo).get()
					* ONE_PAIR.value;
		} else if (ranks.size() == 4) {
			rank = ONE_PAIR;
			value += ranks.keySet().stream().filter(r -> ranks.get(r) == 2).findFirst().get() * rank.value;
		} else {
			rank = HIGH_CARD;
		}

		this.value = value;
	}

	@Override
	public String toString() {
		return Arrays.toString(notation);
	}

	@Override
	public int compareTo(Hand o) {
		return Long.valueOf(value).compareTo(o.value);
	}

	public enum Rank {
		HIGH_CARD(0), ONE_PAIR(5), TWO_PAIRS(6), THREE_OF_A_KIND(7), STRAIGHT(8), FLUSH(9), FULL_HOUSE(10),
		FOUR_OF_A_KIND(11), STRAIGHT_FLUSH(12), ROLYAL_FLUSH(12);

		public final long value;

		private Rank(long value) {
			this.value = (long) Math.pow(0x10, value);
		}
	}
}
