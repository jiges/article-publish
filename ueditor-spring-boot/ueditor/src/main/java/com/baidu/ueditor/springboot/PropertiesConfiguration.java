package com.baidu.ueditor.springboot;

import org.json.JSONObject;

import java.util.Arrays;

/**
 * Ueditor 配置类
 *
 * @author ccr
 * @date 2018/8/14
 */
public class PropertiesConfiguration implements Configuration{

    /**
     * 文件保存根路径
     */
    private String rootPath;

    //-----------上传图片设置------------
    /**
     * 执行上传图片的action名称
     */
    private String imageActionName = "uploadimage";
    /**
     * 提交的图片表单名称
     */
    private String imageFieldName = "upfile";
    /**
     * 上传大小限制，单位B
     */
    private Long imageMaxSize = 2048000L;
    /**
     * 上传图片格式显示
     */
    private String[] imageAllowFiles = new String[]{".png", ".jpg", ".jpeg", ".gif", ".bmp"};

    /**
     * 是否压缩图片,默认是true
     */
    private Boolean imageCompressEnable = true;

    /**
     * 图片压缩最长边限制
     */
    private Integer imageCompressBorder = 1600;

    /**
     * 插入的图片浮动方式
     */
    private String imageInsertAlign = "none";
    /**
     * 图片访问路径前缀
     */
    private String imageUrlPrefix = "";
    /**
     * 上传保存路径,可以自定义保存路径和文件名格式
     * {filename} 会替换成原文件名,配置这项需要注意中文乱码问题
     * {rand:6} 会替换成随机数,后面的数字是随机数的位数
     * {time} 会替换成时间戳
     * {yyyy} 会替换成四位年份
     * {yy} 会替换成两位年份
     * {mm} 会替换成两位月份
     * {dd} 会替换成两位日期
     * {hh} 会替换成两位小时
     * {ii} 会替换成两位分钟
     * {ss} 会替换成两位秒
     * 非法字符 \ : * ? " < > |
     * 具请体看线上文档: fex.baidu.com/ueditor/#use-format_upload_filename
     */
    private String imagePathFormat = "/ueditor/jsp/upload/image/{yyyy}{mm}{dd}/{time}{rand:6}";

    //-----------涂鸦图片上传配置项-----------
    /**
     * 执行上传涂鸦的action名称
     */
    private String scrawlActionName = "uploadscrawl";
    /**
     * 提交的图片表单名称
     */
    private String scrawlFieldName = "upfile";
    /**
     * 上传保存路径,可以自定义保存路径和文件名格式
     */
    private String scrawlPathFormat = "/ueditor/jsp/upload/image/{yyyy}{mm}{dd}/{time}{rand:6}";
    /**
     * 上传大小限制，单位B
     */
    private Long scrawlMaxSize = 2048000L;
    /**
     * 图片访问路径前缀
     */
    private String scrawlUrlPrefix = "";
    private String scrawlInsertAlign = "none";

    //----------截图工具上传----------
    /**
     * 执行上传截图的action名称
     */
    private String snapscreenActionName = "uploadimage";
    /**
     * 上传保存路径,可以自定义保存路径和文件名格式
     */
    private String snapscreenPathFormat = "/ueditor/jsp/upload/image/{yyyy}{mm}{dd}/{time}{rand:6}";
    /**
     * 图片访问路径前缀
     */
    private String snapscreenUrlPrefix = "";
    /**
     * 插入的图片浮动方式
     */
    private String snapscreenInsertAlign = "none";

    //----------抓取远程图片配置----------

    private String[] catcherLocalDomain = new String[]{"127.0.0.1", "localhost", "img.baidu.com"};

