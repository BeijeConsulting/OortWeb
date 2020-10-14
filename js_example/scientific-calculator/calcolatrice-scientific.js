// if (typeof module === "object" && typeof module.exports === "object") module.exports = Lexer;

// Lexer.defunct = function (chr) {
//     throw new Error("Unexpected character at index " + (this.index - 1) + ": " + chr);
// };
// try {
//     Lexer.engineHasStickySupport = typeof /(?:)/.sticky == 'boolean';
// } catch (ignored) {
//     Lexer.engineHasStickySupport = false;
// }
// try {
//     Lexer.engineHasUnicodeSupport = typeof /(?:)/.unicode == 'boolean';
// } catch (ignored) {
//     Lexer.engineHasUnicodeSupport = false;
// }

// function Lexer(defunct) {
//     if (typeof defunct !== "function") defunct = Lexer.defunct;

//     var tokens = [];
//     var rules = [];
//     var remove = 0;
//     this.state = 0;
//     this.index = 0;
//     this.input = "";

//     this.addRule = function (pattern, action, start) {
//         var global = pattern.global;

//         if (!global || Lexer.engineHasStickySupport && !pattern.sticky) {
//             var flags = Lexer.engineHasStickySupport ? "gy" : "g";
//             if (pattern.multiline) flags += "m";
//             if (pattern.ignoreCase) flags += "i";
//             if (Lexer.engineHasUnicodeSupport && pattern.unicode) flags += "u";
//             pattern = new RegExp(pattern.source, flags);
//         }

//         if (Object.prototype.toString.call(start) !== "[object Array]") start = [0];

//         rules.push({
//             pattern: pattern,
//             global: global,
//             action: action,
//             start: start
//         });

//         return this;
//     };

//     this.setInput = function (input) {
//         remove = 0;
//         this.state = 0;
//         this.index = 0;
//         tokens.length = 0;
//         this.input = input;
//         return this;
//     };

//     this.lex = function () {
//         if (tokens.length) return tokens.shift();

//         this.reject = true;

//         while (this.index <= this.input.length) {
//             var matches = scan.call(this).splice(remove);
//             var index = this.index;

//             while (matches.length) {
//                 if (this.reject) {
//                     var match = matches.shift();
//                     var result = match.result;
//                     var length = match.length;
//                     this.index += length;
//                     this.reject = false;
//                     remove++;

//                     var token = match.action.apply(this, result);
//                     if (this.reject) this.index = result.index;
//                     else if (typeof token !== "undefined") {
//                         switch (Object.prototype.toString.call(token)) {
//                         case "[object Array]":
//                             tokens = token.slice(1);
//                             token = token[0];
//                         default:
//                             if (length) remove = 0;
//                             return token;
//                         }
//                     }
//                 } else break;
//             }

//             var input = this.input;

//             if (index < input.length) {
//                 if (this.reject) {
//                     remove = 0;
//                     var token = defunct.call(this, input.charAt(this.index++));
//                     if (typeof token !== "undefined") {
//                         if (Object.prototype.toString.call(token) === "[object Array]") {
//                             tokens = token.slice(1);
//                             return token[0];
//                         } else return token;
//                     }
//                 } else {
//                     if (this.index !== index) remove = 0;
//                     this.reject = true;
//                 }
//             } else if (matches.length)
//                 this.reject = true;
//             else break;
//         }
//     };

//     function scan() {
//         var matches = [];
//         var index = 0;

//         var state = this.state;
//         var lastIndex = this.index;
//         var input = this.input;

//         for (var i = 0, length = rules.length; i < length; i++) {
//             var rule = rules[i];
//             var start = rule.start;
//             var states = start.length;

//             if ((!states || start.indexOf(state) >= 0) ||
//                 (state % 2 && states === 1 && !start[0])) {
//                 var pattern = rule.pattern;
//                 pattern.lastIndex = lastIndex;
//                 var result = pattern.exec(input);

//                 if (result && result.index === lastIndex) {
//                     var j = matches.push({
//                         result: result,
//                         action: rule.action,
//                         length: result[0].length
//                     });

//                     if (rule.global) index = j;

//                     while (--j > index) {
//                         var k = j - 1;

