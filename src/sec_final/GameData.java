package sec_final;

public class GameData {
	// 獲得した札の数
	private int playerWonCards = 0;
	private int comWonCards = 0;
	// 場に積まれた札の数
	private int pendingCards = 0;
	// ターン
	private int numOfTurn = 0;
	
	public int getPlayerWonCards() {
		return playerWonCards;
	}
	public void setPlayerWonCards(int playerWonCards) {
		this.playerWonCards = playerWonCards;
	}
	public int getComWonCards() {
		return comWonCards;
	}
	public void setComWonCards(int comWonCards) {
		this.comWonCards = comWonCards;
	}
	public int getPendingCards() {
		return pendingCards;
	}
	public void setPendingCards(int pendingCards) {
		this.pendingCards = pendingCards;
	}
	public int getNumOfTurn() {
		return numOfTurn;
	}
	public void setNumOfTurn(int numOfTurn) {
		this.numOfTurn = numOfTurn;
	}
}
