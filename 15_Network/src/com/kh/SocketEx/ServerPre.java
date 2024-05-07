package com.kh.SocketEx;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
//채팅 시작 주최자 = server
//port 2,3,4자리는 컴퓨터에서 약속으로 지정한 숫자
public class ServerPre {
	public static void main(String[] args) {
		
		try {
			ServerSocket s = new ServerSocket(12370);
			System.out.println("chat open");
			
			Socket b = s.accept();
			System.out.println("client success");
			
			
			BufferedReader in = new BufferedReader(new InputStreamReader(b.getInputStream()));
			PrintWriter out = new PrintWriter(b.getOutputStream(),true);
			
			String m;
			
			while((m = in.readLine()) != null) {
				System.out.println("send success: " + m);
				out.println("success: " + m);
			}
			
			b.close();
			s.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
