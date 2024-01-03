// class3.js

// 배열에 추가-> push 사용
const ary=[]
ary.push(1)
ary.push(2)
ary.push(3)
console.log(ary);

// find : 배열에서 해당되는 위치에 그 값이 있는지 찾는다
console.log(ary.find(item => {
    return item >= 2; //true값을 첫번째 반환 (이 ary배열에서 find 메소드를 실행하면...조건을 만족하는 첫번째 item값을 반환해줌)
}));


// p100~101
class Estimate{
    constructor(param){
        this.unit = param;
    }
    // 견적가 얻기 메서드
    getestimate(unittype, width, height){
        let priceinfo = this.unit.find(item => item.type == unittype);
        return priceinfo.price*width*height;
    }
    // 배열에 요소 추가 메서드
    addUnit(unit){
        unit.push(unit);
    }
}

let unitinfo = [{type:"wood", price:100}, {type:"iron", price:300}, {type: "plastic", price:200}];
const estimator = new Estimate(unitinfo);
let result = estimator.getestimate('wood', 20, 20);
console.log(result);




// p.102 프로토타입

// 객체를 만들면? 프로토타입이라는 추가적인 속성이 있어서 prototype에 여러가지 메소드를 추가해서 선언한 인스턴스에서 쓸수있다~
// 프로토타입은...새로운 인스턴스 만들때 기능을 복사해서 메모리에 새로 저장되는것 X 프로토타입의 주소값을 참조해서 사용 O




// p.111 this
// 1. 객체: this는 자기자신
// 2. function() this는 전역객체(window);
function myFunc(){
    console.log(this);
}
myFunc();

let obj = {}
obj.act = function(){ //obj에 act라는 메소드 추가
    this.value = 'default value'; //this는...지금 객체 안 메소드이긴 때문에 this 는 자기자신obj

    function innerAct(){
        this.value = 'innerAct value'; //function 안에서 this는 window...윈도우의 value에 innerAct라는 값을 넣었다
        console.log("this.value: " + this.value);
    }
    function innerReact(caller){
        caller.value="innerReact value"; //obj의 value
        console.log("this.value: " + this.value); //함수 안 이므로 this는 window.value => innerAct value
        console.log("caller.value: " + caller.value); 
    }
    innerAct();
    console.log("obj 객체의 this.value: " + this.value); 

    innerReact(this); //this는 객체 obj
    console.log("obj 객체의 this.value: " + this.value);    
}
obj.act();



// window.location.href="https://www.daum.net";



// p116. Closure
function outerFunc(name){
    let saying = name + '안녕!';
    
    return function(){
        return saying;
    }
}

const closure1 = outerFunc('라이언');
const closure2 = outerFunc('콘');
console.log(closure1); // f(){ return saying; }  출력...closure1에는 saying을 반환하는 함수 정의 구문이 담겨있다
console.log(closure1()); //함수 종료 시점에 saying이 사라져야 하지만 무사히 출력되는걸 볼수있다! 
console.log(closure2());



function getCounter(){
    let cnt = 1;
    
    return function(){
        cnt++;
        console.log(cnt);
    }
    // increaseCounter();
}

const clo1 = getCounter();
clo1();
clo1();
clo1();
