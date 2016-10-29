package sec_final;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class WarGameTest {
	WarGame warGame;
	
	@Before
	public void setUp() throws Exception {
		warGame = new WarGame();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testSave() {
		try {
			GameData data = new GameData();
			warGame.saveGame(WarGame.GAME_DATA_FILE, data);
		} catch (Exception e) {
			fail();
		}
	}
	
	@Test
	public void testRestore() {
		try {
			GameData data = new GameData();
			data.setNumOfTurn(1);
			data.setPlayerWonCards(2);
			data.setComWonCards(3);
			data.setPendingCards(4);
			warGame.saveGame(WarGame.GAME_DATA_FILE, data);
			
			data = warGame.restoreGame(WarGame.GAME_DATA_FILE);
			assertEquals(1, data.getNumOfTurn());
			assertEquals(2, data.getPlayerWonCards());
			assertEquals(3, data.getComWonCards());
			assertEquals(4, data.getPendingCards());
		} catch (Exception e) {
			fail();
		}
	}

}
