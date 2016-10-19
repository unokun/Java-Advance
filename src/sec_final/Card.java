package sec_final;

/**
 * トランプのカードクラス
 * 
 * カードは0から25までの数値を持ちます。
 * この値を使ってカードの表現します。
 * 
 * カードの種類
 * カードの数
 * 
 * i / 2 ---> カードの種類(Suit)
 * i % 2 ---> i+1がカードの数を表す(10: J, 11: Q, 12: K)
 * 
 * @author unokun
 *
 */
public class Card {
	public static int NUM_OF_CARDS = 13;
	
	// http://qiita.com/KeithYokoma/items/9681b130ea132cfad64d
	public enum Suit {
		SPADES(0), DIAMONDS(1), UNKNOWN(2); 
		
		private final int id;
		private Suit(int id) {
			this.id = id;
		}
	    public static Suit valueOf(int id) {
	        for (Suit suit : values()) {
	            if (suit.getId() == id) {
	                return suit;
	            }
	        }

//	        throw new IllegalArgumentException("no such enum object for the id: " + id);
	        // Null-Object パターンにしたがって、列挙に UNKNOWN みたいなのを入れておくのも良い
	         return UNKNOWN;
	    }
		public int getId() {
			return this.id;
		}
	}
	
	// カードの種類
	private Suit suit;
	
	// ナンバー 1...10,11(J),12(Q),13(K)
	private int number;

	public Suit getCardSuit() {
		return suit;
	}

	public void setSuit(Suit suit) {
		this.suit = suit;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number + 1;
	}
	/**
	 * カードを作成します
	 * 
	 * @param cardType
	 * @param number
	 */
	public Card(Card.Suit cardType, int number) {
		this.suit = cardType;
		this.number = number;
	}
	/**
	 * ランダムにカードを作成します
	 * 
	 * @param random
	 * @return
	 */
	public static Card makeCard(int value) {
		int suits = value % 2;
		int number = value / 2 + 1;

		return new Card(createCardType(suits), number);
	}
	
	private static Card.Suit createCardType(int id) {
		return Card.Suit.valueOf(id);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		switch (this.suit) {
		case SPADES:
			builder.append("スペード");
			break;
		case DIAMONDS:
			builder.append("ダイヤ");
			break;
		case UNKNOWN:
			builder.append("不明");
			break;
		}
		builder.append(this.number);
		
		return builder.toString();
	}

}
