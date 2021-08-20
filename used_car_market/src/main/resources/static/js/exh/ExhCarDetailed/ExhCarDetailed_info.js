var ExhCarDetailed = {};

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
        var brand = $("#brand").val();
        var series = $("#series").val();
        var model = $("#model").val();
        var maunfaturer = $("#maunfaturer").val();
        var level = $("#level").val();
        var engine = $("#engine").val();
        var gearbox = $("#gearbox").val();
        var size = $("#size").val();
        var structure = $("#structure").val();
        var emissionstandard = $("#emissionstandard").val();
        var displacement = $("#displacement").val();
        var fueltype = $("#fueltype").val();
        if (brand === '' || series === '' || model === '' || maunfaturer === '' || level === '' || engine === '' || gearbox === '' || size === '' || structure === '' || emissionstandard === '' || displacement === '' || fueltype === ''){
            alert("请见表格填写完整！");
        }else {
            $.ajax({
                url: $("#RootPath").val() + "/exhCarDetailed/add",     //请求地址
                type: "post",       //提交方式
                dataType: "json",   //
                async: false,       //异步
                data: {             //提交的数据
                    'brand':brand,
                    'series':series,
                    'model':model,
                    'maunfaturer':maunfaturer.trim(),
                    'level':level.trim(),
                    'engine':engine.trim(),
                    'gearbox':gearbox.trim(),
                    'size':size.trim(),
                    'structure':structure.trim(),
                    'emissionstandard':emissionstandard.trim(),
                    'displacement':displacement.trim(),
                    'fueltype':fueltype.trim(),
                },
                success:function (data) {    //成功返回
                    if (data){
                        $("#tip").text("添加成功~~~");
                        $("#tip").css('color','green');
                        setTimeout(function(){
                            $("#tip").text("");
                        },300);
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
    });

    /**
     * 添加车辆详细信息重置
     */
    $("#reset_add").click(function () {
        document.getElementById("series").options.length = 0;
        document.getElementById("model").options.length = 0;
    })
};


$(function () {
    ExhCarDetailed.initButton();
});