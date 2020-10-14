/*let a; //undefined
let c = null;
let d1 = 0;
let d2 = "";
let array = "a b c d e".split(" ");
{
	var s = 'ciao oort!!';
	const b = 5.5;
	//b = 5;
}
//			alert(a);
//			alert(c);
//			alert('s : ' + s*2); //NaN
/*array.map(i => {
	let j = i+i;
	console.log(j);
});

console.log('a : ', a);
console.log('c : ', c);
console.log('a == c ? ', a == c);
console.log('a === c : ', a === c);
console.log('0 == "0" ? ', 0 == '0');
console.log('0 === "0" : ', 0 === "0");
console.log('0 == [] ? ', 0 == []);
console.log('0 === [] : ', 0 === []);
if (d1) console.log('d1 : ', d1);
if (d2) console.log('d2 : ', d2);*/

/* JAVASCRIPT PER PROVA.HTML*/

function checkNumero(el) {
	let num = el.value;
	console.log(num);
	if (num && num.length > 3) {
		el.style.color = 'red';
		document.getElementById('msg').innerHTML="il numero non deve superare le 3 cifre";
	}
}

function checkLogin(formEl) {
	console.log(formEl.email.value);
	console.log(formEl.password.value);
	
	if (formEl.email.value && formEl.password.value) return true;
	else {
		document.getElementById('msgLogin').innerHTML="CREDENZIALI INCOMPLETE";
		return false;	
	}
}

/* JAVASCRIPT PER CALCOLATRICE.HTML*/
var o="";

function reset() {
	document.getElementById("display").innerHTML = "";
	o="";
}

function num(valore) {
	o+=valore;
	document.getElementById("display").innerHTML = o;
}

function operation(op, o, o1) {
	//console.log('Entro in operation. operaione(op)=', op, ' Operando 1:', parseInt(o1), ' Operando 2:', o);
	if(op=="+") return parseFloat(o1)+parseFloat(o);
	if(op=="-") return parseFloat(o1)-parseFloat(o);
	if(op=="*") return parseFloat(o1)*parseFloat(o);
	if(op=="/") return parseFloat(o1)/parseFloat(o);
}

function parse() {
	//console.log('Entro in parse(). var o = ', o)
	let o1="";
	for (let index = 0; index < o.length; index++) {
		//console.log('Entro nel for. Index = ', index ,"ChatAt(index): ", o.charAt(index));
		if (o.charAt(index)==="+" || o.charAt(index)==="-" || o.charAt(index)==="*" || o.charAt(index)==="/") {
			let op = o.charAt(index);
			document.getElementById("display").innerHTML = operation(op, o.substr(index+1), o1);
			break;
		} else {
			o1 += o.charAt(index)
		}
	}
	o="";
}