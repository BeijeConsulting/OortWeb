function vedi(valore) {  
  document.getElementById('disp').value+=valore;
  console.log(document.getElementById('disp').value);
  
/*   document.getElementById('display').value+=valore; 
  console.log(document.getElementById('display').value);*/
	
  document.getElementById('display').innerHTML+=valore;
}

function op(){

 document.getElementById('disp').value=eval(document.getElementById('disp').value);
 document.getElementById('display').innerHTML = document.getElementById('disp').value;
 
 //document.getElementById('display').value=eval(document.getElementById('display').value);
}