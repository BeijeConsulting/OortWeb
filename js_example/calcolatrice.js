
var result=0;
var operatore;
var variabile='0';
function risultato(oper, risultato, num) {

		if(oper== '+'){
			result = risultato+ parseFloat(num);
			variabile='0';
			console.log("ADDIZIONE");
			console.log("Risultato dentro RISULTATO "+ result)
		}
		else if(oper== '-'){
			result= risultato -parseFloat(num);
			variabile='0';
		}
		else if(oper== '*'){
			result= risultato * parseFloat(num);
			variabile='0';
		}
		else if(oper== '/'){
				result= risultato / parseFloat(num);
				variabile='0';
		}
				
}
	function insert(num){
		if(variabile==='0'&&num!='.') variabile=num;
		else variabile = variabile.concat(num);
		document.getElementById('display').innerHTML= variabile;
		console.log("variabile corrente "+ variabile);
	}
	function operazione(oper){
		if(oper!= 'AC' && oper!= '='){
			if(!operatore){
				operatore = oper;
				if(result==0) result=parseFloat(variabile);
				variabile='0';
				console.log(operatore);
				console.log("risultato iniziale " + result)
				}
			
			else{
		
				risultato(operatore, result, variabile);
				document.getElementById('display').innerHTML= result;		
				console.log("risultato nell'else " + result);
				operatore = oper;
			}			
		} else if(oper=='AC'){
			result=0;
			variabile='0';
			operatore=null;
			document.getElementById('display').innerHTML= result;
		}	else if(oper == '='){
			risultato(operatore, result, variabile);
			operatore=null;
			document.getElementById('display').innerHTML= result;
			}

	}


