var login = {};

var codeStr = '';       //最终产生的验证码

/**
 * 登陆提交表单
 * @returns {boolean}
 */
function sub() {
    /**
     * 手机号验证
     */
    var phone = $('#phone').val();
    var tel = /^(13[0-9]|14[01456879]|15[0-35-9]|16[2567]|17[0-8]|18[0-9]|19[0-35-9])\d{8}$/;
    if(!(tel.test(phone)) && phone !== 'ROOT'){
        alert("手机号码有误，请重填");
        return false;
    }



    if (codeStr !== $("#pictureCode").val()) {
        $("#pictureCode").val('');
        alert('验证码填写错误，请重新填写！');
        return false;
    } else {
        document.forms["login"].action = $("#RootPath").val() + "/sysUser/login";
        document.forms["login"].method = "get";
        document.forms["login"].submit();
        return true;
    }
}

/**
 * 初始化按钮
 */
login.initButton = function(){
    /**
     * 手机号验证
     */
    $('#phone').blur(function () {
        var phone = $('#phone').val();
        var tel = /^(13[0-9]|14[01456879]|15[0-35-9]|16[2567]|17[0-8]|18[0-9]|19[0-35-9])\d{8}$/;
        if(!(tel.test(phone)) && phone !== 'ROOT'){
            alert("手机号码有误，请重填");
            return false;
        }
    })

};

/**
 * 启动jQuery，初始化函数
 */
$(function () {
    drawPic();
    login.initButton();
});


//**************************************************************************************
//*****                           生成图片验证码                              **********
//**************************************************************************************
/**
 * 生成一个随机数
 * @param min
 * @param max
 * @returns {number}
 */
function randomNum(min, max) {
    return Math.floor(Math.random() * (max - min) + min);
}

/**
 * 生成一个随机色
 * @param min
 * @param max
 * @returns {string}
 */
function randomColor(min, max) {
    var r = randomNum(min, max);
    var g = randomNum(min, max);
    var b = randomNum(min, max);
    return "rgb(" + r + "," + g + "," + b + ")";
}

// drawPic();
/**
 * 点击更换图片
 * @param e
 */
document.getElementById("changeImg").onclick = function (e) {
    e.preventDefault();
    drawPic();
    //弹出二维码
    //alert(codeStr)
};

/**
 * 生成验证码图
 */
function drawPic() {
    var canvas = document.getElementById("canvas");
    var width = canvas.width;
    var height = canvas.height;
    var ctx = canvas.getContext('2d');
    ctx.textBaseline = 'bottom';
    /**绘制背景色**/
    ctx.fillStyle = randomColor(180, 240); //颜色若太深可能导致看不清
    ctx.fillRect(0, 0, width, height);
    /**绘制文字**/
    var str = 'abcdefghijklmnopqrstuvwxyz123456789';      //可能会产生的文字
    codeStr = '';
    for (var i = 0; i < 4; i++) {
        var txt = str[randomNum(0, str.length)];
        codeStr += txt;
        ctx.fillStyle = randomColor(50, 160);  //随机生成字体颜色
        ctx.font = randomNum(30, 45) + 'px SimHei'; //随机生成字体大小
        var x = 10 + i * 25;
        var y = randomNum(25, 35);
        var deg = randomNum(-30, 30);
        //修改坐标原点和旋转角度
        ctx.translate(x, y);
        ctx.rotate(deg * Math.PI / 180);
        ctx.fillText(txt, 0, 0);
        //恢复坐标原点和旋转角度
        ctx.rotate(-deg * Math.PI / 180);
        ctx.translate(-x, -y);
    }
    // alert(codeStr)
    /**绘制干扰线**/
    for (var i = 0; i < 4; i++) {
        ctx.strokeStyle = randomColor(40, 180);
        ctx.beginPath();
        ctx.moveTo(randomNum(0, width), randomNum(0, height));
        ctx.lineTo(randomNum(0, width), randomNum(0, height));
        ctx.stroke();
    }
    /**绘制干扰点**/
    for (var i = 0; i < 100; i++) {
        ctx.fillStyle = randomColor(0, 255);
        ctx.beginPath();
        ctx.arc(randomNum(0, width), randomNum(0, height), 1, 0, 2 * Math.PI);
        ctx.fill();
    }
}

//**************************************************************************************
//**************************************************************************************
//**************************************************************************************