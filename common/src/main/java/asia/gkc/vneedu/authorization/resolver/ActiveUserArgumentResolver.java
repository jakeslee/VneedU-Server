package asia.gkc.vneedu.authorization.resolver;

import asia.gkc.vneedu.authorization.annotation.ActiveUser;
import asia.gkc.vneedu.common.Constants;
import asia.gkc.vneedu.model.User;
import asia.gkc.vneedu.service.UserService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;
import org.springframework.web.multipart.support.MissingServletRequestPartException;

/**
 * File Name: ActiveUserArgumentResolver.java
 * Function:
 *
 * @author jakes.
 * @version 1.0
 * @DateTime 4/5/16 8:41 PM
 */

public class ActiveUserArgumentResolver implements HandlerMethodArgumentResolver {
    private final Log logger = LogFactory.getLog(this.getClass());

    @Autowired
    private UserService userService;

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.getParameterType().isAssignableFrom(User.class) &&
                parameter.hasParameterAnnotation(ActiveUser.class);
    }

    @Override
    public Object resolveArgument(MethodParameter parameter,
                                  ModelAndViewContainer mavContainer,
                                  NativeWebRequest webRequest,
                                  WebDataBinderFactory binderFactory) throws Exception {

        String uuid = (String) webRequest.getAttribute(Constants.USER_ID_IN_REQUEST, RequestAttributes.SCOPE_REQUEST);

        logger.info("Inject User[" + uuid + "] into parameter.");

        if (!StringUtils.isEmpty(uuid)) {
            return userService.getObjectById(uuid);
        }

        return null;
        //throw new MissingServletRequestPartException(Constants.USER_ID_IN_REQUEST);
    }
}
