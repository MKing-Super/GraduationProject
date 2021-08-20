var CarDetailedMiddle = {};

CarDetailedMiddle.initButton = function () {
    $("#dict_add").click(function () {
        if(confirm('确定要添加吗？')===true){
            var brand = $("#brand").val();
            var series = $("#series").val();
            var model = $("#model").val();
            if (false){
                alert("请见表格填写完整！");
            }else {
                $.ajax({
                    url: $("#RootPath").val() + "/carDetailedMiddle/carDetailedMiddleAdd",     //请求地址
                    type: "post",       //提交方式
                    dataType: "json",   //
                    async: false,       //异步
                    data: {             //提交的数据
                        'brand':brand,
                        'series':series,
                        'model':model
                    },
                    success:function (data) {    //成功返回
                        if (data){
                            $("#tip").text("添加成功~~~");
                            $("#tip").css('color','green');
                            setTimeout(function(){
                                $("#tip").text("");
                            },300);
                        }else {
                            $("#tip").text("添加失败！！！");
                            $("#tip").css('color','red');
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
};

$(function () {
    CarDetailedMiddle.initButton();
});