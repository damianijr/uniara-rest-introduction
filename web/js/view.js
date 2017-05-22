
function addExchangeRateOnList(exchangeRate){

    $('#list-table tbody')
        .append(
            $('<tr />')
                .append($('<td />').html(exchangeRate.symbol))
                .append($('<td />').html(exchangeRate.name))
                .append($('<td />').html('R$ ' + exchangeRate.rate))
                .append($('<td />').html(exchangeRate.description))
                .append($('<td />').html("-"))
        );
}