package interceptor;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.demo1.utils.JwtUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
@Component
public class TokenInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //1. 获取请求路径
        String path = request.getServletPath();
        //2. 判断是否是登录请求,/login
        if (path.equals("/login")) {
            return true;
        }
        //3. 获取请求头中的token
        String token = request.getHeader("token");
        //4. 验证token
        if (token == null || token.isEmpty()) {
            response.setStatus(401);
            return false;
        }
        try {
            JwtUtils.parseJwt(token);
        } catch (Exception e) {
            response.setStatus(401);
            return false;
        }
        //5. 如果验证成功,放行
        return true;
    }

}