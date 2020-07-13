<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<link
      rel="stylesheet"
      href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
      integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
      crossorigin="anonymous"
    />
   <script src="https://code.jquery.com/jquery-3.5.1.min.js" integrity="sha256-9/aliU8dGd2tb6OSsuzixeV4y/faTqgFtohetphbbj0=" crossorigin="anonymous"></script>
<h4>가격을 변경할 책의 코드 번호와 가격을 입력하세요</h4>		
<form method='post' action=''>	
	<div class="form-row">	
		<div class="form-group col-md-6">  
		 	<input type="text" name="code" class="form-control form-control-lg" required="required" placeholder="코드" autofocus>
		</div> 
		<div class="form-group col-md-6">  
		 	<input type="text" name="price" class="form-control form-control-lg" required="required" placeholder="가격">
		</div> 
	</div>
	<div class="form-row">
  	<div class="form-group col-md-6">
		<button type="button" class="btn btn-primary">입력</button>
		<button type="reset" class="btn btn-secondary">취소</button>
	</div>
  </div>
</form>
<script>
$(function(){
	
	//수정하기
	// JSON.stringify() : 클라이언트 측에서 서버로 데이터를 보낼때 사용
	//                    자바스크립트 객체를 변환 시켜서 보내줌
	$(".btn-primary").click(function(){		
		//코드랑 가격  => 
		let formData = $("form").serialize();
		
		console.log(formData);
		
		$.ajax({
			url : '/modify',
			type : 'put',			
			data : formData,
			success:function(result){
				alert(result);
			},
			error:function(xhr,txtStatus,error){
				alert(xhr.responseText);
			}
		})
	})
	
})
</script>
