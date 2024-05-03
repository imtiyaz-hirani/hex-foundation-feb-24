/* Creating employee objects in JS: JSON: JavaScript Object notation */

var emp1={
    name: 'harry',
    city: 'mumbai',
    salary: '88000'
}

var emp2={
    name: 'ronald',
    city: 'chennai',
    salary: '80000'
}

var emp3={
    name: 'hermione',
    city: 'mumbai',
    salary: '98000'
}

var empArry=[emp1,emp2,emp3]; 

const loadEmployees = ()=>{
    let empStr='';
    empArry.forEach(e=>{
        let temp =e.name + '--' + e.city + '--' + e.salary
        empStr = empStr + temp; 
        empStr = empStr + '<br />'
    })
    document.getElementById('empData').innerHTML=empStr;
}

const sortEmployee =(op)=>{
    switch(op){
        case 'ASC':
             empArry.sort((a,b)=>a.salary-b.salary)
            break; 
        case 'RESET':
            empArry=[emp1,emp2,emp3];
            break; 
        case 'DESC':
            empArry.sort((a,b)=>b.salary-a.salary)
            break;
    }
    loadEmployees();
}

const filterEmployee =() =>{
    empArry=[emp1,emp2,emp3];
    let searchStr = document.getElementById('searchStr').value
    console.log(searchStr)

    empArry = empArry.filter(e=>e.name.startsWith(searchStr));
    loadEmployees();
}