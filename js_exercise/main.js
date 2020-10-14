function insert(value){
  var answerView = document.getElementById("readhere");
  if(answerView.value == "Errore")
    answerView.value = value;
  else
    answerView.value+=value;
}

function back(){
  var answerView = document.getElementById("readhere");
  if(answerView.value == "Errore")
    clean();
  else
    answerView.value = answerView.value.substring(0,answerView.value.length-1);
}

function clean(){
  document.getElementById("readhere").value = "";
}

function equal(){
  var answerView = document.getElementById("readhere");
  try{
    var answer = eval(answerView.value);
  }catch{
    var answer = "Errore";
  }
  answerView.value = answer;
}

function date(){
	document.getElementById("readhere").value = new Date();
}