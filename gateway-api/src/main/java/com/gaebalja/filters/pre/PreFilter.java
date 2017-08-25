package com.gaebalja.filters.pre;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

/**
 * 라우팅전에 실행되며 필터이다. 주로 logging, 인증등이 pre Filter에서 이루어 진다.
 * http://woowabros.github.io/r&d/2017/06/13/apigateway.html
 * @author kyuja79@danalssocio.com
 * @date 2017. 8. 25.
 *
 */
@Component
public class PreFilter extends ZuulFilter {
	
	private static Logger logger = LoggerFactory.getLogger(PreFilter.class);
		
	@Override
	public String filterType() {
		return "pre";
	}

	@Override
	public int filterOrder() {
		return 0;
	}	
	
	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        logger.info("PreFilter : " + String.format("%s request to %s", request.getMethod(), request.getRequestURL().toString()));
        return null;
	}
	

}
