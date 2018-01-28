var oldRate = 28.745248;
var oldCC = "$";

function createSelect() {
    for (var i = 0; i < data.length; i++) {
        var option = document.createElement('option');
        var parent_elem = document.getElementById("currencyID");
        var old_option = parent_elem.getElementsByTagName("option")[0];
        var new_option = old_option.cloneNode(true);
        new_option.innerHTML = data[i].txt;
        var val = data[i].cc;
        new_option.setAttribute("value", val);
        parent_elem.appendChild(new_option);
    }
}
// - Універсальний конвертер - переводить в довільну валюту вибрану із списка
function convert() {
    var elem = document.getElementById("currencyID");
    var ind = elem.selectedIndex - 1;
    var rate = data[ind].rate;
    var cc = data[ind].cc;
    var desc = data[ind].txt;

    var price_spans = document.getElementsByTagName("span");
    for (var i = 1; i < price_spans.length; i++) {
        var price_text = price_spans[i].innerHTML;
        var price_clear = remove_first_occurrence(price_text, oldCC);
        var price_new = Math.round(parseInt(price_clear) * oldRate / rate);
        price_spans[i].innerHTML = price_new + cc;
    }
    oldRate = rate;
    oldCC = cc
}


function remove_first_occurrence(str, searchstr) {
    var index = str.indexOf(searchstr);
    if (index === -1) {
        return str;
    }
    return str.slice(0, index) + str.slice(index + searchstr.length);
}