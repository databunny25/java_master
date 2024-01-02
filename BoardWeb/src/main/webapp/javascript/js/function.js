// function.js
// 함수 선언식

function sum(num1 = 0, num2 = 0) {
    let result = 0;
    result = num1+num2; //만약 num1과 num2의 초기값을 정의 안해주면 undefined 두개를 더해서 NaN 돌려줌
    // console.log(result);
    console.log(arguments); //매개값을 처리해주는 arguments라는 객체가 있다!!!
    if(arguments.length >2){
        for(let arg=2; arg<arguments.length;arg++){
            result += arg;
        }
    }
    return result;
}
sum();
sum(11,22);
sum(11); //11+0

let result = sum(11, 22);

let result2 = sum(11, 22, 33, 44, 55, 66); //에러 안남 (arguments가 함수가 실행될때 매개값들을 받아서 처리해준다...)
console.log('결과는 ' + result2);


//함수표현식
let sum2 = function(num1 = 0, num2 = 0){
    let result= num1 + num2;
    return result;
}
console.log('결과: ' + sum2(10, 20));
let obj1 = {
    name: "Hong",
    point: 100
}
let obj2 = {
    name: "Hwang",
    point: 80
}
let average = function(obj1={}, obj2 = {}){ //객체인 매개값이 오는경우 (걍 obj1, ojb2 이렇게 쓸수 있고...매개값으로 배열이 올수도 있다)
    let result = 0;
    result = (obj1.point + obj2.point) /2;
    return result;
}
console.log('평균값: ' + average(obj1, obj2));
let array1 = [10, 20];
let array2 = [30, 40];
let sum3 = function(ary1 =[], ary2= []){
    let result = 0;
    ary1.concat(ary2).forEach(function(val){
        result += val;
    });
    return result;
}
console.log("배열의 총합: " + sum3(array1, array2));

let myfunc = function(callback){
    let result = 0;
    let num1 = 10, num2 = 5;
    result = callback(num1, num2);
    return result;
}
let sumfunc = function(n1, n2){
    return n1+n2;
}
let minusfunc = function(n1, n2){
    return n1-n2;
}

console.log('함수결과 ' + myfunc(sumfunc));
console.log('함수결과 ' + myfunc(minusfunc));