//                         if (matches[j].length > matches[k].length) {
//                             var temple = matches[j];
//                             matches[j] = matches[k];
//                             matches[k] = temple;
//                         }
//                     }
//                 }
//             }
//         }

//         return matches;
//     }
// }
// /** ------------------------------------------------------------------------ */
// function Parser(table) {
//     this.table = table;
// }

// Parser.prototype.parse = function (input) {
//     var length = input.length,
//         table = this.table,
//         output = [],
//         stack = [],
//         index = 0;

//     while (index < length) {
//         var token = input[index++];

//         switch (token) {
//         case "(":
//             stack.unshift(token);
//             break;
//         case ")":
//             while (stack.length) {
//                 var token = stack.shift();
//                 if (token === "(") break;
//                 else output.push(token);
//             }

//             if (token !== "(")
//                 throw new Error("Mismatched parentheses.");
//             break;
//         default:
//             if (table.hasOwnProperty(token)) {
//                 while (stack.length) {
//                     var punctuator = stack[0];

//                     if (punctuator === "(") break;

//                     var operator = table[token],
//                         precedence = operator.precedence,
//                         antecedence = table[punctuator].precedence;

//                     if (precedence > antecedence ||
//                         precedence === antecedence &&
//                         operator.associativity === "right") break;
//                     else output.push(stack.shift());
//                 }

//                 stack.unshift(token);
//             } else output.push(token);
//         }
//     }

//     while (stack.length) {
//         var token = stack.shift();
//         if (token !== "(") output.push(token);
//         else throw new Error("Mismatched parentheses.");
//     }

//     return output;
// };
// /** ------------------------------------------------------------------- */
// var lexer = new Lexer;

// lexer.addRule(/\s+/, function () {
//     /* skip whitespace */
// });

// lexer.addRule(/[a-z]/, function (lexeme) {
//     return lexeme; // symbols
// });

// lexer.addRule(/[\(\+\-\*\/\)]/, function (lexeme) {
//     return lexeme; // punctuation (i.e. "(", "+", "-", "*", "/", ")")
// });

// var factor = {
//     precedence: 2,
//     associativity: "left"
// };

// var term = {
//     precedence: 1,
//     associativity: "left"
// };

// var parser = new Parser({
//     "+": term,
//     "-": term,
//     "*": factor,
//     "/": factor
// });

// function parse(input) {
//     lexer.setInput(input);
//     var tokens = [], token;
//     while (token = lexer.lex()) tokens.push(token);
//     return parser.parse(tokens);
// }

// var stack = [];

// var context = {
//     "a": 1,
//     "b": 2,
//     "c": 3,
//     "d": 4,
//     "e": 5
// };

// var operator = {
//     "+": function (a, b) { return a + b; },
//     "-": function (a, b) { return a - b; },
//     "*": function (a, b) { return a * b; },
//     "/": function (a, b) { return a / b; }
// };

// // parse("e*((a*(b+c))+d)").forEach(function (c) {
// //     switch (c) {
// //     case "+":
// //     case "-":
// //     case "*":
// //     case "/":
// //         var b =+ stack.pop();
// //         var a =+ stack.pop();
// //         stack.push(operator[c](a, b));
// //         break;
// //     default:
// //         stack.push(context[c]);
// //     }
// // });

// // var output = stack.pop();

// // alert(output);

// var resultShow = "";
// var output;

// function show(value) {

//     if(value === '=') {
//         parse(resultShow).forEach(function (c) {
//                 switch (c) {
//                 case "+":
//                 case "-":
//                 case "*":
//                 case "/":
//                     var b =+ stack.pop();
//                     var a =+ stack.pop();
//                     stack.push(operator[c](a, b));
//                     break;
//                 default:
//                     stack.push(context[c]);
//                 }
//             });
            
//             output = stack.pop();
//             document.getElementById("memory").innerHTML = output;
//     }
//     else {
//         resultShow = resultShow + value;
//     }

//     document.getElementById("display").innerHTML = resultShow;

// }

var str = "";

function show(value) {
    if(value === '=') {
        result = eval(str);
        document.getElementById("memory").innerHTML = result;
    }
    else {
        str = str + value;
    }

    document.getElementById("display").innerHTML = str;
}