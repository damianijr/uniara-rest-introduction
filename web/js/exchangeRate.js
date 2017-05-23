function exchangeRateList() {
    return $.get('http://localhost:8080/exchangerate');
}

function newExchangeRate(exchangeRate) {
    return $.ajax({
        url: 'http://localhost:8080/exchangerate',
        type: 'POST',
        data: JSON.stringify(exchangeRate),
        contentType:"application/json; charset=utf-8",
    });
}

function editExchangeRate(exchangeRate) {
    return $.ajax({
        url: 'http://localhost:8080/exchangerate/' + exchangeRate.symbol,
        type: 'PUT',
        data: JSON.stringify(exchangeRate),
        contentType:"application/json; charset=utf-8",
    });
}

function editExRate(symbol, newRate) {
    return $.ajax({
        url: 'http://localhost:8080/exchangerate/' + symbol,
        type: 'PATCH',
        data: JSON.stringify({ rate: newRate }),
        contentType:"application/json; charset=utf-8",
    });
}


function deleteExchangeRate(symbol) {
    return $.ajax({
        url: 'http://localhost:8080/exchangerate/' + symbol,
        type: 'DELETE'
     });
}

