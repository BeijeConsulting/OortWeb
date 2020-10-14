// booleano per permettere una singola operazione alla volta
let operatorSelected = false;

// entry point
function calcolatrice(valore) {
    document.getElementById("error").innerHTML = null;

    console.log("Selezionato: " + valore + ". OperationDone: " + operatorSelected);

    // Se faccio AC pulisco lo schermo.
    if (valore === 'AC'){
        console.log("Pulisco...");

        document.getElementById("screen").value = "";
        return;
    }

    // Se hai già fatto un'operazione, fai l'operazione effettiva (come la calc di Windows)
    if (operatorSelected &&
        (valore === '+' || valore === '-' || valore === '*' || valore === '/')){

        console.log("Richiesta di operazione multipla trovata, quindi eseguo operazione.")
        console.log("Valore: " + valore + ". OperationDone: " + operatorSelected);

        let operator = valore;
        valore = calc(document.getElementById("screen").value);
        valore += operator;

        operatorSelected = true;

        // Se ancora nessuna operazione è stata fatta, prosegui normalmente
    } else if (!operatorSelected &&
        (valore === '+' || valore === '-' || valore === '*' || valore === '/')){
        console.log("Richiesta di operazione multipla singola fatta. Proseguo.")
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
        return getNumber(nums[0]) + getNumber(nums[1])
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
    if (numberInString.indexOf(",") === -1){
        console.log("Float in input. Converto...")
        let float = parseFloat(numberInString);
        console.log("Numero convertito in float: " + float);
        return float;
    } else return parseInt(numberInString, 10);
}