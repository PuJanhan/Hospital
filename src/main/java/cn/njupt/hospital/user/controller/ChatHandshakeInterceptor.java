package cn.njupt.hospital.user.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.HandshakeInterceptor;


import cn.njupt.hospital.user.entity.Users;

/**
 * websocket的链接建立是基于http握手协议，我们可以添加一个拦截器处理握手之前和握手之后过程
 * @author Administrator
 *
 */

@Component
public class ChatHandshakeInterceptor implements HandshakeInterceptor {
    
	/**
     * 握手之前，若返回false，则不建立链接
     */
	@Override
	public boolean beforeHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler,
			Map<String, Object> attributes) throws Exception {
		if (request instanceof ServletServerHttpRequest) {
			ServletServerHttpRequest servletRequest = (ServletServerHttpRequest) request;
			HttpSession session = servletRequest.getServletRequest().getSession(false);
			//如果用户已经登录，允许聊天
			if(session.getAttribute("session_user")!=null){
				//获取登录的用户
				Users user=(Users)session.getAttribute("session_user") ;
				//将用户放入socket处理器的会话(WebSocketSession)中
				attributes.put("session_user", user);
				System.out.println("Websocket:用户[ID:" + (user.getId() + ",Name:"+user.getSname()+"]要建立连接"));
			}else{
				//用户没有登录，拒绝聊天
				//握手失败！
				System.out.println("--------------握手已失败...");
				return false;
			}
		}
		System.out.println("--------------握手开始...");
		return true;
	}

	/**
     * 握手之后
     */
	@Override
	public void afterHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler,
			Exception exception) {
		System.out.println("--------------握手成功啦...");
	}


}
