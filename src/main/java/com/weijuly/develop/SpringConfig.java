package com.weijuly.develop;

/** 
 * A sample Java annotation configuration. This configuration needs to be loaded
 * using AnnotationConfigApplicationContext
 */

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.weijuly.develop.knight.Knight;
import com.weijuly.develop.quest.Quest;
import com.weijuly.develop.quest.SlayDragonQuest;

@Configuration
public class SpringConfig {

    
    @Bean
    public Knight knight(){
	return new Knight(quest());
    }
    
    @Bean
    public Quest quest(){
	return new SlayDragonQuest();
    }
}
