package example.nio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class TimeClient implements Runnable{
	
	private int port;
	private Socket soket;
	
	
	
	public TimeClient(int port) {
		super();
		this.port = port;
	}

	

	public static void main(String[] args) {
		TimeClient client = new TimeClient(8080);
		new Thread(client).start();
	}



	@Override
	public void run() {
		BufferedReader in = null;
		PrintWriter out = null;
		BufferedReader console = null;
		try {
			this.soket = new Socket("localhost", port);
			in = new BufferedReader(
						new InputStreamReader(
								this.soket.getInputStream()));
			out = new PrintWriter(this.soket.getOutputStream(), true);
			
			console = new BufferedReader(
						new InputStreamReader(System.in));
//			while(!stop){
				String cmd = console.readLine();
				if(null != cmd){
					out.println(cmd);
					System.out.println("send cmd:" + cmd + " to timeServer success");
					String ret = in.readLine();
					System.out.println("get return data:" + ret);
				}
//			}
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if(out != null){
				out.close();
			}
			
			if(null != in){
				try {
					in.close();
				} catch (IOException e) {
				}
			}
			if(null != console){
				try {
					console.close();
				} catch (IOException e) {
				}
			}
			
			if(null != this.soket){
				try {
					soket.close();
				} catch (IOException e) {
				}
			}
			
			
			
		}
	}
}
