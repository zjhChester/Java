var stompClient = null;

function setConnected(connected) {
    $("#connect").prop("disabled", connected);
    $("#disconnect").prop("disabled", !connected);

    if (connected) {
        $("#conversation").show();
        $("#connectsuccess").html("连接成功");
        document.getElementById("connectsuccess").style.color = "green";
    }
    else {
        $("#conversation").hide();
        $("#connectsuccess").html("连接断开");
        document.getElementById("connectsuccess").style.color = "red";
    }
    $("#notice").html("");
}

function connect() {
    $("#meerror").html("");
    $("#youerror").html("");
    if($("#me").val() == ""){
        $("#meerror").html("*请输入发送者");
        $("#meerror").focus();
        return;
    }
    else if($("#you").val() == ""){
        $("#youerror").html("*请输入收信人");
        $("#youerror").focus();
        return;
    }
    $("#me").attr("disabled","disabled");
    $("#you").attr("disabled","disabled");
	var from = $("#me").val();
	var to = $("#you").val();
	var socket = new SockJS('/endpoint-websocket');
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function (frame) {
        setConnected(true);
        console.log('Connected: ' + frame);
        stompClient.subscribe('/getMessage/single/'+ from + to, function (result) {
        	showContent(result.body);
        });
    });
}

function disconnect() {
    $("#me").removeAttr("disabled");
    $("#you").removeAttr("disabled");
    if (stompClient !== null) {
        stompClient.disconnect();
    }
    setConnected(false);
    console.log("Disconnected");
}

function sendName() {
    if($("#content").val() == ""){
        $("#contenterror").html("*请输入需要发送的内容")
        $("#content").focus();
        return;
    }
    var toUser = document.getElementById("you").value;
    var fromUser = document.getElementById("me").value;
    var message = document.getElementById("content").value;
    stompClient.send("/sendMessage/single/chat", {}, JSON.stringify({
        'message': "<span style='padding: 3%;border-radius: 50px;width: 40px;height: 40px;background: darkslateblue;color: white;'>"+$("#me").val()+'</span>：'+$("#content").val(),
        'toUser': $("#you").val(),
        'fromUser': $("#me").val()
    }));
    $("#notice").append("<tr><td><p class='text-right' style='width: 100%;border: 3px solid #8efff5;border-radius: 10%;overflow: hidden;background: white;" +
        "color: black;font-size:17px;opacity: 0.8;padding: 3%;box-shadow: black 3px 3px 5px'>" + message +"：<span style='padding: 3%;border-radius: 50px;width: 40px;height: 40px;background: darkslateblue;color: white;'>"+fromUser+ "</span></p></td></tr>");
    if (window.XMLHttpRequest) {
        // IE7+, Firefox, Chrome, Opera, Safari 浏览器执行代码
        xmlhttp = new XMLHttpRequest();
    }
    else {
        // IE6, IE5 浏览器执行代码
        xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
    }
    xmlhttp.open("POST", "/chatMessage", false);
    xmlhttp.setRequestHeader('content-type','application/x-www-form-urlencoded');
    //正式发送请求
    xmlhttp.send('toUser='+toUser+'&fromUser='+fromUser+'&message='+message);
    $("#content").val("");

}

function showContent(body) {
    $("#notice").append("<tr><td><p class='text-left' style='border: 3px solid coral;border-radius: 10%;overflow: hidden;" +
        "color: black;font-size:17px;opacity: 0.8;padding: 3%;box-shadow: black 3px 3px 5px'>" + body + "</p></td></tr>");
}

$(function () {
    $("form").on('submit', function (e) {
        e.preventDefault();
    });
    $( "#connect" ).click(function() { connect(); });
    $( "#disconnect" ).click(function() {  disconnect(); });
    $( "#send" ).click(function() { sendName(); });
});

