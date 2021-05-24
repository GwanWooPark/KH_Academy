<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script type="text/javascript" src="https://cdn.jsdelivr.net/npm/@tensorflow/tfjs@1.3.1/dist/tf.min.js"></script>
    <script type="text/javascript" src="https://cdn.jsdelivr.net/npm/@teachablemachine/image@0.8/dist/teachablemachine-image.min.js"></script>
    <script class="jsbin" src="https://ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js"></script>
    <script type="text/javascript" src="resources/js/Teachable.js"></script>
    <link rel="stylesheet" href="resources/css/Teachable.css">
</head>
<body>
<div class="header_wrap">
    <div class="webHeader">
        나와 닮은 동물 찾기
    </div>
</div>
<div id="webcamWrap">
    <div id="webCam">
        <div id="webcam-container"></div>
        <div>
            <div class="species_info">
                <div class="dog div_common"></div>
                <div class="graphWrap">
                    <div class="graph1 div_common" style=""></div>
                </div>
            </div>
            <div class="species_info">
                <div class="cat div_common"></div>
                <div class="graphWrap">
                    <div class="graph2 div_common" style=""></div>
                </div>
            </div>
            <div class="species_info">
                <div class="dinosaur div_common"></div>
                <div class="graphWrap">
                    <div class="graph3 div_common" style=""></div>
                </div>
            </div>
        </div>
    </div>
</div>
<div class="findBtnWrap">
    <button type="button" class="startWebcam" onclick="init()">찾기</button>
</div>
</body>
</html>
