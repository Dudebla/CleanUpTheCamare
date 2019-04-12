package web;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import service.userService;
import domain.User;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;
import java.util.HashMap;

@RestController
public class MainController {
    private userService userService;

    @Autowired
    public void setUserService(userService userService){
        this.userService = userService;
    }

    @RequestMapping(value = "index.html")
    public ModelAndView loginPage(){
        return new ModelAndView("login");
    }

    @RequestMapping(value = "/login.html")
    public ModelAndView login(HttpServletRequest request){
        return new ModelAndView("login");
    }

    @RequestMapping(value = "/login")
    public Map<String, String> dealLogin(HttpServletRequest request){
        String name = request.getParameter("username");
        String pass = request.getParameter("password");
        System.out.println("username:" + name + " password:" + pass + " 尝试登录------>");
        Map<String, String> map = new HashMap<String, String>();
        map.put("result","0");
        boolean isHasUser = userService.hasMatchUser(name);
        //System.out.println(isHasUser);
        if(!isHasUser){
            map.put("result","404");//未找到该用户
            System.out.println("登录失败！未找到该用户!");
            return map;
        }
        User user = userService.findUserByName(name);
        //System.out.println((user == null));
        if(user != null){
            if(user.getPassWord().equals(pass)){
                map.put("result","200");
                map.put("flag",user.getFlag()+"");
                System.out.print("登录成功！");
            }
            else{
                map.put("result","401");
                System.out.println("登录失败！密码错误！");
            }
        }
        return map;
    }
}
