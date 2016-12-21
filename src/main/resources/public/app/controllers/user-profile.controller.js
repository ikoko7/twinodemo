/** User Profile Controller **/
(function(){
    "use strict";
    angular
        .module('app')
        .controller('UserProfileController', UserProfileController);

        UserProfileController.$inject = ['$state', 'userService'];
        function UserProfileController($state, userService) {

            var vm = this;
            vm.user = {};
            vm.saveUser = saveUser;
            vm.getUserProfile = getUserProfile;

            getUserProfile();

            function getUserProfile(){
                userService.getUserProfileService().then(function (response) {
                    vm.user = response;
                });
            }

            function saveUser(){
                userService.saveUser($scope.user).then(function (response) {
                    $state.go('profile');
                });
            }
        }

})();