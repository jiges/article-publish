package com.baidu.ueditor;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author ccr
 * @date 2018/8/15
 */
@ConfigurationProperties(prefix = "ueditor")
public class UeditorProperties {

    private String rootPath;

    private Image image = new Image();

    private Scrawl scrawl = new Scrawl();

    private SnapScreen snapScreen = new SnapScreen();

    private Catcher catcher = new Catcher();

    private Video video = new Video();

    private File file = new File();

    private ImageManager imageManager = new ImageManager();

    private FileManager fileManager = new FileManager();

    public String getRootPath() {
        return rootPath;
    }

    public void setRootPath(String rootPath) {
        this.rootPath = rootPath;
    }

    public Image getImage() {
        return image;
    }

    public Scrawl getScrawl() {
        return scrawl;
    }

    public SnapScreen getSnapScreen() {
        return snapScreen;
    }

    public Catcher getCatcher() {
        return catcher;
    }

    public Video getVideo() {
        return video;
    }

    public File getFile() {
        return file;
    }

    public ImageManager getImageManager() {
        return imageManager;
    }

    public FileManager getFileManager() {
        return fileManager;
    }

    /**
     * 图片配置
     */
    public static class Image {
        /**
         * 执行上传图片的action名称
         */
        private String actionName = "uploadimage";
        /**
         * 提交的图片表单名称
         */
        private String fieldName = "upfile";
        /**
         * 上传大小限制，单位B
         */
        private Long maxSize = 2048000L;
        /**
         * 上传图片格式显示
         */
        private String[] allowFiles = new String[]{".png", ".jpg", ".jpeg", ".gif", ".bmp"};

        /**
         * 是否压缩图片,默认是true
         */
        private Boolean compressEnable = true;

        /**
         * 图片压缩最长边限制
         */
        private Integer compressBorder = 1600;

        /**
         * 插入的图片浮动方式
         */
        private String insertAlign = "none";
        /**
         * 图片访问路径前缀
         */
        private String urlPrefix = "";
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
        private String pathFormat = "/ueditor/jsp/upload/image/{yyyy}{mm}{dd}/{time}{rand:6}";

        public String getActionName() {
            return actionName;
        }

        public void setActionName(String actionName) {
            this.actionName = actionName;
        }

        public String getFieldName() {
            return fieldName;
        }

        public void setFieldName(String fieldName) {
            this.fieldName = fieldName;
        }

        public Long getMaxSize() {
            return maxSize;
        }

        public void setMaxSize(Long maxSize) {
            this.maxSize = maxSize;
        }

        public String[] getAllowFiles() {
            return allowFiles;
        }

        public void setAllowFiles(String[] allowFiles) {
            this.allowFiles = allowFiles;
        }

        public Boolean getCompressEnable() {
            return compressEnable;
        }

        public void setCompressEnable(Boolean compressEnable) {
            this.compressEnable = compressEnable;
        }

        public Integer getCompressBorder() {
            return compressBorder;
        }

        public void setCompressBorder(Integer compressBorder) {
            this.compressBorder = compressBorder;
        }

        public String getInsertAlign() {
            return insertAlign;
        }

        public void setInsertAlign(String insertAlign) {
            this.insertAlign = insertAlign;
        }

        public String getUrlPrefix() {
            return urlPrefix;
        }

        public void setUrlPrefix(String urlPrefix) {
            this.urlPrefix = urlPrefix;
        }

        public String getPathFormat() {
            return pathFormat;
        }

        public void setPathFormat(String pathFormat) {
            this.pathFormat = pathFormat;
        }
    }

    /**
     * 涂鸦图片上传配置项
     */
    public static class Scrawl {
        /**
         * 执行上传涂鸦的action名称
         */
        private String actionName = "uploadscrawl";
        /**
         * 提交的图片表单名称
         */
        private String fieldName = "upfile";
        /**
         * 上传保存路径,可以自定义保存路径和文件名格式
         */
        private String pathFormat = "/ueditor/jsp/upload/image/{yyyy}{mm}{dd}/{time}{rand:6}";
        /**
         * 上传大小限制，单位B
         */
        private Long maxSize = 2048000L;
        /**
         * 图片访问路径前缀
         */
        private String urlPrefix = "";
        private String insertAlign = "none";

