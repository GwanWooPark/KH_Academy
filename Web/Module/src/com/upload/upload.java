package com.upload;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;

import com.oreilly.servlet.Base64Decoder;

public class upload {
// cos.jar 사용
	public String base64toimg(String content, HttpServletRequest request) throws IOException {
		// base64 : Binary Data를 Text로 바꾸는 Encoding
		while(content.indexOf("<img src=\"data")>=0) { //base64 형식 이미지 가 있을 경우 실행
			String picture = "<img src=\"data"+content.split("<img src=\"data")[1].split(">")[0]+">"; //base64 이미지 부분만 추출
			System.out.println(picture);
			String filenamme= picture.split("data-filename=\"")[1].split("\"")[0]; //파일이름 만 추출
			System.out.println(filenamme);
			UUID id = UUID.randomUUID(); //바꿀 파일이름 생성(중복이나 수정시 일괄적으로 바뀌지 않게끔)
			String pictureAcc = "style="+picture.split("\" style=")[1].split("data-filename")[0]+">"; //base64 데이터 부분 제외한 나머지
			String data = picture.split(",")[1].split("\" style=")[0]; //데이터 부분만 추출
			String path = request.getSession().getServletContext().getRealPath("/"); //서버의 저장소 위치 찾기
			System.out.println("저장경로 : "+path);
			byte[] imageBytes = Base64Decoder.decodeToBytes(data);//base64형식을 이미지 바이트 형식으로 바꾸기
			BufferedImage bufimg = ImageIO.read(new ByteArrayInputStream(imageBytes)); //이미지 형식으로 바꾸기
			ImageIO.write(bufimg, filenamme.split("\\.")[1], new File(path+"resources/img/"+id.toString()+"."+filenamme.split("\\.")[1]));
			//파일작성(저장할 이미지, 파일 형식, 파일 위치(file 클래스))
			content = content.replace("<img src=\"data"+content.split("<img src=\"data")[1].split(">")[0]+">","<img src='/Base64Upload/resources/img/"+id.toString()+"."+filenamme.split("\\.")[1]+"'"+pictureAcc);
			//무한반복 안걸리게+경로에서 불러오게 바꿔주기
			
		}
		 
		return content; //이미지를 경로 값으로 바꿔서 다시 리턴~!
	}
	
}
