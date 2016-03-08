package com.weijuly.learn.c2.music.config;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * This class implements an environment check that can be used in conjunction
 * with spring's configuration class. See MusicPlayerConditionConfig to
 * see how this could be used
 *
 */
public class EnvironmentCheck implements Condition {

    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metaData) {
	return false;
    }
}
