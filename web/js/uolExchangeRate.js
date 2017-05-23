window.Uol || (window.Uol = {});

Uol.ExchangeRate = (function() {
    function ExchangeRate(list) {
        this.list = list;
    }

    ExchangeRate.prototype.render = function() {
        this.fetchExchangeRate(this.list);
    };

    ExchangeRate.prototype.fetchExchangeRate = function(list) {
        $.get('http://localhost:8080/exchangerate',
            function(rates) {
                rates.map(function(rate) {
                    list
                        .append(
                            $('<tr />')
                                .append($('<td />').html(rate.symbol))
                                .append($('<td />').html('R$ ' + rate.rate))
                        );
                })
            }
        );
    }

    return ExchangeRate;
})();


$(document).ready(function() {
    var exchange_rate;
    exchange_rate = new Uol.ExchangeRate($("#exchange_rate tbody"));
    return exchange_rate.render();
});
