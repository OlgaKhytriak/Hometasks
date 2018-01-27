var d = document,
    itemBox = d.querySelectorAll('.item_box'), // блок кожного товару в <li>
    cartCont = d.getElementById('cart_content'); // блок виводу даних корзини
// Функція  установка обробник подій
function addEvent(elem, type, handler) {
    if (elem.addEventListener) {
        elem.addEventListener(type, handler, false);
    } else {
        elem.attachEvent('on' + type, function() { handler.call(elem); });
    }
    return false;
}
// Отримуємо дані з LocalStorage
function getCartData() {
    return JSON.parse(localStorage.getItem('cart'));
}
// Записуємо дані в LocalStorage
function setCartData(o) {
    localStorage.setItem('cart', JSON.stringify(o));
    return false;
}
// Добавляємо товар в корзину
function addToCart(e) {
    this.disabled = true; // блокуємо кнопку на час операцій з корзиною
    var cartData = getCartData() || {}, // отримуємо дані з корзини або створюємо новий обєкт якщо даних нема
        parentBox = this.parentNode, // батьківський елемент кнопки добавити в корзину 
        itemId = this.getAttribute('data-id'), // ID товару
        itemTitle = parentBox.querySelector('.item_title').innerHTML, // назва товару
        itemPrice = parentBox.querySelector('.style-price-grid').innerHTML; // вартість товару
    if (cartData.hasOwnProperty(itemId)) { // якщо такий товар вже є то +1 до кількості
        cartData[itemId][2] += 1;
    } else { // якщо товару в корзині ще нема, то добавляємо обєкт
        cartData[itemId] = [itemTitle, itemPrice, 1];
    }
    // Обновляємо дані в  в LocalStorage
    if (!setCartData(cartData)) {
        this.disabled = false; // розблоковуємо кнопку після оновлення LS
        cartCont.innerHTML = 'Product is added to cart.';
        setTimeout(function() {
            cartCont.innerHTML = 'Continue shopping...';
        }, 1000);
    }

    return false;
}
// Встановлюємо обробник подій на кожну кнопку "добавити в корзину";

for (var i = 0; i < itemBox.length; i++) {
    addEvent(itemBox[i].querySelector('.add-cart-style-grid'), 'click', addToCart);
}
// Відкриваємо корзину зі списком добавлених товарів
function openCart(e) {

    var cartData = getCartData(), // витягуємо всі дані з корзини
        totalItems = '';
    console.log(JSON.stringify(cartData));
    // якщо в корзині щось є то формуємо дані для виведення
    if (cartData !== null) {
        totalItems = '<table class="shopping_list"><tr><th>Name</th><th>Price</th><th>Number</th></tr>';
        for (var items in cartData) {
            totalItems += '<tr>';
            for (var i = 0; i < cartData[items].length; i++) {
                totalItems += '<td>' + cartData[items][i] + '</td>';
            }
            totalItems += '</tr>';
        }
        totalItems += '<table>';
        cartCont.innerHTML = totalItems;
    } else {
        // Якщо в корзині пусто то сигналізуємо про це
        cartCont.innerHTML = 'Empty cart!';

    }
    return false;
}
/* Відкрити корзину */
addEvent(d.getElementById('checkout'), 'click', openCart);
/* Очистити корзину */
addEvent(d.getElementById('clear_cart'), 'click', function(e) {
    localStorage.removeItem('cart');
    cartCont.innerHTML = 'Cart has been cleaned';

});