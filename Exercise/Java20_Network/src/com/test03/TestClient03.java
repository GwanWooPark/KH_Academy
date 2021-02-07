package com.test03;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.Arrays;

public class TestClient03 {

	// UDP

	public static void main(String[] args) throws Exception {
		
		DatagramSocket ds = new DatagramSocket(); // DatagramSocket은 UDP 끝점 API이며 데이터 그램 패킷을 보내고받는 데 사용됩니다.
		System.out.println("클라이언트 입니다.");
		
		byte[] buff = "연습입니다.".getBytes(); // byte배열 객체안에 byte시퀀로 인코딩해서 넣는다.
		
		DatagramPacket sendP = new DatagramPacket(buff, buff.length,InetAddress.getByName("localhost"),8888); // 보낼 데이터의 형과, 데이터의 길이, 이름, 주소를 설정해서 보낸다.
		
		ds.send(sendP); // 메시지를 보낸다.
		
		ds.close();
		ds.disconnect();
	}

}
