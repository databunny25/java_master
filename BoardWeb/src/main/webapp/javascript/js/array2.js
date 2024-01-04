// array2.js
// reduce()
const numAry = [23, 10, 17, 35, 9];

let result = numAry.reduce((acc, num)=>{
    console.log(acc, num);
    return acc + num;
}, 0 );
console.log(`총합: ${result}`);

result = numAry.reduce((acc, num)=>{
    return acc > num ? acc : num;
}, 0 );
console.log(`최대값: ${result}`);


// 1. 최소값
result = numAry.reduce((acc, num)=>{
    return acc > num ? num : acc;
}, numAry[0]);
console.log(`최소값: ${result}`);

// 2. 평균
// //내가 한거
// result = numAry.reduce((acc, num)=>{
//     return acc + num/numAry.length;
// }, 0);

result = numAry.reduce((acc, num, idx)=>{
    if(idx == numAry.length -1){
        console.log((acc+num)/numAry.length);
        return (acc+num)/numAry.length
    }
    console.log(acc + num);
    return acc + num; // 이거 이해 안된다!!!!!!!!!!!!!!!!!ㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠ
}, 0);
console.log(`평균: ${result}`);


// 10보다 큰 값을 새로운 배열
result = numAry.reduce((acc, num) =>{
    if (num > 10){
        acc.push(num);
    }
    return acc;
}, []); //초기값...배열

console.log(`결과: ${result}`);



