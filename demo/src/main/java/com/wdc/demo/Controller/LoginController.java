/*
 *                        _oo0oo_
 *                       o8888888o
 *                       88" . "88
 *                       (| -_- |)
 *                       0\  =  /0
 *                     ___/`---'\___
 *                   .' \\|     |// '.
 *                  / \\|||  :  |||// \
 *                 / _||||| -:- |||||- \
 *                |   | \\\  - /// |   |
 *                | \_|  ''\---/''  |_/ |
 *                \  .-\__  '-'  ___/-. /
 *              ___'. .'  /--.--\  `. .'___
 *           ."" '<  `.___\_<|>_/___.' >' "".
 *          | | :  `- \`.;`\ _ /`;.`/ - ` : | |
 *          \  \ `_.   \_ __\ /__ _/   .-` /  /
 *      =====`-.____`.___ \_____/___.-`___.-'=====
 *                        `=---='
 * 
 * 
 *      ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * 
 *            佛祖保佑       永不宕机     永无BUG
 * 
 * @Author: Wei.Dongcheng
 * @Date: 2020-09-14 19:51:07
 * @LastEditors: Wei.Dongcheng
 * @LastEditTime: 2020-11-21 15:27:59
 * @FilePath: \src\main\java\com\wdc\demo\Controller\LoginController.java
 * @Description: file content
 */

package com.wdc.demo.Controller;

import javax.servlet.http.HttpSession;

import com.wdc.demo.pojo.User;
import com.wdc.demo.result.Result;
import com.wdc.demo.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.HtmlUtils;

/**
 * 负责数据交互，即接收前端发送的数据，通过调用 Service 获得处理后的数据并返回
*/
@Controller
public class LoginController {
    @Autowired
    UserService userService;

    @CrossOrigin  //每个方法前面都加上 @CrossOrigin 允许跨域
    @PostMapping(value = "api/login")
    @ResponseBody
    public Result login(@RequestBody User requestUser, HttpSession session) {
        // 对 html 标签进行转义，防止 XSS 攻击
        String username = requestUser.getUsername();
        username = HtmlUtils.htmlEscape(username);

        // if (!Objects.equals("admin", username) || !Objects.equals("123456", requestUser.getPassword())) {
        //     String message = "账号密码错误";
        //     System.out.println(message);
        //     return new Result(400);
        // } else {
        //     return new Result(200);
        // }
        User user = userService.get(username, requestUser.getPassword());
        if(null == user){
            return new Result(400);
        } else {
            session.setAttribute("user", user);
            return new Result(200);
        }

    }
}