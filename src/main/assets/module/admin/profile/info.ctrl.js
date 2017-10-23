(function () {
    var ctrl = function ($scope, $rootScope, $stateParams, AccountApi, $state, $uibModalInstance, Notification) {
        var account = angular.copy($rootScope.User);
        var ui = {
            status: false
        };
        if (account.status === 1) {
            ui.status = true;
        } else if (account.status === 2) {
            ui.status = false;
        }

        var successCallback = function (result) {
            if (result.data) {
                Notification.success({message: '保存成功'});
            } else {
                Notification.error({message: '保存失败'});
            }
            $uibModalInstance.close('fresh');
            location.reload([]);
        };
        var submit = function () {
            if (ui.status) {
                account.status = 1;
            } else if (!ui.status) {
                account.status = 2;
            }
            AccountApi.save({id: account.id}, account, successCallback);
        };
        var cancel = function () {
            $uibModalInstance.dismiss('cancel');
        };
        angular.extend($scope, {
            account: account,
            submit: submit,
            cancel: cancel,
            ui: ui
        });
    };

    ctrl.$inject = ['$scope', '$rootScope', '$stateParams', 'AccountApi', '$state', '$uibModalInstance', 'Notification'];
    angular.module('app.profile').controller('InfoCtrl', ctrl);

})();
