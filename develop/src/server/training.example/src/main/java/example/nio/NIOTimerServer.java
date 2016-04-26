package example.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class NIOTimerServer implements Runnable{
	
	private Selector selector;
	private ServerSocketChannel serverSocketChannel;
	private volatile boolean stop;
	
	public void stop(){
		this.stop = true;
	}
	
	public NIOTimerServer(int port) {
		try {
			selector = Selector.open();
			serverSocketChannel = ServerSocketChannel.open();
			serverSocketChannel.configureBlocking(false);
			serverSocketChannel.socket().bind(new InetSocketAddress("localhost", 8080));
			serverSocketChannel.register(selector, 1024);
			System.out.println("NIOTimerServer is start in port:" + port);
			this.stop = false;
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}
	}

	@Override
	public void run() {
		while(!stop){
			try {
				selector.select(1000);
				Set<SelectionKey> selectedKeys = selector.selectedKeys();
				Iterator<SelectionKey> iter = selectedKeys.iterator();
				SelectionKey key = null;
				while(iter.hasNext()){
					key = iter.next();
					iter.remove();
					handleSelectionKey(key);
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		if(null != this.selector){
			try {
				selector.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	
	
	private void handleSelectionKey(SelectionKey key) throws IOException{
		if(key.isValid()){
			if(key.isAcceptable()){
				ServerSocketChannel ssc = (ServerSocketChannel) key.channel();
				SocketChannel sc = ssc.accept();
				sc.configureBlocking(false);
				sc.register(selector, SelectionKey.OP_READ);
			}
		}
	}
}
