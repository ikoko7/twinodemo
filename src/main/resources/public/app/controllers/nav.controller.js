/** Nav Controller **/
(function(){
	"use strict";
	angular
		.module('app')
		.controller('NavController', NavController);

        NavController.$inject = ['$scope', '$state', 'userService'];
        function NavController($scope, $state, userService) {
            var vm = this;
            vm.navPages = [];
            vm.title = 'Credit Users';
            vm.init = init;

            init();


            vm.isUrl = function(url) {
                if (url === '#') return false;
                return ('#' + $state.$current.url.source + '/').indexOf(url + '/') === 0;
            };


            function init(callback){
                var role = {};
                userService.isUserExist().then(function (response) {
                    role = response;

                    if(role){
                        vm.navPages = [
                            {
                                name: 'Users',
                                url: '#/users'
                            },
                            {
                                name: 'User Profile',
                                url: '#/userProfile'
                            },{
                                name: 'Logout',
                                url: '/logout'
                            }];
                    }else{
                        vm.navPages = [
                            {
                                name: 'Users',
                                url: '#/users'
                            },
                            {
                                name: 'Register',
                                url: '#/saveUser'
                            },
                            {
                                name: 'Login',
                                url: '#/login'
                            }];
                    }

                    callback && callback(response);
                });
            }

        }

})();
