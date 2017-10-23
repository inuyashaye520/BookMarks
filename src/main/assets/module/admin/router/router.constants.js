(function () {
    angular.module('app.router').constant('APP_REQUIRES', {
        'datepicker': {
           files: [
               Context + '/assets/lib/My97DatePicker/WdatePicker.js'
           ],
           serie: true
        },
        'ui-select': {
            files: [
                Context + '/webjars/angular-ui-select/0.19.6/dist/select.min.css?version=0.19.1'
                , Context + '/webjars/angular-ui-select/0.19.6/dist/select.min.js?version=0.19.1'
            ]
        },
        'ng-file-upload': {
            files: [Context + '/webjars/ng-file-upload/12.2.13/ng-file-upload-all.min.js']
        },
        'ueditor': {
            files: [
                Context + '/webjars/ueditor-bower/1.4.3/ueditor.all.min.js',
                Context + '/webjars/ng-ueditor/0.3.0/dist/ng-ueditor.min.js'
            ]
        },
        'qrcode': {
            files: [
                Context + '/webjars/github-com-monospaced-bower-qrcode-generator/0.1.0/js/qrcode.js'
                , Context + '/webjars/github-com-monospaced-bower-qrcode-generator/0.1.0/js/qrcode_UTF8.js'
                , Context + '/webjars/github-com-belerweb-angular-qrcode/6.2.2/angular-qrcode.js'
            ],
            serie: true
        }


    });
})();
