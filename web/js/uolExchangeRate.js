window.Uol || (window.Uol = {});

Uol.ExchangeRate = (function() {
    function ExchangeRate(list, currency) {
        this.list = list;
        this.currency = currency;
    }

    ExchangeRate.prototype.render = function() {
        this.fetchExchangeRate(this.list, this.currency);
    };

    ExchangeRate.prototype.fetchExchangeRate = function(list, currency) {
        $.get('http://localhost:8080/exchangerate/' + currency,
            function(rate) {
                list
                    .append(
                        $('<h1 />').html('Cotação ' + rate.name))
                     .append(
                        $('<tr />')
                            .append($('<td />').html(rate.symbol))
                            .append($('<td />').html('R$ ' + rate.rate))
                    );
            }
        );
    }

    return ExchangeRate;
})();


$(document).ready(function() {
    var exchange_rate;
    var currency = $('[data-currency]:first').data('currency');
    exchange_rate = new Uol.ExchangeRate($("#exchange_rate tbody"), currency);
    return exchange_rate.render();
});
