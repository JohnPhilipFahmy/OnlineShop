  
function add( id ){
  
  var x = document.getElementById("Num"+id);
  x.value =  (x.value )-(-1);
    
    console.log("john"+id);
}
function reduction(id){
    var x = document.getElementById("Num"+id);
    if(x.value > 0){
        
  x.value =  (x.value )-1;
}
}