        public String getActionName() {
            return actionName;
        }

        public void setActionName(String actionName) {
            this.actionName = actionName;
        }

        public String getFieldName() {
            return fieldName;
        }

        public void setFieldName(String fieldName) {
            this.fieldName = fieldName;
        }

        public String getPathFormat() {
            return pathFormat;
        }

        public void setPathFormat(String pathFormat) {
            this.pathFormat = pathFormat;
        }

        public Long getMaxSize() {
            return maxSize;
        }

        public void setMaxSize(Long maxSize) {
            this.maxSize = maxSize;
        }

        public String getUrlPrefix() {
            return urlPrefix;
        }

        public void setUrlPrefix(String urlPrefix) {
            this.urlPrefix = urlPrefix;
        }

        public String getInsertAlign() {
            return insertAlign;
        }

        public void setInsertAlign(String insertAlign) {
            this.insertAlign = insertAlign;
        }
    }

    /**
     * 截图工具上传
     */
    public static class SnapScreen{
        /**
         * 执行上传截图的action名称
         */
        private String actionName = "uploadimage";
        /**
         * 上传保存路径,可以自定义保存路径和文件名格式
         */
        private String pathFormat = "/ueditor/jsp/upload/image/{yyyy}{mm}{dd}/{time}{rand:6}";
        /**
         * 图片访问路径前缀
         */
        private String urlPrefix = "";
        /**
         * 插入的图片浮动方式
         */
        private String insertAlign = "none";

        public String getActionName() {
            return actionName;
        }

        public void setActionName(String actionName) {
            this.actionName = actionName;
        }

        public String getPathFormat() {
            return pathFormat;
        }

        public void setPathFormat(String pathFormat) {
            this.pathFormat = pathFormat;
        }

        public String getUrlPrefix() {
            return urlPrefix;
        }

        public void setUrlPrefix(String urlPrefix) {
            this.urlPrefix = urlPrefix;
        }

        public String getInsertAlign() {
            return insertAlign;
        }

        public void setInsertAlign(String insertAlign) {
            this.insertAlign = insertAlign;
        }
    }

    public static class Catcher {
        private String[] localDomain = new String[]{"127.0.0.1", "localhost", "img.baidu.com"};

        /**
         * 执行抓取远程图片的action名称
         */
        private String actionName = "catchimage";
        /**
         * 提交的图片列表表单名称
         */
        private String fieldName = "source";
        /**
         * 上传保存路径,可以自定义保存路径和文件名格式
         */
        private String pathFormat = "/ueditor/jsp/upload/image/{yyyy}{mm}{dd}/{time}{rand:6}";
        /**
         * 图片访问路径前缀
         */
        private String urlPrefix = "";
        /**
         * 上传大小限制，单位B
         */
        private Long maxSize = 2048000L;
        /**
         * 抓取图片格式显示
         */
        private String[] allowFiles = new String[]{".png", ".jpg", ".jpeg", ".gif", ".bmp"};

        public String[] getLocalDomain() {
            return localDomain;
        }

        public void setLocalDomain(String[] localDomain) {
            this.localDomain = localDomain;
        }

        public String getActionName() {
            return actionName;
        }

        public void setActionName(String actionName) {
            this.actionName = actionName;
        }

        public String getFieldName() {
            return fieldName;
        }

        public void setFieldName(String fieldName) {
            this.fieldName = fieldName;
        }

        public String getPathFormat() {
            return pathFormat;
        }

        public void setPathFormat(String pathFormat) {
            this.pathFormat = pathFormat;
        }

        public String getUrlPrefix() {
            return urlPrefix;
        }

        public void setUrlPrefix(String urlPrefix) {
            this.urlPrefix = urlPrefix;
        }

