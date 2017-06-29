
(function () {
    'use strict';
    angular
        .module('app')
        .controller('DeviceCtrl', DeviceCtrl);

    DeviceCtrl.$inject = ['$http'];

    function DeviceCtrl($http) {
        var bc = this;

        bc.setValue  = setValue;

        function setValue(device){

            console.log("device: "+device)
            var url = "api/books/set/";
            $http.post(url,device).then(function(response){

                    alert( (response.data).toString());
                });

        }





    }
})();
