<%--
  Created by IntelliJ IDEA.
  User: CS
  Date: 2019/7/1
  Time: 13:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
    <title>登录</title>
    <style>
        * {
            margin: 0;
            padding: 0;
        }

        html {
            height: 100%;
        }

        body {
            height: 100%;
            background: #fff url(resource/images/jump.png) 50% 50% no-repeat;
            background-size: cover;
        }

        .dowebok {
            position: absolute;
            left: 50%;
            top: 50%;
            width: 430px;
            height: 550px;
            margin: -300px 0 0 -215px;
            border: 1px solid #fff;
            border-radius: 20px;
            overflow: hidden;
        }

        .logo {
            width: 104px;
            height: 104px;
            margin: 50px auto 80px;
            background: url(resource/images/login.png) 0 0 no-repeat;
        }

        .form-item {
            position: relative;
            width: 360px;
            margin: 0 auto;
            padding-bottom: 30px;
        }

        .form-item input {
            width: 288px;
            height: 48px;
            padding-left: 70px;
            border: 1px solid #fff;
            border-radius: 25px;
            font-size: 18px;
            color: #fff;
            background-color: transparent;
            outline: none;
        }

        .form-item button {
            width: 360px;
            height: 50px;
            border: 0;
            border-radius: 25px;
            font-size: 18px;
            color: #1f6f4a;
            outline: none;
            cursor: pointer;
            background-color: #fff;
        }

        #username {
            background: url(resource/images/emil.png) 20px 14px no-repeat;
        }

        #password {
            background: url(resource/images/password.png) 23px 11px no-repeat;
        }

        .tip {
            display: none;
            position: absolute;
            left: 20px;
            top: 52px;
            font-size: 14px;
            color: #f50;
        }

        .reg-bar {
            width: 360px;
            margin: 20px auto 0;
            font-size: 14px;
            overflow: hidden;
        }

        .reg-bar a {
            color: #fff;
            text-decoration: none;
        }

        .reg-bar a:hover {
            text-decoration: underline;
        }

        .reg-bar .reg {
            float: left;
        }

        .reg-bar .forget {
            float: right;
        }

        .dowebok ::-webkit-input-placeholder {
            font-size: 18px;
            line-height: 1.4;
            color: #fff;
        }

        .dowebok :-moz-placeholder {
            font-size: 18px;
            line-height: 1.4;
            color: #fff;
        }

        .dowebok ::-moz-placeholder {
            font-size: 18px;
            line-height: 1.4;
            color: #fff;
        }

        .dowebok :-ms-input-placeholder {
            font-size: 18px;
            line-height: 1.4;
            color: #fff;
        }

        @media screen and (max-width: 500px) {
            * {
                box-sizing: border-box;
            }

            .dowebok {
                position: static;
                width: auto;
                height: auto;
                margin: 0 30px;
                border: 0;
                border-radius: 0;
            }

            .logo {
                margin: 50px auto;
            }

            .form-item {
                width: auto;
            }

            .form-item input, .form-item button, .reg-bar {
                width: 100%;
            }
        }

        .opacity1{
            opacity:1;
        }
        .clear {
            zoom: 1;
        }
    </style>
</head>
<body>

<div class="dowebok">
    <div class="logo"></div>
    <div class="form-item">
        <input id="username" type="text" autocomplete="off" placeholder="账号">
        <p class="tip"></p>
    </div>
    <div class="form-item">
        <input id="password" type="password" autocomplete="off" placeholder="登录密码">
        <%--<p class="tip">用户名或密码不正确</p>--%>
    </div>
    <div class="form-item">
        <button id="submit">登 录</button>
    </div>
    <div class="reg-bar">
        <a class="reg" href="javascript:void(0)">立即注册</a>
        <a class="forget" href="javascript:void(0)">忘记密码</a>
    </div>
</div>

<div id="dialog" title="注册" class="opacity1" hidden style="text-align: center;margin: 0 auto;width: 960px; border: 1px solid #d9d9d9">
    <form class="opacity1">
        <ul style="margin-top: 10px">
            <li>用户名：<input id="userNameText" type="text"></li>
            <li>密码：<input id="passWordText" type="text"></li>
            <li>手机：<input id="phoneNumText" type="text"></li>
            <li>邮箱：<input id="emailText" type="text"></li>
        </ul>
        <div style="display:inline ;font-size: 16px">
            <input id="dSure" style="margin-left: 10px;font-size: 16px;cursor: pointer;" type="button" value="确定">
            <input id="dClose" style="margin-left: 10px;font-size: 16px;cursor: pointer;" type="button" value="取消">
        </div>
    </form>
</div>

</body>
<script type="text/javascript" src="resource/js/tools/jquery-1.11.3.min.js"></script>
<script type="text/javascript" src="resource/js/tools/jquery-ui.min.js"></script>
<script type="text/javascript" src="resource/js/login.js"></script>
</html>
