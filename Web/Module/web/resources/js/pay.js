function requestPay() { // 예약 번호

    var IMP = window.IMP; // 생략가능
    IMP.init('iamport');  // 가맹점 식별 코드

    IMP.request_pay({
        pg: 'html5_inicis', // 결제방식
        pay_method: 'card',	// 결제 수단
        merchant_uid: 'merchant_' + new Date().getTime(), // 고유 구매 ID
        name: '예약금',	// order 테이블에 들어갈 주문명 혹은 주문 번호
        amount: '10',	// 결제 금액
        buyer_email: '',	// 구매자 이메일
        buyer_name: '',	// 구매자 이름
        buyer_tel: '',	// 구매자 전화번호
        buyer_addr: '',	// 구매자 주소
        buyer_postcode: '',	// 구매자 우편번호
        m_redirect_url: ''	// 결제 완료 후 보낼 컨트롤러의 메소드명
    }, function (rsp) {
            if (rsp.success) { // 성공시
                var msg = '결제가 완료되었습니다.';
                msg += '고유ID : ' + rsp.imp_uid;
                msg += '상점 거래ID : ' + rsp.merchant_uid;
                msg += '결제 금액 : ' + rsp.paid_amount;
                msg += '카드 승인번호 : ' + rsp.apply_num;

            }
        })
}