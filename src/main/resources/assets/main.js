
searchButton();
homeButton();


function searchButton() {

    var search = document.querySelector(".boton .search");
    var input = document.querySelector(".boton input");


    search.onclick = function() {

        var filtro = input.value;
        location.href = '/games?search=' + filtro;
        document.getElementById("titulo").textContent = "aaaaa";
    }
}

function homeButton () {

    var home = document.querySelector(".boton .home");
    var mainPageTitle = document.querySelector(".pagetitle");

    home.onclick = function() {

        location.href = '/games';
    };
}
