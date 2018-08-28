package com.baidu.ueditor.springboot;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author ccr
 * @date 2018/8/15
 */
public class PropertiesConfigurationTest {
    @Test
    public void getAllConfig() throws Exception {
        PropertiesConfiguration configuration = new PropertiesConfiguration();
        System.out.println(configuration.allConfig());
    }

}