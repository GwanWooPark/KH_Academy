//엘리먼트들에 대한 데이터를 테이블 형식으로 화면에 표현하기

function makeTable(elem){														// elem안에 ROW 태그들 들어와 있음.
	$table = $("<table border=1>");												// 변수 생략 가능. var 생략 시 window객체 것이 됨. 자바 스크립트 전체에서 사용 가능.
	
	//컬럼 정의하기
	for (var i = 0; i < 1; i++) {
		$tr = $("<tr>");														// tr객체 만듦.
		for (var j = 0; j < elem.eq(0).children().length; j++) {				// 0번지 row의 자식(5개) 갯수만큼 반복
			$td = $("<td>").append(elem.eq(0).children().eq(j).prop("tagName"));// <tr><td>tagName</td> --- n개</tr> , append 자식요소 안에 제일뒤에다가 추가
			$tr.append($td);
		}
		$table.append($tr);
	}
	
	//데이터 넣기
	for (var i = 0; i < elem.length; i++) {
		$tr = $("<tr>");
		for (var j = 0; j < elem.eq(i).children().length; j++) {
			$td = $("<td>").append(elem.eq(i).children().eq(j).text());
			$tr.append($td);
		}
		$table.append($tr);
	}
	
	//만들어진 테이블 반환
	return $table;
}



