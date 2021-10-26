package inheritanceOfMutiInterval;

import interval.IntervalConflictException;
import interval.IntervalSet;
import interval.MultiIntervalSet;

public class NonOverlapMutiIntervalSetImpl<L> 
					extends MultiIntervalSet<L> 
			implements NonOverlapMutiIntervalSet<L>{
	@Override
	public void insert(long start, long end, L label) throws IntervalConflictException{
		for(L lab:super.labels()) {
			IntervalSet<Integer> intervs=super.intervals(lab);
			for(Integer i:intervs.labels()) {
				if((intervs.start(i)<=start&&intervs.end(i)>start)||(intervs.start(i)<end&&intervs.end(i)>=end))
						throw new IntervalConflictException("ʱ����ص�");
			}
		}
		super.insert(start, end, label);
	}
	

}
//��C4���޸