$(function () {
    getJsonData();
});

function getJsonData() {
    $.getJSON("resources/json/bike.json", function (mydata) {
        $.ajax({
            url: "bike.do",
            method: "POST",
            data: {command: "getdata", mydata: JSON.stringify(mydata)},
            // stringify함수는 자바스크립트 언어 환경에서의 Json형식의 object를 함수의 파라미터에 넣으면 String 구조의 값으로 반환되는 함수
            // Json.parse : Json 형태의 문자열을 -> json 객체(javascript object)
            dataType: "json",
            success: function (msg) {
                var $tbody = $("tbody");
                var list = msg.result;
                for (var i = 0; i < list.length; i++) {
                    var $tr = $("<tr>");
                    $tr.append($("<td>").append(list[i].name));
                    $tr.append($("<td>").append(list[i].addr));
                    $tr.append($("<td>").append(list[i].latitude));
                    $tr.append($("<td>").append(list[i].longitude));
                    $tr.append($("<td>").append(list[i].bike_count));

                    $tbody.append($tr);
                }
            },
            error:function(request,status,error){
                alert("code:" + request.status + "<br>" + "message:" + request.responseText + "<br>" + "error:" + error);
            }
        });
    });
}