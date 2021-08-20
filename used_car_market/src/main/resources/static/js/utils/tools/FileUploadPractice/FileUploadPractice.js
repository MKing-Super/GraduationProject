/**
 * 选择图片后立即上传
 */
$("#imgUpload").fileinput({
    language: "zh", //设置语言
    uploadUrl: $('#RootPath').val() + "/fileUpload/addImg", //上传的地址
    allowedFileExtensions: ["jpg", "png", "jpeg", "bmp"], //接收的文件后缀
    theme: "fa",      // 主题设置
    initialPreview: $('#RootPath').val() + '/images/noimage.jpg',        // 初始预览区域显示的图片
    initialPreviewAsData: true,
    initialPreviewConfig: [{ type: "image", fileType: "image" }],
    dropZoneEnabled: false,          // 禁止点击预览区域进行文件上传操作
    maxFileCount: 1,                    // 最大上传为 1
    showUpload: false,             // 不显示上传按钮，选择后直接上传
    previewClass:"uploadPreview",
}).on("change", function() {
    // 清除掉上次上传的图片
    $(".uploadPreview").find(".file-preview-frame:first").remove();
    $(".uploadPreview").find(".kv-zoom-cache:first").remove();
}).on("filebatchselected", function(e, files) {
    $(this).fileinput("upload");             // 文件选择完直接调用上传方法。
}).on("fileuploaded", function(e, data, previewiId, index) {       // 上传完成后的处理
    var form = data.form,
        files = data.files,
        extra = data.extra,
        response = data.response,        // 响应
        reader = data.reader;          // 文件对象
    if (response.flag) {
        let img = new Image();     // 这里上传的是图片，对图片处理获取图片的分辨率
        img.src = reader.result;
        if (img.complete) {
            $(this).attr("data-displayReso", img.width + "*" + img.height);
        } else {
            img.onload = function() {
                $(this).attr("data-displayReso", img.width + "*" + img.height);
            };
        }
    }
});

/**
 * 点击上传按钮后上传
 */
$("#img").fileinput({
    language: "zh", //设置语言
    uploadUrl: $('#RootPath').val() + "/fileUpload/add", //上传的地址
    showUpload: false,             // 显示上传按钮，选择后直接上传
    showRemove:true,               //显示移除按钮
    showPreview: true,              //显示预览
    showCaption: true,             //显示标题
    autoReplace: false,
    minFileCount: 0,            //最小上传数量1
    uploadAsync: true,          //上传异步
    maxFileCount: 3,                    // 最大上传为 3
    browseOnZoneClick: true,
    enctype: 'multipart/form-data',
    //overwriteInitial: false,        //不覆盖已上传图片
    browseClass: "btn btn-primary", //按钮样式
    uploadExtraData: function(previewId,index){
        //文件上传所需参数
        var busId=$("#busId").val();
        var data = {
            busId:busId,
        };
        return data;
    },
    previewFileIcon: "<i class='glyphicon glyphicon-king'></i>",
    allowedFileExtensions: ["jpg", "png", "jpeg", "bmp"], //接收的文件后缀
    theme: "fa",      // 主题设置
}).on("change", function() {
    // 清除掉上次上传的图片
    $(".uploadPreview").find(".file-preview-frame:first").remove();
    $(".uploadPreview").find(".kv-zoom-cache:first").remove();
}).on("fileuploaded", function(e, data, index) {       // 上传完成后的处理
    var form = data.form,
        files = data.files,
        extra = data.extra,
        response = data.response,        // 响应
        reader = data.reader;          // 文件对象
    if (response.flag) {
        let img = new Image();     // 这里上传的是图片，对图片处理获取图片的分辨率
        img.src = reader.result;
        if (img.complete) {
            $(this).attr("data-displayReso", img.width + "*" + img.height);
        } else {
            img.onload = function() {
                $(this).attr("data-displayReso", img.width + "*" + img.height);
            };
        }
    }
});
/**
 * 自定义按钮上传，注意：使用时，showUpload: false
 */
$("#upload").click(function () {
    $("#img").fileinput("upload");
});

