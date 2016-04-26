package example.nio;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class TimerServer {
	
	public static void main(String[] args) {
		int port = 8080;
		ServerSocket serverSocket = null;
		try {
			serverSocket = new ServerSocket(port);
			System.out.println("timeServer started ... ...");
			while(true){
				Socket socket = serverSocket.accept();
				System.out.println("timeServer accept client connection.....");
				new Thread(new TimeServerHandlerTask(socket)).start();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if(null != serverSocket){
				try {
					serverSocket.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
}
