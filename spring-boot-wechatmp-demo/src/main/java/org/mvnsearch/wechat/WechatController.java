package org.mvnsearch.wechat;

import me.chanjar.weixin.mp.api.WxMpConfigStorage;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.result.WxMpOAuth2AccessToken;
import me.chanjar.weixin.mp.bean.result.WxMpUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.metrics.CounterService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.UUID;

/**
 * wechat controller
 *
 * @author linux_china
 */
@Controller
@RequestMapping("/wechat")
public class WechatController {
    private Logger log = LoggerFactory.getLogger(WechatController.class);
    @Autowired
    private WxMpService wxMpService;
    @Autowired
    private WxMpConfigStorage wxMpConfigStorage;
    @Autowired
    private CounterService counterService;

    @RequestMapping("/login")
    public String login() {
        String redirectUrl = "http://www.foobar.com/wechat/callback.action";
        String state = UUID.randomUUID().toString();
        String snsapiLogin = wxMpService.oauth2buildAuthorizationUrl(redirectUrl, "snsapi_login", state);
        return "redirect:" + snsapiLogin;
    }

    @RequestMapping("/weblogin")
    public String webLogin() {
        String state = UUID.randomUUID().toString();
        String callbackUrl = "http%3A%2F%2Fwww.xxxx.com%2Fwechat%2Fcallback.action";
        return "redirect:https://open.weixin.qq.com/connect/qrconnect?appid=" + wxMpConfigStorage.getAppId() + "&redirect_uri=" + callbackUrl + "&response_type=code&scope=snsapi_login&state=" + state + "#wechat_redirect";
    }

    @RequestMapping("/callback")
    public String callback(@RequestParam String code) {
        try {
            WxMpOAuth2AccessToken accessToken = wxMpService.oauth2getAccessToken(code);
            WxMpUser wxMpUser = wxMpService.oauth2getUserInfo(accessToken, "zh_CN");
            if (wxMpUser != null) {
                //....
            }
        } catch (Exception e) {
            counterService.increment("error.wechat.callback");
            log.error("error.wechat.callback", e);
        }
        return "redirect:/home";
    }
}