        public Long getMaxSize() {
            return maxSize;
        }

        public void setMaxSize(Long maxSize) {
            this.maxSize = maxSize;
        }

        public String[] getAllowFiles() {
            return allowFiles;
        }

        public void setAllowFiles(String[] allowFiles) {
            this.allowFiles = allowFiles;
        }
    }

    /**
     * 上传视频配置
     */
    public static class Video {
        /**
         * 执行上传视频的action名称
         */
        private String actionName = "uploadvideo";
        /**
         * 提交的视频表单名称
         */
        private String fieldName = "upfile";
        /**
         * 上传保存路径,可以自定义保存路径和文件名格式
         */
        private String pathFormat = "/ueditor/jsp/upload/video/{yyyy}{mm}{dd}/{time}{rand:6}";
        /**
         * 视频访问路径前缀
         */
        private String urlPrefix = "";
        /**
         * 上传大小限制，单位B，默认100MB
         */
        private Long maxSize = 102400000L;
        /**
         * 上传视频格式显示
         */
        private String[] allowFiles = new String[]{
                ".flv", ".swf", ".mkv", ".avi", ".rm", ".rmvb", ".mpeg", ".mpg",
                ".ogg", ".ogv", ".mov", ".wmv", ".mp4", ".webm", ".mp3", ".wav", ".mid"};

        public String getActionName() {
            return actionName;
        }

        public void setActionName(String actionName) {
            this.actionName = actionName;
        }

        public String getFieldName() {
            return fieldName;
        }

        public void setFieldName(String fieldName) {
            this.fieldName = fieldName;
        }

        public String getPathFormat() {
            return pathFormat;
        }

        public void setPathFormat(String pathFormat) {
            this.pathFormat = pathFormat;
        }

        public String getUrlPrefix() {
            return urlPrefix;
        }

        public void setUrlPrefix(String urlPrefix) {
            this.urlPrefix = urlPrefix;
        }

        public Long getMaxSize() {
            return maxSize;
        }

        public void setMaxSize(Long maxSize) {
            this.maxSize = maxSize;
        }

        public String[] getAllowFiles() {
            return allowFiles;
        }

        public void setAllowFiles(String[] allowFiles) {
            this.allowFiles = allowFiles;
        }
    }

    /**
     * 上传文件配置
     */
    public static class File {
        /**
         * controller里,执行上传视频的action名称
         */
        private String actionName = "uploadfile";
        /**
         * 提交的文件表单名称
         */
        private String fieldName = "upfile";
        /**
         * 上传保存路径,可以自定义保存路径和文件名格式
         */
        private String pathFormat = "/ueditor/jsp/upload/file/{yyyy}{mm}{dd}/{time}{rand:6}";
        /**
         * 文件访问路径前缀
         */
        private String urlPrefix = "";
        /**
         * 上传大小限制，单位B，默认50MB
         */
        private Long maxSize = 51200000L;
        /**
         * 上传文件格式显示
         */
        private String[] allowFiles = new String[]{
                ".png", ".jpg", ".jpeg", ".gif", ".bmp",
                ".flv", ".swf", ".mkv", ".avi", ".rm", ".rmvb", ".mpeg", ".mpg",
                ".ogg", ".ogv", ".mov", ".wmv", ".mp4", ".webm", ".mp3", ".wav", ".mid",
                ".rar", ".zip", ".tar", ".gz", ".7z", ".bz2", ".cab", ".iso",
                ".doc", ".docx", ".xls", ".xlsx", ".ppt", ".pptx", ".pdf", ".txt", ".md", ".xml"
        };

        public String getActionName() {
            return actionName;
        }

        public void setActionName(String actionName) {
            this.actionName = actionName;
        }

        public String getFieldName() {
            return fieldName;
        }

        public void setFieldName(String fieldName) {
            this.fieldName = fieldName;
        }

        public String getPathFormat() {
            return pathFormat;
        }

        public void setPathFormat(String pathFormat) {
            this.pathFormat = pathFormat;
        }