    /**
     * 执行抓取远程图片的action名称
     */
    private String catcherActionName = "catchimage";
    /**
     * 提交的图片列表表单名称
     */
    private String catcherFieldName = "source";
    /**
     * 上传保存路径,可以自定义保存路径和文件名格式
     */
    private String catcherPathFormat = "/ueditor/jsp/upload/image/{yyyy}{mm}{dd}/{time}{rand:6}";
    /**
     * 图片访问路径前缀
     */
    private String catcherUrlPrefix = "";
    /**
     * 上传大小限制，单位B
     */
    private Long catcherMaxSize = 2048000L;
    /**
     * 抓取图片格式显示
     */
    private String[] catcherAllowFiles = new String[]{".png", ".jpg", ".jpeg", ".gif", ".bmp"};

    //----------上传视频配置----------
    /**
     * 执行上传视频的action名称
     */
    private String videoActionName = "uploadvideo";
    /**
     * 提交的视频表单名称
     */
    private String videoFieldName = "upfile";
    /**
     * 上传保存路径,可以自定义保存路径和文件名格式
     */
    private String videoPathFormat = "/ueditor/jsp/upload/video/{yyyy}{mm}{dd}/{time}{rand:6}";
    /**
     * 视频访问路径前缀
     */
    private String videoUrlPrefix = "";
    /**
     * 上传大小限制，单位B，默认100MB
     */
    private Long videoMaxSize = 102400000L;
    /**
     * 上传视频格式显示
     */
    private String[] videoAllowFiles = new String[]{
            ".flv", ".swf", ".mkv", ".avi", ".rm", ".rmvb", ".mpeg", ".mpg",
            ".ogg", ".ogv", ".mov", ".wmv", ".mp4", ".webm", ".mp3", ".wav", ".mid"};

    //----------上传文件配置----------
    /**
     * controller里,执行上传视频的action名称
     */
    private String fileActionName = "uploadfile";
    /**
     * 提交的文件表单名称
     */
    private String fileFieldName = "upfile";
    /**
     * 上传保存路径,可以自定义保存路径和文件名格式
     */
    private String filePathFormat = "/ueditor/jsp/upload/file/{yyyy}{mm}{dd}/{time}{rand:6}";
    /**
     * 文件访问路径前缀
     */
    private String fileUrlPrefix = "";
    /**
     * 上传大小限制，单位B，默认50MB
     */
    private Long fileMaxSize = 51200000L;
    /**
     * 上传文件格式显示
     */
    private String[] fileAllowFiles = new String[]{
            ".png", ".jpg", ".jpeg", ".gif", ".bmp",
            ".flv", ".swf", ".mkv", ".avi", ".rm", ".rmvb", ".mpeg", ".mpg",
            ".ogg", ".ogv", ".mov", ".wmv", ".mp4", ".webm", ".mp3", ".wav", ".mid",
            ".rar", ".zip", ".tar", ".gz", ".7z", ".bz2", ".cab", ".iso",
            ".doc", ".docx", ".xls", ".xlsx", ".ppt", ".pptx", ".pdf", ".txt", ".md", ".xml"
    };

    //----------列出指定目录下的图片-----------
    /**
     * 执行图片管理的action名称
     */
    private String imageManagerActionName = "listimage";
    /**
     * 指定要列出图片的目录
     */
    private String imageManagerListPath = "/ueditor/jsp/upload/image/";
    /**
     * 每次列出文件数量
     */
    private Integer imageManagerListSize = 20;
    /**
     * 图片访问路径前缀
     */
    private String imageManagerUrlPrefix = "";
    /**
     * 插入的图片浮动方式
     */
    private String imageManagerInsertAlign = "none";
    /**
     * 列出的文件类型
     */
    private String imageManagerAllowFiles[] = new String[]{".png", ".jpg", ".jpeg", ".gif", ".bmp"};


