function loadNoteBooks(){
			//获得当前用户登录的user_id，此逻辑在登录功能实现时获得user_id的值，并存入cookie中
			$.ajax({url:"book/loadbooks.do",
					type:"post",
					data:{"userId":userId},
					dataType:"json",
					success:function(result) {
						if (result.stat == 0) {
							var books = result.data;							
							for (var i = 0; i < books.length; i++) {
								var bookName = books[i].cn_notebook_name;
								var bookId = books[i].cn_notebook_id;
								var lis = "<li class='online'>";
								 lis+= "	<a>";
								 lis+= "		<i class='fa fa-book' title='online' rel='tooltip-bottom'>";
								 lis+= "		</i>";
								 lis+=bookName;
								 lis+=		"</a>";
								 lis+= "</li>";
								 var $li = $(lis);
								 $li.data("bookId",bookId);
								 $("#uls").append($li)
							}
						}
					},
					error:function(){
						alert("加载用户笔记本列表失败");
					} 
				});
		}