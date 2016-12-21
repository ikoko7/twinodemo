var app = angular.module('app', [
    'ui.router',
    'ngAnimate',
    'ui.bootstrap',
    'ngTable']);

    app.config(['$stateProvider', '$urlRouterProvider', function($stateProvider, $urlRouterProvider){

        var viewsPrefix = 'app/views/';

        // For any unmatched url, send to /
        $urlRouterProvider.otherwise("/");

        $stateProvider
            .state('home', {
                url: "/",
                templateUrl: viewsPrefix + "home.html",
                controller: 'UserController',
                controllerAs: 'vm'
            })
            .state('users',{
                url:'/users',
                templateUrl: viewsPrefix + 'usersList.html',
                controller:'UserController',
                controllerAs: 'vm'
            })
            .state('saveUser',{
                url:'/saveUser',
                templateUrl: viewsPrefix + 'saveUser.html',
                controller: 'UserController',
                controllerAs: 'vm'
            })
            .state('userProfile',{
                url:'/userProfile',
                templateUrl: viewsPrefix + 'userProfile.html',
                controller:'ProfileController',
                controllerAs: 'vm'
            })
    }]);

