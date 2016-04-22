

function addFamilyMember(){
    var $form = $('form')

    var $newForm = $('<div>').attr({
        class: 'form-group'
    })
    $("<input type='text' value='' />")
        .attr("id", "myfieldid")
        .attr("name", "myfieldid")
        .appendTo($newForm);

    $newForm.appendTo($form)
}

$('#addFamilyButton').on('click', function(event){
    event.preventDefault()
    addFamilyMember()
    }
);


