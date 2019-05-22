package web;

import domain.Merchant;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import service.userService;
import service.merchantService;
import domain.User;
import domain.Merchant;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;
import java.util.HashMap;

@RestController
public class MainController {
    private userService userService;
    private merchantService merchantService;

    @Autowired
    public void setUserService(userService userService){
        this.userService = userService;
    }

    @Autowired
    public void setMerchantService(merchantService merchantService) { this.merchantService = merchantService; }

    @RequestMapping(value = "index.html")
    public ModelAndView loginPage(){
        return new ModelAndView("login");
    }

    @RequestMapping(value = "/login.html")
    public ModelAndView login(HttpServletRequest request){
        return new ModelAndView("login");
    }

    @RequestMapping(value = "/login")
    public Map<String, String> dealLogin(HttpServletRequest request, HttpServletResponse response){
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
                map.put("id", user.getId()+"");
                System.out.println("登录成功！");
            }
            else{
                map.put("result","401");
                System.out.println("登录失败！密码错误！");
            }
        }
        return map;
    }

    @RequestMapping(value = "/signUp.html")
    public ModelAndView signUp(HttpServletRequest request){
        return new ModelAndView("signUp");
    }

    @RequestMapping(value = "/signUp")
    public Map dealSignUp(HttpServletRequest request){
        String name = request.getParameter("username");
        String pass = request.getParameter("password");
        System.out.println("尝试注册" + name + "用户，密码为" + pass);
        boolean isHaveUser = userService.hasMatchUser(name);
        Map<String, String> map = new HashMap<String, String>();
        if(!isHaveUser){
            User user = new User();
            user.setUserName(name);
            user.setPassWord(pass);
            user.setFlag(1);
            user.setEmail(null);
            user.setPhone(null);
            user.setId("tset"+name);
            boolean success = userService.insertUser(user);
            //System.out.println("success:" + success);
            if(success){
                System.out.println(name + "注册成功!");
                map.put("result","200");
            }
            else{
                System.out.println(name + "注册失败");
                map.put("result","401");
            }

        }
        else{
            map.put("result","404");
            System.out.println(name + "用户已存在！");
        }
        return map;
    }

    @RequestMapping(value = "/getShopInfo.html")
    public ModelAndView shopInfo(HttpServletRequest request){
        return new ModelAndView("getShopInfo");
    }

    @RequestMapping(value = "/getShopInfo")
    public Map<String, String> getShopInfo(HttpServletRequest request, HttpServletResponse response)
    {
        String id = request.getParameter("id");
        System.out.println("ID: " + id + ",正在获取商家信息------>");
        Map<String, String> map = new HashMap<String, String>();
        Merchant merchant;
        merchant = merchantService.getInfoByID(id);
        if(merchant != null)
        {
            map.put("result", "200");
            map.put("name", merchant.getName());
            map.put("address", merchant.getAddress());
            map.put("status", merchant.getStatus());
            map.put("score", merchant.getScore() + "");
            map.put("intro", merchant.getIntroduction());
            System.out.println(merchant.getName());
            System.out.println(merchant.getAddress());
            System.out.println(merchant.getStatus());
            System.out.println(merchant.getScore());
            System.out.println(merchant.getIntroduction());
        }
        else
        {
            map.put("result", "404");
            System.out.println("获取失败!");
        }
        return map;
    }

    @RequestMapping(value = "/updateShopInfo.html")
    public ModelAndView updateShopInfo(HttpServletRequest request)
    {
        return new ModelAndView("updateShopInfo");
    }

    @RequestMapping(value = "/updateShopInfo")
    public Map<String, String> dealUpdateShopInfo(HttpServletRequest request, HttpServletResponse response)
    {
        Map<String, String> map = new HashMap<>();
        Merchant merchant = new Merchant();
        merchant.setID(request.getParameter("id"));
        merchant.setName(request.getParameter("name"));
        merchant.setStatus(request.getParameter("status"));
        merchant.setAddress(request.getParameter("address"));
        merchant.setIntroduction(request.getParameter("intro"));
        merchant.setScore(Double.valueOf(request.getParameter("score")));
        System.out.println("ID:" + request.getParameter("id") + " updating info------>");
        System.out.println("Name: " + request.getParameter("name"));
        boolean result;
        result = merchantService.updateInfoByID(merchant);
        if(result)
        {
            map.put("result","200");
            System.out.println("ID:" + request.getParameter("id") + " update info success");
        }
        else
        {
            map.put("result", "404");
            System.out.println("ID:" + request.getParameter("id") + " update info error");
        }
        return map;
    }
}
