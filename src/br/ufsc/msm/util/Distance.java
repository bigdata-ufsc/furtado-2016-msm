package br.ufsc.msm.util;

import br.ufsc.msm.base.Interval;
import br.ufsc.msm.base.Point;

public class Distance {

	public static double semanticDistance(String type, String type2) {
		if (!type.equals(type2)) {
			return 1;
		}
		return 0;
	}

	public static double euclideanDistance(Point p1, Point p2) {
		double distX = Math.abs(p1.getX() - p2.getX());
		double distSqrX = distX * distX;

		double distY = Math.abs(p1.getY() - p2.getY());
		double distSqrY = distY * distY;

		double result = Math.sqrt(distSqrX + distSqrY);

		return result;

	}

	public static double timeDistance(Interval i, Interval i2) {

		long start1 = i.getStartTime().getTime();
		long start2 = i2.getStartTime().getTime();
		long maxStart = 0;
		long minStart = 0;
		if (start1 > start2) {
			maxStart = start1;
			minStart = start2;
		} else {
			maxStart = start2;
			minStart = start1;
		}

		long end1 = i.getEndTime().getTime();
		long end2 = i2.getEndTime().getTime();

		long maxEnd = 0;
		long minEnd = 0;

		if (end1 > end2) {
			maxEnd = end1;
			minEnd = end2;
		} else {
			maxEnd = end2;
			minEnd = end1;
		}

		if (maxStart > minEnd) {
			return 1;
		}

		long diam1 = minEnd - maxStart;
		long diam2 = Math.abs(maxEnd - minStart);

		return 1 - ((double) diam1 / (double) diam2);
	}

}
