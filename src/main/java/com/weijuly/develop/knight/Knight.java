package com.weijuly.develop.knight;

import com.weijuly.develop.quest.Quest;

public class Knight {

	private Quest quest;

	public Knight(Quest quest) {
		this.quest = quest;
	}

	public void embarkQuest() {
		quest.embark();
	}

}
