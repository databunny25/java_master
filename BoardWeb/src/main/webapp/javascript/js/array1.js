// array1.js
// ary=[]
const ary =[1, 2, '3', new Date()]; //다른 타입도 담을 수 있다

const numAry = [10, 20, 30, 40];
numAry.push(30);
numAry.unshift(40); //배열의 제일 처음 위치에 값 추가
numAry.pop(); //마지막 요소 삭제
numAry.shift(); //첫 요소 삭제
numAry.splice(1,0,50, 60); //추가, 수정, 삭제 모두 가능 1번째 위치의 0개를 50과 60으로 바꾸겠다(50과 60을 1번 위치에 추가하겠다는 의미)
// numAry.splice(0); //모두 삭제

// numAry.length = 0; //배열 요소 전부 지워줌
numAry.length = 10; //배열 길이 수정...empty*4 를 볼수있다

console.log(numAry);
console.log(numAry.length);



const numAry2 = [50, 60];

// const numAry3 = numAry.concat(numAry2); //concat은 새로운 배열을 만들어 이어준다
// console.log(numAry3);

// numAry에 numAry2를 추가
numAry2.forEach(elm => numAry.push(elm));
console.log(numAry);
