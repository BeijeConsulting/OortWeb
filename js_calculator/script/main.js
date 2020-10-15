
let numberOne = 0;
let numberTwo = 0;
let operation = "";

function changeBackground(element, type) {

    if (type === 'over') {
        element.style.background = 'red';
    } else if (type === 'out') {
        element.style.background = 'blanchedalmond';
    }
}

function deleteAll() {
    document.getElementById('input-box').value = "";
}

function deleteSingleElement() {

    let value = document.getElementById('input-box').value;
    value = value.slice(0, value.length - 1);
    document.getElementById('input-box').value = value;

}

function inputNumber(element) {
    document.getElementById('input-box').value += element.innerHTML;
}

function inputCommand(element) {
    document.getElementById('input-box').value += element.innerHTML;
}

function calculate() {

    let text = document.getElementById('input-box').value;


    //let simbols = new Map();
    //let numbers = new Map();

    let simbols = [];
    let numbers = [];

    let number = '';

    for (let i = 0; i < text.length; i++) {
        switch (text[i]) {
            case '*':
            case '/':
            case '+':
            case '-':
                simbols.push(text[i]);
                numbers.push(parseFloat(number));
                number = '';
                //simbols.set(i, text[i]);
                break;
            default:
                number += text[i];
            //numbers.set(i, parseInt(text[i]));
        }

        if (i == text.length - 1) {
            numbers.push(parseInt(number));
        }
    }

    // console.log(numbers);
    // console.log(simbols);

    let n1 = 0;
    let n2 = 0;

    let total;

    for (let i = 0; i < numbers.length; i++) {

        if (i == 0) {
            total = numbers[i];
        } else if (i != numbers.length - 1) {
            switch (simbols[i]) {
                case '*':
                    total *= numbers[i];
                    break;
                case '/':
                    total /= numbers[i];
                    break;
                case '+':
                    total += numbers[i];
                    break;
                case '-':
                    total -= numbers[i];
                    break;
            }
        } else {
            switch (simbols[i - 1]) {
                case '*':
                    total *= numbers[i];
                    break;
                case '/':
                    total /= numbers[i];
                    break;
                case '+':
                    total += numbers[i];
                    break;
                case '-':
                    total -= numbers[i];
                    break;
            }
        }
    }

    document.getElementById('input-box').value = total;
}