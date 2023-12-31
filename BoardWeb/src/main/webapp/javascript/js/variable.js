 //var: 함수레벨  vs  let, const : block 레벨
 var name = 'Hwang';
 function myfunc(){
     var name = 'Hong';
     // name = 'Hong'
     console.log(name);
     console.log(this);
 }
 myfunc();
 console.log(name);


 let age=20;
 function myfunc2(){
     let age = 22;
     console.log(age);
 }
 // myfunc2();
 console.log(age);
 let obj = { id:'Hong', age:20, show: function(){ console.log(this)} };

 obj.show();
 
 document.body.addEventListener('click', function(){
     console.log(this);
 });
     
 // console.log(window);

 // this
 //1. 전역영역 : window 겍체
 //2. 함수: window 객체
 //3. 객체: object
 //4. 이벤트: 
 console.log(this);
 

 // let show = 'Hello';
 // function show(){
 //     console.log('show');
 // }

 // () 실행  ( ()는 함수를 실행한다는 의미다)
 let show = function(){
     console.log('show');
     // return undefined;
     return '반환값';
 }

 console.log(show());
 
 (function(){
     console.log('익명함수')
 })();


 // 함수명명 규칙
 function showMyName(){
     console.log('홍길동');
 }

 // 상수선언
 const height = 167.9;
 // height = 169; 상수는 값을 변경할수 없다

 const friend = {
     name: '홍길동',
     phone: '010-1111'
 }
 friend.phone = '010-2222'; //상수 friend의 속성의 값 변경은 오류 X

 // friend = {} 이렇게 써서 값을 재할당하면 오류나겠지~
 
