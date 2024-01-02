//function5.js

//Array.prototype.forEach();
const ary = ['a', 'b', 'c'];
ary.forEach(elem => console.log(elem));

ary.forEach((elem, idx) => {
    if(idx > 0){
        console.log(elem);
    }
});


Array.prototype.sum = function(){ //Array라는 prototype에 sum이라는 메소드를 추가하겠다
    console.log(this);
    let result = 0;
    this.forEach(function(val){
        result += val;
    })
    return result;
}
const numbers = [1,2,3,4];
console.log('sum: ' + numbers.sum());

//https://developer.mozilla.org/ko/docs/Web/JavaScript/Reference/Global_Objects/Array/forEach 참고하기