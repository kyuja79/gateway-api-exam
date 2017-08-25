package com.gaebalja.filters.routing;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

/**
 * 요청에 대한 라우팅을 다루는 필터이다. Apache httpclient를 사용하여 정해진 Url로 보낼수 있고, Neflix Ribbon을 사용하여 동적으로 라우팅 할 수도 있다.
 * http://woowabros.github.io/r&d/2017/06/13/apigateway.html
 * 
 * @author kyuja79@danalssocio.com
 * @date 2017. 8. 25.
 *
 */
@Component
public class RoutingFilter extends ZuulFilter {

	private static Logger logger = LoggerFactory.getLogger(RoutingFilter.class);
	
	@Override
	public String filterType() {
		return "route";
	}
	
	@Override
	public int filterOrder() {
		return 1;
	}
	
	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public Object run() {
		RequestContext ctx = RequestContext.getCurrentContext();
		HttpServletRequest request = ctx.getRequest();
		logger.info("RouteFilter : " + String.format("%s request to %s", request.getMethod(), request.getRequestURL().toString()));
		return null;
	}

}
