package com.baidu.ueditor.springboot;

/**
 * @author ccr
 * @date 2018/8/14
 */
public interface Configuration {

    public String getRootPath();

    public String getImageActionName();

    public String getImageFieldName();

    public Long getImageMaxSize();

    public String[] getImageAllowFiles();

    public Boolean getImageCompressEnable();

    public Integer getImageCompressBorder();

    public String getImageInsertAlign();

    public String getImageUrlPrefix();

    public String getImagePathFormat();

    public String getScrawlActionName();

    public String getScrawlFieldName();

    public String getScrawlPathFormat();

    public Long getScrawlMaxSize();

    public String getScrawlUrlPrefix();

    public String getScrawlInsertAlign();

    public String getSnapscreenActionName();

    public String getSnapscreenPathFormat();

    public String getSnapscreenUrlPrefix();

    public String getSnapscreenInsertAlign();

    public String[] getCatcherLocalDomain();

    public String getCatcherActionName();

    public String getCatcherFieldName();

    public String getCatcherPathFormat();

    public String getCatcherUrlPrefix();

    public Long getCatcherMaxSize();

    public String[] getCatcherAllowFiles();

    public String getVideoActionName();

    public String getVideoFieldName();

    public String getVideoPathFormat();

    public String getVideoUrlPrefix();

    public Long getVideoMaxSize();

    public String[] getVideoAllowFiles();

    public String getFileActionName();

    public String getFileFieldName();

    public String getFilePathFormat();

    public String getFileUrlPrefix();

    public Long getFileMaxSize();

    public String[] getFileAllowFiles();

    public String getImageManagerActionName();

    public String getImageManagerListPath();

    public Integer getImageManagerListSize();

    public String getImageManagerUrlPrefix();

    public String getImageManagerInsertAlign();

    public String[] getImageManagerAllowFiles();

    public String getFileManagerActionName();

    public String getFileManagerListPath();

    public String getFileManagerUrlPrefix();

    public Integer getFileManagerListSize();

    public String[] getFileManagerAllowFiles();

    String allConfig();
}
