package com.weijuly.develop.knight;

import org.junit.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;

import com.weijuly.develop.quest.Quest;

public class KnightTest {
	
	@Test
	public void knightShouldEmbarkOnQuest() {
		Quest mockQuest = mock(Quest.class);
		Knight knight = new Knight(mockQuest);
		knight.embarkQuest();
		verify(mockQuest, times(1)).embark();
	}
}
