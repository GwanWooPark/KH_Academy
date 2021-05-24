	var Chat = (function(){
		
		// 사용자 이름 (공백 처리)
	    var userName = " ";
	 
	    function init() {

	        $(document).on('keydown', 'div.input textarea', function(e){
				// keyCode 13 : enter
				// shift키를 같이 누르면 전송되지 않고 줄바꿈
	        	if(e.keyCode === 13 && !e.shiftKey) {
					// 태그 이벤트가 있을 경우 해당 태그 속성이 중단됨 - 이벤트 전파 막음
	        		e.preventDefault();
	                var message = $(this).val();

	                // 메세지 보내는 함수 호출
	                sendMessage(message);

	                clearTextarea();
	            }
	        });
	    }
	 
	    // 메세지 송수신
	    function sendMessage(message) {
	        var data = {
	            "senderName" : " ",
	            "message" : message
	        };
	        
	        // 보낸/받은 메세지 구분해서 화면에 띄우기
	        request(data);
	        
	        $.ajax({
	        	type:"POST",
	        	url: "chatbot.do?&message="+encodeURIComponent(message),
	        	dataType: "json",
	        	success : function(data){
	        		if (data.message!=="감사합니다. 대화를 종료합니다."){
	        			
	        			response(data);
	        		} else {
	        			// 대화 종료 메세지가 뜨면 창 종료
	        			response(data);
	        			setTimeout(function() {
	        				window.close();
	        			}, 800);
	        		}
	        	}
	        	,
	        	error : function(){
	        		alert("error");
	        	}
	        
	        }); 
	    }
	    
	    function request(data) {
	    	// 보낸 메세지는 화면 오른쪽에
	      	var LR = "right";
	        appendMessageTag("right", data.senderName, data.message);
	    }
		
		function response(data) {
			// 받은 메세지는 화면 왼쪽에
			var LR = "left";
			appendMessageTag("left", data.senderName, data.message);
		}
		
	    function appendMessageTag(LR_className, senderName, message) {
			var chatLi = $('div.chat.form ul li').clone();
			// 태그안의 요소들을 복제.

			chatLi.addClass(LR_className);
			chatLi.find('.sender span').text(senderName);
			chatLi.find('.message span').text(message);


			$('div.chat:not(.form) ul').append(chatLi);

	        // 스크롤바 화면 아래에 고정
			//$("html, body").animate({ scrollTop: $(document).height() }, 500);
	    }
	 
	 
	    function clearTextarea() {
	        $('div.input textarea').val('');
	    }
	 
	    return {
	        'init': init
	    };
	})();

	// init 함수 시작
	$(function(){
	    Chat.init();
	});