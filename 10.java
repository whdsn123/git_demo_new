package inheritanceOfInterval;

import interval.CommonIntervalSet;
import interval.IntervalConflictException;

public class NonOverlapIntervalSetImpl<L> 
					extends CommonIntervalSet<L>
					implements NonOverlapIntervalSet<L>{
	@Override
	public void insert(long start, long end, L label) throws IntervalConflictException{
		for(L lab:super.labels()) {
			if((super.start(lab)<=start&&super.end(lab)>start)||(super.start(lab)<end&&super.end(lab)>=end))
					throw new IntervalConflictException("Ê±¼ä¶ÎÖØµþ");
		}
		super.insert(start, end, label);
	}
}
