package inheritanceOfMutiInterval;

import interval.IntervalConflictException;

public interface NonOverlapMutiIntervalSet<L> {
	public void insert(long start, long end, L label) throws IntervalConflictException;
}
