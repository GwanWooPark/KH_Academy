const URL = "https://teachablemachine.withgoogle.com/models/lRmi_M1M1/";
// 데이터를 받아올 링크

let model, webcam, labelContainer, maxPredictions;
let graph1, graph2, graph3;

// 이미지 모델 불러오기 및 웹캠 설정
async function init() {
    const modelURL = URL + "model.json";
    const metadataURL = URL + "metadata.json";

    // 모델 및 메타 데이터 불러오기
    model = await tmImage.load(modelURL, metadataURL);
    // 모델이 예측할 데이터의 갯수
    maxPredictions = model.getTotalClasses();

    // 웹캠을 설정
    const flip = true; // 플립인지 아닌지
    webcam = new tmImage.Webcam(500, 400, flip); // width, height, flip
    await webcam.setup(); // 웹캠 접근(액세스) 요청
    await webcam.play(); // 웹캠 시작
    window.requestAnimationFrame(loop); // 루프를 돌면서 진행

    // 웹캠 컨테이너 안에 웹캠이 띄워질 컨테이너 생성(버튼이 눌리면 원래 있던 영역이 지워지고 생성됨)
    if (document.getElementById("webcam-container").hasChildNodes()) {
        document.getElementById("webcam-container").removeChild(document.getElementById("webcam-container").childNodes[0]);
    }
    document.getElementById("webcam-container").appendChild(webcam.canvas);
}

async function loop() {
    webcam.update(); // 웹캠 업데이트
    await predict();
    window.requestAnimationFrame(loop);
}
// 웹캠 실행 함수
async function predict() {
    // 이미지 혹은 웹캠에 보여지는 요소를 예측
    const prediction = await model.predict(webcam.canvas);
    $(".dog").text(prediction[0].className);
    $(".graph1").css({width : prediction[0].probability.toFixed(2) * 100 + '%', height : "30px"});
    $(".cat").text(prediction[1].className);
    $(".graph2").css({width : prediction[1].probability.toFixed(2) * 100 + '%', height : "30px"});
    $(".dinosaur").text(prediction[2].className);
    $(".graph3").css({width : prediction[2].probability.toFixed(2) * 100 + '%', height : "30px"});
}




async function initUpload() {
    const modelURL = URL + "model.json";
    const metadataURL = URL + "metadata.json";

    model = await
        tmImage.load(modelURL, metadataURL);
    maxPredictions = model.getTotalClasses();


    labelContainer = document.getElementById("label-container");
    for (let i = 0; i < maxPredictions; i++) { // and class labels
        labelContainer.appendChild(document.createElement("div"));
    }
}
// 사진 예측(업로드용)
async function predictUpload() {
    // predict can take in an image, video or canvas html element
    var image = document.getElementById("face-image");
    const prediction = await model.predict(image, false);
    $(".dog").text(prediction[0].className);
    $(".graph1").css({width : prediction[0].probability.toFixed(2) * 100 + '%', height : "30px"});
    //$(".graph1").text(prediction[0].probability.toFixed(2) * 100 + '%');
    $(".cat").text(prediction[1].className);
    $(".graph2").css({width : prediction[1].probability.toFixed(2) * 100 + '%', height : "30px"});
    // $(".graph2").text(prediction[1].probability.toFixed(2) * 100 + '%');
    $(".dinosaur").text(prediction[2].className);
    $(".graph3").css({width : prediction[2].probability.toFixed(2) * 100 + '%', height : "30px"});
}
function readURL(input) {
    if (input.files && input.files[0]) {

        var reader = new FileReader();
        reader.onload = function(e) {
            $('.image-upload-wrap').hide();
            $('.file-upload-image').attr('src', e.target.result);
            $('.file-upload-content').show();
            $('.image-title').html(input.files[0].name);
        };
        reader.readAsDataURL(input.files[0]);
    } else {
        removeUpload();
    }
}
function removeUpload() {
    $('.file-upload-input').replaceWith($('.file-upload-input').clone());
    $('.file-upload-content').hide();
    $('.image-upload-wrap').show();
}
$('.image-upload-wrap').bind('dragover', function () {
    $('.image-upload-wrap').addClass('image-dropping');
});
$('.image-upload-wrap').bind('dragleave', function () {
    $('.image-upload-wrap').removeClass('image-dropping');
});