$(function() {
	//登录
	$("#login").click(login);
});


function login() {
			$("#user_text").html("");
			$("#pwd_text").html("");
			 
			var name = $("#count").val().trim();
			var password = $("#password").val().trim();
// 			alert(name);
// 			console.log("控制台信息");
		var mark = true;
		if (name == "") {
			mark = false;
			$("#user_text").html("用户名不能为空");
		}
		if (password == "") {
			mark = false;
			$("#pwd_text").html("密码不能为空");
		}
		
		//发送Ajax
		if (mark) {
			$.ajax({
				url:"user/login.do",
				type:"post",
				data:{"name":name,"password":password},
				dataType:"json",
				success:function(result) {
					if(result.stat == 3) {//
						//获取返回的用户ID,存入Cookie
						var userId = result.data;
						addCookie("userId",userId,2);
						alert(result.message);
						window.location.href="edit.html";
					} else if (result.stat == 2) {
						$("#pwd_text").html(result.message);
					} else if(result.stat == 1) {
						$("#user_text").html(result.message);
					}
				},
				error:function() {
					alert("登录异常");
				}
			});
		};
	};