/**
 *  
 * RouteLocator은 url path에 대한 routing을 지정한다. 요청이 들어오면 url path로 어떻게 routing 할 것인가를 정의하고 있다.
 * ZuulHandlerMapping은 org.springframework.web.servlet.handler.AbstractUrlHandlerMapping을 상속받고, RouteLocator에 정의된 url path에 zuulController를 매핑한다. RouteLocator에 정의된 path의 요청이 들어오면 zuulController를 호출하게 된다. 
 * ZuulController은 org.springframework.web.servlet.mvc.ServletWrappingController를 상속받으며, ZuulServlet을 주입시킨다. 그래서 ZuulController로 들어온 모든 요청은 ZuulServlet으로 처리한다.
 * ZuulFilterInitializer는 filter Map에 정의된 filter를 FilterRegistry에 등록하고, FilterLoader로 로딩한다.
 * 
 * 
 * 
 * Spring Cloud Zuul은 @EnableZuulProxy와 @EnableZuulServer 두 종류의 annotation으로 Zuul을 구동시킨다. 
 * 두개는 완전히 다른 것이 아니고 @EnableZuulProxy가 @EnableZuulServer을 포함한다. 
 * @EnableZuulServer에서 PreDecorationFilter, RibbonRoutingFilter, SimpleHostRoutingFilter를 추가하면, @EnableZuulProxy가 되는 것이다.
 * 
 * http://cloud.spring.io/spring-cloud-netflix/spring-cloud-netflix.html
 * @author kyuja79@danalssocio.com
 * @date 2017. 6. 13.
 *
 */
package com.gaebalja;