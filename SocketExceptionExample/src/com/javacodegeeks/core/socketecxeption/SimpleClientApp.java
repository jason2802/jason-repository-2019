package com.javacodegeeks.core.socketecxeption;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;


public class SimpleClientApp {

	public static void main(String[] args) {
		
		new Thread(new SimpleClient()).start();

	}
	
	static class SimpleClient implements Runnable {

		@Override
		public void run() {

			Socket socket = null;
			try {

				socket = new Socket("localhost", 3333);
				

				PrintWriter outWriter = new PrintWriter(socket.getOutputStream(), true);
				
				System.out.println("Wait");

				Thread.sleep(15000);
				
				//throw new Exception("Random exception");

				
				outWriter.println("Hello Mr. Server!");
				

			}catch (SocketException e) {
				e.printStackTrace();
			}catch (InterruptedException e) {
				e.printStackTrace();
			} catch (UnknownHostException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {

				try {
					if (socket != null)
						socket.close();
				} catch (IOException e) {

					e.printStackTrace();
				}
				
				
			}
		}

	}

}
