month = new Array("01", "02", "03", "04", "05", "06",
    "07", "08", "09", "10", "11", "12");

function clock() {
    var d = new Date();
    var month_num = d.getMonth()
    var day = d.getDate();
    var hours = d.getHours();
    var minutes = d.getMinutes();
    var seconds = d.getSeconds();



    if (day <= 9) day = "0" + day;
    if (hours <= 9) hours = "0" + hours;
    if (minutes <= 9) minutes = "0" + minutes;
    if (seconds <= 9) seconds = "0" + seconds;

    date_time = "Сьогодні - " + day + " " + month[month_num] + " " + d.getFullYear() +
        " &nbsp;&nbsp;&nbsp;Поточний час - " + hours + ":" + minutes + ":" + seconds;
    if (document.layers) {
        document.layers.doc_time.document.write(date_time);
        document.layers.doc_time.document.close();
    } else document.getElementById("doc_time").innerHTML = date_time;
    setTimeout("clock()", 1000);
}

function clockLondon() {
    var d = new Date();
    var month_num = d.getUTCMonth()
    var day = d.getUTCDate();
    var hours = d.getUTCHours();
    var minutes = d.getUTCMinutes();
    var seconds = d.getUTCSeconds();

    if (day <= 9) day = "0" + day;
    if (hours <= 9) hours = "0" + hours;
    if (minutes <= 9) minutes = "0" + minutes;
    if (seconds <= 9) seconds = "0" + seconds;

    date_time = "" + day + "." + month[month_num] + "." + d.getFullYear() +
        "&nbsp;- " + hours + ":" + minutes + ":" + seconds;
    if (document.layers) {
        document.layers.doc_time.document.write(date_time);
        document.layers.doc_time.document.close();
    } else document.getElementById("london_time").innerHTML = date_time;
    setTimeout("clockLondon()", 1000);
}

function clockTimezone() {
    var hoursArray = [];
    var dayArray = [];
    var hoursArrayMinus = [];
    var dayArrayMinus = [];
    var data_time_Array = [];
    var data_time_Array_Minus = [];

    var d = new Date();
    var month_num = d.getUTCMonth()
    var day = d.getUTCDate();
    var hours = d.getUTCHours();
    var minutes = d.getUTCMinutes();
    var seconds = d.getUTCSeconds();

    if (day <= 9) day = "0" + day;
    if (hours <= 9) hours = "0" + hours;
    if (minutes <= 9) minutes = "0" + minutes;
    if (seconds <= 9) seconds = "0" + seconds;

    for (var i = 0; i < 12; i++) {
        hoursArray[i] = hours + i;
        hoursArrayMinus[i] = hours - i;
        dayArray[i] = day;
        dayArrayMinus[i] = day;

        if (hoursArray[i] >= 24) {
            hoursArray[i] = hoursArray[i] - 24;
            dayArray[i] = dayArray[i] + 1;
        }

        if (hoursArrayMinus[i] >= 24) {
            hoursArrayMinus[i] = hoursArrayMinus[i] - 24;
            dayArrayMinus[i] = dayArrayMinus[i] + 1;
        }
    }
    for (var i = 0; i < 12; i++) {
        data_time_Array[i] = "" + dayArray[i] + "." + month[month_num] + "." + d.getFullYear() +
            "&nbsp;- " + hoursArray[i] + ":" + minutes + ":" + seconds;
        data_time_Array_Minus[i] = "" + dayArrayMinus[i] + "." + month[month_num] + "." + d.getFullYear() +
            "&nbsp;- " + hoursArrayMinus[i] + ":" + minutes + ":" + seconds;

    }

    if (document.layers) {
        document.layers.doc_time.document.write(data_time_Array[0]);
        document.layers.doc_time.document.close();
        document.layers.doc_time.document.write(data_time_Array[2]);
        document.layers.doc_time.document.close();
        document.layers.doc_time.document.write(data_time_Array[1]);
        document.layers.doc_time.document.close();
        document.layers.doc_time.document.write(data_time_Array_Minus[8]);
        document.layers.doc_time.document.close();
        document.layers.doc_time.document.write(data_time_Array_Minus[5]);
        document.layers.doc_time.document.close();
    } else {
        document.getElementById("zone_0").innerHTML = data_time_Array[0];
        document.getElementById("zone_2").innerHTML = data_time_Array[2];
        document.getElementById("zone_1").innerHTML = data_time_Array[1];
        document.getElementById("zone_8min").innerHTML = data_time_Array_Minus[8];
        document.getElementById("zone_5min").innerHTML = data_time_Array_Minus[5];
    }

    setTimeout("clockTimezone()", 1000);

}