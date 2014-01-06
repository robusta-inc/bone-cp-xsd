package com.jolbox.bonecp.config;

import com.jolbox.bonecp.xsd.DefaultConfigType;
import org.junit.Before;
import org.junit.Test;

import static com.jolbox.bonecp.config.DefaultConfigTypeBuilder.aBoneCPDefaultConfig;
import static org.junit.Assert.assertNotNull;

public class DefaultConfigTypeBuilderTest {
    private DefaultConfigTypeBuilder builder;

    @Before
    public void setUp() throws Exception {
        builder = aBoneCPDefaultConfig().withDefaults();
    }

    @Test
    public void testBuild() throws Exception {
        DefaultConfigType type = builder.withConnectionTimeoutInMs(1000).withCloseConnectionWatch(true).build();
        assertNotNull(type);
    }
}
