package com.weijuly.develop.music;

import static org.junit.Assert.assertNotNull;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

import com.weijuly.learn.music.CompactDisc;
import com.weijuly.learn.music.MediaPlayer;
import com.weijuly.learn.music.config.MusicPlayerConfig;

import junit.framework.Assert;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = MusicPlayerConfig.class)
@TestExecutionListeners(listeners = { DependencyInjectionTestExecutionListener.class })
@ActiveProfiles("dev")
public class MusicPlayerTest {

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
	Assert.assertEquals("Playing Girls and Peace by SNSD", output);
    }

}
