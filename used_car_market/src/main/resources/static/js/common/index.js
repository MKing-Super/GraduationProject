index = {

};

/**
 * 初始化按钮
 */
index.initButton = function () {
    $("#codeGenerator").click(function () {
        var username = '';
        var password = '';
        username = prompt("请输入管理员密码：","");
        if (username === '0317'){
            window.location.href = $("#RootPath").val() + '/code/togenerator';
        }else {
            alert('密码输入错误！');
        }
    });

    $("#buyCar").click(function () {
        window.location.href = $("#RootPath").val() + '/exhCar/toExhCarView';
    });

    $("#carAdd").click(function () {
        window.location.href = $("#RootPath").val() + '/exhCar/toExhCarAdd';
    });
};

/**
 * 启动jQuery，初始化函数
 */
$(function () {
    index.initButton();
});