package com.ddominguezh.superhero.shared.domain.config.handler;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import com.ddominguezh.superhero.shared.domain.config.annotations.RequestAuthorization;

public class AuthorizationHandlerMethodArgumentResolver implements HandlerMethodArgumentResolver {

	private static Logger logger = Logger.getLogger(AuthorizationHandlerMethodArgumentResolver.class);
	private static String BEARER = "Bearer ";

	@Override
	public boolean supportsParameter(MethodParameter parameter) {
		logger.debug("RequestAuthorization: " + (parameter.getParameterAnnotation(RequestAuthorization.class) != null));
		return parameter.getParameterAnnotation(RequestAuthorization.class) != null;
	}

	@Override
	public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer,
			NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
		HttpServletRequest request = (HttpServletRequest) webRequest.getNativeRequest();
		
		logger.debug("RequestAuthorization: " + (parameter.getParameterAnnotation(RequestAuthorization.class) != null));
		return request.getHeader("Authorization");
	}

}