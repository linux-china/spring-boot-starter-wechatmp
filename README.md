spring-boot-start-wechatmp
===================================
Spring Boot对微信公众号(订阅号、服务号)的支持

### usage
in pom.xml add following dependency:

      <dependency>
          <groupId>org.mvnsearch.wechat</groupId>
          <artifactId>spring-boot-starter-wechatmp</artifactId>
          <version>1.0.0-SNAPSHOT</version>
      </dependency>
      
in application.properties file, please add following keys:

     spring.wechatmp.appId=xxxx
     spring.wechatmp.secret=yyyy
If you set token and aesKey in wechat backend, please add following settings:
     
     spring.wechatmp.token=your-token
     spring.wechatmp.aesKey=your-aeskey
If you want to implement wechat payment features, please add following settings:
     
     spring.wechatmp.partnerId=your-partnerId
     spring.wechatmp.partnerKey=your-partnerKey
in your code you can use OssClient directly:

     @Autowired
     WxMpService wxMpService;
     
### spring-boot-start-wechatmp service List

* me.chanjar.weixin.mp.api.WxMpInMemoryConfigStorage: config storage
* me.chanjar.weixin.mp.api.WxMpService: wechat MP service

### 参考

* 微信开放平台: https://open.weixin.qq.com/
* Wechat接入开发文档: https://github.com/wechat-group/weixin-java-tools