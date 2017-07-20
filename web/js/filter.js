/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


function createElement(ut){
    var link = $("<a>")
            .attr("href", "bacheca.html?user=" + user.user)
            .html(user.nome + " " + user.cognome);
    return $("<p>").append(link);
}

function stateSuccess(data){
    var userListPage = $("#persone");

    $(userListPage).empty();

    if (jQuery.isEmptyObject(data))
    {
        $(userListPage).append(controlloDatiFallito());
    } else
    {
        for (var instance in data) {
            $(userListPage).append(createElement(data[instance]));
        }
    }
}
function stateFailure(data, state){
    console.log(state);
}

$(document).ready(function(){
    $("#filter").click(function(){
        
        var wantedUser = $("#ricerca")[0].value;
        
        $.ajax({
            url: "Filter",
            data:{
                cmd:"search",
                nomeUtente: wantedUser
            },
            dataType:"json",
            success: function(data, state){
                stateSuccess(data)
            },
            error: function(data, state){
                stateFailure(data, state)
            }
        });
    })
});
