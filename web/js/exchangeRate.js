function exchangeRateList() {
    $.get('http://localhost:8080/exchangerate',
            function(rates) {
                rates.map(function(rate) {
                    addExchangeRateOnList(rate);
                })
            }
    );
}