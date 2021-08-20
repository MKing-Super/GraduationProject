var ExhCarDetailed = {
    carId: ''
};

ExhCarDetailed.initButton = function () {
    /**
     * 点击品牌下拉框，生成相应的系列下拉框信息
     */
    $("#brand").click(function () {
        var brand = $("#brand").val();
        var series = $("#series").val();
        var model = $("#model").val();
        if (false){
            alert("请见表格填写完整！");
        }else {
            $.ajax({
                url: $("#RootPath").val() + "/seller/getCarSeries",     //请求地址
                type: "post",       //提交方式
                dataType: "json",   //
                async: false,       //异步
                data: {             //提交的数据
                    'brand':brand,
                    'series':series,
                    'model':model
                },
                success:function (data) {    //成功返回
                    var str = '';
                    for (var i = 0 ; i < data.length ; i++){
                        str += "<option value='"+data[i].sheetid+"'>"+data[i].dicttypename+"</option>"
                    }
                    $("#series").html(str);
                },
                error:function () {         //失败返回
                    alert("数据返回失败");
                }
            });
        }
    });

    /**
     * 点击系列下拉框，生成车型下拉框信息
     */
    $("#series").click(function () {
        var brand = $("#brand").val();
        var series = $("#series").val();
        var model = $("#model").val();
        if (false){
            alert("请见表格填写完整！");
        }else {
            $.ajax({
                url: $("#RootPath").val() + "/seller/getCarModel",     //请求地址
                type: "post",       //提交方式
                dataType: "json",   //
                async: false,       //异步
                data: {             //提交的数据
                    'brand':brand,
                    'series':series,
                    'model':model
                },
                success:function (data) {    //成功返回
                    var str = '';
                    for (var i = 0 ; i < data.length ; i++){
                        str += "<option value='"+data[i].sheetid+"'>"+data[i].dicttypename+"</option>"
                    }
                    $("#model").html(str);
                },
                error:function () {         //失败返回
                    alert("数据返回失败");
                }
            });
        }
    });

    /**
     * 新增提交
     */
    $("#sub_add").click(function () {
        //再提交卖车信息之前对用户是否登陆进行检验
        if(SYS_USER === '' || SYS_USER === null){
            alert("请先登陆用户！");
            window.location.href = $("#RootPath").val() + '/sysUser/toLogin';
            return false;
        }
        //确认车辆信息是否提交
        if (confirm('确定添加吗？') === true){
            var img = $("#img").val();
            var brand = $("#brand").val();
            var series = $("#series").val();
            var model = $("#model").val();
            var registrationtime = $("#registrationtime").val();
            var mileage = $("#mileage").val();
            var transferrecord = $("#transferrecord").val();
            var useproperties = $("#useproperties").val();
            var propertyright = $("#propertyright").val();
            var price = $("#price").val();
            if (brand === '' || series === '' || model === '' || registrationtime === '' ||
                mileage === '' || transferrecord === '' || useproperties === '' || propertyright === '' ||
                price === '' || img === ''){
                alert("请见表格填写完整！");
            }else {
                $.ajax({
                    url: $("#RootPath").val() + "/exhCar/exhCarAdd",     //请求地址
                    type: "post",       //提交方式
                    dataType: "json",   //
                    async: false,       //异步
                    data: {             //提交的数据
                        'brand':brand,
                        'series':series,
                        'model':model,
                        'registrationtime':registrationtime.trim(),
                        'mileage':mileage.trim(),
                        'transferrecord':transferrecord.trim(),
                        'useproperties':useproperties.trim(),
                        'propertyright':propertyright.trim(),
                        'price':price.trim(),
                        'userid':SYS_USER.sheetid
                    },
                    success:function (data) {    //成功返回
                        if (data.msg != ''){
                            ExhCarDetailed.carId = data.msg.sheetid;
                            //图片文件上传
                            $("#img").fileinput("upload");

                            $("#tip").text("添加成功~~~");
                            $("#tip").css('color','green');
                            setTimeout(function(){
                                $("#tip").text("");
                            },500);
                            window.location.href = $("#RootPath").val() + '/';
                        }else {
                            $("#tip").text("添加失败~~~");
                            $("#tip").css('color','red');
                            setTimeout(function(){
                                $("#tip").text("");
                            },300);
                        }
                    },
                    error:function () {         //失败返回
                        alert("数据返回失败");
                    }
                });
            }
            return true;
        }else {
            return false;
        }

    });

    /**
     * 添加车辆详细信息重置
     */
    $("#reset_add").click(function () {
        document.getElementById("series").options.length = 0;
        document.getElementById("model").options.length = 0;
    });

};