        public String getUrlPrefix() {
            return urlPrefix;
        }

        public void setUrlPrefix(String urlPrefix) {
            this.urlPrefix = urlPrefix;
        }

        public Long getMaxSize() {
            return maxSize;
        }

        public void setMaxSize(Long maxSize) {
            this.maxSize = maxSize;
        }

        public String[] getAllowFiles() {
            return allowFiles;
        }

        public void setAllowFiles(String[] allowFiles) {
            this.allowFiles = allowFiles;
        }
    }

    /**
     * 列出指定目录下的图片
     */
    public static class ImageManager {
        /**
         * 执行图片管理的action名称
         */
        private String actionName = "listimage";
        /**
         * 指定要列出图片的目录
         */
        private String listPath = "/ueditor/jsp/upload/image/";
        /**
         * 每次列出文件数量
         */
        private Integer listSize = 20;
        /**
         * 图片访问路径前缀
         */
        private String urlPrefix = "";
        /**
         * 插入的图片浮动方式
         */
        private String insertAlign = "none";
        /**
         * 列出的文件类型
         */
        private String allowFiles[] = new String[]{".png", ".jpg", ".jpeg", ".gif", ".bmp"};

        public String getActionName() {
            return actionName;
        }

        public void setActionName(String actionName) {
            this.actionName = actionName;
        }

        public String getListPath() {
            return listPath;
        }

        public void setListPath(String listPath) {
            this.listPath = listPath;
        }

        public Integer getListSize() {
            return listSize;
        }

        public void setListSize(Integer listSize) {
            this.listSize = listSize;
        }

        public String getUrlPrefix() {
            return urlPrefix;
        }

        public void setUrlPrefix(String urlPrefix) {
            this.urlPrefix = urlPrefix;
        }

        public String getInsertAlign() {
            return insertAlign;
        }

        public void setInsertAlign(String insertAlign) {
            this.insertAlign = insertAlign;
        }

        public String[] getAllowFiles() {
            return allowFiles;
        }

        public void setAllowFiles(String[] allowFiles) {
            this.allowFiles = allowFiles;
        }
    }


    /**
     * 列出指定目录下的文件
     */
    public static class FileManager {
        /**
         * 执行文件管理的action名称
         */
        private String actionName = "listfile";
        /**
         * 指定要列出文件的目录
         */
        private String listPath = "/ueditor/jsp/upload/file/";
        /**
         * 文件访问路径前缀
         */
        private String urlPrefix = "";
        /**
         * 每次列出文件数量
         */
        private Integer listSize = 20;
        /**
         * 列出的文件类型
         */
        private String[] allowFiles = new String[]{
                ".png", ".jpg", ".jpeg", ".gif", ".bmp",
                ".flv", ".swf", ".mkv", ".avi", ".rm", ".rmvb", ".mpeg", ".mpg",
                ".ogg", ".ogv", ".mov", ".wmv", ".mp4", ".webm", ".mp3", ".wav", ".mid",
                ".rar", ".zip", ".tar", ".gz", ".7z", ".bz2", ".cab", ".iso",
                ".doc", ".docx", ".xls", ".xlsx", ".ppt", ".pptx", ".pdf", ".txt", ".md", ".xml"
        };

        public String getActionName() {
            return actionName;
        }

        public void setActionName(String actionName) {
            this.actionName = actionName;
        }

        public String getListPath() {
            return listPath;
        }

        public void setListPath(String listPath) {
            this.listPath = listPath;
        }

        public String getUrlPrefix() {
            return urlPrefix;
        }

        public void setUrlPrefix(String urlPrefix) {
            this.urlPrefix = urlPrefix;
        }

        public Integer getListSize() {
            return listSize;
        }

        public void setListSize(Integer listSize) {
            this.listSize = listSize;
        }

        public String[] getAllowFiles() {
            return allowFiles;
        }

        public void setAllowFiles(String[] allowFiles) {
            this.allowFiles = allowFiles;
        }
    }
}
