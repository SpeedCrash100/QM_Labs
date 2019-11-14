var app = angular.module('calc', []);

app.controller("calcController", function($scope, $http){
    $scope.calcBtnDisabled = true;
    $scope.cancelBtnDisabled = true;

    $scope.inputtext = "";
    $scope.outputtext = "";

    $scope.onInputChanged = function() {
        if($scope.inputtext.length == 0)
        {
            $scope.calcBtnDisabled = true;
        }
        else
        {
            $scope.calcBtnDisabled = false;
        }
    };

    var onCancelUpdateOk = function(respond)
    {
        var size = respond.data["size"];
        if(size > 0)
        {
            $scope.cancelBtnDisabled = false;
        }
        else 
        {
            $scope.cancelBtnDisabled = true;
        }
    };

    var onCancelUpdateFail = function(respond)
    {
        console.log("smth went wrong:");
        console.log(respond);
    };

    var updateCancelBtn = function()
    {
        var respond = $http(
            {
                url: "/rest/stack",
                method: "GET"
            }
        );

        respond.then(onCancelUpdateOk, onCancelUpdateFail);
    };

    updateCancelBtn();

    var onCalcOk = function(respond)
    {
        var data = respond.data;
        $scope.outputtext = data["result"];
        $scope.inputtext = "";
        updateCancelBtn();
    };
    var onCalcFail = function(respond)
    {
        console.log("smth went wrong:");
        console.log(respond);
    };

    $scope.onCalcClicked = function() {
        var dataToRest = { expr: $scope.inputtext };
        var respond = $http(
            {
                url: "/rest/calc",
                method: "POST",
                params: dataToRest
            }
        );

        respond.then(onCalcOk, onCalcFail);
    };

    var onCancelOk = function(respond)
    {
        var data = respond.data;
        $scope.outputtext = data["result"];
        $scope.inputtext = data["argument"];
        updateCancelBtn();
        $scope.calcBtnDisabled = false;
    };

    var onCancelFail = function(respond)
    {
        console.log("smth went wrong:");
        console.log(respond);
    };

    $scope.onCancelClicked = function() {
        var respond = $http(
            {
                url: "/rest/cancel",
                method: "POST"
            }
        );

        respond.then(onCancelOk, onCancelFail);
    };
});