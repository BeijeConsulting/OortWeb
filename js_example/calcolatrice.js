let risultato = 0;
let stringaDisplay = "";
let stringaValore = "";
let memory = 0;
let lastOperator = "";
function vedi(valore) {
/*  if (valore != 'AC')
    somma = somma + valore;
  else
    somma = 0;
  alert(somma);*/
    console.log("input : " + valore);
    if (lastOperator == "=") {
        memory = 0;
        risultato = "";
        lastOperator = "";
        stringaDisplay = "";
    }
    switch (valore) {
        case "AC" :
            stringaDisplay = "";
            stringaValore = "";
            memory = 0;
            risultato = 0;
            lastOperator = "";
            break;
        case "DEL" :
            let sliced = stringaDisplay.slice(0, stringaDisplay.length - 1);
            stringaDisplay = sliced;
            stringaValore = stringaDisplay;
            break;
        case "+": 
            memory += parseFloat(stringaValore);
            stringaDisplay = stringaDisplay + " + "  ;
            lastOperator = "+";
            break;
        case "-": 
            if(memory == 0) {
                memory = parseFloat(stringaValore);
            } else {
                memory -= parseFloat(stringaValore);
            }
            
            stringaDisplay = stringaDisplay + " - "  ;
            lastOperator = "-";
            break;
        case "*":
            if (memory == 0) {
                memory = 1;
            }            
            memory *= parseFloat(stringaValore);
            stringaDisplay = stringaDisplay + " x "  ;
            lastOperator = "*";
            break;
        case "/": 
            memory = parseFloat(stringaValore);
            stringaDisplay = "";
            lastOperator = "/";
            break;
        case "=":
            switch (lastOperator) {
                case "+":
                    risultato = memory + parseFloat(stringaValore);
                    lastOperator = "=";
                    break;
                case "-":
                    risultato = memory - parseFloat(stringaValore);
                    lastOperator = "=";
                    break;
                case "*":
                    risultato = memory * parseFloat(stringaValore);
                    lastOperator = "=";
                    break;
                case "/":
                    risultato = memory / parseFloat(stringaValore);
                    lastOperator = "=";
                    break;
                default:
                    lastOperator = "=";
                    memory = 0;
                    risultato = "";
                    stringaDisplay = "";
            }
            stringaDisplay = "" + risultato;
            memory = 0;
            break;
        default:
            if(stringaDisplay.charAt(stringaDisplay.length-1) == " ")
            {
                stringaValore = "";                
            }
                
            stringaValore += valore;
             
            if (lastOperator == "") {
                stringaDisplay = stringaValore;
            } else {
                stringaDisplay += valore;
            }
                                  
    }
    console.log("display : " + stringaDisplay);
    console.log("value: " + stringaValore)
    console.log("risultato : " + risultato);
    console.log("last operator : " + lastOperator);
    console.log("memory : " + memory);
    console.log("");
    document.getElementById("display").value = stringaDisplay;
    return valore;
}


