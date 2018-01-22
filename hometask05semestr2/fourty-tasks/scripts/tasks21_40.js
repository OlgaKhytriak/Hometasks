//----------------------- task 40
//Write a JavaScript program to swap the first and last elements of a given array of integers. 
//The array length should be at least 1.
function solveTask40() {
    function swap(arra) {
        [arra[0], arra[arra.length - 1]] = [arra[arra.length - 1], arra[0]];
        return arra;
    }
    console.log(swap([1, 2, 3, 4]));
    console.log(swap([0, 2, 1]));
    console.log(swap([3]));
} //----------------------- task 39
//Write a JavaScript program to test if an array of integers 
//of length 2 contains 1 or a 3.
function solveTask39() {
    function contins13(nums) {

        if (nums.indexOf(1) != -1 || nums.indexOf(3) != -1) {
            return true
        } else {
            return false
        }
    }

    console.log(contins13([1, 5]));
    console.log(contins13([2, 3]));
    console.log(contins13([7, 5]));
} //----------------------- task 38
//Write a JavaScript program to check if the first 
//and last elements are equal of a given array of integers length 3.
function solveTask38() {
    function first_last_same(nums) {
        var end = nums.length - 1;
        if (nums.length >= 1) {
            return nums[0] == nums[end];
        } else { return false; }
    }

    console.log(first_last_same([10, 20, 30]));
    console.log(first_last_same([10, 20, 30, 10]));
    console.log(first_last_same([20, 20, 20]));
}
//----------------------- task 37
//Write a JavaScript program to extract the first half of a string of even length.
function solveTask37() {
    function first_half(str) {
        if (str.length % 2 == 0) {
            return str.slice(0, str.length / 2);
        }
        return str;
    }
    console.log(first_half("Python"));

}
//----------------------- task 36
//Write a JavaScript program to divide two 
//positive numbers and return a string with properly formatted commas.
function solveTask36() {
    function division_string(n1, n2) {

        n1 = 80;
        n2 = 6;

        var div = Math.round(n1 / n2).toString(),
            result_array = div.split("");

        if (div >= 1000) {
            for (var i = div.length - 3; i > 0; i -= 3) {
                result_array.splice(i, 0, ",");
            }
            result_array;
        }
        console.log(result_array);
    }
} //----------------------- task 35
//Write a JavaScript program to check if the characters a and b are separated 
//by exactly 3 places anywhere (at least once) in a given string.
function solveTask35() {
    function ab_Check(str) {
        return (/a...b/).test(str) || (/b...a/).test(str);
    }

    console.log(ab_Check("Chainsbreak"));
    console.log(ab_Check("pane borrowed"));
    console.log(ab_Check("abCheck"));
}
//----------------------- task 34
//----------------------- task 33
//Write a JavaScript program to check if a number in the range 
//40..10000 presents in two number (in same range).
//For example 40 presents in 400 and 4000.
function solveTask34() {
    function test_digit(x, y) {
        let x_div = parseInt(x / 40),
            x_mod = x % 40,
            y_div = parseInt(y / 40),
            y_mod = y % 40;
        return x_div === y_div || x_mod === y_mod ||
            x_div === y_mod || x_mod === y_div;
    }

    console.log(test_digit(40, 4000));
}

