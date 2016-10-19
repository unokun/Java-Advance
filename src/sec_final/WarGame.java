package sec_final;

import java.io.File;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Queue;
import java.util.Random;
import java.util.Scanner;

import com.sun.jmx.remote.internal.ArrayQueue;

/**
 * 
 * jsonによるデータ読み書き
 * Jacksonの便利な使い方 [初心者向け] - Qiita 
 * http://qiita.com/takehiro224/items/6db2841c0abbf4ffb233
 * 
 * Jackson使い方メモ - Qiita 
 * http://qiita.com/opengl-8080/items/b613b9b3bc5d796c840c
 * 
 * Jackson でハイパフォーマンスな JSON 処理を追求する (第十七回 #渋谷java でお話してきました) - k11i.biz 
 * http://k11i.biz/blog/2016/10/01/high-performance-jackson/
 * 
 * @author unokun
 *
 */
public class WarGame {
	private static final int NUM_CARD = 13;
	private static final int TOTAL_CARD = NUM_CARD * 2;
	// 手札
	Deque<Card> playerDeck;
	Deque<Card> comDeck;
	// 獲得した札の数
	int playerWonCards;
	int comWonCards;
	// 場に積まれた札の数
	int pendingCards;
	// ターン
	int numOfTurn;
	
	/**
	 * ゲームを保存します
	 * 
	 */
	void saveGame() {
	}
	/**
	 * ファイルからゲームを復元します
	 * 
	 */
	void restoreGame() {
		
	}
	/**
	 * どちらのカードの数字が大きいか？
	 * AはK(13)より大きい(強い)とします。
	 * @param num1
	 * @param num2
	 * @return
	 */
	boolean isBigger(int num1, int num2) {
		if (num1 == 1) { num1 = 14; }
		if (num2 == 1) { num2 = 14; }
		
		return (num1 > num2);
	}
	/**
	 * ゲーム開始
	 */
	public void startGame() {
		try (Scanner scanner = new Scanner(System.in)) {
			while (true) {
				numOfTurn += 1;
				
				System.out.println("### 第" + numOfTurn + "回戦 ###");
				System.out.println("場に積まれた札: " + pendingCards + "枚");
				System.out.println("CPUの持ち札: " + comDeck.size() + "枚, " + "獲得した札: " + comWonCards + "枚");
				System.out.println("あなたの持ち札: " + playerDeck.size() + "枚, " + "獲得した札: " + playerWonCards + "枚");
				while (true) {
					System.out.print("札を切りますか?(d: 札を切る, q: 中断) > ");
					String response = scanner.nextLine();
					if (response.equalsIgnoreCase("q")) {
						System.out.println("ゲームを中断します");
						return;
					}
					if (response.equalsIgnoreCase("d")) {
						break;
					}
				}

				Card playerCard = playerDeck.poll();
				Card comCard = comDeck.poll();
				// game over
				if (playerCard == null || comCard == null) {
					return;
				}

				System.out.println("CPUが切った札: [" + comCard.toString() + "]");
				System.out.println("あなたが切った札: [" + playerCard.toString() + "]");

				int numPlayer = playerCard.getNumber();
				int numCom = comCard.getNumber();
				if (isBigger(numPlayer, numCom)) {
					System.out.println("あなたが獲得しました!");
					playerWonCards += 2;

					if (pendingCards != 0) {
						playerWonCards += pendingCards;
						pendingCards = 0;
					}
					
				} else if (numPlayer < numCom) {
					comWonCards += 2;

					if (pendingCards != 0) {
						comWonCards += pendingCards;
						pendingCards = 0;
					}
					
				} else {
					// draw
					System.out.println("引き分けです。");
					pendingCards += 2;
				}
				if (playerDeck.size() == 0) {
					System.out.println("### 最終結果 ###");
					System.out.println("CPUが獲得した札: " + comWonCards + "枚");
					System.out.println("あなたが獲得した札: " + playerWonCards + "枚");
					if (playerWonCards > comWonCards) {
						System.out.println("あなたが勝ちました、おめでとう!");
					}

					return;
				}
			}		
		}

	}
	/**
	 * 入れ替える
	 * 
	 * @param i
	 * @param j
	 * @param cards
	 */
	void swapCard(int i, int j, int[] cards) {
		int tmp = cards[i];
		cards[i] = cards[j];
		cards[j] = tmp;
	}
	
	int[] makeRandomizeNumbers() {
		// 0 - 25までの数字をセットする
		int[] cards = new int[TOTAL_CARD];
		for (int i = 0; i < TOTAL_CARD; i++) {
			cards[i] = i;
		}
		// シャッフルする
		Random random = new Random();
		for (int i = 0; i < TOTAL_CARD; i++) {
			int j = random.nextInt(TOTAL_CARD - i) + i ;
			swapCard(i, j, cards);
		}		
		return cards;
	}
	/**
	 * ゲームの初期化をします
	 * 
	 * <ul>
	 * <li>プレーヤーにカードを配る</li>
	 * </ul>
	 */
	void initGame() {
		playerDeck = new ArrayDeque<>(NUM_CARD);
		comDeck = new ArrayDeque<>(NUM_CARD);
		
		playerWonCards = 0;
		comWonCards = 0;
		pendingCards = 0;

		numOfTurn = 0;
		int nCards = NUM_CARD;
		File breakFile = new File("game_break.csv");
		if (breakFile.exists()) {
			// 中断したゲームがある場合にはファイルからゲームを復元します
			
		}
		int[] randomNumbers = makeRandomizeNumbers();
		for (int i = 0; i < nCards; i++) {
			playerDeck.add(Card.makeCard(randomNumbers[i]));
			comDeck.add(Card.makeCard(randomNumbers[nCards + i]));
			
		}
//		System.out.println("player:");
//		System.out.println(playerDeck);
//		System.out.println("com:");
//		System.out.println(comDeck);

	}

	public static void main(String[] args) {
		WarGame game = new WarGame();
		game.initGame();
		game.startGame();
	}

}
