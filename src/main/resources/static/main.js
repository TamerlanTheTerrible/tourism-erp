

$('document').ready(function (){

    $('.table .btnEdit').on('click', function(event){

        event.preventDefault();

        var href = $(this).attr('href');
        $.get(href, function (group, status){
            $('#groupNumberEdit').val(group.groupNumber)
            $('#dateCreatedEdit').val(group.dateCreatedInString)
            $('#idEdit').val(group.id)
            $('#companyEdit').val(group.company)
            $('#countryEdit').val(group.country)
            $('#paxEdit').val(group.pax)
            $('#arrivalEdit').val(group.arrivalInString)
            $('#guidesEdit').val(group.guides)
            $('#commentsEdit').val(group.comments)
        });

       $('#editModal').modal();

    });

})