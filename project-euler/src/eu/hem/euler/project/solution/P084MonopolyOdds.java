package eu.hem.euler.project.solution;

import static eu.hem.euler.project.util.MatrixUtils.multiply;
import static java.lang.Math.pow;

public class P084MonopolyOdds {

	public static final int GO = 0;
	public static final int G2J = 30;
	public static final int JAIL = 10;
	public static final int C1 = 11;
	public static final int E3 = 24;
	public static final int H2 = 39;
	public static final int R1 = 5;
	public static final int R2 = 15;
	public static final int R3 = 25;
	public static final int R4 = 35;
	public static final int U1 = 12;
	public static final int U2 = 28;
	public static final int CC1 = 2;
	public static final int CC2 = 17;
	public static final int CC3 = 33;
	public static final int CH1 = 7;
	public static final int CH2 = 22;
	public static final int CH3 = 36;

	public static void main(String[] args) {
		long start = System.currentTimeMillis();

		int dice = 4;
		int size = 40;
		double chance = 1.0 / (dice * dice);
		double cardChance = 1.0 / 16.0;

		double[][] stochasticMatrix = new double[size][size];
		for (int i = 0; i < size; i++) {
			for (int d1 = 1; d1 < dice + 1; d1++) {
				for (int d2 = 1; d2 < dice + 1; d2++) {
					int square = (i + d1 + d2) % size;
					double multiplier = 1.0;
					if (d1 == d2) {
						stochasticMatrix[i][JAIL] += (dice * dice - dice) / pow(dice, 4) * chance;
						multiplier = 1.0 - (dice * dice - dice) / pow(dice, 4);
					}
					if (square == G2J) {
						stochasticMatrix[i][JAIL] += multiplier * chance;
					} else if (square == CC1 || square == CC2 || square == CC3) {
						stochasticMatrix[i][GO] += multiplier * cardChance * chance;
						stochasticMatrix[i][JAIL] += multiplier * cardChance * chance;
						stochasticMatrix[i][square] += multiplier * 14 * cardChance * chance;
					} else if (square == CH1 || square == CH2 || square == CH3) {
						stochasticMatrix[i][GO] += multiplier * cardChance * chance;
						stochasticMatrix[i][JAIL] += multiplier * cardChance * chance;
						stochasticMatrix[i][C1] += multiplier * cardChance * chance;
						stochasticMatrix[i][E3] += multiplier * cardChance * chance;
						stochasticMatrix[i][H2] += multiplier * cardChance * chance;
						stochasticMatrix[i][R1] += multiplier * cardChance * chance;
						stochasticMatrix[i][R1] += square == CH1 ? multiplier * 2 * cardChance * chance : 0.0;
						stochasticMatrix[i][R3] += square == CH2 ? multiplier * 2 * cardChance * chance : 0.0;
						stochasticMatrix[i][R4] += square == CH3 ? multiplier * 2 * cardChance * chance : 0.0;
						stochasticMatrix[i][U1] += square == CH1 ? multiplier * cardChance * chance : 0.0;
						stochasticMatrix[i][U2] += square == CH2 ? multiplier * cardChance * chance : 0.0;
						stochasticMatrix[i][U2] += square == CH3 ? multiplier * cardChance * chance : 0.0;
						stochasticMatrix[i][4] += square == CH1 ? multiplier * cardChance * chance : 0.0;
						stochasticMatrix[i][19] += square == CH2 ? multiplier * cardChance * chance : 0.0;
						stochasticMatrix[i][33] += square == CH3 ? multiplier * cardChance * chance : 0.0;
						stochasticMatrix[i][square] += multiplier * 6 * cardChance * chance;
					} else {
						stochasticMatrix[i][square] += multiplier * chance;
					}
				}
			}
		}

		int steps = 1000;
		double[][] state = new double[1][size];
		state[0][0] = 1.0;

		for (int step = 0; step < steps; step++) {
			state = multiply(state, stochasticMatrix);
		}

		int i1 = 0, i2 = 0, i3 = 0;
		for (int i = 0; i < size; i++) {
			i3 = state[0][i] > state[0][i2] ? i2 : state[0][i] > state[0][i3] ? i : i3;
			i2 = state[0][i] > state[0][i1] ? i1 : state[0][i] > state[0][i2] ? i : i2;
			i1 = state[0][i] > state[0][i1] ? i : i1;
		}

		System.out.format("%02d%02d%02d\n", i1, i2, i3);
		System.out.println("duration=" + (System.currentTimeMillis() - start));
	}

}
