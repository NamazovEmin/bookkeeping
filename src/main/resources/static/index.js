
angular.module('bookkeeping', ['ngStorage']).controller('indexController', function ($scope, $http, $localStorage) {

    $scope.createOperation = function (operation) {
        if (operation.date != null & operation.source != null & operation.cost != null &
                operation.details != null && operation.category != null)
                {
            $http.post('http://localhost:8080/operation', operation)
                    .then(function() {
                        $scope.clearPaymentFields(operation);
                    });
        }
    }

    $scope.clearPaymentFields = function(operation) {
        operation.date = null;
        operation.source = null;
        operation.cost = null;
        operation.details = null;
        operation.category = null;
    }

    $scope.getOperationByRange = function(range) {
        $http.get('http://localhost:8080/operation/range', range)
                .then(function() {
                });
    }
});