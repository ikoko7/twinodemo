/** Users List Controller **/
(function(){
    "use strict";
    angular
        .module('app')
        .controller('UserController', UserController);

        UserController.$inject = ['$state', 'NgTableParams', 'userService'];
        function UserController($state, NgTableParams, userService) {

            var vm = this;

            vm.usersList = [];
            vm.user = {};
            vm.minAge2 = 21;
            vm.minAge = 21;
            vm.today = new Date();
            vm.minAge = new Date(vm.today.getFullYear() - vm.minAge, vm.today.getMonth(), vm.today.getDate());
            vm.getUsersList = getUsersList;
            vm.saveUser = saveUser;

            getUsersList();

            function getUsersList(){
                userService.getUsersService().then(function (response) {
                    vm.usersList = new NgTableParams({}, { dataset: response.content});
                });
            }

            function saveUser(){
                userService.saveUserService(vm.user).then(function (response) {
                    $state.go('users');
                });
            }
        }

})();