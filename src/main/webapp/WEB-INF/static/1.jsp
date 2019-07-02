<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>home</title>
    <script type="text/javascript" src="static/js/jquery-1.11.3.min.js"></script>
    <script type="text/javascript" src="static/js/arttemplate.js"></script>
    <script type="text/javascript" src="static/js/home.js" charset="utf-8"></script>

    <style type="text/css">
        .tableRowWidth{
            width: 17%
        }
    </style>
</head>

<body>
<div style="text-align: center;margin: 0 auto;width: 960px; border: 1px solid #d9d9d9">
<div>
    <div>支出</div>
    <div>收入</div>
    <table>
        <tr style="font-size: 20px;">
            <td></td>
            <td class="tableRowWidth">名称</td>
            <td class="tableRowWidth">价格</td>
            <td class="tableRowWidth">时间</td>
            <td class="tableRowWidth">备注</td>
            <td class="tableRowWidth">创建人</td>
        </tr>
    </table>
</div>
<div id="allZhangDanHtml">
    <script type="text/html" id="allZhangDanTpl">
        <table>
            <tbody>
            {{each list as value index}}
            <tr style="font-size: 16px;">
                <td><input type="checkbox"></td>
                <td class="tableRowWidth">{{value.goodsName}}</td>
                <td class="tableRowWidth">{{value.money}}</td>
                <td class="tableRowWidth">{{value.createTime}}</td>
                <td class="tableRowWidth">{{value.remark}}</td>
                <td class="tableRowWidth">{{value.createName}}</td>
            </tr>
            {{/each}}
            </tbody>
        </table>
    </script>
</div>

</div>
</body>
</html>
