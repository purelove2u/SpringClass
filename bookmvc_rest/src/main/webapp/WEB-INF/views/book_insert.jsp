<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<link
      rel="stylesheet"
      href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
      integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
      crossorigin="anonymous"
    />
<div class="container">
<form>	
  <div class="form-group">
    <label for="code">Code</label>
    <input type="text" class="form-control" name="code" placeholder="code" required="required" autofocus>    
  </div>
  <div class="form-group">
    <label for="title">Title</label>
    <input type="text" class="form-control" name="title" placeholder="title" required="required">
  </div>
  <div class="form-group">
    <label for="author">Author</label>
    <input type="text" class="form-control" name="writer" placeholder="author" required="required">
  </div>
  <div class="form-group">
    <label for="price">Price</label>
    <input type="number" class="form-control" name="price" placeholder="price" required="required">
  </div>
  <button type="button" class="btn btn-primary">입력</button>
  <button type="reset" class="btn btn-secondary">취소</button>	
</form>	
</div>
<script src="https://code.jquery.com/jquery-3.5.1.min.js" integrity="sha256-9/aliU8dGd2tb6OSsuzixeV4y/faTqgFtohetphbbj0=" crossorigin="anonymous"></script>
<script>
$(function(){
	$(".btn-primary").click(function(){
		//입력 버튼을 클릭하면 폼안의 데이터를 가져온 후
		let param = {
				code:$("input[name='code']").val(),
				title:$("input[name='title']").val(),
				writer:$("input[name='writer']").val(),
				price:$("input[name='price']").val(),
		};		
		
		//ajax를 이용해 서버로 전송한 후 결과 출력
		$.ajax({
			url : '/insert',
			type : 'post',
			data : JSON.stringify(param),
			contentType : "application/json",
			success:function(data){
				alert(data);
				$("input[name='code']").val("");
				$("input[name='title']").val("");
				$("input[name='writer']").val("");
				$("input[name='price']").val("");
				$("input[name='code']").focus();
			},
			error:function(xhr,txtStatus,error){
				alert(xhr.responseText);
			}
		})
	})
})
</script>





















