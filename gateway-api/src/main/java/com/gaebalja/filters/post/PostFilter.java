package com.gaebalja.filters.post;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

/**
 * 라우팅 후에 실행되는 필터이다. response에 HTTP header를 추가하거나, response에 대한 응답속도, Status Code, 등 응답에 대한 statistics and metrics을 수집한다.
 * http://woowabros.github.io/r&d/2017/06/13/apigateway.html
 * 
 * @author kyuja79@danalssocio.com
 * @date 2017. 8. 25.
 *
 */
@Component
public class PostFilter extends ZuulFilter {

	private static Logger logger = LoggerFactory.getLogger(PostFilter.class);
	
    @Override
    public String filterType() {
        return "post";
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
	    HttpServletResponse response = RequestContext.getCurrentContext().getResponse();
    	HttpServletRequest request = RequestContext.getCurrentContext().getRequest();
    	logger.info("PostFilter: " + String.format("response's content type is %s", response.getStatus()));
    	logger.info("REQUEST :: < " + request.getScheme() + " " + request.getLocalAddr() + ":" + request.getLocalPort());
    	logger.info("REQUEST :: < " + request.getMethod() + " " + request.getRequestURI() + " " + request.getProtocol()); 
    	logger.info("RESPONSE:: > HTTP:" + response.getStatus());
    	return null;	
    }

}
