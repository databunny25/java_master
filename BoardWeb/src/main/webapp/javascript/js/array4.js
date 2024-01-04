//array4.js
// map, filter, find, indexOf, some, every

// const str = '펭수, 라이언, 어피치, 콘, 브라운, 무지, 라이언, 어피치, 콘';

// // 1. 콘이라는 이름이 몇번?

// //내가 함...
// const strAry1 = str.split(', ');
// console.log(strAry1);

// //책 코드...이해안감ㅜㅜ
// let index = -1;
// let count = 0;
// do{
//     index = strAry1.indexOf('콘', index+1);
//     count += index >= 0 ? 1:0;
// }while(index >= 0);
// console.log(count);

// //or
// console.log(strAry1.filter(val => val.indexOf('콘') != -1).length);


// // 2. 이름이 3자 이상이 몇명?
// console.log(strAry1.filter(val => val.length >=3).length);


// // 3. 2자인 이름이 있는지 여부?
// console.log(strAry1.some(val => val.length ==2));



// // 4. {no: 1, name: '펭수'} 형태의 값을 가지는 배열을 생성. 결과값을 strAry에 대입

// const strAry = strAry1
//     .filter(val => val.indexOf('펭수') != -1)
//     .map((item, idx)=>{
//         let obj={}
//         obj.no = 1;
//         obj.name = item;
//         return obj;
// }) 
// console.log(strAry);



// 교수님 풀이!!!!!!!!!!!!!!
const str = '펭수, 라이언, 어피치, 콘, 브라운, 무지, 라이언, 어피치, 콘';

// 1. 콘이라는 이름이 몇번?
console.log('콘이름횟수 ' + str.split(', ').filter(name => name == '콘').length)

// 2. 이름이 3자 이상이 몇명?
console.log('3자이상횟수 ' + str.split(', ').filter(name => name.length >= 3).length)

// 3. 2자인 이름이 있는지 여부?
console.log('2자존재여부 ' + str.split(', ').some(name => name.length == 2))

// 4. {no: 1, name: '펭수'} 형태의 값을 가지는 배열을 생성. 결과값을 strAry에 대입.

const strAry = str.split(', ').map((item, idx) => {
    return {
        no: idx + 1,
        name: item
    };
});
console.log(strAry)
// 1.
console.log('콘: ', strAry.reduce((acc, obj) => {
    if (obj.name == '콘') {
        acc++;
    }
    return acc;
}, 0));
// 2.
console.log('3자 이상: ', strAry.reduce((acc, obj) => {
    if (obj.name.length >= 3) {
        acc++;
    }
    return acc;
}, 0));
// 3.
console.log('2자: ' + strAry.some(obj => obj.name.length == 2));