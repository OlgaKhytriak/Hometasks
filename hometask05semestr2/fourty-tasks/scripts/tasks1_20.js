//----------------------- task 20
function solveTask20() {
    var minBorder = parseInt(document.getElementById("text201").value);
    var maxBorder = parseInt(document.getElementById("text202").value);
    rand = function(min, max) {
        if (min == null && max == null)
            return 0;

        if (max == null) {
            max = min;
            min = 0;
        }
        return min + Math.floor(Math.random() * (max - min + 1));
    };

    console.log(rand(minBorder, maxBorder));
}
//----------------------- task 19
function solveTask19() {
    var str19 = document.getElementById("text19").value;
    var myNumber = parseInt(str19);

    function reverse_a_number(n) {
        n = n + "";
        return n.split("").reverse().join("");
    }
    console.log(str19 + " -> " + reverse_a_number(myNumber));

}
//----------------------- task 18
function solveTask18() {
    var str181 = document.getElementById("text181").value;
    var str182 = document.getElementById("text182").value;

    function concatenate(str1, str2) {
        str1 = str1.substring(1, str1.length);
        str2 = str2.substring(1, str2.length);
        return str1 + str2;
    }
    console.log(str181 + "+" + str182 + " -> " + concatenate(str181, str182));
}
//----------------------- task 17
function solveTask17() {
    var str17 = document.getElementById("text17").value;

    function capital_letter(str) {
        str = str.split(" ");

        for (var i = 0, x = str.length; i < x; i++) {
            str[i] = str[i][0].toUpperCase() + str[i].substr(1);
        }

        return str.join(" ");
    }

    console.log(str17 + " -> " + capital_letter(str17));
}
//----------------------- task 16
function solveTask16() {
    var str16 = document.getElementById("text16").value;

    function alphabet_Soup(str) {
        return str.split("").sort().join("");
    }

    console.log(str16 + " -> " + alphabet_Soup(str16));
}
//----------------------- task 15
function solveTask15() {
    var str15 = document.getElementById("text15").value;

    function string_reverse(str) {
        return str.split("").reverse().join("");
    }

    console.log(str15 + " -> " + string_reverse(str15));
}
//----------------------- task 14
function solveTask14() {
    var str14 = document.getElementById("text14").value;

    function upper_lower(str) {
        if (str.length <= 3) {
            return str.toLowerCase();
        }
        front_part = (str.substring(0, 3)).toLowerCase();
        back_part = str.substring(3, str.length);
        return front_part + back_part;
    }
    console.log(str14 + " -> " + upper_lower(str14));
}
//----------------------- task 13
function solveTask13() {
    var str13 = document.getElementById("text13").value;
    var char13 = document.getElementById("char13").value;

    function check_char(str, char) {
        ctr = 0;
        for (let i = 0; i < str.length; i++) {
            if (str.charAt(i) == char) {
                ctr++;
            }
        }
        return (ctr >= 2 && ctr <= 4);
    }
    console.log(check_char(str13, char13));
}
//----------------------- task 12
function solveTask12() {

    var str12 = document.getElementById("text12").value;

    function front_back3(str) {
        if (str.length >= 3) {
            str_len = 3;

            back = str.substring(str.length - 3);
            return back + str + back;
        } else
            return false;
    }

    console.log(front_back3(str12));
}
//----------------------- task 11
function solveTask11() {
    function remove_character(str, char_pos) {
        part1 = str.substring(0, char_pos);
        part2 = str.substring(char_pos + 1, str.length);
        return (part1 + part2);
    }
    var str1 = document.getElementById("text11").value;
    var pos = parseInt(document.getElementById("charPosition11").value);
    console.log(str1);
    console.log(remove_character(str1, pos));
}
//----------------------- task 10
function solveTask10() {
    var str = document.getElementById("string10").value;
    var rezString = "";
    if (str === null || str === undefined || str.substring(0, 2) === 'Py') {
        rezString = str;
    } else { rezString = "Py" + str; }
    console.log(rezString);
}
//----------------------- task 9
function solveTask9() {
    var filename = document.getElementById("fileName").value;
    var ext = filename.split('.').pop();
    console.log(ext);
}
//----------------------- task 8
function solveTask8() {
    alert(document.URL);
}
//----------------------- task 7
function multiplyBy() {
    num1 = document.getElementById("firstNumber").value;
    num2 = document.getElementById("secondNumber").value;
    document.getElementById("rezDivMult").innerHTML = num1 * num2;
}

function divideBy() {
    num1 = document.getElementById("firstNumber").value;
    num2 = document.getElementById("secondNumber").value;
    document.getElementById("rezDivMult").innerHTML = num1 / num2;
}
//----------------------- task 6
function solveTask6() {
    year = window.prompt("Input a Year : ");
    var isLaep = (year % 100 == 0) ? (year % 400 == 0) : (year % 4 == 0);
    console.log(isLaep);
}
//----------------------- task 5 ///не працює в мене
function solveTask5() {

    var element = document.getElementById("w3resource");
    var textNode = element.childNodes[0]; // assuming no other children
    var text = textNode.data;
    setInterval(function() {
        text = text[text.length - 1] + text.substring(0, text.length - 1);
        textNode.data = text;
    }, 1000);
}
//----------------------- task 4
function solveTask4() {
    var a = parseInt(document.getElementById("aSize").value);
    var b = parseInt(document.getElementById("bSize").value);
    var c = parseInt(document.getElementById("cSize").value);
    var p = (a + b + c) / 2;
    var s = Math.sqrt((p - a) * (p - b) * (p - c) * p);
    console.log(p);
    console.log("Triangle square=" + s)
}
//----------------------- task 3
function solveTask3() {
    var date = new Date();
    var mm = date.getMonth(); // місяць
    mm = mm + 1;
    if (mm < 10) {
        mm = "0" + mm;
    }
    var dd = date.getDate(); //день
    if (dd < 10) {
        dd = "0" + dd;
    }
    var yyyy = date.getFullYear(); //рік
    console.log(dd + "/" + mm + "/" + yyyy);
}
//----------------------- task 2
function solveTask2() {
    window.print();
}
//----------------------- task 1
function solveTask1() {
    var rezMessage = "";
    var currentDate = new Date();
    var daysArray = ["Sunday", "Monday", "Tuesday", "Wednesday ", "Thursday", "Friday", "Saturday"];
    var dayIndex = currentDate.getDay();
    rezMessage = " Today is :" + daysArray[dayIndex] + "\n";

    var hour = currentDate.getHours();
    var minuts = currentDate.getMinutes();
    var seconds = currentDate.getSeconds();

    var prepand = (hour >= 12) ? " PM " : " AM ";
    if (hour > 12) {
        hour = hour - 12;
    } else if (hour == 12) {
        prepand = "Noon";
        hour = "";
    } else if (hour == 0) {
        prepand = "Midnight";
        hour = "";
    }
    rezMessage = rezMessage + "Current time is : " + hour + " " + prepand + " : " + minuts + " : " + seconds;
    console.log(rezMessage);
}