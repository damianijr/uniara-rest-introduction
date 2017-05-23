function exchangeRateList() {
    return $.get('http://localhost:8080/exchangerate');
}

function newExchangeRateList(exchangeRate) {
    return $.ajax({
        url: 'http://localhost:8080/exchangerate',
        type: 'POST',
        data: JSON.stringify(exchangeRate),
        contentType:"application/json; charset=utf-8",
    });
}

function deleteExchangeRate(symbol) {
    return $.ajax({
        url: 'http://localhost:8080/exchangerate/' + symbol,
        type: 'DELETE'
     });
}