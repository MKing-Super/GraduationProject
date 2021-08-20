var AccountManagement = {
    carId: ''
};

/**
 * 按钮
 */
AccountManagement.initButton = function () {
    /**
     * 手机号修改
     */
    $("#editphone").click(function () {
        $("#phone").val('');
    });

    /**
     * 密码修改
     */
    $("#editpassword").click(function () {
        $("#password").val('');
    });

    /**
     * 昵称修改
     */
    $("#editpetname").click(function () {
        $("#petName").val('');
    });

    /**
     * 修改提交
     */
    $("#edit").click(function () {
        //取值
        var sheetid = $("#sheetid").val();
        var username = $("#username").val();
        var phone = $("#phone").val();
        var password = $("#password").val();
        var petname = $("#petName").val();
        if ('' === username){
            alert('请填写用户姓名！')
        }else if ('' === phone){
            alert('请填写手机号！');
        }else if (checkPhone(phone) === false){
            alert("手机号码有误，请重填");
        }else if (checkPassword(password) === false){
            alert("密码格式有误，只能输入6-12个字母、数字以及英文符号");
        }else if ('' === password){
            alert('请填写密码！');
        }else if ('' == petname){
            alert('请填写昵称！')
        }else {
            $.ajax({
                url:$("#RootPath").val() + "/sysUser/accountManagement",
                type: 'post',
                dataType: 'json',
                data:{
                    'sheetid':sheetid,
                    'username':username,
                    'phone':phone,
                    'password':password,
                    'petname':petname,
                },
                success:function (msg) {
                    $("#tip").text("修改成功~~~");
                    $("#tip").css('color','green');
                    setTimeout(function(){
                        window.location.href = $('#RootPath').val() + "/sysUser/logout";
                    },1000);
                },
                error:function (msg) {
                    alert("返回数据错误！")
                }
            });
        }

    });
};

/**
 * 手机号码验证
 * @param data
 * @returns {boolean}
 */
function checkPhone(data){
    var phone = data;
    var tel = /^(13[0-9]|14[01456879]|15[0-35-9]|16[2567]|17[0-8]|18[0-9]|19[0-35-9])\d{8}$/;
    if(!(tel.test(phone))){
        // alert("手机号码有误，请重填");
        return false;
    }
    return true;
}

/**
 * 密码验证
 * @param data
 * @returns {boolean}
 */
function checkPassword(data){
    var password = data;
    var patrn=/^[a-zA-Z]{1}([a-zA-Z0-9]|[,._~!@#$%^&*]){5,11}$/;
    if (!patrn.exec(password)) {
        // alert("密码格式有误，只能输入6-12个字母、数字以及英文符号");
        return false
    }
    return true;
}



$(function () {
    AccountManagement.initButton();
});