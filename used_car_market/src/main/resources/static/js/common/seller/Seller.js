var Seller = {};

Seller.initButton = function () {

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
     * 模拟点击
     */
    $("#brand").click();
    $("#series").click();
};

$(function () {
    Seller.initButton();

});