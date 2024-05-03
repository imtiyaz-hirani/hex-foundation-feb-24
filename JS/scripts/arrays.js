
const iterateArry=()=>{
    let arry=[4,2,6,8,5,9];
    arry.forEach(e=>console.log(e) )
}
 
const searchElement=(e)=>{
    let arry=[4,2,6,8,5,9];
    let found = 0; 
    arry.find(element=>{
        if(element === e)
            found=1;
    });
    if(found === 1) 
        console.log('found')
    else 
        console.log('Not found')
}
const searchElementShort=(e)=>{
    let arry=[4,2,6,8,5,9];
    let found = 0; 
    arry.find(element=> element === e?found=1: found=0); 
    console.log(found === 1?'element found' : 'not found');
}

var arry=[4,2,6,8,5,9];

const loadArray = ()=>{
    let arryString='';
    arry.forEach(e=>arryString=arryString +'  ' + e);
    document.getElementById('arry').innerHTML=arryString;
}

sortArry = (op) =>{ //ASC  RESET  DESC
    switch(op){
        case 'ASC':
             arry.sort((a,b)=>a-b)
            break; 
        case 'RESET':
            arry=[4,2,6,8,5,9];
            break; 
        case 'DESC':
            arry.sort((a,b)=>b-a)
            break;
    }
    let arryString='';
    arry.forEach(e=>arryString=arryString +'  ' + e);
    document.getElementById('arry')
               .innerHTML=arryString;
}