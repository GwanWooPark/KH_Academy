package com.test03;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class TestServer03 {

	public static void main(String[] args) throws Exception {

		// 포트번호 있 : server 없 : client
		DatagramSocket ds = new DatagramSocket(8888); // 데이터 그램 소켓을 구성하고 로컬 호스트 시스템의 지정된 포트에 바인딩합니다.
		System.out.println("서버입니다.");
		
		byte[] buff = new byte[1024]; // 받은 데이터를 담을 공
		
		DatagramPacket recieveP = new DatagramPacket(buff, buff.length); // 받을 데이터의 형과 사이즈를 정함.
		
		ds.receive(recieveP); // 메시지를 받는다.
	
		System.out.println(new String(recieveP.getData())); // 받은 데이터를 출력한다.
		
		ds.close();
		ds.disconnect();
	}
}
