(function () {
    var ApiFactory = function ($resource) {
        return $resource(Context + '/logout', {}, {});
    };
    ApiFactory.$inject = ['$resource'];
    angular.module('app.profile').service('LogoutApi', ApiFactory);
})();

