/** Users Service **/
(function(){
    "use strict";
    angular
        .module('app')
        .service('userService', UserService);

        UserService.$inject = ['$http'];
        function UserService($http) {

            this.getUsersService = function() {
                return $http({
                    url : 'users/getUserList?page=0&count=10',
                    method : 'GET'
                }).then(function(response) {
                    return response.data;
                });
            };

            this.getUserProfileService = function() {
                return $http({
                    url : 'users/getProfileUser',
                    method : 'GET'
                }).then(function(response) {
                    return response.data;
                });
            };

            this.saveUserService = function(userObj) {
                if(userObj.id){
                    return $http({
                        url: 'users/saveUser',
                        method: 'POST',
                        data: userObj
                    }).then(function(response) {
                        return response.status;
                    });
                }else{
                    return $http({
                        url: 'users/saveUser',
                        method: 'POST',
                        data: userObj
                    }).then(function(response) {
                        return response.status;
                    });
                }

            };

            this.isUserExist = function() {
                return $http({
                    url : 'users/getCurrentUser',
                    method : 'GET'
                }).then(function(response) {
                    return response.data;
                });
            };
    }

})();