function solveTask33() {

} //----------------------- task 32
//Write a JavaScript program to check from three given integers that if a 
//number is greater than or equal to 20 and less than one of the others.
function solveTask32() {
    function lessby20_others(x, y, z) {
        return (Math.abs(x - y) >= 20) ||
            (Math.abs(x - z) >= 20) ||
            (Math.abs(y - z) >= 20);
    }

    console.log(lessby20_others(23, 45, 10));
} //----------------------- task 31
//Write a JavaScript program to check if two numbers are in range 40..60 or in the range 70..100 inclusive.
function solveTask31() {
    function numbers_ranges(x, y) {
        if ((x >= 40 && x <= 60 && y >= 40 && y <= 60) ||
            (x >= 70 && x <= 100 && y >= 70 && y <= 100)) {
            return true;
        } else {
            return false;
        }
    }

    console.log(numbers_ranges(44, 56));
}
//----------------------- task 30
//Write a JavaScript program to check from two given integers, if one is positive and one is negative.
function solveTask30() {
    function positive_negative(x, y) {
        if ((x < 0 && y > 0) || x > 0 && y < 0) {
            return true;
        } else {
            return false;
        }
    }
    console.log(positive_negative(2, 2));
}
//----------------------- task 29
//Write a JavaScript program to compute the sum of the two given integers. If the two values are same, then returns triple their sum.
function solveTask29() {
    function sumTriple(x, y) {
        if (x == y) {
            return 3 * (x + y);
        } else {
            return (x + y);
        }
    }
    console.log(sumTriple(10, 20));
}
//----------------------- task 28
//Write a JavaScript program to check a given integer is within 20 of 100 or 400.
function solveTask28() {
    function testhundred(x) {
        return ((Math.abs(100 - x) <= 20) ||
            (Math.abs(400 - x) <= 20));
    }

    console.log(testhundred(10));
}
//----------------------- task 27
//Write a JavaScript function to compare dates (i.e. greater than, less than or equal to).
function solveTask27() {
    var compare_dates = function(date1, date2) {
        if (date1 > date2) return ("Date1 > Date2");
        else if (date1 < date2) return ("Date2 > Date1");
        else return ("Date1 = Date2");
    }

    console.log(compare_dates(new Date('11/14/2013 00:00'), new Date('11/14/2013 00:00')));
}
//----------------------- task 26
//Write a JavaScript function to get the month name from a particular date.
function solveTask26() {
    var month_name = function(dt) {
        mlist = ["January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"];
        return mlist[dt.getMonth()];
    };
    console.log(month_name(new Date("10/11/2009")));
}
//----------------------- task 25
//Write a JavaScript function to sort the following array of objects by title value.
function solveTask25() {
    var library = [
        { author: 'Bill Gates', title: 'The Road Ahead', libraryID: 1254 },
        { author: 'Steve Jobs', title: 'Walter Isaacson', libraryID: 4264 },
        { author: 'Suzanne Collins', title: 'Mockingjay: The Final Book of The Hunger Games', libraryID: 3245 }
    ];
    console.log("Basic array=");
    console.log(library);

    function compareToAuthor(x, y) {
        if (x.author < y.author) { return -1; } else
        if (x.author > y.author) { return 1; } else { return 0; }

    }

    function compareToTitle(x, y) {
        if (x.title < y.title) { return -1; } else
        if (x.title > y.title) { return 1; } else { return 0; }

    }

    console.log("Sorted array=");
    console.log(library.sort(compareToAuthor));
    console.log(library.sort(compareToTitle));
}
//----------------------- task 24
//Write a JavaScript program to find the most frequent item of an array
function solveTask24() {
    function maxFrequentElement(arr1) {
        var mf = 1;
        var m = 0;
        var item;
        for (var i = 0; i < arr1.length; i++) {
            for (var j = i; j < arr1.length; j++) {
                if (arr1[i] == arr1[j])
                    m++;
                if (mf < m) {
                    mf = m;
                    item = arr1[i];
                }
            }
            m = 0;
        }

        return item + " ( " + mf + " times ) ";
    }

    var inputArray = [3, 'a', 'a', 'a', 2, 3, 'a', 3, 'a', 2, 4, 9, 3];
    console.log("Basic array=" + inputArray);
    console.log("Max frequent elem=" + maxFrequentElement(inputArray));
}

//----------------------- task 23
//Write a JavaScript program to sort the items of an array
function solveTask23() {
    function sortArray(arr1) {
        var arr1 = arr1;
        var arr2 = [];
        var minElem = arr1[0];
        var position;
        var maxElem = arr1[0];
        for (i = 0; i < arr1.length; i++) {
            if (maxElem < arr1[i]) maxElem = arr1[i];
        }

        for (var i = 0; i < arr1.length; i++) {
            for (var j = 0; j < arr1.length; j++) {
                if (arr1[j] != "x") {
                    if (minElem > arr1[j]) {
                        minElem = arr1[j];
                        position = j;
                    }
                }
            }
            arr2[i] = minElem;
            arr1[position] = "x";
            minElem = maxElem;
        }
        return arr2;
    }
    var inputArray = [3, 8, 7, 6, 5, -4, 3, 2, 1];
    console.log("Basic array=" + inputArray);
    console.log("Sorted array=" + sortArray(inputArray));
}
//----------------------- task 22
//Write a simple JavaScript program to join all elements of 
//the following array into a string.
function solveTask22() {

    function toString(array) {
        return array.join();
    }
    var myColor = ["Red", "Green", "White", "Black"]
    console.log("Basic array=" + myColor);
    console.log("To string array=" + toString(myColor));
}
//----------------------- task 21
// Write a JavaScript function to clone an array.
function solveTask21() {
    arrayClone = function(arra1) {
        return arra1.slice(0);
    };

    var arrayInput = [1, 2, 4, 6];
    console.log("Basic array=" + arrayInput);
    console.log("Cloned array=" + arrayClone(arrayInput));
}