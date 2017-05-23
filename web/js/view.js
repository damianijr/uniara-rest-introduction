
function refreshExchangeList() {
    $('#list-table tbody').empty();
    exchangeRateList()
        .done(function(rates) {
            rates.map(function(rate) { addExchangeRateOnTable(rate); });
        })

}

function addExchange() {
    let exchangeRate = $('form').serializeArray().reduce(function(a, x) { a[x.name] = x.value; return a; }, {});
    newExchangeRateList(exchangeRate)
        .done(function() {
            success('Nova moeda cadastrada com sucesso!');
            refreshExchangeList();
        })
        .fail(function(jqXHR, textStatus) {
        console.log(textStatus)
            error('Erro ao cadastrar nova moeda.')
        });
}

function deleteExchangeRateOnClick(e) {
    e.preventDefault();
    deleteExchangeRate($(this).data('symbol'))
        .done(function() { refreshExchangeList(); });
    return false;
}

function addExchangeRateOnTable(exchangeRate){
    $('#list-table tbody')
        .append(
            $('<tr />')
                .append($('<td />').html(exchangeRate.symbol))
                .append($('<td />').html(exchangeRate.name))
                .append($('<td />').html('R$ ' + exchangeRate.rate))
                .append($('<td />').html(exchangeRate.description))
                .append($('<td />').html(btnActions(exchangeRate)))
        );
}

function btnActions(exchangeRate) {
    return btnDelete(exchangeRate);
}

function btnDelete(exchangeRate) {
    return $('<a />')
                .data('symbol', exchangeRate.symbol)
                .addClass('btn btn-danger btn-xs')
                .html('Excluir')
                .on('click', deleteExchangeRateOnClick);
}


function success(msg) {
    $('#success').html(msg).show().fadeOut(5000);
}

function error(msg) {
    $('#error').show().html(msg).fadeOut(5000);
}