    //----------列出指定目录下的文件----------
    /**
     * 执行文件管理的action名称
     */
    private String fileManagerActionName = "listfile";
    /**
     * 指定要列出文件的目录
     */
    private String fileManagerListPath = "/ueditor/jsp/upload/file/";
    /**
     * 文件访问路径前缀
     */
    private String fileManagerUrlPrefix = "";
    /**
     * 每次列出文件数量
     */
    private Integer fileManagerListSize = 20;
    /**
     * 列出的文件类型
     */
    private String[] fileManagerAllowFiles = new String[]{
            ".png", ".jpg", ".jpeg", ".gif", ".bmp",
            ".flv", ".swf", ".mkv", ".avi", ".rm", ".rmvb", ".mpeg", ".mpg",
            ".ogg", ".ogv", ".mov", ".wmv", ".mp4", ".webm", ".mp3", ".wav", ".mid",
            ".rar", ".zip", ".tar", ".gz", ".7z", ".bz2", ".cab", ".iso",
            ".doc", ".docx", ".xls", ".xlsx", ".ppt", ".pptx", ".pdf", ".txt", ".md", ".xml"
    };

    @Override
    public String getRootPath() {
        return rootPath;
    }

    public void setRootPath(String rootPath) {
        this.rootPath = rootPath;
    }

    @Override
    public String getImageActionName() {
        return imageActionName;
    }

    public void setImageActionName(String imageActionName) {
        this.imageActionName = imageActionName;
    }
    @Override
    public String getImageFieldName() {
        return imageFieldName;
    }

    public void setImageFieldName(String imageFieldName) {
        this.imageFieldName = imageFieldName;
    }
    @Override
    public Long getImageMaxSize() {
        return imageMaxSize;
    }

    public void setImageMaxSize(Long imageMaxSize) {
        this.imageMaxSize = imageMaxSize;
    }
    @Override
    public String[] getImageAllowFiles() {
        return imageAllowFiles;
    }

    public void setImageAllowFiles(String[] imageAllowFiles) {
        this.imageAllowFiles = imageAllowFiles;
    }
    @Override
    public Boolean getImageCompressEnable() {
        return imageCompressEnable;
    }

    public void setImageCompressEnable(Boolean imageCompressEnable) {
        this.imageCompressEnable = imageCompressEnable;
    }
    @Override
    public Integer getImageCompressBorder() {
        return imageCompressBorder;
    }

    public void setImageCompressBorder(Integer imageCompressBorder) {
        this.imageCompressBorder = imageCompressBorder;
    }
    @Override
    public String getImageInsertAlign() {
        return imageInsertAlign;
    }

    public void setImageInsertAlign(String imageInsertAlign) {
        this.imageInsertAlign = imageInsertAlign;
    }
    @Override
    public String getImageUrlPrefix() {
        return imageUrlPrefix;
    }

    public void setImageUrlPrefix(String imageUrlPrefix) {
        this.imageUrlPrefix = imageUrlPrefix;
    }
    @Override
    public String getImagePathFormat() {
        return imagePathFormat;
    }

    public void setImagePathFormat(String imagePathFormat) {
        this.imagePathFormat = imagePathFormat;
    }

    @Override
    public String getScrawlActionName() {
        return scrawlActionName;
    }

    public void setScrawlActionName(String scrawlActionName) {
        this.scrawlActionName = scrawlActionName;
    }
    @Override
    public String getScrawlFieldName() {
        return scrawlFieldName;
    }

    public void setScrawlFieldName(String scrawlFieldName) {
        this.scrawlFieldName = scrawlFieldName;
    }
    @Override
    public String getScrawlPathFormat() {
        return scrawlPathFormat;
    }

    public void setScrawlPathFormat(String scrawlPathFormat) {
        this.scrawlPathFormat = scrawlPathFormat;
    }
    @Override
    public Long getScrawlMaxSize() {
        return scrawlMaxSize;
    }

    public void setScrawlMaxSize(Long scrawlMaxSize) {
        this.scrawlMaxSize = scrawlMaxSize;
    }
    @Override
    public String getScrawlUrlPrefix() {
        return scrawlUrlPrefix;
    }

    public void setScrawlUrlPrefix(String scrawlUrlPrefix) {
        this.scrawlUrlPrefix = scrawlUrlPrefix;
    }
    @Override
    public String getScrawlInsertAlign() {
        return scrawlInsertAlign;
    }

