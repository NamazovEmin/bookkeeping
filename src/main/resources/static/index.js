
angular.module('bookkeeping', ['ngStorage']).controller('indexController', function ($scope, $http, $localStorage) {

    $scope.createPayment = function () {
        if ($scope.payment.date != null & $scope.payment.type != null & $scope.payment.cost != null &
                $scope.payment.name != null && $scope.payment.category != null) {
            $http.post('http://localhost:8080/operation', $scope.payment)
                    .then(function() {
                        $scope.clearPaymentFields();
                    });
        }
    }
    $scope.clearPaymentFields = function() {
        this.payment.date = null;
        this.payment.type = null;
        this.payment.cost = null;
        this.payment.name = null;
        this.payment.category = null;
    }
});