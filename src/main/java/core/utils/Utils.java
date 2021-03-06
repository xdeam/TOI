package core.utils;

import core.model.User;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class Utils {
    public static Map userMap = new HashMap();

    public static String saveUser(User vu) {
        // 创建 GUID 对象
        UUID uuid = UUID.randomUUID();
        // 得到对象产生的ID
        String token = uuid.toString();
        // 转换为大写
        token = token.toUpperCase();
        // 替换 “-”变成空格
        token = token.replaceAll("-", "");
        userMap.put(token, vu);
        HttpServletRequest httpRequest = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        httpRequest.getSession().setAttribute("user", vu);
        return token;
    }

    public static User getUser(String token) {
        User u = (User) userMap.get(token);
        System.out.println("autologinUser:" + u);
        return u;
    }

    public static User getUser() {
        HttpServletRequest httpRequest = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        return (User) httpRequest.getSession().getAttribute("user");
    }

}
