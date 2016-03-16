package com.weijuly.develop.c2.music;

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

import com.weijuly.learn.c2.music.CompactDisc;
import com.weijuly.learn.c2.music.MediaPlayer;
import com.weijuly.learn.c2.music.config.MusicPlayerConditionConfig;

import junit.framework.Assert;
/**
 * This damn TestExecutionListeners annotation is unnecessary, but it helps to 
 * suppress JUnit warnings when running spring tests
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = MusicPlayerConditionConfig.class)
@TestExecutionListeners(listeners = { DependencyInjectionTestExecutionListener.class })
public class MusicPlayerConditionTest {

    private ByteArrayOutputStream stream;

    @Autowired
    private CompactDisc cd;

    @Autowired
    private MediaPlayer player;

    @Before
    public void setup() {
		stream = new ByteArrayOutputStream();
		System.setOut(new PrintStream(stream));
    }

    @Test
    public void cdShouldNotBeNull() {
	assertNotNull(cd);
    }

    @Test
    public void playerShouldPlay() {
	player.play();
	String output = stream.toString();
	Assert.assertEquals("Playing Something by SuJu", output);
    }

}
