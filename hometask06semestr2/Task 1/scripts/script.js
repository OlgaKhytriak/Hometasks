//----------------------- Метод що ховає текст
function hideDiv() {
    var elem = document.getElementById("myDiv");
    if (elem.style.display === "none") {
        elem.style.display = 'block';
    } else {
        elem.style.display = 'none';

    }
}
//----------------------- видаляє елементи списку
var close = document.getElementsByClassName("closebtn");
var i;
for (i = 0; i < close.length; i++) {
    close[i].onclick = function() {
        var div = this.parentElement;
        div.style.opacity = "0";
        setTimeout(function() {
            div.style.display = "none";
        }, 600)
    }
}


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