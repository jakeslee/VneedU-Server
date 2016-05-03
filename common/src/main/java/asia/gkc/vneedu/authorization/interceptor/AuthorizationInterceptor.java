package asia.gkc.vneedu.authorization.interceptor;

import asia.gkc.vneedu.authorization.annotation.RequireLogin;
import asia.gkc.vneedu.common.Constants;
import asia.gkc.vneedu.common.ResultModel;
import asia.gkc.vneedu.common.ResultStatus;
import asia.gkc.vneedu.utils.IdentityUtil;
import com.alibaba.fastjson.JSON;
import io.jsonwebtoken.ExpiredJwtException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StringUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * File Name: AuthorizationInterceptor.java
 * Function:
 *
 * @author jakes.
 * @version 1.0
 * @DateTime 4/5/16 3:56 PM
 */

public class AuthorizationInterceptor extends HandlerInterceptorAdapter {
    private final Log logger = LogFactory.getLog(this.getClass());

    /**
     * This implementation always returns {@code true}.
     *
     * @param request
     * @param response
     * @param handler
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 跳过非方法的拦截
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }

        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();

        // 跳过不需要登录验证的方法
        if (method.getAnnotation(RequireLogin.class) == null) {
            return true;
        }

        // 获取请求头的授权字段
        String authorization = request.getHeader(Constants.AUTHORIZATION);

        // 进行基础验证
        if (authorization == null) {
            return exitWithHeaderError(response);
        }

        String[] auths = authorization.split(" ");
        if (! auths[0].equals("token") || (auths.length > 1 && StringUtils.isEmpty(auths[1]))) {
            return exitWithHeaderError(response);
        }

        // 验证Token的有效性
        try {
            logger.debug(auths[1]);
            String uuid = IdentityUtil.verifyToken(auths[1]);
            logger.debug(uuid);

            request.setAttribute(Constants.USER_ID_IN_REQUEST, uuid);
        }catch (ExpiredJwtException e) {
            return exitWithExpiredAuth(response);
        }catch (Exception e) {
            return exitWithTokenError(response);
        }

        return true;
    }

    /**
     * 错误退出
     * @param response - 返回响应
     * @param resultStatus 返回的状态
     * @return
     * @throws Exception
     */
    private boolean exitWithError(HttpServletResponse response, ResultStatus resultStatus) throws Exception {
        ResultModel resultModel = ResultModel.ERROR(resultStatus);
        response.setContentType("application/json;charset=UTF-8");
        response.getWriter().write(JSON.toJSONString(resultModel));
        return false;
    }

    /**
     * 返回头部错误
     * @param response - 响应
     * @return
     * @throws Exception
     */
    private boolean exitWithHeaderError(HttpServletResponse response) throws Exception{
        return exitWithError(response, ResultStatus.AUTHORIZATION_HEADER_ERROR);
    }

    /**
     * 返回授权超时错误
     * @param response - 响应
     * @return
     * @throws Exception
     */
    private boolean exitWithExpiredAuth(HttpServletResponse response) throws Exception{
        return exitWithError(response, ResultStatus.AUTHORIZATION_TIMEOUT);
    }

    /**
     * 返回Token错误
     * @param response - 响应
     * @return
     * @throws Exception
     */
    private boolean exitWithTokenError(HttpServletResponse response) throws Exception{
        return exitWithError(response, ResultStatus.AUTHORIZATION_TOKEN_ERROR);
    }
}
