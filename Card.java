import java.util.Random;

public class Card {

	private String suit;
	private String face;
	public Card (String s, String f)
	{
		suit = s;
		face = f;
	}
	
	public String getSuit()
	{
		return suit;
	}
	public String getFace()
	{
		return face;
	}
	public String toString()
	{
		String a = face + " of  " + suit;
		return a;
		
	}
}
