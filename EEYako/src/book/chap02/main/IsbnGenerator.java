package book.chap02.main;

import java.util.Random;

public class IsbnGenerator implements NumberGenerator{

	public String generateNumber() {
		return "13-85456"+Math.abs(new Random().nextInt());
	}

}
