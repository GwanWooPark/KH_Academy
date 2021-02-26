package com.test02;

import java.io.*;
import java.net.*;

public class TestServer02 {
	public static void main(String[] args) {

		// TCP

		/*
		   소켓은 네트워크를 통해 시스템간에 통신 링크를 설정하는 수단입니다. java.net 패키지는 4 가지 종류의 소켓을 제공합니다.
		   ServerSocket은 TCP 서버 API이며 일반적으로 클라이언트 소켓의 연결을 허용.
		   소켓은 TCP 클라이언트 API이며 일반적으로 원격 호스트에 연결하는 데 사용.

		 */

		ServerSocket serverSocket = null; // 서버 생성 소켓
		Socket serviceSocket; // 접속될 클라이언트.
		PrintWriter out = null; // 출력 객체 (서버에서 클라이언트로)
		BufferedReader in = null; // Buffer를 이용해서 읽는다. 입력 객체 (클라이언트에서 서버로)
		
		try {
			serverSocket = new ServerSocket(9999); // 지정된 포트에 바인딩 된 서버를 열었다.
		} catch (IOException e) {
		}
		
		while(true){

			System.out.println("client를 기다립니다...");
			try {
				serviceSocket = serverSocket.accept(); // 이 소켓에 접
				System.out.println("client가 접속했습니다...");

				in = new BufferedReader(new InputStreamReader(serviceSocket.getInputStream())); // 서버 소켓이 클라이언트의 입력 스트림을 리턴합니다.
				                                                                                // ServerSocket에서 입력된 스트림을 InputStreamReader가 데이터를 하나씩 읽는다.
				                                                                                // 읽어온 데이터를 한번에 BufferedReader 저장한다.
				out = new PrintWriter(serviceSocket.getOutputStream(),true);           // get이 소켓의 출력 스트림을 리턴합니다.
																								// clisent로 메시지를 보낸다.
				                                                                                // autoFlush의 값을 true로 하면 println 메서드가 호출되거나 개행문자가 출력될때 자동으로 flush
				                                                                                // flush : 버퍼를 비워준다
				
				String inputLine;

				while((inputLine = in.readLine()) != null){                                     // 클라이언트로부터 라인단위로 입력받
					System.out.println("client가 보낸 메시지 : " + inputLine);                      // 콘솔창에 출력
					out.println(inputLine);                                                     // 클라이언트로 보냄
				}
				
				out.close();
				in.close();
				serviceSocket.close();
				serverSocket.close();
				
				System.out.println("client에 데이터 전송했습니다...");
				
			} catch (IOException e) {
			}
		}
	}
}
