package com.antsdouble.learnsession.controller;

import com.antsdouble.learnsession.pv.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author lyy
 * @description
 * @date 2019/5/14
 */
@RestController
@RequestMapping("test")
public class LoginController {

    @Autowired
    @Qualifier("userRedisTemplate")
    private RedisTemplate<String, User> rts;

    @RequestMapping("hello")
    public String hello() {
        User user = new User();
        user.setAge(12);
        rts.opsForValue().set("user", user);
        return "1212";
    }

    @RequestMapping(value = "/cookie", method = RequestMethod.GET)
    public String cookie(@RequestParam("browser") String browser, HttpServletRequest request, HttpSession httpSession) {
        Object sessionBrowser = httpSession.getAttribute("browser");
        if (sessionBrowser == null) {
            System.out.println("不存在session 设置browser=" + browser);
            httpSession.setAttribute("browser", browser);

        } else {
            System.out.println("存在session:" + sessionBrowser.toString());
        }
        Cookie[] cookies = request.getCookies();
        if (cookies != null && cookies.length > 0) {
            for (Cookie cookie : cookies) {
                System.out.println(cookie.getName() + ":" + cookie.getValue());
            }
        }
        return "test";
    }

    /**
     * 这里为了能简单在浏览器响应，暂时使用GET请求，
     *
     * @return
     */
    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String login(HttpServletRequest request) {

        request.getSession().setAttribute("url", request.getRequestURL());

        return "success";
    }

    /**
     * 判断用户的session是否有效（在同一个浏览器中，同一个域中，每次Request请求，都会带上Session）
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "isValid", method = RequestMethod.GET)
    public String isSessionValid(HttpServletRequest request) {
        //简化if-else表达式（其实很多地方可以简化的，这里为了方便新手朋友可以看得顺畅点，我尽量不简化）
        return request.isRequestedSessionIdValid() ? "ok" : "no";
    }

    /**
     * 注销登录
     *
     * @param session
     * @return
     */
    @RequestMapping(value = "logout", method = RequestMethod.GET)
    public String logout(HttpSession session) {
        String str = session.getAttribute("url").toString();
        session.invalidate();//使Session变成无效，及用户退出
        return "logout" + str;
    }
}
