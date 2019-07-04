$(function () {
    $('#submit').on('click', function () {
        login();
    });

    var thisDialog = $('#dialog').dialog({
        autoOpen: false,
        modal: true
    });

    $('.reg').on('click', function () {
        $("#dialog").show().dialog("open");
        $("#dSure").click(function () {
            signIn();
            thisDialog.dialog('destroy').dialog("close");
        });
        $("#dClose").click(function () {
            thisDialog.dialog('destroy').dialog("close");
        });
    })
});

function login() {
    $.ajax({
        url: '/login',
        data: {
            'userName': $('#username').val(),
            'passWord': $('#password').val()
        },
        type: 'POST',
        success: function (data) {
            if (data) {
                if (data.status == '1' || data.status == 1) {
                    window.location.href = '/index';
                } else {
                    $('.tip').show().html(data.message);
                }
            }
        }
    });
}

function signIn() {
    var user = {
        userName: $('#userNameText').val(),
        passWord: $('#passWordText').val(),
        phone: $('#phoneNumText').val(),
        email: $('#emailText').val()
    }
    $.ajax({
        url: '/signIn',
        data: {
            user: JSON.stringify(user)
        },
        type: 'POST',
        success: function (data) {
            if (data) {
                if (data.status == 1 || data.status == '1') {
                    console.log('成功');
                } else {
                    console.log("error")
                }
            } else {
                console.log("error")
            }
        }
    })

}
