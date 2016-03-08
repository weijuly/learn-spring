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
import com.weijuly.learn.c2.music.config.EnvironmentConfig;

import junit.framework.Assert;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = EnvironmentConfig.class)
@TestExecutionListeners(listeners = { DependencyInjectionTestExecutionListener.class })
public class EnvironmentConfigTest {
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
