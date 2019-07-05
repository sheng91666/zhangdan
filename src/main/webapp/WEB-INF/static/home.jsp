<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>home</title>
    <link rel="stylesheet" href="http://www.jq22.com/jquery/font-awesome.4.6.0.css">
    <link href="resource/css/foundation-datepicker.css" rel="stylesheet" type="text/css">
    <link href="resource/css/jquery-ui.min.css" rel="stylesheet" type="text/css">

    <%--<script src="resource/js/tools/require.js" data-main="resource/js/requireConfig"></script>--%>
    <script type="text/javascript" src="resource/js/tools/jquery-1.11.3.min.js"></script>
    <script type="text/javascript" src="resource/js/tools/jquery-ui.min.js"></script>
    <script type="text/javascript" src="resource/js/tools/foundation-datepicker.js"></script>
    <script type="text/javascript" src="resource/js/tools/foundation-datepicker.zh-CN.js"></script>
    <script type="text/javascript" src="resource/js/tools/arttemplate.js"></script>

    <script type="text/javascript" src="resource/js/home.js" charset="utf-8"></script>

    <style type="text/css">
        .tableRowWidth {
            width: 192px;
        }

        .cler {
            zoom: 1
        }

        .border {
            border-bottom: 1px solid #ccc;
        }

        table {
            border-collapse: collapse;
        }

        tr {
            background: white;
        }

        tr:nth-child(2n) {
            background: #ccc;
        }

        .leixing {
            color: #ca963b;
            border-bottom: 2px solid #ca963b;
        }
    </style>
</head>

<body>
<div style="text-align: center;margin: 0 auto;width: 960px; border: 1px solid #d9d9d9">

    <div>
        <div style="text-align: left;font-size: 23px">
            <span style="margin-left: 50px; cursor: pointer;" id="zhiChu" class="leixing" data-value="0">支出</span>
            <span style="margin-left: 50px; cursor: pointer;" id="shouRu" data-value="1">收入</span>
            <div style="margin-left: 100px; display:inline ;font-size: 16px">
                查询时间：
                <input id="startTime" style="width: 90px;display:inline;cursor: pointer;" readonly="readonly" value="">
                -
                <input id="endTime" style="width: 90px;display:inline;cursor: pointer;" readonly="readonly" value="">
                <input id="searchQuery" style="margin-left: 10px;font-size: 16px;cursor: pointer;" type="button" value="查询">
                <input id="addShouZhang" style="margin-left: 5px;font-size: 16px;cursor: pointer;" type="button" value="新增">
                <input id="delShouZhang" style="margin-left: 5px;font-size: 16px;cursor: pointer;" type="button" value="删除">
            </div>
        </div>
        <div class="border" style="margin-top: 20px">
            <table>
                <tr style="font-size: 20px;">
                    <th style="width: 50px">序号</th>
                    <th class="tableRowWidth">名称</th>
                    <th class="tableRowWidth">价格</th>
                    <th class="tableRowWidth">时间</th>
                    <th class="tableRowWidth">备注</th>
                </tr>
            </table>
        </div>
    </div>

    <div id="allZhangDanHtml">
        <script type="text/html" id="allZhangDanTpl">
            {{if list.length >0}}
            <table id="tableA">
                <tbody>
                {{each list as value index}}
                <tr style="font-size: 16px;">
                    <td style="width: 50px"><input type="checkbox" data-id='{{value.id}}'></td>
                    <td class="tableRowWidth">{{value.goodsName}}</td>
                    <td class="tableRowWidth">{{value.money}}</td>
                    <td class="tableRowWidth">{{value.createTime}}</td>
                    <td class="tableRowWidth">{{value.remark}}</td>
                </tr>
                {{/each}}
                </tbody>
            </table>
            {{else}}
            没有查询到数据！！
            {{/if}}
        </script>
    </div>

</div>

<div id="dialog" title="新增" style="text-align: center;margin: 0 auto;width: 960px; border: 1px solid #d9d9d9">
    <form>
        <div>类型：
            <label><input type="radio" name="leiFlag" value="0" checked>支出</label>
            <label><input type="radio" name="leiFlag" value="1">收入</label>
        </div>
        <ul>
            <li>名称：<input id="addName" type="text"></li>
            <li>价格：<input id="addPrice" type="text"></li>
            <li>时间：<input id="addTime" style="cursor: pointer;" readonly="readonly" value=""></li>
            <li>备注：<input id="addMark" type="text"></li>
        </ul>
        <div style="display:inline ;font-size: 16px">
            <input id="dSure" style="margin-left: 10px;font-size: 16px;cursor: pointer;" type="button" value="确定">
            <input id="dClose" style="margin-left: 10px;font-size: 16px;cursor: pointer;" type="button" value="取消">
        </div>
    </form>
</div>

</body>
</html>
