
angular.module('bookkeeping', ['ngStorage']).controller('indexController', function ($scope, $http, $localStorage) {

    // $scope.createOperation = function () {
    //     if ($scope.operation.date != null && $scope.operation.source != null && $scope.operation.cost != null &&
    //             $scope.operation.name != null && $scope.operation.category != null)
                {
            $http.post('http://localhost:8080/operation', $scope.operation)
                    .then(function() {
                        $scope.clearPaymentFields();
                    });
        // }
    }

    $scope.clearPaymentFields = function() {
        $scope.operation.date = null;
        $scope.operation.source = null;
        $scope.operation.cost = null;
        $scope.operation.name = null;
        $scope.operation.category = null;
    }
});