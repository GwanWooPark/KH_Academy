package com.test02;

import java.io.*;
import java.net.Socket;

public class TestClient02 implements Runnable { // 쓰레드화 1이 접속해도 2도 접속가능하게 하려

	@Override
	public void run() {
		try{
			Socket clientSocket;
			PrintWriter out = null;
			BufferedReader in = null;
			BufferedReader stdin = null;
			
			System.out.println("server에 접속합니다...");
			clientSocket = new Socket("localhost",9999);  // 스트림 소켓을 만들고 명명된 호스트의 지정된 포트 번호에 연결 (접속)


			// 출력 (클라이언트에서 서버로)
			out = new PrintWriter(clientSocket.getOutputStream(),true);             // 서버로 입력을 하기 위

			// 입력 (서버에서 클라이언트로) out.println 에서 보내는 값
			in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));	 // 서버가 보낸 클라언트 소켓의 입력 스트림을 읽는다.

			// 콘솔에서 코드로 보낸 값
			stdin = new BufferedReader(new InputStreamReader(System.in));
			// System.in은 InputStream 타입이므로 BufferedReader의 생성자에 바로 들어갈 수 없으므로 InputStreamReader 클래스를 이용.

			String inputLine;
			while((inputLine = stdin.readLine()) != null){                                  // 입력이 끝날떄까지 받음
				out.println(inputLine);
				System.out.println("server로부터 다시 받은 메시지 :" + in.readLine());
			}
			
			out.close();
			in.close();
			stdin.close();
			clientSocket.close();
			
			System.out.println("소켓을 닫는다...");
			
		}catch(IOException e){
		}
	}
	
	public static void main(String[] args) throws Exception{
		Thread t1 = new Thread(new TestClient02());
		t1.start();
	}
}
