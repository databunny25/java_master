// function3.js
// 객체생성: {}

let obj1 = {
    name: "홍길동",
    age: 20,
    showInfo: function(){ //속성의 값이 함수로 정해져있으면...이런 것들을 메소드라고 한다
        return '이름은 ' + this.name + ', 나이는 ' + this.age;
    }
}
let obj2 = {
    name: "홍길동",
    age: 20,
    showInfo: function(){ //속성의 값이 함수로 정해져있으면...이런 것들을 메소드라고 한다
        return '이름은 ' + this.name + ', 나이는 ' + this.age;
    }
}
console.log(obj1.name);
console.log(obj1['age']);
console.log(obj1.showInfo());


// 함수를 통해 객체선언
function Member(name, age){  //생성자 함수 => 인스턴스를 만들어줌
    this.name = name; //this.name이 아니라 그냥 name으로 쓰면 전역변수에 있는 name을 불러온다는 의미가 되므로 틀린거임~
    this.age = age; //age = age; 라고 쓰면 전역변수 age 선언하는 뜻이 되어버림...
    this.showInfo = function(){
        return '이름은 ' + this.name + ', 나이는 ' + this.age; 
    }
}

let obj3 = new Member("김명철", 22);
let obj4 = new Member("이형섭", 25);
console.log(obj3.showInfo());
console.log(obj4.showInfo());
// console.log(showInfo()); //showInfo는 Member안에 있어서 사용 X Member에서 this없이 showInfo선언했으면 광역변수라서 여기서도 사용가능