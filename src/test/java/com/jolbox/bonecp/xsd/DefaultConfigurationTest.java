package com.jolbox.bonecp.xsd;

import com.jolbox.bonecp.config.DefaultConfigTypeBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import java.io.InputStream;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

public class DefaultConfigurationTest {
    public static final String TEST_DEFAULT_CONFIG_FILE_NAME = "bonecp-config.xml";
    private InputStream testConfigAsStream;
    private JAXBContext jaxbContext;

    @Before
    public void setUp() throws Exception {
        testConfigAsStream = getClass().getClassLoader().getResourceAsStream(TEST_DEFAULT_CONFIG_FILE_NAME);
        assertNotNull(testConfigAsStream);
        jaxbContext = JAXBContext.newInstance("com.jolbox.bonecp.xsd");
    }

    @After
    public void tearDown() throws Exception {
        if(testConfigAsStream != null) {
            testConfigAsStream.close();
        }
    }

    @Test
    public void testBuilder() throws Exception {
        DefaultConfigType configType = DefaultConfigTypeBuilder.aBoneCPDefaultConfig().withDefaults().build();
        System.out.println("configType = " + configType);
    }

    @Test
    public void testThatXmlCanBeUnMarshaled() throws Exception {
        JAXBElement<BoneCPConfigType> instance = (JAXBElement<BoneCPConfigType>) jaxbContext.createUnmarshaller().unmarshal(testConfigAsStream);
        BoneCPConfigType configuration = instance.getValue();
        assertNotNull(configuration.getDefaultConfig());
        assertNotNull(configuration.getNamedConfig());
        assertThat(configuration.getNamedConfig().size(), equalTo(0));
        for (PropertyType propertyType : configuration.getDefaultConfig().getProperty()) {
            System.out.println(String.format("%s = '%s'", propertyType.getName().value(), propertyType.getValue()));
        }
    }
}
