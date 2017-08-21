searchButton();
homeButton();


function searchButton() {

    var search = document.querySelector(".boton .search");

    search.onclick = function() {

        var input = document.querySelector(".boton input");
        var filtro = input.value;
        if (filtro) {
            location.href = '/games?genre=' + filtro;
        }
    };
}

function homeButton () {

    var home = document.querySelector(".boton .home");

    home.onclick = function() {

        location.href = '/games';
    };
}
