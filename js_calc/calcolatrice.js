// booleano per permettere una singola operazione alla volta
let operatorSelected = false;

// entry point
function calcolatrice(valore) {
    document.getElementById("error").innerHTML = null;

    console.log("Selezionato: " + valore + ". OperationDone: " + operatorSelected);

    // Devo cancellare tutto o l'ultimo char? Se sì, inutile proseguire, fai return.
    if (tryCleanOrDelete(valore)) return;

    //todo radice non funzionante perché non riesce a fare il controllo

    // Se hai già fatto un'operazione, fai l'operazione effettiva (come la calc di Windows)
    if (operatorSelected &&
        (valore === '+' || valore === '-' || valore === '*' || valore === '/'
            || valore === '^' || valore === "\u221A")){

        console.log("Richiesta di operazione multipla trovata, quindi eseguo operazione.")
        console.log("Valore: " + valore + ". OperationDone: " + operatorSelected);

        let operator = valore;
        valore = calc(document.getElementById("screen").value);
        valore += operator;

        operatorSelected = true;

        // Se ancora nessuna operazione è stata fatta, prosegui normalmente
    } else if (!operatorSelected &&
        (valore === '+' || valore === '-' || valore === '*' || valore === '/'
        || valore === '^' || String(valore) === "\u221A")){
        console.log("Richiesta di operazione singola fatta. Proseguo.")
        operatorSelected = true;
    }

    if (valore === 'eq' && operatorSelected){
        valore = calc(document.getElementById("screen").value);
        scriviSuSchermo(valore);
        return;
    } else if (valore === 'eq' && !operatorSelected){
        document.getElementById("error").innerHTML = "Errore. Non hai fatto nessuna operazione.";
        return;
    }
    scriviSuSchermo(valore);
}

// Si occupa di scrivere su schermo
function scriviSuSchermo(val){
    document.getElementById("screen").value += val;
}

// Effettua i calcoli
function calc(valueOnScreen){
    // Pulisco lo schermo della calcolatrice
    document.getElementById("screen").value = "";
    operatorSelected = false;

    // Converto l'oggetto generico in Stringa
    let value = String(valueOnScreen);

    // Faccio il calcolo corretto a seconda dell'operatore
    if (value.indexOf("+") !== -1){ // somma
        let nums = value.split("+");
        return getNumber(nums[0]) + getNumber(nums[1]);
    } else if (value.indexOf("^") !== -1){ // pow
        let nums = value.split("^");
        let result = pow(getNumber(nums[0]), getNumber(nums[1]));
        console.log(result);
        return result;
    } else if (value.indexOf('\u221A') !== -1){ //sqrt
        let nums = value.split('\u221A');
        let result = radix(getNumber(nums[0]), getNumber(nums[1]));
        console.log(result);
        return result;
    } else if (value.indexOf("-") !== -1){ // sottrazione
        let nums = value.split("-");
        return getNumber(nums[0]) - getNumber(nums[1])
    } else if (value.indexOf("*") !== -1){ // moltiplicazione
        let nums = value.split("*");
        return getNumber(nums[0]) * getNumber(nums[1])
    } else if (value.indexOf("/") !== -1){ // divisione
        let nums = value.split("/");
        // Controllo che non sia una divisione per 0
        if (parseInt(nums[1], 10) === 0){
            console.log("Tentata divisione per zero.");
            document.getElementById("error").innerHTML = "Tentata divisione per zero.";
            return "";
        } else return getNumber(nums[0]) / getNumber(nums[1])
    } else {
        return "";
    }
}

function getNumber(numberInString){
    if (numberInString.indexOf(",") !== -1){
        console.log("Float in input. Converto...")
        let float = parseFloat(numberInString);
        float = float.toFixed(5);
        console.log("Numero convertito in float: " + float);
        return float;
    } else return parseInt(numberInString, 10);
}

function radix(n1, n2){
    if (n2 === 0){
        console.log("Zero non è un inpur valido.");
        document.getElementById("error").innerHTML = "Zero non è un inpur valido.";
        return "";
    }
    return Math.pow(n1, 1/n2);
}

function pow(n1, n2){
    return Math.pow(n1, n2);
}

function tryCleanOrDelete(valore){
    // Se faccio AC pulisco lo schermo.
    if (valore === 'AC'){
        console.log("Pulisco...");
        document.getElementById("screen").value = "";
        return true;
    } else if (valore === 'del'){
        console.log("Cancello ultimo char...");
        let screenString = String(document.getElementById("screen").value);
        // Se era un operatore, annullo il boolean, così torno a 0 operatori scritti.
        let lastChar = screenString.charAt(screenString.length - 1 );
        if (lastChar === '+' || lastChar === '-' || lastChar === '*' || lastChar === '/'
            || lastChar === '^' || lastChar === '&radic;'){
            operatorSelected = false;
        }
        document.getElementById("screen").value = screenString.slice(0, -1);
        return true;
    } else return false;
}