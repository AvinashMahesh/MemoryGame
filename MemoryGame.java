import java.util.Scanner;

public class MemoryGame {

	public static void main(String[] args) {
		playGame();

	}

	public static Card[] createDeck()
	{
		Card [] deck = {new Card("Spades", "2") , new Card("Diamonds", "3"), new Card("Diamonds", "Ace"), new Card("Spades", "3"), new Card("Spades", "Queen"), new Card("Spades", "King"),
				new Card("Diamonds", "2"), new Card("Diamonds", "King"), new Card("Spades", "Ace"), new Card("Diamonds", "Queen"), new Card("Diamonds", "4"), new Card("Diamonds", "5"), new Card("Spades", "6"),
				new Card("Spades", "7"), new Card("Spades", "8"), new Card("Spades", "9"), new Card("Diamonds", "10"), new Card("Spades", "5"), new Card("Diamonds", "Jack"), new Card("Spades", "4"),
				new Card("Diamonds", "7"), new Card("Diamonds", "6"), new Card("Spades", "10"), new Card("Diamonds", "8"), new Card("Diamonds", "9"), new Card("Spades", "Jack")};
		return deck;
		}
		
	

	public static void shuffle (Card [] deck) {
	for (int i = deck.length - 1 ; i >= 0; i--) {
		int g = (int) (Math.random() * i);
		Card swap = deck [g];
		deck [g] = deck [i];
		deck [i] = swap;	
	}
	}
	
	public static void playGame()
	{
		Card [] game = createDeck();
		shuffle(game);
		Scanner y = new Scanner(System.in); 
		int pairs = 0;
		int guesses = 0;
		int sub = 0;
		Card [][] cardgrid = new Card [5][6];
		
		for (int a = 0; a < 5; a++)
		{
			for (int i = 0; i < 6; i++)
			{
			cardgrid [a][i] = game [sub];
			sub ++;
			if(sub == 26)
				break;
			}
		}
		
		while (pairs != 13) {
		System.out.println("Enter a row for the first card: ");
		int r = y.nextInt() - 1;
		System.out.println("Enter a column for the first card: ");
		int c = y.nextInt() - 1;
		System.out.println("Enter a row for the second card: ");
		int r1 = y.nextInt() - 1;
		System.out.println("Enter a column for the second card: ");
		int c1 = y.nextInt() - 1;
		
		validateInput(r, c, cardgrid);
		validateInput(r1, c1, cardgrid);
		
		if (cardgrid [r][c] == cardgrid [r1][c1])
		{
			pairs++;
			System.out.println("Card 1: " + cardgrid [r][c]);
			System.out.println("Card 2: " + cardgrid [r1][c1]);
			System.out.println("Pair found!");
			cardgrid [r][c] = null;
			cardgrid [r1][c1] = null;
		}
		else 
		{
			System.out.println("Not a pair!");
		}
		guesses++;
		}
		System.out.println("Number of guesses: " + guesses);
		
		display(cardgrid);
		
	}
	
	public static boolean validateInput ( int r, int c, Card[][]grid )
	{
		if (r > 4 || r < 0 || c > 5 || c < 0 || grid [r][c] == null)
			return false;
		else
			return true;
	}

	public static void display ( Card[][] grid )
	{
		String [][] dis = new String [5][6];
	
	for (int a = 0; a < grid.length - 1; a++)
	{
		for (int b = 0; b < grid[0].length -1; b++)
		{
			if (grid[a][b] == null)
			{
				dis[a][b] = "X";
			}
			else 
			{
				dis[a][b] = "O";
			}
		}
	}
	
	for (int a = 0; a < grid.length - 1; a++)
	{
		for (int b = 0; b < grid[0].length -1; b++)
		{
			System.out.print(dis[a][b]);
		}
		System.out.println();
	}
	
	}

}
