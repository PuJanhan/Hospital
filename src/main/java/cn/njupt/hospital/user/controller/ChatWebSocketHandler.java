package cn.njupt.hospital.user.controller;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.util.HtmlUtils;

import cn.njupt.hospital.user.entity.Message;
import cn.njupt.hospital.user.entity.Users;
import cn.njupt.hospital.utils.GsonUtils;


@Component("chatWebSocketHandler")
public class ChatWebSocketHandler implements WebSocketHandler {
	
	//在线用户的SOCKETsession(存储了所有的用户通道)
	public static final HashMap<String,WebSocketSession> USER_SOCKETSESSION_MAP;
    
	
	//存储所有的在线用户
	static{
		USER_SOCKETSESSION_MAP = new HashMap<String,WebSocketSession>();
	}
	
	/**
     * websocket链接关闭的回调
     * 连接关闭后：一般是回收资源等
     */
	@Override
	public void afterConnectionClosed(WebSocketSession webSocketSession, CloseStatus arg1) throws Exception {
		
		

	}

	@Override
	public void afterConnectionEstablished(WebSocketSession webSocketSession) throws Exception {
		 
		//将当前的连接用户放入MAP，key是用户编号
		Users user = (Users) webSocketSession.getAttributes().get("session_user");
		USER_SOCKETSESSION_MAP.put(user.getId(),webSocketSession);
		
		//群发消息告诉大家
		Message msg = new Message();
		msg.setText("风骚的【" + user.getSname()+"】踩着轻盈的步伐来啦，大家欢迎！");
		msg.setDate(new Date());
		
		//获取所有在线的WebSocketSession 对象集合
		Set<Entry<String,WebSocketSession>> entrySet = USER_SOCKETSESSION_MAP.entrySet();
		
		//将最新的所有在线人列表放入消息对象的list集合中，用于页面显示
		for(Entry<String,WebSocketSession>entry:entrySet){
			msg.getUserList().add((Users) entry.getValue().getAttributes().get("session_user"));
		}
		
		//将消息转换为json
		
		TextMessage message  = new TextMessage(GsonUtils.toJson(msg));
		
		
		sendMessageToAll(message);

	}

	private void sendMessageToAll(TextMessage message) {
		//对用户发送的消息内容进行转义
		
				//获取到所有在线用户的SocketSession对象
				Set<Entry<String, WebSocketSession>> entrySet = USER_SOCKETSESSION_MAP.entrySet();
				for (Entry<String, WebSocketSession> entry : entrySet) {
					//某用户的WebSocketSession
					final WebSocketSession webSocketSession = entry.getValue();
					//判断连接是否仍然打开的
					if(webSocketSession.isOpen()){
						//开启多线程发送消息（效率高）
						new Thread(new Runnable() {
							public void run() {
								try {
									if (webSocketSession.isOpen()) {
										webSocketSession.sendMessage(message);
									}
								} catch (IOException e) {
									e.printStackTrace();
								}
							}

						}).start();
						
					}
				}
			}
		
	


	@Override
	/**
	 * 客户端发送服务器消息时的处理函数，在这里收到消息后可以分发消息
	 * 
	 * 
	 */
	//处理消息：当一个新的Websocket到达的时候，会调用（在客户端通过Websocket API发送的消息会经过这里，然后进行相应的处理）
	public void handleMessage(WebSocketSession webSocketSession, WebSocketMessage<?> message) throws Exception {
		if(message.getPayloadLength()==0){
			return;
		}
		//反序列化服务端接收到的json 消息
		Message msg = GsonUtils.fromJson(message.getPayload().toString(), Message.class);
        msg.setDate(new Date());
        //处理HTML 的字符，转义；
        String text = msg.getText();
        
        //转换为HTML转义字符表示
        String htmlEscapeText = HtmlUtils.htmlEscape(text);
		msg.setText(htmlEscapeText);
		System.out.println("消息（可存数据库作为历史记录）:"+message.getPayload().toString());
		
		//判断群发还是单发
		if(msg.getTo()==null || msg.getTo().equals("-1")){
			//群发
		}else{
			//单发
			sendMessageToUser(msg.getTo(), new TextMessage(GsonUtils.toJson(msg)));
		}
	} 
    
	/**
     * 消息传输过程中出现的异常处理函数
     * 处理传输错误：处理由底层WebSocket消息传输过程中发生的异常
     */
	@Override
	public void handleTransportError(WebSocketSession arg0, Throwable arg1) throws Exception {
		// TODO Auto-generated method stub

	}
    
	
	@Override
	public boolean supportsPartialMessages() {
		// TODO Auto-generated method stub
		return false;
	}
	/**
	 * 给某个人发消息
	 * 
	 * @param message
	 * @throws Exception 
	 */
    private void sendMessageToUser(String id,TextMessage message) throws Exception{
         WebSocketSession  webSocketSession  = USER_SOCKETSESSION_MAP.get("id");
         if(webSocketSession!=null && webSocketSession.isOpen()){
        	 //发送消息
        	 webSocketSession.sendMessage(message);
         }
    }
}
