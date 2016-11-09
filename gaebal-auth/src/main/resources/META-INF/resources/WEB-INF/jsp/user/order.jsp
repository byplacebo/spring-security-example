<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <title>계발자 주문 페이지</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="//cdnjs.cloudflare.com/ajax/libs/bootstrap-table/1.9.1/bootstrap-table.min.css">
    <script src="//cdnjs.cloudflare.com/ajax/libs/bootstrap-table/1.9.1/bootstrap-table.min.js"></script>
    <script src="//cdnjs.cloudflare.com/ajax/libs/bootstrap-table/1.9.1/locale/bootstrap-table-zh-CN.min.js"></script>
</head>
<body>

<div class="container">
    <h2>계발자 주문 페이지</h2>

    <p>계발자에서 치킨을 주문하고자 하시는 분은 하단에 주문 내역을 추가하여 주시기 바랍니다.</p>

    <div id="toolbar">
        <button id="button" class="btn btn-default">주문하기</button>
        <a href="/logout" class="btn btn-default">로그아웃</a>
    </div>
    <table id="table"
           data-toggle="table"
           data-toolbar="#toolbar"
           class="table table-striped"
           datasrc="./json/orders.json">
        <thead>
        <tr>
            <th data-field="datetime">주문일시</th>
            <th data-field="name">주문자</th>
            <th data-field="address">주소</th>
            <th data-field="cellphone">연락처</th>
            <th data-field="order">주문내용</th>
        </tr>
        </thead>
        <tbody>
        <div>
            <tr>
                <td>
                </td>
                <td>
                    <input type="text" id='name0' name='name0' placeholder='${user.name}' disabled value='${user.name}' class="form-control"/>
                </td>
                <td>
                    <input type="text" id='address0' name='address0' placeholder='${user.address}' disabled value='${user.address}' class="form-control"/>
                </td>
                <td>
                    <input type="text" id='cellphone0' name='cellphone0' placeholder='${user.cellphone}' disabled value='${user.cellphone}' class="form-control"/>
                </td>
                <td>
                    <input type="text" id='order0' name='order0' placeholder='Order' class="form-control"/>
                </td>
            </tr>
        </div>
        <c:forEach var="order" items="${orders}">
            <tr>
                <td>${order.datetime}</td>
                <td>${order.name}</td>
                <td>${order.address}</td>
                <td>${order.cellphone}</td>
                <td>${order.order}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

</div>
<script>
    var $table = $('#table'), $button = $('#button');
    $(function () {
        $button.click(function () {
            if ($('#name0').val() == "" || $('#address0').val() == "" || $('#cellphone0').val() == "" || $('#order0').val() == "") {
                return;
            }
            var d = new Date();
            $table.bootstrapTable('insertRow', {
                index: 1,
                row: {
                    datetime: d.getFullYear() + "-" + (d.getMonth() + 1) + "-" + d.getDate() + " " + d.getHours() + ":" + d.getMinutes() + ":" + d.getSeconds(),
                    name: '${user.name}',
                    address: '${user.address}',
                    cellphone: '${user.cellphone}',
                    order: $('#order0').val()
                }
            });
        });
    });
</script>
</body>
</html>