    public void setScrawlInsertAlign(String scrawlInsertAlign) {
        this.scrawlInsertAlign = scrawlInsertAlign;
    }
    @Override
    public String getSnapscreenActionName() {
        return snapscreenActionName;
    }

    public void setSnapscreenActionName(String snapscreenActionName) {
        this.snapscreenActionName = snapscreenActionName;
    }
    @Override
    public String getSnapscreenPathFormat() {
        return snapscreenPathFormat;
    }

    public void setSnapscreenPathFormat(String snapscreenPathFormat) {
        this.snapscreenPathFormat = snapscreenPathFormat;
    }
    @Override
    public String getSnapscreenUrlPrefix() {
        return snapscreenUrlPrefix;
    }

    public void setSnapscreenUrlPrefix(String snapscreenUrlPrefix) {
        this.snapscreenUrlPrefix = snapscreenUrlPrefix;
    }
    @Override
    public String getSnapscreenInsertAlign() {
        return snapscreenInsertAlign;
    }

    public void setSnapscreenInsertAlign(String snapscreenInsertAlign) {
        this.snapscreenInsertAlign = snapscreenInsertAlign;
    }
    @Override
    public String[] getCatcherLocalDomain() {
        return catcherLocalDomain;
    }

    public void setCatcherLocalDomain(String[] catcherLocalDomain) {
        this.catcherLocalDomain = catcherLocalDomain;
    }
    @Override
    public String getCatcherActionName() {
        return catcherActionName;
    }

    public void setCatcherActionName(String catcherActionName) {
        this.catcherActionName = catcherActionName;
    }
    @Override
    public String getCatcherFieldName() {
        return catcherFieldName;
    }

    public void setCatcherFieldName(String catcherFieldName) {
        this.catcherFieldName = catcherFieldName;
    }
    @Override
    public String getCatcherPathFormat() {
        return catcherPathFormat;
    }

    public void setCatcherPathFormat(String catcherPathFormat) {
        this.catcherPathFormat = catcherPathFormat;
    }
    @Override
    public String getCatcherUrlPrefix() {
        return catcherUrlPrefix;
    }

    public void setCatcherUrlPrefix(String catcherUrlPrefix) {
        this.catcherUrlPrefix = catcherUrlPrefix;
    }
    @Override
    public Long getCatcherMaxSize() {
        return catcherMaxSize;
    }

    public void setCatcherMaxSize(Long catcherMaxSize) {
        this.catcherMaxSize = catcherMaxSize;
    }
    @Override
    public String[] getCatcherAllowFiles() {
        return catcherAllowFiles;
    }

    public void setCatcherAllowFiles(String[] catcherAllowFiles) {
        this.catcherAllowFiles = catcherAllowFiles;
    }
    @Override
    public String getVideoActionName() {
        return videoActionName;
    }

    public void setVideoActionName(String videoActionName) {
        this.videoActionName = videoActionName;
    }
    @Override
    public String getVideoFieldName() {
        return videoFieldName;
    }

    public void setVideoFieldName(String videoFieldName) {
        this.videoFieldName = videoFieldName;
    }
    @Override
    public String getVideoPathFormat() {
        return videoPathFormat;
    }

    public void setVideoPathFormat(String videoPathFormat) {
        this.videoPathFormat = videoPathFormat;
    }
    @Override
    public String getVideoUrlPrefix() {
        return videoUrlPrefix;
    }

    public void setVideoUrlPrefix(String videoUrlPrefix) {
        this.videoUrlPrefix = videoUrlPrefix;
    }
    @Override
    public Long getVideoMaxSize() {
        return videoMaxSize;
    }

    public void setVideoMaxSize(Long videoMaxSize) {
        this.videoMaxSize = videoMaxSize;
    }
    @Override
    public String[] getVideoAllowFiles() {
        return videoAllowFiles;
    }

    public void setVideoAllowFiles(String[] videoAllowFiles) {
        this.videoAllowFiles = videoAllowFiles;
    }
    @Override
    public String getFileActionName() {
        return fileActionName;
    }

