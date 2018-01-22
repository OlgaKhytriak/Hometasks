function setDefaultValues() {
    // task 1.1
    document.getElementById("string1").value = "рудщ ві віав";
    document.getElementById("size1").value = 3;
    // task 1.2
    document.getElementById("string2").value = "Назва Львів дана місту на честь князя Лева Даниловича, сина засновника Львова Данила Галицького.";
    document.getElementById("letter1").value = "а";
}
//--------------Task 3 -------------------
function createSymbolsArray(str) {
    var symbols = [];
    for (var i = 0; i < str.length; i++) {
        var currentSymbol = str[i];
        isInArray = false;
        for (var j = 0; j < symbols.length; j++) {
            if (symbols[j] == currentSymbol) {
                isInArray = true;
                break;
            }
        }
        if (!isInArray) {
            symbols.push(currentSymbol);
        }
    }
    return symbols;
}

function countSymbolInStr(str, symbol) {
    var s = 0;
    for (var i = 0; i < str.length; i++) {
        if (str[i] == symbol)
            s++;
    }
    return s;
}

function createQuantityBySymbolObject(str) {
    var rezObj = {};
    var symbols = createSymbolsArray(str);
    for (var i = 0; i < symbols.length; i++) {
        var currentSymbol = symbols[i];
        var currentQuantity = countSymbolInStr(str, currentSymbol);
        if (currentQuantity > 1) {
            rezObj[currentSymbol] = currentQuantity;
        }
    }
    return rezObj;
}


function remember(str) {
    var rezText = "";
    console.log(createQuantityBySymbolObject(str));
    return rezText;
}

function solveTask3() {
    var strToFilter = document.getElementById("text3").value;
    var rezText = remember(strToFilter);
    console.log(rezText);
}
//--------------Task 2 -------------------
var indexGlobal = 0;
var arrayGlobal = Array();

function addElementToArray() {
    arrayGlobal[indexGlobal] = document.getElementById("textArrayElement").value;
    indexGlobal++;
    document.getElementById("textArrayElement").value = "";
}

function displayArray(elementID) {
    var e = "Your array:      [";
    for (var y = 0; y < arrayGlobal.length; y++) {
        e += arrayGlobal[y] + " ";
    }
    e += "]";
    document.getElementById(elementID).innerHTML = e;
}

function arrayToString(rezArray) {
    var printArray = " [ ";
    for (var y = 0; y < rezArray.length; y++) {
        printArray += rezArray[y] + " ";
    }
    printArray += "]";
    return printArray;
}
//-------
//--------------Task 2.3 -------------------
function avg(array) {
    var resultSum = array.reduce(function(sum, current) {
        sum = sum + parseInt(current);
        return sum;
    }, 0);

    var avgRez = resultSum / array.length;
    return avgRez;
}

function solveTask23() {
    var avgValue = avg(arrayGlobal);
    document.getElementById("RezArray23").innerHTML = avgValue;
}
//--------------Task 2.2 -------------------

function oddFilter(array) {
    var arrayOdd = array.filter(function(arrayElement) {
        if (arrayElement % 2 == 0)
            return false;
        else {
            return true;
        };
    });
    return arrayOdd;
}

function solveTask22() {
    var rezArray = oddFilter(arrayGlobal);
    document.getElementById("RezArray22").innerHTML = arrayToString(rezArray);
}
//--------------Task 2.1 -------------------
function double(array) {
    var doubleArray = array.map(function(arrayElement) {
        return arrayElement * 2;
    });
    return doubleArray;
}

function solveTask21() {
    var rezArray = double(arrayGlobal);
    document.getElementById("RezArray21").innerHTML = arrayToString(rezArray);
}
//--------------Task 1.4-------------------
function deleteAllLettersInText(str) {
    if ((str === null) || (str === ''))
        return false;
    else {
        str = str.toString();
        var rezText = str.replace(/[^-0-9]/gim, '');
    }
    return rezText;
}

function solveTask14() {
    var strToFilter = document.getElementById("text13").value;
    var rezText = deleteAllLettersInText(strToFilter);
    console.log(rezText);
}
//--------------Task 1.3-------------------
function filterText(str) {
    var deleteWord1 = "xxxx";
    var deleteWord2 = "polityka";
    if ((str === null) || (str === ''))
        return false;
    else {
        str = str.toString();
        var rezText = str.replace(new RegExp("xxxx", 'g'), '');
        rezText = rezText.replace(new RegExp("polityka", 'g'), '');
    }

    return rezText;
}

function solveTask13() {
    var strToFilter = document.getElementById("text13").value;
    var rezText = filterText(strToFilter);
    console.log(rezText);
}
//--------------Task 1.2-------------------
function countLetters(str, target) {
    var pos = 0;
    while (true) {
        var foundPos = str.indexOf(target, pos);
        if (foundPos == -1) break;
        pos = foundPos + 1;
    }
    return pos;
}

function solveTask12() {
    var strToFind = document.getElementById("string2").value;
    var letterToFind = document.getElementById("letter1").value;
    var resQuantity = countLetters(strToFind, letterToFind);
    console.log(resQuantity);
}

//--------------Task 1.1-------------------
function truncate(str, maxlength) {

    var newString = str.substring(0, maxlength);
    return newString;
}

function solveTask11() {
    var strToTruncate = document.getElementById("string1").value;
    var sizeToTruncate = parseInt(document.getElementById("size1").value);
    var resultString = truncate(strToTruncate, sizeToTruncate) + "...";
    console.log(resultString);
}