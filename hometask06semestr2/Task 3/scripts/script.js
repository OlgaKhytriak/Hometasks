//-----------------------
//Зробити першу букву великою
function upper_first_letter(str) {
    front_part = (str.substring(0, 1)).toUpperCase();
    back_part = str.substring(1, str.length);
    return front_part + back_part;
}
//-----------------------
//Знайти елементи з описом продукта та виправити, щоб текст починався з великої букви.
function task1() {
    var ul_devices = document.getElementsByClassName("device");
    for (var i = 0; i < ul_devices.length; i++) {
        var ul_inner = ul_devices[i].firstElementChild.lastElementChild;
        var text = ul_inner.firstElementChild.innerHTML;
        ul_inner.firstElementChild.innerHTML = upper_first_letter(text);
    }

    var ul_all = document.body.children;
    var ul_last = ul_all[ul_all.length - 2];
    var ul_inner = ul_last.firstElementChild.lastElementChild;
    var text = ul_inner.firstElementChild.innerHTML;
    ul_inner.firstElementChild.innerHTML = upper_first_letter(text);
}

//---------------
//Виділити ціну червоним кольором (додати класс red до елемента)
function task2() {
    var price_spans = document.getElementsByTagName("span");
    for (var i = 1; i < price_spans.length; i++) {
        price_spans[i].classList.add('red');
    }
}

//---------------
//Додати новий блок з елементами про iPhone 5
// назва - iPhone 5
// опис - Our Hero
// ціна - 300$

function task3() {
    var ul_device = document.getElementsByClassName("device")[0];
    var new_device = ul_device.cloneNode(true);

    var ul_inner = new_device.firstElementChild.lastElementChild;
    new_device.getElementsByTagName("h4")[0].innerHTML = "iPhone 5";
    new_device.getElementsByTagName("span")[0].innerHTML = "300$";
    ul_inner.firstElementChild.innerHTML = "Our Hero";

    var ul_all = document.body.children;
    var ul_last = ul_all[ul_all.length - 2];
    document.body.insertBefore(new_device, ul_last);
}

//---------------
//Перевірити чи всі блоки мають клас device, якщо немає то додати його.
function task4() {
    var ul_all = document.getElementsByTagName("ul");

    for (var i = 0; i < ul_all.length; i++) {
        var elem = ul_all[i];
        if (document.body.contains(elem))
            if (!elem.classList.contains('device')) {
                elem.classList.add('device');
            }
    }
}
//-----------------------
//Замінити ВСІ слова iPhone на Android
function task5() {
    var all_elements = document.getElementsByTagName('*');
    for (var i = 0; i < all_elements.length; i++) {
        var text = all_elements[i].innerHTML;
        var newText = text.replace("iPhone", "Android");
        all_elements[i].innerHTML = newText;
    }
}

//-----------------------
task1();
task2();
task3();
task4();
task5();
//----------------------- 
//----------------------- 
//----------------------- 
//----------------------- 
//----------------------- 
//----------------------- 
//----------------------- 
//----------------------- 
//-----------------------