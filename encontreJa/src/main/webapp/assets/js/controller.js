var mainAppLogin = angular.module("mainAppLogin", ['ngRoute', 'ngCookies']);
var mainApp = angular.module("mainApp", ['ngRoute', 'ngCookies']);
mainApp.config(['$routeProvider', function ($routeProvider) {
        $routeProvider.
                when('/register', {
                    templateUrl: 'views/register.html',
                    controller: 'CreateUserController'
                }).
                when('/register_professional', {
                    templateUrl: 'views/register_professional.html',
                    controller: 'CreateUserProController'
                }).
                when('/login', {
                    templateUrl: 'views/login.html',
                    controller: 'loginController'
                }).
                when('/people', {
                    templateUrl: 'views/people.html',
                    controller: 'peopleController'
                }).
                when('/people/:id', {
                    templateUrl: 'views/people_detail.html',
                    controller: 'peopleDetController'
                }).
                when('/contact/:id', {
                    templateUrl: 'views/contact_person.html',
                    controller: 'contactPersonController'
                }).
                when('/logout', {
                    templateUrl: 'views/start.html',
                    controller: 'LogoutController'
                }).
                when('/search', {
                    templateUrl: 'views/search.html',
                    controller: 'searchController'
                }).
                when('/private_contacts', {
                    templateUrl: 'views/private_contacts.html',
                    controller: 'privateContactsController'
                }).otherwise({
            templateUrl: 'views/start.html'
        });
    }]);
mainApp.controller('LogoutController', function ($cookieStore, $window) {
    $cookieStore.remove("user");
    $window.location.href = 'index.html';


});
mainApp.controller('mainAppCtrl', function ($scope, $cookieStore, $rootScope, $http) {
    $scope.isLogged = false;

    $scope.$watch("isLogged", function (newValue) {


        $scope.isLogged = newValue;
    });


    if (!angular.isUndefined($cookieStore.get("user"))) {




        var url = "api/user/" + $cookieStore.get("user")

        $http.get(url).success(function (response) {

            if (response != "") {
                $scope.isLogged = true;
                $scope.username = response.email;
            }
        });
    }





});
mainApp.controller('privateContactsController', function ($scope, $http, $location, $cookieStore) {


    var url = "api/contact/" + $cookieStore.get("user");
   
    $http.get(url).success(function (response) {
        $scope.contacts = response;
    });



});

mainApp.controller('searchController', function ($scope, $http, $location) {


    var url = "api/category";

    $http.get(url).success(function (response) {
        $scope.categories = response;
    });

    $scope.submit = function () {
        $location.path('/people').search({region: $scope.localidade, category: $scope.category.id});
    };

});
mainApp.controller('peopleController', function ($scope, $http, $location) {
    var url = "api/user/type/professional";
    $scope.title = "Encontre o melhor profissional, ao melhor preço de mercado. ";
    $scope.pageTitle = "PROFISSIONAIS DE CONFIANÇA";

    if ($location.search().region && $location.search().category) {

        $http.get("api/category/" + $location.search().category).success(function (response) {



            $scope.title = "Resultados da pesquisa em " + $location.search().region + " de " + response.name;
            $scope.pageTitle = "PESQUISA DE PROFISSIONAIS";
            $http.get("api/user/type/profissional?l=" + $location.search().region + "&c=" + $location.search().category).success(function (response) {
                $scope.users = response;
                if (response == "") {
                    $scope.message = "nao foram encontrados resultados para a sua pesquisa";
                }
            });
        });
    } else
    {
        $http.get(url).success(function (response) {
            $scope.users = response;

        });
    }


});




mainApp.controller('loginController', function ($scope, $http, $cookieStore, $window) {
    $scope.message = "";
    $scope.processForm = function () {
        $http({
            method: 'POST',
            url: 'api/auth/',
            data: $.param($scope.formData), // pass in data as strings
            headers: {'Content-Type': 'application/x-www-form-urlencoded'}  // set the headers so angular passing info as form data (not request payload)
        })
                .error(function () {
                    $scope.message = 'Erro ao efetuar o login.';
                })
                .success(function (data) {
                    $scope.login_data = data;
                    $cookieStore.put("user", data.id);

                    $window.location.href = 'index.html';
                });
    }

});

mainApp.controller('peopleDetController', function ($scope, $http, $routeParams) {

    var url = "api/user/" + $routeParams.id;
    $http.get(url).success(function (response) {
        $scope.user = response;
    });


});
mainApp.controller('contactPersonController', function ($scope, $http) {


});


mainApp.controller('CreateUserController', function ($scope, $http) {

    $scope.btnsubmit = "Registar";
    $scope.titulo = "Criar novo Utilizador"
    $scope.type = "client";
    $scope.userImg = "team-01.png";
    $scope.formData = {};

    $scope.processForm = function () {
        $http({
            method: 'POST',
            url: 'api/user',
            data: $.param($scope.formData), // pass in data as strings
            headers: {'Content-Type': 'application/x-www-form-urlencoded'}  // set the headers so angular passing info as form data (not request payload)
        })
                .error(function () {


                    $scope.message = 'Erro ao efetuar o registo.';
                })
                .success(function () {

                    $scope.message = 'Registo efetuado com sucesso.';
                });

    };

});


mainApp.controller('CreateUserProController', function ($scope, $http) {
    $scope.btnsubmit = "Registar Pro"
    $scope.titulo = "Criar novo Profissional"
    $scope.type = "professional";
    $scope.userImg = "team-01.png";

    var url = "api/category";

    $http.get(url).success(function (response) {
        $scope.categories = response;
    });

    $scope.formData = {};

    $scope.processForm = function () {

        $http({
            method: 'POST',
            url: 'api/user',
            data: $.param($scope.formData), // pass in data as strings
            headers: {'Content-Type': 'application/x-www-form-urlencoded'}  // set the headers so angular passing info as form data (not request payload)
        })
                .error(function () {


                    $scope.message = 'Erro ao efetuar o registo do profissional.';
                })
                .success(function () {

                    $scope.message = 'Registo do profissional efetuado com sucesso.';
                });

    };

});