/**
 * 初始化上传
 */
ExhCarDetailed.initUpload = function(){
    /**
     * 点击上传按钮后上传
     */
    $("#img").fileinput({
        language: "zh", //设置语言
        uploadUrl: $('#RootPath').val() + "/exhCar/picutreUpload", //上传的地址
        showUpload: false,             // 显示上传按钮，选择后直接上传
        showRemove:true,               //显示移除按钮
        showPreview: true,              //显示预览
        showCaption: true,             //显示标题
        autoReplace: false,
        minFileCount: 0,            //最小上传数量0
        uploadAsync: true,          //上传异步
        maxFileCount: 10,                    // 最大上传为 10
        browseOnZoneClick: true,
        enctype: 'multipart/form-data',
        //overwriteInitial: false,        //不覆盖已上传图片
        browseClass: "btn btn-primary", //按钮样式
        uploadExtraData: function(previewId,index){
            //文件上传所需参数
            var car_id=ExhCarDetailed.carId;
            var data = {
                carId:car_id,
            };
            return data;
        },
        previewFileIcon: "<i class='glyphicon glyphicon-king'></i>",
        allowedFileExtensions: ["jpg", "png", "jpeg", "bmp"], //接收的文件后缀
        theme: "fa",      // 主题设置

        initialPreview: $('#RootPath').val() + '/images/noimage.jpg',        // 初始预览区域显示的图片
        initialPreviewAsData: true,
        initialPreviewConfig: [{ type: "image", fileType: "image" }],
        dropZoneEnabled: false,          // 禁止点击预览区域进行文件上传操作
        previewClass:"uploadPreview",
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
};


/**
 * 时间组件
 */
ExhCarDetailed.ininDate = function(){
    var localDate = new Date();
    var year = localDate.getFullYear();
    var month = localDate.getMonth();
    var date = localDate.getDate();
    var hours = localDate.getHours();
    var minutes = localDate.getMinutes();
    var second = localDate.getSeconds();
    if (month <= 10){
        month = month +1;
        month = '0' + month;
    }
    if (date < 10){
        date = '0' + date;
    }
    if (hours < 10){
        hours = '0' + hours;
    }
    if (minutes < 10){
        minutes = '0' + minutes;
    }
    if (second < 10){
        second = '0' + second;
    }
    var yyyyMMddTime = year+'-'+month+'-'+date;
    var yyyyMMddHHmmssTime = year+'-'+month+'-'+date+' '+hours+':'+minutes+':'+second;

    $.fn.datetimepicker.dates['zh-CN'] = {
        days: ["星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六", "星期日"],
        daysShort: ["周日", "周一", "周二", "周三", "周四", "周五", "周六", "周日"],
        daysMin:  ["日", "一", "二", "三", "四", "五", "六", "日"],
        months: ["1月", "2月", "3月", "4月", "5月", "6月", "7月", "8月", "9月", "10月", "11月", "12月"],
        monthsShort: ["1月", "2月", "3月", "4月", "5月", "6月", "7月", "8月", "9月", "10月", "11月", "12月"],
        today: "今日",
        suffix: [],
        meridiem: []
    };

    $(".form_datetime").datetimepicker({
        format:'yyyy-mm-dd',    //日期格式
        endDate: yyyyMMddTime,
        autoclose:true,         //点击之后自动关闭
        minView:2,              //最精准的时间选择为日期0-分 1-时 2-日 3-月
        weekStart:1,             //一周从哪一天开始
        language:'zh-CN',       //语言
        todayBtn:true,
        todayHighlight:true
    });
};


$(function () {
    ExhCarDetailed.initUpload();
    ExhCarDetailed.ininDate();
    ExhCarDetailed.initButton();
});