    public void setFileActionName(String fileActionName) {
        this.fileActionName = fileActionName;
    }
    @Override
    public String getFileFieldName() {
        return fileFieldName;
    }

    public void setFileFieldName(String fileFieldName) {
        this.fileFieldName = fileFieldName;
    }
    @Override
    public String getFilePathFormat() {
        return filePathFormat;
    }

    public void setFilePathFormat(String filePathFormat) {
        this.filePathFormat = filePathFormat;
    }
    @Override
    public String getFileUrlPrefix() {
        return fileUrlPrefix;
    }

    public void setFileUrlPrefix(String fileUrlPrefix) {
        this.fileUrlPrefix = fileUrlPrefix;
    }
    @Override
    public Long getFileMaxSize() {
        return fileMaxSize;
    }

    public void setFileMaxSize(Long fileMaxSize) {
        this.fileMaxSize = fileMaxSize;
    }
    @Override
    public String[] getFileAllowFiles() {
        return fileAllowFiles;
    }

    public void setFileAllowFiles(String[] fileAllowFiles) {
        this.fileAllowFiles = fileAllowFiles;
    }
    @Override
    public String getImageManagerActionName() {
        return imageManagerActionName;
    }

    public void setImageManagerActionName(String imageManagerActionName) {
        this.imageManagerActionName = imageManagerActionName;
    }
    @Override
    public String getImageManagerListPath() {
        return imageManagerListPath;
    }

    public void setImageManagerListPath(String imageManagerListPath) {
        this.imageManagerListPath = imageManagerListPath;
    }
    @Override
    public Integer getImageManagerListSize() {
        return imageManagerListSize;
    }

    public void setImageManagerListSize(Integer imageManagerListSize) {
        this.imageManagerListSize = imageManagerListSize;
    }
    @Override
    public String getImageManagerUrlPrefix() {
        return imageManagerUrlPrefix;
    }

    public void setImageManagerUrlPrefix(String imageManagerUrlPrefix) {
        this.imageManagerUrlPrefix = imageManagerUrlPrefix;
    }
    @Override
    public String getImageManagerInsertAlign() {
        return imageManagerInsertAlign;
    }

    public void setImageManagerInsertAlign(String imageManagerInsertAlign) {
        this.imageManagerInsertAlign = imageManagerInsertAlign;
    }
    @Override
    public String[] getImageManagerAllowFiles() {
        return imageManagerAllowFiles;
    }

    public void setImageManagerAllowFiles(String[] imageManagerAllowFiles) {
        this.imageManagerAllowFiles = imageManagerAllowFiles;
    }
    @Override
    public String getFileManagerActionName() {
        return fileManagerActionName;
    }

    public void setFileManagerActionName(String fileManagerActionName) {
        this.fileManagerActionName = fileManagerActionName;
    }
    @Override
    public String getFileManagerListPath() {
        return fileManagerListPath;
    }

    public void setFileManagerListPath(String fileManagerListPath) {
        this.fileManagerListPath = fileManagerListPath;
    }
    @Override
    public String getFileManagerUrlPrefix() {
        return fileManagerUrlPrefix;
    }

    public void setFileManagerUrlPrefix(String fileManagerUrlPrefix) {
        this.fileManagerUrlPrefix = fileManagerUrlPrefix;
    }
    @Override
    public Integer getFileManagerListSize() {
        return fileManagerListSize;
    }

    public void setFileManagerListSize(Integer fileManagerListSize) {
        this.fileManagerListSize = fileManagerListSize;
    }
    @Override
    public String[] getFileManagerAllowFiles() {
        return fileManagerAllowFiles;
    }

    public void setFileManagerAllowFiles(String[] fileManagerAllowFiles) {
        this.fileManagerAllowFiles = fileManagerAllowFiles;
    }

    @Override
    public String allConfig() {
        return new JSONObject(this).toString();
    }
}

