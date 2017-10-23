(function () {
    var UploadApiFactory = function ($q, $http, $injector) {
        var upload = function (api, files) {
            var isArray = angular.isArray(files);
            if ((isArray && files.length === 0) || (!isArray && !files)) {
                // 没有文件
                return;
            }

            if (!isArray) {
                files = [files];
            }

            var deferred = $q.defer();
            var promises = [];
            var result = [];
            var Upload = $injector.get('Upload');
            angular.forEach(files, function (file, i) {
                var promise = Upload.upload({
                    url: api,
                    file: file
                }).success(function (data) {
                    result[i] = data;
                }).error(function () {
                    result[i] = {};
                }).then(function (resp) {
                    // TODO
                }, function (resp) {
                    // TODO show error
                }, function (evt) {
                    // TODO show progress
                });

                promises.push(promise);
            });

            $q.all(promises).then(function () {
                deferred.resolve(isArray ? result : result[0]);
            });
            return deferred.promise;
        };

        angular.extend(this, {
            upload: upload
        });
    };

    UploadApiFactory.$inject = ['$q', '$http', '$injector'];
    angular.module('app.core').service('UploadApi', UploadApiFactory);
})();
