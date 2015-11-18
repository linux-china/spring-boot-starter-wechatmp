package org.mvnsearch.wechat;

import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.result.WxMpOAuth2AccessToken;
import me.chanjar.weixin.mp.bean.result.WxMpUser;
import org.springframework.beans.factory.annotation.Autowired;
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
    @Autowired
    private WxMpService wxMpService;

    @RequestMapping("/login")
    public String login() {
        String redirectUrl = "http://www.foobar.com/wechat/callback.action";
        String state = UUID.randomUUID().toString();
        String snsapiLogin = wxMpService.oauth2buildAuthorizationUrl(redirectUrl, "snsapi_login", state);
        return "redirect:" + snsapiLogin;
    }

    @RequestMapping("/callback")
    public String callback(@RequestParam String code) {
        try {
            WxMpOAuth2AccessToken accessToken = wxMpService.oauth2getAccessToken(code);
            WxMpUser wxMpUser = wxMpService.oauth2getUserInfo(accessToken, "zh_CN");
            if (wxMpUser != null) {
                //....
            }
        } catch (Exception ignore) {

        }
        return "redirect:/home";
    }
}
