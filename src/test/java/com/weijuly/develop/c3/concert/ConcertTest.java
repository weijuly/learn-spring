package com.weijuly.develop.c3.concert;

import static org.junit.Assert.assertNotNull;

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

import junit.framework.Assert;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ConcertConfig.class)
@TestExecutionListeners(listeners = {
		DependencyInjectionTestExecutionListener.class })
public class ConcertTest {

	private ByteArrayOutputStream stream;

	@Autowired
	Audience audience;

	@Autowired
	Performance performance;

	@Before
	public void captureOutput() {
		stream = new ByteArrayOutputStream();
		System.setOut(new PrintStream(stream));
	}

	@Test
	public void audienceShouldSilence() {
		assertNotNull(audience);
		assertNotNull(performance);
		performance.perform();
		String expected = "Silencing all phones\n" + "Taking Seats\n"
				+ "Playing Rondo Alla Turca !!!\n" + "Clapping...\n"
				+ "Returning home\n";
		Assert.assertEquals(expected, stream.toString());
	}
}
