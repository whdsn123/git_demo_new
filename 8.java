package inheritanceOfInterval;

import interval.BlankException;

public interface NoBlankIntervalSet<L> {
	public boolean checkNoBlank() throws BlankException;
}
