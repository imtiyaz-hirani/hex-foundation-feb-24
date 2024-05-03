const name='harry potter'; //global variable - not recommended way
var pi=3.14;

displayName=()=>{
    name='ronald';
    console.log(name)
}

 display=()=>{
    /* Right way of creating a variable*/
    const nameVal='harry potter'; //local variable
    //nameVal="ron"; -- cannot reassign value to const variable
    console.log(nameVal)
}

 display1 =()=>{
    //recommended: let is used to create local variables
    let nameVal='harry potter'; 
    console.log(nameVal)
    nameVal='ronald';
    console.log(nameVal)
}

 display2=()=>{
    var nameVal="harry potter"; //instead of var prefer let. 
    console.log(nameVal)
    nameVal='ronald';
    console.log(nameVal)
    console.log(pi)
}

m1=()=>console.log('arrow function')

const firstName=(name)=>console.log(name)

const nameConcat=(fname,lname)=>console.log(fname + ' ' + lname);
