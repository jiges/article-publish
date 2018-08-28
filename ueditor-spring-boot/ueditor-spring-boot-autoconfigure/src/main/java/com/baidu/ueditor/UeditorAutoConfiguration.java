package com.baidu.ueditor;

import com.baidu.ueditor.springboot.ActionEnter;
import com.baidu.ueditor.springboot.ConfigManager;
import com.baidu.ueditor.springboot.PropertiesConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author ccr
 * @date 2018/8/15
 */
@Configuration
@ConditionalOnClass({ActionEnter.class, ConfigManager.class, PropertiesConfiguration.class})
@EnableConfigurationProperties(UeditorProperties.class)
public class UeditorAutoConfiguration {

    @Autowired
    private UeditorProperties ueditorProperties;

    @Bean
    @ConditionalOnMissingBean
    public PropertiesConfiguration propertiesConfiguration() {
        PropertiesConfiguration configuration = new PropertiesConfiguration();

        configuration.setRootPath(ueditorProperties.getRootPath());

        configuration.setImageActionName(ueditorProperties.getImage().getActionName());
        configuration.setImageFieldName(ueditorProperties.getImage().getFieldName());
        configuration.setImageMaxSize(ueditorProperties.getImage().getMaxSize());
        configuration.setImageAllowFiles(ueditorProperties.getImage().getAllowFiles());
        configuration.setImageCompressEnable(ueditorProperties.getImage().getCompressEnable());
        configuration.setImageCompressBorder(ueditorProperties.getImage().getCompressBorder());
        configuration.setImageInsertAlign(ueditorProperties.getImage().getInsertAlign());
        configuration.setImageUrlPrefix(ueditorProperties.getImage().getUrlPrefix());
        configuration.setImagePathFormat(ueditorProperties.getImage().getPathFormat());

        configuration.setScrawlActionName(ueditorProperties.getScrawl().getActionName());
        configuration.setScrawlFieldName(ueditorProperties.getScrawl().getFieldName());
        configuration.setScrawlUrlPrefix(ueditorProperties.getScrawl().getUrlPrefix());
        configuration.setScrawlPathFormat(ueditorProperties.getScrawl().getPathFormat());
        configuration.setScrawlMaxSize(ueditorProperties.getScrawl().getMaxSize());
        configuration.setScrawlInsertAlign(ueditorProperties.getScrawl().getInsertAlign());

        configuration.setSnapscreenActionName(ueditorProperties.getSnapScreen().getActionName());
        configuration.setSnapscreenPathFormat(ueditorProperties.getSnapScreen().getPathFormat());
        configuration.setSnapscreenUrlPrefix(ueditorProperties.getSnapScreen().getUrlPrefix());
        configuration.setSnapscreenInsertAlign(ueditorProperties.getSnapScreen().getInsertAlign());

        configuration.setCatcherLocalDomain(ueditorProperties.getCatcher().getLocalDomain());
        configuration.setCatcherActionName(ueditorProperties.getCatcher().getActionName());
        configuration.setCatcherFieldName(ueditorProperties.getCatcher().getFieldName());
        configuration.setCatcherPathFormat(ueditorProperties.getCatcher().getPathFormat());
        configuration.setCatcherUrlPrefix(ueditorProperties.getCatcher().getUrlPrefix());
        configuration.setCatcherMaxSize(ueditorProperties.getCatcher().getMaxSize());
        configuration.setCatcherAllowFiles(ueditorProperties.getCatcher().getAllowFiles());

        configuration.setVideoActionName(ueditorProperties.getVideo().getActionName());
        configuration.setVideoFieldName(ueditorProperties.getVideo().getFieldName());
        configuration.setVideoPathFormat(ueditorProperties.getVideo().getPathFormat());
        configuration.setVideoUrlPrefix(ueditorProperties.getVideo().getUrlPrefix());
        configuration.setVideoMaxSize(ueditorProperties.getVideo().getMaxSize());
        configuration.setVideoAllowFiles(ueditorProperties.getVideo().getAllowFiles());

        configuration.setFileActionName(ueditorProperties.getFile().getActionName());
        configuration.setFileFieldName(ueditorProperties.getFile().getFieldName());
        configuration.setFilePathFormat(ueditorProperties.getFile().getPathFormat());
        configuration.setFileUrlPrefix(ueditorProperties.getFile().getUrlPrefix());
        configuration.setFileMaxSize(ueditorProperties.getFile().getMaxSize());
        configuration.setFileAllowFiles(ueditorProperties.getFile().getAllowFiles());

        configuration.setImageManagerActionName(ueditorProperties.getImageManager().getActionName());
        configuration.setImageManagerListPath(ueditorProperties.getImageManager().getListPath());
        configuration.setImageManagerListSize(ueditorProperties.getImageManager().getListSize());
        configuration.setImageManagerUrlPrefix(ueditorProperties.getImageManager().getUrlPrefix());
        configuration.setImageManagerInsertAlign(ueditorProperties.getImageManager().getInsertAlign());
        configuration.setImageManagerAllowFiles(ueditorProperties.getImageManager().getAllowFiles());

        configuration.setFileManagerActionName(ueditorProperties.getFileManager().getActionName());
        configuration.setFileManagerListPath(ueditorProperties.getFileManager().getListPath());
        configuration.setFileManagerUrlPrefix(ueditorProperties.getFileManager().getUrlPrefix());
        configuration.setFileManagerListSize(ueditorProperties.getFileManager().getListSize());
        configuration.setFileManagerAllowFiles(ueditorProperties.getFileManager().getAllowFiles());

        return configuration;
    }

    @Bean
    @ConditionalOnMissingBean
    public ConfigManager configManager(PropertiesConfiguration propertiesConfiguration) {
        ConfigManager configManager = new ConfigManager();
        configManager.setConfiguration(propertiesConfiguration);
        return configManager;
    }

    @Bean
    @ConditionalOnMissingBean
    public ActionEnter actionEnter(ConfigManager configManager) {
        ActionEnter actionEnter = new ActionEnter();
        actionEnter.setConfigManager(configManager);
        return actionEnter;
    }
}
