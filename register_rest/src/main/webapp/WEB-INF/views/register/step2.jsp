<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>Insert title here</title>
    <!-- resources 앞에 / 를 붙일때는 context path가 없는 경우일 때 -->
    <link
      rel="stylesheet"
      href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
      integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
      crossorigin="anonymous"
    />
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.1/jquery.validate.js"></script>
<!-- validation 사용자 작성 코드 삽입-->
<script src="/resources/js/join.js"></script>   
<script>
$(function(){
	let gender = '${vo.gender}';    	
	if(gender === '남'){
		$("input:radio[name='gender'][value='남']").prop("checked",true);		
	}else if(gender === '여'){
		$("input:radio[name='gender'][value='여']").prop("checked",true);		
	}   		
})
</script> 
  </head>
  <body style="background-color:#F5F5F5;">
    <div class="container" style="margin-top:40px">
      <form>
        <div class="form-group row justify-content-center">
          <label for="userid" class="col-sm-2 col-form-label">아이디</label>
          <div class="col-sm-6">
            <input
              type="text"
              name="userid"
              id="userid"
              class="form-control"
              placeholder="아이디를 입력하세요"
              value="${vo.userid}"
            />
            <small id="userid" class="text-info"></small>
          </div>
        </div>
        <div class="form-group row justify-content-center">
          <label for="pass1" class="col-sm-2 col-form-label">비밀번호</label>
          <div class="col-sm-6">
            <input
              type="password"
              name="password"
              id="password"
              class="form-control"
              placeholder="비밀번호를 입력하세요"             
            />
            <small id="password" class="text-info"></small>
          </div>
        </div>
        <div class="form-group row justify-content-center">
          <label for="pass2" class="col-sm-2 col-form-label"
            >비밀번호 확인
          </label>
          <div class="col-sm-6">
            <input
              type="password"
              name="confirm_password"
              id="confirm_password"
              class="form-control"
              placeholder="비밀번호를 다시 입력하세요"              
            />
            <small id="confirm_password" class="text-info"></small>
          </div>
        </div>
        <div class="form-group row justify-content-center">
          <label for="name" class="col-sm-2 col-form-label">이름 </label>
          <div class="col-sm-6">
            <input
              type="text"
              name="name"
              id="name"
              class="form-control"
              placeholder="이름을 입력하세요"
              value="${vo.name}"
            />
            <small id="name" class="text-info"></small>
          </div>
        </div>
        <div class="form-group row justify-content-center">
          <label for="pass2" class="col-sm-2 col-form-label">성별 </label>
          <div class="col-sm-6">
            <div class="form-check form-check-inline">
              <input
                type="radio"
                id="gender"
                name="gender"
                value="남"
                class="form-check-input"
              />남
            </div>
            <div class="form-check form-check-inline">
              <input
                type="radio"
                name="gender"
                value="여"
                class="form-check-input"
              />여
            </div>
            <small id="gender" class="text-info"></small>
          </div>
        </div>
        <div class="form-group row justify-content-center">
          <label for="email" class="col-sm-2 col-form-label">이메일</label>
          <div class="col-sm-6">
            <input
              type="email"
              name="email"
              id="email"
              class="form-control"
              placeholder="example@gmail.com"
              value="${vo.email}"
            />
            <small id="email" class="text-info"></small>
          </div>
        </div>
        <div class="form-group text-center">
          <button type="button" class="btn btn-primary">입력</button>
          <button type="reset" class="btn btn-secondary">취소</button>
        </div>
      </form>
    </div>
<script>
$(function(){
	$(".btn-primary").click(function(){
		
		let userid= $("#userid").val();
		let password= $("#password").val();
		let confirm_password= $("#confirm_password").val();
		let name= $("#name").val();
		let gender= $("input[type=radio]:checked").val();
		let email= $("#email").val();		
		
		let param = {
			userid : userid,
			password : password,
			confirm_password : confirm_password,
			name : name,
			gender : gender,
			email : email
		};
				
		// 폼안의 데이터를 json 형태로 서버로 보내기
		// 입력 후 결과를 받아 출력하기
		$.ajax({
			url : 'insert',
			type : 'post',
			contentType : 'application/json',
			data : JSON.stringify(param),
			success:function(data){
				alert(data);
			},
			error:function(xhr,txtStatus,error){
				alert(xhr.responseText);
			}
		})
	})
/* $(".btn-primary").click(function(){						
		// 폼안의 데이터를 서버로 보내기
		// 입력 후 결과를 받아 출력하기
		$.ajax({
			url : 'insert',
			type : 'post',			
			data : $("form").serialize(),
			success:function(data){
				alert(data);
			},
			error:function(xhr,txtStatus,error){
				alert(xhr.responseText);
			}
		})
	}) */
})

</script>
  </body>
</html>










