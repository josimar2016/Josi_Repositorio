var mainAppLogin = angular.module("mainAppLogin", ['ngRoute', 'ngCookies']);
var mainApp = angular.module("mainApp", ['ngRoute', 'ngCookies']);
mainApp.config(['$routeProvider', function ($routeProvider) {
        $routeProvider.
                when('/register', {
                    templateUrl: 'views/register.html',
                    controller: 'registerController'
                }).
                when('/register_professional', {
                    templateUrl: 'views/register_professional.html',
                    controller: 'registerProController'
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
                when('/search', {
                    templateUrl: 'views/search.html',
                    controller: 'searchController'
                }).otherwise({
            templateUrl: 'views/start.html'
        });
    }]);

mainApp.controller('searchController', function ($scope, $http) {


//    var url;
//    if ($scope.isAdmin)
//        url = "rest/sensors";
//    else
//        url = "rest/agricultor/" + $scope.userId + "/sensors";
//
//    $http.get(url).success(function (response) {
//        $scope.sensors = response;
//
//        setThisLocalizacao(response[0]);
//        initGlobalMap(response);
//
//
//    });
//
//    $scope.setLocalizacao = function (sensor) {
//        setThisLocalizacao(sensor);
//    }
//
//    $scope.titulo = "Listagem de sensores em atividade";


});
mainApp.controller('peopleController', function ($scope, $http) {


});
mainApp.controller('registerProController', function ($scope, $http) {


});

mainApp.controller('registerController', function ($scope, $http) {


});

mainApp.controller('peopleDetController', function ($scope, $http) {


});
mainApp.controller('contactPersonController', function ($scope, $http) {


});



                