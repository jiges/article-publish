package com.baidu.ueditor.springboot;

import com.baidu.ueditor.define.ActionMap;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * 配置管理器
 *
 * @author hancong03@baidu.com
 */
public final class ConfigManager {

    // 涂鸦上传filename定义
    private final static String SCRAWL_FILE_NAME = "scrawl";
    // 远程图片抓取filename定义
    private final static String REMOTE_FILE_NAME = "remote";

    private Configuration configuration;

    public Map<String, Object> getConfig(int type, HttpServletRequest request) {

        Map<String, Object> conf = new HashMap<String, Object>();
        String savePath = null;

        switch (type) {

            case ActionMap.UPLOAD_FILE:
                conf.put("isBase64", "false");
                conf.put("maxSize", this.configuration.getFileMaxSize());
                conf.put("allowFiles", this.configuration.getFileAllowFiles());
                conf.put("fieldName", this.configuration.getFileFieldName());
                savePath = this.configuration.getFilePathFormat();
                break;

            case ActionMap.UPLOAD_IMAGE:
                conf.put("isBase64", "false");
                conf.put("maxSize", this.configuration.getImageMaxSize());
                conf.put("allowFiles", this.configuration.getImageAllowFiles());
                conf.put("fieldName", this.configuration.getImageFieldName());
                savePath = this.configuration.getImagePathFormat();
                break;

            case ActionMap.UPLOAD_VIDEO:
                conf.put("maxSize", this.configuration.getVideoMaxSize());
                conf.put("allowFiles", this.configuration.getVideoAllowFiles());
                conf.put("fieldName", this.configuration.getVideoFieldName());
                savePath = this.configuration.getVideoPathFormat();
                break;

            case ActionMap.UPLOAD_SCRAWL:
                conf.put("filename", ConfigManager.SCRAWL_FILE_NAME);
                conf.put("maxSize", this.configuration.getScrawlMaxSize());
                conf.put("fieldName", this.configuration.getScrawlFieldName());
                conf.put("isBase64", "true");
                savePath = this.configuration.getScrawlPathFormat();
                break;

            case ActionMap.CATCH_IMAGE:
                conf.put("filename", ConfigManager.REMOTE_FILE_NAME);
                conf.put("filter", this.configuration.getCatcherLocalDomain());
                conf.put("maxSize", this.configuration.getCatcherMaxSize());
                conf.put("allowFiles", this.configuration.getCatcherAllowFiles());
                conf.put("fieldName", this.configuration.getCatcherFieldName() + "[]");
                savePath = this.configuration.getCatcherPathFormat();
                break;

            case ActionMap.LIST_IMAGE:
                conf.put("allowFiles", this.configuration.getImageManagerAllowFiles());
                conf.put("dir", this.configuration.getImageManagerListPath());
                conf.put("count", this.configuration.getImageManagerListSize());
                break;

            case ActionMap.LIST_FILE:
                conf.put("allowFiles", this.configuration.getFileManagerAllowFiles());
                conf.put("dir", this.configuration.getFileManagerListPath());
                conf.put("count", this.configuration.getFileManagerListSize());
                break;
            default:
                break;

        }

        conf.put("savePath", savePath);
        if(this.configuration.getRootPath() != null) {
            conf.put("rootPath", this.configuration.getRootPath());
        } else {
            conf.put("rootPath", request.getServletContext().getRealPath("/"));
        }


        return conf;

    }


    public String getAllConfig() {
        return configuration.allConfig();
    }

    public void setConfiguration(Configuration configuration) {
        this.configuration = configuration;
    }
}
