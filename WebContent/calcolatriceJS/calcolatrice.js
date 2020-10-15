let previousValue = null;
let previousOperation = null;
let isDisplayReset = false;
let isExpressionReset = false;

function clickCalc(btnValue) {
    manageBtn(btnValue);
}

// Lambda equivalente: var clickCalc = btnValue => manageBtn(btnValue);

function manageBtn(btnValue) {

    // Resetta il display dei risultati quando previsto
    // - Dopo aver premuto +, -, *, / o =; si va a inserire altri numeri
    if (isDisplayReset) {
        resetResultDisplay();
        isDisplayReset = false;
    }

    // Resetta il display dell'espressione quando previsto
    // - Dopo aver premuto =
    if (isExpressionReset) {
        resetExpressionDisplay();
        isExpressionReset = false;
    }

    let displayContainer = document.getElementById("resultDisplay");
    let displayValue = displayContainer.innerHTML;

    if (btnValue === "AC") {
        resetResultDisplay();
        resetExpressionDisplay();
        resetVariables();
    } else if (btnValue === ",") {
        displayValue = displayValue.includes(".") ? displayValue : displayValue.concat(".");
        showNumber(displayValue);
    } else if (btnValue >= 0 && btnValue <= 9) {
        if (previousOperation == "=") { previousOperation = null; } //Stiamo iniziando un nuovo calcolo, perciò resettiamo l'operatore
        // Se c'è lo 0, deve sovrascriverlo, ma se è 0. o altri numeri, allora deve concatenare
        displayValue = displayValue == 0 && !displayValue.includes(".") ? btnValue : displayValue.concat(btnValue);
        showNumber(displayValue);
    } else if (btnValue === "+" || btnValue === "-" || btnValue === "X" || btnValue === "/" ) {
        expressionDisplay(previousOperation === "=" ? previousValue : displayValue, btnValue);
        let result = previousOperation ? doBinaryMath(previousValue, displayValue, previousOperation) : displayValue;
        previousValue = result;
        previousOperation = btnValue;
        isDisplayReset = true;
        showNumber(result);
    } else if (btnValue === "=") {
        let result = 0;
        if ( previousValue == null ) {
            expressionDisplay(displayValue, btnValue);
            previousValue = displayValue;
            result = previousValue;
        } else if ( previousOperation == null ) {
            return;
        } else {
            expressionDisplay(previousOperation === "=" ? previousValue : displayValue, btnValue);
            result = doBinaryMath(previousValue, displayValue, previousOperation);
            previousValue = result;
        }

        previousOperation = btnValue;
        isDisplayReset = true;
        isExpressionReset = true;
        showNumber(result);

    }
}

function expressionDisplay(value, btnValue) {
    let expressionContainer = document.getElementById("expressionDisplay");
    let expressionValue = expressionContainer.innerHTML;
    if (typeof value != "number") {
        value = value.charAt(value.length - 1) == "." ? value.substring(0, value.length - 1) : value;
    }
    expressionContainer.innerHTML = expressionValue.concat(value).concat(btnValue).toLowerCase();
}

function doBinaryMath(value1, value2, operation) {
    let result;
    value1 = parseFloat(value1);
    value2 = parseFloat(value2);
    if (operation === "+") {
        result = value1 + value2;
    } else if (operation === "-") {
        result = value1 - value2;
    } else if (operation === "X") {
        result = value1 * value2;
    } else if (operation === "/") {
        if (value2 == 0) {
            result = "Error";
        } else {
            result = value1 / value2;
        }
    } else if (operation === "=") {
        result = value1;
    }
    return result;
}

function showNumber(result) {
    document.getElementById("resultDisplay").innerHTML = result;
}

function resetResultDisplay() {
    document.getElementById("resultDisplay").innerHTML = "0";
}

function resetExpressionDisplay() {
    document.getElementById("expressionDisplay").innerHTML = "";
}

function resetVariables() {
    previousValue = null;
    previousOperation = null;
    isDisplayReset = false;
    isExpressionReset = false;
}