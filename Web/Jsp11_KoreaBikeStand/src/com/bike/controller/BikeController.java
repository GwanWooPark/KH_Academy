package com.bike.controller;

import com.bike.dao.BikeDao;
import com.bike.dto.BikeDto;
import com.google.gson.*;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/bike.do")
public class BikeController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");

        BikeDao dao = new BikeDao();

        String command = request.getParameter("command");
        System.out.println("[" + command + "]");

        if (command.equals("view")) {
            response.sendRedirect("view.html");

        } else if (command.equals("getdata")) {
            if (dao.delete()) {
                System.out.println("삭제 성공");
            } else {
                System.out.println("삭제 실패");
            }

            String data = request.getParameter("mydata");
            /*
               JsonElement : JsonObject, JsonArray, JsonPrimitive, JsonNull -> Json요소
               JsonObject : name-value 쌍으로 이루어진 객체 -> Json 객체 { String : JsonElement }
             */

            JsonElement element = JsonParser.parseString(data);   // json형식인 문자열(json data)을 파싱하여 JsonElement 형식으로 변환
            JsonObject jsonData = element.getAsJsonObject();      // 변환된 JsonElement를 JsonObject로 변환
            // {"fields": [{},{}]
            JsonElement records = jsonData.get("records");       // json파일의 records(key)를 가지고온다
            JsonArray recordsArray = records.getAsJsonArray();   // records를 JsonArray형식으로 변환

            List<BikeDto> list = new ArrayList<BikeDto>();
            JsonArray resultArray = new JsonArray();            // 결과를 저장할 JsonArray 생성

            for (int i = 0; i < recordsArray.size(); i++) {     // 레코드 사이즈만큼
                String name = recordsArray.get(i).getAsJsonObject().get("자전거대여소명").getAsString(); // 레코드 배열[i] 오브젝트의 자전거 대여소명을 name에 저장
                String addr = null;

                if (recordsArray.get(i).getAsJsonObject().get("소재지도로명주소") != null) {              // 만약 "소재지도로명주소"가 널이 아니면
                    addr = recordsArray.get(i).getAsJsonObject().get("소재지도로명주소").getAsString();   // 소재지도로명주소로
                } else {                                                                             // 그렇지 않으면 "소재지지번주소로"
                    addr = recordsArray.get(i).getAsJsonObject().get("소재지지번주소").getAsString();
                }
                // key값을 가져오면 key값의 value를 가지고옴
                double latitude = recordsArray.get(i).getAsJsonObject().get("위도").getAsDouble();     // 변수에 위도 값
                double longitude = recordsArray.get(i).getAsJsonObject().get("경도").getAsDouble();    // 변수에 경도 값
                int bike_count = recordsArray.get(i).getAsJsonObject().get("자전거보유대수").getAsInt();  // 변수에 자전거 보유 대수 값

                BikeDto dto = new BikeDto(name, addr, latitude, longitude, bike_count);
                list.add(dto);

                Gson gson = new Gson();  // json 구조를 띄는 직렬화된 데이터를 JAVA객체로 역직렬화, 직렬화 해주는 자바 라이브러리
                String jsonString = gson.toJson(dto);   // 자바 객체를 Json 표현식으로 변경해준다. {"key" : "value"}
                resultArray.add(JsonParser.parseString(jsonString));    // json표현식으로 변경된 data를 JasonElement 형식으로 바꾸어서 resultArray에 담는다.
            }

            if (dao.insert(list)) {
                System.out.println("저장 성공");
            } else {
                System.out.println("저장 실패");
            }
            JsonObject result = new JsonObject();         // result라는 JsonObject를 만듦
            result.add("result", resultArray);   // JsonObject에 resultArray를 담는다.

            response.getWriter().append(result + "");    // 화면에 result 출력
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
