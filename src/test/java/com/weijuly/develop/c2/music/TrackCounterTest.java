package com.weijuly.develop.c2.music;

import static junit.framework.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

import com.weijuly.learn.c2.music.CompactDisc;
import com.weijuly.learn.c2.music.TrackCounter;
import com.weijuly.learn.c2.music.config.TrackCounterConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TrackCounterConfig.class)
@TestExecutionListeners(listeners = {
		DependencyInjectionTestExecutionListener.class })
public class TrackCounterTest {

	private ByteArrayOutputStream stream;

	@Autowired
	private CompactDisc disc;

	@Autowired
	private TrackCounter counter;

	@Before
	public void capture() {
		stream = new ByteArrayOutputStream();
		System.setOut(new PrintStream(stream));
	}

	@Test
	public void counterShouldCount() {
		disc.playTrack(0);
		disc.playTrack(1);
		disc.playTrack(1);
		disc.playTrack(2);
		disc.playTrack(2);
		disc.playTrack(2);

		assertEquals(1, counter.getCount(0));
		assertEquals(2, counter.getCount(1));
		assertEquals(3, counter.getCount(2));
	}
}
