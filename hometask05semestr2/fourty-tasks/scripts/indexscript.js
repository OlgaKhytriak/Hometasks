//----------------------- 
//----------------------- 
//----------------------- 
//----------------------- 
//----------------------- 
//----------------------- 
//----------------------- 
//----------------------- 
//----------------------- 
//----------------------- 
//----------------------- 

//-----------------------    Сума n-чисел через рекурсію
/*function sum(n) {
    if (n != 1) { // пока n != 1, 
        return n + sum(n - 1);
    } else {
        return n;
    }
}
alert(sum(5));
//-----------------------    Степінь числа через рекурсію
/*function pow(x, n) {
    if (n != 1) { // пока n != 1, сводить вычисление pow(x,n) к pow(x,n-1)
        return x * pow(x, n - 1);
    } else {
        return x;
    }
}

alert(pow(2, 3));
//-----------------------     Анонимные функции
/*                --------  З анонімною
function ask(question, yes, no) {
    if (confirm(question)) yes()
    else no();
}
ask(
    "Вы согласны?",
    function() { alert("Вы согласились."); },
    function() { alert("Вы отменили выполнение."); }
);

/*                --------  Без анонімної
function ask(question, yes, no) {
    if (confirm(question)) yes()
    else no();
}

function showOk() {
    alert("Вы согласились.");
}

function showCancel() {
    alert("Вы отменили выполнение.");
}

// использование
ask("Вы согласны?", showOk, showCancel);
*/