
const OPERATION_ADD = 'ADD';
const OPERATION_EDIT = 'EDIT';
const OPERATION_EDIT_RATE = 'EDIT_RATE';

function refreshExchangeList() {
    $('#list-table tbody').empty();
    exchangeRateList()
        .done(function(rates) {
            rates.map(function(rate) { addExchangeRateOnTable(rate); });
        })

}

function saveExchangeRate(event) {
    event.preventDefault();
    const operation = $('#operation').val();
    switch(operation) {
        case OPERATION_ADD:
            addExchange();
            break;
        case OPERATION_EDIT:
            editExchange();
            break;
        case OPERATION_EDIT_RATE:
            editRate();
            break;
        default:
            throw new Error('Operation [' + operation + '] not found.');
    }
    return false;
}

function addExchange() {
    let exchangeRate = $('form').serializeArray().reduce(function(a, x) { a[x.name] = x.value; return a; }, {});
    newExchangeRate(exchangeRate)
        .done(function() {
            success('Nova moeda cadastrada com sucesso!');
            refreshExchangeList();
            resetForm();
        })
        .fail(() => error('Erro ao cadastrar nova moeda.'));
}

function editExchange() {
    let exchangeRate = $('form').serializeArray().reduce(function(a, x) { a[x.name] = x.value; return a; }, {});
    editExchangeRate(exchangeRate)
        .done(() => {
            success('Nova moeda editada com sucesso!');
            refreshExchangeList();
            resetForm();
        })
        .fail(() => error('Erro ao editar moeda.'));
}

function editRate() {
    editExRate($('#symbol').val(), $('#rate').val())
        .done(() => {
            success('Cotação atualizada com sucesso!');
            refreshExchangeList();
            resetForm();
        })
        .fail(() => error('Erro ao editar Cotação.'));
}


function deleteExchangeRateOnClick(e) {
    e.preventDefault();
    deleteExchangeRate($(this).data('symbol'))
        .done(function() { refreshExchangeList(); });
    return false;
}

function editExchangeRateOnClick(e) {
    e.preventDefault();
    $('#operation').val(OPERATION_EDIT);
    $('#symbol').prop('readonly', true)
    loadExchangeRate($(this).data('exchangeRate'));
}

function prepareFormToEditRate(e) {
    e.preventDefault();
    $('#operation').val(OPERATION_EDIT_RATE);
    $('#symbol').prop('disabled', true)
    $('#name').prop('disabled', true)
    $('#description').prop('disabled', true)
    loadExchangeRate($(this).data('exchangeRate'));
}

function loadExchangeRate(exchangeRate) {
    $('#symbol').val(exchangeRate.symbol);
    $('#name').val(exchangeRate.name);
    $('#rate').val(exchangeRate.rate);
    $('#description').val(exchangeRate.description);
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
    return $('<div />')
            .append(btnDelete(exchangeRate))
            .append(btnEdit(exchangeRate))
            .append(btnRate(exchangeRate));
}

function btnDelete(exchangeRate) {
    return $('<a />')
                .data('symbol', exchangeRate.symbol)
                .addClass('btn btn-danger btn-xs')
                .html('Excluir')
                .on('click', deleteExchangeRateOnClick);
}

function btnEdit(exchangeRate) {
    return $('<a />')
                .data('exchangeRate', exchangeRate)
                .addClass('btn btn-warning btn-xs')
                .html('Editar')
                .on('click', editExchangeRateOnClick);
}

function btnRate(exchangeRate) {
    return $('<a />')
                .data('exchangeRate', exchangeRate)
                .addClass('btn btn-success btn-xs')
                .html('Cotação')
                .on('click', prepareFormToEditRate);

}


function success(msg) {
    $('#success').html(msg).show().fadeOut(2000);
}

function error(msg) {
    $('#error').show().html(msg).fadeOut(2000);
}

function resetForm() {
    $('form').trigger('reset');
    $('#operation').val(OPERATION_ADD);
    $('form input, form textarea').prop('disabled', false).prop('readonly', false);
}