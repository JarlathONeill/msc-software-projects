package p4;

import java.util.Comparator;

public class SortByStrongest implements Comparator<TopTrumpCard>{

	@Override
	public int compare(TopTrumpCard o1, TopTrumpCard o2) {
		// TODO Auto-generated method stub
		return o2.getStrength() - o1.getStrength();
	}

}
