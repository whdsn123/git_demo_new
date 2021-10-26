package inheritanceOfInterval;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import interval.BlankException;
import interval.Interval;

public class NoBlankAndNonOverlapIntervalSetImpl<L> 
					extends NonOverlapIntervalSetImpl<L> 
							implements NoBlankIntervalSet<L>{
	
	
	//private final List<Interval<L>> sortList=new ArrayList<>();
	//private Set<L> sortLabs;
	private long start, end; 						
	public void setStart(long start) {
		this.start=start;
	}
	public void setEnd(long end) {
		this.end=end;
	}

	@Override
	public boolean checkNoBlank() throws BlankException{
		Set<L> sortLabs=super.labels();
		List<Interval<L>> sortList=new ArrayList<>();
		for(L lab:sortLabs) {
			sortList.add(new Interval<L>(super.start(lab),super.end(lab),lab));
		}
		sortList.sort(Comparator.comparing(Interval<L>::getStart));
		if(sortList.size()==0)
			return false;
		if(sortList.get(0).getStart()<this.start)
			//throw new BlankException("����ʱ��αȹ涨ʱ����");
			return false;
		if(sortList.get(0).getStart()>this.start)
			//throw new BlankException("��ͷ���ڿհ�ʱ���");
			return false;
		int n=sortList.size()-1;
		for(int i=0;i<n;i++) {
			if(sortList.get(i).getEnd()!=sortList.get(i+1).getStart())
				//throw new BlankException("�м���ڿհ�ʱ���");
				return false;
		}
		if(sortList.get(n).getEnd()<this.end)
			//throw new BlankException("�����ڿհ�ʱ���");
			return false;
		if(sortList.get(n).getEnd()>this.end)
			//throw new BlankException("����ʱ��αȹ涨ʱ����");
			return false;
		return true;
	}

}
