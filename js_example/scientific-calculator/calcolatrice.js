var result = '';
var value1 = '';
var value2 = '';
var operation = '';

function show(value) {

    switch (value) {
        case 'C':
            if(value2 != '') {
                value2 = '';
            }
            else if(value1 != '') {
                value1 = '';
            }
            document.getElementById('display').innerHTML = '';
            break;

        case 'CE':
            value1 = '';
            value2 = '';
            result = '';
            operation = '';
            document.getElementById('memory').innerHTML = '';
            document.getElementById('display').innerHTML = '';
            document.getElementById('operation').innerHTML = '';
            break;

        case '%':
            operation = '%'
            if(value1 === '') {
                value1 = 0;
            }
            document.getElementById('memory').innerHTML = value1;
            document.getElementById('display').innerHTML = value2;
            break;

        case '/':
            operation = '/';
            if(value1 === '') {
                value1 = 0;
            }
            document.getElementById('memory').innerHTML = value1;
            document.getElementById('display').innerHTML = value2;
            break;

        case '*':
            operation = '*';
            if(value1 === '') {
                value1 = 1;
            }
            document.getElementById('memory').innerHTML = value1;
            document.getElementById('display').innerHTML = value2;
            break;

        case '-':
            operation = '-';
            if(value1 === '') {
                value1 = 0;
            }
            document.getElementById('memory').innerHTML = value1;
            document.getElementById('display').innerHTML = value2;
            break;

        case '+':
            operation = '+';
            if(value1 === '') {
                value1 = 0;
            }
            document.getElementById('memory').innerHTML = value1;
            document.getElementById('display').innerHTML = value2;
            break;

        case '=':
            document.getElementById('display').innerHTML = '';
            if(operation === '+') {
                result = parseFloat(value1) + parseFloat(value2);
            }
            else if(operation === '-') {
                result = parseFloat(value1) - parseFloat(value2);
            }
            else if(operation === '%') {
                result = parseFloat(value1) % parseFloat(value2);
            }
            else if(operation === '/') {
                result = parseFloat(value1) / parseFloat(value2);
            }
            else if(operation === '*') {
                result = parseFloat(value1) * parseFloat(value2);
            }
            value1 = result;
            value2 = '';
            operation = '';
            document.getElementById('operation').innerHTML = '';
            document.getElementById('memory').innerHTML = result;
            break;

        default:
            if(operation === '' && result === '') {
                result = '';
                value1 = value1 + '' + value;
                document.getElementById('display').innerHTML = value1;
            }
            else {
                value2 = value2 + '' + value;
                document.getElementById('memory').innerHTML = value1;
                document.getElementById('display').innerHTML = value2;
            }           
            break;

    }

    console.log("Value => " + value);
    console.log("Value1 => " + value1);
    console.log("Value2 => " + value2);
    console.log("Operation => " + operation);

    
    document.getElementById('operation').innerHTML = operation;
   
    

}