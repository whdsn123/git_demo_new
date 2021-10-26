package inheritanceOfInterval;

import interval.IntervalConflictException;

public interface NonOverlapIntervalSet<L> {
	public void insert(long start, long end, L label) throws IntervalConflictException;
}
