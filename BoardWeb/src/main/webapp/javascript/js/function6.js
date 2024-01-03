// function.js

//펼침연산자 ...args 
const args=[4,5,6]; 

function sum(num1=0, num2=0, ...args){
    let result = 0;
    result = num1 + num2;
    if(args.length > 0) {
        args.forEach(val => {
            result += val;
        })
    }
    return result;
}

console.log(sum(10,20,...args)); //(10, 20, 3, 4, 6) 이렇게 배열의 요소의 값을 순서에 맞쳐서 펼쳐서 쓰겠다는 의미

const ary1 = [10, 20];


const ary2 = ary1.concat(args);
console.log(ary2);

const ary3 = [...ary1, ...args];
console.log(ary3);

//펼침연산자...객체에도 사용가능
const obj1 = {name:"Hong", age:20};
const obj2 = {name:"Hwang", heignt: 170};

const obj3 = {...obj1, ...obj2}; //배열처럼 값을 펼치는게 아니라 속성에 값을 누적시킨다
console.log(obj3); // 결과 : {name: 'Hwang', age: 20, heignt: 170} 

//펼침연산자...파라메터로 쓰이는 경우 : 반드시 마지막에 쓰여야 한다!


// reduce() 메소드
let result = [4,5,6].reduce((acc, curItem, idx, ary) =>{
    console.log(acc, curItem, idx); //누산값, 현재값, 인덱스
    return curItem;
}, 0); //0은 초기값
console.log('결과값: ' + result); //마지막 값인 7을 돌려줌

let result2 = [4,5,6].reduce((acc, curItem, idx, ary) =>{
    console.log(acc, curItem, idx); //누산값, 현재값, 인덱스
    return acc + curItem; //이렇게 하면 합을 구할수있다
}, 0); //0은 초기값
console.log('결과값: ' + result2);


// map 메소드
result = [1,2,3,4].map((item, idx, ary) => {
    console.log(item, idx, ary);
    return item *2;
});
console.log('결과값: ', result);


// 변수의 스코프
var name = '어피치'; 
var name = '어피치'; // var 중복선언가능

function run(){
    if(true){
        var name = '라이언'; 
    }
    console.log(name);
    return name;
}
run(); //var name= '라이언' -> 라이언 출력, let name = '라이언' -> 어피치 출력
console.log(name);

var name = '어피치'; 
function run(){
    let name; 
    if(true){
        name = '라이언'; 
    }
    console.log(name);
    return name;
}
run(); //이렇게 하면 함수밖에서도 '라이언'으로 출력 가능!
console.log(name);

// 스코프 체인
var a = 1;
var b = 5;
function outerFunc(){
    var b; //undefined;  밑에서 var b=2; 로 선언했어도 이렇게 앞으로 끌어와서 undefined로 알아서 선언한다
    function innerFunc(){ //outerFunc 영역 안에서만 innerFunc 사용가능
        a=b;
    }
    console.log(a); // 1 출력
    a=3;
    b=4;
    innerFunc();
    console.log(a, b); // 4 4 출력
    var b=2;
    console.log(b); //2 출력
}
outerFunc();



const c = 10;

try{
    c=20;
}catch(error){
    console.log(error);
}finally{
    console.log(c);
}