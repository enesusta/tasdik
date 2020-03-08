package com.github.enesusta.tasdik.spring;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.enesusta.tasdik.validator.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public final class TasdikMethodArgumentResolver implements HandlerMethodArgumentResolver {

    @Autowired
    private Validator validator;

    @Override
    public final boolean supportsParameter(final MethodParameter methodParameter) {
        return methodParameter.getParameterType().isAnnotationPresent(Tasdik.class);
    }

    @Override
    public final Object resolveArgument(final MethodParameter methodParameter,
                                        final ModelAndViewContainer modelAndViewContainer,
                                        final NativeWebRequest nativeWebRequest,
                                        final WebDataBinderFactory webDataBinderFactory) throws Exception {
        return validator.isValid(readRequest(nativeWebRequest));
    }

    private Object readRequest(final NativeWebRequest nativeWebRequest) throws IOException {
        return new ObjectMapper().readValue(getRequestBody(nativeWebRequest).getInputStream(), Object.class);
    }

    private HttpServletRequest getRequestBody(final NativeWebRequest nativeWebRequest) {
        return nativeWebRequest.getNativeRequest(HttpServletRequest.class);
    }
}
