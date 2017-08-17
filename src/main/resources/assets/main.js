
searchButton();

function searchButton() {

    var search = document.querySelector(".botonbuscar button");

    search.onclick = function() {

        var input = document.querySelector(".botonbuscar input");
        var filtro = input.value;
        location.href = '/games?search=' + filtro;
    };
}

function homeButton () {

    var home = document.querySelector(".botonhome button");

    home.onclick = location.href = '/games';
}