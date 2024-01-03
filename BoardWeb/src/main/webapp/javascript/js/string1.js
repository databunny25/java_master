// string1. js

// p162 string
let str1 = "Hello";
console.log(str1, typeof str1);
let str2 = new String("Hello"); //객체 타입
console.log(str2, typeof str2);

console.log(str1 == str2); //값만 비교 true
console.log(str1 === str2); //타입까지 비교 false

console.log(str2.substring(1,3)); //javascript에서...앞의 매개값은 포함, 뒤의 매개값은 포함X => el 출력
console.log(str1.substring(1,3)); //str1 자동으로 형변환 일어나서 객체에 있는 메소드 사용 가능해짐!

// p158 trimStart(), trimEnd()

let word = "   Hello, World ";
console.log(word.trimStart()); //왼쪽 공백 잘려나감!
console.log(word.trimEnd()); //오른쪽 공백 잘려나감!

// p159 replace
console.log(word.replace('H', 'h'));

// const obj = new Object(); {} 자바스크립트는...new로 선언하는 것보다 후자를 더 선호!
// const reg = new RegExp(); /값/
console.log(word.replace(/l/g, 'h')); // /l/ : 표현식 객체! l이라는 문자를 찾아서 바꾸겠다는 표현식 객체로 써줄수도 있다! (g는 global 전체 구문에서 찾겠다는 뜻!)
console.log(word.replace(/\s/g, '')); // \s: 공백 의미! /\s/ word안에 전체에서 공백을 찾아서 ''로 바꾸겠다!

// 159p
word = '  how are you   to day  everyone.  ';
console.log(word.split(' ').filter((val)=> val));
console.log(word.split(' ').filter((val)=> val).join(' ')); 
// split : 문자열을 공백으로 잘라서 배열에 담아준다! 따라서 word.split(' ')은 배열임!
// filter : 배열메소드. true인 값(공백 아닌 값)만 담아준다!
// join : 배열에 담긴 요소들을 문자열로 변환해줌

