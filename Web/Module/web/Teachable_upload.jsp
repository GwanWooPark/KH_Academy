<%@ page contentType="text/html;charset=UTF-8"  %>
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
<div id="imgWrap">
    <div class="teachable_text">닮은 동물 찾기(F)<br>
        <p>Start 클릭 -> 사진 업로드 -> Predict</p>
    </div>
    <div class="teachable_button">
        <button type="button" class="startUpload" onclick="initUpload();">Start(사진업로드용)</button>
        <button type="button" class="predictUpload" onclick="predictUpload();">Predict(사진업로드용)</button>
    </div>

    <div class="file-upload">
        <button class="file-upload-btn" type="button" onclick="$('.file-upload-input').trigger( 'click' )">사진 업로드</button>
        <div class="image-upload-wrap">
            <input class="file-upload-input" type='file' onchange="readURL(this);" accept="image/*" />
            <div class="drag-text">
                <h3>DRAG AND DROP</h3>
            </div>
        </div>
        <div class="file-upload-content">
            <img class="file-upload-image" id="face-image" src="#" alt="your image" />
            <div class="image-title-wrap">
                <button type="button" onclick="removeUpload()" class="remove-image">
                    파일 지우기 - <span class="image-title">Uploaded Image</span>
                </button>
            </div>
        </div>
        <div id="label-container">
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
</body>
</html>
