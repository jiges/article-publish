# springboot整合百度Ueditor
简易的文章发布系统

## 功能描述
  后台使用百度Ueditor编辑文章，前台展示文章。
  ![后台文章列表](https://github.com/jiges/article-publish/blob/master/readme/%E5%88%97%E8%A1%A8.png)
  ![后台文章编辑](https://github.com/jiges/article-publish/blob/master/readme/%E6%96%87%E7%AB%A0%E5%8F%91%E5%B8%83.png?raw=true)
  ![前台文章列表](https://github.com/jiges/article-publish/blob/master/readme/QQ%E6%88%AA%E5%9B%BE20180921101821.png)
  ![前台文章](https://github.com/jiges/article-publish/blob/master/readme/clipboard.png)
  
  
## 配置说明
  系统整合了Ueditor和springboot，修改了Ueditor 后端的部分源码，使其能自动配置，查看源码ueditor-spring-boot。
  增加了一些配置属性，例如rootPath，保存文件或者附件的服务器路径。Ueditor默认配置参考[官方的默认配置](http://fex.baidu.com/ueditor/)
  ```
  # 默认配置
spring: #spring配置
    datasource: #数据源配置
        driverClassName: com.mysql.jdbc.Driver
        url: jdbc:mysql://172.16.251.253:3306/ahamp-cms?useUnicode=true&characterEncoding=utf-8
        username: root
        password: 5Yg6f4x1%bDiX%Q*
    servlet:
        multipart: #commons包中的ServletFileUpload读取request文件流，要求该request不能被spring的multipart处理过
            enabled: false
    mvc:  #图片上传后映射到静态文件
        static-path-pattern: /**
    resources:
        static-locations: classpath:/META-INF/resources/,classpath:/resources/,classpath:/static/,classpath:/public/,file:D:/work/ahamp-cms/ahamp-cms-static,file:${ueditor.rootPath}

mybatis: # mybatis配置
    mapperLocations: classpath:mapper/*.xml

server: #服务器配置
    port: 8080

ueditor: # 配置Ueditor
    rootPath: E:/ahamp_images # 图片上传路径
    image:
        compressEnable: true
        compressBorder: 1000
        insertAlign: center
        pathFormat: /image/{yyyy}{mm}{dd}/{time}{rand:6}
    imageManager:
        listPath: /image/
        insertAlign: center
#debug: true #日志级别
logging:
    level:
      com.nongrj.dao: DEBUG
---


# 测试配置，覆盖默认配置
spring:
    profiles: test
    resources:
        static-locations: classpath:/META-INF/resources/,classpath:/resources/,classpath:/static/,classpath:/public/,file:/home/server/ahamp-cms/static,file:${ueditor.rootPath}
ueditor:
    rootPath: /home/server/ahamp-cms/static/images
server: #服务器配置
    port: 8089
---

# 生产配置，覆盖默认配置
spring:
    profiles: prod
    resources:
            static-locations: classpath:/META-INF/resources/,classpath:/resources/,classpath:/static/,classpath:/public/,file:D:/dev/ahamp-cms/static,file:${ueditor.rootPath}
    datasource:
        url: jdbc:mysql://127.0.0.1:3306/ahamp-cms?useUnicode=true&amp;characterEncoding=utf-8
        username: root
        password: Nrj2016qwe!@#
ueditor:
    rootPath: D:/dev/ahamp-cms/upload
server:
    port: 8080
logging:
    level:
        com.nongrj.dao: DEBUG
    file: ahamp-cms.log
    path: D:/dev/ahamp-cms/log
  ```
