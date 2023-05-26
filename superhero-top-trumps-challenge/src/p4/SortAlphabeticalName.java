package p4;

import java.util.Comparator;

public class SortAlphabeticalName implements Comparator <TopTrumpCard> {



	@Override
	public int compare(TopTrumpCard o1, TopTrumpCard o2) {
		// TODO Auto-generated method stub
		return o1.getName().compareTo(o2.getName());
	}

}
