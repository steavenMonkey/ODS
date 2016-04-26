package example.nio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Date;

public class TimeServerHandlerTask implements Runnable{
	
	private Socket socket;
	
	
	public TimeServerHandlerTask(Socket socket) {
		super();
		this.socket = socket;
	}


	@Override
	public void run() {
		
		BufferedReader reader = null;
		PrintWriter writer = null;
		
		try {
			reader = new BufferedReader(
						new InputStreamReader(
								this.socket.getInputStream()));
			writer = new PrintWriter(this.socket.getOutputStream(), true);
			
			String line = reader.readLine();
			if(null != line){
				if("query order".equals(line)){
					String currentTime = new Date().toString();
					writer.println(currentTime);
				}else{
					writer.println("error order");
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if(null != reader){
				try {
					reader.close();
				} catch (IOException e) {
				}
			}
			
			if(null != writer){
				writer.close();
			}
			
			if(null != socket){
				try {
					socket.close();
				} catch (IOException e) {
				}
			}
		}
				
		
	}

}
