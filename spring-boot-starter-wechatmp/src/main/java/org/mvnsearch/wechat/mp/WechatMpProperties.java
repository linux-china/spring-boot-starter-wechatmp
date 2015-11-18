package org.mvnsearch.wechat.mp;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * wechat mp properties
 *
 * @author linux_china
 */
@ConfigurationProperties(
        prefix = "spring.wechatmp"
)
public class WechatMpProperties {
    /**
     * 设置微信公众号的appid
     */
    private String appId;
    /**
     * 设置微信公众号的app secret
     */
    private String secret;
    /**
     * 微信支付partner id
     */
    private String partnerId;
    /**
     * 微信支付partner key
     */
    private String partnerKey;
    /**
     * 设置微信公众号的token
     */
    private String token;
    /**
     * 设置微信公众号的EncodingAESKey
     */
    private String aesKey;

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public String getPartnerId() {
        return partnerId;
    }

    public void setPartnerId(String partnerId) {
        this.partnerId = partnerId;
    }

    public String getPartnerKey() {
        return partnerKey;
    }

    public void setPartnerKey(String partnerKey) {
        this.partnerKey = partnerKey;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getAesKey() {
        return aesKey;
    }

    public void setAesKey(String aesKey) {
        this.aesKey = aesKey;
    }
}
