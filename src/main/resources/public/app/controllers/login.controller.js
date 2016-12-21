/** Users List Controller **/
(function(){
    "use strict";
    angular
        .module('app')
        .controller('LoginController', LoginController);

    LoginController.$inject = ['$state', 'NgTableParams', 'userService'];
        function LoginController($state, NgTableParams, userService) {
            var vm = this;
            vm.user = {};
            vm.saveUser = saveUser;
            vm.getUserProfile = getUserProfile;

            getUserProfile($scope.user.id);

            function getUserProfile(id){
                userService.getUserProfileService(id).then(function (response) {
                    vm.user = response;
                });
            }

        }

})();